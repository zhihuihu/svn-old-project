package com.hxkj.xhupubmed.dao;

import org.springframework.stereotype.Repository;

import com.hxkj.xhupubmed.entity.Replies;

/** 
 * ClassName:IRepliesDao
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午5:09:31 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface IRepliesDao extends IBaseDao<Replies> {
	
	public int doUpdateImage(Replies replies) throws Exception;
}
