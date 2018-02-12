package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:SysUser
 * Function:   系统用户
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午1:45:54 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class SysUser implements Serializable {

	private static final long serialVersionUID = 6372418621898369350L;

	//系统用户CUID
	private String sysUserCuid;

	//专业CUID
    private String majorCuid;

    //系统用户名称
    private String sysUserName;

    //系统用户真实名称
    private String sysUserRealName;

    //系统用户登录名
    private String sysUserLoginName;

    //    系统用户登录密码
    private String sysUserPassword;
    
    //系统用户类型
    private int sysUserType;

    //系统用户邮箱
    private String sysUserEmail;

    //系统用户性别
    private int sysUserSex;

    //系统用户年龄
    private int sysUserAge;

    //系统用户电话
    private String sysUserTele;

    //系统用户验证码
    private String sysUserVerCode;

    //系统用户头像'
    private String sysUserUrl;

    //系统用户个人简介
    private String sysUserSignature;
    
    //系统用户学院
    private String sysUserCollege;
    
    //系统用户专业
    private String sysUserMagor;

    //系统用户报考学校
    private String sysUserForSchool;
    
    //系统用户报考专业
    private String sysUserForMagor;
    
    //系统用户标签'
    private String sysUserLabel;

    //系统用户地址',
    private String sysUserAddress;

    //系统用户定位地址
    private String sysUserGpsAddress;

    //系统用户状态
    private int sysUserState;

    //系统用户创建时间
    private String sysUserCreateTime;

    //系统用户更新时间
    private String sysUserUpdateTime;

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getMajorCuid() {
		return majorCuid;
	}

	public void setMajorCuid(String majorCuid) {
		this.majorCuid = majorCuid;
	}

	public String getSysUserName() {
		return sysUserName;
	}

	public void setSysUserName(String sysUserName) {
		this.sysUserName = sysUserName;
	}

	public String getSysUserRealName() {
		return sysUserRealName;
	}

	public void setSysUserRealName(String sysUserRealName) {
		this.sysUserRealName = sysUserRealName;
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

	public String getSysUserEmail() {
		return sysUserEmail;
	}

	public void setSysUserEmail(String sysUserEmail) {
		this.sysUserEmail = sysUserEmail;
	}

	public int getSysUserSex() {
		return sysUserSex;
	}

	public void setSysUserSex(int sysUserSex) {
		this.sysUserSex = sysUserSex;
	}

	public int getSysUserAge() {
		return sysUserAge;
	}

	public void setSysUserAge(int sysUserAge) {
		this.sysUserAge = sysUserAge;
	}

	public String getSysUserTele() {
		return sysUserTele;
	}

	public void setSysUserTele(String sysUserTele) {
		this.sysUserTele = sysUserTele;
	}

	public String getSysUserVerCode() {
		return sysUserVerCode;
	}

	public void setSysUserVerCode(String sysUserVerCode) {
		this.sysUserVerCode = sysUserVerCode;
	}

	public String getSysUserUrl() {
		return sysUserUrl;
	}

	public void setSysUserUrl(String sysUserUrl) {
		this.sysUserUrl = sysUserUrl;
	}

	public String getSysUserSignature() {
		return sysUserSignature;
	}

	public void setSysUserSignature(String sysUserSignature) {
		this.sysUserSignature = sysUserSignature;
	}

	public String getSysUserLabel() {
		return sysUserLabel;
	}

	public void setSysUserLabel(String sysUserLabel) {
		this.sysUserLabel = sysUserLabel;
	}

	public String getSysUserAddress() {
		return sysUserAddress;
	}

	public void setSysUserAddress(String sysUserAddress) {
		this.sysUserAddress = sysUserAddress;
	}

	public String getSysUserGpsAddress() {
		return sysUserGpsAddress;
	}

	public void setSysUserGpsAddress(String sysUserGpsAddress) {
		this.sysUserGpsAddress = sysUserGpsAddress;
	}

	public int getSysUserState() {
		return sysUserState;
	}

	public void setSysUserState(int sysUserState) {
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

	public int getSysUserType() {
		return sysUserType;
	}

	public void setSysUserType(int sysUserType) {
		this.sysUserType = sysUserType;
	}

	public String getSysUserCollege() {
		return sysUserCollege;
	}

	public void setSysUserCollege(String sysUserCollege) {
		this.sysUserCollege = sysUserCollege;
	}

	public String getSysUserMagor() {
		return sysUserMagor;
	}

	public void setSysUserMagor(String sysUserMagor) {
		this.sysUserMagor = sysUserMagor;
	}

	public String getSysUserForSchool() {
		return sysUserForSchool;
	}

	public void setSysUserForSchool(String sysUserForSchool) {
		this.sysUserForSchool = sysUserForSchool;
	}

	public String getSysUserForMagor() {
		return sysUserForMagor;
	}

	public void setSysUserForMagor(String sysUserForMagor) {
		this.sysUserForMagor = sysUserForMagor;
	}
    
    
}
