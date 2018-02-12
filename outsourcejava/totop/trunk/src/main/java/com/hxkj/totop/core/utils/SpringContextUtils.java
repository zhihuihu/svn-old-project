package com.hxkj.totop.core.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by huzhihui on 2016/4/25.
 */
public class SpringContextUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        SpringContextUtils.applicationContext = arg0;
    }

    /**
     *
     * getApplicationContext:
     * TODO: 得到applicationContext 对象
     * @return:得到applicationContext 对象
     * @author huzhihui
     * date: 2015年12月19日 下午12:40:26
     * @since JDK 1.8
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     *
     * getBean:
     * TODO: 执行查找bean
     * @param beanName
     * @return: 返回查询到的bean实例
     * @author huzhihui
     * date: 2015年12月19日 下午12:40:50
     * @since JDK 1.8
     */
    public static Object getBean(String beanName){
        return applicationContext.getBean(beanName);
    }
}
