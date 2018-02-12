package com.dy.weike.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.Exam;
import com.dy.weike.service.inter.IExamService;

@Controller
@RequestMapping(value="exam")
public class ExamController {
	@Resource
	private IExamService iExamService;
	
	@RequestMapping(value="insert")
	@ResponseBody
	public Object insert(HttpServletRequest request,String token,String examString){
		Exam exam = new Exam();
		exam.setClassId(2);
		exam.setExamAns("答案");
		exam.setExamCreatetime(TimeUtils.getMySqlFormatTime());
		exam.setExamName("题目");
		exam.setExamState(1);
		exam.setExamValue(3);
		iExamService.insert(exam);
		return exam;
	}
}
