package com.hxkj.waychat.entity;

import java.io.Serializable;

/**
 * 好友表
 * @ClassName: Friend 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年8月10日 下午2:57:37
 */
public class Friend implements Serializable {

	private static final long serialVersionUID = -6963535583726020172L;

	private String friendCuid;

    private String friendGroupCuid;

    private String friendDesSysUserCuid;

    private String friendOriLikeName;

    private String friendDesLikeName;

    private String friendChatLink;

    private String friendState;

    private String friendCreateTime;

	public String getFriendCuid() {
		return friendCuid;
	}

	public void setFriendCuid(String friendCuid) {
		this.friendCuid = friendCuid;
	}

	public String getFriendGroupCuid() {
		return friendGroupCuid;
	}

	public void setFriendGroupCuid(String friendGroupCuid) {
		this.friendGroupCuid = friendGroupCuid;
	}

	public String getFriendDesSysUserCuid() {
		return friendDesSysUserCuid;
	}

	public void setFriendDesSysUserCuid(String friendDesSysUserCuid) {
		this.friendDesSysUserCuid = friendDesSysUserCuid;
	}

	public String getFriendOriLikeName() {
		return friendOriLikeName;
	}

	public void setFriendOriLikeName(String friendOriLikeName) {
		this.friendOriLikeName = friendOriLikeName;
	}

	public String getFriendDesLikeName() {
		return friendDesLikeName;
	}

	public void setFriendDesLikeName(String friendDesLikeName) {
		this.friendDesLikeName = friendDesLikeName;
	}

	public String getFriendChatLink() {
		return friendChatLink;
	}

	public void setFriendChatLink(String friendChatLink) {
		this.friendChatLink = friendChatLink;
	}

	public String getFriendState() {
		return friendState;
	}

	public void setFriendState(String friendState) {
		this.friendState = friendState;
	}

	public String getFriendCreateTime() {
		return friendCreateTime;
	}

	public void setFriendCreateTime(String friendCreateTime) {
		this.friendCreateTime = friendCreateTime;
	}
    
    
}
