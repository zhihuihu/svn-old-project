package com.hxkj.totops.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.totops.core.config.Constant;
import com.hxkj.totops.core.config.EnumConfig;
import com.hxkj.totops.core.utils.MultipleFileUtils;
import com.hxkj.totops.core.utils.PropertiesUtils;
import com.hxkj.totops.core.utils.TimeUtils;
import com.hxkj.totops.entity.SysFile;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.BaseService;
import com.hxkj.totops.service.inter.ISysFileService;

@Service
@Transactional
public class SysFileService extends BaseService<SysFile> implements ISysFileService {

	@Override
	public Map<String, Object> insertFile(HttpServletRequest request, ParameterBean parameterBean) throws Exception {
		String sysFileUrl = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), false, true);
		String sysFileThunbUrl = MultipleFileUtils.getOneFileThunbUrl(request, PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL));
		SysFile sysFile = new SysFile();
		sysFile.setSysFileCuid(UUID.randomUUID().toString());
		sysFile.setSysFileThumbUrl(sysFileThunbUrl);
		sysFile.setSysFileUrl(sysFileUrl);
		sysFile.setSysFileType(EnumConfig.SYS_FILE_TYPE_IMAGE.getIndex());
		sysFile.setSysFileState(1);
		sysFile.setSysFileCreateTime(TimeUtils.getNowTime());
		this.insertSelective(sysFile);
		Map<String, Object> map = new HashMap<>();
		map.put("name", "image.jpg");
		map.put("originalName", "image.jpg");
		map.put("size", "99697");
		map.put("state", "SUCCESS");
		map.put("type", ".jpg");
		map.put("url", sysFileUrl);
		return map;
	}

}
