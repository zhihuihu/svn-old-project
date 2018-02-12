package com.dy.weike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dy.weike.entity.Class;

/**
 * 课程类db层
 * @author d-y
 *
 */
@Repository
public interface IClassDao extends IBaseDao<Class> {	
	/**
	 * 通过提出人查找
	 * @param b
	 * @return
	 */
	List<Class> selectByAttributeLimit(Class b);
	List<Class> selectByType(Class b);
	List<Class> selectByHobby(Class b);
	List<Class> selectWord(Class b);
}
