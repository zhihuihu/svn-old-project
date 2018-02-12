package com.vieagr.distribution.response;

import com.vieagr.distribution.response.base.BaseReponse;

/**
 * 首页返回结果
 * @author master
 *
 */
public class IndexResponse extends BaseReponse{

	private static final long serialVersionUID = 664885443762942397L;
	
	/**
	 * 订单总数
	 */
	private Integer orderCount;
	/**
	 * 今日下单数
	 */
	private Integer toDayOrderCount;
	/**
	 * 顾客总数
	 */
	private Integer customerCount;
	/**
	 * 商品总数
	 */
	private Integer productCount;
	public Integer getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}
	public Integer getToDayOrderCount() {
		return toDayOrderCount;
	}
	public void setToDayOrderCount(Integer toDayOrderCount) {
		this.toDayOrderCount = toDayOrderCount;
	}
	public Integer getCustomerCount() {
		return customerCount;
	}
	public void setCustomerCount(Integer customerCount) {
		this.customerCount = customerCount;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	
}
