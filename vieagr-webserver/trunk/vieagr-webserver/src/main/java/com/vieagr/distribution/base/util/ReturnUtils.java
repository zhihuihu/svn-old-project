package com.vieagr.distribution.base.util;

import com.vieagr.distribution.base.config.Constant;

/**
 * 返回页面工具类
 * @author huzhihui
 *
 */
public class ReturnUtils {

	/**
	 * 系统状态200/500/404
	 */
	private String status;
	
	/**
	 * 状态：000000:success,111111:false
	 */
	private String code;
	
	/**
	 * 状态对应的字符串
	 */
	private String codeStr;
	
	/**
	 * 一页的大小
	 */
	private Integer pageSize;
	
	/**
	 * 总页数
	 */
	private Integer totalPage;
	
	/**
	 * 当前页
	 */
	private Integer currentPage;
	
	/**
	 * 总行书
	 */
	private Integer totalLine;
	
	/**
	 * 返回到页面的bean
	 */
	private Object msg;
	
	/**
	 * 图片服务器路径前缀
	 */
	private String fileUrlPre;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeStr() {
		return codeStr;
	}

	public void setCodeStr(String codeStr) {
		this.codeStr = codeStr;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalLine() {
		return totalLine;
	}

	public void setTotalLine(Integer totalLine) {
		this.totalLine = totalLine;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}
	
	public String getFileUrlPre() {
		return fileUrlPre;
	}

	public void setFileUrlPre(String fileUrlPre) {
		this.fileUrlPre = fileUrlPre;
	}
	/**
	 * 正常数据返回
	 * @param code	000000,111111
	 * @param msg	bean data
	 * @return
	 */
	public static ReturnUtils forNoraml(String code,Object msg){
		ReturnUtils returnUtils = new ReturnUtils();
		returnUtils.setFileUrlPre(PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_WEBSITE_URL_PRE));
		returnUtils.setStatus("200");
		returnUtils.setCode(code);
		returnUtils.setMsg(msg);
		return returnUtils;
	}
	
	/**
	 * 分页数据返回
	 * @param code	000000,111111
	 * @param msg	bean data
	 * @param currentPage	当前页
	 * @param pageSize	一页的大小
	 * @param totalPage	总页数
	 * @param totalLine	总行数
	 * @return
	 */
	public static ReturnUtils forNoramlPage(String code,Object msg,Integer currentPage,Integer pageSize,Integer totalPage,Integer totalLine){
		ReturnUtils returnUtils = new ReturnUtils();
		returnUtils.setFileUrlPre(PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_WEBSITE_URL_PRE));
		returnUtils.setStatus("200");
		returnUtils.setCode(code);
		returnUtils.setMsg(msg);
		returnUtils.setCurrentPage(currentPage);
		returnUtils.setPageSize(pageSize);
		returnUtils.setTotalPage(totalPage);
		returnUtils.setTotalLine(totalLine);
		return returnUtils;
	}
	
	public static ReturnUtils forNoramlError(String status,String code,Object msg){
		ReturnUtils returnUtils = new ReturnUtils();
		returnUtils.setFileUrlPre(PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_WEBSITE_URL_PRE));
		returnUtils.setStatus(status);
		returnUtils.setCode(code);
		returnUtils.setMsg(msg);
		return returnUtils;
	}

}
