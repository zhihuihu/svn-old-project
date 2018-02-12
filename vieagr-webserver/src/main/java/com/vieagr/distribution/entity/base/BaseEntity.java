package com.vieagr.distribution.entity.base;

import java.io.Serializable;

import org.springframework.util.StringUtils;

/**
 * 实体对象父类
 * @author master
 *
 */
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = -4487884687224647270L;

	private Integer currentPage = 1;
	
	private Integer pageSize = 10;
	
	private String searchName;
	
	private String startTime;
	
	private String endTime;

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = !StringUtils.isEmpty(searchName) ? searchName : "";
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
}
