package com.cqq.leisure.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.ProgramPlan;
import com.cqq.leisure.service.inter.IProgramPlanService;

@Controller
@RequestMapping(value="admin/programplan")
public class ProgramPlanAdminCtrl {
	@Resource
	private IProgramPlanService iProgramPlanService;
	
	@RequestMapping(value="add")
	@ResponseBody
	public Object addProgramPlanAdmin(int holidayPlanId,String name,String address,String content,String start,String end)throws Exception{
		ProgramPlan programPlan = new ProgramPlan();
		programPlan.setHolidayPlanId(holidayPlanId);
		programPlan.setProgramPlanAddress(address);
		programPlan.setProgramPlanEndTime(end);
		programPlan.setProgramPlanMainContent(content);
		programPlan.setProgramPlanStartTime(start);
		programPlan.setProgramPlanName(name);
		programPlan.setProgramPlanCreateTime(TimeUtils.getMySqlFormatTime());
		iProgramPlanService.doInsert(programPlan);
		return PageBeanUtils.formatForNormalTrue("", programPlan);
	}
}
