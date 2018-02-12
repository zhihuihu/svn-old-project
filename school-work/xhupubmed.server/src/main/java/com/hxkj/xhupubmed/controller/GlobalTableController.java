package com.hxkj.xhupubmed.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.service.impl.GlobalTableService;

/** 
 * ClassName:GlobalTableController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午4:33:11 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="globalTable")
public class GlobalTableController {

	@Resource
	private GlobalTableService globalTableService;
	
	@RequestMapping(value="doInsertTrans")
	@ResponseBody
	public Object doInsertTrans() throws Exception{
		globalTableService.doInsertTrans();
		return "";
	}
}
