package com.hxkj.totops.entity;

public class MingPinHui {
    /**
     * 名品汇cuid
     * 表字段 : ming_pin_hui.ming_pin_hui_cuid
     */
    private String mingPinHuiCuid;

    /**
     * 名品汇标题
     * 表字段 : ming_pin_hui.ming_pin_hui_title
     */
    private String mingPinHuiTitle;

    /**
     * 名品汇图片
     * 表字段 : ming_pin_hui.ming_pin_hui_image
     */
    private String mingPinHuiImage;

    /**
     * 名品汇图片icon
     * 表字段 : ming_pin_hui.ming_pin_hui_image_icon
     */
    private String mingPinHuiImageIcon;

    /**
     * 名品汇图片跳转链接
     * 表字段 : ming_pin_hui.ming_pin_hui_image_url
     */
    private String mingPinHuiImageUrl;

    /**
     * 名品汇内容
     * 表字段 : ming_pin_hui.ming_pin_hui_content
     */
    private String mingPinHuiContent;

    /**
     * 名品汇操作人id
     * 表字段 : ming_pin_hui.ming_pin_hui_operate_id
     */
    private String mingPinHuiOperateId;

    /**
     * 名品汇类型
     * 表字段 : ming_pin_hui.ming_pin_hui_type
     */
    private Integer mingPinHuiType;

    /**
     * 名品汇状态（1：正常显示、40：删除隐藏）
     * 表字段 : ming_pin_hui.ming_pin_hui_state
     */
    private Integer mingPinHuiState;

    /**
     * 名品汇创建时间
     * 表字段 : ming_pin_hui.ming_pin_hui_create_time
     */
    private String mingPinHuiCreateTime;

    /**
     * 名品汇更新时间
     * 表字段 : ming_pin_hui.ming_pin_hui_update_time
     */
    private String mingPinHuiUpdateTime;

    public String getMingPinHuiCuid() {
        return mingPinHuiCuid;
    }

    public void setMingPinHuiCuid(String mingPinHuiCuid) {
        this.mingPinHuiCuid = mingPinHuiCuid == null ? null : mingPinHuiCuid.trim();
    }

    public String getMingPinHuiTitle() {
        return mingPinHuiTitle;
    }

    public void setMingPinHuiTitle(String mingPinHuiTitle) {
        this.mingPinHuiTitle = mingPinHuiTitle == null ? null : mingPinHuiTitle.trim();
    }

    public String getMingPinHuiImage() {
        return mingPinHuiImage;
    }

    public void setMingPinHuiImage(String mingPinHuiImage) {
        this.mingPinHuiImage = mingPinHuiImage == null ? null : mingPinHuiImage.trim();
    }

    public String getMingPinHuiImageIcon() {
        return mingPinHuiImageIcon;
    }

    public void setMingPinHuiImageIcon(String mingPinHuiImageIcon) {
        this.mingPinHuiImageIcon = mingPinHuiImageIcon == null ? null : mingPinHuiImageIcon.trim();
    }

    public String getMingPinHuiImageUrl() {
        return mingPinHuiImageUrl;
    }

    public void setMingPinHuiImageUrl(String mingPinHuiImageUrl) {
        this.mingPinHuiImageUrl = mingPinHuiImageUrl == null ? null : mingPinHuiImageUrl.trim();
    }

    public String getMingPinHuiContent() {
        return mingPinHuiContent;
    }

    public void setMingPinHuiContent(String mingPinHuiContent) {
        this.mingPinHuiContent = mingPinHuiContent == null ? null : mingPinHuiContent.trim();
    }

    public String getMingPinHuiOperateId() {
        return mingPinHuiOperateId;
    }

    public void setMingPinHuiOperateId(String mingPinHuiOperateId) {
        this.mingPinHuiOperateId = mingPinHuiOperateId == null ? null : mingPinHuiOperateId.trim();
    }

    public Integer getMingPinHuiType() {
        return mingPinHuiType;
    }

    public void setMingPinHuiType(Integer mingPinHuiType) {
        this.mingPinHuiType = mingPinHuiType;
    }

    public Integer getMingPinHuiState() {
        return mingPinHuiState;
    }

    public void setMingPinHuiState(Integer mingPinHuiState) {
        this.mingPinHuiState = mingPinHuiState;
    }

    public String getMingPinHuiCreateTime() {
        return mingPinHuiCreateTime;
    }

    public void setMingPinHuiCreateTime(String mingPinHuiCreateTime) {
        this.mingPinHuiCreateTime = mingPinHuiCreateTime == null ? null : mingPinHuiCreateTime.trim();
    }

    public String getMingPinHuiUpdateTime() {
        return mingPinHuiUpdateTime;
    }

    public void setMingPinHuiUpdateTime(String mingPinHuiUpdateTime) {
        this.mingPinHuiUpdateTime = mingPinHuiUpdateTime == null ? null : mingPinHuiUpdateTime.trim();
    }
}