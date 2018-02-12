package com.dy.weike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dy.weike.entity.UserSession;

/**
 * 用户-课时db层
 * @author dy
 *
 */
@Repository
public interface IUserSessionDao extends IBaseDao<UserSession> {
	
	int deleteByAttribute(UserSession b);
	UserSession selectBySessionId(UserSession b);
	List<UserSession> selectDaySession(UserSession b);
	List<UserSession> selectWeekSession(UserSession b);
	List<UserSession> selectMonSession(UserSession b);
}
