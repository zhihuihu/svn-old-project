package com.hxkj.photocms.dao;

import org.springframework.stereotype.Repository;

import com.hxkj.photocms.entity.SysUser;

/** 
 * Project Name:photocms.server 
 * ClassName:ISysUser
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午10:13:52 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface ISysUserDao extends IBaseDao<SysUser> {

	public SysUser login(SysUser b) throws Exception;
}
