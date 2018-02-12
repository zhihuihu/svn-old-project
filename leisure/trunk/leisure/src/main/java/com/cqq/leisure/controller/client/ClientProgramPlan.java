package com.cqq.leisure.controller.client;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.ProgramPlan;
import com.cqq.leisure.service.inter.IProgramPlanService;

@Controller
@RequestMapping(value="client/programplan")
public class ClientProgramPlan {
	@Resource
	private IProgramPlanService iProgramPlanService; 
	
	
	/**
	 * 根据holidayPlanId获取到规划方案列表
	 * @param holidayPlanId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Object getProgramPlan(int holidayPlanId) throws Exception{
		ProgramPlan programPlan = new ProgramPlan();
		programPlan.setHolidayPlanId(holidayPlanId);
		PageBean<ProgramPlan> programPlanBean = new PageBean<ProgramPlan>(0, 10000);
		programPlanBean.setInVo(programPlan);
		return iProgramPlanService.selectByAttributeAnd(programPlanBean);
		 
	}
}
