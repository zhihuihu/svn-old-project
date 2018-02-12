package com.dy.weike.service.inter;

import com.dy.weike.entity.ClassSession;
import com.dy.weike.service.IBaseService;

public interface IClassSessionService extends IBaseService<ClassSession> {

	/**
	 * 通过bean的属性查找
	 * @param b
	 * @return Object
	 */
	Object selectByAttribute(ClassSession b);
}
