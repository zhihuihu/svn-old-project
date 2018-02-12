package com.hxkj.waychat.intercept.fliter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*@WebFilter(filterName="MyFilter",urlPatterns="/*")*/
public class MyFilter implements Filter {

	private static Logger logger = LoggerFactory.getLogger(MyFilter.class);
	
	@Override
	public void destroy() {
		logger.info("----------:过滤器销毁");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		logger.info("----------:过滤器执行内容");
		
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		logger.info("----------:过滤器初始化");
	}

}
