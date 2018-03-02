package com.vieagr.distribution.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.Base64FileUtils;
import com.vieagr.distribution.base.util.PropertiesUtils;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.dao.SysSenderDao;
import com.vieagr.distribution.entity.SysSender;
import com.vieagr.distribution.query.SysSenderQuery;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISysSenderService;

@Service
@Transactional
public class SysSenderServiceImpl extends BaseService<SysSender>implements ISysSenderService{

	@Autowired
	private SysSenderDao sysSenderDao;
	
	@Override
	public ReturnUtils selectSenderList(SysSenderQuery senderQuery) throws Exception {
		PageHelper.startPage(senderQuery.getCurrentPage(), senderQuery.getPageSize());
		List<SysSender> list = sysSenderDao.selectByAttributeAnd(Utils.exchangeObject(senderQuery, SysSender.class));
		PageInfo<SysSender> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils selectSenderList(SysSender sysSender) throws Exception {
		PageHelper.startPage(sysSender.getCurrentPage(), sysSender.getPageSize());
		List<SysSender> list = sysSenderDao.selectByAttributeAnd(sysSender);
		PageInfo<SysSender> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils sysSenderAdd(SysSender sysSender) throws Exception {
		if(null == sysSender || null == sysSender.getSysSenderName() || sysSender.getSysSenderName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_SENDER_DATA_ERROR);
		}
		if(!Utils.isMobile(sysSender.getSysSenderMobileNumber())){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_SENDER_MOBILE_ERROR);
		}
		sysSender.setSysSenderId(UUID.randomUUID().toString());
		sysSender.setSysSenderCreateTime(Utils.getNowTime());
		sysSender.setSysSenderImgUrl(Base64FileUtils.base64ToImageFile(sysSender.getSysSenderImgUrl(), PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		int flg = sysSenderDao.insertSelective(sysSender);
		if(flg <= 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.SYS_SENDER_ADD_SUCCESS);
	}

	@Override
	public ReturnUtils selectSysSenderList(SysSender sysSender) throws Exception {
		PageHelper.startPage(sysSender.getCurrentPage(), sysSender.getPageSize());
		sysSender.setSysSenderName(sysSender.getSearchName());
		sysSender.setSysSenderMobileNumber(sysSender.getSearchName());
		List<SysSender> list = sysSenderDao.selectSysSenderList(sysSender);
		PageInfo<SysSender> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

}
