package com.dy.weike.entity;

import java.io.Serializable;

/**
 * 用户课程类
 * @author d-y
 *
 */
public class UserClass implements Serializable {

	/**
	 * 用户-课程类序列化id
	 */
	private static final long serialVersionUID = -3523464575594311640L;	
    private int classId;
    private int userId;
    
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * 学习进度
	 */
	private Float studyProgress;
	/**
	 * 课程学习是否完成
	 */
    private Boolean studyOff;
    /**
     * 是否为计划学习
     */   
    private Boolean studyAttention;
    /**
     * 用户星级评论
     */    
    private int userStar;
    /**
     * 用户课程建立联系的时间
     */   
    private String userClassCreatetime;
    
    
    private Class classInfo;
    
	public Float getStudyProgress() {
		return studyProgress;
	}
	public void setStudyProgress(Float studyProgress) {
		this.studyProgress = studyProgress;
	}
	public Boolean getStudyOff() {
		return studyOff;
	}
	public void setStudyOff(Boolean studyOff) {
		this.studyOff = studyOff;
	}
	public Boolean getStudyAttention() {
		return studyAttention;
	}
	public void setStudyAttention(Boolean studyAttention) {
		this.studyAttention = studyAttention;
	}
	public int getUserStar() {
		return userStar;
	}
	public void setUserStar(int userStar) {
		this.userStar = userStar;
	}
	public String getUserClassCreatetime() {
		return userClassCreatetime;
	}
	public void setUserClassCreatetime(String userClassCreatetime) {
		this.userClassCreatetime = userClassCreatetime;
	}
	public Class getClassInfo() {
		return classInfo;
	}
	public void setClassInfo(Class classInfo) {
		this.classInfo = classInfo;
	}  
    
}
