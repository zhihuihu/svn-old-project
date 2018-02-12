package com.hxkj.photocms.entity;

import java.io.Serializable;

/** 
 * Project Name:photocms.server 
 * ClassName:SpecialContent
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午6:45:09 
 * @version  1.0 
 * @since    JDK 1.8      
 */
/*SPECIAL_CONTENT_CUID varchar(255) not null,
SPECIAL_CUID         varchar(255),
SPECIAL_CONTENT_NAME varchar(100),
SPECIAL_CONTENT_THUMB_URL varchar(255),
SPECIAL_CONTENT_MAIN_URL varchar(255),
SPECIAL_CONTENT_SHOW varchar(5),
SPECIAL_CONTENT_CREATE_USER varchar(255),
SPECIAL_CONTENT_AUTHOR varchar(100),
SPECIAL_CONTENT_CREATE_ADDRESS varchar(255),
SPECIAL_CONTENT_CREATE_TIME timestamp,
SPECIAL_CONTENT_UPDATE_TIME timestamp,*/
public class SpecialContent implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	
	/*专辑内容CUID*/
	private String specialContentCuid;
	/*专辑CUID*/
	private String specialCuid;
	/*专辑内容名称*/
	private String specialContentName;
	/*专辑内容缩略图*/
	private String specialContentThumbUrl;
	/*专辑内容主内容*/
	private String specialContentMainUrl;
	/*专辑内容是否显示 1：显示  2：隐藏*/
	private String specialContentShow;
	/*专辑内容是否为主页显示*/
	private String specialContentHot;
	/*专辑内容创建者*/
	private String specialContentCreateUser;
	/*专辑内容作者*/
	private String specialContentAuthor;
	/*专辑内容 产生地址*/
	private String specialContentCreateAddress;
	/*专辑内容创建时间*/
	private String specialContentCreateTime;
	/*专辑内容更新时间*/
	private String specialContentUpdateTime;
	//对象属性
	/**
	 * 专辑属性
	 */
	private Special special;
	public String getSpecialContentCuid() {
		return specialContentCuid;
	}
	public void setSpecialContentCuid(String specialContentCuid) {
		this.specialContentCuid = specialContentCuid;
	}
	public String getSpecialCuid() {
		return specialCuid;
	}
	public void setSpecialCuid(String specialCuid) {
		this.specialCuid = specialCuid;
	}
	public String getSpecialContentName() {
		return specialContentName;
	}
	public void setSpecialContentName(String specialContentName) {
		this.specialContentName = specialContentName;
	}
	public String getSpecialContentThumbUrl() {
		return specialContentThumbUrl;
	}
	public void setSpecialContentThumbUrl(String specialContentThumbUrl) {
		this.specialContentThumbUrl = specialContentThumbUrl;
	}
	public String getSpecialContentMainUrl() {
		return specialContentMainUrl;
	}
	public void setSpecialContentMainUrl(String specialContentMainUrl) {
		this.specialContentMainUrl = specialContentMainUrl;
	}
	public String getSpecialContentShow() {
		return specialContentShow;
	}
	public void setSpecialContentShow(String specialContentShow) {
		this.specialContentShow = specialContentShow;
	}
	public String getSpecialContentCreateUser() {
		return specialContentCreateUser;
	}
	public void setSpecialContentCreateUser(String specialContentCreateUser) {
		this.specialContentCreateUser = specialContentCreateUser;
	}
	public String getSpecialContentAuthor() {
		return specialContentAuthor;
	}
	public void setSpecialContentAuthor(String specialContentAuthor) {
		this.specialContentAuthor = specialContentAuthor;
	}
	public String getSpecialContentCreateAddress() {
		return specialContentCreateAddress;
	}
	public void setSpecialContentCreateAddress(String specialContentCreateAddress) {
		this.specialContentCreateAddress = specialContentCreateAddress;
	}
	public String getSpecialContentCreateTime() {
		return specialContentCreateTime;
	}
	public void setSpecialContentCreateTime(String specialContentCreateTime) {
		this.specialContentCreateTime = specialContentCreateTime;
	}
	public String getSpecialContentUpdateTime() {
		return specialContentUpdateTime;
	}
	public void setSpecialContentUpdateTime(String specialContentUpdateTime) {
		this.specialContentUpdateTime = specialContentUpdateTime;
	}
	public Special getSpecial() {
		return special;
	}
	public void setSpecial(Special special) {
		this.special = special;
	}
	public String getSpecialContentHot() {
		return specialContentHot;
	}
	public void setSpecialContentHot(String specialContentHot) {
		this.specialContentHot = specialContentHot;
	}
	
	

}
