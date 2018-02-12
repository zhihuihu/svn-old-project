package com.hxkj.waychat.entity;

import java.io.Serializable;

/**
 * 系统用户表
 * @ClassName: SysUser 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年8月10日 下午2:56:55
 */
public class SysUser implements Serializable {

	private static final long serialVersionUID = -1679005555586662949L;

	private String sysUserCuid;

    private String sysUserIcon;

    private String sysUserName;

    private String sysUserLikeName;

    private String sysUserLoginName;

    private String sysUserPassword;

    private String sysUserProfile;

    private String sysUserAddress;

    private String sysUserTel;

    private String sysUserEmail;

    private Integer sysUserOnlineState;

    private Integer sysUserState;

    private String sysUserCreateTime;

    private String sysUserUpdateTime;

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getSysUserIcon() {
		return sysUserIcon;
	}

	public void setSysUserIcon(String sysUserIcon) {
		this.sysUserIcon = sysUserIcon;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getSysUserLikeName() {
		return sysUserLikeName;
	}

	public void setSysUserLikeName(String sysUserLikeName) {
		this.sysUserLikeName = sysUserLikeName;
	}

	public String getSysUserLoginName() {
		return sysUserLoginName;
	}

	public void setSysUserLoginName(String sysUserLoginName) {
		this.sysUserLoginName = sysUserLoginName;
	}

	public String getSysUserPassword() {
		return sysUserPassword;
	}

	public void setSysUserPassword(String sysUserPassword) {
		this.sysUserPassword = sysUserPassword;
	}

	public String getSysUserProfile() {
		return sysUserProfile;
	}

	public void setSysUserProfile(String sysUserProfile) {
		this.sysUserProfile = sysUserProfile;
	}

	public String getSysUserAddress() {
		return sysUserAddress;
	}

	public void setSysUserAddress(String sysUserAddress) {
		this.sysUserAddress = sysUserAddress;
	}

	public String getSysUserTel() {
		return sysUserTel;
	}

	public void setSysUserTel(String sysUserTel) {
		this.sysUserTel = sysUserTel;
	}

	public String getSysUserEmail() {
		return sysUserEmail;
	}

	public void setSysUserEmail(String sysUserEmail) {
		this.sysUserEmail = sysUserEmail;
	}

	public Integer getSysUserOnlineState() {
		return sysUserOnlineState;
	}

	public void setSysUserOnlineState(Integer sysUserOnlineState) {
		this.sysUserOnlineState = sysUserOnlineState;
	}

	public Integer getSysUserState() {
		return sysUserState;
	}

	public void setSysUserState(Integer sysUserState) {
		this.sysUserState = sysUserState;
	}

	public String getSysUserCreateTime() {
		return sysUserCreateTime;
	}

	public void setSysUserCreateTime(String sysUserCreateTime) {
		this.sysUserCreateTime = sysUserCreateTime;
	}

	public String getSysUserUpdateTime() {
		return sysUserUpdateTime;
	}

	public void setSysUserUpdateTime(String sysUserUpdateTime) {
		this.sysUserUpdateTime = sysUserUpdateTime;
	}
    
    
}
