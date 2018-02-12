package com.dy.weike.entity;

import java.io.Serializable;

/**
 * 问答类
 * @author d-y
 *
 */
public class Ask implements Serializable {

	/**
	 * 添加问答类的序列化ID
	 */
	private static final long serialVersionUID = 50093176669002744L;
	/**
	 * 留言ID
	 */
    private int askId;
    /**
     * 课程ID
     */
    private int classId;
    /**
     * 留言人ID
     */   
    private int askerId;
    /**
     * 回复人ID
     */
    private int anserId;
    /**
     * 留言时间
     */
    private  String askTime;
    /**
     * 留言内容
     */
    private String askText;
    /**
     * 问答状态
     */
    private int askState;
    
    private User anserInfo;


	public int getAskId() {
		return askId;
	}


	public void setAskId(int askId) {
		this.askId = askId;
	}


	public int getClassId() {
		return classId;
	}


	public void setClassId(int classId) {
		this.classId = classId;
	}


	public int getAskerId() {
		return askerId;
	}


	public void setAskerId(int askerId) {
		this.askerId = askerId;
	}


	public int getAnserId() {
		return anserId;
	}


	public void setAnserId(int anserId) {
		this.anserId = anserId;
	}


	public String getAskTime() {
		return askTime;
	}


	public void setAskTime(String askTime) {
		this.askTime = askTime;
	}


	public String getAskText() {
		return askText;
	}


	public void setAskText(String askText) {
		this.askText = askText;
	}


	public int getAskState() {
		return askState;
	}


	public void setAskState(int askState) {
		this.askState = askState;
	}


	public User getAnserInfo() {
		return anserInfo;
	}


	public void setAnserInfo(User anserInfo) {
		this.anserInfo = anserInfo;
	}
	
	
	


	
    
    
	

}
