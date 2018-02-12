package com.hxkj.photocms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.photocms.core.utils.PageBeanUtils;
import com.hxkj.photocms.core.utils.ParameterUtils;
import com.hxkj.photocms.core.utils.TimeUtils;
import com.hxkj.photocms.entity.DataInBean;
import com.hxkj.photocms.entity.SysUser;
import com.hxkj.photocms.entity.UserSession;
import com.hxkj.photocms.intercept.session.UserSessionUtils;
import com.hxkj.photocms.service.impl.SysUserService;

/** 
 * Project Name:photocms.server 
 * ClassName:SysUserController
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午10:19:55 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="sysUser")
public class SysUserController {

	@Resource
	private SysUserService sysUserService;
	
	@RequestMapping(value="doInsert")
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SysUser sysUser = inBean.getSysUser();
		sysUser.setSysUserLoginName("huzhihui");
		sysUser.setSysUserRelName("胡志辉");
		sysUser.setSysUserAddress("成都郫县西华大学");
		sysUser.setSysUserMail("huzhihui_c@qq.com");
		sysUser.setSysUserCreateTime(TimeUtils.getMySqlFormatTime());
		sysUser.setUserTypeCuid("USER_TYPE_20160202002");
		sysUserService.doInsert(sysUser);
		return sysUser;
	}
	
	@RequestMapping(value="login")
	@ResponseBody
	public Object login(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SysUser sysUser = inBean.getSysUser();
		SysUser resUser = sysUserService.login(sysUser);
		if(resUser!= null){
			UserSession userSession = UserSessionUtils.addUserSession(resUser);
			return PageBeanUtils.formatForNormalTrue(userSession.getSessionId(),resUser);
		}else{
			return PageBeanUtils.formatForNormalFalse("",resUser);
		}
	}
	
	@RequestMapping(value="loginOut")
	@ResponseBody
	public Object loginOut(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		String sessionId = inBean.getSessionId();
		UserSessionUtils.destoryUserSession(sessionId);
		return PageBeanUtils.formatForNormalTrue("","用户注销成功！");
	}
}
