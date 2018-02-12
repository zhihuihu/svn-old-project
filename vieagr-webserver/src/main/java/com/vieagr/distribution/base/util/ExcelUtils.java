package com.vieagr.distribution.base.util;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.vieagr.distribution.base.config.Constant;

/**
 * excel操作的工具类
 * @author Administrator
 *
 */
public class ExcelUtils {
		
	
	@SuppressWarnings("deprecation")
	public static HSSFCellStyle getHeadTitleStyle(HSSFWorkbook workBook){
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
		return cellStyleHead;
	}

	/**
	 * 获得次级标题的风格
	 * @param workBook
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static HSSFCellStyle getSencondTitleStyle(HSSFWorkbook workBook){
		HSSFCellStyle secondCellStyle = workBook.createCellStyle();
		secondCellStyle.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		secondCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		secondCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 内容字体风格设置
		 */
		HSSFFont assistantFont = workBook.createFont();
		assistantFont.setFontHeightInPoints(Constant.EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE_SECOND);
		assistantFont.setFontName(Constant.EXCEL_SHEET_BODY_FONT_TYPE);
		assistantFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		secondCellStyle.setFont(assistantFont);
		secondCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		secondCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		secondCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		secondCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		return secondCellStyle;
	}
	
	/**
	 * 获得正文标题风格
	 * @param workBook
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static HSSFCellStyle getTextTitleStyle(HSSFWorkbook workBook){
		HSSFCellStyle textCellStyle = workBook.createCellStyle();
		textCellStyle.setWrapText(Constant.EXCEL_SHEET_WRAP_TEXT);
		textCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		textCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		/**
		 * 内容字体风格设置
		 */
		HSSFFont font = workBook.createFont();
		font.setFontHeightInPoints(Constant.EXCEL_SNED_ORDER_SHEET_HEAD_FONT_SIZE_TEXT);
		font.setFontName(Constant.EXCEL_SHEET_BODY_FONT_TYPE);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		textCellStyle.setFont(font);
		textCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		textCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		textCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		textCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		return textCellStyle;
	}
	
}
