package com.cqq.leisure.entity;

import java.io.Serializable;

public class UserPlan implements Serializable {
	
	
    /**
	 * 用户规划实体
	 */
	private static final long serialVersionUID = 3764625348178576890L;
	//用户规划表ID
	private int userPlanId;
	//用户ID
    private int userId;
    //用户规划表名称(替换为用户规划表目的地)
    private String userPlanName;
    //用户规划表具体内容
    private String userPlanMainContent;
    //用户规划表开始时间
    private String userPlanStartTime;
    //用户规划表结束时间
    private String userPlanEndTime;
    //用户规划表状态
    private int userPlanState;
    //用户规划表创建时间
    private String userPlanCreateTime;
    //用户规划表更新时间
    private String userPlanUpdateTime;
	public int getUserPlanId() {
		return userPlanId;
	}
	public void setUserPlanId(int userPlanId) {
		this.userPlanId = userPlanId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserPlanName() {
		return userPlanName;
	}
	public void setUserPlanName(String userPlanName) {
		this.userPlanName = userPlanName;
	}
	public String getUserPlanMainContent() {
		return userPlanMainContent;
	}
	public void setUserPlanMainContent(String userPlanMainContent) {
		this.userPlanMainContent = userPlanMainContent;
	}
	public String getUserPlanStartTime() {
		return userPlanStartTime;
	}
	public void setUserPlanStartTime(String userPlanStartTime) {
		this.userPlanStartTime = userPlanStartTime;
	}
	public String getUserPlanEndTime() {
		return userPlanEndTime;
	}
	public void setUserPlanEndTime(String userPlanEndTime) {
		this.userPlanEndTime = userPlanEndTime;
	}
	public int getUserPlanState() {
		return userPlanState;
	}
	public void setUserPlanState(int userPlanState) {
		this.userPlanState = userPlanState;
	}
	public String getUserPlanCreateTime() {
		return userPlanCreateTime;
	}
	public void setUserPlanCreateTime(String userPlanCreateTime) {
		this.userPlanCreateTime = userPlanCreateTime;
	}
	public String getUserPlanUpdateTime() {
		return userPlanUpdateTime;
	}
	public void setUserPlanUpdateTime(String userPlanUpdateTime) {
		this.userPlanUpdateTime = userPlanUpdateTime;
	}
    
    

}
