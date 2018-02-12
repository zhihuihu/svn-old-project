package com.hxkj.xhupubmed.dao;

import org.springframework.stereotype.Repository;

import com.hxkj.xhupubmed.entity.Follow;

/** 
 * ClassName:IFollowDao
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午5:03:33 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface IFollowDao extends IBaseDao<Follow> {

	/**
	 * 
	* @Function: 通过属性查询
	* @Title: selectByAttribute  
	* @param follow
	* @return
	* @throws Exception   
	* Follow    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月3日 下午1:28:36
	* @Since JDK 1.8
	 */
	public Follow selectByAttribute(Follow follow) throws Exception;
	
	//只实现postCuid
	public int doDeleteByAttribute(Follow follow) throws Exception;
}
