package com.cqq.leisure.entity;

import java.io.Serializable;

/**
 * 用户实体层
 * @author CQQ
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -4129919869678153738L;

	//用户id
	private int userId;

	//用户头像
    private String userIconUrl;

    //用户登录名
    private String userLoginName;

    //用户真实名称
    private String userRelName;

    //用户登录密码
    private String userPassword;

    //用户兴趣爱好
    private String userHobby;

    //用户主要区域
    private String userMainRange;

    //用户活动区域
    private String userActiveRange;

    //用户类型
    private String userType;

    //用户状态
    private int userState;

    //用户电话号码
    private String userTele;

    //用户邮箱
    private String userEmail;

    //用户GPS地址
    private String userGpsAddress;

    //用户经度
    private String userLog;

    //用户纬度
    private String userLat;

    //用户创建时间
    private String userCreateTime;
    
    //用户更新时间
    private String userUpdateTime;
    
    //用户身份证号
    private String userIdCode;
    //用户验证码
    private String userVerCode;

	public String getUserIdCode() {
		return userIdCode;
	}

	public void setUserIdCode(String userIdCode) {
		this.userIdCode = userIdCode;
	}

	public String getUserVerCode() {
		return userVerCode;
	}

	public void setUserVerCode(String userVerCode) {
		this.userVerCode = userVerCode;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserIconUrl() {
		return userIconUrl;
	}

	public void setUserIconUrl(String userIconUrl) {
		this.userIconUrl = userIconUrl;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public String getUserRelName() {
		return userRelName;
	}

	public void setUserRelName(String userRelName) {
		this.userRelName = userRelName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserHobby() {
		return userHobby;
	}

	public void setUserHobby(String userHobby) {
		this.userHobby = userHobby;
	}

	public String getUserMainRange() {
		return userMainRange;
	}

	public void setUserMainRange(String userMainRange) {
		this.userMainRange = userMainRange;
	}

	public String getUserActiveRange() {
		return userActiveRange;
	}

	public void setUserActiveRange(String userActiveRange) {
		this.userActiveRange = userActiveRange;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public String getUserTele() {
		return userTele;
	}

	public void setUserTele(String userTele) {
		this.userTele = userTele;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserGpsAddress() {
		return userGpsAddress;
	}

	public void setUserGpsAddress(String userGpsAddress) {
		this.userGpsAddress = userGpsAddress;
	}

	public String getUserLog() {
		return userLog;
	}

	public void setUserLog(String userLog) {
		this.userLog = userLog;
	}

	public String getUserLat() {
		return userLat;
	}

	public void setUserLat(String userLat) {
		this.userLat = userLat;
	}

	public String getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(String userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public String getUserUpdateTime() {
		return userUpdateTime;
	}

	public void setUserUpdateTime(String userUpdateTime) {
		this.userUpdateTime = userUpdateTime;
	}

    
    
}
