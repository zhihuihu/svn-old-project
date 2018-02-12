package com.cqq.leisure.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.service.impl.UserService;

/**
 * 用户控制层
 * @author CQQ
 *
 */
@Controller
@RequestMapping(value="user")
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping(value="register")
	@ResponseBody
	private Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		User user = new User();
		user.setUserLoginName("cqq");
		user.setUserPassword("123456");
		user.setUserType("普通用户");
		user.setUserState(1);
		user.setUserTele("13438334359");
		user.setUserCreateTime(TimeUtils.getMySqlFormatTime());
		userService.doInsert(user);
		return user;
	}
	
}
