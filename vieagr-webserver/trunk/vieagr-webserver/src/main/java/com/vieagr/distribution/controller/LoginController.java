package com.vieagr.distribution.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SysUser;
import com.vieagr.distribution.param.LoginParam;
import com.vieagr.distribution.response.LoginResponse;
import com.vieagr.distribution.service.inter.ILoginService;

/**
 * 登录与注销控制层
 * @author master
 *
 */
@RestController
@RequestMapping(value = "login")
public class LoginController {
	
	@Autowired
	private ILoginService loginService;
	
	/**
	 * 用户登录
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value = "frontLogin", method = RequestMethod.POST)
	public Object frontLogin(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		LoginResponse loginResponse = new LoginResponse();
		LoginParam loginParam = Utils.jsonStrToObject(jsonStr, LoginParam.class);
		Integer loginResultCode = loginService.frontLogin(loginParam, request, response);
		loginResponse.setCode(loginResultCode.toString());
		loginResponse.setMessage(EnumConfig.getName(loginResultCode, Constant.LOGIN_STATE));
		return loginResponse;
	}

	/**
	 * 检查用户是否登录或者登录是否过期
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "checkUserIsLogin",method = RequestMethod.POST)
	public Object checkUserIsLogin(HttpServletRequest request){
		LoginResponse loginResponse = new LoginResponse();
		Boolean userIsExsit = Utils.getLoginUserInfo(request, SysUser.class) == null;
		loginResponse.setCode(userIsExsit ? Constant.RESPONSE_CODE_ERROR : Constant.RESPONSE_CODE_SUCCESS);
		loginResponse.setMessage(userIsExsit ? Constant.RESPONSE_MESSAGE_ERROR : Constant.RESPONSE_MESSAGE_SUCCESS);
		return loginResponse;
	}
	
	/**
	 * 用户注销
	 * @return
	 */
	@RequestMapping(value = "frontLogout", method = RequestMethod.GET)
	public Object frontLogout(HttpServletRequest request){
		LoginResponse loginResponse = new LoginResponse();
		try {
			Object sysUser = loginService.frontLogout(request);
			if(null == sysUser){
				loginResponse.setCode(Constant.RESPONSE_CODE_SUCCESS);
				loginResponse.setMessage(Constant.RESPONSE_MESSAGE_SUCCESS);
			}else{
				loginResponse.setCode(Constant.RESPONSE_CODE_ERROR);
				loginResponse.setMessage(Constant.RESPONSE_MESSAGE_ERROR);
			}
		} catch (Exception e) {
			e.printStackTrace();
			loginResponse.setCode(Constant.RESPONSE_CODE_ERROR);
			loginResponse.setMessage(Constant.RESPONSE_MESSAGE_ERROR);
		}
		return loginResponse;
	}
}
