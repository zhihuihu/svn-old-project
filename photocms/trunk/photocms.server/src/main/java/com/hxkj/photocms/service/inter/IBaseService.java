package com.hxkj.photocms.service.inter;

import java.util.List;
import com.hxkj.photocms.entity.PageBean;


/** 
 * Project Name:photocms.server 
 * ClassName:IBaseService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午5:14:36 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IBaseService<B> {

	public boolean doInsert(B b) throws Exception;
	
	public boolean doInsertList(List<B> b) throws Exception;
	
	public boolean doUpdate(B b) throws Exception;
	
	public boolean doDelete(B b) throws Exception;
	
	public List<B> getAll() throws Exception;
	
	public B getById(B b) throws Exception;
	
	public List<B> getAllByPage(PageBean<B> pageBean) throws Exception;
	
	public int getAllByPageCount(PageBean<B> pageBean) throws Exception;
	
	public int getAllByPageCountOr(PageBean<B> pageBean) throws Exception;
}