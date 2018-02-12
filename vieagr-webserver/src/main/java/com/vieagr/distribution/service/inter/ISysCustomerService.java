package com.vieagr.distribution.service.inter;

import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.entity.SysCustomer;
import com.vieagr.distribution.entity.SysCustomerGroup;
import com.vieagr.distribution.param.SysCustomerParam;
import com.vieagr.distribution.query.SysCustomerGroupProductQuery;
import com.vieagr.distribution.query.SysCustomerQuery;
import com.vieagr.distribution.query.SysCustomerSaveQuery;
import com.vieagr.distribution.service.base.IBaseService;

/**
 * 客户业务
 * @author master
 *
 */
public interface ISysCustomerService extends IBaseService<SysCustomer>{
	
	/**
	 * 分页查询客户，Query对象接收
	 * @param deliveryQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectCustomerList(SysCustomerQuery customerQuery) throws Exception;
	
	/**
	 * 分页查询客户，Entity对象接收
	 * @param deliveryQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectCustomerList(SysCustomer sysCustomer) throws Exception;
	
	/**
	 * @Title: sysCustomerAdd 
	 * @Description:     添加一个客户
	 * @param sysCustomer
	 * @return
	 * @throws Exception   
	 * @return ReturnUtils    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 上午10:59:47
	 */
	ReturnUtils sysCustomerAdd(SysCustomerSaveQuery sysCustomerSaveQuery) throws Exception;
	
	/**
	 * @Title: selectCustomerDetailList 
	 * @Description:     客户列表查询
	 * @param sysCustomer
	 * @return
	 * @throws Exception   
	 * @return ReturnUtils    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 下午2:51:25
	 */
	ReturnUtils selectCustomerDetailList(SysCustomer sysCustomer) throws Exception;
	
	/**
	 * @Title: selectCustomerDetailByPrimaryKey 
	 * @Description:     通过主键查询客户信息
	 * @param sysCustomer
	 * @return
	 * @throws Exception   
	 * @return ReturnUtils    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 下午3:05:34
	 */
	ReturnUtils selectCustomerDetailByPrimaryKey(SysCustomer sysCustomer) throws Exception;
	
	/**
	 * @Title: updateSysCustomer 
	 * @Description:     更新客户信息
	 * @param sysCustomerSaveQuery
	 * @return
	 * @throws Exception   
	 * @return ReturnUtils    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 下午3:24:27
	 */
	ReturnUtils updateSysCustomer(SysCustomerSaveQuery sysCustomerSaveQuery) throws Exception;
	
	/**
	 * 查询客户信息按照订单数目排序
	 * @param sysCustomer
	 * @return
	 * @throws Exception
	 */
	ReturnUtils selectCustomerOrderByOrderTotal(SysCustomer sysCustomer) throws Exception;
	
	/**
	 * 添加顾客分组信息
	 * @param sysCustomerParam
	 * @return
	 * @throws Exception
	 */
	ReturnUtils insertCustomerGroup(SysCustomerParam sysCustomerParam) throws Exception;
	
	/**
	 * 添加顾客信息至顾客分组中
	 * 	
	 * @return
	 * @throws Exception
	 */
	ReturnUtils insertCustomerIdToCustomerGroup(SysCustomerParam sysCustomerParam) throws Exception;
	
	/**
	 * 修改顾客分组信息
	 * @param sysCustomerGroup
	 * @return
	 * @throws Exception
	 */
	ReturnUtils updateCustomerGroupById(SysCustomerParam sysCustomerParam) throws Exception;
	
	/**
	 * 根据顾客分组信息修改关联表顾客信息
	 * @param sysCustomerParam
	 * @return
	 * @throws Exception
	 */
	ReturnUtils updateCustomerIdByCustomerGroupId(SysCustomerParam sysCustomerParam) throws Exception;
	
	/**
	 * 添加顾客分组商品模板信息
	 * @param sysCustomerParam
	 * @return
	 * @throws Exception
	 */
	ReturnUtils insertCustomerGroupProduct(SysCustomerParam sysCustomerParam) throws Exception;
	
	/**
	 * 分页查询顾客列表，
	 * 并添加是否加入顾客分组的标识
	 * @param customerQuery
	 * @return
	 * @throws Exception
	 */
	ReturnUtils selectCustomerForInsertCustomerGroup(SysCustomerQuery sysCustomerQuery) throws Exception;
	
	/**
	 * 查询顾客分组列表
	 * @param sysCustomerGroup
	 * @return
	 */
	ReturnUtils selectSysCustomerGroupList(SysCustomerGroup sysCustomerGroup) throws Exception;
	
	/**
	 * 根据分组id查询模板商品列表
	 * @param sysCustomerGroupProduct
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectCustomerGroupProductByCustomerGroupId(SysCustomerGroupProductQuery 
			sysCustomerGroupProductQuery) throws Exception;
	
	/**
	 * 修改模板商品中的员工餐卖价和普通卖价
	 * @param sysCustomerParam
	 * @return
	 * @throws Exception
	 */
	ReturnUtils flushSysCcustomerGroupProductStaffPriceAndOrdinaryPrice(
			SysCustomerParam sysCustomerParam) throws Exception;
}
