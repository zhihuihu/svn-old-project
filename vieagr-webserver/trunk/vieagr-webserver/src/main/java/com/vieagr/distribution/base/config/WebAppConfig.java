package com.vieagr.distribution.base.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.vieagr.distribution.base.interceptor.LoginInterceptor;


/**
 * 拦截器注册配置类
 * @author master
 *
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 登录拦截器的添加
	 */
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
        		.excludePathPatterns("/login/*");
    }
}
