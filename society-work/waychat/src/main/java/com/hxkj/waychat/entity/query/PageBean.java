package com.hxkj.waychat.entity.query;

/**
 * @ClassName: PageBean 
 * @Description: 分页查询bean
 * @author huzhihui_c@qq.com
 * @date 2016年7月12日 上午10:35:26 
 * @param <B>
 */
public class PageBean<B> {

	//查询开始行号
	private Integer startLine;
	
	//查询开始页号
	private Integer currentPage;
	
	//查询一页的大小
	private Integer pageSize;
	
	//查询bean
	private B b;
	
	//排序字符串
	private String orderByString;
	
	public PageBean(Integer currentPage, Integer pageSize, B b) {
		this.startLine = (currentPage - 1) >= 0 ? (currentPage - 1)*currentPage : 0;
		this.setCurrentPage(currentPage);
		this.pageSize = pageSize;
		this.b = b;
	}

	public Integer getStartLine() {
		return startLine;
	}

	public void setStartLine(Integer startLine) {
		this.startLine = startLine;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

	public String getOrderByString() {
		return orderByString;
	}

	public void setOrderByString(String orderByString) {
		this.orderByString = orderByString;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
