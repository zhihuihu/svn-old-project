package com.cqq.leisure.entity;

import java.io.Serializable;

public class UserTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2663458078350357507L;
	
	//标签_ID
    private Integer tagId;

    //用户ID
    private Integer userId;

	//用户_标签_点击次数
	private Integer userTagPressNumber;

    //用户_标签状态（1：点击一次；2：加入收藏）
    private Integer userTagState;

    //实体类属性
    private Tag tag;
    
	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getUserTagPressNumber() {
		return userTagPressNumber;
	}

	public void setUserTagPressNumber(Integer userTagPressNumber) {
		this.userTagPressNumber = userTagPressNumber;
	}

	public Integer getUserTagState() {
		return userTagState;
	}

	public void setUserTagState(Integer userTagState) {
		this.userTagState = userTagState;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
    

}
