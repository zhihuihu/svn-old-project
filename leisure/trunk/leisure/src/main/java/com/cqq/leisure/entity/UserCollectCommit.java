package com.cqq.leisure.entity;

import java.io.Serializable;

public class UserCollectCommit  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5947317992349213015L;
	//商家Id
	private Integer merchantId;
	//用户Id
	private Integer userId;
	//评论类型
	private Integer userCollectCommitType;
	//评论状态  (2为产生的空白评论，还未进行评论的状态     1为已经参加过评论)
    private Integer userCollectCommitState;
    //评论标题
    private String userCollectCommitTitle;
    //评论内容
    private String userCollectCommitContent;
    //评论创建时间
    private String userCollectCommitCreateTime;
    //评论更新时间
    private String userCollectCommitUpdateTime;
    
    //实体对象
    //用户对象
    private User user;
	public Integer getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getUserCollectCommitType() {
		return userCollectCommitType;
	}
	public void setUserCollectCommitType(Integer userCollectCommitType) {
		this.userCollectCommitType = userCollectCommitType;
	}
	public Integer getUserCollectCommitState() {
		return userCollectCommitState;
	}
	public void setUserCollectCommitState(Integer userCollectCommitState) {
		this.userCollectCommitState = userCollectCommitState;
	}
	public String getUserCollectCommitTitle() {
		return userCollectCommitTitle;
	}
	public void setUserCollectCommitTitle(String userCollectCommitTitle) {
		this.userCollectCommitTitle = userCollectCommitTitle;
	}
	public String getUserCollectCommitContent() {
		return userCollectCommitContent;
	}
	public void setUserCollectCommitContent(String userCollectCommitContent) {
		this.userCollectCommitContent = userCollectCommitContent;
	}
	public String getUserCollectCommitCreateTime() {
		return userCollectCommitCreateTime;
	}
	public void setUserCollectCommitCreateTime(String string) {
		this.userCollectCommitCreateTime = string;
	}
	public String getUserCollectCommitUpdateTime() {
		return userCollectCommitUpdateTime;
	}
	public void setUserCollectCommitUpdateTime(String userCollectCommitUpdateTime) {
		this.userCollectCommitUpdateTime = userCollectCommitUpdateTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
