package com.hxkj.photocms.entity;

import java.io.Serializable;

/** 
 * Project Name:photocms.server 
 * ClassName:GlobalId
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午4:57:59 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class GlobalId implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * 全局生成ID
	 */
	private int globalCuid;
	/**
	 * 生成对应表名称
	 */
	private String globalTableName;
	/**
	 * 对应提示
	 */
	private String globalNotes;
	/**
	 * 创建时间
	 */
	private String globalCreateTime;
	public int getGlobalCuid() {
		return globalCuid;
	}
	public void setGlobalCuid(int globalCuid) {
		this.globalCuid = globalCuid;
	}
	public String getGlobalTableName() {
		return globalTableName;
	}
	public void setGlobalTableName(String globalTableName) {
		this.globalTableName = globalTableName;
	}
	public String getGlobalNotes() {
		return globalNotes;
	}
	public void setGlobalNotes(String globalNotes) {
		this.globalNotes = globalNotes;
	}
	public String getGlobalCreateTime() {
		return globalCreateTime;
	}
	public void setGlobalCreateTime(String globalCreateTime) {
		this.globalCreateTime = globalCreateTime;
	}
}
