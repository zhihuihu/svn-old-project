package com.hxkj.photocms.intercept.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hxkj.photocms.core.utils.TimeUtils;
import com.hxkj.photocms.entity.UserSession;
import com.hxkj.photocms.intercept.session.UserSessionUtils;

/** 
 * Project Name:photocms.server 
 * ClassName:LoginInterceptor
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月19日 下午6:55:34 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		String sessionId = arg0.getParameter("sessionId") == null ? "":arg0.getParameter("sessionId").toString();
		String[] defaultUrl={"login.html","loginOut.html","get","find"};
		String url=arg0.getRequestURI();
		System.out.println(url);
		for(int i=0;i<defaultUrl.length;i++){
			if(url.indexOf(defaultUrl[i])>=0){
				System.out.println(url.indexOf(defaultUrl[i]));
				return true;
			}
		}
		UserSession userSession = UserSessionUtils.getUserSession(sessionId);
		if(userSession == null){
			throw new Exception("用户没有登录");
		}else{
			userSession.setUpdateTime(TimeUtils.getMySqlFormatTime());
			userSession.setUpdateTimeSecond(System.currentTimeMillis());
			UserSessionUtils.updateUserSession(sessionId, userSession);
		}
		return true;
	}

}
