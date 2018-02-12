package com.cqq.leisure.entity;

import java.io.Serializable;

public class UserActiveComment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8116103878761237997L;
	//用户活动评论ID
	private int userActiveCommentId;
	//用户活动评论用户ID
    private int userActiveCommentUserId;
    //用户活动评论活动ID
    private int userActiveCommentActiveId;
    //用户活动评论标题
    private String userActiveCommentTitle;
    //用户活动评论类型
    private int userActiveCommentType;
    //用户活动评论内容
    private String userActiveCommentContent;
    //用户活动评论地点
    private String userActiveCommentAddress;
    //用户活动评论创建时间
    private String userActiveCommentCreateTime;
    //用户活动评论更新时间
    private String userActiveCommentUpdateTime;
    //实体对象 用户
    private User user;
	public int getUserActiveCommentId() {
		return userActiveCommentId;
	}
	public void setUserActiveCommentId(int userActiveCommentId) {
		this.userActiveCommentId = userActiveCommentId;
	}
	public int getUserActiveCommentUserId() {
		return userActiveCommentUserId;
	}
	public void setUserActiveCommentUserId(int userActiveCommentUserId) {
		this.userActiveCommentUserId = userActiveCommentUserId;
	}
	public int getUserActiveCommentActiveId() {
		return userActiveCommentActiveId;
	}
	public void setUserActiveCommentActiveId(int userActiveCommentActiveId) {
		this.userActiveCommentActiveId = userActiveCommentActiveId;
	}
	public String getUserActiveCommentTitle() {
		return userActiveCommentTitle;
	}
	public void setUserActiveCommentTitle(String userActiveCommentTitle) {
		this.userActiveCommentTitle = userActiveCommentTitle;
	}
	public int getUserActiveCommentType() {
		return userActiveCommentType;
	}
	public void setUserActiveCommentType(int userActiveCommentType) {
		this.userActiveCommentType = userActiveCommentType;
	}
	public String getUserActiveCommentContent() {
		return userActiveCommentContent;
	}
	public void setUserActiveCommentContent(String userActiveCommentContent) {
		this.userActiveCommentContent = userActiveCommentContent;
	}
	public String getUserActiveCommentAddress() {
		return userActiveCommentAddress;
	}
	public void setUserActiveCommentAddress(String userActiveCommentAddress) {
		this.userActiveCommentAddress = userActiveCommentAddress;
	}
	public String getUserActiveCommentCreateTime() {
		return userActiveCommentCreateTime;
	}
	public void setUserActiveCommentCreateTime(String userActiveCommentCreateTime) {
		this.userActiveCommentCreateTime = userActiveCommentCreateTime;
	}
	public String getUserActiveCommentUpdateTime() {
		return userActiveCommentUpdateTime;
	}
	public void setUserActiveCommentUpdateTime(String userActiveCommentUpdateTime) {
		this.userActiveCommentUpdateTime = userActiveCommentUpdateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

    
}
