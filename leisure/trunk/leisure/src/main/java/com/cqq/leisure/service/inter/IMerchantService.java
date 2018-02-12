package com.cqq.leisure.service.inter;

import java.util.List;

import com.cqq.leisure.entity.Merchant;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.IBaseService;

public interface IMerchantService extends IBaseService<Merchant> {

	/**
	 * 通过经纬度，距离查询最近的商家
	 * @param longitude	经度
	 * @param latitude	纬度
	 * @param distance	距离
	 * @return
	 * @throws Exception
	 */
	public List<Merchant> selectNearByMerchant(String longitude,String latitude,float distance) throws Exception;
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
	public List<Merchant> selectByKeyWord(String keyWord ) throws Exception;
}
