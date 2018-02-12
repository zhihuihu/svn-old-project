package com.hxkj.photocms.entity;

import java.io.Serializable;
import java.util.List;

/** 
 * Project Name:photocms.server 
 * ClassName:Special
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午6:54:35 
 * @version  1.0 
 * @since    JDK 1.8      
 */
/*SPECIAL_CUID         varchar(255) not null,
SPECIAL_TYPE_CUID    varchar(255),
SPECIAL_NAME         varchar(100),
SPECIAL_TOTAL_NUMBER int,
SPECIAL_SHOW         varchar(5),
SPECIAL_MAIN_IMG_URL varchar(255),
SPECIAL_LABEL        varchar(100),
SPECIAL_AUTHOR       varchar(100),
SPECIAL_CREATE_ADDRESS varchar(100),
SPECIAL_CREATE_TIME  timestamp,
SPECIAL_UPDATE_TIME  timestamp,*/
public class Special implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	/**
	 * 专辑CUID
	 */
	private String specialCuid;
	/**
	 * 专辑类型CUID
	 */
	private String specialTypeCuid;
	/**
	 * 专辑名称
	 */
	private String specialName;
	/**
	 * 专辑对应的内容总数
	 */
	private int specialTotalNumber;
	/**
	 * 专辑是否显示 1：显示  2：隐藏
	 */
	private String specialShow;
	/**
	 * 专辑主图缩略图
	 */
	private String specialMainImgUrl;
	/**
	 * 专辑标签
	 */
	private String specialLabel;
	/**
	 * 专辑主要作者
	 */
	private String specialAuthor;
	/**
	 * 专辑主要拍摄地址
	 */
	private String specialCreateAddress;
	/**
	 * 专辑创建时间
	 */
	private String specialCreateTime;
	/**
	 * 专辑更新时间
	 */
	private String specialUpdataTime;
	/**
	 * 专辑更新时间
	 */
	//对象属性
	/**
	 * 专辑类型
	 */
	private SpecialType specialType;
	/**
	 * 专辑对应实际内容List
	 */
	private List<SpecialContent> specialContents;
	private String specialUpdateTime;
	public String getSpecialCuid() {
		return specialCuid;
	}
	public void setSpecialCuid(String specialCuid) {
		this.specialCuid = specialCuid;
	}
	public String getSpecialTypeCuid() {
		return specialTypeCuid;
	}
	public void setSpecialTypeCuid(String specialTypeCuid) {
		this.specialTypeCuid = specialTypeCuid;
	}
	public String getSpecialName() {
		return specialName;
	}
	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}
	public int getSpecialTotalNumber() {
		return specialTotalNumber;
	}
	public void setSpecialTotalNumber(int specialTotalNumber) {
		this.specialTotalNumber = specialTotalNumber;
	}
	public String getSpecialShow() {
		return specialShow;
	}
	public void setSpecialShow(String specialShow) {
		this.specialShow = specialShow;
	}
	public String getSpecialMainImgUrl() {
		return specialMainImgUrl;
	}
	public void setSpecialMainImgUrl(String specialMainImgUrl) {
		this.specialMainImgUrl = specialMainImgUrl;
	}
	public String getSpecialLabel() {
		return specialLabel;
	}
	public void setSpecialLabel(String specialLabel) {
		this.specialLabel = specialLabel;
	}
	public String getSpecialAuthor() {
		return specialAuthor;
	}
	public void setSpecialAuthor(String specialAuthor) {
		this.specialAuthor = specialAuthor;
	}
	public String getSpecialCreateAddress() {
		return specialCreateAddress;
	}
	public void setSpecialCreateAddress(String specialCreateAddress) {
		this.specialCreateAddress = specialCreateAddress;
	}
	public String getSpecialCreateTime() {
		return specialCreateTime;
	}
	public void setSpecialCreateTime(String specialCreateTime) {
		this.specialCreateTime = specialCreateTime;
	}
	public String getSpecialUpdateTime() {
		return specialUpdateTime;
	}
	public void setSpecialUpdateTime(String specialUpdateTime) {
		this.specialUpdateTime = specialUpdateTime;
	}
	public SpecialType getSpecialType() {
		return specialType;
	}
	public void setSpecialType(SpecialType specialType) {
		this.specialType = specialType;
	}
	public List<SpecialContent> getSpecialContents() {
		return specialContents;
	}
	public void setSpecialContents(List<SpecialContent> specialContents) {
		this.specialContents = specialContents;
	}
	public String getSpecialUpdataTime() {
		return specialUpdataTime;
	}
	public void setSpecialUpdataTime(String specialUpdataTime) {
		this.specialUpdataTime = specialUpdataTime;
	}
	
	
}
