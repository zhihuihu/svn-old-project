package com.dy.weike.service.inter;

import com.dy.weike.entity.UserSession;
import com.dy.weike.service.IBaseService;

public interface IUserSessionService extends IBaseService<UserSession> {

	/**
	 * 通过bean的属性查找
	 * @param b
	 * @return
	 */		
	Object selectByAttribute(UserSession b);
	int deleteByAttribute(UserSession b);
	UserSession selectBySessionId(UserSession b);
	Object selectDaySession(UserSession b);
	Object selectWeekSession(UserSession b);
	Object selectMonSession(UserSession b);
}
