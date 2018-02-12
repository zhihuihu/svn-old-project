package com.cqq.leisure.entity;

import java.io.Serializable;

public class Active implements Serializable {
	
	/**
	 * 活动表实体
	 */
	private static final long serialVersionUID = -7412439116500862472L;

	//活动表ID
    private int activeId;
    //标签_ID
    private int tagId;
    //发起活动用户id
    private int userId;
    //活动表名称
    private String activeName;
    //活动表图标
    private String activeIconUrl;
    //活动表类型(1：用户发起的社区活动 2：管理员添加的活动)
    private String activeType;
    //活动表内容
    private String activeMainContent;
    //活动表开始时间
    private String activeStartTime;
    //活动表结束时间
    private String activeEndTime;
    //活动表具体地址
    private String activeAddress;
    //活动表经度
    private String activeLog;
    //活动表纬度
    private String activeLat;
    //活动表状态 	
    private int activeState;
    //活动表创建时间
    private String activeCreateTime;
    //活动表更新时间
    private String activeUpdateTime;
    //活动标签 修改为 判断是热度排序还是正常排序    hot normal
    private String activeTag;
    //活动表排序
    private int activeSort;
    //活动发起人
    private String activeCreateName;
    //发起人对象
    private User user;
	public int getActiveId() {
		return activeId;
	}
	public void setActiveId(int activeId) {
		this.activeId = activeId;
	}
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getActiveName() {
		return activeName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getActiveCreateName() {
		return activeCreateName;
	}
	public void setActiveCreateName(String activeCreateName) {
		this.activeCreateName = activeCreateName;
	}
	public void setActiveName(String activeName) {
		this.activeName = activeName;
	}
	public String getActiveIconUrl() {
		return activeIconUrl;
	}
	public void setActiveIconUrl(String activeIconUrl) {
		this.activeIconUrl = activeIconUrl;
	}
	public String getActiveType() {
		return activeType;
	}
	public void setActiveType(String activeType) {
		this.activeType = activeType;
	}
	public String getActiveMainContent() {
		return activeMainContent;
	}
	public void setActiveMainContent(String activeMainContent) {
		this.activeMainContent = activeMainContent;
	}
	public String getActiveStartTime() {
		return activeStartTime;
	}
	public void setActiveStartTime(String activeStartTime) {
		this.activeStartTime = activeStartTime;
	}
	public String getActiveEndTime() {
		return activeEndTime;
	}
	public void setActiveEndTime(String activeEndTime) {
		this.activeEndTime = activeEndTime;
	}
	public String getActiveAddress() {
		return activeAddress;
	}
	public void setActiveAddress(String activeAddress) {
		this.activeAddress = activeAddress;
	}
	public String getActiveLog() {
		return activeLog;
	}
	public void setActiveLog(String activeLog) {
		this.activeLog = activeLog;
	}
	public String getActiveLat() {
		return activeLat;
	}
	public void setActiveLat(String activeLat) {
		this.activeLat = activeLat;
	}
	public int getActiveState() {
		return activeState;
	}
	public void setActiveState(int activeState) {
		this.activeState = activeState;
	}
	public String getActiveCreateTime() {
		return activeCreateTime;
	}
	public void setActiveCreateTime(String activeCreateTime) {
		this.activeCreateTime = activeCreateTime;
	}
	public String getActiveUpdateTime() {
		return activeUpdateTime;
	}
	public void setActiveUpdateTime(String activeUpdateTime) {
		this.activeUpdateTime = activeUpdateTime;
	}
	public String getActiveTag() {
		return activeTag;
	}
	public void setActiveTag(String activeTag) {
		this.activeTag = activeTag;
	}
	public int getActiveSort() {
		return activeSort;
	}
	public void setActiveSort(int activeSort) {
		this.activeSort = activeSort;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
    

}
