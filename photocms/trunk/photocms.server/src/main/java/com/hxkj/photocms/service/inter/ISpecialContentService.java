package com.hxkj.photocms.service.inter;

import java.util.List;
import java.util.Map;

import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.SpecialContent;

/** 
 * Project Name:photocms.server 
 * ClassName:ISpecialContentService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 下午12:02:14 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface ISpecialContentService extends IBaseService<SpecialContent> {

	public Map<String, Object> getSpecialContentBySpecial(PageBean<SpecialContent> pageBean) throws Exception;
	
	public boolean doUpdateSpecialMainUrl(SpecialContent specialContent) throws Exception;
	
	public boolean doUpdataList(List<SpecialContent> specialContents) throws Exception;
	
	public Map<String, Object> getSpecialContentByAttributeAnd(PageBean<SpecialContent> pageBean) throws Exception;
	
	public Map<String, Object> getSpecialContentByAttributeOr(PageBean<SpecialContent> pageBean) throws Exception;
}
