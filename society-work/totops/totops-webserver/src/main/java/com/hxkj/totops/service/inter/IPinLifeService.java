package com.hxkj.totops.service.inter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hxkj.totops.entity.PinLife;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.IBaseService;

public interface IPinLifeService extends IBaseService<PinLife> {

	/**
	 * @Title: insertRightImage 
	 * @Description:     品生活--增加一个右上图片
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月18日 下午12:44:24
	 */
	public Map<String, Object> insertRightImage(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
	
	/**
	 * @Title: updateRightImage 
	 * @Description:     品生活--更新一个右上图片
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月18日 下午12:53:27
	 */
	public Map<String, Object> updateRightImage(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
}
