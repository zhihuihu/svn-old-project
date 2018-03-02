package com.vieagr.distribution.entity;

import java.io.Serializable;

import com.vieagr.distribution.entity.base.BaseEntity;

public class SysIndex extends BaseEntity implements Serializable {
    /**
     * 主页ID
     * 表字段 : sys_index.sys_index_id
     */
    private String sysIndexId;

    /**
     * 主页名称
     * 表字段 : sys_index.sys_index_name
     */
    private String sysIndexName;

    /**
     * 主页图片URL
     * 表字段 : sys_index.sys_index_image_url
     */
    private String sysIndexImageUrl;

    /**
     * 主页图片内容
     * 表字段 : sys_index.sys_index_image_content
     */
    private String sysIndexImageContent;

    /**
     * 主页内容类型
     * 表字段 : sys_index.sys_index_type
     */
    private Integer sysIndexType;

    /**
     * 排序number
     * 表字段 : sys_index.sys_index_number
     */
    private Integer sysIndexNumber;

    /**
     * 创建时间
     * 表字段 : sys_index.sys_index_create_time
     */
    private String sysIndexCreateTime;

    /**
     * 更新时间
     * 表字段 : sys_index.sys_index_update_time
     */
    private String sysIndexUpdateTime;

    private static final long serialVersionUID = 1L;

    //非数据库字段
    /**
     * 排序字段
     */
    private String orderByString;
    
    public String getSysIndexId() {
        return sysIndexId;
    }

    public void setSysIndexId(String sysIndexId) {
        this.sysIndexId = sysIndexId == null ? null : sysIndexId.trim();
    }

    public String getSysIndexName() {
        return sysIndexName;
    }

    public void setSysIndexName(String sysIndexName) {
        this.sysIndexName = sysIndexName == null ? null : sysIndexName.trim();
    }

    public String getSysIndexImageUrl() {
        return sysIndexImageUrl;
    }

    public void setSysIndexImageUrl(String sysIndexImageUrl) {
        this.sysIndexImageUrl = sysIndexImageUrl == null ? null : sysIndexImageUrl.trim();
    }

    public String getSysIndexImageContent() {
        return sysIndexImageContent;
    }

    public void setSysIndexImageContent(String sysIndexImageContent) {
        this.sysIndexImageContent = sysIndexImageContent == null ? null : sysIndexImageContent.trim();
    }

    public Integer getSysIndexType() {
        return sysIndexType;
    }

    public void setSysIndexType(Integer sysIndexType) {
        this.sysIndexType = sysIndexType;
    }

    public Integer getSysIndexNumber() {
        return sysIndexNumber;
    }

    public void setSysIndexNumber(Integer sysIndexNumber) {
        this.sysIndexNumber = sysIndexNumber;
    }

    public String getSysIndexCreateTime() {
        return sysIndexCreateTime;
    }

    public void setSysIndexCreateTime(String sysIndexCreateTime) {
        this.sysIndexCreateTime = sysIndexCreateTime == null ? null : sysIndexCreateTime.trim();
    }

    public String getSysIndexUpdateTime() {
        return sysIndexUpdateTime;
    }

    public void setSysIndexUpdateTime(String sysIndexUpdateTime) {
        this.sysIndexUpdateTime = sysIndexUpdateTime == null ? null : sysIndexUpdateTime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sysIndexId=").append(sysIndexId);
        sb.append(", sysIndexName=").append(sysIndexName);
        sb.append(", sysIndexImageUrl=").append(sysIndexImageUrl);
        sb.append(", sysIndexImageContent=").append(sysIndexImageContent);
        sb.append(", sysIndexType=").append(sysIndexType);
        sb.append(", sysIndexNumber=").append(sysIndexNumber);
        sb.append(", sysIndexCreateTime=").append(sysIndexCreateTime);
        sb.append(", sysIndexUpdateTime=").append(sysIndexUpdateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

	public String getOrderByString() {
		return orderByString;
	}

	public void setOrderByString(String orderByString) {
		this.orderByString = orderByString;
	}
}