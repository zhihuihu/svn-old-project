package com.hxkj.waychat.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.waychat.core.config.Constant;
import com.hxkj.waychat.core.utils.JackSonUtils;
import com.hxkj.waychat.core.utils.PageReturnUtils;
import com.hxkj.waychat.entity.SysUser;
import com.hxkj.waychat.entity.query.ParameterBean;
import com.hxkj.waychat.service.inter.ISysUserService;

@Controller
@RequestMapping(value="sysUser")
public class SysUserController {

	private static Logger logger = LoggerFactory.getLogger(SysUserController.class);
	
	@Autowired
	private ISysUserService iSysUserService;
	
	/**
	 * 返回登录页面
	 * @Title: login 
	 * @Description:     
	 * @return   
	 * @return String    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月10日 下午4:56:07
	 */
	@RequestMapping(value="login")
	public String login(HttpServletRequest request,HttpServletResponse response,Model model){
		Cookie cookie = new Cookie("token",UUID.randomUUID().toString());
		 
		cookie.setMaxAge(3600);
		 
		//设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
		 
		cookie.setPath("/");
		response.addCookie(cookie);
		return "login";
	}
	
	/**
	 * 用户注册页面
	 * @Title: register 
	 * @Description:     
	 * @param model
	 * @return   
	 * @return String    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月12日 下午1:45:38
	 */
	@RequestMapping(value="register")
	public String register(Model model){
		return "register";
	}
	
	/**
	 * 
	 * @Title: userLogin 
	 * @Description:     
	 * @param request
	 * @param sysUserString
	 * @return   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月12日 下午2:34:12
	 */
	@RequestMapping(value="userLogin")
	@ResponseBody
	public Object userLogin(HttpServletRequest request,HttpSession session,String parameterBeanString) throws Exception{
		ParameterBean parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		SysUser sysUser = new SysUser();
		if(null != parameterBean && null != parameterBean.getSysUser()){
			logger.info("----------:用户:" + parameterBean.getSysUser().getSysUserLoginName() +"登录");
			sysUser.setSysUserLoginName(parameterBean.getSysUser().getSysUserLoginName());
			sysUser.setSysUserPassword(parameterBean.getSysUser().getSysUserPassword());
		}else{
			return PageReturnUtils.formatNormal("", "", false, Constant.LOGIN_FALSE);
		}
		List<SysUser> sysUsers = iSysUserService.selectByAttribute(sysUser);
		if(null == sysUsers || 0 == sysUsers.size()){
			return PageReturnUtils.formatNormal("", "", false, Constant.LOGIN_FALSE);
		}
		return PageReturnUtils.formatNormal("", "", true, Constant.LOGIN_TRUE);
	}
	
	/**
	 * 用户注册
	 * @Title: userRegister 
	 * @Description:     
	 * @param request
	 * @param session
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月12日 下午5:46:05
	 */
	@RequestMapping(value="userRegister")
	@ResponseBody
	public Object userRegister(HttpServletRequest request,HttpSession session,String parameterBeanString) throws Exception{
		ParameterBean parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		SysUser sysUser = new SysUser();
		if(null != parameterBean && null != parameterBean.getSysUser()){//检测用户名格式是否输入正确
			if(null != parameterBean.getSysUser().getSysUserLoginName() && !"".equals(parameterBean.getSysUser().getSysUserLoginName().trim())){
				logger.info("----------:用户:" + parameterBean.getSysUser().getSysUserLoginName() + "注册");
				sysUser.setSysUserLoginName(parameterBean.getSysUser().getSysUserLoginName());
			}else{
				return PageReturnUtils.formatNormal("", "", false, Constant.REGISTER_FALSE01);
			}
		}
		List<SysUser> sysUsers = iSysUserService.selectByAttribute(sysUser);
		if(null != sysUser && 0 != sysUsers.size()){//检查用户名是否重复
			return PageReturnUtils.formatNormal("", "", false, Constant.REGISTER_FALSE);
		}
		if(null != parameterBean.getSysUser().getSysUserPassword() && !"".equals(parameterBean.getSysUser().getSysUserPassword().trim())){//用户名检查通过后再近些密码的检测
			sysUser.setSysUserPassword(parameterBean.getSysUser().getSysUserPassword());
		}else{
			return PageReturnUtils.formatNormal("", "", false, Constant.REGISTER_FALSE02);
		}
		sysUser.setSysUserCuid(UUID.randomUUID().toString());
		if(iSysUserService.insert(sysUser) <= 0){//判断注册是否成功
			return PageReturnUtils.formatNormal("", "", false, Constant.REGISTER_FALSE01);
		}
		return PageReturnUtils.formatNormal("", "", true, Constant.REGISTER_TRUE);
	}
	
	/**
	 * 校验用户名
	 * @Title: checkUserLoginName 
	 * @Description:     
	 * @param request
	 * @param session
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月12日 下午6:01:50
	 */
	@RequestMapping(value="checkUserLoginName")
	@ResponseBody
	public Object checkUserLoginName(HttpServletRequest request,HttpSession session,String parameterBeanString) throws Exception{
		ParameterBean parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		SysUser sysUser = new SysUser();
		if(null != parameterBean && null != parameterBean.getSysUser()){
			logger.info("----------:用户:" + parameterBean.getSysUser().getSysUserLoginName() + "注册，校验登录名");
			sysUser.setSysUserLoginName(parameterBean.getSysUser().getSysUserLoginName());
		}
		List<SysUser> sysUsers = iSysUserService.selectByAttribute(sysUser);
		if(null != sysUsers && 0 != sysUsers.size()){
			return PageReturnUtils.formatNormal("", "", false, Constant.REGISTER_FALSE);
		}
		return PageReturnUtils.formatNormal("", "", true, Constant.REGISTER_CROSS);
	}
}
