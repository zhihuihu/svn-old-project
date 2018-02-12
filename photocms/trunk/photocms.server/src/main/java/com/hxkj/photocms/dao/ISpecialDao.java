package com.hxkj.photocms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.Special;

/** 
 * Project Name:photocms.server 
 * ClassName:ISpecialDao
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午11:33:48 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface ISpecialDao extends IBaseDao<Special> {

	public List<Special> getSpecialBySpecialType(PageBean<Special> pageBean) throws Exception;
	
	/**
	 * 
	* @Title: doUpdateTotalNumber 
	* @Description: TODO  这里的number是更新的数量，并不是拥有的总数
	* @param @param special
	* @param @return
	* @param @throws Exception     
	* @return boolean    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月18日 下午9:02:49
	* @Since JDK 1.8
	 */
	public boolean doUpdateTotalNumber(Special special) throws Exception;
	
	public List<Special> getSpecialByAttributeAnd(PageBean<Special> pageBean) throws Exception;
	
	public List<Special> getSpecialByAttributeOr(PageBean<Special> pageBean) throws Exception;
}
