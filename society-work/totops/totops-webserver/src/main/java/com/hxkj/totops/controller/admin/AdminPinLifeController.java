package com.hxkj.totops.controller.admin;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.totops.core.config.EnumConfig;
import com.hxkj.totops.core.utils.JackSonUtils;
import com.hxkj.totops.core.utils.PageReturnUtils;
import com.hxkj.totops.core.utils.TimeUtils;
import com.hxkj.totops.entity.PinLife;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.inter.IPinLifeService;

/**
 * @ClassName: AdminPinLifeController 
 * @Description: 管理端--品生活
 * @author huzhihui_c@qq.com
 * @date 2016年8月31日 上午9:39:17
 */
@Controller
@RequestMapping(value="admin/pinLife")
public class AdminPinLifeController {

	private static final Logger logger = LoggerFactory.getLogger(AdminPinLifeController.class);
	
	@Autowired
	private IPinLifeService iPinLifeService;
	
	/**
	 * @Title: insertLeftInfo 
	 * @Description:     
	 * @param parameterBeanString
	 * @return   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午9:44:14
	 */
	@RequestMapping(value="insertLeftInfo")
	@ResponseBody
	public Map<String, Object> insertLeftInfo(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----品生活--增加一个左侧列表内容");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，新增失败");
		}
		PinLife pinLife = parameterBean.getPinLife();
		pinLife.setPinLifeCuid(UUID.randomUUID().toString());
		pinLife.setPinLifeType(EnumConfig.PIN_LIFE_TYPE_LEFT.getIndex());
		pinLife.setPinLifeCreateTime(TimeUtils.getNowTime());
		iPinLifeService.insertSelective(pinLife);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "新增成功");
	}
	
	/**
	 * @Title: updateLeftInfo 
	 * @Description:     品生活--修改一个左侧列表内容
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午9:56:59
	 */
	@RequestMapping(value="updateLeftInfo")
	@ResponseBody
	public Map<String, Object> updateLeftInfo(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----品生活--修改一个左侧列表内容");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，更新失败");
		}
		PinLife pinLife = parameterBean.getPinLife();
		pinLife.setPinLifeUpdateTime(TimeUtils.getNowTime());
		if(iPinLifeService.updateByPrimaryKeySelective(pinLife) > 0){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "更新成功");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "没有找到该数据，更新失败");
	}
	
	/**
	 * @Title: deleteByPrimaryKey 
	 * @Description:     品生活--删除一个内容
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午9:59:30
	 */
	@RequestMapping(value="deleteByPrimaryKey")
	@ResponseBody
	public Map<String,Object> deleteByPrimaryKey(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----品生活--删除一个内容");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，删除失败");
		}
		if(iPinLifeService.deleteByPrimaryKey(parameterBean.getPinLife().getPinLifeCuid()) > 0){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "删除成功");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "没有找到该数据，删除失败");
	}
	
	/**
	 * @Title: insertRightInfo 
	 * @Description:     品生活--增加一个右下列表内容
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午10:21:07
	 */
	@RequestMapping(value="insertRightInfo")
	@ResponseBody
	public Map<String, Object> insertRightInfo(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----品生活--增加一个右下列表内容");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，新增失败");
		}
		PinLife pinLife = parameterBean.getPinLife();
		pinLife.setPinLifeCuid(UUID.randomUUID().toString());
		pinLife.setPinLifeType(EnumConfig.PIN_LIFE_TYPE_RIGHT.getIndex());
		pinLife.setPinLifeCreateTime(TimeUtils.getNowTime());
		iPinLifeService.insertSelective(pinLife);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "新增成功");
	}
	
	/**
	 * @Title: updateRightInfo 
	 * @Description:     品生活--修改一个右侧下列表内容
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午10:22:36
	 */
	@RequestMapping(value="updateRightInfo")
	@ResponseBody
	public Map<String, Object> updateRightInfo(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----品生活--修改一个右侧下列表内容");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，更新失败");
		}
		PinLife pinLife = parameterBean.getPinLife();
		pinLife.setPinLifeUpdateTime(TimeUtils.getNowTime());
		if(iPinLifeService.updateByPrimaryKeySelective(pinLife) > 0){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "更新成功");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "没有找到该数据，更新失败");
	}
	
	/**
	 * @Title: insertRightImage 
	 * @Description:    品生活--增加一个右上图片 
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月18日 下午12:44:41
	 */
	@RequestMapping(value="insertRightImage")
	@ResponseBody
	public Map<String, Object> insertRightImage(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----品生活--增加一个右上图片");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iPinLifeService.insertRightImage(request, parameterBean);
	}
	
	/**
	 * @Title: updateRightImage 
	 * @Description:   品生活--更新一个右上图片  
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月18日 下午12:53:42
	 */
	@RequestMapping(value="updateRightImage")
	@ResponseBody
	public Map<String, Object> updateRightImage(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----品生活--更新一个右上图片");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iPinLifeService.updateRightImage(request, parameterBean);
	}
}
