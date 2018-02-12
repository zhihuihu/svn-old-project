package com.dy.weike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.User;
import com.dy.weike.service.inter.IUserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	
	@Resource
	private IUserService iUserService;
	
	/**
	 * 增加一条用户数据
	 * @param request
	 * @param token
	 * @param userString
	 * @return
	 */
	@RequestMapping(value="insert")
	@ResponseBody
	public Object insert(HttpServletRequest request,String token,String userString){
		User user = new User();
		user.setPassword("dy");
		user.setUserAge(16);
		user.setUserCreatetime(TimeUtils.getMySqlFormatTime());
		user.setUserEdu("大学");
		user.setUserEmaile("dy@qq.com");
		user.setUserExperience(300);
		user.setUserInterest("摄影");
		user.setUserState(1);
		user.setUserTeacher(false);
		user.setUserType(1);
		user.setUserVip(true);
		iUserService.insert(user);
		return user;		
	}
}
