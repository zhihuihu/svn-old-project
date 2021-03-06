package com.vieagr.distribution.entity;

import java.util.Date;

import com.vieagr.distribution.entity.base.BaseEntity;

public class BetCustomerGroup extends BaseEntity {
    /**
     * 顾客和顾客分组关联id
     * 表字段 : bet_customer_group.bet_customer_group_id
     */
    private String betCustomerGroupId;

    /**
     * 顾客和顾客分组关联顾客id
     * 表字段 : bet_customer_group.bet_customer_group_customer_id
     */
    private String betCustomerGroupCustomerId;

    /**
     * 顾客与顾客分组关联顾客分组id
     * 表字段 : bet_customer_group.bet_customer_group_customer_group_id
     */
    private String betCustomerGroupCustomerGroupId;

    /**
     * 顾客与顾客分组关联创建时间
     * 表字段 : bet_customer_group.bet_customer_group_create_time
     */
    private String betCustomerGroupCreateTime;

    /**
     * 顾客与顾客分组关联修改时间
     * 表字段 : bet_customer_group.bet_customer_group_update_time
     */
    private Date betCustomerGroupUpdateTime;

    /**
     * 顾客与顾客分组关联删除标记1、未删除，2、已删除'
     * 表字段 : bet_customer_group.bet_customer_group_del_flag
     */
    private Integer betCustomerGroupDelFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bet_customer_group
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    public String getBetCustomerGroupId() {
        return betCustomerGroupId;
    }

    public void setBetCustomerGroupId(String betCustomerGroupId) {
        this.betCustomerGroupId = betCustomerGroupId == null ? null : betCustomerGroupId.trim();
    }

    public String getBetCustomerGroupCustomerId() {
        return betCustomerGroupCustomerId;
    }

    public void setBetCustomerGroupCustomerId(String betCustomerGroupCustomerId) {
        this.betCustomerGroupCustomerId = betCustomerGroupCustomerId == null ? null : betCustomerGroupCustomerId.trim();
    }

    public String getBetCustomerGroupCustomerGroupId() {
        return betCustomerGroupCustomerGroupId;
    }

    public void setBetCustomerGroupCustomerGroupId(String betCustomerGroupCustomerGroupId) {
        this.betCustomerGroupCustomerGroupId = betCustomerGroupCustomerGroupId == null ? null : betCustomerGroupCustomerGroupId.trim();
    }

    public String getBetCustomerGroupCreateTime() {
        return betCustomerGroupCreateTime;
    }

    public void setBetCustomerGroupCreateTime(String betCustomerGroupCreateTime) {
        this.betCustomerGroupCreateTime = betCustomerGroupCreateTime == null ? null : betCustomerGroupCreateTime.trim();
    }

    public Date getBetCustomerGroupUpdateTime() {
        return betCustomerGroupUpdateTime;
    }

    public void setBetCustomerGroupUpdateTime(Date betCustomerGroupUpdateTime) {
        this.betCustomerGroupUpdateTime = betCustomerGroupUpdateTime;
    }

    public Integer getBetCustomerGroupDelFlag() {
        return betCustomerGroupDelFlag;
    }

    public void setBetCustomerGroupDelFlag(Integer betCustomerGroupDelFlag) {
        this.betCustomerGroupDelFlag = betCustomerGroupDelFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", betCustomerGroupId=").append(betCustomerGroupId);
        sb.append(", betCustomerGroupCustomerId=").append(betCustomerGroupCustomerId);
        sb.append(", betCustomerGroupCustomerGroupId=").append(betCustomerGroupCustomerGroupId);
        sb.append(", betCustomerGroupCreateTime=").append(betCustomerGroupCreateTime);
        sb.append(", betCustomerGroupUpdateTime=").append(betCustomerGroupUpdateTime);
        sb.append(", betCustomerGroupDelFlag=").append(betCustomerGroupDelFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}