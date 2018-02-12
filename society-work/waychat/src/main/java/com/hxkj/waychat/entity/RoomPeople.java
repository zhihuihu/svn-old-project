package com.hxkj.waychat.entity;

import java.io.Serializable;

/**
 * 聊天室拥有的用户
 * @ClassName: RoomPeople 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年8月10日 下午2:57:04
 */
public class RoomPeople implements Serializable {

	private static final long serialVersionUID = 2819262829592000731L;
	
	private String roomPeopleCuid;

    private String chatRoomCuid;

    private String sysUserCuid;

    private Integer roomPeopleState;

    private String roomPeopleCreateTime;

	public String getRoomPeopleCuid() {
		return roomPeopleCuid;
	}

	public void setRoomPeopleCuid(String roomPeopleCuid) {
		this.roomPeopleCuid = roomPeopleCuid;
	}

	public String getChatRoomCuid() {
		return chatRoomCuid;
	}

	public void setChatRoomCuid(String chatRoomCuid) {
		this.chatRoomCuid = chatRoomCuid;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public Integer getRoomPeopleState() {
		return roomPeopleState;
	}

	public void setRoomPeopleState(Integer roomPeopleState) {
		this.roomPeopleState = roomPeopleState;
	}

	public String getRoomPeopleCreateTime() {
		return roomPeopleCreateTime;
	}

	public void setRoomPeopleCreateTime(String roomPeopleCreateTime) {
		this.roomPeopleCreateTime = roomPeopleCreateTime;
	}

    
}
