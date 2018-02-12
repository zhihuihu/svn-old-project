package com.vieagr.distribution.query;

import com.vieagr.distribution.query.base.BaseQuery;

public class SysCustomerGroupProductQuery extends BaseQuery{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 顾客分组id
	 */
	private String sysCustomerGroupId;
	/**
	 * 商品id
	 */
	private String sysProductId;

	/**
	 * 商品分类id
	 */
	private String sysProductTypeId; 
	
	/**
	 * 模板订单订单号
	 */
	private String orderNumber;
	
	/**
	 * 顾客id
	 */
	private String sysCustomerId;
		
	public String getSysCustomerId() {
		return sysCustomerId;
	}
	public void setSysCustomerId(String sysCustomerId) {
		this.sysCustomerId = sysCustomerId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getSysProductTypeId() {
		return sysProductTypeId;
	}
	public void setSysProductTypeId(String sysProductTypeId) {
		this.sysProductTypeId = sysProductTypeId;
	}
	public String getSysCustomerGroupId() {
		return sysCustomerGroupId;
	}
	public void setSysCustomerGroupId(String sysCustomerGroupId) {
		this.sysCustomerGroupId = sysCustomerGroupId;
	}
	public String getSysProductId() {
		return sysProductId;
	}
	public void setSysProductId(String sysProductId) {
		this.sysProductId = sysProductId;
	}
	@Override
	public String toString() {
		return "SysCustomerGroupProductQuery [sysCustomerGroupId=" + sysCustomerGroupId + ", sysProductId="
				+ sysProductId + ", sysProductTypeId=" + sysProductTypeId + "]";
	}
	
}
