package com.hxkj.wechat.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;import com.hxkj.wechat.service.TestService;

@Aspect
@Configuration
public class TestAop2 {

	private static final Logger logger = LoggerFactory.getLogger(TestAop2.class);
	
	@Pointcut("execution(public * com.hxkj.wechat.service..*.*(..))")
	public void webLog() {

	}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Exception {
		// 接收到请求，记录请求内容
		logger.info("WebLogAspect.doBefore()");
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		logger.info("URL : " + request.getRequestURL().toString());
		logger.info("HTTP_METHOD : " + request.getMethod());
		logger.info("IP : " + request.getRemoteAddr());
		logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "."
				+ joinPoint.getSignature().getName());
		logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
		// 获取所有参数方法一：
		logger.info("获取request中的方法");
		Enumeration<String> enu = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			System.out.println(paraName + ": " + request.getParameter(paraName));
		}
		logger.info("获取方法的参数");
		String targetName = joinPoint.getTarget().getClass().getName();
		String methodName = joinPoint.getSignature().getName();
		Object[] arguments = joinPoint.getArgs();
		Class<?> targetClass = Class.forName(targetName);
		System.out.println("targetName:"+targetName);
		System.out.println("methodName:"+methodName);
		System.out.println("arguments:"+arguments);
		for(Object o : arguments){
			System.out.println(o.getClass().toString());
			System.out.println(o.toString());
		}
		/*for(Method method : targetClass.getMethods()){
			if(method.getName().equals(methodName)){
				Class[] clazzs = method.getParameterTypes();
				if(clazzs.length == arguments.length){
					method.getAnnotation(null);
				}
			}
		}*/
		System.out.println("targetClass:"+targetClass);
	}

	@AfterReturning("webLog()")
	public void doAfterReturning(JoinPoint joinPoint) {
		// 处理完请求，返回内容
		logger.info("WebLogAspect.doAfterReturning()");
	}
}
