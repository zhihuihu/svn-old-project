package com.cqq.leisure.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.cqq.leisure.entity.Active;
import com.cqq.leisure.service.impl.ActiveService;

@Controller
@RequestMapping("active")
public class AcitveController {
	@Resource
	private ActiveService activeService;
	@RequestMapping("insert")
	@ResponseBody
	private Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Active active = new Active();
		active.setActiveName("活动一");
		active.setActiveType("野餐");
		active.setActiveMainContent("去西华大学野餐活动");
		active.setActiveCreateTime("2016-03-20");
		active.setActiveStartTime("2016-03-21");
		active.setActiveEndTime("2016-03-23");
		active.setActiveLog("120");
		active.setActiveLat("44.234");
		active.setActiveAddress("牛市口西华");
		active.setActiveState(3);
		active.setActiveTag("成都");
		activeService.doInsert(active);
		return active;
	}

}
