package com.hxkj.totops.controller.admin;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxkj.totops.core.utils.JackSonUtils;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.inter.ISysFileService;

@Controller
@RequestMapping(value="admin/sysFile")
public class AdminSysFileController {

	@Autowired
	private ISysFileService iSysFileService;
	
	/**
	 * @Title: insertFile 
	 * @Description:     增加一个文件
	 * @param request
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月26日 下午12:53:42
	 */
	@RequestMapping(value="insertFile")
	public void insertFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ParameterBean parameterBean = new ParameterBean();
		Map<String, Object> map = iSysFileService.insertFile(request, parameterBean);
		PrintWriter writer = response.getWriter();
        writer.write(JackSonUtils.toString(map));
        writer.flush();
        writer.close();
	}
}
