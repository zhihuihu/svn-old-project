package com.cqq.leisure.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.service.inter.IUserService;

@Controller
@RequestMapping(value="admin/user")
public class UserAdminCtrl {
	@Resource
	private IUserService iUserService;
	
	/**
	 * 获取user列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list")
	@ResponseBody
	public Object getActiveList() throws Exception{
		User user = new User();
		PageBean<User> pageBean = new PageBean<User>(0, 100);
		pageBean.setInVo(user);
		return iUserService.selectAll(pageBean);
	}
	
	/***
	 * 通过UserId修改User信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="edit",method=RequestMethod.POST)
	@ResponseBody
	public Object updateActive(int userId,String userPassword,String userLoginName,String userMainRange) throws Exception{
		User user = new User();
		user.setUserId(userId);
		User userExict = iUserService.selectByPrimaryKey(user);
		if(userExict == null){
			return PageBeanUtils.formatForNormalFalse("", "不存在该用户");
		}
		userExict.setUserLoginName(userLoginName);
		userExict.setUserPassword(userPassword);
		userExict.setUserMainRange(userMainRange);
		iUserService.doUpdateByPrimaryKey(userExict);
		System.out.println(iUserService.doUpdateByPrimaryKey(userExict));
		if(iUserService.doUpdateByPrimaryKey(userExict) == 1){
			return PageBeanUtils.formatForNormalTrue("", "修改成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "修改失败");
		
	}
	
	/***
	 * 后台管理删除用户
	 * @param userId
	 * @return
	 * @throws Exception
	 * 当用户状态为1时表示禁用
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Object deleteUser(int userId) throws Exception{
		User user = new User();
		user.setUserId(userId);
		User userExict = iUserService.selectByPrimaryKey(user);
		System.out.println( userExict );
		if(userExict == null){
			return PageBeanUtils.formatForNormalFalse("", "不存在该用户");
		}
		userExict.setUserState(1);
		iUserService.doUpdateByPrimaryKey(userExict);
		return PageBeanUtils.formatForNormalTrue("", "删除成功");
	}
	/***
	 * 后台管理启动用户
	 * @param userId
	 * @return
	 * @throws Exception
	 * 当用户状态为0时表示启动
	 */
	@RequestMapping(value="start",method=RequestMethod.POST)
	@ResponseBody
	public Object startUser(int userId) throws Exception{
		User user = new User();
		user.setUserId(userId);
		User userExict = iUserService.selectByPrimaryKey(user);
		System.out.println( userExict );
		if(userExict == null){
			return PageBeanUtils.formatForNormalFalse("", "不存在该用户");
		}
		userExict.setUserState(0);
		iUserService.doUpdateByPrimaryKey(userExict);
		return PageBeanUtils.formatForNormalTrue("", "启动成功");
	}
}
