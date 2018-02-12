package com.dy.weike.controllerClient;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.PageBeanUtils;
import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.Class;
import com.dy.weike.entity.UserClass;
import com.dy.weike.service.inter.IClassService;
import com.dy.weike.service.inter.IUserClassService;

@Controller
@RequestMapping(value="client/userClass")
public class UserClassClientController {
	
	@Resource
	private IUserClassService userClassService;
	@Resource
	private IClassService classService;
	
	@RequestMapping(value="joinClass")
	@ResponseBody
	public Object joinClass(int userId,int classId){
		UserClass userClass = new UserClass();
		userClass.setUserId(userId);
		userClass.setClassId(classId);		
		userClass.setStudyAttention(true);
		userClass.setUserClassCreatetime(TimeUtils.getMySqlFormatTime());
		userClassService.insertSelective(userClass);
		return PageBeanUtils.formatForNormalTrue("", "加入学习");
	}
	
	@RequestMapping(value="judgeJoin")
	@ResponseBody
	public Object judgeJoin(int userId,int classId){
		UserClass userClass = new UserClass();
		userClass.setClassId(classId);
		userClass.setUserId(userId);
		UserClass joinExist = userClassService.selectByPrimaryKey(userClass);
		if(joinExist != null){
			return PageBeanUtils.formatForNormalTrue("","已关注");			
		}
		return PageBeanUtils.formatForNormalFalse("", "没有关注");		
	}
	
	@RequestMapping(value="delJoinClass")
	@ResponseBody
	public Object delJoinClass(int userId, int classId){
		UserClass userClass = new UserClass();
		userClass.setClassId(classId);
		userClass.setUserId(userId);
		userClassService.deleteByPrimaryKey(userClass);		
		return PageBeanUtils.formatForNormalTrue("", "取消关注");
	}
	
	@RequestMapping(value="myClass")
	@ResponseBody
	public Object studyingClass(int userId){
		UserClass userClass = new UserClass();
		userClass.setUserId(userId);
		List<UserClass> myClassExist = (List<UserClass>) userClassService.selectByAttribute(userClass);			
		if(myClassExist != null){
			for(int i = 0; i < myClassExist.size();i++){
				Class classExist = new Class();
				int classId = myClassExist.get(i).getClassId();
				classExist.setClassId(classId);
				Class curClass = classService.selectByPrimaryKey(classExist);
				myClassExist.get(i).setClassInfo(curClass);
			}	
			return PageBeanUtils.formatForNormalTrue("", myClassExist);
		}
		return PageBeanUtils.formatForNormalFalse("","");		
	}
	
	
}
