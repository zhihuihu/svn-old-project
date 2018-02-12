package com.dy.weike.service.inter;


import com.dy.weike.entity.User;
import com.dy.weike.service.IBaseService;

public interface IUserService extends IBaseService<User> {

	/**
	 * 通过bean的属性查询
	 * @param b
	 * @return User
	 */
	User selectByAttribute(User b);
}
