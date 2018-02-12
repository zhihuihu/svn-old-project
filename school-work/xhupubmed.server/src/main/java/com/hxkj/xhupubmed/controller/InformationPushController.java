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
import com.hxkj.xhupubmed.entity.InformationPush;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.impl.InformationPushService;
import com.wordnik.swagger.annotations.ApiOperation;

/** 
 * ClassName:InformationPushController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午4:59:25 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="informationPush")
public class InformationPushController {

	@Resource
	private InformationPushService informationPushService;
	
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ApiOperation(value = "添加信息", httpMethod = "GET", response =Chat.class, notes = "add chat")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		InformationPush informationPush = new InformationPush();
		informationPush.setInformationPushTitle("最新消息");
		informationPush.setInformationPushContent("这个是很好的哦");
		informationPush.setInformationPushState(1);
		informationPush.setInformationPushCreateTime(TimeUtils.getMySqlFormatTime());
		informationPushService.doInsert(informationPush);
		return informationPush;
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ApiOperation(value = "通过主键删除", httpMethod = "GET", response =PageBeanUtils.class, notes = "delete chat")
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		InformationPush informationPush = new InformationPush();
		informationPush.setInformationPushCuid("");
		informationPushService.doDeleteByPrimaryKey(informationPush);
		return informationPush;
	}
	
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<InformationPush> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new InformationPush());
		return informationPushService.selectByAttributeAnd(pageBean);
	}
	
	
	@RequestMapping(value="selectByAttributeOr",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询OR查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select or chat")
	@ResponseBody
	public Object selectByAttributeOr(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<InformationPush> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new InformationPush());
		return informationPushService.selectByAttributeOr(pageBean);
	}
	
}
