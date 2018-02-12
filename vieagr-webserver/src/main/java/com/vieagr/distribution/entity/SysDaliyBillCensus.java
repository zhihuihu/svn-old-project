package com.vieagr.distribution.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SysDaliyBillCensus implements Serializable {
    /**
     * 日统计账单主键id
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_id
     */
    private String sysDaliyBillCensusId;

    /**
     * 日统计账单表类型，1、普通订单，2、员工餐订单
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_order_type
     */
    private Integer sysDaliyBillCensusOrderType;

    /**
     * 日统计订单业务类型，1、总统计、2客户统计
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_service_type
     */
    private Integer sysDaliyBillCensusServiceType;

    /**
     * 日统计账单客户id
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_customer_id
     */
    private String sysDaliyBillCensusCustomerId;

    /**
     * 日统计账单卖价总计
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_sale_amount
     */
    private BigDecimal sysDaliyBillCensusSaleAmount;

    /**
     * 日统计账单成本统计
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_bid_amount
     */
    private BigDecimal sysDaliyBillCensusBidAmount;

    /**
     * 日统计账单利润总计
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_profit_amount
     */
    private BigDecimal sysDaliyBillCensusProfitAmount;

    /**
     * 日统计账单订单数量
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_order_count
     */
    private Integer sysDaliyBillCensusOrderCount;

    /**
     * 日统计账单统计的日期，此处用字符串年月日
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_date
     */
    private String sysDaliyBillCensusDate;

    /**
     * 日统计账单创建时间
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_create_time
     */
    private String sysDaliyBillCensusCreateTime;

    /**
     * 日统计账单修改时间
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_update_time
     */
    private Date sysDaliyBillCensusUpdateTime;

    /**
     * 日统计账单状态,1、有效，2、无效
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_state
     */
    private Integer sysDaliyBillCensusState;

    /**
     * 日统计账单删除标记，1、未删除，2、已删除
     * 表字段 : sys_daliy_bill_census.sys_daliy_bill_census_del_flag
     */
    private Integer sysDaliyBillCensusDelFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_daliy_bill_census
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    public String getSysDaliyBillCensusId() {
        return sysDaliyBillCensusId;
    }

    public void setSysDaliyBillCensusId(String sysDaliyBillCensusId) {
        this.sysDaliyBillCensusId = sysDaliyBillCensusId == null ? null : sysDaliyBillCensusId.trim();
    }

    public Integer getSysDaliyBillCensusOrderType() {
        return sysDaliyBillCensusOrderType;
    }

    public void setSysDaliyBillCensusOrderType(Integer sysDaliyBillCensusOrderType) {
        this.sysDaliyBillCensusOrderType = sysDaliyBillCensusOrderType;
    }

    public Integer getSysDaliyBillCensusServiceType() {
        return sysDaliyBillCensusServiceType;
    }

    public void setSysDaliyBillCensusServiceType(Integer sysDaliyBillCensusServiceType) {
        this.sysDaliyBillCensusServiceType = sysDaliyBillCensusServiceType;
    }

    public String getSysDaliyBillCensusCustomerId() {
        return sysDaliyBillCensusCustomerId;
    }

    public void setSysDaliyBillCensusCustomerId(String sysDaliyBillCensusCustomerId) {
        this.sysDaliyBillCensusCustomerId = sysDaliyBillCensusCustomerId == null ? null : sysDaliyBillCensusCustomerId.trim();
    }

    public BigDecimal getSysDaliyBillCensusSaleAmount() {
        return sysDaliyBillCensusSaleAmount;
    }

    public void setSysDaliyBillCensusSaleAmount(BigDecimal sysDaliyBillCensusSaleAmount) {
        this.sysDaliyBillCensusSaleAmount = sysDaliyBillCensusSaleAmount;
    }

    public BigDecimal getSysDaliyBillCensusBidAmount() {
        return sysDaliyBillCensusBidAmount;
    }

    public void setSysDaliyBillCensusBidAmount(BigDecimal sysDaliyBillCensusBidAmount) {
        this.sysDaliyBillCensusBidAmount = sysDaliyBillCensusBidAmount;
    }

    public BigDecimal getSysDaliyBillCensusProfitAmount() {
        return sysDaliyBillCensusProfitAmount;
    }

    public void setSysDaliyBillCensusProfitAmount(BigDecimal sysDaliyBillCensusProfitAmount) {
        this.sysDaliyBillCensusProfitAmount = sysDaliyBillCensusProfitAmount;
    }

    public Integer getSysDaliyBillCensusOrderCount() {
        return sysDaliyBillCensusOrderCount;
    }

    public void setSysDaliyBillCensusOrderCount(Integer sysDaliyBillCensusOrderCount) {
        this.sysDaliyBillCensusOrderCount = sysDaliyBillCensusOrderCount;
    }

    public String getSysDaliyBillCensusDate() {
        return sysDaliyBillCensusDate;
    }

    public void setSysDaliyBillCensusDate(String sysDaliyBillCensusDate) {
        this.sysDaliyBillCensusDate = sysDaliyBillCensusDate == null ? null : sysDaliyBillCensusDate.trim();
    }

    public String getSysDaliyBillCensusCreateTime() {
        return sysDaliyBillCensusCreateTime;
    }

    public void setSysDaliyBillCensusCreateTime(String sysDaliyBillCensusCreateTime) {
        this.sysDaliyBillCensusCreateTime = sysDaliyBillCensusCreateTime == null ? null : sysDaliyBillCensusCreateTime.trim();
    }

    public Date getSysDaliyBillCensusUpdateTime() {
        return sysDaliyBillCensusUpdateTime;
    }

    public void setSysDaliyBillCensusUpdateTime(Date sysDaliyBillCensusUpdateTime) {
        this.sysDaliyBillCensusUpdateTime = sysDaliyBillCensusUpdateTime;
    }

    public Integer getSysDaliyBillCensusState() {
        return sysDaliyBillCensusState;
    }

    public void setSysDaliyBillCensusState(Integer sysDaliyBillCensusState) {
        this.sysDaliyBillCensusState = sysDaliyBillCensusState;
    }

    public Integer getSysDaliyBillCensusDelFlag() {
        return sysDaliyBillCensusDelFlag;
    }

    public void setSysDaliyBillCensusDelFlag(Integer sysDaliyBillCensusDelFlag) {
        this.sysDaliyBillCensusDelFlag = sysDaliyBillCensusDelFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sysDaliyBillCensusId=").append(sysDaliyBillCensusId);
        sb.append(", sysDaliyBillCensusOrderType=").append(sysDaliyBillCensusOrderType);
        sb.append(", sysDaliyBillCensusServiceType=").append(sysDaliyBillCensusServiceType);
        sb.append(", sysDaliyBillCensusCustomerId=").append(sysDaliyBillCensusCustomerId);
        sb.append(", sysDaliyBillCensusSaleAmount=").append(sysDaliyBillCensusSaleAmount);
        sb.append(", sysDaliyBillCensusBidAmount=").append(sysDaliyBillCensusBidAmount);
        sb.append(", sysDaliyBillCensusProfitAmount=").append(sysDaliyBillCensusProfitAmount);
        sb.append(", sysDaliyBillCensusOrderCount=").append(sysDaliyBillCensusOrderCount);
        sb.append(", sysDaliyBillCensusDate=").append(sysDaliyBillCensusDate);
        sb.append(", sysDaliyBillCensusCreateTime=").append(sysDaliyBillCensusCreateTime);
        sb.append(", sysDaliyBillCensusUpdateTime=").append(sysDaliyBillCensusUpdateTime);
        sb.append(", sysDaliyBillCensusState=").append(sysDaliyBillCensusState);
        sb.append(", sysDaliyBillCensusDelFlag=").append(sysDaliyBillCensusDelFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}