package com.hxkj.xhupubmed.entity;

import java.util.List;

/** 
 * ClassName:PageBean
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月2日 下午5:07:54 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class PageBean<B> {

	private int currentPage;
	private int startLine;
	private int lineSize;
	private List<String> orderBys;
	private String orderByString;
	private B b;
	private String startTime;
	private String endTime;
	private String searchName;
	private String searchName2;
	private String searchName3;

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

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchName2() {
		return searchName2;
	}

	public void setSearchName2(String searchName2) {
		this.searchName2 = searchName2;
	}

	public String getSearchName3() {
		return searchName3;
	}

	public void setSearchName3(String searchName3) {
		this.searchName3 = searchName3;
	}
	
}