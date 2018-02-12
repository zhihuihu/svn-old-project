package com.hxkj.photocms.entity;

import java.io.Serializable;
import java.util.List;

/** 
 * Project Name:photocms.server 
 * ClassName:DataType
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午7:02:04 
 * @version  1.0 
 * @since    JDK 1.8      
 */
/*DATA_TYPE_CUID       varchar(255) not null,
DATA_TYPE_NAME       varchar(100),
DATA_TYPE_CODE       varchar(100),
DATA_TYPE_CREATE_TIME timestamp,
DATA_TYPE_TOTAL_NUMBER int,*/
public class DataType implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;

	/**
	 * 数据类型CUID
	 */
	private String dataTypeCuid;
	/**
	 * 数据类型名称
	 */
	private String dataTypeName;
	/**
	 * 数据类型编码
	 */
	private String dataTypeCode;
	/**
	 * 数据类型创建时间
	 */
	private String dataTypeCreateTime;
	/**
	 * 数据类型对应的专辑类型总数
	 */
	private int dataTypeTotalNumber;
	//对象属性
	/**
	 * 专辑类型List
	 */
	private List<SpecialType> specialTypes;
	public String getDataTypeCuid() {
		return dataTypeCuid;
	}
	public void setDataTypeCuid(String dataTypeCuid) {
		this.dataTypeCuid = dataTypeCuid;
	}
	public String getDataTypeName() {
		return dataTypeName;
	}
	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}
	public String getDataTypeCode() {
		return dataTypeCode;
	}
	public void setDataTypeCode(String dataTypeCode) {
		this.dataTypeCode = dataTypeCode;
	}
	public String getDataTypeCreateTime() {
		return dataTypeCreateTime;
	}
	public void setDataTypeCreateTime(String dataTypeCreateTime) {
		this.dataTypeCreateTime = dataTypeCreateTime;
	}
	public int getDataTypeTotalNumber() {
		return dataTypeTotalNumber;
	}
	public void setDataTypeTotalNumber(int dataTypeTotalNumber) {
		this.dataTypeTotalNumber = dataTypeTotalNumber;
	}
	public List<SpecialType> getSpecialTypes() {
		return specialTypes;
	}
	public void setSpecialTypes(List<SpecialType> specialTypes) {
		this.specialTypes = specialTypes;
	}
	
	
}
