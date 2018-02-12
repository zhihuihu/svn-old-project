package com.cqq.leisure.service.inter;

import java.util.List;

import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.Tag;
import com.cqq.leisure.service.IBaseService;

public interface ITagService extends IBaseService<Tag> {

	/***
	 * 获取标签列表
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<Tag> selectAll(PageBean<Tag> pageBean) throws Exception;
}
