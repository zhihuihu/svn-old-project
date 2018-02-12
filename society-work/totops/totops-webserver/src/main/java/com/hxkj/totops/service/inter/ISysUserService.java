package com.hxkj.totops.service.inter;

import java.util.Map;

import com.hxkj.totops.entity.SysUser;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.IBaseService;

public interface ISysUserService extends IBaseService<SysUser> {
	/**
	 * @Title: login 
	 * @Description:     管理员登录
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 上午10:50:58
	 */
	public Map<String, Object> login(ParameterBean parameterBean) throws Exception;
}
