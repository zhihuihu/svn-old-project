package com.hxkj.totop.entity;

import java.io.Serializable;

/**
 * 品生活实体类
 * Created by huzhihui on 2016/4/7.
 */
public class PingLife implements Serializable {


    private static final long serialVersionUID = 8622510678928849440L;
    //品生活CUID
    private String pingLifeCuid;
    //品生活主图URL
    private String pingLifeMainUrl;
    //品生活主图提示
    private String pingLifeMainNotes;
    //品生活类别名称
    private String pingLifeCategory;
    //品生活类别编码
    private String pingLifeCategoryCode;
    //品生活小标题名称
    private String pingLifeTitleName;
    //品生活类型
    private int pingLifeType;
    //品生活状态
    private int pingLifeState;
    //品生活创建时间
    private String pingLifeCreateTime;
    //品生活更新时间
    private String pingLifeUpdateTime;

    /**
     *  实体属性
     */
    //富文本
    private RichText richText;

    public String getPingLifeCuid() {
        return pingLifeCuid;
    }

    public void setPingLifeCuid(String pingLifeCuid) {
        this.pingLifeCuid = pingLifeCuid;
    }

    public String getPingLifeMainUrl() {
        return pingLifeMainUrl;
    }

    public void setPingLifeMainUrl(String pingLifeMainUrl) {
        this.pingLifeMainUrl = pingLifeMainUrl;
    }

    public String getPingLifeMainNotes() {
        return pingLifeMainNotes;
    }

    public void setPingLifeMainNotes(String pingLifeMainNotes) {
        this.pingLifeMainNotes = pingLifeMainNotes;
    }

    public String getPingLifeCategory() {
        return pingLifeCategory;
    }

    public void setPingLifeCategory(String pingLifeCategory) {
        this.pingLifeCategory = pingLifeCategory;
    }

    public String getPingLifeCategoryCode() {
        return pingLifeCategoryCode;
    }

    public void setPingLifeCategoryCode(String pingLifeCategoryCode) {
        this.pingLifeCategoryCode = pingLifeCategoryCode;
    }

    public String getPingLifeTitleName() {
        return pingLifeTitleName;
    }

    public void setPingLifeTitleName(String pingLifeTitleName) {
        this.pingLifeTitleName = pingLifeTitleName;
    }

    public int getPingLifeType() {
        return pingLifeType;
    }

    public void setPingLifeType(int pingLifeType) {
        this.pingLifeType = pingLifeType;
    }

    public int getPingLifeState() {
        return pingLifeState;
    }

    public void setPingLifeState(int pingLifeState) {
        this.pingLifeState = pingLifeState;
    }

    public String getPingLifeCreateTime() {
        return pingLifeCreateTime;
    }

    public void setPingLifeCreateTime(String pingLifeCreateTime) {
        this.pingLifeCreateTime = pingLifeCreateTime;
    }

    public String getPingLifeUpdateTime() {
        return pingLifeUpdateTime;
    }

    public void setPingLifeUpdateTime(String pingLifeUpdateTime) {
        this.pingLifeUpdateTime = pingLifeUpdateTime;
    }

    public RichText getRichText() {
        return richText;
    }

    public void setRichText(RichText richText) {
        this.richText = richText;
    }
}
