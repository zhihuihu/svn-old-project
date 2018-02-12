package com.cqq.leisure.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.UserPlan;
import com.cqq.leisure.service.impl.UserPlanService;

/** 
 * ClassName:UserPlanController
 * Function:   
 * Date:     2016年3月20日 下午9:24:48 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="userPlan")
public class UserPlanController {

	@Resource
	private UserPlanService userPlanService;
	
	
	@RequestMapping(value="insert")
	@ResponseBody
	private Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserPlan userPlan = new UserPlan();
		userPlan.setUserPlanName("周末去丽江");
		userPlan.setUserPlanMainContent("我们一去");
		userPlan.setUserPlanStartTime(TimeUtils.getMySqlFormatTime());
		userPlan.setUserPlanEndTime(TimeUtils.getMySqlFormatTime());
		userPlan.setUserPlanState(1);
		userPlan.setUserPlanCreateTime(TimeUtils.getMySqlFormatTime());
		userPlanService.doInsert(userPlan);
		return userPlan;
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey")
	@ResponseBody
	private Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserPlan userPlan = new UserPlan();
		userPlan.setUserPlanId(3);
		userPlanService.doDeleteByPrimaryKey(userPlan);
		return userPlan;
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	private Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserPlan userPlan = new UserPlan();
		userPlan.setUserPlanId(3);
		userPlan = userPlanService.selectByPrimaryKey(userPlan);
		return userPlan;
	}
	
	@RequestMapping(value="doUpdateByPrimaryKey")
	@ResponseBody
	private Object doUpdateByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		UserPlan userPlan = new UserPlan();
		userPlan.setUserPlanId(3);
		userPlan.setUserPlanName("周末去丽江");
		userPlan.setUserPlanMainContent("我们一去");
		userPlan.setUserPlanStartTime(TimeUtils.getMySqlFormatTime());
		userPlan.setUserPlanEndTime(TimeUtils.getMySqlFormatTime());
		userPlan.setUserPlanState(1);
		userPlan.setUserPlanCreateTime(TimeUtils.getMySqlFormatTime());
		userPlanService.doUpdateByPrimaryKey(userPlan);
		return userPlan;
	}
}
