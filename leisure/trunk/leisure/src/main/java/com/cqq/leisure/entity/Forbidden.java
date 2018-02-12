package com.cqq.leisure.entity;

import java.io.Serializable;

public class Forbidden implements Serializable {
	/***
	 * 各地域禁忌表实体
	 */

	private static final long serialVersionUID = -8632970948055605493L;
	//地域禁忌表ID
	private int forbiddenId;
	//城市名称
	private String forbiddenCityName;
	//禁忌标题
	private String forbiddenTitle;
	//禁忌主要内容
	private String forbiddenMainContent;
	
	public int getForbiddenId() {
		return forbiddenId;
	}
	public void setForbiddenId(int forbiddenId) {
		this.forbiddenId = forbiddenId;
	}
	public String getForbiddenCityName() {
		return forbiddenCityName;
	}
	public void setForbiddenCityName(String forbiddenCityName) {
		this.forbiddenCityName = forbiddenCityName;
	}
	public String getForbiddenTitle() {
		return forbiddenTitle;
	}
	public void setForbiddenTitle(String forbiddenTitle) {
		this.forbiddenTitle = forbiddenTitle;
	}
	public String getForbiddenMainContent() {
		return forbiddenMainContent;
	}
	public void setForbiddenMainContent(String forbiddenMainContent) {
		this.forbiddenMainContent = forbiddenMainContent;
	}
	
	

	
	
}
