package com.cqq.leisure.dao;

import java.util.List;

import com.cqq.leisure.entity.Active;
import com.cqq.leisure.entity.PageBean;

public interface IActiveDao extends IBaseDao<Active> {

	/***
	 * 获取活动列表
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<Active> selectAll(PageBean<Active> pageBean) throws Exception;
	/***
	 * 通过关键字搜素活动
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<Active> selectByKeyWord(PageBean<Active> pageBean ) throws Exception;
}
