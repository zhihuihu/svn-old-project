package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:KeyLog
 * Function:   关键日志	这里根据state的不同,作为了用户的信息反馈 state为10位用户反馈
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:52:20 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class KeyLog implements Serializable {

	private static final long serialVersionUID = 449690034186712795L;

	//关键日志CUID
	private String keyLogCuid;

	//关键日志名称
    private String keyLogName;

    //关键日志内容
    private String keyLogContent;

    //关键日志操作人
    private String keyLogPeople;

    //关键日志状态
    private int keyLogState;

    //关键日志创建时间
    private String keyLogCreateTime;

	public String getKeyLogCuid() {
		return keyLogCuid;
	}

	public void setKeyLogCuid(String keyLogCuid) {
		this.keyLogCuid = keyLogCuid;
	}

	public String getKeyLogName() {
		return keyLogName;
	}

	public void setKeyLogName(String keyLogName) {
		this.keyLogName = keyLogName;
	}

	public String getKeyLogContent() {
		return keyLogContent;
	}

	public void setKeyLogContent(String keyLogContent) {
		this.keyLogContent = keyLogContent;
	}

	public String getKeyLogPeople() {
		return keyLogPeople;
	}

	public void setKeyLogPeople(String keyLogPeople) {
		this.keyLogPeople = keyLogPeople;
	}

	public int getKeyLogState() {
		return keyLogState;
	}

	public void setKeyLogState(int keyLogState) {
		this.keyLogState = keyLogState;
	}

	public String getKeyLogCreateTime() {
		return keyLogCreateTime;
	}

	public void setKeyLogCreateTime(String keyLogCreateTime) {
		this.keyLogCreateTime = keyLogCreateTime;
	}
    
    
}
