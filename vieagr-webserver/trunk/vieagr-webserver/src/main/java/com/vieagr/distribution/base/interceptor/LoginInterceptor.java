package com.vieagr.distribution.base.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SysUser;

@Component
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * 直接放行的接口
	 */
	private static final String[] notFilterUrl = {"selectImagesByType"};
	
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception e)
			throws Exception {
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String requestPath = request.getServletPath();
		for(String path : notFilterUrl) {
			if(requestPath.contains(path)) {
				return true;
			}
		}
		if(Utils.getLoginUserInfo(request, SysUser.class) == null){
			response.setCharacterEncoding("UTF-8");  
		    response.setContentType("application/json; charset=utf-8"); 
			PrintWriter out = response.getWriter();  
	        out.print("{\"code\":\"" +Constant.INTERCEPTOR_OF_NOT_LOGIN_CODE+ "\", \"msg\":\""+Constant.LOGIN_LOSE_EFFICACY+"\"}");
	        logger.info("登录用户失效" + request.getContextPath());
	        return false;
		}
		return true;
	}
}
