package com.vieagr.distribution.param;

import com.vieagr.distribution.param.base.BaseParam;

/**
 * 登录请求对象
 * @author master
 *
 */
public class LoginParam extends BaseParam{
	
	private static final long serialVersionUID = -7007535198203098714L;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 用户类型
	 */
	private Integer userType;
	
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
