package com.hxkj.totops.controller.web;

import java.util.List;
import java.util.Map;

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
import com.hxkj.totops.entity.PinLife;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.inter.IPinLifeService;

/**
 * @ClassName: WebPinLifeController 
 * @Description: web--品生活控制器
 * @author huzhihui_c@qq.com
 * @date 2016年8月31日 上午8:55:49
 */
@Controller
@RequestMapping(value="web/pinLife")
public class WebPinLifeController {

	private static final Logger logger = LoggerFactory.getLogger(WebPinLifeController.class);
	
	@Autowired
	private IPinLifeService iPinLifeService;
	
	/**
	 * @Title: selectLeftTypeList 
	 * @Description:    web--品生活--获取左边列表 
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午9:00:10
	 */
	@RequestMapping(value="selectLeftTypeList")
	@ResponseBody
	public Map<String,Object> selectLeftTypeList() throws Exception{
		logger.info("-----web--品生活--查询左侧列表");
		PinLife pinLife = new PinLife();
		pinLife.setPinLifeType(EnumConfig.PIN_LIFE_TYPE_LEFT.getIndex());
		List<PinLife> pinLifes = iPinLifeService.selectByAttribute(pinLife);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, pinLifes);
	}
	
	/**
	 * 
	 * @Title: selectRightListImage 
	 * @Description:     web--品生活--查询右侧列表上图片通过左侧对应的cuid
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月18日 下午1:16:13
	 */
	@RequestMapping(value="selectRightListImage")
	@ResponseBody
	public Map<String,Object> selectRightListImage(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----web--品生活--查询右侧列表上图片通过左侧对应的cuid");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，查询失败");
		}
		PinLife pinLife = new PinLife();
		pinLife.setPinLifeSmallListParentId(parameterBean.getPinLife().getPinLifeSmallListParentId());
		pinLife.setPinLifeType(EnumConfig.PIN_LIFE_TYPE_RIGHT_T.getIndex());
		List<PinLife> pinLifes = iPinLifeService.selectByAttribute(pinLife);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, pinLifes);
	}
	
	/**
	 * @Title: selectRightList 
	 * @Description:     web--品生活--获取右边列表
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午9:10:02
	 */
	@RequestMapping(value="selectRightList")
	@ResponseBody
	public Map<String,Object> selectRightList(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----web--品生活--查询右侧列表通过左侧对应的cuid");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，查询失败");
		}
		PinLife pinLife = new PinLife();
		pinLife.setPinLifeSmallListParentId(parameterBean.getPinLife().getPinLifeSmallListParentId());
		pinLife.setPinLifeType(EnumConfig.PIN_LIFE_TYPE_RIGHT.getIndex());
		List<PinLife> pinLifes = iPinLifeService.selectByAttribute(pinLife);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, pinLifes);
	}
	
	/**
	 * @Title: selectByPrimaryKey 
	 * @Description:     web--品生活--通过主键查询 
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午9:11:40
	 */
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Map<String,Object> selectByPrimaryKey(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----web--品生活--通过主键查询");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getPinLife()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，查询失败");
		}
		PinLife pinLife = iPinLifeService.selectByPrimaryKey(parameterBean.getPinLife().getPinLifeCuid());
		if(null == pinLife){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "没有查询到该数据，查询失败");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, pinLife);
	}
}
