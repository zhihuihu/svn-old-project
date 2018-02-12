package com.dy.weike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.Class;
import com.dy.weike.service.inter.IClassService;

@Controller
@RequestMapping(value="class")
public class ClassController {
	
	@Resource
	private IClassService iClassService;
	
	@RequestMapping(value="insert")
	@ResponseBody
	public Object insert(HttpServletRequest request,String token,String reportString){
		Class className = new Class();
		className.setClassCount(13);
		className.setClassDescription("课程描述");
		className.setClassEnd(TimeUtils.getMySqlFormatTime());
		className.setClassKeyword("计算机");
		className.setClassLiveness(32);
		className.setClassName("软件工程");
		className .setClassPerson(100);
		className.setClassStar(3);
		className.setClassStart(TimeUtils.getMySqlFormatTime());
		className.setClassState(1);
		className.setClassTag("1");
		iClassService.insert(className);
		return className;	
	}
	

}
