package com.hxkj.photocms.intercept.session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/** 
 * Project Name:photocms.server 
 * ClassName:OnlineUserSessionListener
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午5:38:55 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class OnlineUserSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		ServletContext application = session.getServletContext();
		Integer onlineCount = (Integer) application.getAttribute("onlineCount");
		if(onlineCount == null){
			onlineCount = new Integer(1);
		}else{
			onlineCount ++ ;
		}
		application.setAttribute("onlineCount", onlineCount);
		System.out.println("--------------------当前登录新用户："+session.getId());
		System.out.println("--------------------当前登录用户数："+onlineCount);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		HttpSession session = arg0.getSession();
		System.out.println("--------------------当前退出账号sessionId："+ session.getId());
	}

}
