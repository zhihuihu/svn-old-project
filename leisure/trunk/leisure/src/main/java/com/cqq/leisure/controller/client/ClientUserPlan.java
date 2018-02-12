package com.cqq.leisure.controller.client;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.RedisUtils;
import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.entity.UserPlan;
import com.cqq.leisure.service.inter.IUserPlanService;

@Controller
@RequestMapping(value="client/userplan")
public class ClientUserPlan {
	@Resource
	private IUserPlanService iUserPlanService;
	/***
	 * 添加一个我的日历规划
	 * @param userPlanStartTime 开始时间
	 * @param userPlanEndTime结束时间
	 * @param userPlanName 规划名称
	 * @param userPlanMainContent规划内容
	 * @param token  用户token
	 * @return object 填写的日历规划
	 * @throws Exception
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public Object doAddUserPlan(String userPlanStartTime,String userPlanEndTime,String userPlanName,String userPlanMainContent,String token )throws Exception{
		UserPlan userPlan = new UserPlan();
		User tokenUser = RedisUtils.get(token,User.class);
		if(tokenUser == null){
			return PageBeanUtils.formatForNormalFalse("", "用户登录到期请重新登录");
		}
		userPlan.setUserPlanStartTime(userPlanStartTime);
		userPlan.setUserPlanEndTime(userPlanEndTime);
		userPlan.setUserPlanMainContent(userPlanMainContent);
		userPlan.setUserPlanName(userPlanName);
		userPlan.setUserPlanState(0);
		userPlan.setUserId(tokenUser.getUserId());
		userPlan.setUserPlanCreateTime(TimeUtils.getMySqlFormatTime());
		iUserPlanService.doInsert(userPlan);
		return PageBeanUtils.formatForNormalTrue("", userPlan);
	}
	
	/**
	 * 通过用户Id查找我的日历规划
	 * @param token
	 * @param currentPage 当前查询页号
	 * @param lineSize 当前查询页一页的行数
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Object UserPlanList(String token,int currentPage,int lineSize) throws Exception{
		User userToken = RedisUtils.get(token, User.class);
		if(userToken == null){
			return PageBeanUtils.formatForNormalFalse("", "请登录");
		}
		UserPlan userPlan = new UserPlan();
		userPlan.setUserId(userToken.getUserId());
		PageBean<UserPlan> pageBean = new PageBean<UserPlan>(currentPage, lineSize);
		pageBean.setInVo(userPlan);
		return iUserPlanService.selectByAttributeAnd(pageBean);
	}
	/**
	 * 删除我的日历规划
	 * @param token
	 * @param UserPlanId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Object UserPlanDelete(String token,int UserPlanId) throws Exception{
		User userToken = RedisUtils.get(token, User.class);
		if(userToken == null){
			return PageBeanUtils.formatForNormalFalse("", "请登录");
		}
		UserPlan userPlan = new UserPlan();
		userPlan.setUserPlanId(UserPlanId);
		iUserPlanService.doDeleteByPrimaryKey(userPlan);
		return PageBeanUtils.formatForNormalTrue("", "删除成功");
	}

}
