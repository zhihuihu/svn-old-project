package com.cqq.leisure.entity;

import java.util.List;

/** 
 * ClassName:PageBean
 * Function: TODO ADD FUNCTION.   
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class PageBean<B> {

	private int currentPage;
	private int startLine;
	private int lineSize;
	private String searchName;
	private String startTime;
	private String endTime;
	private List<String> orderBys;
	private String orderByString;
	private B b;

	public PageBean(int currentPage, int lineSize) {
		this.lineSize = lineSize;
		this.currentPage = currentPage;
		this.startLine = ((currentPage < 1 ? 1 : currentPage) - 1) * lineSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getLineSize() {
		return lineSize;
	}

	public B getInVo() {
		return b;
	}

	public void setInVo(B b) {
		this.b = b;
	}
	
	public int getStartLine() {
		return startLine;
	}

	public void setStartLine(int startLine) {
		this.startLine = startLine;
	}

	public List<String> getOrderBys() {
		return orderBys;
	}

	public void setOrderBys(List<String> orderBys) {
		this.orderBys = orderBys;
	}

	public String getOrderByString() {
		return orderByString;
	}

	public void setOrderByString(String orderByString) {
		this.orderByString = orderByString;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
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