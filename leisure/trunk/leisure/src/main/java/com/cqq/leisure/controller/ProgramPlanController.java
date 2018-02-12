package com.cqq.leisure.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.ProgramPlan;
import com.cqq.leisure.service.impl.ProgramPlanService;

/** 
 * ClassName:ProgramPlanController
 * Function:   
 * Date:     2016年3月20日 下午9:02:38 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="programPlan")
public class ProgramPlanController {

	@Resource
	private ProgramPlanService programPlanService;
	
	@RequestMapping(value="insert")
	@ResponseBody
	private Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ProgramPlan programPlan = new ProgramPlan();
		programPlan.setProgramPlanName("红光广场舞");
		programPlan.setProgramPlanType("国际");
		programPlan.setProgramPlanStartTime(TimeUtils.getMySqlFormatTime());
		programPlan.setProgramPlanEndTime(TimeUtils.getMySqlFormatTime());
		programPlan.setProgramPlanAddress("红光镇");
		programPlan.setProgramPlanMainContent("我们就是爱");
		programPlan.setProgramPlanSort(1);
		programPlan.setProgramPlanState(1);
		programPlan.setProgramPlanCreateTime(TimeUtils.getMySqlFormatTime());
		programPlanService.doInsert(programPlan);
		return programPlan;
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey")
	@ResponseBody
	private Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ProgramPlan programPlan = new ProgramPlan();
		programPlan.setProgramPlanId(3);
		programPlanService.doDeleteByPrimaryKey(programPlan);
		return programPlan;
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	private Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ProgramPlan programPlan = new ProgramPlan();
		programPlan.setProgramPlanId(3);
		programPlan = programPlanService.selectByPrimaryKey(programPlan);
		return programPlan;
	}
	
	@RequestMapping(value="doUpdateByPrimaryKey")
	@ResponseBody
	private Object doUpdateByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ProgramPlan programPlan = new ProgramPlan();
		programPlan.setProgramPlanId(3);
		programPlanService.doUpdateByPrimaryKey(programPlan);
		return programPlan;
	}
	
}
