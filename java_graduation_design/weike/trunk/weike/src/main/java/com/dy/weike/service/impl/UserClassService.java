package com.dy.weike.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IUserClassDao;
import com.dy.weike.entity.UserClass;
import com.dy.weike.service.inter.IUserClassService;

@Service
@Transactional
public class UserClassService implements IUserClassService {
	
	@Resource
	private IUserClassDao iUserClassDao;

	@Override
	public int deleteByPrimaryKey(UserClass b) {
		return iUserClassDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(UserClass b) {
		return iUserClassDao.insert(b);
	}

	@Override
	public int insertSelective(UserClass b) {
		return iUserClassDao.insertSelective(b);
	}

	@Override
	public UserClass selectByPrimaryKey(UserClass b) {
		return iUserClassDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(UserClass b) {
		return iUserClassDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(UserClass b) {
		return iUserClassDao.updateByPrimaryKey(b);
	}
	
	@Override
	public Object selectByAttribute(UserClass b){
		List<UserClass> userClass = iUserClassDao.selectByAttribute(b);
		List<UserClass> list = new ArrayList<UserClass>();
		if(userClass != null && userClass.size() != 0){
			for(int i = 0; i < userClass.size(); i++){
				list.add(userClass.get(i));
			}
			return list;
		}		
		return null;		
	}
}
