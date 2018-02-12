package com.cqq.leisure.controller.client;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.RedisUtils;
import com.cqq.leisure.entity.HolidayPlan;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.entity.UserPlan;
import com.cqq.leisure.service.inter.IHolidayPlanService;
import com.cqq.leisure.service.inter.IUserPlanService;

@Controller
@RequestMapping(value="client/holidayplan")
public class ClientHolidayPlan {
	
	@Resource
	private IHolidayPlanService  iHolidayPlanService;
	@Resource
	private IUserPlanService iUserPlanService;
	
	/**
	 * 获取假日方案 根据日历规划的目的地 与假日方案的目的地进行模糊查询
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="recommeds",method=RequestMethod.GET)
	@ResponseBody
	public Object getRecommendHolidayPlan(String token) throws Exception{
		User tokenUser = RedisUtils.get(token, User.class);
		if( tokenUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期，请重新登录");
		}
		return iHolidayPlanService.getRecommendHolidayPlan(tokenUser);
	}
}
