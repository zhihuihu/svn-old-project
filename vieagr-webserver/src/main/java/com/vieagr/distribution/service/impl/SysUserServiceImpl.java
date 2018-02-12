package com.vieagr.distribution.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.Base64FileUtils;
import com.vieagr.distribution.base.util.PropertiesUtils;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.dao.SysUserDao;
import com.vieagr.distribution.entity.SysUser;
import com.vieagr.distribution.query.SysUserQuery;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISysUserService;

@Service
@Transactional
public class SysUserServiceImpl extends BaseService<SysUser>implements ISysUserService{

	@Autowired
	private SysUserDao sysUserDao;
	
	@Override
	public ReturnUtils selectUserList(SysUserQuery sysUserQuery) throws Exception {
		PageHelper.startPage(sysUserQuery.getCurrentPage(), sysUserQuery.getPageSize());
		List<SysUser> list = sysUserDao.selectByAttributeAnd(Utils.exchangeObject(sysUserQuery, SysUser.class));
		PageInfo<SysUser> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils addOneSysUser(SysUser sysUser) throws Exception {
		sysUser.setSysUserId(UUID.randomUUID().toString());
		if(sysUser.getSysUserName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.ADD_USER_FOR_USER_NAME_ERROR);
		}
		SysUser sysUserCheck = sysUserDao.selectUserByUserName(sysUser.getSysUserName());
		if(null != sysUserCheck){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.ADD_USER_FOR_USER_NAME_IS_USED);
		}
		if(!Utils.isMobile(sysUser.getSysUserMobileNumber())){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.ADD_USER_FOR_PHONE_NUMBER_ERROR);
		}
		if(null == sysUser.getSysUserPassword() || sysUser.getSysUserPassword().trim().length() < 6){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.ADD_USER_FOR_PASSWORD_ERROR);
		}
		sysUser.setSysUserImgUrl(Base64FileUtils.base64ToImageFile(sysUser.getSysUserImgUrl(), PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		sysUser.setSysUserCreateTime(Utils.getNowTime());
		this.insertSelective(sysUser);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.ADD_USER_SUCCESS);
	}

	@Override
	public ReturnUtils selectSysUserList(SysUser sysUser) throws Exception {
		if(!StringUtils.isEmpty(sysUser.getSearchName()) && !sysUser.getSearchName().trim().equals("")){
			sysUser.setSysUserName(sysUser.getSearchName());
			sysUser.setSysUserRealName(sysUser.getSearchName());
			sysUser.setSysUserMobileNumber(sysUser.getSearchName());
		}
		PageHelper.startPage(sysUser.getCurrentPage(), sysUser.getPageSize());
		List<SysUser> list = sysUserDao.selectSysUserList(sysUser);
		PageInfo<SysUser> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, page.getPageNum(), 
				page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

}
