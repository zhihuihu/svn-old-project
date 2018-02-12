package com.vieagr.distribution.query.base;

import java.io.Serializable;

/**
 * 查询参数封装对象父类
 * @author master
 *
 */
public class BaseQuery implements Serializable{

	private static final long serialVersionUID = -8812185640996472283L;

	/**
	 *	当前页码
	 */
	private Integer currentPage;
	/**
	 * 每页条数
	 */
	private Integer pageSize;
	/**
	 * 查询关键字
	 */
	private String searchName;
	
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
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
	
}
