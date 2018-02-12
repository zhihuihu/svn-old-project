package com.dy.weike.entity;

import java.io.Serializable;


/**
 * 活动类
 * @author d-y
 *
 */
public class Activity implements Serializable {
	/**
	 * 添加活动类的序列化ID
	 */
	private static final long serialVersionUID = 4022938949133388872L;
	/**
	 * 活动ID
	 */    
    private int activityId;
    /**
     * 活动所属课程ID
     */
    private int classId;
    /**
     * 活动发起人ID
     */
    private int activityUser;
    /**
     * 活动时间
     */
    private String activityData;
    /**
     * 活动地点
     */
    private String activityPlace;
    /**
     * 活动主题
     */
    private String activityTheme;
    /**
     * 活动注意事项
     */
    private String activityWatch;
    /**
     * 活动状态
     */
    private int activityState;
    
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getActivityUser() {
		return activityUser;
	}
	public void setActivityUser(int activityUser) {
		this.activityUser = activityUser;
	}
	public String getActivityData() {
		return activityData;
	}
	public void setActivityData(String activityData) {
		this.activityData = activityData;
	}
	public String getActivityPlace() {
		return activityPlace;
	}
	public void setActivityPlace(String activityPlace) {
		this.activityPlace = activityPlace;
	}
	public String getActivityTheme() {
		return activityTheme;
	}
	public void setActivityTheme(String activityTheme) {
		this.activityTheme = activityTheme;
	}
	public String getActivityWatch() {
		return activityWatch;
	}
	public void setActivityWatch(String activityWatch) {
		this.activityWatch = activityWatch;
	}
	public int getActivityState() {
		return activityState;
	}
	public void setActivityState(int activityState) {
		this.activityState = activityState;
	}
    
    
    
    
    
    
}
