package com.hxkj.totops.service.impl;


import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.totops.core.config.Constant;
import com.hxkj.totops.core.config.EnumConfig;
import com.hxkj.totops.core.utils.MultipleFileUtils;
import com.hxkj.totops.core.utils.PageReturnUtils;
import com.hxkj.totops.core.utils.PropertiesUtils;
import com.hxkj.totops.core.utils.TimeUtils;
import com.hxkj.totops.dao.IMingPinHuiDao;
import com.hxkj.totops.entity.MingPinHui;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.BaseService;
import com.hxkj.totops.service.inter.IMingPinHuiService;

@Service
@Transactional
public class MingPinHuiService extends BaseService<MingPinHui> implements IMingPinHuiService {

	@Autowired
	private IMingPinHuiDao iMingPinHuiDao;
	
	@Override
	public Map<String, Object> insertOneMingPinHui(HttpServletRequest request, ParameterBean parameterBean)
			throws Exception {
		MingPinHui mingPinHui = parameterBean.getMingPinHui();
		String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		mingPinHui.setMingPinHuiImage(imageUrl);
		mingPinHui.setMingPinHuiCuid(UUID.randomUUID().toString());
		mingPinHui.setMingPinHuiCreateTime(TimeUtils.getNowTime());
		mingPinHui.setMingPinHuiType(EnumConfig.MING_PIN_HUI_TYPE_ONE.getIndex());
		iMingPinHuiDao.insertSelective(mingPinHui);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "新增名品汇成功");
	}

	@Override
	public Map<String, Object> updateOneMingPinHui(HttpServletRequest request, ParameterBean parameterBean)
			throws Exception {
		MingPinHui mingPinHui = parameterBean.getMingPinHui();
		if(null == mingPinHui || mingPinHui.getMingPinHuiCuid() == null ){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数有误，修改失败");
		}
		String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		mingPinHui.setMingPinHuiImage(imageUrl);
		mingPinHui.setMingPinHuiUpdateTime(TimeUtils.getNowTime());
		if(iMingPinHuiDao.updateByPrimaryKeySelective(mingPinHui) > 0){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "修改名品汇成功");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "没有找到该数据，修改失败");
	}

}
