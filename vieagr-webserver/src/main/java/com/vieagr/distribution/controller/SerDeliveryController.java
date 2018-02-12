package com.vieagr.distribution.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SerDelivery;
import com.vieagr.distribution.service.inter.ISerDeliveryService;

/**
 * 送货单控制层
 * @author master
 *
 */
@RestController
@RequestMapping(value = "delivery")
public class SerDeliveryController {
	
	@Autowired
	private ISerDeliveryService serDeliveryService;

	/**
	 * 送货单列表查询
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "selectSerDeliveryList", method = RequestMethod.POST)
	public Object selectSerDeliveryList(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws 
		Exception{
		SerDelivery serDelivery = Utils.jsonStrToObject(jsonStr, SerDelivery.class);
		return serDeliveryService.selectDeliveryList(serDelivery);
	}
	
	/**
	 * 根据id查询一条送货单详情
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "selectSerDeliveryById", method = RequestMethod.POST)
	public Object selectSerDeliveryById(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SerDelivery serDelivery = Utils.jsonStrToObject(jsonStr, SerDelivery.class);
		SerDelivery delivery = serDeliveryService.selectByPrimaryKey(serDelivery.getSerDeliverId());
		if(delivery != null){
			return ReturnUtils.forNoramlError(Constant.RESPONSE_MESSAGE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS, delivery);
		}
		return ReturnUtils.forNoramlError(Constant.RESPONSE_MESSAGE_ERROR, Constant.RESPONSE_MESSAGE_ERROR,null);
	}
	
	/**
	 * 根据id修改一条送货单信息
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "updateSerDeliveryById", method = RequestMethod.POST)
	public Object updateSerDeliveryById(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SerDelivery serDelivery = Utils.jsonStrToObject(jsonStr, SerDelivery.class);
		if(serDeliveryService.updateByPrimaryKeySelective(serDelivery) >= Constant.SAVE_OR_UPDATE_SUCCESS_CODE){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
	}
	
	/**
	 *	根据id逻辑删除一条送货单
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "deleteSerDeliveryById", method = RequestMethod.POST)
	public Object deleteSerDeliveryById(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SerDelivery serDelivery = Utils.jsonStrToObject(jsonStr, SerDelivery.class);
		if(serDeliveryService.deleteByPrimaryKey(serDelivery.getSerDeliverId()) >= Constant.SAVE_OR_UPDATE_SUCCESS_CODE){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
	}
	
	/**
	 * 添加一条送货单
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "saveSerDelivery", method = RequestMethod.POST)
	public Object saveSerDelivery(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SerDelivery serDelivery = Utils.jsonStrToObject(jsonStr, SerDelivery.class);
		if(serDeliveryService.insert(serDelivery) >= Constant.SAVE_OR_UPDATE_SUCCESS_CODE){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
	}
}
