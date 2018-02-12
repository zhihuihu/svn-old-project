package com.hxkj.totops.entity;

public class IndexPage {
    /**
     * 主页信息表cuid
     * 表字段 : index_page.index_page_cuid
     */
    private String indexPageCuid;

    /**
     * 主页信息表主图
     * 表字段 : index_page.index_page_main_image
     */
    private String indexPageMainImage;

    /**
     * 主页信息表主图跳转链接
     * 表字段 : index_page.index_page_main_image_url
     */
    private String indexPageMainImageUrl;

    /**
     * 主页信息表内容
     * 表字段 : index_page.index_page_content
     */
    private String indexPageContent;

    /**
     * 主页信息表中间标题
     * 表字段 : index_page.index_page_center_title
     */
    private String indexPageCenterTitle;

    /**
     * 主页信息表中间标题跳转链接
     * 表字段 : index_page.index_page_center_title_url
     */
    private String indexPageCenterTitleUrl;

    /**
     * 主页信息表中间内容
     * 表字段 : index_page.index_page_center_content
     */
    private String indexPageCenterContent;

    /**
     * 主页信息表中间图片
     * 表字段 : index_page.index_page_center_icon
     */
    private String indexPageCenterIcon;

    /**
     * 主页信息表中间图片跳转链接
     * 表字段 : index_page.index_page_center_icon_url
     */
    private String indexPageCenterIconUrl;

    /**
     * 主页信息表底部图片
     * 表字段 : index_page.index_page_bottom_icon
     */
    private String indexPageBottomIcon;

    /**
     * 主页信息表底部标题
     * 表字段 : index_page.index_page_bottom_title
     */
    private String indexPageBottomTitle;

    /**
     * 主页信息表底部跳转链接
     * 表字段 : index_page.index_page_bottom_title_url
     */
    private String indexPageBottomTitleUrl;

    /**
     * 主页信息表操作人id
     * 表字段 : index_page.index_page_operate_id
     */
    private String indexPageOperateId;

    /**
     * 主页信息表类型（1：主图类、2：中间、3：底部）
     * 表字段 : index_page.index_page_type
     */
    private Integer indexPageType;

    /**
     * 主页信息表状态（1：正常显示、40：删除隐藏）
     * 表字段 : index_page.index_page_state
     */
    private Integer indexPageState;

    /**
     * 主页信息表创建时间
     * 表字段 : index_page.index_page_create_time
     */
    private String indexPageCreateTime;

    /**
     * 主页信息表更新时间
     * 表字段 : index_page.index_page_update_time
     */
    private String indexPageUpdateTime;

    public String getIndexPageCuid() {
        return indexPageCuid;
    }

    public void setIndexPageCuid(String indexPageCuid) {
        this.indexPageCuid = indexPageCuid == null ? null : indexPageCuid.trim();
    }

    public String getIndexPageMainImage() {
        return indexPageMainImage;
    }

    public void setIndexPageMainImage(String indexPageMainImage) {
        this.indexPageMainImage = indexPageMainImage == null ? null : indexPageMainImage.trim();
    }

    public String getIndexPageMainImageUrl() {
        return indexPageMainImageUrl;
    }

    public void setIndexPageMainImageUrl(String indexPageMainImageUrl) {
        this.indexPageMainImageUrl = indexPageMainImageUrl == null ? null : indexPageMainImageUrl.trim();
    }

    public String getIndexPageContent() {
        return indexPageContent;
    }

    public void setIndexPageContent(String indexPageContent) {
        this.indexPageContent = indexPageContent == null ? null : indexPageContent.trim();
    }

    public String getIndexPageCenterTitle() {
        return indexPageCenterTitle;
    }

    public void setIndexPageCenterTitle(String indexPageCenterTitle) {
        this.indexPageCenterTitle = indexPageCenterTitle == null ? null : indexPageCenterTitle.trim();
    }

    public String getIndexPageCenterTitleUrl() {
        return indexPageCenterTitleUrl;
    }

    public void setIndexPageCenterTitleUrl(String indexPageCenterTitleUrl) {
        this.indexPageCenterTitleUrl = indexPageCenterTitleUrl == null ? null : indexPageCenterTitleUrl.trim();
    }

    public String getIndexPageCenterContent() {
        return indexPageCenterContent;
    }

    public void setIndexPageCenterContent(String indexPageCenterContent) {
        this.indexPageCenterContent = indexPageCenterContent == null ? null : indexPageCenterContent.trim();
    }

    public String getIndexPageCenterIcon() {
        return indexPageCenterIcon;
    }

    public void setIndexPageCenterIcon(String indexPageCenterIcon) {
        this.indexPageCenterIcon = indexPageCenterIcon == null ? null : indexPageCenterIcon.trim();
    }

    public String getIndexPageCenterIconUrl() {
        return indexPageCenterIconUrl;
    }

    public void setIndexPageCenterIconUrl(String indexPageCenterIconUrl) {
        this.indexPageCenterIconUrl = indexPageCenterIconUrl == null ? null : indexPageCenterIconUrl.trim();
    }

    public String getIndexPageBottomIcon() {
        return indexPageBottomIcon;
    }

    public void setIndexPageBottomIcon(String indexPageBottomIcon) {
        this.indexPageBottomIcon = indexPageBottomIcon == null ? null : indexPageBottomIcon.trim();
    }

    public String getIndexPageBottomTitle() {
        return indexPageBottomTitle;
    }

    public void setIndexPageBottomTitle(String indexPageBottomTitle) {
        this.indexPageBottomTitle = indexPageBottomTitle == null ? null : indexPageBottomTitle.trim();
    }

    public String getIndexPageBottomTitleUrl() {
        return indexPageBottomTitleUrl;
    }

    public void setIndexPageBottomTitleUrl(String indexPageBottomTitleUrl) {
        this.indexPageBottomTitleUrl = indexPageBottomTitleUrl == null ? null : indexPageBottomTitleUrl.trim();
    }

    public String getIndexPageOperateId() {
        return indexPageOperateId;
    }

    public void setIndexPageOperateId(String indexPageOperateId) {
        this.indexPageOperateId = indexPageOperateId == null ? null : indexPageOperateId.trim();
    }

    public Integer getIndexPageType() {
        return indexPageType;
    }

    public void setIndexPageType(Integer indexPageType) {
        this.indexPageType = indexPageType;
    }

    public Integer getIndexPageState() {
        return indexPageState;
    }

    public void setIndexPageState(Integer indexPageState) {
        this.indexPageState = indexPageState;
    }

    public String getIndexPageCreateTime() {
        return indexPageCreateTime;
    }

    public void setIndexPageCreateTime(String indexPageCreateTime) {
        this.indexPageCreateTime = indexPageCreateTime == null ? null : indexPageCreateTime.trim();
    }

    public String getIndexPageUpdateTime() {
        return indexPageUpdateTime;
    }

    public void setIndexPageUpdateTime(String indexPageUpdateTime) {
        this.indexPageUpdateTime = indexPageUpdateTime == null ? null : indexPageUpdateTime.trim();
    }
}