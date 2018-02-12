package com.dy.weike.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IUserSessionDao;
import com.dy.weike.entity.UserClass;
import com.dy.weike.entity.UserSession;
import com.dy.weike.service.inter.IUserSessionService;

@Service
@Transactional
public class UserSessionService implements IUserSessionService {
	
	@Resource
	private IUserSessionDao iUserSessionDao;

	@Override
	public int deleteByPrimaryKey(UserSession b) {
		return iUserSessionDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(UserSession b) {
		return iUserSessionDao.insert(b);
	}

	@Override
	public int insertSelective(UserSession b) {
		return iUserSessionDao.insertSelective(b);
	}

	@Override
	public UserSession selectByPrimaryKey(UserSession b) {
		return iUserSessionDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(UserSession b) {
		return iUserSessionDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(UserSession b) {
		return iUserSessionDao.updateByPrimaryKey(b);
	}

	@Override
	public Object selectByAttribute(UserSession b) {
		return iUserSessionDao.selectByAttribute(b);
	}

	@Override
	public int deleteByAttribute(UserSession b) {
		return iUserSessionDao.deleteByAttribute(b);
	}

	@Override
	public UserSession selectBySessionId(UserSession b) {
		return iUserSessionDao.selectBySessionId(b);
	}

	@Override
	public Object selectDaySession(UserSession b) {
		List<UserSession> userSession = (List<UserSession>) iUserSessionDao.selectDaySession(b);
		List<UserSession> list = new ArrayList<UserSession>();
		if(userSession != null && userSession.size() != 0){
			for(int i = 0; i < userSession.size(); i++){
				list.add(userSession.get(i));
			}
			return list;
		}		
		return null;
	}

	@Override
	public Object selectWeekSession(UserSession b) {
		List<UserSession> userSession = (List<UserSession>) iUserSessionDao.selectWeekSession(b);
		List<UserSession> list = new ArrayList<UserSession>();
		if(userSession != null && userSession.size() != 0){
			for(int i = 0; i < userSession.size(); i++){
				list.add(userSession.get(i));
			}
			return list;
		}		
		return null;
	}

	@Override
	public Object selectMonSession(UserSession b) {
		List<UserSession> userSession = (List<UserSession>) iUserSessionDao.selectMonSession(b);
		List<UserSession> list = new ArrayList<UserSession>();
		if(userSession != null && userSession.size() != 0){
			for(int i = 0; i < userSession.size(); i++){
				list.add(userSession.get(i));
			}
			return list;
		}		
		return null;
	}

}
