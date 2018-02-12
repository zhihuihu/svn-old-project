package com.dy.weike.controllerClient;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.PageBeanUtils;
import com.dy.weike.entity.ClassSession;
import com.dy.weike.service.inter.IClassSessionService;

@Controller
@RequestMapping(value="client/session")
public class SessionClientController {
	@Resource
	private IClassSessionService iClassSessionService;
	
	/**
	 * 课程所属的课时列表
	 * @param classId
	 * @return
	 */
	@RequestMapping(value="showSessionList")
	@ResponseBody
	public Object showSessionList(int classId){
		ClassSession sessiones = new ClassSession();
		sessiones.setClassId(classId);
		Object sessionList = iClassSessionService.selectByAttribute(sessiones);
		return PageBeanUtils.formatForNormalTrue("", sessionList);
	}
}
