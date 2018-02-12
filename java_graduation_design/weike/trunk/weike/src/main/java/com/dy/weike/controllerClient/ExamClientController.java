package com.dy.weike.controllerClient;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.PageBeanUtils;
import com.dy.weike.entity.Exam;
import com.dy.weike.service.inter.IExamService;


@Controller
@RequestMapping(value="client/exam")
public class ExamClientController {
	@Resource
	private IExamService iExamService;
	
	@RequestMapping(value="getExamInfo")
	@ResponseBody
	public Object getExamInfo(int classId){		
		Exam exam = new Exam();
		exam.setClassId(classId);
		Object examExist = iExamService.selectByAttribute(exam);
		if(examExist != null){
			return PageBeanUtils.formatForNormalTrue("", examExist);
		}
		return PageBeanUtils.formatForNormalFalse("", "还没有练习题库。");
	}

}
