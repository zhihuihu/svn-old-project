package com.vieagr.distribution.query;

import com.vieagr.distribution.query.base.BaseQuery;

/**
 * 商品查询对象
 * @author master
 *
 */
public class SysProductQuery extends BaseQuery{

	private static final long serialVersionUID = -1405505380541759081L;

	/**
	 * 订单号
	 */
	private String orderNumber;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
