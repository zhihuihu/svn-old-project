package com.hxkj.waychat.entity;

import java.io.Serializable;

/**
 * 好友分组表
 * @ClassName: FriendGroup 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年8月10日 下午2:57:24
 */
public class FriendGroup implements Serializable {

	private static final long serialVersionUID = -1426146736162729099L;

	private String friendGroupCuid;

    private String friendGroupIcon;

    private String sysUserCuid;

    private String friendGroupName;

    private Integer friendGroupOnlineNumber;

    private Integer friendGroupTotalNumber;

    private Integer friendGroupState;

	public String getFriendGroupCuid() {
		return friendGroupCuid;
	}

	public void setFriendGroupCuid(String friendGroupCuid) {
		this.friendGroupCuid = friendGroupCuid;
	}

	public String getFriendGroupIcon() {
		return friendGroupIcon;
	}

	public void setFriendGroupIcon(String friendGroupIcon) {
		this.friendGroupIcon = friendGroupIcon;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getFriendGroupName() {
		return friendGroupName;
	}

	public void setFriendGroupName(String friendGroupName) {
		this.friendGroupName = friendGroupName;
	}

	public Integer getFriendGroupOnlineNumber() {
		return friendGroupOnlineNumber;
	}

	public void setFriendGroupOnlineNumber(Integer friendGroupOnlineNumber) {
		this.friendGroupOnlineNumber = friendGroupOnlineNumber;
	}

	public Integer getFriendGroupTotalNumber() {
		return friendGroupTotalNumber;
	}

	public void setFriendGroupTotalNumber(Integer friendGroupTotalNumber) {
		this.friendGroupTotalNumber = friendGroupTotalNumber;
	}

	public Integer getFriendGroupState() {
		return friendGroupState;
	}

	public void setFriendGroupState(Integer friendGroupState) {
		this.friendGroupState = friendGroupState;
	}
    
    
}
