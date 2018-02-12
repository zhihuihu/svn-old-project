package com.hxkj.totop.intercept.session;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by huzhihui on 2016/4/6.
 */
public class OnlineUserSessionListener implements HttpSessionListener {

    private static Log log = LogFactory.getLog(OnlineUserSessionListener.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        ServletContext application = session.getServletContext();
        Integer onlineCount = (Integer) application.getAttribute("onlineCount");
        if(onlineCount == null){
            onlineCount = new Integer(1);
        }else{
            onlineCount ++ ;
        }
        application.setAttribute("onlineCount", onlineCount);
        log.debug("--------------------当前访问新用户："+session.getId());
        log.debug("--------------------当前访问用户数："+onlineCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        log.debug("--------------------当前退出访问用户sessionId："+ session.getId());
    }
}
