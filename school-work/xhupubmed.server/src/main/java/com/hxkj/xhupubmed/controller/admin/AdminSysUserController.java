package com.hxkj.xhupubmed.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.SysUserService;

/** 
 * ClassName:AdminSysUserController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月5日 下午3:52:41 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="admin/sysUser")
public class AdminSysUserController {
	
	@Resource
	private SysUserService sysUserService;
	
	
	@RequestMapping(value="doLogin")
	@ResponseBody
	public Object doLogin(HttpSession session,String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SysUser sysUser = inBean.getSysUser();
		sysUser.setSysUserType(1);
		sysUser = sysUserService.selectByAttribute(sysUser);
		if(sysUser != null){
			session.setAttribute("sysUser", sysUser);
			return PageBeanUtils.formatForNormalTrue("", sysUser);
		}
		return PageBeanUtils.formatForNormalFalse("", sysUser);
	}
	
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		return PageBeanUtils.formatForNormalTrue("", sysUserService.selectByPrimaryKey(inBean.getSysUser()));
	}
	
	@RequestMapping(value="doUpdateByPrimaryKeySelective")
	@ResponseBody
	public Object doUpdateByPrimaryKeySelective(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SysUser sysUser = inBean.getSysUser();
		sysUser.setSysUserUpdateTime(TimeUtils.getMySqlFormatTime());
		int flg = sysUserService.doUpdateByPrimaryKeySelective(sysUser);
		if(flg > 0){
			return PageBeanUtils.formatForNormalTrue("", "更新成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "更新失败,数据不存在");
	}
	
	@RequestMapping(value="selectByAttributeAnd")
	@ResponseBody
	public Object selectByAttributeAnd(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		PageBean<SysUser> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(inBean.getSysUser());
		pageBean.setSearchName(inBean.getSearchName());
		pageBean.setStartTime(inBean.getStartTime());
		pageBean.setEndTime(inBean.getEndTime());
		pageBean.setOrderByString("ORDER BY SYS_USER_CREATE_TIME DESC");
		return sysUserService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="selectMydata")
	@ResponseBody
	public Object selectMydata(HttpSession session,String dataInBean) throws Exception{
		SysUser sysUser = (SysUser) session.getAttribute("sysUser");
		if(sysUser != null){
			return PageBeanUtils.formatForNormalTrue("", sysUserService.selectByPrimaryKey(sysUser));
		}
		return PageBeanUtils.formatForNormalFalse("", "用户登录已经过期,请重新登录");
	}
	
	/**
	 * 
	* @Function: 增加新管理员
	* @Title: doInsert  
	* @param session
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月9日 下午9:50:43
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpSession session,String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SysUser sysUser = inBean.getSysUser();
		sysUser.setSysUserType(1);
		sysUser.setSysUserState(1);
		sysUser.setSysUserCreateTime(TimeUtils.getMySqlFormatTime());
		sysUser.setSysUserUpdateTime(TimeUtils.getMySqlFormatTime());
		SysUser sysUserExit = new SysUser();
		sysUserExit.setSysUserLoginName(sysUser.getSysUserLoginName());
		sysUserExit = sysUserService.selectByAttribute(sysUserExit);
		if(sysUserExit != null){
			return PageBeanUtils.formatForNormalFalse("", "登录名已经存在");
		}
		sysUserExit = new SysUser();
		sysUserExit.setSysUserEmail(sysUser.getSysUserEmail());
		sysUserExit = sysUserService.selectByAttribute(sysUserExit);
		if(sysUserExit != null){
			return PageBeanUtils.formatForNormalFalse("", "邮箱已经存在");
		}
		sysUserService.doInsert(sysUser);
		return PageBeanUtils.formatForNormalTrue("", "用户添加成功");
	}
	
	@RequestMapping(value="doLoginOut")
	@ResponseBody
	public Object doLoginOut(HttpSession session,String dataInBean) throws Exception{
		session.setAttribute("sysUser", null);
		return PageBeanUtils.formatForNormalTrue("", "退出成功");
	}
}
