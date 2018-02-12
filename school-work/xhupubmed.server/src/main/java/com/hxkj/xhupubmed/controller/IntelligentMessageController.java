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
import com.hxkj.xhupubmed.entity.IntelligentMessage;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.impl.IntelligentMessageService;
import com.wordnik.swagger.annotations.ApiOperation;

/** 
 * ClassName:IntelligentMessageController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午6:50:51 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="intelligentMessage")
public class IntelligentMessageController {

	@Resource
	private IntelligentMessageService intelligentMessageService;
	
	
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ApiOperation(value = "添加信息", httpMethod = "GET", response =Chat.class, notes = "add chat")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		IntelligentMessage intelligentMessage = new IntelligentMessage();
		intelligentMessage.setIntelligentMessageContent("智能消息内容");
		intelligentMessage.setIntelligentMessageDirection(1);
		intelligentMessage.setIntelligentMessageCreateTime(TimeUtils.getMySqlFormatTime());
		intelligentMessageService.doInsert(intelligentMessage);
		return intelligentMessage;
	}
	
	
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ApiOperation(value = "通过主键删除", httpMethod = "GET", response =PageBeanUtils.class, notes = "delete chat")
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		IntelligentMessage intelligentMessage = new IntelligentMessage();
		intelligentMessage.setIntelligentMessageCuid("");
		intelligentMessageService.doDeleteByPrimaryKey(intelligentMessage);
		return intelligentMessage;
	}
	
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询AND查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select and chat")
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<IntelligentMessage> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new IntelligentMessage());
		return intelligentMessageService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="selectByAttributeOr",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询OR查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select or chat")
	@ResponseBody
	public Object selectByAttributeOr(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<IntelligentMessage> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new IntelligentMessage());
		return intelligentMessageService.selectByAttributeOr(pageBean);
	}
}
