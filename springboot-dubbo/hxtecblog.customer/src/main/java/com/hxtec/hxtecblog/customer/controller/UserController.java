package com.hxtec.hxtecblog.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hxtec.hxtecblog.api.service.IUserService;

@Controller
@RequestMapping(value="userController")
public class UserController {

	@Reference(version="1.0.0")
	private IUserService iUserService;
	
	@RequestMapping(value="welcome")
	@ResponseBody
	public Object welcomeUser(){
		return iUserService.sayWelcome("huzhihui");
	}
}
