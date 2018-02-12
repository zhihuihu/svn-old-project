package com.vieagr.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SysCustomer;
import com.vieagr.distribution.entity.SysCustomerGroup;
import com.vieagr.distribution.param.SysCustomerParam;
import com.vieagr.distribution.query.SysCustomerGroupProductQuery;
import com.vieagr.distribution.query.SysCustomerQuery;
import com.vieagr.distribution.query.SysCustomerSaveQuery;
import com.vieagr.distribution.service.inter.ISysCustomerService;

/**
 * 客户控制层
 * @author master
 *
 */
@RestController
@RequestMapping(value = "sysCustomer")
public class SysCustomerController {
	
	@Autowired
	private ISysCustomerService sysCustomerService;
	
	/**
	 * @Title: sysCustomerAdd 
	 * @Description:     添加一个客户
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 上午10:57:39
	 */
	@RequestMapping(value="sysCustomerAdd",method=RequestMethod.POST)
	public Object sysCustomerAdd(String jsonStr) throws Exception{
		SysCustomerSaveQuery sysCustomerSaveQuery = Utils.jsonStrToObject(jsonStr, SysCustomerSaveQuery.class);
		return sysCustomerService.sysCustomerAdd(sysCustomerSaveQuery);
	}
	
	/**
	 * @Title: selectSysCustomerList 
	 * @Description:     列表查询
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 上午11:51:26
	 */
	@RequestMapping(value="selectSysCustomerList",method=RequestMethod.POST)
	public Object selectSysCustomerList(String jsonStr) throws Exception{
		SysCustomer sysCustomer = Utils.jsonStrToObject(jsonStr, SysCustomer.class);
		return sysCustomerService.selectCustomerDetailList(sysCustomer);
	}
	
	/**
	 * @Title: selectByPrimaryKey 
	 * @Description:     通过主键查询
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 上午11:51:57
	 */
	@RequestMapping(value="selectByPrimaryKey",method=RequestMethod.POST)
	public Object selectByPrimaryKey(String sysCustomerId) throws Exception{
		SysCustomer sysCustomer = new SysCustomer();
		sysCustomer.setSysCustomerId(sysCustomerId);
		return sysCustomerService.selectCustomerDetailByPrimaryKey(sysCustomer);
	}
	
	/**
	 * @Title: updateSysCustomerState 
	 * @Description:     启用禁用状态修改
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 上午11:52:39
	 */
	@RequestMapping(value="updateSysCustomerState",method=RequestMethod.POST)
	public Object updateSysCustomerState(String jsonStr) throws Exception{
		SysCustomer sysCustomer = Utils.jsonStrToObject(jsonStr, SysCustomer.class);
		SysCustomer sysCustomerCheck = sysCustomerService.selectByPrimaryKey(sysCustomer.getSysCustomerId());
		String msg = "";
		if(sysCustomerCheck.getSysCustomerState().equals(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex())){//禁用
			sysCustomer.setSysCustomerState(EnumConfig.SYSTEM_UNIFIED_STATE_END_USING.getIndex());
			msg = Constant.SYS_CUSTOMER_STATE_END;
		}else{//启用
			sysCustomer.setSysCustomerState(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex());
			msg = Constant.SYS_CUSTOMER_STATE_START;
		}
		int flg = sysCustomerService.updateByPrimaryKeySelective(sysCustomer);
		if(flg <= 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, msg);
	}
	
	/**
	 * @Title: updateSysCustomer 
	 * @Description:     修改客户信息
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 上午11:53:10
	 */
	@RequestMapping(value="updateSysCustomer",method=RequestMethod.POST)
	public Object updateSysCustomer(String jsonStr) throws Exception{
		SysCustomerSaveQuery sysCustomerSaveQuery = Utils.jsonStrToObject(jsonStr, SysCustomerSaveQuery.class);
		return sysCustomerService.updateSysCustomer(sysCustomerSaveQuery);
	}
	
	/**
	 * 查询顾客列表，按照订单数目排序
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "selectCustomerOrderByOrderTotal", method=RequestMethod.POST)
	public Object selectCustomerOrderByOrderTotal(String jsonStr) throws Exception{
		SysCustomer sysCustomer = Utils.jsonStrToObject(jsonStr, SysCustomer.class);
		return sysCustomerService.selectCustomerOrderByOrderTotal(sysCustomer);
	}
	
	/**
	 * 查询顾客分组列表
	 * @param jsonStr
	 * @return
	 */
	@RequestMapping(value = "selectSysCustomerGroupList", method=RequestMethod.POST)
	public Object selectSysCustomerGroupList(String jsonStr) throws Exception{
		return sysCustomerService.selectSysCustomerGroupList(Utils.jsonStrToObject(jsonStr, SysCustomerGroup.class));
	}
	
	/**
	 * 根据分组id查询顾客列表
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "selectCustomerForInsertCustomerGroup", method=RequestMethod.POST)
	public Object selectCustomerForInsertCustomerGroup(String jsonStr) throws Exception{
		return sysCustomerService.selectCustomerForInsertCustomerGroup(Utils.jsonStrToObject(
				jsonStr, SysCustomerQuery.class));
	}
	
	/**
	 * 添加顾客分组
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "insertCustomerGroup",method = RequestMethod.POST)
	public Object insertCustomerGroup(String jsonStr) throws Exception{
		return sysCustomerService.insertCustomerGroup(Utils.jsonStrToObject(jsonStr, SysCustomerParam.class));
	}
	
	/**
	 * 根据顾客分组id添加顾客分组关联信息
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "insertCustomerIdByCustomerGroupId",method = RequestMethod.POST)
	public Object insertCustomerIdByCustomerGroupId(String jsonStr) throws Exception{
		return sysCustomerService.insertCustomerIdToCustomerGroup(Utils.jsonStrToObject(jsonStr, SysCustomerParam.class));
	}
	
	/**
	 * 修改顾客分组信息
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateCustomerGroupById",method = RequestMethod.POST)
	public Object updateCustomerGroupById(String jsonStr) throws Exception{
		return sysCustomerService.updateCustomerGroupById(Utils.jsonStrToObject(jsonStr, SysCustomerParam.class));
	}
	
	/**
	 * 根据顾客分组id修改顾客与顾客分组关联信息
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateCustomerIdByCustomerGroupId",method = RequestMethod.POST)
	public Object updateCustomerIdByCustomerGroupId(String jsonStr) throws Exception{
		return sysCustomerService.updateCustomerIdByCustomerGroupId(Utils.jsonStrToObject(jsonStr, SysCustomerParam.class));
	}
	
	/**
	 * 添加顾客分组的商品模板信息
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "insertCustomerGroupProduct", method = RequestMethod.POST)
	public Object insertOrUpdateCustomerGroupTemplateProductInfo(String jsonStr) throws Exception{
		return sysCustomerService.insertCustomerGroupProduct(
				Utils.jsonStrToObject(jsonStr, SysCustomerParam.class));
	}
	
	/**
	 * 根据分组id查询模板商品列表
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "selectCustomerGroupProductByCustomerGroupId", method = RequestMethod.POST)
	public Object selectCustomerGroupProductByCustomerGroupId(String jsonStr) throws Exception{
		return sysCustomerService.selectCustomerGroupProductByCustomerGroupId(
				Utils.jsonStrToObject(jsonStr, SysCustomerGroupProductQuery.class));
	}
	
	/**
	 * 修改模板商品的员工餐卖价和普通卖价
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "flushSysCcustomerGroupProductStaffPriceAndOrdinaryPrice", method = RequestMethod.POST)
	public Object flushSysCcustomerGroupProductStaffPriceAndOrdinaryPrice(String jsonStr) throws Exception{
		return sysCustomerService.flushSysCcustomerGroupProductStaffPriceAndOrdinaryPrice(
				Utils.jsonStrToObject(jsonStr, SysCustomerParam.class));
	}
	
}
