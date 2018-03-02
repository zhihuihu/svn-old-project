package com.vieagr.distribution.dao;

import java.util.List;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SysCustomer;
import com.vieagr.distribution.param.SysCustomerParam;

public interface SysCustomerDao extends IBaseDao<SysCustomer> {

	/**
	 * @Title: selectCustomerListByLike 
	 * @Description:     客户列表通过like语句查询
	 * @param sysCustomer
	 * @return
	 * @throws Exception   
	 * @return List<SysCustomer>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 下午2:53:28
	 */
	List<SysCustomer> selectCustomerListByLike(SysCustomer sysCustomer) throws Exception;
	
	/**
	 * 查询顾客按照订单数目排序
	 * @param sysCustomer
	 * @return
	 * @throws Exception
	 */
	List<SysCustomer> selectCustomerOrderByOrderTotal(SysCustomer sysCustomer) throws Exception;
	
	/**
	 * 获取顾客总数
	 * @return
	 */
	Integer selectCustomerCount();
	
	/**
	 * 根据分组id查询顾客列表
	 * @param sysCustomerParam
	 * @return
	 */
	List<SysCustomer> selectCustomerForCustomerGroup(SysCustomerParam sysCustomerParam);
	
	/**
	 * 根据分组id查询已拥有的顾客数量
	 * @param sysCustomerGroupId
	 * @return
	 */
	Integer selectCustomerCountByCustomerGroupId(String sysCustomerGroupId);
	
}