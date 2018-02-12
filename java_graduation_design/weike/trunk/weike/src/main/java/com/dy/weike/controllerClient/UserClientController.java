package com.dy.weike.controllerClient;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.KeyUtils;
import com.dy.weike.core.utils.PageBeanUtils;
import com.dy.weike.core.utils.RedisUtils;
import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.User;
import com.dy.weike.service.impl.UserService;
import com.dy.weike.service.inter.IUserService;

import redis.clients.util.KeyMergeUtil;

@Controller
@RequestMapping(value="client/user")
public class UserClientController {
	
	@Resource
	private IUserService userService;
	
	/**
	 * 注册
	 * @param userEmail
	 * @param userPassword
	 * @return
	 */
	@RequestMapping(value="insert")
	@ResponseBody
	public Object doRegister(String userEmail,String userPassword){
		User user = new User();
		user.setUserEmaile(userEmail);
		User userExist = userService.selectByAttribute(user);
		if(userExist != null){
			return PageBeanUtils.formatForNormalFalse("", "邮箱已注册！");
		}
		user.setPassword(userPassword);
		user.setUserCreatetime(TimeUtils.getMySqlFormatTime());
		user.setUserAge(0);
		user.setUserEdu("高中");
		user.setUserExperience(0);
		user.setUserTeacher(false);
		user.setUserType(0);
		user.setUserVip(false);
		user.setUserInterest("1;2;3;4;5");
		user.setUserState(0);
		user.setUserNickname("昵称为空");
		user.setUserVip(false);
		userService.insertSelective(user);
		return PageBeanUtils.formatForNormalTrue("", "注册成功！");
	}
	
	/***
	 * 
	 * 登录
	 * @param userEmail
	 * @param userPassword
	 * @return
	 */
	@RequestMapping(value="login")
	@ResponseBody
	public Object doLogin(String userEmail,String userPassword){
		User user = new User();
		user.setUserEmaile(userEmail);
		User userExist = userService.selectByAttribute(user);
		if(userExist == null){
			return PageBeanUtils.formatForNormalFalse("", "邮箱不存在！");
		}
		if(!userExist.getPassword().equals(userPassword)){
			System.out.println(userPassword);
			System.out.println(userExist.getPassword());	
			return PageBeanUtils.formatForNormalFalse("", "用户名或密码错误");
		}
		RedisUtils.save(KeyUtils.getToken("user" + userExist.getUserId()), userExist, KeyUtils.TOKEN_TIME);
		return PageBeanUtils.formatForNormalTrue(KeyUtils.getToken("user"+userExist.getUserId()), userExist);
	}
	
	/**
	 * 获取个人信息
	 */
	@RequestMapping(value="showPersonInfo")
	@ResponseBody
	public Object showPersonInfo(int userId){
		User user = new User();
		user.setUserId(userId);
		User userExist = userService.selectByPrimaryKey(user);
		if(userExist != null){
			return PageBeanUtils.formatForNormalTrue("", userExist);			
		}
		return PageBeanUtils.formatForNormalFalse("", "该用户不存在！");		
	}
	
	/**
	 * 保存个人信息
	 */
	@RequestMapping(value="savePersonInfo")
	@ResponseBody
	public Object savaPersonInfo(int userId,int userAge,int userType,String userEdu,String nickName,String userInterest){
		User user = new User();
		user.setUserId(userId);
		User userExist = userService.selectByPrimaryKey(user);
		if(userExist != null){
			userExist.setUserAge(userAge);
			userExist.setUserType(userType);
			userExist.setUserEdu(userEdu);
			userExist.setUserNickname(nickName);
			System.out.println("--------userInterest");
			System.out.println(userInterest);
			userExist.setUserInterest(userInterest);
			userService.updateByPrimaryKey(userExist);
			return PageBeanUtils.formatForNormalTrue("", "保存成功");			
		}
		return PageBeanUtils.formatForNormalTrue("", "此用户不存在！");		
	}
	
	
	
}
