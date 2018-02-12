package com.hxkj.totops.service.inter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hxkj.totops.entity.SysFile;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.IBaseService;

public interface ISysFileService extends IBaseService<SysFile> {

	public Map<String,Object> insertFile(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
}
