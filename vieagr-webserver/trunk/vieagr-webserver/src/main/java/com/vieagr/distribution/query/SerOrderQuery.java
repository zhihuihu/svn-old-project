package com.vieagr.distribution.query;

import java.util.List;

import com.vieagr.distribution.query.base.BaseQuery;

/**
 * 订单查询对象
 * @author master
 *
 */
public class SerOrderQuery extends BaseQuery{

	private static final long serialVersionUID = -4558556819988117983L;
	
	/**
	 * 订单号
	 */
	private String orderNumber;
	
	/**
	 * 订单配送时间
	 */
	private String orderSendTime;
	
	/**
	 * 客户外键
	 */
	private String customerId;
	
	/**
	 * 订单商品关联id
	 */
	private String betOrderProductId;
	
	/**
	 * 订单状态
	 */
	private Integer serOrderState;
	
	/**
	 * 订单类型
	 */
	private Integer serOrderType;
	
	 /**
     * 订单下单时间，
     */
    private String orderPlaceTime;
	
    /**
     * 订单号集合字符串
     */
    private String orderNumberArrays;
    
    /**
     * 订单号集合
     */
    private List<String> orderNumbers;
    
    /**
     * 商品id
     */
    private String sysProductId;
    
    /**
     *	导出的excel类型
     */
    private String excelType;
    
    /**
     * 送货车辆id
     */
    private String sysVehiclesId;
    
	public String getSysVehiclesId() {
		return sysVehiclesId;
	}

	public void setSysVehiclesId(String sysVehiclesId) {
		this.sysVehiclesId = sysVehiclesId;
	}

	public String getExcelType() {
		return excelType;
	}

	public void setExcelType(String excelType) {
		this.excelType = excelType;
	}

	public String getSysProductId() {
		return sysProductId;
	}

	public void setSysProductId(String sysProductId) {
		this.sysProductId = sysProductId;
	}

	public List<String> getOrderNumbers() {
		return orderNumbers;
	}

	public void setOrderNumbers(List<String> orderNumbers) {
		this.orderNumbers = orderNumbers;
	}

	public String getOrderNumberArrays() {
		return orderNumberArrays;
	}

	public void setOrderNumberArrays(String orderNumberArrays) {
		this.orderNumberArrays = orderNumberArrays;
	}

	public Integer getSerOrderState() {
		return serOrderState;
	}

	public void setSerOrderState(Integer serOrderState) {
		this.serOrderState = serOrderState;
	}

	public Integer getSerOrderType() {
		return serOrderType;
	}

	public void setSerOrderType(Integer serOrderType) {
		this.serOrderType = serOrderType;
	}

	public String getOrderPlaceTime() {
		return orderPlaceTime;
	}

	public void setOrderPlaceTime(String orderPlaceTime) {
		this.orderPlaceTime = orderPlaceTime;
	}

	public String getBetOrderProductId() {
		return betOrderProductId;
	}

	public void setBetOrderProductId(String betOrderProductId) {
		this.betOrderProductId = betOrderProductId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getOrderSendTime() {
		return orderSendTime;
	}

	public void setOrderSendTime(String orderSendTime) {
		this.orderSendTime = orderSendTime;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
}
