package com.vieagr.distribution.param;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.param.base.BaseParam;

/**
 *	订单请求对象
 * @author master
 *
 */
public class SerOrderParam extends BaseParam{

	private static final long serialVersionUID = 7258083342802499780L;
	/**
	 * 订单类型
	 */
	private Integer serOrderType;
	/**
	 * 客户关联外键
	 */
	private String serOrderCustomerId;
	/**
	 * 订单创建人id
	 */
	private String serOrderCreaterId;
	/**
	 * 订单送货时间
	 */
	private String serOrderSendTime;
	/**
	 * 订单备注
	 */
	private String serOrderRemark;
	/**
	 * 商品列表集合
	 */
	private List<SysProduct> products = new ArrayList<SysProduct>();
	/**
	 * 订单号
	 */
	private String orderNumber;
	/**
	 * 订单关联商品id
	 */
	private String betOrderProductId;
	/**
	 * 修改价格
	 */
	private BigDecimal updatePrice;
	/**
	 * 商品数量
	 */
	private String betOrderProductProductCount;
	
	/**
	 * 商品id
	 */
	private String sysProductId;
	
	/**
	 * 订单号集合
	 */
	private List<String> orderNumbers = new ArrayList<String>();
	
	/**
	 * 订单中的商品信息集合
	 */
	private List<BetOrderProduct> betOrderProducts = new ArrayList<BetOrderProduct>();
	
	public List<BetOrderProduct> getBetOrderProducts() {
		return betOrderProducts;
	}
	public void setBetOrderProducts(List<BetOrderProduct> betOrderProducts) {
		this.betOrderProducts = betOrderProducts;
	}
	public List<String> getOrderNumbers() {
		return orderNumbers;
	}
	public void setOrderNumbers(List<String> orderNumbers) {
		this.orderNumbers = orderNumbers;
	}
	public String getSysProductId() {
		return sysProductId;
	}
	public void setSysProductId(String sysProductId) {
		this.sysProductId = sysProductId;
	}
	public String getBetOrderProductProductCount() {
		return betOrderProductProductCount;
	}
	public void setBetOrderProductProductCount(String betOrderProductProductCount) {
		this.betOrderProductProductCount = betOrderProductProductCount;
	}
	public BigDecimal getUpdatePrice() {
		return updatePrice;
	}
	public void setUpdatePrice(BigDecimal updatePrice) {
		this.updatePrice = updatePrice;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getBetOrderProductId() {
		return betOrderProductId;
	}
	public void setBetOrderProductId(String betOrderProductId) {
		this.betOrderProductId = betOrderProductId;
	}
	public Integer getSerOrderType() {
		return serOrderType;
	}
	public void setSerOrderType(Integer serOrderType) {
		this.serOrderType = serOrderType;
	}
	public String getSerOrderCustomerId() {
		return serOrderCustomerId;
	}
	public void setSerOrderCustomerId(String serOrderCustomerId) {
		this.serOrderCustomerId = serOrderCustomerId;
	}
	public String getSerOrderCreaterId() {
		return serOrderCreaterId;
	}
	public void setSerOrderCreaterId(String serOrderCreaterId) {
		this.serOrderCreaterId = serOrderCreaterId;
	}
	public String getSerOrderSendTime() {
		return serOrderSendTime;
	}
	public void setSerOrderSendTime(String serOrderSendTime) {
		this.serOrderSendTime = serOrderSendTime;
	}
	public String getSerOrderRemark() {
		return serOrderRemark;
	}
	public void setSerOrderRemark(String serOrderRemark) {
		this.serOrderRemark = serOrderRemark;
	}
	public List<SysProduct> getProducts() {
		return products;
	}
	public void setProducts(List<SysProduct> products) {
		this.products = products;
	}
	
}
