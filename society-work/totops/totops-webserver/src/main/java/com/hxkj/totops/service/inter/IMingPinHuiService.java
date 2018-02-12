package com.hxkj.totops.service.inter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hxkj.totops.entity.MingPinHui;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.IBaseService;

public interface IMingPinHuiService extends IBaseService<MingPinHui> {

	/**
	 * @Title: insertOneMingPinHui 
	 * @Description:     名品汇--增加一个名品汇子内容
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午11:49:26
	 */
	public Map<String, Object> insertOneMingPinHui(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
	
	/**
	 * @Title: updateOneMingPinHui 
	 * @Description:     名品汇--更新一个名品汇子内容
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午11:49:57
	 */
	public Map<String, Object> updateOneMingPinHui(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
}
