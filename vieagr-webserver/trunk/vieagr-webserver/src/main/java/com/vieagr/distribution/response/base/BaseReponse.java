package com.vieagr.distribution.response.base;

import java.io.Serializable;

import com.vieagr.distribution.entity.base.BaseEntity;

/**
 * 请求返回参数对象父类
 * @author master
 *
 */
public class BaseReponse implements Serializable{

	private static final long serialVersionUID = 469253240646139936L;
	
	/**
	 * 返回状态码
	 */
	private String code;
	/**
	 * 返回状态信息
	 */
	private String message;
	/**
	 * 对象实体
	 */
	private BaseEntity baseEntity;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BaseEntity getBaseEntity() {
		return baseEntity;
	}

	public void setBaseEntity(BaseEntity baseEntity) {
		this.baseEntity = baseEntity;
	}
	
}
