package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:Chat
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:26:39 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Chat implements Serializable{

	private static final long serialVersionUID = -6668400158606198217L;
	
	//聊天记录表CUID
	private String chatCuid;

	//系统用户CUID
    private String sysUserCuid;

    //聊天记录表LEFTCUID
    private String chatLeftCuid;

    //聊天记录表LEFT名称
    private String chatLeftName;
    
    //聊天记录表RIGHTCUID
    private String chatRightCuid;

    //聊天记录表RIGHT名称
    private String chatRightName;

    //聊天记录表文字内容
    private String chatContent;

    //聊天记录表图片URL
    private String chatPhotoUrl;

    //聊天记录表状态
    private int chatState;

    //聊天记录表创建时间
    private String chatCreateTime;

    //聊天记录表更新时间
    private String chatUpdateTime;

	public String getChatCuid() {
		return chatCuid;
	}

	public void setChatCuid(String chatCuid) {
		this.chatCuid = chatCuid;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getChatLeftCuid() {
		return chatLeftCuid;
	}

	public void setChatLeftCuid(String chatLeftCuid) {
		this.chatLeftCuid = chatLeftCuid;
	}

	public String getChatLeftName() {
		return chatLeftName;
	}

	public void setChatLeftName(String chatLeftName) {
		this.chatLeftName = chatLeftName;
	}

	public String getChatRightCuid() {
		return chatRightCuid;
	}

	public void setChatRightCuid(String chatRightCuid) {
		this.chatRightCuid = chatRightCuid;
	}

	public String getChatRightName() {
		return chatRightName;
	}

	public void setChatRightName(String chatRightName) {
		this.chatRightName = chatRightName;
	}

	public String getChatContent() {
		return chatContent;
	}

	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}

	public String getChatPhotoUrl() {
		return chatPhotoUrl;
	}

	public void setChatPhotoUrl(String chatPhotoUrl) {
		this.chatPhotoUrl = chatPhotoUrl;
	}

	public int getChatState() {
		return chatState;
	}

	public void setChatState(int chatState) {
		this.chatState = chatState;
	}

	public String getChatCreateTime() {
		return chatCreateTime;
	}

	public void setChatCreateTime(String chatCreateTime) {
		this.chatCreateTime = chatCreateTime;
	}

	public String getChatUpdateTime() {
		return chatUpdateTime;
	}

	public void setChatUpdateTime(String chatUpdateTime) {
		this.chatUpdateTime = chatUpdateTime;
	}

    
}
