package com.hxkj.photocms.service.inter;

import java.util.Map;

import com.hxkj.photocms.entity.DataType;

/** 
 * Project Name:photocms.server 
 * ClassName:IDataTypeService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午10:40:48 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IDataTypeService extends IBaseService<DataType> {

	public Map<String,Object> findByDataType(DataType dataType) throws Exception;
	
}
