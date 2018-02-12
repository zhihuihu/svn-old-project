package com.cqq.leisure.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.HolidayPlan;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.inter.IHolidayPlanService;

@Controller
@RequestMapping(value="admin/holiday")
public class HolidayPlanAdminCtrl {
	@Resource
	private IHolidayPlanService iHolidayPlanService;
	@RequestMapping(value="list")
	@ResponseBody
	public Object getAllHoliday() throws Exception{
		HolidayPlan holidayPlan = new HolidayPlan();
		PageBean<HolidayPlan> pageBean = new PageBean<HolidayPlan>(0, 1000);
		pageBean.setInVo(holidayPlan);
		return iHolidayPlanService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="add")
	@ResponseBody
	public Object addHolidayPlan(String name,String start,String end,String content) throws Exception{
		HolidayPlan holidayPlan = new HolidayPlan();
		holidayPlan.setHolidayPlanCreateTime(TimeUtils.getMySqlFormatTime());
		holidayPlan.setHolidayPlanDesc(content);
		holidayPlan.setHolidayPlanEndTime(end);
		holidayPlan.setHolidayPlanName(name);
		holidayPlan.setHolidayPlanStartTime(start);
		holidayPlan.setTagId(1);
		iHolidayPlanService.doInsert(holidayPlan);
		return  PageBeanUtils.formatForNormalTrue("", holidayPlan);
	
	}
}
