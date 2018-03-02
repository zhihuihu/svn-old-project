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
	/**
	 * 订单id
	 */
	private String serOrderId;
	/**
  	 * 商品id
	 */
	private String productId;
	
	public String getSerOrderId() {
		return serOrderId;
	}

	public void setSerOrderId(String serOrderId) {
		this.serOrderId = serOrderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
