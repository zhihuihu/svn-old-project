package com.hxkj.xhupubmed.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.Chat;
import com.hxkj.xhupubmed.entity.Classroom;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.impl.ClassroomService;
import com.wordnik.swagger.annotations.ApiOperation;

/** 
 * ClassName:ClassroomController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午5:43:36 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="classroom")
public class ClassroomController {

	@Resource
	private ClassroomService classroomService;
	
	
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ApiOperation(value = "添加信息", httpMethod = "GET", response =Chat.class, notes = "add chat")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Classroom classroom = new Classroom();
		classroom.setClassroomName("软件考研");
		classroom.setClassroomNumber("6教");
		classroom.setClassroomRoomNumber("6A-302");
		classroom.setClassroomStudentNumber(1);
		classroom.setClassroomState(1);
		classroom.setClassroomCreateTime(TimeUtils.getMySqlFormatTime());
		classroomService.doInsert(classroom);
		return classroom;
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ApiOperation(value = "通过主键删除", httpMethod = "GET", response =PageBeanUtils.class, notes = "delete chat")
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Classroom classroom = new Classroom();
		classroom.setClassroomCuid("");
		classroomService.doDeleteByPrimaryKey(classroom);
		return classroom;
	}
	
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询AND查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select and chat")
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<Classroom> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new Classroom());
		return classroomService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="selectByAttributeOr",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询OR查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select or chat")
	@ResponseBody
	public Object selectByAttributeOr(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<Classroom> pageBean = new PageBean<>(1, 16);
		pageBean.setInVo(new Classroom());
		return classroomService.selectByAttributeOr(pageBean);
	}
}
