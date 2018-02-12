package com.hxkj.totop.entity;

import java.io.Serializable;

/**
 * 富文本内容
 * Created by huzhihui on 2016/4/7.
 */
public class RichText implements Serializable{


    private static final long serialVersionUID = -5713659922329051572L;
    //富文本内容CUID
    private String richTextCuid;

    //品生活CUID
    private String pingLifeCuid;

    //富文本内容缩略图
    private String richTextThumbUrl;

    //富文本内容标题
    private String richTextTitle;

    //富文本内容状态
    private int richTextState;

    //富文本内容创建时间
    private String richTextCreateTime;

    //富文本内容更新时间
    private String richTextUpdateTime;

    //富文本内容主要内容
    private String richTextContent;

    public String getRichTextCuid() {
        return richTextCuid;
    }

    public void setRichTextCuid(String richTextCuid) {
        this.richTextCuid = richTextCuid;
    }

    public String getPingLifeCuid() {
        return pingLifeCuid;
    }

    public void setPingLifeCuid(String pingLifeCuid) {
        this.pingLifeCuid = pingLifeCuid;
    }

    public String getRichTextThumbUrl() {
        return richTextThumbUrl;
    }

    public void setRichTextThumbUrl(String richTextThumbUrl) {
        this.richTextThumbUrl = richTextThumbUrl;
    }

    public String getRichTextTitle() {
        return richTextTitle;
    }

    public void setRichTextTitle(String richTextTitle) {
        this.richTextTitle = richTextTitle;
    }

    public int getRichTextState() {
        return richTextState;
    }

    public void setRichTextState(int richTextState) {
        this.richTextState = richTextState;
    }

    public String getRichTextCreateTime() {
        return richTextCreateTime;
    }

    public void setRichTextCreateTime(String richTextCreateTime) {
        this.richTextCreateTime = richTextCreateTime;
    }

    public String getRichTextUpdateTime() {
        return richTextUpdateTime;
    }

    public void setRichTextUpdateTime(String richTextUpdateTime) {
        this.richTextUpdateTime = richTextUpdateTime;
    }

    public String getRichTextContent() {
        return richTextContent;
    }

    public void setRichTextContent(String richTextContent) {
        this.richTextContent = richTextContent;
    }
}
