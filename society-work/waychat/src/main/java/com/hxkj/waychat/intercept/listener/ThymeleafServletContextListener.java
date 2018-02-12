package com.hxkj.waychat.intercept.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hxkj.waychat.core.config.Constant;
import com.hxkj.waychat.core.utils.PropertiesUtils;

@WebListener
public class ThymeleafServletContextListener implements ServletContextListener {

	private static Logger logger = LoggerFactory.getLogger(ThymeleafServletContextListener.class);
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		logger.info("----------:ServletContext销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.info("----------:ServletContext初始化");
		logger.info("----------:baseUrl:"+PropertiesUtils.getPropertiesValue(Constant.BASE_URL)+";fileUrl:"+PropertiesUtils.getPropertiesValue(Constant.FILE_URL));
		arg0.getServletContext().setAttribute("baseUrl", PropertiesUtils.getPropertiesValue(Constant.BASE_URL));
		arg0.getServletContext().setAttribute("fileUrl", PropertiesUtils.getPropertiesValue(Constant.FILE_URL));
	}

}
