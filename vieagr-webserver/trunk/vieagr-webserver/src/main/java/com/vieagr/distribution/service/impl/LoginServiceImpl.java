package com.vieagr.distribution.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.dao.SysUserDao;
import com.vieagr.distribution.entity.SysUser;
import com.vieagr.distribution.param.LoginParam;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ILoginService;

@Service
@Transactional
public class LoginServiceImpl extends BaseService<SysUser> implements ILoginService{

	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public Integer frontLogin(LoginParam loginParam, HttpServletRequest request
			, HttpServletResponse response) throws JsonProcessingException {
		if(StringUtils.isEmpty(loginParam.getUserName())){
			throw new RuntimeException(Constant.LOGIN_USER_NAME_IS_NULL);
		}
		if(StringUtils.isEmpty(loginParam.getPassword())){
			throw new RuntimeException(Constant.LOGIN_USER_PASSWORD_IS_NULL);
		}
		if(StringUtils.isEmpty(loginParam.getUserType())){
			throw new RuntimeException(Constant.LOGIN_USER_TYPE_IS_NULL);
		}
		SysUser sysUser = sysUserDao.selectUserByUserName(loginParam.getUserName());
		if(sysUser == null){
			return EnumConfig.LOGIN_ERROR_FOR_INFO.getIndex();
		}
		if(!sysUser.getSysUserPassword().equals(loginParam.getPassword())){
			return EnumConfig.LOGIN_ERROR_FOR_INFO.getIndex();
		}
		if(!sysUser.getSysUserType().equals(loginParam.getUserType())){
			return EnumConfig.LOGIN_ERROR_FOR_USER_YPPE.getIndex();
		}
		request.getSession().setAttribute(Constant.SESSION_USER_KEY, sysUser);
		return EnumConfig.LOGIN_SUCCESS.getIndex();
	}

	@Override
	public Object frontLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute(Constant.SESSION_USER_KEY);
		return session.getAttribute(Constant.SESSION_USER_KEY);
	}
}
