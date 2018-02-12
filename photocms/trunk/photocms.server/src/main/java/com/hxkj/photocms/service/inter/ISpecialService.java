package com.hxkj.photocms.service.inter;


import java.util.Map;

import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.Special;

/** 
 * Project Name:photocms.server 
 * ClassName:ISpecialService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午11:35:06 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface ISpecialService extends IBaseService<Special> {

	public Map<String, Object> getSpecialBySpecialType(PageBean<Special> pageBean) throws Exception;
	
	public Map<String, Object> getSpecialByAttributeAnd(PageBean<Special> pageBean) throws Exception;
	
	public Map<String, Object> getSpecialByAttributeOr(PageBean<Special> pageBean) throws Exception;
}
