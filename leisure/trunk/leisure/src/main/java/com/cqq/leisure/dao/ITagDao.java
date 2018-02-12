package com.cqq.leisure.dao;

import java.util.List;

import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.Tag;

public interface ITagDao extends IBaseDao<Tag> {
	
	/***
	 * 获取标签列表
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<Tag> selectAll(PageBean<Tag> pageBean) throws Exception;

}
