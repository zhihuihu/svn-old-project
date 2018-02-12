package com.hxkj.photocms.entity;
/** 
 * Project Name:photocms.server 
 * ClassName:UserSession
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月14日 下午1:54:11 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class UserSession {
	/**
	 * 返回的keyid
	 */
	private String sessionId;
	
	private SysUser sysUser;
	/**
	 * 最后一次访问session时间
	 */
	private String updateTime;
	
	private long updateTimeSecond;
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public long getUpdateTimeSecond() {
		return updateTimeSecond;
	}
	public void setUpdateTimeSecond(long updateTimeSecond) {
		this.updateTimeSecond = updateTimeSecond;
	}
	
	
}
