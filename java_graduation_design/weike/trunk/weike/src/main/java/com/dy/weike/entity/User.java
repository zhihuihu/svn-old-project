package com.dy.weike.entity;

import java.io.Serializable;

/**
 * 用户类
 * @author d-y
 *
 */
public class User implements Serializable {

	/**
	 * 创建用户类的序列化ID
	 */
	private static final long serialVersionUID = -7161694461027894829L;
	/**
	 * 用户ID
	 */	
    private int userId;
    /**
     * 用户邮箱
     */
    private String userEmaile;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户会员判断
     */
    private Boolean userVip;
    /**
     * 微课导师判断
     */
    private Boolean userTeacher;
    /**
     * 用户经验值
     */
    private int userExperience;
    /**
     * 用户兴趣标签
     */
    private String userInterest;
    /**
     * 用户年龄
     */
    private int userAge;
    /**
     * 用户状态
     */
    private int userState;
    /**
     * 用户类型
     */
    private int userType;
    /**
     * 用户学历
     */
    private String userEdu;
    /**
     * 用户创建时间
     */
    private String userCreatetime;
    
    /**
     * 用户昵称
     */
    private String userNickname;
    
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmaile() {
		return userEmaile;
	}
	public void setUserEmaile(String userEmaile) {
		this.userEmaile = userEmaile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getUserVip() {
		return userVip;
	}
	public void setUserVip(Boolean userVip) {
		this.userVip = userVip;
	}
	public Boolean getUserTeacher() {
		return userTeacher;
	}
	public void setUserTeacher(Boolean userTeacher) {
		this.userTeacher = userTeacher;
	}
	public int getUserExperience() {
		return userExperience;
	}
	public void setUserExperience(int userExperience) {
		this.userExperience = userExperience;
	}
	public String getUserInterest() {
		return userInterest;
	}
	public void setUserInterest(String userInterest) {
		this.userInterest = userInterest;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public int getUserState() {
		return userState;
	}
	public void setUserState(int userState) {
		this.userState = userState;
	}
	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public String getUserEdu() {
		return userEdu;
	}
	public void setUserEdu(String userEdu) {
		this.userEdu = userEdu;
	}
	public String getUserCreatetime() {
		return userCreatetime;
	}
	public void setUserCreatetime(String userCreatetime) {
		this.userCreatetime = userCreatetime;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}     
	
}
