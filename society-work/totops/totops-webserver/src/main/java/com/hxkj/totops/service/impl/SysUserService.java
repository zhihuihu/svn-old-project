package com.hxkj.totops.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.totops.core.config.Constant;
import com.hxkj.totops.core.utils.PageReturnUtils;
import com.hxkj.totops.core.utils.PropertiesUtils;
import com.hxkj.totops.entity.SysUser;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.BaseService;
import com.hxkj.totops.service.inter.ISysUserService;

@Service
@Transactional
public class SysUserService extends BaseService<SysUser> implements ISysUserService {

	private final static Logger logger = LoggerFactory.getLogger(SysUserService.class);

	@Override
	public Map<String, Object> login(ParameterBean parameterBean) throws Exception {
		if (null == parameterBean || null == parameterBean.getSysUser()) {
			logger.info("-----管理员登录参数传入错误");
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE,
					Constant.LOGIN_FALSE);
		}
		SysUser sysUser = parameterBean.getSysUser();
		if (null == sysUser.getSysUserLoginName() || sysUser.getSysUserLoginName().trim().equals("")
				|| null == sysUser.getSysUserPassword() || sysUser.getSysUserPassword().trim().equals("")) {
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE,
					Constant.LOGIN_FALSE);
		}
		List<SysUser> sysUsers = this.selectByAttribute(sysUser);
		if(null == sysUsers || 0 == sysUsers.size()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE,
					Constant.LOGIN_FALSE);
		}
		return PageReturnUtils.formatNormal(PropertiesUtils.getPropertiesValue(Constant.TOKEN), PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE,
				Constant.LOGIN_TRUE);
	}

}
