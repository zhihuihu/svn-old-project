package com.vieagr.distribution.query;

import com.vieagr.distribution.query.base.BaseQuery;

public class SysBillCensusQuery extends BaseQuery{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 账单统计订单类型
	 */
	private Integer billCensusOrderType;

	/**
	 * 账单统计业务类型
	 */
	private Integer billCensusServiceType;
	
	/**
	 * 账单统计顾客主键
	 */
	private String billCensusCustomerId;

	/**
	 * 账单统计统计日期
	 */
	private String billCensusDate;
	
	public String getBillCensusDate() {
		return billCensusDate;
	}

	public void setBillCensusDate(String billCensusDate) {
		this.billCensusDate = billCensusDate;
	}

	public Integer getBillCensusOrderType() {
		return billCensusOrderType;
	}

	public void setBillCensusOrderType(Integer billCensusOrderType) {
		this.billCensusOrderType = billCensusOrderType;
	}

	public Integer getBillCensusServiceType() {
		return billCensusServiceType;
	}

	public void setBillCensusServiceType(Integer billCensusServiceType) {
		this.billCensusServiceType = billCensusServiceType;
	}

	public String getBillCensusCustomerId() {
		return billCensusCustomerId;
	}

	public void setBillCensusCustomerId(String billCensusCustomerId) {
		this.billCensusCustomerId = billCensusCustomerId;
	}
	
}
