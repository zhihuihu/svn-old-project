package com.hxkj.photocms.entity;


/** 
 * Project Name:photocms.server 
 * ClassName:PageBean
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午5:07:54 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class PageBean<B> {

	private int currentPage;
	private int lineSize;
	private B b;

	public PageBean(int currentPage, int lineSize) {
		this.lineSize = lineSize;
		this.currentPage = ((currentPage < 1 ? 1 : currentPage) - 1) * lineSize;
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
	
	public int getRealCurrentPage(){
		return currentPage > 0 ? (currentPage / lineSize) + 1 : 1;
	}
}