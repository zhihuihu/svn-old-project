package com.dy.weike.entity;

import java.io.Serializable;
import java.util.Date;

public class UserSession implements Serializable {

	/**
	 * 用户-课时类序列化id
	 */
	private static final long serialVersionUID = 1L;
	
    private int sessionId;
    private int userId;
    private int classId;
	
	/**
	 * 课时学习状态
	 */
    private int sessionState;

    /**
     * 用户关注课程时间
     */
    private String userSessionCreatetime;
    
    /**
     * 用户计划学习课时时间
     */
    private String userSessionPlantime;
    
    /**
     * 用户学习课时时间
     */
    private String userSessionEndtime;
    
    /**
     * 用户规划学习类型
     * @return
     */
    private int planType;

    private Class classInfo;
    
    private ClassSession classSessionInfo;
    
    
	public ClassSession getClassSessionInfo() {
		return classSessionInfo;
	}

	public void setClassSessionInfo(ClassSession classSessionInfo) {
		this.classSessionInfo = classSessionInfo;
	}

	public Class getClassInfo() {
		return classInfo;
	}

	public void setClassInfo(Class classInfo) {
		this.classInfo = classInfo;
	}

	public int getSessionId() {
		return sessionId;
	}

	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getSessionState() {
		return sessionState;
	}

	public void setSessionState(int sessionState) {
		this.sessionState = sessionState;
	}

	public String getUserSessionCreatetime() {
		return userSessionCreatetime;
	}

	public void setUserSessionCreatetime(String userSessionCreatetime) {
		this.userSessionCreatetime = userSessionCreatetime;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getUserSessionPlantime() {
		return userSessionPlantime;
	}

	public void setUserSessionPlantime(String userSessionPlantime) {
		this.userSessionPlantime = userSessionPlantime;
	}

	public String getUserSessionEndtime() {
		return userSessionEndtime;
	}

	public void setUserSessionEndtime(String userSessionEndtime) {
		this.userSessionEndtime = userSessionEndtime;
	}

	public int getPlanType() {
		return planType;
	}

	public void setPlanType(int planType) {
		this.planType = planType;
	}
	
}
