package com.hxkj.photocms.service.inter;

import java.util.Map;

import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.SpecialType;

/** 
 * Project Name:photocms.server 
 * ClassName:ISpecialTypeService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午11:04:17 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface ISpecialTypeService extends IBaseService<SpecialType> {
	
	public Map<String,Object> getSpecialTypeByDataTypeCuid(PageBean<SpecialType> pageBean) throws Exception;
	
	public Map<String,Object> getSpecialTypeByAttributeAnd(PageBean<SpecialType> pageBean) throws Exception;
	
	public Map<String,Object> getSpecialTypeByAttributeOr(PageBean<SpecialType> pageBean) throws Exception;
}
