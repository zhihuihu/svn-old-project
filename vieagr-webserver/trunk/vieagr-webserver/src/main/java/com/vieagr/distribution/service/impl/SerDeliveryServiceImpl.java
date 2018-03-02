package com.vieagr.distribution.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.dao.SerDeliveryDao;
import com.vieagr.distribution.entity.SerDelivery;
import com.vieagr.distribution.query.SerDeliveryQuery;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISerDeliveryService;

@Service
@Transactional
public class SerDeliveryServiceImpl extends BaseService<SerDelivery> implements ISerDeliveryService{

	@Autowired
	private SerDeliveryDao serDeliveryDao;
	
	@Override
	public ReturnUtils selectDeliveryList(SerDeliveryQuery deliveryQuery) throws Exception {
		PageHelper.startPage(deliveryQuery.getCurrentPage(), deliveryQuery.getPageSize());
		List<SerDelivery> list = serDeliveryDao.selectByAttributeAnd(Utils.exchangeObject(deliveryQuery, SerDelivery.class));
		PageInfo<SerDelivery> page = new PageInfo<SerDelivery>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils selectDeliveryList(SerDelivery serDelivery) throws Exception {
		PageHelper.startPage(serDelivery.getCurrentPage(), serDelivery.getPageSize());
		List<SerDelivery> list = serDeliveryDao.selectByAttributeAnd(serDelivery);
		PageInfo<SerDelivery> page = new PageInfo<SerDelivery>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

}
