package com.vieagr.distribution.base.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.ReturnUtils;

/**
 * 全局异常处理器
 * 
 * @ClassName: GlobalExceptionHandler
 * @Description:
 * @author huzhihui_c@qq.com
 * @date 2016年10月28日 下午1:36:19
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Object errorHandler(HttpServletRequest request, Exception e) {
		e.printStackTrace();
		logger.info("-----捕获服务器内部错误" + e.toString());
		logger.info("-----捕获服务器内部错误请求" + request.getRequestURI());
		return ReturnUtils.forNoramlError(Constant.EXCEPTION_OF_STATUS, Constant.EXCEPTION_OF_CODE, Constant.EXCEPTION_OF_MESSAGE);
	}
}
