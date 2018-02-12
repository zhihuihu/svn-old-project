package com.vieagr.distribution.dao;

import java.util.List;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SysUser;

public interface SysUserDao extends IBaseDao<SysUser> {
	/**
	 * 通过用户名查找用户
	 * @param userName
	 * @return
	 */
	SysUser selectUserByUserName(String userName);
	
	/**
	 * 系统用户列表查询
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	List<SysUser> selectSysUserList(SysUser sysUser) throws Exception;
}