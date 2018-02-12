package com.dy.weike.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IClassDao;
import com.dy.weike.entity.Class;
import com.dy.weike.service.inter.IClassService;
@Service
@Transactional
public class ClassService implements IClassService {
 
	@Resource
	private IClassDao iClassDao;
	@Override
	public int deleteByPrimaryKey(Class b) {
		return iClassDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(Class b) {
		return iClassDao.insert(b);
	}

	@Override
	public int insertSelective(Class b) {
		return iClassDao.insertSelective(b);
	}

	@Override
	public Class selectByPrimaryKey(Class b) {
		return iClassDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(Class b) {
		return iClassDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(Class b) {
		return iClassDao.updateByPrimaryKey(b);
	}
	
	@Override
	public Object selectByAttribute(Class b) {
		List<Class> classes = iClassDao.selectByAttribute(b);
		List<Class> list = new ArrayList<Class>();
		System.out.println(classes);
		if( classes!= null && classes.size() != 0){
			for(int i=0;i<classes.size();i++){
				list.add(classes.get(i));
			}
			return list;
		}
		return null;
	}

	@Override
	public Object selectByAttributeLimit(Class b) {
		List<Class> classes = iClassDao.selectByAttributeLimit(b);
		List<Class> list = new ArrayList<Class>();
		System.out.println(classes);
		if( classes!= null && classes.size() != 0){
			for(int i=0;i<classes.size();i++){
				list.add(classes.get(i));
			}
			return list;
		}
		return null;
	}

	@Override
	public Object selectByType(Class b) {
		List<Class> classes = iClassDao.selectByType(b);
		List<Class> list = new ArrayList<Class>();
		System.out.println(classes);
		if( classes!= null && classes.size() != 0){
			for(int i=0;i<classes.size();i++){
				list.add(classes.get(i));
			}
			return list;
		}
		return null;
	}

	@Override
	public Object selectByHobby(Class b) {
		List<Class> classes = iClassDao.selectByHobby(b);
		List<Class> list = new ArrayList<Class>();
		System.out.println(classes);
		if( classes!= null && classes.size() != 0){
			for(int i=0;i<classes.size();i++){
				list.add(classes.get(i));
			}
			return list;
		}
		return null;
	}

	@Override
	public Object selectWord(Class b) {
		List<Class> classes = iClassDao.selectWord(b);
		List<Class> list = new ArrayList<Class>();
		System.out.println(classes);
		if( classes!= null && classes.size() != 0){
			for(int i=0;i<classes.size();i++){
				list.add(classes.get(i));
			}
			return list;
		}
		return null;
	}	

}
