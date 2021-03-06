package com.hxkj.xhupubmed.dao;

import org.springframework.stereotype.Repository;

import com.hxkj.xhupubmed.entity.Post;

/** 
 * ClassName:IPostDao
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午5:09:03 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface IPostDao extends IBaseDao<Post> {

	public int doUpdateImage(Post post) throws Exception;
}
