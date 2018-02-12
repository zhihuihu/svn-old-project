package com.hxkj.xhupubmed.dao;

import org.springframework.stereotype.Repository;

import com.hxkj.xhupubmed.entity.SysUser;

/** 
 * ClassName:ISysUserDao
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午5:10:00 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface ISysUserDao extends IBaseDao<SysUser> {

	public SysUser selectSysUserByAttribute(SysUser sysUser) throws Exception;
	
}
