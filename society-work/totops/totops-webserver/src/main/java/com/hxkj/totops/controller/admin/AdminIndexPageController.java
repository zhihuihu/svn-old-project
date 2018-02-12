package com.hxkj.totops.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.totops.core.utils.JackSonUtils;
import com.hxkj.totops.core.utils.PageReturnUtils;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.inter.IIndexPageService;

/**
 * @ClassName: AdminIndexPageController 
 * @Description: 主页的管理控制器
 * @author huzhihui_c@qq.com
 * @date 2016年8月30日 下午1:20:11
 */
@Controller
@RequestMapping(value="admin/indexPage")
public class AdminIndexPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminIndexPageController.class);
	
	@Autowired
	private IIndexPageService iIndexPageService;
	/**
	 * @Title: insertMainImage 
	 * @Description:     主页--增加一个主页轮播图片
	 * @param request
	 * @param parameterBeanString
	 * @return   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午1:27:01
	 */
	@RequestMapping(value="insertMainImage")
	@ResponseBody
	public Map<String,Object> insertMainImage(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----主页--增加一个主页轮播图片");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iIndexPageService.insertMainImage(request, parameterBean);
	}
	
	/**
	 * @Title: updateMainImage 
	 * @Description:     主页--更新一个主页轮播图片
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午7:38:43
	 */
	@RequestMapping(value="updateMainImage")
	@ResponseBody
	public Map<String,Object> updateMainImage(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----主页--更新一个主页轮播图片");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iIndexPageService.updateMainImage(request, parameterBean);
	}
	
	/**
	 * @Title: deleteMainImage 
	 * @Description:     主页--删除一个主页轮播图片
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:23:10
	 */
	@RequestMapping(value="deleteMainImage")
	@ResponseBody
	public Map<String,Object> deleteMainImage(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----主页--删除一个主页轮播图片");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getIndexPage()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，删除失败");
		}
		if(iIndexPageService.deleteByPrimaryKey(parameterBean.getIndexPage().getIndexPageCuid()) > 0){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "删除成功");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "该信息不存在，删除失败");
	}
	
	/**
	 * @Title: insertMidInfo 
	 * @Description:     主页--增加一个主页中间内容
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:25:06
	 */
	@RequestMapping(value="insertMidInfo")
	@ResponseBody
	public Map<String,Object> insertMidInfo(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----主页--增加一个主页中间内容");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iIndexPageService.insertMidInfo(request, parameterBean);
	}
	
	/**
	 * @Title: updateMidInfo 
	 * @Description:     主页--更新一个主页中间内容
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:31:54
	 */
	@RequestMapping(value="updateMidInfo")
	@ResponseBody
	public Map<String,Object> updateMidInfo(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----主页--更新一个主页中间内容");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iIndexPageService.updateMidInfo(request, parameterBean);
	}
	
	/**
	 * @Title: deleteMidImage 
	 * @Description:     主页--删除一个中间内容
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:35:06
	 */
	@RequestMapping(value="deleteMidImage")
	@ResponseBody
	public Map<String,Object> deleteMidImage(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----主页--删除一个中间内容");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getIndexPage()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，删除失败");
		}
		if(iIndexPageService.deleteByPrimaryKey(parameterBean.getIndexPage().getIndexPageCuid()) > 0){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "删除成功");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "该信息不存在，删除失败");
	}
	
	/**
	 * @Title: insertBottomInfo 
	 * @Description:     主页--增加一个主页底部图片内容
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:37:01
	 */
	@RequestMapping(value="insertBottomInfo")
	@ResponseBody
	public Map<String,Object> insertBottomInfo(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----主页--增加一个主页底部图片内容");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iIndexPageService.insertBottomInfo(request, parameterBean);
	}
	
	/**
	 * @Title: updateBottomInfo 
	 * @Description:     主页--更新一个主页底部图片内容
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:41:28
	 */
	@RequestMapping(value="updateBottomInfo")
	@ResponseBody
	public Map<String,Object> updateBottomInfo(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----主页--更新一个主页底部图片内容");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iIndexPageService.updateBottomInfo(request, parameterBean);
	}
	
	/**
	 * @Title: deleteBottomInfo 
	 * @Description:     主页--删除一个底部内容
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午8:43:35
	 */
	@RequestMapping(value="deleteBottomInfo")
	@ResponseBody
	public Map<String,Object> deleteBottomInfo(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----主页--删除一个底部内容");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getIndexPage()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，删除失败");
		}
		if(iIndexPageService.deleteByPrimaryKey(parameterBean.getIndexPage().getIndexPageCuid()) > 0){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "删除成功");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "该信息不存在，删除失败");
	}
}
