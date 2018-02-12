package com.hxkj.totops.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.hxkj.totops.core.config.EnumConfig;
import com.hxkj.totops.core.utils.JackSonUtils;
import com.hxkj.totops.entity.SysFile;
import com.hxkj.totops.entity.query.PageBean;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.inter.ISysFileService;

@Controller
@RequestMapping(value="web/sysFile")
public class WebSysFileController {

	private static final Logger logger = LoggerFactory.getLogger(WebSysFileController.class);
	
	@Autowired
	private ISysFileService iSysFileService;
	
	/**
	 * @Title: selectSysImageByPage 
	 * @Description:     系统文件--查询图片列表分页
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月26日 下午9:54:42
	 */
	@RequestMapping(value="selectSysImageByPage")
	@ResponseBody
	public Map<String,Object> selectSysImageByPage(String parameterBeanString) throws Exception{
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		logger.info("-----系统文件--查询图片列表分页");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		SysFile sysFile = new SysFile();
		sysFile.setSysFileType(EnumConfig.SYS_FILE_TYPE_IMAGE.getIndex());
		PageBean<SysFile> pageBean = new PageBean<SysFile>(parameterBean.getCurrentPage(), parameterBean.getPageSize(), sysFile);
		return iSysFileService.selectByPageAnd(pageBean);
	}
	
}
