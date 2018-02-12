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
import com.hxkj.totops.entity.MingPinHui;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.inter.IMingPinHuiService;

/**
 * @ClassName: WebMingPinHuiController 
 * @Description: web端--名品汇控制器
 * @author huzhihui_c@qq.com
 * @date 2016年8月31日 上午11:36:47
 */
@Controller
@RequestMapping(value="web/mingPinHui")
public class WebMingPinHuiController {

	private static final Logger logger = LoggerFactory.getLogger(WebMingPinHuiController.class);
	
	@Autowired
	private IMingPinHuiService iMingPinHuiService;
	
	/**
	 * @Title: selectAllList 
	 * @Description:     名品汇--查询所有列表
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午11:37:30
	 */
	@RequestMapping(value="selectAllList")
	@ResponseBody
	public Map<String,Object> selectAllList() throws Exception{
		logger.info("-----名品汇--查询所有列表");
		MingPinHui mingPinHui = new MingPinHui();
		mingPinHui.setMingPinHuiType(EnumConfig.MING_PIN_HUI_TYPE_ONE.getIndex());
		List<MingPinHui> mingPinHuis = iMingPinHuiService.selectByAttribute(mingPinHui);
		for(int i=0;i<mingPinHuis.size();i++){
			mingPinHuis.get(i).setMingPinHuiContent(null);
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, mingPinHuis);
	}
	
	/**
	 * @Title: selectByPrimaryKey 
	 * @Description:     名品汇--查询单个详情
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午11:41:32
	 */
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Map<String,Object> selectByPrimaryKey(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----名品汇--查询单个详情");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getMingPinHui()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，查询失败");
		}
		MingPinHui mingPinHui = iMingPinHuiService.selectByPrimaryKey(parameterBean.getMingPinHui().getMingPinHuiCuid());
		if(null == mingPinHui){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "没有查询到该数据，查询失败");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, mingPinHui);
	}
	
}
