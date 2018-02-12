package com.vieagr.distribution.param;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.vieagr.distribution.param.base.BaseParam;

/**
 * 商品请求对象
 * @author master
 *
 */
public class SysProductParam extends BaseParam{

	private static final long serialVersionUID = 6392232210472544702L;

	/**
	 * 商品id集合
	 */
	private List<String> sysProductIds = new ArrayList<String>();
	
	/**
	 * 商品价格集合
	 */
	private List<BigDecimal> sysProductPrices = new ArrayList<BigDecimal>();

	/**
	 * 商品员工餐进价
	 */
	private List<BigDecimal> sysProductStaffBidPrice = new ArrayList<>();
	/**
	 * 商品普通进价
	 */
	private List<BigDecimal> sysProductOrdinaryBidPrice = new ArrayList<>();
	
	public List<BigDecimal> getSysProductStaffBidPrice() {
		return sysProductStaffBidPrice;
	}

	public void setSysProductStaffBidPrice(List<BigDecimal> sysProductStaffBidPrice) {
		this.sysProductStaffBidPrice = sysProductStaffBidPrice;
	}

	public List<BigDecimal> getSysProductOrdinaryBidPrice() {
		return sysProductOrdinaryBidPrice;
	}

	public void setSysProductOrdinaryBidPrice(List<BigDecimal> sysProductOrdinaryBidPrice) {
		this.sysProductOrdinaryBidPrice = sysProductOrdinaryBidPrice;
	}

	public List<String> getSysProductIds() {
		return sysProductIds;
	}

	public void setSysProductIds(List<String> sysProductIds) {
		this.sysProductIds = sysProductIds;
	}

	public List<BigDecimal> getSysProductPrices() {
		return sysProductPrices;
	}

	public void setSysProductPrices(List<BigDecimal> sysProductPrices) {
		this.sysProductPrices = sysProductPrices;
	}
	
	
}
