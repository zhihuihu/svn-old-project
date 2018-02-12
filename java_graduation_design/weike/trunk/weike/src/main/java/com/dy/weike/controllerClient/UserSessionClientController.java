package com.dy.weike.controllerClient;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.PageBeanUtils;
import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.Class;
import com.dy.weike.entity.ClassSession;
import com.dy.weike.entity.UserSession;
import com.dy.weike.service.inter.IClassService;
import com.dy.weike.service.inter.IClassSessionService;
import com.dy.weike.service.inter.IUserSessionService;

@Controller
@RequestMapping(value = "client/userSession")
public class UserSessionClientController {
	
	@Resource
	private IUserSessionService userSessionService;
	@Resource
	private IClassService classService;
	@Resource
	private IClassSessionService classSessionService;	
	
	@RequestMapping(value = "userSessionExist")
	@ResponseBody
	public Object userSessionExist(int classId, int userId, int sessionId){
		UserSession userSession = new UserSession();
		userSession.setClassId(classId);
		userSession.setUserId(userId);
		userSession.setSessionId(sessionId);
		Object userSessionExist = userSessionService.selectByPrimaryKey(userSession);
		if(userSessionExist == null){
			userSession.setPlanType(-1);
			userSession.setSessionState(1);
			userSession.setUserSessionEndtime(TimeUtils.getMySqlFormatTime());
			userSessionService.insert(userSession);	
			return PageBeanUtils.formatForNormalTrue("", "完成学习");
		}
		return PageBeanUtils.formatForNormalFalse("", "已经学习过");		
	}
	
	@RequestMapping(value = "delUserSession")
	@ResponseBody
	public Object delUserSession(int classId,int userId){
		UserSession userSession = new UserSession();
		userSession.setClassId(classId);
		userSession.setUserId(userId);
		userSessionService.deleteByAttribute(userSession);
		return PageBeanUtils.formatForNormalTrue("", "user-session删除成功!");
	}
	
	@RequestMapping(value = "insertUserSessionDay")
	@ResponseBody	
	public Object insertUserSessionDay(int sessionId, int classId, int userId, int planType,String sessionPlanTime){
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		userSession.setClassId(classId);
		userSession.setUserId(userId);
		userSession.setSessionState(0);
		userSession.setUserSessionCreatetime(TimeUtils.getMySqlFormatTime());
		userSession.setUserSessionPlantime(sessionPlanTime);
		userSession.setPlanType(planType);
		userSessionService.insert(userSession);
		return PageBeanUtils.formatForNormalTrue("", "user-session插入成功！");
	}
	
	@RequestMapping(value = "insertUserSessionWeek")
	@ResponseBody
	public Object insertUserSessionWeek(int sessionId, int classId, int userId, int planType){
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		userSession.setClassId(classId);
		userSession.setUserId(userId);
		userSession.setSessionState(0);
		userSession.setUserSessionCreatetime(TimeUtils.getMySqlFormatTime());
		userSession.setPlanType(planType);
		userSessionService.insert(userSession);
		return PageBeanUtils.formatForNormalTrue("", "周计划成功！");
	}
	
	@RequestMapping(value = "insertUserSessionMon")
	@ResponseBody
	public Object insertUserSessionMon(int sessionId, int classId, int userId, int planType, String sessionPlanTime ){
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		userSession.setClassId(classId);
		userSession.setUserId(userId);
		userSession.setSessionState(0);
		userSession.setUserSessionCreatetime(TimeUtils.getMySqlFormatTime());
		userSession.setUserSessionPlantime(sessionPlanTime);
		userSession.setPlanType(planType);
		userSessionService.insert(userSession);
		return PageBeanUtils.formatForNormalTrue("", "月计划成功！");
	}
	
	@RequestMapping(value = "insertUserSessionSelf")
	@ResponseBody
	public Object insertUserSessionSelf(int sessionId, int classId, int userId, int planType){
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		userSession.setClassId(classId);
		userSession.setUserId(userId);
		userSession.setSessionState(0);
		userSession.setUserSessionCreatetime(TimeUtils.getMySqlFormatTime());
		userSession.setPlanType(planType);
		userSessionService.insert(userSession);
		return PageBeanUtils.formatForNormalTrue("", "自主学习成功！");
	}
	
	@RequestMapping(value = "selectBySessionId")
	@ResponseBody
	public Object selectBySessionId(int sessionId){
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		Object userSessionExist = userSessionService.selectByAttribute(userSession);
		if(userSessionExist != null){
			return PageBeanUtils.formatForNormalTrue("", userSessionExist);
		}
		return PageBeanUtils.formatForNormalFalse("", "该课时不存在！");	
	}
	
	@RequestMapping(value = "updateSessionState")
	@ResponseBody
	public Object updateSessionState(int sessionId){
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		UserSession userSessionExist = userSessionService.selectBySessionId(userSession);
		userSessionExist.setSessionState(1);
		userSessionExist.setUserSessionEndtime(TimeUtils.getMySqlFormatTime());
		userSessionService.updateByPrimaryKeySelective(userSessionExist);
		return PageBeanUtils.formatForNormalTrue("", "课时学习完成！");
	}
	
	@RequestMapping(value = "selectSessionByUserId")
	@ResponseBody
	public Object selectSessionByUserId(int userId){
		UserSession userSession = new UserSession();
		userSession.setUserId(userId);
		Object userSessionExist = userSessionService.selectByAttribute(userSession);
		if(userSessionExist != null){
			System.out.println("--------------userSessionExist");
			System.out.println(userSessionExist);
			return PageBeanUtils.formatForNormalTrue("", userSessionExist);
		}
		return PageBeanUtils.formatForNormalFalse("", "没有学习");
	}	
	
	@RequestMapping(value = "getDaySession")
	@ResponseBody
	public Object getDaySession(int userId, int planType,String planTime){
		UserSession userSession = new UserSession();
		userSession.setUserId(userId);
		userSession.setPlanType(planType);
		userSession.setUserSessionPlantime(planTime);
		List<UserSession> userSessionExist = (List<UserSession>) userSessionService.selectDaySession(userSession);
		if(userSessionExist != null){
			for(int i = 0; i < userSessionExist.size(); i++){
				Class classExist = new Class();
				classExist.setClassId(userSessionExist.get(i).getClassId());
				Class curClass = classService.selectByPrimaryKey(classExist);				
				userSessionExist.get(i).setClassInfo(curClass);	
				
				ClassSession classSessinExist = new ClassSession();
				classSessinExist.setSessionId(userSessionExist.get(i).getSessionId());
				ClassSession curSession = classSessionService.selectByPrimaryKey(classSessinExist);
				userSessionExist.get(i).setClassSessionInfo(curSession);				
			}
			return PageBeanUtils.formatForNormalTrue("", userSessionExist);
		}
		return PageBeanUtils.formatForNormalFalse("","今日没有计划");
	}
	
	@RequestMapping(value = "getWeekSession")
	@ResponseBody
	public Object getWeekSession(int userId, int planType){
		UserSession userSession = new UserSession();
		userSession.setUserId(userId);
		userSession.setPlanType(planType);
		List<UserSession> userSessionExist = (List<UserSession>) userSessionService.selectWeekSession(userSession);
		if(userSessionExist != null){
			for(int i = 0; i < userSessionExist.size(); i++){
				Class classExist = new Class();
				classExist.setClassId(userSessionExist.get(i).getClassId());
				Class curClass = classService.selectByPrimaryKey(classExist);
				userSessionExist.get(i).setClassInfo(curClass);
			}
			return PageBeanUtils.formatForNormalTrue("", userSessionExist);
		}
		return PageBeanUtils.formatForNormalFalse("","没有周计划");		
	}
	
	@RequestMapping(value = "getMonSession")
	@ResponseBody
	public Object getMonSession(int userId, int planType){
		UserSession userSession = new UserSession();
		userSession.setUserId(userId);
		userSession.setPlanType(planType);
		List<UserSession> userSessionExist = (List<UserSession>) userSessionService.selectMonSession(userSession);
		if(userSessionExist != null){
			for(int i = 0; i < userSessionExist.size(); i++){
				Class classExist = new Class();
				classExist.setClassId(userSessionExist.get(i).getClassId());
				Class curClass = classService.selectByPrimaryKey(classExist);
				userSessionExist.get(i).setClassInfo(curClass);
			}
			return PageBeanUtils.formatForNormalTrue("", userSessionExist);
		}
		return PageBeanUtils.formatForNormalFalse("","没有月计划");		
	}
	
	
	
	
	
	@RequestMapping(value = "insertUserSession")
	@ResponseBody
	public Object insertUserSession(int sessionId,int userId,int classId,String planTime){
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		userSession.setUserId(userId);	
		userSession.setClassId(classId);
		UserSession userSessionExist = userSessionService.selectByPrimaryKey(userSession);
		if(userSessionExist == null){
			userSession.setSessionState(1);
			userSession.setUserSessionCreatetime(TimeUtils.getMySqlFormatTime());
			userSessionService.insert(userSession);
			return PageBeanUtils.formatForNormalTrue("", "现在学习此课时");
		}
		return PageBeanUtils.formatForNormalTrue("", "以前学过此课时");
	}
	
	@RequestMapping(value = "curUserSession")
	@ResponseBody
	public Object curUserSession(int sessionId,int userId){
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		userSession.setUserId(userId);	
		UserSession userSessionExist = userSessionService.selectByPrimaryKey(userSession);
		if(userSessionExist != null){
			return PageBeanUtils.formatForNormalTrue("","这个课时已经学习！");			
		}
		return PageBeanUtils.formatForNormalTrue("","不存在对该课时的学习");
	}	
}
