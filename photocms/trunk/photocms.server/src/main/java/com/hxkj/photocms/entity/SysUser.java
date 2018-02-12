package com.hxkj.photocms.entity;

import java.io.Serializable;

/** 
 * Project Name:photocms.server 
 * ClassName:SysUser
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午6:27:24 
 * @version  1.0 
 * @since    JDK 1.8      
 */
/*SYS_USER_CUID        varchar(255) not null,
USER_TYPE_CUID       varchar(255),
SYS_USER_LOGIN_NAME  varchar(255),
SYS_USER_REL_NAME    varchar(255),
SYS_USER_PASSWORD    varchar(255),
SYS_USER_TELE        varchar(20),
SYS_USER_MAIL        varchar(100),
SYS_USER_ADDRESS     varchar(255),
SYS_USER_VER_CODE    varchar(10),
SYS_USER_CREATE_TIME timestamp,
SYS_USER_UPDATE_TIME timestamp,*/
public class SysUser implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	/*用户CUID*/
	private String sysUserCuid;
	/*用户类型CUID*/
	private String userTypeCuid;
	/*用户登录名*/
	private String sysUserLoginName;
	/*用户真实姓名*/
	private String sysUserRelName;
	/*用户密码*/
	private String sysUserPassword;
	/*用户手机号码*/
	private String sysUserTele;
	/*用户邮箱*/
	private String sysUserMail;
	/*用户地址*/
	private String sysUserAddress;
	/*用户验证码*/
	private String sysUserVerCode;
	/*用户创建时间*/
	private String sysUserCreateTime;
	/*用户更新时间*/
	private String sysUserUpdateTime;
	//对象属性
	/**
	 * 用户类型
	 */
	private UserType userType;
	public String getSysUserCuid() {
		return sysUserCuid;
	}
	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}
	public String getUserTypeCuid() {
		return userTypeCuid;
	}
	public void setUserTypeCuid(String userTypeCuid) {
		this.userTypeCuid = userTypeCuid;
	}
	public String getSysUserLoginName() {
		return sysUserLoginName;
	}
	public void setSysUserLoginName(String sysUserLoginName) {
		this.sysUserLoginName = sysUserLoginName;
	}
	public String getSysUserRelName() {
		return sysUserRelName;
	}
	public void setSysUserRelName(String sysUserRelName) {
		this.sysUserRelName = sysUserRelName;
	}
	public String getSysUserPassword() {
		return sysUserPassword;
	}
	public void setSysUserPassword(String sysUserPassword) {
		this.sysUserPassword = sysUserPassword;
	}
	public String getSysUserTele() {
		return sysUserTele;
	}
	public void setSysUserTele(String sysUserTele) {
		this.sysUserTele = sysUserTele;
	}
	public String getSysUserMail() {
		return sysUserMail;
	}
	public void setSysUserMail(String sysUserMail) {
		this.sysUserMail = sysUserMail;
	}
	public String getSysUserAddress() {
		return sysUserAddress;
	}
	public void setSysUserAddress(String sysUserAddress) {
		this.sysUserAddress = sysUserAddress;
	}
	public String getSysUserVerCode() {
		return sysUserVerCode;
	}
	public void setSysUserVerCode(String sysUserVerCode) {
		this.sysUserVerCode = sysUserVerCode;
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
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
}
