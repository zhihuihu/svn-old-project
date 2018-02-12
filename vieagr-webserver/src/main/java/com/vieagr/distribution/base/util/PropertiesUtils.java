package com.vieagr.distribution.base.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * 获取application中的配置
 * @author huzhihui
 *
 */
@Configuration
public class PropertiesUtils implements EnvironmentAware{

	private static final Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);

	private static RelaxedPropertyResolver propertyResolver;

    /**
     * 这个方法只是测试实现EnvironmentAware接口，读取环境变量的方法。
     */
    @Override
    public void setEnvironment(Environment env) {
    	logger.info("-----获取到配置文件");
        propertyResolver = new RelaxedPropertyResolver(env, "custom.");
    }
    
    /**
     * 获取配置
     * @param name
     * @return
     */
    public static String getProperties(String name){
    	return propertyResolver.getProperty(name);
    }
}
