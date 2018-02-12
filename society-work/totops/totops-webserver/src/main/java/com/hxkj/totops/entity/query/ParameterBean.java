package com.hxkj.totops.entity.query;

import com.hxkj.totops.entity.IndexPage;
import com.hxkj.totops.entity.MingPinHui;
import com.hxkj.totops.entity.PinLife;
import com.hxkj.totops.entity.SysFile;
import com.hxkj.totops.entity.SysUser;

/**
 * @ClassName: ParameterBean 
 * @Description: 做为前端传数据到服务器的bean
 * @author huzhihui_c@qq.com
 * @date 2016年7月20日 上午11:39:16
 */
public class ParameterBean {

	//token字符串
	private String token;
	
	//查询页号
	private int currentPage;
	
	//一页的大小
	private int pageSize = 10;
	
	//搜索框内容
	private String searchName;
	
	//搜索开始时间
	private String startTime;
	
	//搜索结束时间
	private String endTime;
	
	/**
	 * 系统用户
	 */
	private SysUser sysUser;
	
	/**
	 * 主页bean
	 */
	private IndexPage indexPage;
	
	/**
	 * 品生活bean
	 */
	private PinLife pinLife;
	
	/**
	 * 名品汇bean
	 */
	private MingPinHui mingPinHui;

	/**
	 * 系统文件
	 */
	private SysFile sysFile;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public IndexPage getIndexPage() {
		return indexPage;
	}

	public void setIndexPage(IndexPage indexPage) {
		this.indexPage = indexPage;
	}

	public PinLife getPinLife() {
		return pinLife;
	}

	public void setPinLife(PinLife pinLife) {
		this.pinLife = pinLife;
	}

	public MingPinHui getMingPinHui() {
		return mingPinHui;
	}

	public void setMingPinHui(MingPinHui mingPinHui) {
		this.mingPinHui = mingPinHui;
	}

	public SysFile getSysFile() {
		return sysFile;
	}

	public void setSysFile(SysFile sysFile) {
		this.sysFile = sysFile;
	}
}
