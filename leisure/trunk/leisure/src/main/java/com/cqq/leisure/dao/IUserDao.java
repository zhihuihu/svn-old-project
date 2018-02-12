package com.cqq.leisure.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;

@Repository
public interface IUserDao extends IBaseDao<User> {

	/**
	 * 通过属性查询user
	 * @param user 传入对象
	 * @return
	 * @throws Exception
	 */
	public User selectByAttribute(User user) throws Exception;
	
	/****
	 * 查询所有的User
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<User> selectAll(PageBean<User> pageBean) throws Exception;
}
