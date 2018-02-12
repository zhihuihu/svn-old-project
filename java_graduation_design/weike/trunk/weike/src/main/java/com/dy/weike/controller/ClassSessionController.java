package com.dy.weike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.ClassSession;
import com.dy.weike.service.inter.IClassSessionService;

@Controller
@RequestMapping(value="classSession")

public class ClassSessionController {
	
	@Resource
	private IClassSessionService iClassSessionService;
	/**
	 * 增加一条课时数据
	 * @param request
	 * @param token
	 * @param sessionString
	 * @return
	 */
	@RequestMapping(value="insert")
	@ResponseBody	
	public Object insert(HttpServletRequest request,String token,String sessionString){
		ClassSession session = new ClassSession();
		session.setClassId(2);
		session.setSessionBrith(TimeUtils.getMySqlFormatTime());
		session.setSessionFree(true);
		session.setSessionName("课时");
		session.setSessionUrl("url");
		session.setSessionValue(3);
		iClassSessionService.insert(session);
		return session;
	}

}
