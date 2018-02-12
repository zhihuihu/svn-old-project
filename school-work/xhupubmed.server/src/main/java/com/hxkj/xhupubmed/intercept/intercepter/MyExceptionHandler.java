package com.hxkj.xhupubmed.intercept.intercepter;

import java.io.FileNotFoundException;

import javax.lang.model.type.UnknownTypeException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;

/** 
 * ClassName:MyExceptionHandler
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午5:12:44 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView modelAndView = new ModelAndView("notice/error/error");
		try {
			if (ex instanceof NullPointerException) {
				request.setAttribute("ex", JSON.toJSONString(PageBeanUtils.formatForError("", "传入数据错误！")));
			} else if (ex instanceof FileNotFoundException) {
				request.setAttribute("ex", JSON.toJSONString(PageBeanUtils.formatForError("", "文件上传出错！")));
			} else if (ex instanceof ClassNotFoundException) {
				request.setAttribute("ex", JSON.toJSONString(PageBeanUtils.formatForError("", "系统内部错误！")));
			} else if (ex instanceof UnknownTypeException) {
				request.setAttribute("ex", JSON.toJSONString(PageBeanUtils.formatForError("", "未知错误！")));
			} else if (ex.getMessage().equals("用户没有登录")){
				request.setAttribute("ex", JSON.toJSONString(PageBeanUtils.formatForError("", "用户未登录！")));
			} else{
				request.setAttribute("ex", JSON.toJSONString(PageBeanUtils.formatForError("", ex.getMessage())));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return modelAndView;
	}
}
