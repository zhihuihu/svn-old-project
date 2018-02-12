package com.dy.weike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.Ask;
import com.dy.weike.service.inter.IAskService;

@Controller
@RequestMapping(value="ask")
public class AskController {
	@Resource
	private IAskService iAskService;
	
	@RequestMapping(value="insert")
	@ResponseBody
	public Object insert(HttpServletRequest request,String token,String askString){
		Ask ask = new Ask();
		ask.setAnserId(1);
		ask.setAskerId(1);
		ask.setAskState(1);
		ask.setAskText("这是一个留言");
		ask.setAskTime(TimeUtils.getMySqlFormatTime());
		ask.setClassId(1);
		iAskService.insert(ask);	
		return ask;
	}

}
