package com.cqq.leisure.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cqq.leisure.entity.Active;
import com.cqq.leisure.entity.Merchant;
import com.cqq.leisure.entity.PageBean;
@Repository
public interface IMerchantDao extends IBaseDao<Merchant> {

	/***
	 * 获取列表 商家
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<Merchant> selectAll( PageBean<Merchant> pageBean) throws Exception;

	/***
	 * 通过关键字搜素商家
	 * @param pageBean
	 * @return
	 * @throws Exception
	 */
	public List<Merchant> selectByKeyWord(PageBean<Merchant> pageBean ) throws Exception;
}
