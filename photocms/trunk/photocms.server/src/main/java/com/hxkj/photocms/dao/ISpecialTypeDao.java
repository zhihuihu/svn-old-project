package com.hxkj.photocms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.SpecialType;

/** 
 * Project Name:photocms.server 
 * ClassName:ISpecialTypeDao
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午11:02:32 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface ISpecialTypeDao extends IBaseDao<SpecialType> {

	public List<SpecialType> getSpecialTypeByDataTypeCuid(PageBean<SpecialType> pageBean) throws Exception;
	
	public boolean doUpdateToTalNumber(SpecialType specialType) throws Exception;
	/**
	 * 
	* @Title: getSpecialTypeByAttributeAnd 
	* @Description: TODO 得到专辑类型通过属性与查询
	* @param @param pageBean
	* @param @return
	* @param @throws Exception     
	* @return List<SpecialType>    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月19日 下午11:12:00
	* @Since JDK 1.8
	 */
	public List<SpecialType> getSpecialTypeByAttributeAnd(PageBean<SpecialType> pageBean) throws Exception;
	/**
	 * 
	* @Title: getSpecialTypeByAttributeOr 
	* @Description: TODO 得到专辑类型通过专辑类型属性或查询
	* @param @param pageBean
	* @param @throws Exception     
	* @return List<SpecialType>    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月19日 下午11:12:25
	* @Since JDK 1.8
	 */
	public List<SpecialType> getSpecialTypeByAttributeOr(PageBean<SpecialType> pageBean) throws Exception;
	
}
