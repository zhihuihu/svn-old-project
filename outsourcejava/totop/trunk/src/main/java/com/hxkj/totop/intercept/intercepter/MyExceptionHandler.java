package com.hxkj.totop.intercept.intercepter;

import com.alibaba.fastjson.JSON;
import com.hxkj.totop.core.utils.PageBeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.lang.model.type.UnknownTypeException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * Created by huzhihui on 2016/4/25.
 */
@Component
public class MyExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, Exception ex) {
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
