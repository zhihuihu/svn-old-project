package com.vieagr.distribution.entity;

import java.util.Date;

import com.vieagr.distribution.entity.base.BaseEntity;

/**
 * 客户信息
 * @author master
 *
 */
public class SysCustomer extends BaseEntity {
    /**
     * 客户主键
     * 表字段 : sys_customer.sys_customer_id
     */
    private String sysCustomerId;

    /**
     * 客户用户名
     * 表字段 : sys_customer.sys_customer_name
     */
    private String sysCustomerName;

    /**
     * 客户性别，1、男，2、女
     * 表字段 : sys_customer.sys_customer_sex
     */
    private Integer sysCustomerSex;

    /**
     * 客户年龄
     * 表字段 : sys_customer.sys_customer_age
     */
    private Integer sysCustomerAge;

    /**
     * 客户真实姓名
     * 表字段 : sys_customer.sys_customer_real_name
     */
    private String sysCustomerRealName;

    /**
     * 客户手机号
     * 表字段 : sys_customer.sys_customer_mobile_number
     */
    private String sysCustomerMobileNumber;

    /**
     * 客户QQ号码
     * 表字段 : sys_customer.sys_customer_qq_number
     */
    private String sysCustomerQqNumber;

    /**
     * 客户邮箱
     * 表字段 : sys_customer.sys_customer_email
     */
    private String sysCustomerEmail;

    /**
     * 客户头像地址
     * 表字段 : sys_customer.sys_customer_img_url
     */
    private String sysCustomerImgUrl;

    /**
     * 客户门店名
     * 表字段 : sys_customer.sys_customer_store_name
     */
    private String sysCustomerStoreName;

    /**
     * 客户门店地址
     * 表字段 : sys_customer.sys_customer_store_address
     */
    private String sysCustomerStoreAddress;

    /**
     * 客户类型，1、普通客户，2、VIP用户
     * 表字段 : sys_customer.sys_customer_type
     */
    private Integer sysCustomerType;

    /**
     * 客户等级，1、小型买家客户，2中型买家客户，3、大型买家客户
     * 表字段 : sys_customer.sys_customer_grade
     */
    private Integer sysCustomerGrade;

    /**
     * 客户状态，1、启用，2、禁用
     * 表字段 : sys_customer.sys_customer_state
     */
    private Integer sysCustomerState;

    /**
     * 创建时间
     * 表字段 : sys_customer.sys_customer_create_time
     */
    private String sysCustomerCreateTime;

    /**
     * 更新时间
     * 表字段 : sys_customer.sys_customer_update_time
     */
    private Date sysCustomerUpdateTime;

    /**
     * 客户删除标记，1、未删除，2已删除
     * 表字段 : sys_customer.sys_customer_del_flag
     */
    private Integer sysCustomerDelFlag;

    /**
     * 顾客分组id
     */
    private String sysCustomerGroupId;

    /**
     * 顾客分组名称
     */
    private String sysCustomerGroupName;
    	
    /**
     * 被选择类型，1、未被选择，2、被所选分组选择，
     * 3、被其他分组选择
     */
    private Integer isChangedType;
    
    public Integer getIsChangedType() {
		return isChangedType;
	}

	public void setIsChangedType(Integer isChangedType) {
		this.isChangedType = isChangedType;
	}

	public String getSysCustomerGroupName() {
		return sysCustomerGroupName;
	}

	public void setSysCustomerGroupName(String sysCustomerGroupName) {
		this.sysCustomerGroupName = sysCustomerGroupName;
	}

	public String getSysCustomerGroupId() {
		return sysCustomerGroupId;
	}

	public void setSysCustomerGroupId(String sysCustomerGroupId) {
		this.sysCustomerGroupId = sysCustomerGroupId;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_customer
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    public String getSysCustomerId() {
        return sysCustomerId;
    }

    public void setSysCustomerId(String sysCustomerId) {
        this.sysCustomerId = sysCustomerId == null ? null : sysCustomerId.trim();
    }

    public String getSysCustomerName() {
        return sysCustomerName;
    }

    public void setSysCustomerName(String sysCustomerName) {
        this.sysCustomerName = sysCustomerName == null ? null : sysCustomerName.trim();
    }

    public Integer getSysCustomerSex() {
        return sysCustomerSex;
    }

    public void setSysCustomerSex(Integer sysCustomerSex) {
        this.sysCustomerSex = sysCustomerSex;
    }

    public Integer getSysCustomerAge() {
        return sysCustomerAge;
    }

    public void setSysCustomerAge(Integer sysCustomerAge) {
        this.sysCustomerAge = sysCustomerAge;
    }

    public String getSysCustomerRealName() {
        return sysCustomerRealName;
    }

    public void setSysCustomerRealName(String sysCustomerRealName) {
        this.sysCustomerRealName = sysCustomerRealName == null ? null : sysCustomerRealName.trim();
    }

    public String getSysCustomerMobileNumber() {
        return sysCustomerMobileNumber;
    }

    public void setSysCustomerMobileNumber(String sysCustomerMobileNumber) {
        this.sysCustomerMobileNumber = sysCustomerMobileNumber == null ? null : sysCustomerMobileNumber.trim();
    }

    public String getSysCustomerQqNumber() {
        return sysCustomerQqNumber;
    }

    public void setSysCustomerQqNumber(String sysCustomerQqNumber) {
        this.sysCustomerQqNumber = sysCustomerQqNumber == null ? null : sysCustomerQqNumber.trim();
    }

    public String getSysCustomerEmail() {
        return sysCustomerEmail;
    }

    public void setSysCustomerEmail(String sysCustomerEmail) {
        this.sysCustomerEmail = sysCustomerEmail == null ? null : sysCustomerEmail.trim();
    }

    public String getSysCustomerImgUrl() {
        return sysCustomerImgUrl;
    }

    public void setSysCustomerImgUrl(String sysCustomerImgUrl) {
        this.sysCustomerImgUrl = sysCustomerImgUrl == null ? null : sysCustomerImgUrl.trim();
    }

    public String getSysCustomerStoreName() {
        return sysCustomerStoreName;
    }

    public void setSysCustomerStoreName(String sysCustomerStoreName) {
        this.sysCustomerStoreName = sysCustomerStoreName == null ? null : sysCustomerStoreName.trim();
    }

    public String getSysCustomerStoreAddress() {
        return sysCustomerStoreAddress;
    }

    public void setSysCustomerStoreAddress(String sysCustomerStoreAddress) {
        this.sysCustomerStoreAddress = sysCustomerStoreAddress == null ? null : sysCustomerStoreAddress.trim();
    }

    public Integer getSysCustomerType() {
        return sysCustomerType;
    }

    public void setSysCustomerType(Integer sysCustomerType) {
        this.sysCustomerType = sysCustomerType;
    }

    public Integer getSysCustomerGrade() {
        return sysCustomerGrade;
    }

    public void setSysCustomerGrade(Integer sysCustomerGrade) {
        this.sysCustomerGrade = sysCustomerGrade;
    }

    public Integer getSysCustomerState() {
        return sysCustomerState;
    }

    public void setSysCustomerState(Integer sysCustomerState) {
        this.sysCustomerState = sysCustomerState;
    }

    public String getSysCustomerCreateTime() {
        return sysCustomerCreateTime;
    }

    public void setSysCustomerCreateTime(String sysCustomerCreateTime) {
        this.sysCustomerCreateTime = sysCustomerCreateTime == null ? null : sysCustomerCreateTime.trim();
    }

    public Date getSysCustomerUpdateTime() {
        return sysCustomerUpdateTime;
    }

    public void setSysCustomerUpdateTime(Date sysCustomerUpdateTime) {
        this.sysCustomerUpdateTime = sysCustomerUpdateTime;
    }

    public Integer getSysCustomerDelFlag() {
        return sysCustomerDelFlag;
    }

    public void setSysCustomerDelFlag(Integer sysCustomerDelFlag) {
        this.sysCustomerDelFlag = sysCustomerDelFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sysCustomerId=").append(sysCustomerId);
        sb.append(", sysCustomerName=").append(sysCustomerName);
        sb.append(", sysCustomerSex=").append(sysCustomerSex);
        sb.append(", sysCustomerAge=").append(sysCustomerAge);
        sb.append(", sysCustomerRealName=").append(sysCustomerRealName);
        sb.append(", sysCustomerMobileNumber=").append(sysCustomerMobileNumber);
        sb.append(", sysCustomerQqNumber=").append(sysCustomerQqNumber);
        sb.append(", sysCustomerEmail=").append(sysCustomerEmail);
        sb.append(", sysCustomerImgUrl=").append(sysCustomerImgUrl);
        sb.append(", sysCustomerStoreName=").append(sysCustomerStoreName);
        sb.append(", sysCustomerStoreAddress=").append(sysCustomerStoreAddress);
        sb.append(", sysCustomerType=").append(sysCustomerType);
        sb.append(", sysCustomerGrade=").append(sysCustomerGrade);
        sb.append(", sysCustomerState=").append(sysCustomerState);
        sb.append(", sysCustomerCreateTime=").append(sysCustomerCreateTime);
        sb.append(", sysCustomerUpdateTime=").append(sysCustomerUpdateTime);
        sb.append(", sysCustomerDelFlag=").append(sysCustomerDelFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}