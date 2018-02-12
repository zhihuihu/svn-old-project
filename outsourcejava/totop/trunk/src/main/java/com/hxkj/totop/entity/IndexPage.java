package com.hxkj.totop.entity;

import java.io.Serializable;

/**
 * 主页的对应的实体
 * Created by huzhihui on 2016/4/7.
 */
public class IndexPage implements Serializable{

    private static final long serialVersionUID = 3831769650508503728L;
    //主页表CUID
    private String indexPageCuid;

    //主页表图片URL
    private String indexPageImageUrl;

    //主页表图片提示
    private String indexPageImageNotes;

    //主页表图片后续文字
    private String indexPageSubContent;

    //主页表跳转链接(待用)
    private String indexPageToUrl;

    //主页表介绍标题
    private String indexPageTitleName;

    //主页表介绍主要内容
    private String indexPageMainContent;

    //主页表对应内容类型(1:4张主图;2:公司介绍;3:介绍旁图片;4:最下面三张图片)
    private int indexPageType;

    //主页表状态
    private int indexPageState;

    //主页表创建时间
    private String indexPageCreateTime;

    //主页表更新时间
    private String indexPageUpdateTime;

    public String getIndexPageUpdateTime() {
        return indexPageUpdateTime;
    }

    public void setIndexPageUpdateTime(String indexPageUpdateTime) {
        this.indexPageUpdateTime = indexPageUpdateTime;
    }

    public String getIndexPageCuid() {
        return indexPageCuid;
    }

    public void setIndexPageCuid(String indexPageCuid) {
        this.indexPageCuid = indexPageCuid;
    }

    public String getIndexPageImageUrl() {
        return indexPageImageUrl;
    }

    public void setIndexPageImageUrl(String indexPageImageUrl) {
        this.indexPageImageUrl = indexPageImageUrl;
    }

    public String getIndexPageImageNotes() {
        return indexPageImageNotes;
    }

    public void setIndexPageImageNotes(String indexPageImageNotes) {
        this.indexPageImageNotes = indexPageImageNotes;
    }

    public String getIndexPageSubContent() {
        return indexPageSubContent;
    }

    public void setIndexPageSubContent(String indexPageSubContent) {
        this.indexPageSubContent = indexPageSubContent;
    }

    public String getIndexPageToUrl() {
        return indexPageToUrl;
    }

    public void setIndexPageToUrl(String indexPageToUrl) {
        this.indexPageToUrl = indexPageToUrl;
    }

    public String getIndexPageTitleName() {
        return indexPageTitleName;
    }

    public void setIndexPageTitleName(String indexPageTitleName) {
        this.indexPageTitleName = indexPageTitleName;
    }

    public String getIndexPageMainContent() {
        return indexPageMainContent;
    }

    public void setIndexPageMainContent(String indexPageMainContent) {
        this.indexPageMainContent = indexPageMainContent;
    }

    public int getIndexPageType() {
        return indexPageType;
    }

    public void setIndexPageType(int indexPageType) {
        this.indexPageType = indexPageType;
    }

    public int getIndexPageState() {
        return indexPageState;
    }

    public void setIndexPageState(int indexPageState) {
        this.indexPageState = indexPageState;
    }

    public String getIndexPageCreateTime() {
        return indexPageCreateTime;
    }

    public void setIndexPageCreateTime(String indexPageCreateTime) {
        this.indexPageCreateTime = indexPageCreateTime;
    }
}
