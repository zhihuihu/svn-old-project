package com.cqq.leisure.entity;

import java.io.Serializable;
import java.util.Date;

public class UserHolidayComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8852505633558893783L;
	//假日方案ID
	private Integer holidayPlanId;
	//用户ID
	private Integer userId;
	//用户假日方案评论类型
	private int userHolidayCommentType;
	//用户假日方案评论状态
	private int userHolidayCommentState;
	//用户假日方案评论标题
	private String userHolidayCommentTitle;
	//用户假日方案评论内容
	private String userHolidayCommentContent;
	//用户假日方案评论创建时间
	private String userHolidayCommentCreateTime;
	//用户假日方案评论更新时间
	private String userHolidayCommentUpdateTime;
	public Integer getHolidayPlanId() {
		return holidayPlanId;
	}
	public void setHolidayPlanId(Integer holidayPlanId) {
		this.holidayPlanId = holidayPlanId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public int getUserHolidayCommentType() {
		return userHolidayCommentType;
	}
	public void setUserHolidayCommentType(int userHolidayCommentType) {
		this.userHolidayCommentType = userHolidayCommentType;
	}
	public int getUserHolidayCommentState() {
		return userHolidayCommentState;
	}
	public void setUserHolidayCommentState(int userHolidayCommentState) {
		this.userHolidayCommentState = userHolidayCommentState;
	}
	public String getUserHolidayCommentTitle() {
		return userHolidayCommentTitle;
	}
	public void setUserHolidayCommentTitle(String userHolidayCommentTitle) {
		this.userHolidayCommentTitle = userHolidayCommentTitle;
	}
	public String getUserHolidayCommentContent() {
		return userHolidayCommentContent;
	}
	public void setUserHolidayCommentContent(String userHolidayCommentContent) {
		this.userHolidayCommentContent = userHolidayCommentContent;
	}
	public String getUserHolidayCommentCreateTime() {
		return userHolidayCommentCreateTime;
	}
	public void setUserHolidayCommentCreateTime(String userHolidayCommentCreateTime) {
		this.userHolidayCommentCreateTime = userHolidayCommentCreateTime;
	}
	public String getUserHolidayCommentUpdateTime() {
		return userHolidayCommentUpdateTime;
	}
	public void setUserHolidayCommentUpdateTime(String userHolidayCommentUpdateTime) {
		this.userHolidayCommentUpdateTime = userHolidayCommentUpdateTime;
	}
	
	
}
