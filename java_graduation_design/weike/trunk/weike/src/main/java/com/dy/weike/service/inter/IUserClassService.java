package com.dy.weike.service.inter;

import com.dy.weike.entity.UserClass;
import com.dy.weike.service.IBaseService;
import com.dy.weike.service.impl.UserClassService;

public interface IUserClassService extends IBaseService<UserClass> {
	
	/**
	 * 通过bean的属性查找
	 * @param b
	 * @return
	 */	
	Object selectByAttribute(UserClass b);
}
