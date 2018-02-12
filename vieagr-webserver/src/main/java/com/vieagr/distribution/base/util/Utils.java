package com.vieagr.distribution.base.util;

import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.yaml.snakeyaml.introspector.PropertyUtils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysVehicles;
import com.vieagr.distribution.param.IndexParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.response.SerOrderResponse;

/**
 *	统一工具类
 * @author master
 *
 */
public class Utils {
	
	/**
	 * 默认读取properties文件
	 */
	private static Properties propsDefault = new Properties();
	
	static {
		try {
			propsDefault.load(PropertyUtils.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取config.properties
	 * @param key
	 * @return
	 */
	public static String get(String key){
		return propsDefault.getProperty(key);
	}
	
	/**
	 * 利用spring工具类将两个bean对象对应转换,注意调用强制转换
	 * 
	 * @param <BOUser>
	 * @param source
	 *            源javabean对象
	 * @param target
	 *            目标javabean对象
	 * @return
	 */
	public static <T> T exchangeObject(Object source, Class<T> target) {
		if (StringUtils.isEmpty(source)) {
			return null;
		}
		T t = null;
		try {
			t = target.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		BeanUtils.copyProperties(source, t);
		return t;
	}
	
	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		return df.format(new Date());
	}
	
	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getNowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		return df.format(new Date());
	}
	
	/**
	 * 获取当前日期
	 * @return
	 */
	public static String getNowDateCustomFormat(String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);// 设置日期格式
		return df.format(new Date());
	}
	
	/**
	 * 根据某一天日期返回对应的月份的所有日期数
	 * @param date
	 * @return
	 */
	public static List<Date> getAllTheDateOftheMonth(Date date) {
		List<Date> list = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);
		int month = cal.get(Calendar.MONTH);
		while(cal.get(Calendar.MONTH) == month){
			list.add(cal.getTime());
			cal.add(Calendar.DATE, 1);
		}
		return list;
	}	
	
	/**
	 * 根据某一天日期返回对应的月份的所有日期字符串
	 * @param date
	 * @return
	 */
	public static List<String> getAllTheDateOftheMonthStr(Date paramDate, String format) {
		List<Date> list = new ArrayList<Date>();
		List<String> resultList = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(paramDate);
		cal.set(Calendar.DATE, 1);
		int month = cal.get(Calendar.MONTH);
		while(cal.get(Calendar.MONTH) == month){
			list.add(cal.getTime());
			cal.add(Calendar.DATE, 1);
		}
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		for (Date date : list) {
			resultList.add(simpleDateFormat.format(date));
		}
		return resultList;
	}	
	
	/**
	 * 生成订单号
	 * 
	 * @param serviceType
	 *            根据服务类型生产订单号
	 * @return
	 */
	public static String getOrderNo(Integer orderType) {
		String orderNo;
		long now = System.currentTimeMillis();
		String r;
		while (true) {
			r = (int) (Math.random() * (1000)) + "";
			if(r.length() == 3) break;
		}

		String t = now + "";
		t = t.substring(t.length() - 8, t.length());
		orderNo = orderType.toString() + t + r;
		if (orderNo.length() != 12) {
			orderNo = getOrderNo(orderType);
		}
		return orderNo;
	}
	
	/**
	 * 将json字符串转化为对应的Object对象
	 * @param jsonStr
	 * @param clazz
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static <T> T jsonStrToObject(String jsonStr, Class<T> clazz) 
			throws JsonParseException, JsonMappingException, IOException{
		return new ObjectMapper().readValue(jsonStr, clazz);
	}
	
	/**
	 * 将对象转化为json字符串
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String objectToJsonStr(Object object) 
			throws JsonProcessingException{
		return new ObjectMapper().writeValueAsString(object);
	}
	
	/**
	 * 将JavaBean对象转换为XML文件
	 * 
	 * @param t		需要转换的JavaBean对象
	 * @param file	转换后保存XML的文件
	 * @throws JAXBException
	 * @throws IOException 
	 */
	public static <T> void bean2XmlFile(T t, File file) throws JAXBException, IOException {
		Assert.notNull(t, "JavaBean对象为null");
		Assert.notNull(file, "XML文件为null");
		
		JAXBContext context = JAXBContext.newInstance(t.getClass());
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.marshal(t, file);
	}
	
	/**
	 * 将JavaBean对象转换为XML文件
	 * 
	 * @param t			需要转换的JavaBean对象
	 * @param filePath	转换后保存XML的文件路径
	 * @throws JAXBException
	 * @throws IOException 
	 */
	public static <T> void bean2XmlFile(T t, String filePath) throws JAXBException, IOException {
		Assert.notNull(filePath, "文件路径为null");
		
		bean2XmlFile(t, new File(filePath));
	}
	
	/**
	 * 将JavaBean对象转换为XML字符串
	 * 
	 * @param t		需要转换的JavaBean对象
	 * @return		返回XML格式的字符串
	 */
	public static <T> String bean2XmlString(T t) {
		Assert.notNull(t, "JavaBean对象为null");
		
		StringWriter writer = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(t.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(t, writer);
			
			return writer.toString().replace(" standalone=\"yes\"", "");
		} catch (JAXBException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 将XML转换为JavaBean对象
	 * 
	 * @param filePath	需要转换为JavaBean对象的XML文件路径
	 * @param clazz		JavaBean对象的字节码
	 * @return	clazz对应的JavaBean实例
	 */
	public static <T> T xml2Bean(String filePath, Class<T> clazz) {
		return (T) xml2Bean(clazz, new File(filePath));
	}
	
	/**
	 * 将XML转换为JavaBean对象
	 * 
	 * @param clazz		JavaBean对象的字节码
	 * @param file		需要转换为JavaBean对象的XML文件
	 * @return	clazz对应的JavaBean实例
	 */
	public static <T> T xml2Bean(Class<T> clazz, File file) {
		try {
			return (T) xml2Bean(clazz, new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将XML转换为JavaBean对象
	 * @param clazz		JavaBean对象的字节码
	 * @param xmlStr	需要转换为JavaBean对象的XML格式的字符串
	 * @return	clazz对应的JavaBean实例
	 */
	public static <T> T xml2Bean(Class<T> clazz, String xmlStr) {
		return (T) xml2Bean(clazz, new StringReader(xmlStr));
	}
	
	/**
	 * 将XML转换为JavaBean对象
	 * 
	 * @param clazz		JavaBean对象的字节码
	 * @param reader	需要转换为JavaBean对象的XML字符流
	 * @return	clazz对应的JavaBean实例
	 */
	@SuppressWarnings("unchecked")
	public static <T> T xml2Bean(Class<T> clazz, Reader reader) {
		Assert.notNull(clazz, "JavaBean对象的字节码为null");
		Assert.notNull(reader, "数据源为null");
		
		try {
			JAXBContext context = JAXBContext.newInstance(clazz);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (T) unmarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 创建缩略图（按高度和宽度缩放）。图像本身就比较小时，不创建缩略图
	 * 
	 * @param srcFile
	 *            源图像文件地址
	 * @param tgtFile
	 *            缩放后的图像地址
	 * @param fileType
	 *            文件类型
	 * @param height
	 *            缩放后的高度
	 * @param width
	 *            缩放后的宽度
	 * @return true:转换成功 false:转换失败
	 */
	public final static InputStream createThumbnail(InputStream in, String tgtFile, String fileType, int height, int width) {
		try {
			double ratio = 0.0;
			BufferedImage bi = ImageIO.read(in);
			Image itemp = bi.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			if ((bi.getHeight() > height) || (bi.getWidth() > width)) {
				if (bi.getHeight() < bi.getWidth()) {
					ratio = (new Integer(height)).doubleValue() / bi.getHeight();
				} else {
					ratio = (new Integer(width)).doubleValue() / bi.getWidth();
				}
				AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);
				itemp = op.filter(bi, null);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				ImageIO.write((BufferedImage) itemp, fileType, out);
				InputStream sbs =new ByteArrayInputStream(out.toByteArray());
				return sbs;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 从session中获取当前登录用户信息
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getLoginUserInfo(HttpServletRequest request, Class<T> clazz){
		T t = (T) request.getSession().getAttribute(Constant.SESSION_USER_KEY);
		if(t!= null && t.getClass().getName().equals(clazz.getName())){
			return t;
		}else{
			return null;
		}
	}
	
	/**
	 * 根据传入的内容生成excel的输入流
	 * 用于导出excel操作
	 * @param excelType
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static InputStream createExcelStream(String excelType, IndexParam indexParam) {
		/**
		 * 创建工作簿和要写入的输出流对象
		 */
		HSSFWorkbook workBook= new HSSFWorkbook();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		/**
		 * 创建表格sheet，并设置每个单元格默认宽度
		 */
		HSSFSheet sheet = workBook.createSheet(excelType.equals(Constant.EXCEL_TYPE_SORTING_ORDER) 
				? Constant.EXCEL_SHEET_NAME_SORTING  : Constant.EXCEL_SHEET_NAME_SUMMARY);
		/**
		 * 设置表头单元格的风格
		 */
		HSSFCellStyle cellStyleHead = workBook.createCellStyle();
		/**
		 * 自动换行
		 */
		cellStyleHead.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		/**
		 * 水平和竖直居中
		 */
		cellStyleHead.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyleHead.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 设置表头单元格背景
		 */
		cellStyleHead.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyleHead.setFillForegroundColor(new HSSFColor.BLUE_GREY().getIndex());
		/**
		 * 表头字体风格设置
		 */
		HSSFFont fontHead = workBook.createFont();
		fontHead.setFontHeightInPoints(Constant.EXCEL_SHEET_HEAD_FONT_SIZE);
		/**
		 * 加粗
		 */
		fontHead.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		fontHead.setColor(HSSFColor.WHITE.index);
		fontHead.setFontName(Constant.EXCEL_SHEET_HEAD_FONT_TYPE);
		cellStyleHead.setFont(fontHead);
		/**
		 * 设置单元格上下左右的边线
		 */
		cellStyleHead.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyleHead.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyleHead.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyleHead.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		/**
		 * sheet内容风格设置
		 */
		HSSFCellStyle cellStyle = workBook.createCellStyle();
		cellStyle.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 内容字体风格设置
		 */
		HSSFFont font = workBook.createFont();
		font.setFontHeightInPoints(Constant.EXCEL_SHEET_BODY_FONT_SIZE);
		font.setFontName(Constant.EXCEL_SHEET_BODY_FONT_TYPE);
		cellStyle.setFont(font);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		/**
		 * 普通订单填充信息
		 */
		List<String> ordinaryOrderCustomerStoreNames = indexParam.getOrdinaryOrderCustomerStoreNames();
		Map<String, Object> ordinaryOrderProductInfoMaps = indexParam.getOrdinaryOrderProductInfoMaps();
		List<String> ordinaryProductNames = ordinaryOrderProductInfoMaps.get(Constant.DOWNLOAD_EXCEL_PRODUCT_INFOS) != null ? 
				(List<String>) ordinaryOrderProductInfoMaps.get(Constant.DOWNLOAD_EXCEL_PRODUCT_INFOS) : new ArrayList<String>();
		/**
		 * 员工餐订单填充信息
		 */
		Map<String, Object> staffOrderProductInfoMaps = indexParam.getStaffOrderProductInfoMaps();
		List<String> staffProductNames = staffOrderProductInfoMaps.get(Constant.DOWNLOAD_EXCEL_PRODUCT_INFOS) != null ? 
				(List<String>)staffOrderProductInfoMaps.get(Constant.DOWNLOAD_EXCEL_PRODUCT_INFOS) : new ArrayList<String>();
		List<String> staffOrderCustomerStoreNames = indexParam.getStaffOrderCustomerStoreNames();
		/**
		 *	表数据填充
		 *	根据传入的excel文件类型不同
		 */
		if(excelType.equals(Constant.EXCEL_TYPE_SORTING_ORDER)){
			/**
			 * 分拣单
			 */
			sheet.setDefaultColumnWidth(Constant.EXCEL_SHEET_DEFAULT_COLUMN_WIDTH);
			/**
			 * 表头及商家名称填充
			 */
			HSSFRow rowHead = sheet.createRow(0);
			HSSFCell cellHeadOne = rowHead.createCell(0); 
			cellHeadOne.setCellValue(Constant.DOWNLOAD_EXCEL_ORDER_SEQUENCE);
			cellHeadOne.setCellStyle(cellStyleHead);
			HSSFCell cellHeadTwo = rowHead.createCell(1);
			cellHeadTwo.setCellValue(Constant.DOWNLOAD_EXCEL_ORDER_PRODUCT_NAME);
			cellHeadTwo.setCellStyle(cellStyleHead);
			HSSFCell cellHeadThree = rowHead.createCell(2);
			cellHeadThree.setCellValue(Constant.DOWNLOAD_EXCEL_SORTING_ORDER_UNIT);
			cellHeadThree.setCellStyle(cellStyleHead);
			/**
			 * 合并第二行前三列区分订单类型
			 */
			sheet.addMergedRegion(new CellRangeAddress(1,1,0,4));
			/**
			 * 第二行
			 */
			HSSFRow rowSecond = sheet.createRow(1);
			HSSFCell secondRowOneCell = rowSecond.createCell(0);
			rowSecond.createCell(1).setCellStyle(cellStyleHead);
			rowSecond.createCell(2).setCellStyle(cellStyleHead);
			secondRowOneCell.setCellValue(Constant.DOWNLOAD_EXCEL_ORDINARY_ORDER);
			secondRowOneCell.setCellStyle(cellStyleHead);
			
			for (int i = 0; i < indexParam.getOrdinaryOrderCustomerStoreNames().size(); i++) {
				HSSFCell tempCell = rowHead.createCell(i + 3);
				tempCell.setCellValue(ordinaryOrderCustomerStoreNames.get(i));
				tempCell.setCellStyle(cellStyleHead);
			}
			/**
			 * 普通订单表内容
			 * 以行为一个Map填充
			 */
			if(ordinaryProductNames.size() > 0){
				for (int i = 0; i < ordinaryProductNames.size(); i++) {
					HSSFRow tempRow = sheet.createRow(i + 2);
					Map<String, String> tempMap = (Map<String, String>) ordinaryOrderProductInfoMaps.get(ordinaryProductNames.get(i));
					HSSFCell cellOne = tempRow.createCell(0);
					cellOne.setCellValue(i + 1 +"");
					cellOne.setCellStyle(cellStyle);
					for (int j = 2; j < ordinaryOrderCustomerStoreNames.size() + 4; j++) {
						HSSFCell tempCell = tempRow.createCell(j - 1);
						tempCell.setCellValue(tempMap.get(j + ""));
						tempCell.setCellStyle(cellStyle);
					}
				}
			}
			if(staffProductNames.size() > 0){
				HSSFRow staffRowHead = sheet.createRow(ordinaryProductNames.size() + 2);
				/**
				 * 合并员工餐订单第一行标题
				 */
				sheet.addMergedRegion(new CellRangeAddress(ordinaryProductNames.size() + 2,ordinaryProductNames.size() + 2, 0, 4));
				/**
				 * 第二行
				 */
				HSSFCell staffRowHeadCell = staffRowHead.createCell(0);
				staffRowHead.createCell(1).setCellStyle(cellStyleHead);
				staffRowHead.createCell(2).setCellStyle(cellStyleHead);
				staffRowHeadCell.setCellValue(Constant.DOWNLOAD_EXCEL_STAFF_ORDER);
				staffRowHeadCell.setCellStyle(cellStyleHead);
				for (int i = 0; i < staffProductNames.size(); i++) {
					HSSFRow tempRow = sheet.createRow(i + ordinaryProductNames.size() + 3);
					Map<String, String> tempMap = (Map<String, String>) staffOrderProductInfoMaps.get(staffProductNames.get(i));
					HSSFCell cellOne = tempRow.createCell(0);
					cellOne.setCellValue(i + 1 +"");
					cellOne.setCellStyle(cellStyle);
					for (int j = 2; j < staffOrderCustomerStoreNames.size() + 4; j++) {
						HSSFCell tempCell = tempRow.createCell(j - 1);
						tempCell.setCellValue(tempMap.get(j + ""));
						tempCell.setCellStyle(cellStyle);
					}
				}
			}
			/**
			 * 汇总单
			 */
		}if(excelType.equals(Constant.EXCEL_TYPE_SUMMARY_ORDER)){
			/**
			 * 表头填充
			 */
			HSSFRow rowHead = sheet.createRow(0);
			rowHead.setHeight((short) 500);
			HSSFCell cellHeadOne = rowHead.createCell(0);
			cellHeadOne.setCellValue(Constant.DOWNLOAD_EXCEL_ORDER_SEQUENCE);
			cellHeadOne.setCellStyle(cellStyleHead);
			HSSFCell cellHeadTwo = rowHead.createCell(1);
			cellHeadTwo.setCellValue(Constant.DOWNLOAD_EXCEL_ORDER_PRODUCT_NAME);
			cellHeadTwo.setCellStyle(cellStyleHead);
			HSSFCell cellHeadThree = rowHead.createCell(2);
			cellHeadThree.setCellValue(Constant.DOWNLOAD_EXCEL_SUMMARY_ORDER_REMARK);
			cellHeadThree.setCellStyle(cellStyleHead);
			HSSFCell cellHeadFour = rowHead.createCell(3);
			cellHeadFour.setCellValue(Constant.DOWNLOAD_EXCEL_SUMMARY_ORDER_TOTAL);
			cellHeadFour.setCellStyle(cellStyleHead);
			/**
			 * 合并第二行前三列区分订单类型
			 */
			sheet.addMergedRegion(new CellRangeAddress(1,1,0,3));
			/**
			 * 第二行
			 */
			HSSFRow rowSecond = sheet.createRow(1);
			HSSFCell secondRowOneCell = rowSecond.createCell(0);
			rowSecond.createCell(1).setCellStyle(cellStyleHead);
			rowSecond.createCell(2).setCellStyle(cellStyleHead);
			secondRowOneCell.setCellValue(Constant.DOWNLOAD_EXCEL_ORDINARY_ORDER);
			secondRowOneCell.setCellStyle(cellStyleHead);
			/**
			 * 普通订单汇总信息
			 */
			if(ordinaryProductNames.size() > 0){
				for (int i = 0; i < ordinaryProductNames.size(); i++) {
					HSSFRow tempRow = sheet.createRow(i + 2);
					String productInfo = ordinaryProductNames.get(i);
					Map<String, String> tempMap = (Map<String, String>) ordinaryOrderProductInfoMaps.get(productInfo);
					HSSFCell cellOne = tempRow.createCell(0);
					cellOne.setCellValue(i + 1 +"");
					cellOne.setCellStyle(cellStyle);
					HSSFCell cellTwo = tempRow.createCell(1);
					cellTwo.setCellValue(tempMap.get("2"));
					cellTwo.setCellStyle(cellStyle);
					StringBuilder sb = new StringBuilder();
					BigDecimal productCount = new BigDecimal("0");
					String productUnitName = tempMap.get("3");
					for (int j = 4; j < ordinaryOrderCustomerStoreNames.size() + 4; j++) {
						if(tempMap.get(j + "") != null){
							productCount = productCount.add(new BigDecimal(tempMap.get(j + "")));
							String remark = tempMap.get("@" + j) ;
							if(sb.toString().length() == 0){
								if(remark != null){
									sb.append(tempMap.get(j + "") + productUnitName + "（"+ remark +"）");
								}else{
									sb.append(tempMap.get(j + "") + productUnitName);
								}
							}else{
								if(remark != null){
									sb .append(", ").append(tempMap.get(j + "") + productUnitName + "（"+ remark +"）");
								}else{
									sb .append(", ").append(tempMap.get(j + "") + productUnitName);
								}
							}
						}
					}
					HSSFCell cellThree = tempRow.createCell(2);
					cellThree.setCellValue(sb.toString());
					cellThree.setCellStyle(cellStyle);
					HSSFCell cellFour = tempRow.createCell(3);
					cellFour.setCellValue(productCount.toString() + productUnitName);
					cellFour.setCellStyle(cellStyle);
				}
			}
			/**
			 * 合并员工餐订单信息第一行前三列区分订单类型
			 */
			sheet.addMergedRegion(new CellRangeAddress(ordinaryProductNames.size() + 2,ordinaryProductNames.size() + 2, 0, 3));
			/**
			 * 第二行
			 */
			HSSFRow staffRowHead = sheet.createRow(ordinaryProductNames.size() + 2);
			HSSFCell staffRowCell = staffRowHead.createCell(0);
			staffRowHead.createCell(1).setCellStyle(cellStyleHead);
			staffRowHead.createCell(2).setCellStyle(cellStyleHead);
			staffRowCell.setCellValue(Constant.DOWNLOAD_EXCEL_STAFF_ORDER);
			staffRowCell.setCellStyle(cellStyleHead);
			if(staffProductNames.size() > 0){
				for (int i = 0; i < staffProductNames.size(); i++) {
					HSSFRow tempRow = sheet.createRow(i + ordinaryProductNames.size() + 3);
					Map<String, String> tempMap = (Map<String, String>) staffOrderProductInfoMaps.get(staffProductNames.get(i));
					HSSFCell cellOne = tempRow.createCell(0);
					cellOne.setCellValue(i + 1 +"");
					cellOne.setCellStyle(cellStyle);
					HSSFCell cellTwo = tempRow.createCell(1);
					cellTwo.setCellValue(tempMap.get("2"));
					cellTwo.setCellStyle(cellStyle);
					StringBuilder sb = new StringBuilder();
					BigDecimal productCount = new BigDecimal(0);
					String productUnitName = tempMap.get("3");
					for (int j = 4; j < staffOrderCustomerStoreNames.size() + 4; j++) {
						if(tempMap.get(j + "") != null){
							productCount = productCount.add(new BigDecimal(tempMap.get(j + "")));
							String remark = tempMap.get("@" + j);
							if(sb.toString().length() == 0){
								if(remark != null){
									sb.append(tempMap.get(j + "") + productUnitName + "（"+ remark +"）");
								}else{
									sb.append(tempMap.get(j + "") + productUnitName);
								}
							}else{
								if(remark != null){
									sb .append(", ").append(tempMap.get(j + "") + productUnitName + "（"+ remark +"）");
								}else{
									sb .append(", ").append(tempMap.get(j + "") + productUnitName);
								}
							}
						}
					}
					HSSFCell cellThree = tempRow.createCell(2);
					cellThree.setCellValue(sb.toString());
					cellThree.setCellStyle(cellStyle);
					HSSFCell cellFour = tempRow.createCell(3);
					cellFour.setCellValue(productCount.toString() + productUnitName);
					cellFour.setCellStyle(cellStyle);
				}
			}
			/**
			 * 每行样式
			 */
			sheet.setColumnWidth(0, 1500);
			sheet.setColumnWidth(1, 4000);
			sheet.setColumnWidth(2, 15000);
			sheet.setColumnWidth(3, 3000);
		}
        try {
			workBook.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				workBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
	/**
	 * 判断是否是isMobile
	 * @Title: isMobile 
	 * @Description:     
	 * @param mobile
	 * @return   
	 * @return boolean    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月28日 上午8:45:30
	 */
	public static boolean isMobile(String mobile) {
		Pattern pattern = Pattern.compile("^(13[0-9]{9})|(18[0-9]{9})|(14[0-9]{9})|(17[0-9]{9})|(15[0-9]{9})$");
		Matcher matcher = pattern.matcher(mobile);
		return matcher.matches();
	}
	
	/**
	 * 获取新的图片的名称	
	 * @return	images/1232131.jpg
	 */
	public static synchronized String getImageName(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");// 设置日期格式
		return "images/" + df.format(new Date()) + ".png";
	}
	
	/**
	 * 生成UUID形式的主键
	 * @return
	 */
	public static String createPrimaryKey(){
		return UUID.randomUUID().toString();
	}
	
	/**
	 * 获取当日上周的日期
	 * @return
	 */
	public static String getDateOfLastWeek(){
		Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.WEEK_OF_YEAR, -1);
        date = calendar.getTime();
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}
	
	/**传入的日期加上任意天数
	 * 且设置日期格式
     * @return
     */
    public static String addAnyDay(String theDay, String format,Integer days){   
        SimpleDateFormat f =  new SimpleDateFormat(format);   
        try   {   
            Date  d  =  new Date(f.parse(theDay).getTime()+24*3600*1000 * days);     
              return  f.format(d);
        }   
        catch(Exception ex) {   
            return   "输入格式错误";     
        }   
    }
    
    /**
     * List集合中交换两元素的坐标位置
     * @param <T>
     * @return
     */
    public static <T> List<T> exchangeListIndex(List<T> list, Integer beforeIndex, Integer afterIndex){
    	T t = list.get(beforeIndex);
        list.set(beforeIndex, list.get(afterIndex));
        list.set(afterIndex, t);
        return list;
    }
    
    /**
     * 获取第二天的年月日
     * @return
     */
    public static String getTomorrowDate(){
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			return df.format(calendar.getTime());
    }
    
    /**
	 * 每一条订单的送货单excel形式导出
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static InputStream createSendOrderStream(SerOrderResponse serOrderResponse){
		/**
		 * 创建工作簿和要写入的输出流对象
		 */
		HSSFWorkbook workBook= new HSSFWorkbook();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		/**
		 * 创建表格sheet，并设置每个单元格默认宽度
		 */
		HSSFSheet sheet = workBook.createSheet(serOrderResponse.getSerOrder().getSysCustomerName() + "送货单");
		/**
		 * 首行跨列设置，第一行，最后一行，第一列，最后一列
		 */
		sheet.addMergedRegion(new CellRangeAddress(1,1,3,17));
		/**
		 * 设置表头单元格的风格
		 */
		HSSFCellStyle cellStyleHead = workBook.createCellStyle();
		/**
		 * 自动换行
		 */
		cellStyleHead.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		/**
		 * 水平和竖直居中
		 */
		cellStyleHead.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyleHead.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 设置表头单元格背景
		 */
		cellStyleHead.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		/**
		 * 表头字体风格设置
		 */
		HSSFFont fontHead = workBook.createFont();
		fontHead.setFontHeightInPoints(Constant.EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE);
		/**
		 * 加粗
		 */
		fontHead.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		fontHead.setFontName(Constant.EXCEL_SHEET_HEAD_FONT_TYPE);
		cellStyleHead.setFont(fontHead);
		/**
		 * 设置单元格上下左右的边线
		 */
		cellStyleHead.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyleHead.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyleHead.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyleHead.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		/**
		 * sheet次标题风格设置
		 */
		HSSFCellStyle assistantCellStyle = workBook.createCellStyle();
		assistantCellStyle.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		assistantCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		assistantCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 内容字体风格设置
		 */
		HSSFFont assistantFont = workBook.createFont();
		assistantFont.setFontHeightInPoints(Constant.EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE_SECOND);
		assistantFont.setFontName(Constant.EXCEL_SHEET_BODY_FONT_TYPE);
		assistantFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		assistantCellStyle.setFont(assistantFont);
		assistantCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		assistantCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		assistantCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		assistantCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		/**
		 * sheet正文内容风格设置
		 */
		HSSFCellStyle cellStyle = workBook.createCellStyle();
		cellStyle.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 内容字体风格设置
		 */
		HSSFFont font = workBook.createFont();
		font.setFontHeightInPoints(Constant.EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE_TEXT);
		font.setFontName(Constant.EXCEL_SHEET_BODY_FONT_TYPE);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyle.setFont(font);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		/**
		 * 表头及商家名称填充
		 */
		HSSFRow rowHead = sheet.createRow(1);
		rowHead.setHeight((short)700);
		HSSFCell cellHeadOne = rowHead.createCell(3); 
		cellHeadOne.setCellStyle(cellStyleHead);
		cellHeadOne.setCellValue(Constant.DOWNLOAD_SEND_ORDER_EXCEL_TITLE + serOrderResponse.getSerOrder().getSysCustomerName() + "送货单");
		for (int i = 4; i < 18; i++) {
			rowHead.createCell(i).setCellStyle(cellStyleHead);
		}
		
		/**
		 * 间隙行
		 */
		HSSFRow tempRowOne = sheet.createRow(2);
		sheet.addMergedRegion(new CellRangeAddress(2,2,3,17));
		for (int i = 3; i < 18; i++) {
			tempRowOne.createCell(i).setCellStyle(cellStyle);
		}

		/**
		 * 第二行内容设置
		 */
		HSSFRow assistantRowHead = sheet.createRow(3);
		HSSFCell cellAssistantHeadOne = assistantRowHead.createCell(3); 
		cellAssistantHeadOne.setCellValue("客户名称：" + serOrderResponse.getSerOrder().getSysCustomerName());
		cellAssistantHeadOne.setCellStyle(assistantCellStyle);
		HSSFCell cellAssistantHeadTwo = assistantRowHead.createCell(8); 
		cellAssistantHeadTwo.setCellValue("配送电话：" + Constant.DOWNLOAD_SEND_ORDER_EXCEL_SENDER_MOBILE);
		cellAssistantHeadTwo.setCellStyle(assistantCellStyle);
		HSSFCell cellAssistantHeadThree = assistantRowHead.createCell(13); 
		cellAssistantHeadThree.setCellValue("送货日期：" + serOrderResponse.getSendTime());
		cellAssistantHeadThree.setCellStyle(assistantCellStyle);
		/**
		 * 第二行跨行跨列设置
		 */
		for (int i = 4; i < 8; i++) {
			assistantRowHead.createCell(i).setCellStyle(assistantCellStyle);
		}
		for (int i = 9; i < 13; i++) {
			assistantRowHead.createCell(i).setCellStyle(assistantCellStyle);
		}
		for (int i = 14; i < 18; i++) {
			assistantRowHead.createCell(i).setCellStyle(assistantCellStyle);
		}
		sheet.addMergedRegion(new CellRangeAddress(3,3,3,7));
		sheet.addMergedRegion(new CellRangeAddress(3,3,8,12));
		sheet.addMergedRegion(new CellRangeAddress(3,3,13,17));
		
		/**
		 * 间隙行
		 */
		HSSFRow tempRowTwo = sheet.createRow(4);
		sheet.addMergedRegion(new CellRangeAddress(4,4,3,17));
		for (int i = 3; i < 18; i++) {
			tempRowTwo.createCell(i).setCellStyle(cellStyle);
		}
		
		/**
		 * 正文内容设置
		 */
		HSSFRow row = sheet.createRow(5);
		HSSFCell cellOne = row.createCell(3);
		cellOne.setCellValue("序号");
		cellOne.setCellStyle(cellStyle);
		
		row.createCell(4).setCellStyle(cellStyle);
		
		HSSFCell cellTwo = row.createCell(5);
		cellTwo.setCellValue("商品名");
		cellTwo.setCellStyle(cellStyle);
		
		row.createCell(6).setCellStyle(cellStyle);
		row.createCell(7).setCellStyle(cellStyle);
		
		HSSFCell cellThree = row.createCell(8);
		cellThree.setCellValue("数量");
		cellThree.setCellStyle(cellStyle);
		
		row.createCell(9).setCellStyle(cellStyle);
		
		HSSFCell cellFour = row.createCell(10);
		cellFour.setCellValue("单价（元）");
		cellFour.setCellStyle(cellStyle);
		
		row.createCell(11).setCellStyle(cellStyle);
		
		HSSFCell cellFive = row.createCell(12);
		cellFive.setCellValue("金额（元）");
		cellFive.setCellStyle(cellStyle);
		
		row.createCell(13).setCellStyle(cellStyle);
		
		HSSFCell cellSex = row.createCell(14);
		cellSex.setCellValue("备注");
		cellSex.setCellStyle(cellStyle);
		
		row.createCell(15).setCellStyle(cellStyle);
		row.createCell(16).setCellStyle(cellStyle);
		row.createCell(17).setCellStyle(cellStyle);
		/**
		 * 正文跨列设置
		 */
		sheet.addMergedRegion(new CellRangeAddress(5,5,3,4));
		sheet.addMergedRegion(new CellRangeAddress(5,5,5,7));
		sheet.addMergedRegion(new CellRangeAddress(5,5,8,9));
		sheet.addMergedRegion(new CellRangeAddress(5,5,10,11));
		sheet.addMergedRegion(new CellRangeAddress(5,5,12,13));
		sheet.addMergedRegion(new CellRangeAddress(5,5,14,17));
		/**
		 * 正文动态内容填充
		 */
		List<BetOrderProduct> list = serOrderResponse.getProducts();
		if(list != null && list.size() > 0){
			for (int i = 6; i < list.size() + 6; i++) {
				BetOrderProduct betOrderProduct = list.get(i - 6);
				HSSFRow textRow = sheet.createRow(i);
				
				HSSFCell textCellOne = textRow.createCell(3);
				textCellOne.setCellStyle(cellStyle);
				textCellOne.setCellValue(i - 5);
				
				textRow.createCell(4).setCellStyle(cellStyle);
				
				HSSFCell textCellTwo = textRow.createCell(5);
				textCellTwo.setCellStyle(cellStyle);
				textCellTwo.setCellValue(betOrderProduct.getBetOrderProductProductName());
				
				textRow.createCell(6).setCellStyle(cellStyle);
				textRow.createCell(7).setCellStyle(cellStyle);
				
				HSSFCell textCellThree = textRow.createCell(8);
				textCellThree.setCellStyle(cellStyle);
				textCellThree.setCellValue(betOrderProduct.getBetOrderProductProductCount() + "（" + betOrderProduct.getBetOrderProductProductUnitName() + "）");
				
				textRow.createCell(9).setCellStyle(cellStyle);
				
				HSSFCell textCellFour = textRow.createCell(10);
				textCellFour.setCellStyle(cellStyle);
				textCellFour.setCellValue(betOrderProduct.getBetOrderProductProductSalePrice().toString());
				
				textRow.createCell(11).setCellStyle(cellStyle);
				
				HSSFCell textCellFive = textRow.createCell(12);
				textCellFive.setCellStyle(cellStyle);
				textCellFive.setCellValue(betOrderProduct.getBetOrderProductProductTotal().toString());
				
				textRow.createCell(13).setCellStyle(cellStyle);
				
				HSSFCell textCellSix = textRow.createCell(14);
				textCellSix.setCellStyle(cellStyle);
				
				textRow.createCell(15).setCellStyle(cellStyle);
				textRow.createCell(16).setCellStyle(cellStyle);
				textRow.createCell(17).setCellStyle(cellStyle);
				
				/**
				 * 正文动态内容跨列设置
				 */
				sheet.addMergedRegion(new CellRangeAddress(i,i,3,4));
				sheet.addMergedRegion(new CellRangeAddress(i,i,5,7));
				sheet.addMergedRegion(new CellRangeAddress(i,i,8,9));
				sheet.addMergedRegion(new CellRangeAddress(i,i,10,11));
				sheet.addMergedRegion(new CellRangeAddress(i,i,12,13));
				sheet.addMergedRegion(new CellRangeAddress(i,i,14,17));
			}
		}
		Integer tempRowIndex = list == null ? 6 : list.size() + 6;
		/**
		 * 间隙行
		 */
		HSSFRow tempRowTheree = sheet.createRow(tempRowIndex);
		sheet.addMergedRegion(new CellRangeAddress(tempRowIndex,tempRowIndex,3,17));
		for (int i = 3; i < 18; i++) {
			tempRowTheree.createCell(i).setCellStyle(cellStyle);
		}
		
		/**
		 * 脚部内容
		 */
		Integer footIndex = tempRowIndex + 1;
		HSSFRow footRow = sheet.createRow(footIndex);
		HSSFCell footCellOne = footRow.createCell(3);
		footCellOne.setCellStyle(assistantCellStyle);
		footCellOne.setCellValue("合计金额：" + serOrderResponse.getOrderTotalPrice().toString());
		for (int j = 4; j < 8; j++) {
			footRow.createCell(j).setCellStyle(assistantCellStyle);
		}
		HSSFCell footCellTwo = footRow.createCell(8);
		footCellTwo.setCellStyle(assistantCellStyle);
		footCellTwo.setCellValue("送货人：" + Constant.DOWNLOAD_SEND_ORDER_EXCEL_SENDER_NAME);
		
		for (int j = 9; j < 12; j++) {
			footRow.createCell(j).setCellStyle(assistantCellStyle);
		}
		
		HSSFCell footCellThree = footRow.createCell(12);
		footCellThree.setCellStyle(assistantCellStyle);
		footCellThree.setCellValue("财务部：");
		
		footRow.createCell(13).setCellStyle(assistantCellStyle);
		footRow.createCell(14).setCellStyle(assistantCellStyle);
		
		HSSFCell footCellFour = footRow.createCell(15);
		footCellFour.setCellStyle(assistantCellStyle);
		footCellFour.setCellValue("收货人：");
		
		footRow.createCell(16).setCellStyle(assistantCellStyle);
		footRow.createCell(17).setCellStyle(assistantCellStyle);
		
		/**
		 * 脚部内容跨行处理
		 */
		sheet.addMergedRegion(new CellRangeAddress(footIndex,footIndex,3,7));
		sheet.addMergedRegion(new CellRangeAddress(footIndex,footIndex,8,11));
		sheet.addMergedRegion(new CellRangeAddress(footIndex,footIndex,12,14));
		sheet.addMergedRegion(new CellRangeAddress(footIndex,footIndex,15,17));
		try {
			workBook.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				workBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
	/**
	 * 顾客订单数据Excel导出
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static InputStream downLoadCustomerOrdersExcel(List<SerOrder> serOrders, Map<String, Object>betOrderProductMap, 
			Integer maxRowNumber, Integer orderType, String customerName){
		List<String> orderCreateDates = new ArrayList<String>();
		/**
		 * 拼装订单时间数据
		 */
		for (SerOrder serOrder : serOrders) {
			if(!orderCreateDates.contains(serOrder.getSerOrderSendTime())){
				orderCreateDates.add(serOrder.getSerOrderSendTime());
			}
		}
		
		/**
		 * 创建工作簿和要写入的输出流对象
		 */
		HSSFWorkbook workBook= new HSSFWorkbook();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		/**
		 * 创建表格sheet，并设置每个单元格默认宽度
		 */
		HSSFSheet sheet = workBook.createSheet(customerName + "订单详情");
		/**
		 * 首行跨列设置
		 */
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));
		/**
		 * 设置表头单元格的风格
		 */
		HSSFCellStyle cellStyleHead = workBook.createCellStyle();
		/**
		 * 自动换行
		 */
		cellStyleHead.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		/**
		 * 水平和竖直居中
		 */
		cellStyleHead.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyleHead.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 设置表头单元格背景
		 */
		cellStyleHead.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		/**
		 * 表头字体风格设置
		 */
		HSSFFont fontHead = workBook.createFont();
		fontHead.setFontHeightInPoints(Constant.EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE);
		/**
		 * 加粗
		 */
		fontHead.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		fontHead.setFontName(Constant.EXCEL_SHEET_HEAD_FONT_TYPE);
		cellStyleHead.setFont(fontHead);
		/**
		 * 设置单元格上下左右的边线
		 */
		cellStyleHead.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyleHead.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyleHead.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyleHead.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		/**
		 * sheet次标题风格设置
		 */
		HSSFCellStyle assistantCellStyle = workBook.createCellStyle();
		assistantCellStyle.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		assistantCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		assistantCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 内容字体风格设置
		 */
		HSSFFont assistantFont = workBook.createFont();
		assistantFont.setFontHeightInPoints(Constant.EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE_SECOND);
		assistantFont.setFontName(Constant.EXCEL_SHEET_BODY_FONT_TYPE);
		assistantFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		assistantCellStyle.setFont(assistantFont);
		assistantCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		assistantCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		assistantCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		assistantCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		/**
		 * sheet正文内容风格设置
		 */
		HSSFCellStyle cellStyle = workBook.createCellStyle();
		cellStyle.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 内容字体风格设置
		 */
		HSSFFont font = workBook.createFont();
		font.setFontHeightInPoints(Constant.EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE_TEXT);
		font.setFontName(Constant.EXCEL_SHEET_BODY_FONT_TYPE);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyle.setFont(font);
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		/**
		 * 表头商家名称填充
		 */
		HSSFRow rowHead = sheet.createRow(0);
		rowHead.setHeight((short)700);
		HSSFCell cellHeadOne = rowHead.createCell(0); 
		cellHeadOne.setCellStyle(cellStyleHead);
		cellHeadOne.setCellValue("店名：" + customerName + "("+ EnumConfig.getName(orderType, Constant.SER_ORDER_TYPE) +")");
		for (int i = 1; i < 8; i++) {
			HSSFCell cellHeadTemp = rowHead.createCell(i);
			cellHeadTemp.setCellStyle(cellStyleHead);
		}
		/**
		 * 第二行时间填充
		 */
		HSSFRow rowSecond = sheet.createRow(1);
		for (int i = 0; i < orderCreateDates.size(); i++) {
			/**
			 * 时间段行每4列夸列一次
			 */
			sheet.addMergedRegion(new CellRangeAddress(1 ,1,(i) * 4, ((i + 1) * 4) - 1));
			
			HSSFCell secondRowCell = rowSecond.createCell(i * 4);
			secondRowCell.setCellStyle(assistantCellStyle);
			secondRowCell.setCellValue(orderCreateDates.get(i));
			/**
			 * 为了边框填充，创建出空的cell
			 */
			HSSFCell secondRowCellTempOne = rowSecond.createCell(i * 4 + 1);
			HSSFCell secondRowCellTempTwo = rowSecond.createCell(i * 4 + 2);
			HSSFCell secondRowCellThreee = rowSecond.createCell(i * 4 + 3);
			secondRowCellTempOne.setCellStyle(assistantCellStyle);
			secondRowCellTempTwo.setCellStyle(assistantCellStyle);
			secondRowCellThreee.setCellStyle(assistantCellStyle);
		}
		/**
		 * 第三行数据标题
		 */
		HSSFRow rowDataTitle = sheet.createRow(2);
		/**
		 * 第三行数据填充
		 */
		for (int i = 0; i < orderCreateDates.size(); i++) {
			/**
			 * 时间段行每4列夸列一次
			 */
			
			HSSFCell thirdRowCellName = rowDataTitle.createCell(i * 4);
			HSSFCell thirdRowCellCount = rowDataTitle.createCell(i * 4 + 1);
			HSSFCell thirdRowCellPrice = rowDataTitle.createCell(i * 4 + 2);
			HSSFCell thirdRowCellAmount = rowDataTitle.createCell(i * 4 + 3);
			/**
			 * 样式设置
			 */
			thirdRowCellName.setCellStyle(cellStyle);
			thirdRowCellCount.setCellStyle(cellStyle);
			thirdRowCellPrice.setCellStyle(cellStyle);
			thirdRowCellAmount.setCellStyle(cellStyle);
			/**
			 * 内容显示
			 */
			thirdRowCellName.setCellValue("品名");
			thirdRowCellCount.setCellValue("数量");
			thirdRowCellPrice.setCellValue("单价");
			thirdRowCellAmount.setCellValue("金额");
		}
		
		/**
		 * 根据本次导出订单对应商品最多的数量动态创建行row
		 */
		Map<String, Object> dataRowMap = new HashMap<String, Object>();
		for (int i = 3; i < maxRowNumber + 5; i++) {
			dataRowMap.put(i + "", sheet.createRow(i));
		}
		/**
		 * 有效数据填充
		 */
		Integer count = 0;
		BigDecimal totalAmount = new BigDecimal(0); 
		for (String serOrderCreateTime : orderCreateDates) {
			BigDecimal totalCurrentOrderAmount = new BigDecimal(0);
			List<BetOrderProduct> betOrderProducts =  (List<BetOrderProduct>) betOrderProductMap.get(serOrderCreateTime);
			for (int i = 3; i < betOrderProducts.size() + 3; i++) {
				/**
				 * 取得对应的row
				 */
				HSSFRow dataRow = (HSSFRow) dataRowMap.get(i + "");
				/**
				 * 创建对应的cell
				 */
				HSSFCell dataCellOne = dataRow.createCell(count * 4);
				HSSFCell dataCellTwo = dataRow.createCell(count * 4 + 1);
				HSSFCell dataCellThree = dataRow.createCell(count * 4 + 2);
				HSSFCell dataCellFour = dataRow.createCell(count * 4 + 3);
				/**
				 * 设置样式
				 */
				dataCellOne.setCellStyle(cellStyle);
				dataCellTwo.setCellStyle(cellStyle);
				dataCellThree.setCellStyle(cellStyle);
				dataCellFour.setCellStyle(cellStyle);
				/**
				 * 设置数据
				 */
				BetOrderProduct betOrderProduct = betOrderProducts.get(i - 3);
				dataCellOne.setCellValue(betOrderProduct.getBetOrderProductProductName());
				dataCellTwo.setCellValue(betOrderProduct.getBetOrderProductProductCount());
				dataCellThree.setCellValue(betOrderProduct.getBetOrderProductProductSalePrice().toString());
				dataCellFour.setCellValue(betOrderProduct.getBetOrderProductProductTotal().toString());
				/**
				 * 当前订单的合计金额累加
				 */
				totalCurrentOrderAmount = totalCurrentOrderAmount.add(betOrderProduct.getBetOrderProductProductTotal());
			}
			/**
			 * 合计金额处理
			 */
			HSSFRow currentOrdertotalAmountRow = (HSSFRow)dataRowMap.get((maxRowNumber + 4) + "");
			HSSFCell currentOrdertotalAmountCellOne = currentOrdertotalAmountRow.createCell(count * 4);
			HSSFCell currentOrdertotalAmountCellTwo = currentOrdertotalAmountRow.createCell(count * 4 + 1);
			HSSFCell currentOrdertotalAmountCellThree = currentOrdertotalAmountRow.createCell(count * 4 + 2);
			HSSFCell currentOrdertotalAmountCellFour = currentOrdertotalAmountRow.createCell(count * 4 + 3);
			currentOrdertotalAmountCellOne.setCellStyle(cellStyle);
			sheet.addMergedRegion(new CellRangeAddress(maxRowNumber + 4,maxRowNumber + 4,count * 4,count * 4 + 3));
			currentOrdertotalAmountCellOne.setCellValue("合计金额：" + totalCurrentOrderAmount);
			
			currentOrdertotalAmountCellTwo.setCellStyle(cellStyle);
			currentOrdertotalAmountCellThree.setCellStyle(cellStyle);
			currentOrdertotalAmountCellFour.setCellStyle(cellStyle);
			
			/**
			 * 所有金额累加
			 */
			totalAmount = totalAmount.add(totalCurrentOrderAmount);
			count ++;
		}
		/**
		 * 最后总金额显示
		 */
		sheet.addMergedRegion(new CellRangeAddress(maxRowNumber + 6	,maxRowNumber + 6, 0, 5));

		HSSFRow totalAmountRow = sheet.createRow(maxRowNumber + 6);
		HSSFCell totalAmountCell = totalAmountRow.createCell(0);
		HSSFCell totalAmountCellTempOne = totalAmountRow.createCell(1);
		HSSFCell totalAmountCellTempTwo = totalAmountRow.createCell(2);
		HSSFCell totalAmountCellTempThree = totalAmountRow.createCell(3);
		HSSFCell totalAmountCellTempFour = totalAmountRow.createCell(4);
		HSSFCell totalAmountCellTempFive = totalAmountRow.createCell(5);
		
		totalAmountCell.setCellStyle(cellStyle);
		totalAmountCell.setCellValue("总金额：" + totalAmount);
		
		totalAmountCellTempOne.setCellStyle(cellStyle);
		totalAmountCellTempTwo.setCellStyle(cellStyle);
		totalAmountCellTempThree.setCellStyle(cellStyle);
		totalAmountCellTempFour.setCellStyle(cellStyle);
		totalAmountCellTempFive.setCellStyle(cellStyle);
		
		try {
			workBook.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				workBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
        return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
	/**
	 * 送货车辆进价详情单导出
	 * @param betOrderProducts
	 * @param sysVehicles
	 * @param serOrderQuery
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings({ "unchecked" })
	public static InputStream downLoadVehiclesBidAmountTotalExcel(Map<String,Object> paramMap
			, SysVehicles sysVehicles, SerOrderQuery serOrderQuery, Integer bidType) throws Exception{
		/**
		 * 创建工作簿和要写入的输出流对象
		 */
		HSSFWorkbook workBook= new HSSFWorkbook();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		/**
		 * 创建表格sheet，并设置每个单元格默认宽度
		 */
		HSSFSheet sheet = workBook.createSheet(sysVehicles.getSysVehiclesPlateNumber() + "进价详情单");
		/**
		 * 设置表头单元格的风格
		 */
		HSSFCellStyle cellStyleHead = ExcelUtils.getHeadTitleStyle(workBook);
		
		/**
		 * sheet次标题风格设置
		 */
		HSSFCellStyle assistantCellStyle = ExcelUtils.getSencondTitleStyle(workBook);
		
		/**
		 * sheet正文内容风格设置
		 */
		HSSFCellStyle cellStyle = ExcelUtils.getTextTitleStyle(workBook);
		/**
		 * 按天导出
		 */
		if(bidType.equals(1)){
			/**
			 * 首行跨列设置
			 */
			sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
			/**
			 * 表头商家名称填充
			 */
			HSSFRow rowHead = sheet.createRow(0);
			HSSFCell cellHead = rowHead.createCell(0);
			cellHead.setCellStyle(cellStyleHead);
			for (int i = 1; i < 4; i++) {
				HSSFCell tempCell = rowHead.createCell(i);
				tempCell.setCellStyle(cellStyleHead);
			}
			cellHead.setCellValue("车辆名称：" + sysVehicles.getSysVehiclesPlateNumber());
			
			/**
			 * 次级标题:日期
			 */
			HSSFRow rowSecond = sheet.createRow(1);
			HSSFCell assistantCell = rowSecond.createCell(0);
			assistantCell.setCellStyle(assistantCellStyle);
			assistantCell.setCellValue("日期：" + serOrderQuery.getOrderSendTime());
			for (int i = 1; i < 4; i++) {
				HSSFCell tempCell = rowSecond.createCell(i);
				tempCell.setCellStyle(assistantCellStyle);
			}
			
			sheet.addMergedRegion(new CellRangeAddress(1,1,0,3));
			
			/**
			 * 次级标题，统计标题
			 */
			HSSFRow rowThrid = sheet.createRow(2);
			HSSFCell thridOneCell = rowThrid.createCell(0);
			thridOneCell.setCellStyle(assistantCellStyle);
			thridOneCell.setCellValue("品名");
			HSSFCell thridTowCell = rowThrid.createCell(1);
			thridTowCell.setCellStyle(assistantCellStyle);
			thridTowCell.setCellValue("数量");
			HSSFCell thridThreeCell = rowThrid.createCell(2);
			thridThreeCell.setCellStyle(assistantCellStyle);
			thridThreeCell.setCellValue("单价");	
			HSSFCell thridFourCell = rowThrid.createCell(3);
			thridFourCell.setCellStyle(assistantCellStyle);
			thridFourCell.setCellValue("金额");
			
			/**
			 * 动态正文内容拼接
			 */
			Map<String,Object> textMap = new HashMap<>();
			/**
			 * 总金额
			 */
			BigDecimal amountTotal = new BigDecimal(0);
			/**
			 * 动态正文行数
			 */
			List<String> productNames = new ArrayList<>();
			Object betOrderProductObjects = paramMap.get(serOrderQuery.getOrderSendTime());
			if(betOrderProductObjects != null){
				List<BetOrderProduct> betOrderProducts = (List<BetOrderProduct>) betOrderProductObjects;
				for (BetOrderProduct betOrderProduct : betOrderProducts) {
					amountTotal = amountTotal.add(betOrderProduct.getBetOrderProductProductBidPrice().
							multiply(new BigDecimal(betOrderProduct.getBetOrderProductProductCount())));
					/**
					 * 不存在新建
					 */
					if(textMap.get(betOrderProduct.getBetOrderProductProductId()) == null){
						Map<String,Object> tempMap = new HashMap<>();
						tempMap.put("name", betOrderProduct.getBetOrderProductProductName());
						tempMap.put("count", new BigDecimal(betOrderProduct.getBetOrderProductProductCount()));
						tempMap.put("unit", betOrderProduct.getBetOrderProductProductUnitName());
						tempMap.put("price", betOrderProduct.getBetOrderProductProductBidPrice());
						tempMap.put("amount", new BigDecimal(betOrderProduct.getBetOrderProductProductCount()).
								multiply(betOrderProduct.getBetOrderProductProductBidPrice()));
						textMap.put(betOrderProduct.getBetOrderProductProductId(), tempMap);
					}else{
						/**
						 * 存在则叠加
						 */
						Map<String,Object> tempMap = (Map<String, Object>) textMap.get(
								betOrderProduct.getBetOrderProductProductId());
						/**
						 * 数量叠加
						 */
						BigDecimal count = (BigDecimal)tempMap.get("count");
						tempMap.put("count", count.add(new BigDecimal(betOrderProduct.getBetOrderProductProductCount())));
						/**
						 * 金额叠加
						 */
						BigDecimal amount = (BigDecimal) tempMap.get("amount");
						BigDecimal newProductAmount = new BigDecimal(betOrderProduct.getBetOrderProductProductCount()).
								multiply(betOrderProduct.getBetOrderProductProductBidPrice());
						tempMap.put("amount", amount.add(newProductAmount));
						textMap.put(betOrderProduct.getBetOrderProductProductId(), tempMap);
					}
					/**
					 * 正文行数添加
					 */
					if(!productNames.contains(betOrderProduct.getBetOrderProductProductId())){
						productNames.add(betOrderProduct.getBetOrderProductProductId());
					}
				}
				
				for (int i = 0; i < productNames.size(); i++) {
					Map<String,Object> tempMap = (Map<String, Object>)textMap.get(productNames.get(i));
					
					HSSFRow rowText = sheet.createRow(i + 3);
					HSSFCell textOneCell = rowText.createCell(0);
					textOneCell.setCellStyle(cellStyle);
					textOneCell.setCellValue((String)tempMap.get("name"));
					HSSFCell textTowCell = rowText.createCell(1);
					textTowCell.setCellStyle(cellStyle);
					BigDecimal count = (BigDecimal) tempMap.get("count");
					textTowCell.setCellValue(count.toString() + "(" + tempMap.get("unit") + ")");
					HSSFCell textThreeCell = rowText.createCell(2);
					textThreeCell.setCellStyle(cellStyle);
					BigDecimal price = (BigDecimal)tempMap.get("price");
					textThreeCell.setCellValue(price.toString());	
					HSSFCell textFourCell = rowText.createCell(3);
					textFourCell.setCellStyle(cellStyle);
					BigDecimal amount = (BigDecimal) tempMap.get("amount");
					textFourCell.setCellValue(amount.toString());
				}
			}
			/**
			 * 总金额添加
			 */
			HSSFRow totalRow = sheet.createRow(productNames.size() + 4);
			HSSFCell totalCell = totalRow.createCell(0);
			for (int i = 1; i < 4; i++) {
				HSSFCell tempCell = totalRow.createCell(i);
				tempCell.setCellStyle(cellStyle);
			}
			totalCell.setCellStyle(cellStyle);
			totalCell.setCellValue("合计金额：" + amountTotal.toString());
			sheet.addMergedRegion(new CellRangeAddress(productNames.size() + 4,productNames.size() + 4,0,3));
		}else{
			HSSFRow rowHead = sheet.createRow(0);
			HSSFRow rowSecond = sheet.createRow(1);
			HSSFRow rowThrid = sheet.createRow(2);
			for (int i = 3; i < (int)paramMap.get("maxLength") + 3; i++) {
				sheet.createRow(i);
			}
			/**
			 * 表头商家名称填充
			 */
			HSSFCell cellHead = rowHead.createCell(4);
			cellHead.setCellStyle(cellStyleHead);
			for (int j = 5; j < paramMap.keySet().size() -1 * 4 ; j++) {
				HSSFCell tempCell = rowHead.createCell(j);
				tempCell.setCellStyle(cellStyleHead);
			}
			cellHead.setCellValue("车辆名称：" + sysVehicles.getSysVehiclesPlateNumber());
			/**
			 * 首行跨列设置
			 */
			sheet.addMergedRegion(new CellRangeAddress(0,0,4,(paramMap.keySet().size() -1) * 4 - 1));
			/**
			 * 获取当月所有日期数
			 */
			List<String> list = getAllTheDateOftheMonthStr(new SimpleDateFormat("yyyy-MM").
					parse(serOrderQuery.getOrderSendTime() + "-01"), "yyyy-MM-dd");
			
			/**
			 * 合计总金额
			 */
			BigDecimal totalAmount = new BigDecimal(0);
			
			/**
			 * 遍历填充excel
			 */
			for (int i = 0; i < list.size(); i++) {
				
				/**
				 * 次级标题:日期
				 */
				HSSFCell assistantCell = rowSecond.createCell(0 + i * 4);
				assistantCell.setCellStyle(assistantCellStyle);
				assistantCell.setCellValue("日期：" + list.get(i));
				for (int k = 1 + i * 4; k < 4 + i * 4; k++) {
					HSSFCell tempCell = rowSecond.createCell(k);
					tempCell.setCellStyle(assistantCellStyle);
				}
				
				sheet.addMergedRegion(new CellRangeAddress(1,1,i * 4, (i + 1) * 4 - 1));
				
				/**
				 * 次级标题，统计标题
				 */

				HSSFCell thridOneCell = rowThrid.createCell(0 + i * 4);
				thridOneCell.setCellStyle(assistantCellStyle);
				thridOneCell.setCellValue("品名");
				HSSFCell thridTowCell = rowThrid.createCell(1 + i * 4);
				thridTowCell.setCellStyle(assistantCellStyle);
				thridTowCell.setCellValue("数量");
				HSSFCell thridThreeCell = rowThrid.createCell(2 + i * 4);
				thridThreeCell.setCellStyle(assistantCellStyle);
				thridThreeCell.setCellValue("单价");	
				HSSFCell thridFourCell = rowThrid.createCell(3 + i * 4);
				thridFourCell.setCellStyle(assistantCellStyle);
				thridFourCell.setCellValue("金额");
				
				/**
				 * 动态正文内容拼接
				 */
				Map<String,Object> textMap = new HashMap<>();
				/**
				 * 总金额
				 */
				BigDecimal amountTotal = new BigDecimal(0);
				/**
				 * 动态正文行数
				 */
				List<String> productNames = new ArrayList<>();
				Object betOrderProductObjects = paramMap.get(list.get(i));
				if(betOrderProductObjects != null){
					List<BetOrderProduct> betOrderProducts = (List<BetOrderProduct>) betOrderProductObjects;
					for (BetOrderProduct betOrderProduct : betOrderProducts) {
						amountTotal = amountTotal.add(betOrderProduct.getBetOrderProductProductBidPrice().
								multiply(new BigDecimal(betOrderProduct.getBetOrderProductProductCount())));
						/**
						 * 不存在新建
						 */
						if(textMap.get(betOrderProduct.getBetOrderProductProductId()) == null){
							Map<String,Object> tempMap = new HashMap<>();
							tempMap.put("name", betOrderProduct.getBetOrderProductProductName());
							tempMap.put("count", new BigDecimal(betOrderProduct.getBetOrderProductProductCount()));
							tempMap.put("unit", betOrderProduct.getBetOrderProductProductUnitName());
							tempMap.put("price", betOrderProduct.getBetOrderProductProductBidPrice());
							tempMap.put("amount", new BigDecimal(betOrderProduct.getBetOrderProductProductCount()).
									multiply(betOrderProduct.getBetOrderProductProductBidPrice()));
							textMap.put(betOrderProduct.getBetOrderProductProductId(), tempMap);
						}else{
							/**
							 * 存在则叠加
							 */
							Map<String,Object> tempMap = (Map<String, Object>) textMap.get(
									betOrderProduct.getBetOrderProductProductId());
							/**
							 * 数量叠加
							 */
							BigDecimal count = (BigDecimal)tempMap.get("count");
							tempMap.put("count", count.add(new BigDecimal(betOrderProduct.getBetOrderProductProductCount())));
							/**
							 * 金额叠加
							 */
							BigDecimal amount = (BigDecimal) tempMap.get("amount");
							BigDecimal newProductAmount = new BigDecimal(betOrderProduct.getBetOrderProductProductCount()).
									multiply(betOrderProduct.getBetOrderProductProductBidPrice());
							tempMap.put("amount", amount.add(newProductAmount));
							textMap.put(betOrderProduct.getBetOrderProductProductId(), tempMap);
						}
						/**
						 * 正文行数添加
						 */
						if(!productNames.contains(betOrderProduct.getBetOrderProductProductId())){
							productNames.add(betOrderProduct.getBetOrderProductProductId());
						}
					}
					
					/**
					 * 正文数据渲染
					 */
					for (int j = 0; j < productNames.size(); j++) {
						Map<String,Object> tempMap = (Map<String, Object>)textMap.get(productNames.get(j));
						HSSFRow rowText = sheet.getRow(j + 3);
						HSSFCell textOneCell = rowText.createCell(0 + i * 4);
						textOneCell.setCellStyle(cellStyle);
						textOneCell.setCellValue((String)tempMap.get("name"));
						HSSFCell textTowCell = rowText.createCell(1 + i * 4);
						textTowCell.setCellStyle(cellStyle);
						BigDecimal count = (BigDecimal) tempMap.get("count");
						textTowCell.setCellValue(count.toString() + "(" + tempMap.get("unit") + ")");
						HSSFCell textThreeCell = rowText.createCell(2 + i * 4);
						textThreeCell.setCellStyle(cellStyle);
						BigDecimal price = (BigDecimal)tempMap.get("price");
						textThreeCell.setCellValue(price.toString());	
						HSSFCell textFourCell = rowText.createCell(3 + i * 4);
						textFourCell.setCellStyle(cellStyle);
						BigDecimal amount = (BigDecimal) tempMap.get("amount");
						textFourCell.setCellValue(amount.toString());
					}
				}
				/**
				 * 总金额添加
				 */
				HSSFRow totalRow = sheet.getRow(productNames.size() + 3);
				if(totalRow == null){
					totalRow = sheet.createRow(productNames.size() + 3);
				}
				HSSFCell totalCell = totalRow.createCell(0 + i * 4);
				for (int k = 1 + i * 4; k < 4 + i * 4; k++) {
					HSSFCell tempCell = totalRow.createCell(k);
					tempCell.setCellStyle(cellStyle);
				}
				totalCell.setCellStyle(cellStyle);
				totalCell.setCellValue("合计金额：" + amountTotal.toString());
				sheet.addMergedRegion(new CellRangeAddress(productNames.size() + 3,productNames.size() + 3,i * 4, (i + 1) * 4 - 1));
				totalAmount = totalAmount.add(amountTotal) ;
			}
			/**
			 * 当月总合计金额
			 */
			HSSFCell totalAmountCell = rowHead.createCell(0);
			totalAmountCell.setCellStyle(cellStyle);
			totalAmountCell.setCellValue("总合计金额：" + totalAmount.toString());
			for (int j = 1; j < 3; j++) {
				rowHead.createCell(j);
				totalAmountCell.setCellStyle(cellStyle);
			}
			sheet.addMergedRegion(new CellRangeAddress(0,0,0, 3));
		}
		
		try {
			workBook.write(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				workBook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
}
