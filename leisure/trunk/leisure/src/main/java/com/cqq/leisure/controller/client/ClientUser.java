package com.cqq.leisure.controller.client;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cqq.leisure.core.utils.KeyUtils;
import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.RedisUtils;
import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.service.impl.UserService;

@Controller
@RequestMapping(value="client/user")
public class ClientUser {
	
	@Resource
	private UserService userService;
	//normal 不需要登陆就可以访问
	/***
	 * 用户注册
	 * @param Tele
	 * @param Email
	 * @param Password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="normal/register")
	@ResponseBody
	public Object doRegister(String Tele,String Email,String Password) throws Exception{
		User user = new User();
		user.setUserTele(Tele);
		user.setUserPassword(Password);
		user.setUserEmail(Email);
		user.setUserType("普通用户");
		user.setUserCreateTime(TimeUtils.getMySqlFormatTime());
		User userRepeact = new User();
		userRepeact.setUserEmail(Email);
		userRepeact = userService.selectByAttribute(userRepeact);
		if(userRepeact!=null){
			return PageBeanUtils.formatForNormalFalse("", "该邮箱已被注册");
		}
		
		userService.doInsert(user);//用户注册插入数据
		return PageBeanUtils.formatForNormalTrue("", user);
		
	}
	
	/**
	 * 用户登录
	 * @param Email
	 * @param Password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="normal/login",method=RequestMethod.POST)
	@ResponseBody
	public Object doLogin(String Email,String Password) throws Exception{
		User user = new User();
		user.setUserEmail(Email);
		user.setUserPassword(Password);
		
		User isExist = new User(); //用于检测是否存在该用户
		isExist.setUserEmail(Email);
		isExist.setUserPassword(Password);
		isExist = userService.selectByAttribute(isExist);
		if(isExist == null){
			return PageBeanUtils.formatForNormalFalse("", "用户名或密码错误");
		}
		if(isExist.getUserState() == 1){
			return PageBeanUtils.formatForNormalFalse("", "该用户被禁用请联系管理员");
		}
		RedisUtils.save(KeyUtils.getToken("user"+isExist.getUserId()), isExist, KeyUtils.TOKEN_TIME);
		return PageBeanUtils.formatForNormalTrue(KeyUtils.getToken("user"+isExist.getUserId()), isExist);
		
	}
	
	/**
	 *  用户资料更新
	 * @param request
	 * @param response
	 * @param token
	 * @param userString
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="doUpdate",method=RequestMethod.POST)
	@ResponseBody
	public Object doUpdate(String token,String userString)throws Exception{
		User user = JSON.parseObject(userString, User.class);
		User tokenUser = RedisUtils.get(token, User.class);
		
		if(tokenUser == null){
			return PageBeanUtils.formatForNormalFalse("", "用户登录到期请重新登录");
		}
		user.setUserId(tokenUser.getUserId());
		
		int flg = userService.doUpdateByPrimaryKeySelective(user);
		if(flg == 0){
			return PageBeanUtils.formatForNormalFalse("", "更新失败");
		}
		return PageBeanUtils.formatForNormalTrue("", user);
	}
}
