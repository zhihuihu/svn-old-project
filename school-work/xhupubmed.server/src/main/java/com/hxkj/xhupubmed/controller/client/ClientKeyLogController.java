package com.hxkj.xhupubmed.controller.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.ParameterUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.KeyLog;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.KeyLogService;

/** 
 * ClassName:ClientKeyLogController
 * Function:   用户信息反馈使用
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月8日 下午2:32:12 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/keyLog")
public class ClientKeyLogController {

	@Resource
	private KeyLogService keyLogService;
	
	/**
	 * 
	* @Function: 此方法作为用户意见反馈使用
	* @Title: doInsert  
	* @param request
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月13日 下午7:54:38
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		KeyLog keyLog = inBean.getKeyLog();
		keyLog.setKeyLogState(10);
		keyLog.setKeyLogCreateTime(TimeUtils.getMySqlFormatTime());
		keyLogService.doInsertSelective(keyLog);
		return PageBeanUtils.formatForNormalTrue("", "提交成功");
	}
}
