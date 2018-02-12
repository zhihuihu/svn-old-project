package com.hxkj.photocms.dao;


import org.springframework.stereotype.Repository;

import com.hxkj.photocms.entity.DataType;

/** 
 * Project Name:photocms.server 
 * ClassName:IDataTypeDao
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午10:39:43 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface IDataTypeDao extends IBaseDao<DataType> {

	public DataType findByDataType(DataType dataType) throws Exception;
	
}
