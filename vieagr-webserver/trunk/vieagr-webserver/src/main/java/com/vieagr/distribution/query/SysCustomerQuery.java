package com.vieagr.distribution.query;

import com.vieagr.distribution.query.base.BaseQuery;

/**
 * 客户查询对象
 * @author master
 *
 */
public class SysCustomerQuery extends BaseQuery{

	private static final long serialVersionUID = 8102389984718043165L;
	
	/**
	 * 顾客分组id
	 */
	private String customerGroupId;

	public String getCustomerGroupId() {
		return customerGroupId;
	}

	public void setCustomerGroupId(String customerGroupId) {
		this.customerGroupId = customerGroupId;
	}
	
}
