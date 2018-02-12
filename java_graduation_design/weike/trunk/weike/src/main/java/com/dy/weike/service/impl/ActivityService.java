package com.dy.weike.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IActivityDao;
import com.dy.weike.entity.Activity;
import com.dy.weike.service.inter.IActivityService;

@Service
@Transactional
public class ActivityService implements IActivityService {
	
	@Resource
	private IActivityDao iActivityDao;
	
	@Override
	public int deleteByPrimaryKey(Activity b) {
		return iActivityDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(Activity b) {
		return iActivityDao.insert(b);
	}

	@Override
	public int insertSelective(Activity b) {
		return iActivityDao.insertSelective(b);
	}

	@Override
	public Activity selectByPrimaryKey(Activity b) {
		return iActivityDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(Activity b) {
		return iActivityDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(Activity b) {
		return iActivityDao.updateByPrimaryKey(b);
	}
	
	@Override
	public Object selectByAttibute(Activity b){
		return iActivityDao.selectByAttribute(b);
	}

}
