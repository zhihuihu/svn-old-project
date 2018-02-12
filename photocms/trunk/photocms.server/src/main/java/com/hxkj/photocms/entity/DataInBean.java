package com.hxkj.photocms.entity;

import java.util.List;

/** 
 * Project Name:photocms.server 
 * ClassName:DataInBean
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月14日 下午3:11:43 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class DataInBean {

	/**
	 * 为用户保存的sessionId
	 */
	private String sessionId;
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 一页大小
	 */
	private int lineSize;
	
	/**
	 * 用户
	 */
	private SysUser sysUser;
	
	/**
	 * 数据类型
	 */
	private DataType dataType;
	
	private SpecialType specialType;
	
	private Special special;
	
	private SpecialContent specialContent;
	
	private List<SpecialContent> specialContents;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

	public SpecialType getSpecialType() {
		return specialType;
	}

	public void setSpecialType(SpecialType specialType) {
		this.specialType = specialType;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLineSize() {
		return lineSize;
	}

	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}

	public Special getSpecial() {
		return special;
	}

	public void setSpecial(Special special) {
		this.special = special;
	}

	public SpecialContent getSpecialContent() {
		return specialContent;
	}

	public void setSpecialContent(SpecialContent specialContent) {
		this.specialContent = specialContent;
	}

	public List<SpecialContent> getSpecialContents() {
		return specialContents;
	}

	public void setSpecialContents(List<SpecialContent> specialContents) {
		this.specialContents = specialContents;
	}
	
	
}
