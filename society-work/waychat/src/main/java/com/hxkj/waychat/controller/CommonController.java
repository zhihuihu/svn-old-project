package com.hxkj.waychat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	
	/**
	 * 主页
	 * @Title: index 
	 * @Description:     
	 * @return   
	 * @return String    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月12日 下午6:50:05
	 */
	@RequestMapping(value="index")
	public String index(){
		return "index";
	}
}
