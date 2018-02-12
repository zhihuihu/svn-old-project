package com.dy.weike.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IUserDao;
import com.dy.weike.entity.User;
import com.dy.weike.service.inter.IUserService;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Resource
	private IUserDao iUserDao;

	@Override
	public int deleteByPrimaryKey(User b) {
		return iUserDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(User b) {
		return iUserDao.insert(b);
	}

	@Override
	public int insertSelective(User b) {
		return iUserDao.insertSelective(b);
	}

	@Override
	public User selectByPrimaryKey(User b) {
		return iUserDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(User b) {
		return iUserDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(User b) {
		return iUserDao.updateByPrimaryKey(b);
	}

	@Override
	public User selectByAttribute(User b) {
		List<User> users = iUserDao.selectByAttribute(b);
		if(users != null && users.size() != 0){
			return users.get(0);
		}
		return null;
	}

}
