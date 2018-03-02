package com.vieagr.distribution.response;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.response.base.BaseReponse;

/**
 * 订单返回对象
 * @author master
 *
 */
public class SerOrderResponse extends BaseReponse{

	private static final long serialVersionUID = -2142134719803707456L;

	/**
	 * 商品总数
	 */
	private Integer productCount;
	/**
	 * 订单总价
	 */
	private BigDecimal orderTotalPrice;
	/**
	 * 订单详情
	 */
	private SerOrder serOrder;
	/**
	 * 顾客名字
	 */
	private String customerName;
	
	/**
	 * 送货日期
	 */
	private String sendTime;
	/**
	 * excel的文件输入流
	 */
	private InputStream excelInputStream;
	
	public InputStream getExcelInputStream() {
		return excelInputStream;
	}
	public void setExcelInputStream(InputStream excelInputStream) {
		this.excelInputStream = excelInputStream;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	private List<BetOrderProduct> products = new ArrayList<BetOrderProduct>();
	
	public SerOrder getSerOrder() {
		return serOrder;
	}
	public void setSerOrder(SerOrder serOrder) {
		this.serOrder = serOrder;
	}
	public List<BetOrderProduct> getProducts() {
		return products;
	}
	public void setProducts(List<BetOrderProduct> products) {
		this.products = products;
	}
	public Integer getProductCount() {
		return productCount;
	}
	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}
	public BigDecimal getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
	
}
