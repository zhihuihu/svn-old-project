package com.hxkj.photocms.dao;

import java.util.List;

import com.hxkj.photocms.entity.PageBean;


/** 
 * Project Name:photocms.server 
 * ClassName:IBaseDao
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午5:06:55 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IBaseDao<B> {

	public boolean doInsert(B b)throws Exception;
	
	public boolean doUpdate(B b)throws Exception;
	
	public boolean doDelete(B b)throws Exception;
	
	public List<B> getAll()throws Exception;
	
	public B getById(String id)throws Exception;
	
	public List<B> getAllByPage(PageBean<B> B)throws Exception;
	
	public int getAllByPageCount(PageBean<B> B)throws Exception;
	
	public int getAllByPageCountOr(PageBean<B> B)throws Exception;
}
