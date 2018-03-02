package com.vieagr.distribution.controller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysUser;
import com.vieagr.distribution.param.IndexParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.response.SerOrderResponse;
import com.vieagr.distribution.response.SysVehiclesResponse;
import com.vieagr.distribution.service.inter.IBetOrderProductService;
import com.vieagr.distribution.service.inter.ISerOrderService;
import com.vieagr.distribution.service.inter.ISysVehiclesService;

/**
 * 首页控制端
 * @author master
 *
 */
@Controller
@RequestMapping(value = "index")
public class IndexController {
	
	@Autowired
	private ISerOrderService serOrderService;
	
	@Autowired
	private IBetOrderProductService betOrderProductService;
	
	@Autowired
	private ISysVehiclesService sysVehiclesService;
	
	/**
	 * 获取登录的用户的信息
	 * @return
	 */
	@RequestMapping(value = "getLoginUserInfo", method = RequestMethod.GET)
	public @ResponseBody Object getLoginUserInfo(HttpServletRequest request){
		return ReturnUtils.forNoramlError(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS
				, Utils.getLoginUserInfo(request, SysUser.class));
	}
	
	/**
	 * 分别获取订单总条数，
	 * 今日下单条数
	 * 客户数
	 * 商品总数
	 * @return
	 */
	@RequestMapping(value = "classificationGetCount", method = RequestMethod.GET)
	public @ResponseBody Object classiFicationGetCount(){
		return ReturnUtils.forNoramlError(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS, 
				serOrderService.classiFicationGetCount(Utils.getTomorrowDate()));
	}
	
	/**
	 * 查询今日待配送订单
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "selectTomorrowOrderInfo", method = RequestMethod.POST)
	public @ResponseBody Object selectToDayOrderInfo(String jsonStr) throws Exception{
		SerOrderQuery serOrderQuery = Utils.jsonStrToObject(jsonStr, SerOrderQuery.class);
		serOrderQuery.setOrderSendTime(Utils.getTomorrowDate());
		return serOrderService.selectToDayOrderInfo(serOrderQuery);
	}
	
	/**
	 * 导出excel文件
	 * @param serOrderQuery
	 * @return
	 */
	@RequestMapping(value = "downLoadExcelForSysOrder", method = RequestMethod.POST)
	public Object downLoadExcelForSysOrder(String orderSendTime, String excelType, String sysVehiclesId, Integer orderState, HttpServletResponse response){
		SerOrderQuery serOrderQuery = new SerOrderQuery();
		serOrderQuery.setOrderSendTime(orderSendTime);
		serOrderQuery.setSysVehiclesId(sysVehiclesId.equals("-1") ? null : sysVehiclesId);
		serOrderQuery.setSerOrderState(orderState);
		IndexParam indexParam = new IndexParam();
		try {
			/**
			 * 普通订单导出信息获取
			 */
			serOrderQuery.setSerOrderType(EnumConfig.SER_ORDER_TYPE_ORDINARY.getIndex());
			List<BetOrderProduct> ordinaryOrderBetOrderProducts = betOrderProductService.selectBetOrderProductListByQuery(serOrderQuery);
			List<SerOrder> ordinarySerOrders = serOrderService.selectOrdersAndCustomersBySendTime(serOrderQuery);
			List<String> ordinaryOrderCustomerStoreNames = serOrderService.joinCustomerStoreNamesTogether(ordinarySerOrders);
			List<String> ordinaryOrderProductInfos = serOrderService.joinPorductNamesTogether(ordinaryOrderBetOrderProducts);
			Map<String, Object> ordinaryOrderProductInfoMaps = serOrderService.joinOrderAndProductTogether(
					ordinaryOrderProductInfos, ordinaryOrderCustomerStoreNames, ordinaryOrderBetOrderProducts);
			indexParam.setOrdinaryOrderCustomerStoreNames(ordinaryOrderCustomerStoreNames);
			indexParam.setOrdinaryOrderProductInfoMaps(ordinaryOrderProductInfoMaps);
			/*
			 * 员工餐订单导出信息获取
			 */
			serOrderQuery.setSerOrderType(EnumConfig.SER_ORDER_TYPE_STAFF_MEAL.getIndex());
			List<BetOrderProduct> staffOrderBetOrderProducts = betOrderProductService.selectBetOrderProductListByQuery(serOrderQuery);
			List<SerOrder>  staffSerOrders = serOrderService.selectOrdersAndCustomersBySendTime(serOrderQuery);
			List<String> staffOrderCustomerStoreNames = serOrderService.joinCustomerStoreNamesTogether(staffSerOrders);
			List<String> staffOrderProductInfos = serOrderService.joinPorductNamesTogether(staffOrderBetOrderProducts);
			Map<String, Object> staffOrderProductInfoMaps = serOrderService.joinOrderAndProductTogether(
					staffOrderProductInfos, staffOrderCustomerStoreNames, staffOrderBetOrderProducts);
			indexParam.setStaffOrderCustomerStoreNames(staffOrderCustomerStoreNames);
			indexParam.setStaffOrderProductInfoMaps(staffOrderProductInfoMaps);
			/**
			 *	获取excel的文件信息流
			 */
			InputStream inputStream = Utils.createExcelStream(
					excelType,indexParam);
	        OutputStream out = response.getOutputStream(); 
	        String fileName = excelType.equals(Constant.EXCEL_TYPE_SORTING_ORDER) ? "分拣单"  : "汇总单";
	        fileName = orderSendTime + fileName + ".xls";
	        response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));
			try {
		        int b;  
		        while((b=inputStream.read())!= -1)  
		        {  
		            out.write(b);  
		        }  
		        inputStream.close();  
		        out.close();  
			   inputStream.close();
			  } catch (Exception e) {
			   e.printStackTrace();
			  }finally {
				  try {
					  out.close();
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取走势图的数据
	 * @return
	 */
	@RequestMapping(value = "readChartData", method = RequestMethod.GET)
	public @ResponseBody Object readChartData(){
		return ReturnUtils.forNoramlError(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS, 
				serOrderService.readChartData());
	}
	
	/**
	 * 送货单Excel
	 * @param orderNumber
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "downLoadSendOrderExcel", method = RequestMethod.POST)
	public void downLoadSendOrderExcel(String orderNumber, HttpServletRequest request, HttpServletResponse response){
		try {
			SerOrderResponse serOrderResponse = serOrderService.selectOrderByOrderNumber(orderNumber);
			InputStream inputStream = Utils.createSendOrderStream(serOrderResponse);
			OutputStream out = response.getOutputStream(); 
	        String fileName = serOrderResponse.getSerOrder().getSysCustomerName() + "送货单.xls";
	        response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));
			try {
		        int b;  
		        while((b=inputStream.read())!= -1)  
		        {  
		            out.write(b);
		        }  
		        inputStream.close();  
		        out.close();  
			   inputStream.close();
			  } catch (Exception e) {
			   e.printStackTrace();
			  }finally {
				  try {
					  out.close();
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 顾客订单Excel数据按照月份导出
	 * @param monthDate
	 * @param customerId
	 * @param orderType
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "downLoadCustomerOrdersByMonthDate", method = RequestMethod.POST)
	public void downLoadCustomerOrdersByMonthDate(String monthDate, String customerId, Integer orderType,
			HttpServletResponse response) throws Exception{
		SerOrderResponse serOrderResponse = serOrderService.downLoadCustomerOrdersByMonthDate(monthDate, customerId, orderType);
		OutputStream out = response.getOutputStream(); 
        String fileName = serOrderResponse.getCustomerName() + monthDate + EnumConfig.getName(orderType, 
        		Constant.SER_ORDER_TYPE) +"汇总.xls";
        response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));
        InputStream inputStream = serOrderResponse.getExcelInputStream();
		try {
	        int b;  
	        while((b=inputStream.read())!= -1)  
	        {  
	            out.write(b);
	        }  
	        inputStream.close();  
	        out.close();  
		   inputStream.close();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }finally {
			  try {
				  out.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 顾客订单Excel数据安装具体时间导出
	 * @param startDate
	 * @param endDate
	 * @param customerId
	 * @param orderType
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "downLoadCustomerOrdersByDetailsDate" , method = RequestMethod.POST)
	public void downLoadCustomerOrdersByDetailsDate(String startDate, String endDate, String customerId, Integer orderType,
			HttpServletResponse response) throws Exception{
		SerOrderResponse serOrderResponse = serOrderService.downLoadCustomerOrdersByDetailsDate(startDate, endDate, customerId, orderType);
		OutputStream out = response.getOutputStream(); 
        String fileName = serOrderResponse.getCustomerName() + startDate + "-" + endDate + 
        		EnumConfig.getName(orderType, Constant.SER_ORDER_TYPE) +"汇总.xls";
        response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));
        InputStream inputStream = serOrderResponse.getExcelInputStream();
		try {
	        int b;  
	        while((b=inputStream.read())!= -1)  
	        {  
	            out.write(b);
	        }  
	        inputStream.close();  
	        out.close();  
		   inputStream.close();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }finally {
			  try {
				  out.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 根据时间和车辆以及订单类型导出车辆对应的商品进价详情单
	 * @param vehiclesId
	 * @param orderType
	 * @param chooseTime
	 * @param bidType
	 * @throws Exception 
	 */
	@RequestMapping(value = "downLoadVehiclesBidAmountTotalExcel" , method = RequestMethod.POST)
	public void downLoadVehiclesBidAmountTotalExcel(String vehiclesId, Integer orderType, String chooseTime, 
			Integer bidType,HttpServletResponse response) throws Exception{
		SysVehiclesResponse sysVehiclesResponse = sysVehiclesService.
				downLoadVehiclesBidAmountTotalExcel(vehiclesId, orderType, chooseTime,bidType);
		OutputStream outputStream = response.getOutputStream();
        String fileName = sysVehiclesResponse.getVehiclesPlateNumber() +"商品进价单汇总.xls";
        response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(fileName, "UTF-8"));
        InputStream inputStream = sysVehiclesResponse.getBidExcelInPutStream();
		try {
	        int b;  
	        while((b=inputStream.read())!= -1)  
	        {  
	        	outputStream.write(b);
	        }  
	        inputStream.close();  
	        outputStream.close();  
		   inputStream.close();
		  } catch (Exception e) {
		   e.printStackTrace();
		  }finally {
			  try {
				  outputStream.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
