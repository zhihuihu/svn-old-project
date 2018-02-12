package com.dy.weike.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IClassSessionDao;
import com.dy.weike.entity.ClassSession;
import com.dy.weike.service.inter.IClassSessionService;


@Service
@Transactional
public class ClassSessionService implements IClassSessionService {

	@Resource
	private IClassSessionDao iClassSessionDao;
	@Override
	public int deleteByPrimaryKey(ClassSession b) {
		return iClassSessionDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(ClassSession b) {
		return iClassSessionDao.insert(b);
	}

	@Override
	public int insertSelective(ClassSession b) {
		return iClassSessionDao.insertSelective(b);
	}

	@Override
	public ClassSession selectByPrimaryKey(ClassSession b) {
		return iClassSessionDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(ClassSession b) {
		return iClassSessionDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(ClassSession b) {
		return iClassSessionDao.updateByPrimaryKey(b);
	}
	
	@Override
	public Object selectByAttribute(ClassSession b) {
		List<ClassSession> classSession = iClassSessionDao.selectByAttribute(b);
		List<ClassSession> sessionList = new ArrayList<ClassSession>();
		System.out.println(classSession);
		if( classSession!= null && classSession.size() != 0){
			for(int i=0;i<classSession.size();i++){
				sessionList.add(classSession.get(i));
			}
			return sessionList;
		}
		return null;
	}

}
