package com.hxkj.xhupubmed.controller.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.PropertiesUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;

/**
 * ClassName:ClientBaseController Function:
 * 
 * @author huzhihui_c@qq.com Date: 2016年5月24日 下午11:26:58
 * @version 1.0
 * @since JDK 1.8
 */
@Controller
@RequestMapping(value = "client/base")
public class ClientBaseController {
	
	

	/**
	 * 
	* @Function: 得到考研倒计时
	* @Title: getPubmedTime  
	* @return   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月24日 下午11:31:18
	* @Since JDK 1.8
	 */
	@RequestMapping(value = "getPubmedTime")
	@ResponseBody
	public Object getPubmedTime() {
		Date earlydate = new Date();
		Date latedate = new Date();
		DateFormat df = DateFormat.getDateInstance();
		try {
			earlydate = df.parse(TimeUtils.getMySqlFormatTime().substring(0, 10));
			latedate = df.parse(PropertiesUtils.getPropertiesValue("PUBMED_DATA"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int days = TimeUtils.daysBetween(earlydate, latedate);
		return PageBeanUtils.formatForNormalTrue("", days);
	}
	
	/**
	 * 
	* @Function: 取得欢迎语
	* @Title: getPubmedIndexWelcome  
	* @return   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月24日 下午11:32:26
	* @Since JDK 1.8
	 */
	@RequestMapping(value = "getPubmedIndexWelcome")
	@ResponseBody
	public Object getPubmedIndexWelcome() {
		return PageBeanUtils.formatForNormalTrue("", PropertiesUtils.getPropertiesValue("INDEX_WELCOME"));
	}
	
	/**
	 * 
	* @Function: 得到首页基本信息
	* @Title: getPubmedBaseInfo  
	* @return   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月24日 下午11:35:13
	* @Since JDK 1.8
	 */
	@RequestMapping(value = "getPubmedBaseInfo")
	@ResponseBody
	public Object getPubmedBaseInfo() {
		Map<String, Object> map = new HashMap<>();
		Date earlydate = new Date();
		Date latedate = new Date();
		DateFormat df = DateFormat.getDateInstance();
		try {
			earlydate = df.parse(TimeUtils.getMySqlFormatTime().substring(0, 10));
			latedate = df.parse(PropertiesUtils.getPropertiesValue("PUBMED_DATA"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int days = TimeUtils.daysBetween(earlydate, latedate);
		map.put("betweenDays", days);
		map.put("welcomeText", PropertiesUtils.getPropertiesValue("INDEX_WELCOME"));
		return PageBeanUtils.formatForNormalTrue("", map);
	}
}
