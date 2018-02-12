package com.cqq.leisure.service.inter;

import java.util.List;

import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.service.IBaseService;

public interface IUserService extends IBaseService<User> {

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
