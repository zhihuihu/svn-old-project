package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:IntelligentMessage
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:50:14 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class IntelligentMessage implements Serializable {

	private static final long serialVersionUID = -7049304992476706239L;

	//智能消息CUID
	private String intelligentMessageCuid;

	//系统用户CUID
    private String sysUserCuid;

    //智能消息名称
    private String intelligentMessageName;

    //智能消息标题
    private String intelligentMessageTitle;

    //智能消息内容
    private String intelligentMessageContent;

    //智能消息方向
    private int intelligentMessageDirection;

    //智能消息状态
    private int intelligentMessageState;

    //智能消息创建时间
    private String intelligentMessageCreateTime;

    //智能消息更新时间
    private String intelligentMessageUpdateTime;

	public String getIntelligentMessageCuid() {
		return intelligentMessageCuid;
	}

	public void setIntelligentMessageCuid(String intelligentMessageCuid) {
		this.intelligentMessageCuid = intelligentMessageCuid;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getIntelligentMessageName() {
		return intelligentMessageName;
	}

	public void setIntelligentMessageName(String intelligentMessageName) {
		this.intelligentMessageName = intelligentMessageName;
	}

	public String getIntelligentMessageTitle() {
		return intelligentMessageTitle;
	}

	public void setIntelligentMessageTitle(String intelligentMessageTitle) {
		this.intelligentMessageTitle = intelligentMessageTitle;
	}

	public String getIntelligentMessageContent() {
		return intelligentMessageContent;
	}

	public void setIntelligentMessageContent(String intelligentMessageContent) {
		this.intelligentMessageContent = intelligentMessageContent;
	}

	public int getIntelligentMessageDirection() {
		return intelligentMessageDirection;
	}

	public void setIntelligentMessageDirection(int intelligentMessageDirection) {
		this.intelligentMessageDirection = intelligentMessageDirection;
	}

	public int getIntelligentMessageState() {
		return intelligentMessageState;
	}

	public void setIntelligentMessageState(int intelligentMessageState) {
		this.intelligentMessageState = intelligentMessageState;
	}

	public String getIntelligentMessageCreateTime() {
		return intelligentMessageCreateTime;
	}

	public void setIntelligentMessageCreateTime(String intelligentMessageCreateTime) {
		this.intelligentMessageCreateTime = intelligentMessageCreateTime;
	}

	public String getIntelligentMessageUpdateTime() {
		return intelligentMessageUpdateTime;
	}

	public void setIntelligentMessageUpdateTime(String intelligentMessageUpdateTime) {
		this.intelligentMessageUpdateTime = intelligentMessageUpdateTime;
	}
    
    
}
