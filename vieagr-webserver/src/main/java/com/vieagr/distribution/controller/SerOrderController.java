package com.vieagr.distribution.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysUser;
import com.vieagr.distribution.param.SerOrderParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.response.SerOrderResponse;
import com.vieagr.distribution.service.inter.IBetOrderProductService;
import com.vieagr.distribution.service.inter.ISerOrderService;

/**
 * 订单控制层
 * @author master
 *
 */
@RestController
@RequestMapping(value = "order")
public class SerOrderController {

	@Autowired
	private ISerOrderService serOrderService;
	
	@Autowired
	private IBetOrderProductService betOrderProductService;
	
	/**
	 * 订单列表查询
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "selectSerOrderList", method = RequestMethod.POST)
	public Object selectSerOrderList(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SerOrderQuery serOrderQuery = Utils.jsonStrToObject(jsonStr, SerOrderQuery.class);
		serOrderQuery.setSysVehiclesId(serOrderQuery.getSysVehiclesId().equals("-1") ? null : serOrderQuery.getSysVehiclesId());
		return serOrderService.selectOrderList(serOrderQuery);
	}
	
	/**
	 * 添加一条订单
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "saveSerOrder", method = RequestMethod.POST) 
	public Object saveSerOrder(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		SysUser sysUser = Utils.getLoginUserInfo(request, SysUser.class);
		serOrderParam.setSerOrderCreaterId(sysUser.getSysUserId());
		Integer saveCode = serOrderService.saveOrderAndBetOrderProduct(serOrderParam);
		if(saveCode > 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
	}
	
	/**
	 * 根据订单id查询一条订单及该订单所有的商品名
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "selectOrderByOrderNumber", method = RequestMethod.POST)
	public Object selectOrderByOrderNumber(String jsonStr, HttpServletRequest request ,HttpServletResponse response) throws Exception{
		SerOrder serOrder = Utils.jsonStrToObject(jsonStr, SerOrder.class);
		SerOrderResponse serOrderResponse = serOrderService.selectOrderByOrderNumber(serOrder.getSerOrderNumber());
		return ReturnUtils.forNoramlError(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS, serOrderResponse);
	}
	
	/**
	 * 根据订单号取消一条订单
	 * @param jsonStr
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "cacelOrderByOrderNumber", method = RequestMethod.POST)
	public Object cacelOrderByOrderNumber(String jsonStr) throws Exception{
		SerOrder serOrder = Utils.jsonStrToObject(jsonStr, SerOrder.class);
		serOrder.setSerOrderState(EnumConfig.SER_ORDER_STAT_CANCEL.getIndex());
		serOrderService.updateByOrderNumberSelective(serOrder);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 在订单详情中修改商品卖价
	 * @param jsonStr
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "updateProductSalePriceByOrderNumber", method = RequestMethod.POST)
	public Object updateProductSalePriceByOrderNumber(String jsonStr) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		BetOrderProduct betOrderProduct = new BetOrderProduct();
		betOrderProduct.setBetOrderProductOrderNumber(serOrderParam.getOrderNumber());
		betOrderProduct.setBetOrderProductId(serOrderParam.getBetOrderProductId());
		betOrderProduct.setBetOrderProductProductSalePrice(serOrderParam.getUpdatePrice());
		betOrderProduct.setBetOrderProductProductCount(serOrderParam.getBetOrderProductProductCount());
		betOrderProductService.updateByOrderNumberAndBetOrderProductIdSelective(betOrderProduct);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 返回枚举中所有的订单状态
	 * @return
	 */
	@RequestMapping(value = "selectOrderStates", method = RequestMethod.POST)
	public Object selectOrderStates(){
		List<Map<String, Object>> orderStates = new ArrayList<Map<String, Object>>();
		EnumConfig[] values = EnumConfig.values();
		Map<String, Object> firstMap = new HashMap<String, Object>();
		firstMap.put("key", null);
		firstMap.put("value", "全部");
		orderStates.add(firstMap);
		for (int i = 0; i < values.length; i++) {
			if(values[i].getGroup().equals(Constant.SER_ORDER_STATE)){
				Map<String, Object> stateMap = new HashMap<String, Object>();
				stateMap.put("key", values[i].getIndex());
				stateMap.put("value", values[i].getName());
				orderStates.add(stateMap);
			}
		}
		return ReturnUtils.forNoramlError(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS, orderStates);
	}
	
	/**
	 * 返回枚举中所有的订单类型
	 * @return
	 */
	@RequestMapping(value = "selectOrderTypes", method = RequestMethod.POST)
	public Object selectOrderTypes(){
		List<Map<String, Object>> orderTypes = new ArrayList<Map<String, Object>>();
		EnumConfig[] values = EnumConfig.values();
		Map<String, Object> firstMap = new HashMap<String, Object>();
		firstMap.put("key", null);
		firstMap.put("value", "全部");
		orderTypes.add(firstMap);
		for (int i = 0; i < values.length; i++) {
			if(values[i].getGroup().equals(Constant.SER_ORDER_TYPE)){
				Map<String, Object> typeMap = new HashMap<String, Object>();
				typeMap.put("key", values[i].getIndex());
				typeMap.put("value", values[i].getName());
				orderTypes.add(typeMap);
			}
		}
		return ReturnUtils.forNoramlError(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS, orderTypes);
	}
	
	/**
	 * 完成订单
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "completeOrder", method = RequestMethod.POST)
	public Object completeOrder(String jsonStr) throws Exception{
		SerOrder serOrder = Utils.jsonStrToObject(jsonStr, SerOrder.class);
		serOrder.setSerOrderState(EnumConfig.SER_ORDER_STAT_COMPLETION_OF_DISTRIBUTION.getIndex());
		serOrderService.updateByOrderNumberSelective(serOrder);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 统一修改多条订单的商品价格的列表查询
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "updateManyOrderProductPriceForSelectList", method = RequestMethod.POST)
	public Object updateManyOrderProductPriceForSelectList(String jsonStr) throws Exception{
		SerOrderQuery serOrderQuery = Utils.jsonStrToObject(jsonStr, SerOrderQuery.class);
		return ReturnUtils.forNoramlError(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS, 
				betOrderProductService.selectProductsForUnifyUpdateOrder(serOrderQuery));
	}
	
	/**
	 * 统一修改多条订单某些商品卖价
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateProductSalePrice", method = RequestMethod.POST)
	public Object updateProductSalePrice(String jsonStr) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		betOrderProductService.updateProductSalePrice(serOrderParam);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 多条订单多个商品统一修改多个商品价格
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "updateProductPriceForProductsAndOrders", method = RequestMethod.POST)
	public Object updateProductPriceForProductsAndOrders(String jsonStr) throws Exception{
		return betOrderProductService.updateProductPriceForProductsAndOrders(Utils.jsonStrToObject(jsonStr, SerOrderParam.class));
	}
	
	/**
	 * 多个订单打印详情
	 * @param jsonStr
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "readOrderDetailsListForStamp", method = RequestMethod.POST)
	public Object readOrderDetailsListForStamp(String jsonStr) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		return ReturnUtils.forNoramlError(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS
				, serOrderService.readOrderDetailsListForStamp(serOrderParam));
	}
	
	/**
	 * 单条订单打印详情
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "readOrderDetailsForStamp", method = RequestMethod.POST)
	public Object readOrderDetailsForStamp(String jsonStr) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		return ReturnUtils.forNoramlError(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS
				, serOrderService.readOrderDetailsForStamp(serOrderParam));
	}
	
	/**
	 * 一条订单中统一修改里面的商品价格和数量
	 * @param jsonStr
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "unifiedUpdateProductSalePriceForOneOrder", method = RequestMethod.POST)
	public Object unifiedUpdateProductSalePriceForOneOrder(String jsonStr) throws Exception{
		return serOrderService.unifiedUpdateProductSalePriceForOneOrder(Utils.jsonStrToObject(jsonStr, SerOrderParam.class));
	}
	
	/**
	 * 删除订单中的商品
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "deleteProductForOrder", method = RequestMethod.POST)
	public Object deleteProductForOrder(String betOrderProductId) throws Exception{
		BetOrderProduct betOrderProduct = betOrderProductService.selectByPrimaryKey(betOrderProductId);
		betOrderProductService.deleteByPrimaryKey(betOrderProductId);
		serOrderService.updateOrderTotalAmount(betOrderProduct.getBetOrderProductOrderNumber());
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 订单详情中增加商品
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "insertProductForOrderDetails", method = RequestMethod.POST)
	public Object insertProductForOrderDetails(String jsonStr) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		betOrderProductService.insertProductForOrderDetails(serOrderParam);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 添加一条模板订单
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "saveTempSerOrder", method = RequestMethod.POST) 
	public Object saveTempSerOrder(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		SysUser sysUser = Utils.getLoginUserInfo(request, SysUser.class);
		serOrderParam.setSerOrderCreaterId(sysUser.getSysUserId());
		Integer saveCode = serOrderService.saveTempOrderAndBetOrderProduct(serOrderParam);
		if(saveCode > 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
	}
	
	/**
	 * 判断该门店模板订单是否存在
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "judgeTempIsExist", method = RequestMethod.POST)
	public Object judgeTempIsExist(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		SerOrder serOrder = serOrderService.selectMemoryOrderForCustomer(serOrderParam.getSerOrderCustomerId());
		if(serOrder == null){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_STATE_SUCCESS);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, serOrder.getSerOrderNumber());
	}
	
	/**
	 * 修改模板订单的商品种类和数量
	 * @param jsonStr
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "updateSerTempOrder", method = RequestMethod.POST)
	public Object updateSerTempOrder(String jsonStr) throws Exception{
		return serOrderService.updateSerTempOrder(Utils.jsonStrToObject(jsonStr, SerOrderParam.class));
	}
	
	/**
	 * 模板订单详情中增加商品
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "insertProductForTempOrder", method = RequestMethod.POST)
	public Object insertProductForTempOrder(String jsonStr) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		betOrderProductService.insertProductForOrderDetails(serOrderParam);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
}
