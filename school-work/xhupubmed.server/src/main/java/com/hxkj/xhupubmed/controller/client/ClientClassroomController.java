package com.hxkj.xhupubmed.controller.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.ParameterUtils;
import com.hxkj.xhupubmed.core.utils.RedisUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.Classroom;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.ClassroomService;

/** 
 * ClassName:ClientClassroomController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月7日 下午9:48:38 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/classroom")
public class ClientClassroomController {
	
	@Resource
	private ClassroomService classroomService;
	
	/**
	 * 
	* @Function: 执行考研教室的新增求约
	* @Title: doInsert 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月7日 下午9:57:28
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Classroom classroom = inBean.getClassroom();
		classroom.setSysUserCuid(sysUser.getSysUserCuid());
		classroom.setClassroomStudentNumber(1);
		classroom.setClassroomState(1);
		classroom.setClassroomUpdateTime(TimeUtils.getMySqlFormatTime());
		classroomService.doInsert(classroom);
		return PageBeanUtils.formatForNormalTrue("", classroom);
	}
	
	/**
	 * 
	* @Function: 通过主键删除考研教室
	* @Title: doDeleteByPrimaryKey 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月7日 下午9:57:47
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Classroom classroom = inBean.getClassroom();
		classroomService.doDeleteByPrimaryKey(classroom);
		return PageBeanUtils.formatForNormalTrue("", "删除成功");
	}
	
	/**
	 * 
	* @Function: 分页查询
	* @Title: selectByAttributeAnd 
	* @param @param request
	* @param @param response
	* @param @param dataInBean 分页的信息
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月7日 下午9:58:01
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Classroom classroom = inBean.getClassroom();
		PageBean<Classroom> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(classroom);
		pageBean.setOrderByString("ORDER BY CLASSROOM_CREATE_TIME DESC");
		return classroomService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Title: selectByPrimaryKey 
	* @Description: TODO    通过主键查询预约教室的详细信息
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午4:20:19
	 */
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Classroom classroom = inBean.getClassroom();
		classroom = classroomService.selectByPrimaryKey(classroom);
		return PageBeanUtils.formatForNormalTrue("", classroom);
	}

}
