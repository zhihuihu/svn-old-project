package com.cqq.leisure.service;

import java.util.List;
import java.util.Map;

import com.cqq.leisure.entity.PageBean;


/** 
 * ClassName:IBaseService
 * Function: TODO ADD FUNCTION.   
 * Date:     2016年3月7日 上午8:59:26 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IBaseService<B> {

	/**
	 * @Function:通过主键删除
	* @Title: doDeleteByPrimaryKey 
	* @param @param b
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:00:42
	* @Since JDK 1.8
	 */
	public int doDeleteByPrimaryKey(B b) throws Exception;
	
	/**
	 * 
	* @Function: 删除List
	* @Title: doDeleteListByPrimaryKey 
	* @param @param bs
	* @param @return
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:46:14
	* @Since JDK 1.8
	 */
	public int doDeleteListByPrimaryKey(List<B> bs) throws Exception;
	/**
	 * 
	* @Function: 插入一条数据 全部插入
	* @Title: doInsert 
	* @param @param b
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:02:04
	* @Since JDK 1.8
	 */
	public int doInsert(B b) throws Exception;
	
	/**
	 * 
	* @Function: 插入List
	* @Title: doInsertList 
	* @param @param bs
	* @param @return
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:46:30
	* @Since JDK 1.8
	 */
	public int doInsertList(List<B> bs) throws Exception;
	
	/**
	 * 
	* @Function: 插入一条数据，字段为空则不插入该字段
	* @Title: doInsertSelective 
	* @param @param b
	* @param @return
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:02:48
	* @Since JDK 1.8
	 */
	public int doInsertSelective(B b) throws Exception;
	
	/**
	 * 
	* @Function: 通过主键查询
	* @Title: selectByPrimaryKey 
	* @param @param b
	* @param @throws Exception     
	* @return B    
	* @date 2016年3月7日 下午2:03:27
	* @Since JDK 1.8
	 */
	public B selectByPrimaryKey(B b) throws Exception;
	
	/**
	 * 
	* @Function: 更新数据通过主键，传入为空的数据不更新
	* @Title: doUpdateByPrimaryKeySelective 
	* @param @param b
	* @param @return
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:03:48
	* @Since JDK 1.8
	 */
	public int doUpdateByPrimaryKeySelective(B b) throws Exception;
	
	/**
	 * 
	* @Function: 更新数据通过主键，即使传入数据为空也更新该字段
	* @Title: doUpdateByPrimaryKey 
	* @param @param b
	* @param @return
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:04:14
	* @Since JDK 1.8
	 */
	public int doUpdateByPrimaryKey(B b) throws Exception;
	
	/**
	 *
	* @Function: 更新List
	* @Title: doUpdateListByPrimaryKey 
	* @param @param bs
	* @param @return
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:46:42
	* @Since JDK 1.8
	 */
	public int doUpdateListByPrimaryKey(List<B> bs) throws Exception;
	
	/**
	 * 
	* @Function: 通过属性查询 AND查询
	* @Title: selectByAttributeAnd 
	* @param @param pageBean
	* @param @throws Exception     
	* @return Map<String, Object> 
	* @date 2016年3月7日 下午2:04:40
	* @Since JDK 1.8
	 */
	public Map<String, Object> selectByAttributeAnd(PageBean<B> pageBean) throws Exception;
	
	/**
	 * 
	* @Function: 通过属性查询出来总数量   AND查询
	* @Title: selectByAttributeCountAnd 
	* @param @param pageBean
	* @param @return
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:05:15
	* @Since JDK 1.8
	 */
	public int selectByAttributeCountAnd(PageBean<B> pageBean) throws Exception;
	
	/**
	 * 
	* @Function: 通过属性 或查询 OR
	* @Title: selectByAttributeOr 
	* @param @param pageBean
	* @param @throws Exception     
	* @return Map<String, Object>    
	* @date 2016年3月7日 下午2:06:18
	* @Since JDK 1.8
	 */
	public Map<String, Object> selectByAttributeOr(PageBean<B> pageBean) throws Exception;
	
	/**
	 * 
	* @Function: 通过属性 或查询得到数量  OR
	* @Title: selectByAttributeCountOr 
	* @param @param pageBean
	* @param @throws Exception     
	* @return int    
	* @date 2016年3月7日 下午2:06:42
	* @Since JDK 1.8
	 */
	public int selectByAttributeCountOr(PageBean<B> pageBean) throws Exception;
}
