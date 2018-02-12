package com.dy.weike.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IAskDao;
import com.dy.weike.entity.Ask;
import com.dy.weike.service.inter.IAskService;

@Service
@Transactional
public class AskService implements IAskService {
	
	@Resource
	private IAskDao iAskDao;

	@Override
	public int deleteByPrimaryKey(Ask b) {
		return iAskDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(Ask b) {
		return iAskDao.insert(b);
	}

	@Override
	public int insertSelective(Ask b) {
		return iAskDao.insertSelective(b);
	}

	@Override
	public Ask selectByPrimaryKey(Ask b) {
		return iAskDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(Ask b) {
		return iAskDao.updateByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKey(Ask b) {
		return iAskDao.updateByPrimaryKey(b);
	}
	
	@Override
	public Object selectByAttribute(Ask b){
		return iAskDao.selectByAttribute(b);
	}

	@Override
	public Object selectByAttributeByAskerId(Ask b) {
		return iAskDao.selectByAttributeByAskerId(b);
	}
	
	
}
