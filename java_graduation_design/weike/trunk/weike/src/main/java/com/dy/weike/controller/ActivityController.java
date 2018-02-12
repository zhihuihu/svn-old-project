package com.dy.weike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.Activity;
import com.dy.weike.service.inter.IActivityService;

@Controller
@RequestMapping(value="activity")
public class ActivityController {
	
	@Resource
	private IActivityService iActivityService;
	
	@RequestMapping(value="insert")
	@ResponseBody
	public Object insert(HttpServletRequest request,String token,String activityString){
		Activity activity = new Activity();
		
		activity.setActivityData(TimeUtils.getMySqlFormatTime());
		activity.setActivityPlace("西华大学图书馆");
		activity.setActivityState(1);
		activity.setActivityTheme("计算机");
		activity.setActivityUser(2);
		activity.setActivityWatch("注意事项！");
		activity.setClassId(2);		
		iActivityService.insert(activity);
		return activity;
	}
	

}
