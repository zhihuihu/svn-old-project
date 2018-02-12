package com.cqq.leisure.entity;

import java.io.Serializable;

public class Tag implements Serializable {

	/**
	 * 标签表实体
	 */
	private static final long serialVersionUID = 4496150197480375072L;
	//标签Id
    private int tagId;
    //标签名
    private String tagName;
    //标签对应图片
    private String tagImg;
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagImg() {
		return tagImg;
	}
	public void setTagImg(String tagImg) {
		this.tagImg = tagImg;
	}
    
    

}
