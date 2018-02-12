package com.dy.weike.controllerClient;

import javax.annotation.Resource;
import javax.sound.midi.SysexMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.PageBeanUtils;
import com.dy.weike.entity.Class;
import com.dy.weike.entity.User;
import com.dy.weike.service.inter.IClassService;
import com.dy.weike.service.inter.IUserService;

@Controller
@RequestMapping(value="client/class")
public class ClassClientController {
	
	@Resource
	private IClassService iClassService;
	@Resource
	private IUserService iUserService;
	
	/**
	 * 课程获取
	 */
	@RequestMapping(value="allClass")
	@ResponseBody
	public Object allClass(){		
		Class classes = new Class();			
		Object classExist = iClassService.selectByAttribute(classes);		
		return PageBeanUtils.formatForNormalTrue("", classExist);
	}	

	
	/**
	 * 新课推荐	
	 */
	@RequestMapping(value="newClass")
	@ResponseBody
	public Object newClass(){		
		Class classes = new Class();			
		Object classExist = iClassService.selectByAttributeLimit(classes);		
		return PageBeanUtils.formatForNormalTrue("", classExist);
	}	
	
	/**
	 * 猜你喜欢
	 */
	@RequestMapping(value = "hobbyClass")
	@ResponseBody
	public Object hobbyClass(int userId){
		User user = new User();
		user.setUserId(userId);
		User userExist = iUserService.selectByPrimaryKey(user);
		if(userExist != null){
			String userHobby = userExist.getUserInterest();
			Class hobbyClass = new Class();
			hobbyClass.setClassTag(userHobby);
			Object classExist = iClassService.selectByHobby(hobbyClass);
			return PageBeanUtils.formatForNormalTrue("", classExist);			
		}
		return PageBeanUtils.formatForNormalFalse("", "没有设置爱好！");
	}
	
	@RequestMapping(value="typeClass")
	@ResponseBody
	/**
	 * 按类型查找课程
	 */
	public Object typeClass(String typeId){
		Class classes = new Class();
		classes.setClassTag(typeId);
		Object classExist = iClassService.selectByType(classes);
		if(classExist != null){
			return PageBeanUtils.formatForNormalTrue("", classExist);
		}
		return PageBeanUtils.formatForNormalFalse("", "该分类没有课程！");
	}	
	
	
	/**
	 * 关键词搜索
	 */
	@RequestMapping(value = "selectWord")
	@ResponseBody
	public Object selectWord(String selectWord){
		Class classes = new Class();
		classes.setClassName(selectWord);
		classes.setClassDescription(selectWord);
		classes.setClassKeyword(selectWord);
		Object classExist = iClassService.selectWord(classes);
		if(classExist != null){
			return PageBeanUtils.formatForNormalTrue("", classExist);
		}
		return PageBeanUtils.formatForNormalFalse("", "没有相关课程！");
	}
	
	
	/**
	 * 根据ClassId显示课程详情
	 */
	@RequestMapping(value="showClass")
	@ResponseBody
	public Object showClass(int classId){
		Class curClass = new Class();
		curClass.setClassId(classId);
		Class classExist = iClassService.selectByPrimaryKey(curClass);		
		return PageBeanUtils.formatForNormalTrue("", classExist);
	}	
	
	
	/**
	 * 动态更改课程状态
	 */
	@RequestMapping(value="changeClassState")
	@ResponseBody
	public Object changeClassState(int classId,int classState){
		Class curClass = new Class();
		curClass.setClassId(classId);
		Class changeClass = iClassService.selectByPrimaryKey(curClass);
		changeClass.setClassState(classState);
		//curClass.setClassState(classState);
		iClassService.updateByPrimaryKey(changeClass);
		return PageBeanUtils.formatForNormalTrue("",changeClass);		
	}

	
	/**
	 * 查询微课导师所属课程
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="tutorClass")
	@ResponseBody
	public Object tutorClass(int userId){
		Class curClass = new Class();
		curClass.setUserId(userId);
		Object tutorClass = iClassService.selectByAttribute(curClass);
		System.out.println("------!");
		System.out.println(tutorClass);
		System.out.println("------!");
		if(tutorClass != null){
			return PageBeanUtils.formatForNormalTrue("", tutorClass);
		}
		return PageBeanUtils.formatForNormalFalse("", "该导师没有课程！");		
	}	
}
