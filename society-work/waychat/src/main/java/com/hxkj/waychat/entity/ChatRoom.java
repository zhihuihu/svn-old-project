package com.hxkj.waychat.entity;

import java.io.Serializable;

/**
 * 聊天室表
 * @ClassName: ChatRoom 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年8月10日 下午2:57:46
 */
public class ChatRoom implements Serializable {

	private static final long serialVersionUID = -6594863580955784262L;

	private String chatRoomCuid;

    private String chatRoomIcon;

    private String chatRoomName;

    private String chatRoomCreateSysUserCuid;

    private String chatRoomChatLink;

    private String chatRoomCreateTime;

    private Integer chatRoomNumber;

	public String getChatRoomCuid() {
		return chatRoomCuid;
	}

	public void setChatRoomCuid(String chatRoomCuid) {
		this.chatRoomCuid = chatRoomCuid;
	}

	public String getChatRoomIcon() {
		return chatRoomIcon;
	}

	public void setChatRoomIcon(String chatRoomIcon) {
		this.chatRoomIcon = chatRoomIcon;
	}

	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}

	public String getChatRoomCreateSysUserCuid() {
		return chatRoomCreateSysUserCuid;
	}

	public void setChatRoomCreateSysUserCuid(String chatRoomCreateSysUserCuid) {
		this.chatRoomCreateSysUserCuid = chatRoomCreateSysUserCuid;
	}

	public String getChatRoomChatLink() {
		return chatRoomChatLink;
	}

	public void setChatRoomChatLink(String chatRoomChatLink) {
		this.chatRoomChatLink = chatRoomChatLink;
	}

	public String getChatRoomCreateTime() {
		return chatRoomCreateTime;
	}

	public void setChatRoomCreateTime(String chatRoomCreateTime) {
		this.chatRoomCreateTime = chatRoomCreateTime;
	}

	public Integer getChatRoomNumber() {
		return chatRoomNumber;
	}

	public void setChatRoomNumber(Integer chatRoomNumber) {
		this.chatRoomNumber = chatRoomNumber;
	}
    
    
}
