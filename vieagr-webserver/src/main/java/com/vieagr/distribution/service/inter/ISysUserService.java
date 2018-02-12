package com.vieagr.distribution.service.inter;

import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.entity.SysUser;
import com.vieagr.distribution.query.SysUserQuery;
import com.vieagr.distribution.service.base.IBaseService;

public interface ISysUserService extends IBaseService<SysUser>{

	/**
	 * 分页查询登录用户
	 * @param sysUserQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectUserList(SysUserQuery sysUserQuery) throws Exception;
	
	/**
	 * 增加一个系统用户
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	ReturnUtils addOneSysUser(SysUser sysUser) throws Exception;
	
	/**
	 * 系统用户列表查询
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	ReturnUtils selectSysUserList(SysUser sysUser) throws Exception;
}
