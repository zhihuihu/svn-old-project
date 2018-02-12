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
import com.hxkj.xhupubmed.entity.Follow;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.impl.FollowService;
import com.wordnik.swagger.annotations.ApiOperation;

/** 
 * ClassName:FollowController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午9:54:18 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="follow")
public class FollowController {

	@Resource
	private FollowService followService;
	
	
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ApiOperation(value = "添加信息", httpMethod = "GET", response =Chat.class, notes = "add chat")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Follow follow = new Follow();
		follow.setFollowStartTime(TimeUtils.getMySqlFormatTime());
		follow.setFollowState(1);
		follow.setFollowCreateTime(TimeUtils.getMySqlFormatTime());
		followService.doInsert(follow);
		return follow;
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Follow follow = new Follow();
		follow.setFollowCuid("");
		followService.doDeleteByPrimaryKey(follow);
		return follow;
	}
	
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<Follow> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new Follow());
		return followService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="selectByAttributeOr",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询OR查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select or chat")
	@ResponseBody
	public Object selectByAttributeOr(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<Follow> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new Follow());
		return followService.selectByAttributeOr(pageBean);
	}
	
	
}
