package com.hxkj.waychat.entity;

import java.io.Serializable;

/**
 * 聊天历史表
 * @ClassName: ChatHistory 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年8月10日 下午2:50:27
 */
public class ChatHistory implements Serializable {

	private static final long serialVersionUID = -7038187232037308853L;

	private String chatHistoryCuid;

    private String roomOrUserCuid;

    private String sysUserCuid;

    private String chatHistoryContent;

    private String chatHistoryFile;

    private Integer chatHistoryState;

    private String chatHistoryCreateTime;

	public String getChatHistoryCuid() {
		return chatHistoryCuid;
	}

	public void setChatHistoryCuid(String chatHistoryCuid) {
		this.chatHistoryCuid = chatHistoryCuid;
	}

	public String getRoomOrUserCuid() {
		return roomOrUserCuid;
	}

	public void setRoomOrUserCuid(String roomOrUserCuid) {
		this.roomOrUserCuid = roomOrUserCuid;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getChatHistoryContent() {
		return chatHistoryContent;
	}

	public void setChatHistoryContent(String chatHistoryContent) {
		this.chatHistoryContent = chatHistoryContent;
	}

	public String getChatHistoryFile() {
		return chatHistoryFile;
	}

	public void setChatHistoryFile(String chatHistoryFile) {
		this.chatHistoryFile = chatHistoryFile;
	}

	public Integer getChatHistoryState() {
		return chatHistoryState;
	}

	public void setChatHistoryState(Integer chatHistoryState) {
		this.chatHistoryState = chatHistoryState;
	}

	public String getChatHistoryCreateTime() {
		return chatHistoryCreateTime;
	}

	public void setChatHistoryCreateTime(String chatHistoryCreateTime) {
		this.chatHistoryCreateTime = chatHistoryCreateTime;
	}
    
    
}
