package com.dy.weike.entity;

import java.io.Serializable;

/**
 * 课时类
 * @author d-y
 *
 */
public class ClassSession implements Serializable {

	/**
	 * 创建课时类序列号ID
	 */
	private static final long serialVersionUID = 530906639584987400L;
	/**
	 * 课时ID
	 */	
    private int sessionId;
    /**
     * 课程ID
     */
    private int classId;
    /**
     * 课时名称
     */
    private String sessionName;
    /**
     * 课时链接
     */
    private String sessionUrl;
    /**
     * 课时是否免费
     */
    private Boolean  sessionFree;
    /**
     * 课时经验值
     */
    private int sessionValue;
    /**
     * 课程上传日期
     */
    private String sessionBrith;
    
	public int getSessionId() {
		return sessionId;
	}
	public void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getSessionName() {
		return sessionName;
	}
	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}
	public String getSessionUrl() {
		return sessionUrl;
	}
	public void setSessionUrl(String sessionUrl) {
		this.sessionUrl = sessionUrl;
	}
	public Boolean getSessionFree() {
		return sessionFree;
	}
	public void setSessionFree(Boolean sessionFree) {
		this.sessionFree = sessionFree;
	}
	public int getSessionValue() {
		return sessionValue;
	}
	public void setSessionValue(int sessionValue) {
		this.sessionValue = sessionValue;
	}
	public String getSessionBrith() {
		return sessionBrith;
	}
	public void setSessionBrith(String sessionBrith) {
		this.sessionBrith = sessionBrith;
	}
    
    

}
