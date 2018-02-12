package com.cqq.leisure.service.inter;

import java.util.List;

import com.cqq.leisure.entity.Active;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.IBaseService;

public interface IActiveService extends IBaseService<Active> {
	/***
	 * 根据常驻位置信息，推送社区活动
	 * @param token
	 * @return
	 * @throws Exception
	 */
	public List<Active> selectNearByActive(String token) throws Exception;
	/***
	 * 获取活动列表
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<Active> selectAll(PageBean<Active> pageBean) throws Exception;
	/***
	 * 通过关键字搜索
	 */
	public List<Active> selectByKeyWord(String keyWord) throws Exception;
}
