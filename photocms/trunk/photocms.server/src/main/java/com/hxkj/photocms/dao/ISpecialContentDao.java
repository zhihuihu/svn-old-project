package com.hxkj.photocms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.SpecialContent;

/** 
 * Project Name:photocms.server 
 * ClassName:ISpecialContentDao
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 下午12:01:15 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface ISpecialContentDao extends IBaseDao<SpecialContent> {

	public List<SpecialContent> getSpecialContentBySpecial(PageBean<SpecialContent> pageBean) throws Exception;
	
	public List<SpecialContent> getSpecialContentByAttributeAnd(PageBean<SpecialContent> pageBean) throws Exception;
	
	public List<SpecialContent> getSpecialContentByAttributeOr(PageBean<SpecialContent> pageBean) throws Exception;
}
