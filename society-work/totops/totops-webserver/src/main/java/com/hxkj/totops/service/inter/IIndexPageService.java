package com.hxkj.totops.service.inter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.hxkj.totops.entity.IndexPage;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.IBaseService;

public interface IIndexPageService extends IBaseService<IndexPage> {

	/**
	 * @Title: insertMainImage 
	 * @Description:     主页--增加一个主页轮播图片
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午1:33:03
	 */
	public Map<String,Object> insertMainImage(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
	
	/**
	 * @Title: updateMainImage 
	 * @Description:     主页--更新一个主页轮播图片
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午6:03:46
	 */
	public Map<String,Object> updateMainImage(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
	
	/**
	 * @Title: insertMidInfo 
	 * @Description:     主页--增加一个主页中间内容
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:28:04
	 */
	public Map<String,Object> insertMidInfo(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
	
	/**
	 * @Title: updateMidInfo 
	 * @Description:    主页--更新一个主页中间内容 
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:32:35
	 */
	public Map<String,Object> updateMidInfo(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
	
	/**
	 * @Title: insertBottomInfo 
	 * @Description:     主页--增加一个主页底部图片内容
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:38:40
	 */
	public Map<String,Object> insertBottomInfo(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
	
	/**
	 * @Title: updateBottomInfo 
	 * @Description:     主页--更新一个主页底部图片内容
	 * @param request
	 * @param parameterBean
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:42:12
	 */
	public Map<String,Object> updateBottomInfo(HttpServletRequest request,ParameterBean parameterBean) throws Exception;
}
