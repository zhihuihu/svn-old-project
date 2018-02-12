package com.hxkj.xhupubmed.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.Chat;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.service.impl.SysUserService;
import com.wordnik.swagger.annotations.ApiOperation;

/** 
 * ClassName:SysUserController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月9日 上午11:48:53 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="sysUser")
public class SysUserController {
	
	@Resource
	private SysUserService sysUserService;
	
	
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ApiOperation(value = "添加信息", httpMethod = "GET", response =Chat.class, notes = "add chat")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		SysUser sysUser = new SysUser();
		sysUser.setSysUserLoginName("huzhihui_c@qq.com");
		sysUser.setSysUserPassword("123456");
		sysUser.setSysUserState(1);
		sysUser.setSysUserCreateTime(TimeUtils.getMySqlFormatTime());
		sysUserService.doInsert(sysUser);
		return sysUser;
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ApiOperation(value = "通过主键删除", httpMethod = "GET", response =PageBeanUtils.class, notes = "delete chat")
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		SysUser sysUser = new SysUser();
		sysUser.setSysUserCuid("");
		sysUserService.doDeleteByPrimaryKey(sysUser);
		return sysUser;
	}
	
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询AND查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select and chat")
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<SysUser> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new SysUser());
		return sysUserService.selectByAttributeAnd(pageBean);
	}
	@RequestMapping(value="selectByAttributeOr",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询OR查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select or chat")
	@ResponseBody
	public Object selectByAttributeOr(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<SysUser> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new SysUser());
		return sysUserService.selectByAttributeOr(pageBean);
	}
}
