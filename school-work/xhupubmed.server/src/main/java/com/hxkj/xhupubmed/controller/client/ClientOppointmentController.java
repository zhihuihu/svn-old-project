package com.hxkj.xhupubmed.controller.client;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.ParameterUtils;
import com.hxkj.xhupubmed.core.utils.RedisUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.Classroom;
import com.hxkj.xhupubmed.entity.Oppointment;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.ClassroomService;
import com.hxkj.xhupubmed.service.impl.OppointmentService;

/**
 * 
* @ClassName: ClientOppointmentController 
* @Description: TODO 教室求约表的控制层
* @author huzhihui_c@qq.com
* @date 2016年4月14日 下午4:30:36 
*
 */
@Controller
@RequestMapping(value="client/oppointment")
public class ClientOppointmentController {

	@Resource
	private OppointmentService OppointmentService;
	@Resource
	private ClassroomService classroomService;
	
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Oppointment oppointment = inBean.getOppointment();
		oppointment.setSysUserCuid(sysUser.getSysUserCuid());
		List<Oppointment> oppointments = OppointmentService.selectByAttribute(oppointment);
		if(oppointments != null && oppointments.size() != 0){
			return PageBeanUtils.formatForNormalFalse("", "已结预约了该教室哦");
		}
		oppointment.setOppointmentCreateTime(TimeUtils.getMySqlFormatTime());
		oppointment.setOppointmentEndTime(TimeUtils.getMySqlFormatTime());
		oppointment.setOppointmentUserName(sysUser.getSysUserLoginName());
		oppointment.setOppointmentState(1);
		OppointmentService.doInsert(oppointment);
		Classroom classroom = new Classroom();
		classroom.setClassroomCuid(oppointment.getClassroomCuid());
		classroom = classroomService.selectByPrimaryKey(classroom);
		classroom.setClassroomStudentNumber(classroom.getClassroomStudentNumber() + 1);
		classroomService.doUpdateByPrimaryKeySelective(classroom);
		return PageBeanUtils.formatForNormalTrue("", "预约成功哦！");
	}
	
	
	/**
	 * 
	* @Function: 分页查询 预约的教室的人的详细的列表
	* @Title: selectByAttributeAnd  
	* @param request
	* @param response
	* @param dataInBean	oppointment中classroomCuid 必传
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月21日 下午8:57:55
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttributeAnd")
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		/*SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}*/
		Oppointment oppointment = inBean.getOppointment();
		PageBean<Oppointment> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(oppointment);
		return OppointmentService.selectByAttributeAnd(pageBean);
	}
	
	
	/**
	 * 
	* @Function: 预约详情的评论的增加或者更新
	* @Title: addOrUpdate  
	* @param request
	* @param response
	* @param dataInBean	oppointment中classroomCuid 必传 还有name
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月23日 下午3:07:04
	* @Since JDK 1.8
	 */
	@RequestMapping(value="addOrUpdate")
	@ResponseBody
	public Object addOrUpdate(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Oppointment oppointment = inBean.getOppointment();
		oppointment.setSysUserCuid(sysUser.getSysUserCuid());
		Oppointment oppointmentIn = new Oppointment();
		oppointmentIn.setClassroomCuid(oppointment.getClassroomCuid());
		oppointmentIn.setSysUserCuid(sysUser.getSysUserCuid());
		List<Oppointment> oppointments = OppointmentService.selectByAttribute(oppointmentIn);
		if(oppointments != null && oppointments.size() != 0){//已经预约了就直接更新评论即可
			String name = oppointment.getOppointmentName();//评论的内容
			oppointment = oppointments.get(0);
			oppointment.setOppointmentName(name);
			OppointmentService.doUpdateByPrimaryKeySelective(oppointment);
			return PageBeanUtils.formatForNormalTrue("", "评论成功！");
		}
		oppointment.setOppointmentCreateTime(TimeUtils.getMySqlFormatTime());
		oppointment.setOppointmentEndTime(TimeUtils.getMySqlFormatTime());
		oppointment.setOppointmentUserName(sysUser.getSysUserLoginName());
		oppointment.setOppointmentState(1);
		OppointmentService.doInsert(oppointment);
		Classroom classroom = new Classroom();
		classroom.setClassroomCuid(oppointment.getClassroomCuid());
		classroom = classroomService.selectByPrimaryKey(classroom);
		classroom.setClassroomStudentNumber(classroom.getClassroomStudentNumber() + 1);
		classroomService.doUpdateByPrimaryKeySelective(classroom);
		return PageBeanUtils.formatForNormalTrue("", "评论成功！");
	}
}
