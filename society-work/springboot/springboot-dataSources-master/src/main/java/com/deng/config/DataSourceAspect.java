package com.deng.config;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.deng.util.DatabaseContextHolder;
import com.deng.util.DatabaseType;


@Aspect
@Component
public class DataSourceAspect {
	@Before("@annotation(com.deng.config.DataTeast)")
    public void setDataSourceKey(JoinPoint point) throws Exception{
        //根据连接点所属的类实例，动态切换数据源
		String str = DataSourceAspect.getControllerMethodDescription(point);
        if ("1".equals(str)) {
            DatabaseContextHolder.setDatabaseType(DatabaseType.database1);
        } else if("2".equals(str)){
            DatabaseContextHolder.setDatabaseType(DatabaseType.database2);
        }
    }
	
    public  static String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(DataTeast.class).data();    
                     break;    
                }    
            }    
        }    
         return description;    
    }    

}