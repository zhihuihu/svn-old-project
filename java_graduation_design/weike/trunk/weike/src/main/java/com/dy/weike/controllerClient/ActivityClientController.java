package com.dy.weike.controllerClient;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.PageBeanUtils;
import com.dy.weike.entity.Activity;
import com.dy.weike.service.inter.IActivityService;

@Controller
@RequestMapping(value = "client/activity")
public class ActivityClientController {
	
	@Resource
	private IActivityService iActivityService;
	
	@RequestMapping(value = "insertActivity")
	@ResponseBody
	public Object insertActivity(int userId, int classId, String data, String place, String theme, String watch){
	
		Activity activity = new Activity();
		activity.setClassId(classId);
		activity.setActivityUser(userId);
		activity.setActivityData(data);
		activity.setActivityPlace(place);
		activity.setActivityTheme(theme);
		activity.setActivityWatch(watch);
		activity.setActivityState(1);
		iActivityService.insertSelective(activity);
		return PageBeanUtils.formatForNormalTrue("", "发布成功！");		
	}	
	
	@RequestMapping(value = "showActivity")
	@ResponseBody
	public Object showActivity(int userId){
		Activity activity = new Activity();
		activity.setActivityUser(userId);
		Object activityExist = iActivityService.selectByAttibute(activity);
		System.out.println("---panduan");
		if(activityExist != null){
			return PageBeanUtils.formatForNormalTrue("", activityExist);
		}
		return PageBeanUtils.formatForNormalFalse("", "还没有发布消息！");		
	}
	
	
	@RequestMapping(value = "showActivityByClass")
	@ResponseBody
	public Object showActivitybByClass(int classId){
		Activity activity = new Activity();
		activity.setClassId(classId);
		Object activityExist = iActivityService.selectByAttibute(activity);
		System.out.println("---panduan");
		if(activityExist != null){
			return PageBeanUtils.formatForNormalTrue("", activityExist);
		}
		return PageBeanUtils.formatForNormalFalse("", "还没有发布消息！");		
	}

}
