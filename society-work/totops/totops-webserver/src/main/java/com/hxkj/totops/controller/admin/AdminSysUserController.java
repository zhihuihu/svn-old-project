package com.hxkj.totops.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.totops.core.utils.JackSonUtils;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.inter.ISysUserService;

@Controller
@RequestMapping(value="admin/sysUser")
public class AdminSysUserController {

	@Autowired
	private ISysUserService iSysUserService;
	
	@RequestMapping(value="login")
	@ResponseBody
	public Object login(@RequestBody String parameterBeanString) throws Exception{
		ParameterBean parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		return iSysUserService.login(parameterBean);
	}
	
}
