package com.dy.weike.service.inter;

import com.dy.weike.entity.Class;
import com.dy.weike.service.IBaseService;

public interface IClassService extends IBaseService<Class> {
	
	
	/**
	 * 通过bean的属性查找
	 * @param b
	 * @return Object
	 */
	Object selectByAttribute(Class b);
	Object selectByAttributeLimit(Class b);
	Object selectByType(Class b);
	Object selectByHobby(Class b);
	Object selectWord(Class b);
}
