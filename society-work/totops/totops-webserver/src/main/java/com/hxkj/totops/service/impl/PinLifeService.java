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
import com.hxkj.totops.dao.IPinLifeDao;
import com.hxkj.totops.entity.PinLife;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.BaseService;
import com.hxkj.totops.service.inter.IPinLifeService;

@Service
@Transactional
public class PinLifeService extends BaseService<PinLife> implements IPinLifeService {

	@Autowired
	private IPinLifeDao iPinLifeDao;
	
	@Override
	public Map<String, Object> insertRightImage(HttpServletRequest request, ParameterBean parameterBean)
			throws Exception {
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入数据错误");
		}
		PinLife pinLife = parameterBean.getPinLife();
		String pinLifeRightImage = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		pinLife.setPinLifeCuid(UUID.randomUUID().toString());
		pinLife.setPinLifeRightImage(pinLifeRightImage);
		pinLife.setPinLifeType(EnumConfig.PIN_LIFE_TYPE_RIGHT_T.getIndex());
		pinLife.setPinLifeCreateTime(TimeUtils.getNowTime());
		iPinLifeDao.insertSelective(pinLife);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "品生活右上图片新增成功");
	}

	@Override
	public Map<String, Object> updateRightImage(HttpServletRequest request, ParameterBean parameterBean)
			throws Exception {
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入数据错误");
		}
		PinLife pinLife = parameterBean.getPinLife();
		String pinLifeRightImage = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		pinLife.setPinLifeRightImage(pinLifeRightImage);
		pinLife.setPinLifeUpdateTime(TimeUtils.getNowTime());
		if(iPinLifeDao.updateByPrimaryKeySelective(pinLife) > 0){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "品生活右上图片更新成功");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "未找到该数据，更新失败");
	}

}
