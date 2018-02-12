package com.cqq.leisure.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.HolidayPlan;
import com.cqq.leisure.service.impl.HolidayPlanService;

/** 
 * ClassName:HolidayPlanController
 * Function:   
 * Date:     2016年3月20日 下午8:09:42 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="holidayPlan")
public class HolidayPlanController {

	@Resource
	private HolidayPlanService holidayPlanService;
	
	@RequestMapping(value="insert")
	@ResponseBody
	private Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HolidayPlan holidayPlan = new HolidayPlan();
		holidayPlan.setHolidayPlanName("西华7天游");
		holidayPlan.setHolidayPlanStartTime(TimeUtils.getMySqlFormatTime());
		holidayPlan.setHolidayPlanEndTime(TimeUtils.getMySqlFormatTime());
		holidayPlan.setHolidayPlanDesc("西华就是很好的大学");
		holidayPlan.setHolidayPlanCreateTime(TimeUtils.getMySqlFormatTime());
		holidayPlanService.doInsert(holidayPlan);
		return holidayPlan;
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey")
	@ResponseBody
	private Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HolidayPlan holidayPlan = new HolidayPlan();
		holidayPlan.setHolidayPlanId(1);
		holidayPlanService.doDeleteByPrimaryKey(holidayPlan);
		return holidayPlan;
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	private Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HolidayPlan holidayPlan = new HolidayPlan();
		holidayPlan.setHolidayPlanId(1);
		holidayPlanService.selectByPrimaryKey(holidayPlan);
		return holidayPlan;
	}
	
	@RequestMapping(value="doUpdateByPrimaryKey")
	@ResponseBody
	private Object doUpdateByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HolidayPlan holidayPlan = new HolidayPlan();
		holidayPlan.setHolidayPlanId(1);
		holidayPlan.setHolidayPlanName("西华7天游");
		holidayPlan.setHolidayPlanStartTime(TimeUtils.getMySqlFormatTime());
		holidayPlan.setHolidayPlanEndTime(TimeUtils.getMySqlFormatTime());
		holidayPlan.setHolidayPlanDesc("我就是更新的哦");
		holidayPlan.setHolidayPlanCreateTime(TimeUtils.getMySqlFormatTime());
		holidayPlanService.doUpdateByPrimaryKey(holidayPlan);
		return holidayPlan;
	}
}
