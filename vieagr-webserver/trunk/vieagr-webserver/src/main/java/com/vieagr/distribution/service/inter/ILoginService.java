package com.vieagr.distribution.service.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vieagr.distribution.entity.SysUser;
import com.vieagr.distribution.param.LoginParam;
import com.vieagr.distribution.service.base.IBaseService;

/**
 * 登录业务
 * @author master
 *
 */
public interface ILoginService extends IBaseService<SysUser>{
	
	/**
	 * 登录
	 * @param loginParam
	 * @return
	 * @throws JsonProcessingException 
	 */
	public Integer frontLogin(LoginParam loginParam, HttpServletRequest request
			, HttpServletResponse response) throws JsonProcessingException;
	
	/**
	 * 注销
	 * @param request
	 * @return
	 */
	public Object frontLogout(HttpServletRequest request);
	
}
