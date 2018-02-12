package com.hxkj.photocms.entity;

import java.io.Serializable;
import java.util.List;

/** 
 * Project Name:photocms.server 
 * ClassName:UserType
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午5:54:19 
 * @version  1.0 
 * @since    JDK 1.8      
 */
/*USER_TYPE_CUID       varchar(255) not null,
USER_TYPE_NAME       varchar(255),
USER_TYPE_CODE       varchar(255),
USER_TYPE_CREATE_TIME timestamp,*/
public class UserType implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	/*用户类型CUID*/
	private String userTypeCuid;
	/*用户类型名称*/
	private String userTypeName;
	/*用户类型编码*/
	private String userTypeCode;
	/*用户类型创建时间*/
	private String userTypeCreateTime;
	
	//对象属性
	/*用户List*/
	private List<SysUser> sysUsers;
	
	public String getUserTypeCuid() {
		return userTypeCuid;
	}

	public void setUserTypeCuid(String userTypeCuid) {
		this.userTypeCuid = userTypeCuid;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public String getUserTypeCode() {
		return userTypeCode;
	}

	public void setUserTypeCode(String userTypeCode) {
		this.userTypeCode = userTypeCode;
	}

	public String getUserTypeCreateTime() {
		return userTypeCreateTime;
	}

	public void setUserTypeCreateTime(String userTypeCreateTime) {
		this.userTypeCreateTime = userTypeCreateTime;
	}

	public List<SysUser> getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(List<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}
	
	
	
}
