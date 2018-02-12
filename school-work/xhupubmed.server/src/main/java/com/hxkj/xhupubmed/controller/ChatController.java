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
import com.hxkj.xhupubmed.service.impl.ChatService;
import com.wordnik.swagger.annotations.ApiOperation;

/** 
 * ClassName:ChatController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午3:00:11 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="chat")
public class ChatController {

	@Resource
	private ChatService chatService;
	
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ApiOperation(value = "添加消息", httpMethod = "GET", response =Chat.class, notes = "add chat")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Chat chat = new Chat();
		chat.setChatLeftCuid("left001");
		chat.setChatLeftName("胡志辉");
		chat.setChatRightCuid("right001");
		chat.setChatRightName("陈巧巧");
		chat.setChatState(1);
		chat.setChatCreateTime(TimeUtils.getMySqlFormatTime());
		chatService.doInsert(chat);
		return chat;
	}
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ApiOperation(value = "通过主键删除", httpMethod = "GET", response =PageBeanUtils.class, notes = "delete chat")
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Chat chat = new Chat();
		chat.setChatCuid("CHAT20160307014");
		chatService.doDeleteByPrimaryKey(chat);
		return chat;
	}
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询AND查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select and chat")
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<Chat> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new Chat());
		return chatService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="selectByAttributeOr",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询OR查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select or chat")
	@ResponseBody
	public Object selectByAttributeOr(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<Chat> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new Chat());
		return chatService.selectByAttributeOr(pageBean);
	}
}
