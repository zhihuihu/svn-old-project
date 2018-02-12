package com.hxkj.totops.entity;

public class PinLife {
    /**
     * 品生活cuid
     * 表字段 : pin_life.pin_life_cuid
     */
    private String pinLifeCuid;

    /**
     * 品生活左侧类别名称
     * 表字段 : pin_life.pin_life_left_type_name
     */
    private String pinLifeLeftTypeName;

    /**
     * 品生活左侧类别icon
     * 表字段 : pin_life.pin_life_left_type_icon
     */
    private String pinLifeLeftTypeIcon;

    /**
     * 品生活右侧图片
     * 表字段 : pin_life.pin_life_right_image
     */
    private String pinLifeRightImage;

    /**
     * 品生活右侧图片icon
     * 表字段 : pin_life.pin_life_right_image_icon
     */
    private String pinLifeRightImageIcon;

    /**
     * 品生活右侧图片跳转地址
     * 表字段 : pin_life.pin_life_right_image_url
     */
    private String pinLifeRightImageUrl;

    /**
     * 品生活子列表所属类型id
     * 表字段 : pin_life.pin_life_small_list_parent_id
     */
    private String pinLifeSmallListParentId;

    /**
     * 品生活子列表所属类型名称
     * 表字段 : pin_life.pin_life_small_list_parent_name
     */
    private String pinLifeSmallListParentName;

    /**
     * 品生活子列表标题
     * 表字段 : pin_life.pin_life_small_list_title
     */
    private String pinLifeSmallListTitle;

    /**
     * 品生活子列表图片
     * 表字段 : pin_life.pin_life_small_list_image
     */
    private String pinLifeSmallListImage;

    /**
     * 品生活子列表content（富文本）
     * 表字段 : pin_life.pin_life_small_list_content
     */
    private String pinLifeSmallListContent;

    /**
     * 品生活操作人
     * 表字段 : pin_life.pin_life_operate_id
     */
    private String pinLifeOperateId;

    /**
     * 品生活类型（1：左侧列表、2：右侧一张图片、3：右下列表）
     * 表字段 : pin_life.pin_life_type
     */
    private Integer pinLifeType;

    /**
     * 品生活状态（1：正常显示、40：删除隐藏）
     * 表字段 : pin_life.pin_life_state
     */
    private Integer pinLifeState;

    /**
     * 品生活创建时间
     * 表字段 : pin_life.pin_life_create_time
     */
    private String pinLifeCreateTime;

    /**
     * 品生活更新时间
     * 表字段 : pin_life.pin_life_update_time
     */
    private String pinLifeUpdateTime;

    public String getPinLifeCuid() {
        return pinLifeCuid;
    }

    public void setPinLifeCuid(String pinLifeCuid) {
        this.pinLifeCuid = pinLifeCuid == null ? null : pinLifeCuid.trim();
    }

    public String getPinLifeLeftTypeName() {
        return pinLifeLeftTypeName;
    }

    public void setPinLifeLeftTypeName(String pinLifeLeftTypeName) {
        this.pinLifeLeftTypeName = pinLifeLeftTypeName == null ? null : pinLifeLeftTypeName.trim();
    }

    public String getPinLifeLeftTypeIcon() {
        return pinLifeLeftTypeIcon;
    }

    public void setPinLifeLeftTypeIcon(String pinLifeLeftTypeIcon) {
        this.pinLifeLeftTypeIcon = pinLifeLeftTypeIcon == null ? null : pinLifeLeftTypeIcon.trim();
    }

    public String getPinLifeRightImage() {
        return pinLifeRightImage;
    }

    public void setPinLifeRightImage(String pinLifeRightImage) {
        this.pinLifeRightImage = pinLifeRightImage == null ? null : pinLifeRightImage.trim();
    }

    public String getPinLifeRightImageIcon() {
        return pinLifeRightImageIcon;
    }

    public void setPinLifeRightImageIcon(String pinLifeRightImageIcon) {
        this.pinLifeRightImageIcon = pinLifeRightImageIcon == null ? null : pinLifeRightImageIcon.trim();
    }

    public String getPinLifeRightImageUrl() {
        return pinLifeRightImageUrl;
    }

    public void setPinLifeRightImageUrl(String pinLifeRightImageUrl) {
        this.pinLifeRightImageUrl = pinLifeRightImageUrl == null ? null : pinLifeRightImageUrl.trim();
    }

    public String getPinLifeSmallListParentId() {
        return pinLifeSmallListParentId;
    }

    public void setPinLifeSmallListParentId(String pinLifeSmallListParentId) {
        this.pinLifeSmallListParentId = pinLifeSmallListParentId == null ? null : pinLifeSmallListParentId.trim();
    }

    public String getPinLifeSmallListParentName() {
        return pinLifeSmallListParentName;
    }

    public void setPinLifeSmallListParentName(String pinLifeSmallListParentName) {
        this.pinLifeSmallListParentName = pinLifeSmallListParentName == null ? null : pinLifeSmallListParentName.trim();
    }

    public String getPinLifeSmallListTitle() {
        return pinLifeSmallListTitle;
    }

    public void setPinLifeSmallListTitle(String pinLifeSmallListTitle) {
        this.pinLifeSmallListTitle = pinLifeSmallListTitle == null ? null : pinLifeSmallListTitle.trim();
    }

    public String getPinLifeSmallListImage() {
        return pinLifeSmallListImage;
    }

    public void setPinLifeSmallListImage(String pinLifeSmallListImage) {
        this.pinLifeSmallListImage = pinLifeSmallListImage == null ? null : pinLifeSmallListImage.trim();
    }

    public String getPinLifeSmallListContent() {
        return pinLifeSmallListContent;
    }

    public void setPinLifeSmallListContent(String pinLifeSmallListContent) {
        this.pinLifeSmallListContent = pinLifeSmallListContent == null ? null : pinLifeSmallListContent.trim();
    }

    public String getPinLifeOperateId() {
        return pinLifeOperateId;
    }

    public void setPinLifeOperateId(String pinLifeOperateId) {
        this.pinLifeOperateId = pinLifeOperateId == null ? null : pinLifeOperateId.trim();
    }

    public Integer getPinLifeType() {
        return pinLifeType;
    }

    public void setPinLifeType(Integer pinLifeType) {
        this.pinLifeType = pinLifeType;
    }

    public Integer getPinLifeState() {
        return pinLifeState;
    }

    public void setPinLifeState(Integer pinLifeState) {
        this.pinLifeState = pinLifeState;
    }

    public String getPinLifeCreateTime() {
        return pinLifeCreateTime;
    }

    public void setPinLifeCreateTime(String pinLifeCreateTime) {
        this.pinLifeCreateTime = pinLifeCreateTime == null ? null : pinLifeCreateTime.trim();
    }

    public String getPinLifeUpdateTime() {
        return pinLifeUpdateTime;
    }

    public void setPinLifeUpdateTime(String pinLifeUpdateTime) {
        this.pinLifeUpdateTime = pinLifeUpdateTime == null ? null : pinLifeUpdateTime.trim();
    }
}