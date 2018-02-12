package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:Friend
 * Function:   用户好友表
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:42:17 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Friend implements Serializable {

	private static final long serialVersionUID = -7106084366519036819L;

	//用户好友表CUID
	private String friendCuid;

	//系统用户CUID
    private String sysUserCuid;

    //用户好友表用户CUID
    private String friendRealCuid;

    //用户好友表好友昵称
    private String friendFriendName;

    //用户好友表好友CUID
    private String friendFriendCuids;

    //用户好友表添加时间
    private String friendAddTime;

    //用户好友表状态
    private int friendState;

    //用户好友表创建时间
    private String friendCreateTime;

    //用户好友表更新时间
    private String friendUpdateTime;

	public String getFriendCuid() {
		return friendCuid;
	}

	public void setFriendCuid(String friendCuid) {
		this.friendCuid = friendCuid;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getFriendRealCuid() {
		return friendRealCuid;
	}

	public void setFriendRealCuid(String friendRealCuid) {
		this.friendRealCuid = friendRealCuid;
	}

	public String getFriendFriendName() {
		return friendFriendName;
	}

	public void setFriendFriendName(String friendFriendName) {
		this.friendFriendName = friendFriendName;
	}

	public String getFriendFriendCuids() {
		return friendFriendCuids;
	}

	public void setFriendFriendCuids(String friendFriendCuids) {
		this.friendFriendCuids = friendFriendCuids;
	}

	public String getFriendAddTime() {
		return friendAddTime;
	}

	public void setFriendAddTime(String friendAddTime) {
		this.friendAddTime = friendAddTime;
	}

	public int getFriendState() {
		return friendState;
	}

	public void setFriendState(int friendState) {
		this.friendState = friendState;
	}

	public String getFriendCreateTime() {
		return friendCreateTime;
	}

	public void setFriendCreateTime(String friendCreateTime) {
		this.friendCreateTime = friendCreateTime;
	}

	public String getFriendUpdateTime() {
		return friendUpdateTime;
	}

	public void setFriendUpdateTime(String friendUpdateTime) {
		this.friendUpdateTime = friendUpdateTime;
	}
    
    
}
