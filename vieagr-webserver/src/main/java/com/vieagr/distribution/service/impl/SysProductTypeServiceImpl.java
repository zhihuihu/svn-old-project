package com.vieagr.distribution.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.dao.SysProductTypeDao;
import com.vieagr.distribution.entity.SysProductType;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISysProductTypeService;

@Service
@Transactional
public class SysProductTypeServiceImpl extends BaseService<SysProductType> implements ISysProductTypeService{

	@Autowired
	private SysProductTypeDao sysProductTypeDao;
	
	@Override
	public ReturnUtils selectProductTypeList(SysProductType sysProductType) throws Exception {
		PageHelper.startPage(sysProductType.getCurrentPage(), sysProductType.getPageSize());
		List<SysProductType> list = sysProductTypeDao.selectByAttributeAnd(sysProductType);
		PageInfo<SysProductType> page = new PageInfo<SysProductType>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

}
