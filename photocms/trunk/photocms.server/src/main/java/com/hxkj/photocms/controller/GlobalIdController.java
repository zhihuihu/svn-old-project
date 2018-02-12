package com.hxkj.photocms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.photocms.core.utils.TimeUtils;
import com.hxkj.photocms.entity.GlobalId;
import com.hxkj.photocms.service.impl.GlobalIdService;

/** 
 * Project Name:photocms.server 
 * ClassName:GlobalIdController
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午5:22:09 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value = "globalId")
public class GlobalIdController {

	@Resource
	private GlobalIdService globalIdService;
	
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert() throws Exception{
		GlobalId globalId = new GlobalId();
		globalId.setGlobalTableName("GLOBAL_ID");
		globalId.setGlobalNotes("测试插入");
		globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
		globalIdService.doInsert(globalId);
		return globalId;
	}
}
