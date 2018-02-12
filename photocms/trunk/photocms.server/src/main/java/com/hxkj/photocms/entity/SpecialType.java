package com.hxkj.photocms.entity;

import java.io.Serializable;
import java.util.List;

/** 
 * Project Name:photocms.server 
 * ClassName:SpecialType
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午6:34:39 
 * @version  1.0 
 * @since    JDK 1.8      
 */
/*SPECIAL_TYPE_CUID    varchar(255) not null,
DATA_TYPE_CUID       varchar(255),
SPECIAL_TYPE_NAME    varchar(100),
SPECIAL_TYPE_CREATE_TIME timestamp,
SPECIAL_TYPE_TOTAL_NUMBER int,
SPECIAL_TYPE_SHOW    varchar(5),*/
public class SpecialType implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	/*专辑类型CUID*/
	private String specialTypeCuid;
	/*数据类型CUID*/
	private String dataTypeCuid;
	/*专辑类型名称*/
	private String specialTypeName;
	/*专辑类型创建时间*/
	private String specialTypeCreateTime;
	/*专辑类型总共对应专辑数量*/
	private int specialTypeTotalNumber;
	/*专辑类型是否显示     1为显示 2为隐藏*/
	private String specialTypeShow;
	//对象属性
	/**
	 * 数据类型对象
	 */
	private DataType dataType;
	/**
	 * 专辑List对象
	 */
	private List<Special> specials;
	public String getSpecialTypeCuid() {
		return specialTypeCuid;
	}
	public void setSpecialTypeCuid(String specialTypeCuid) {
		this.specialTypeCuid = specialTypeCuid;
	}
	public String getDataTypeCuid() {
		return dataTypeCuid;
	}
	public void setDataTypeCuid(String dataTypeCuid) {
		this.dataTypeCuid = dataTypeCuid;
	}
	public String getSpecialTypeName() {
		return specialTypeName;
	}
	public void setSpecialTypeName(String specialTypeName) {
		this.specialTypeName = specialTypeName;
	}
	public String getSpecialTypeCreateTime() {
		return specialTypeCreateTime;
	}
	public void setSpecialTypeCreateTime(String specialTypeCreateTime) {
		this.specialTypeCreateTime = specialTypeCreateTime;
	}
	public int getSpecialTypeTotalNumber() {
		return specialTypeTotalNumber;
	}
	public void setSpecialTypeTotalNumber(int specialTypeTotalNumber) {
		this.specialTypeTotalNumber = specialTypeTotalNumber;
	}
	public String getSpecialTypeShow() {
		return specialTypeShow;
	}
	public void setSpecialTypeShow(String specialTypeShow) {
		this.specialTypeShow = specialTypeShow;
	}
	public DataType getDataType() {
		return dataType;
	}
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
	public List<Special> getSpecials() {
		return specials;
	}
	public void setSpecials(List<Special> specials) {
		this.specials = specials;
	}
	
}
