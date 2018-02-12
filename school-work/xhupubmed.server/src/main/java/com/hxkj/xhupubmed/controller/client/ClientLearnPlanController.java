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
import com.hxkj.xhupubmed.entity.LearnPlan;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.LearnPlanService;

/** 
 * ClassName:ClientLearnPlanController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月7日 下午9:19:17 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/learnPlan")
public class ClientLearnPlanController {
	@Resource
	private LearnPlanService learnPlanService;
	
	/**
	 * 
	* @Function: 增加一条自定义任务信息
	* @Title: doInsert 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月7日 下午9:26:48
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
		LearnPlan learnPlan = inBean.getLearnPlan();
		learnPlan.setSysUserCuid(sysUser.getSysUserCuid());
		learnPlan.setLearnPlanState(1);
		learnPlan.setLearnPlanCreateTime(TimeUtils.getMySqlFormatTime());
		learnPlan.setLearnPlanUpdateTime(TimeUtils.getMySqlFormatTime());
		learnPlanService.doInsert(learnPlan);
		return PageBeanUtils.formatForNormalTrue("", "新增计划成功");
	}
	
	/**
	 * 
	* @Function: 删除用户的学习计划
	* @Title: doDeleteByPrimaryKey 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月7日 下午9:29:17
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		LearnPlan learnPlan = inBean.getLearnPlan();
		learnPlanService.doDeleteByPrimaryKey(learnPlan);
		return PageBeanUtils.formatForNormalTrue("", "删除计划成功");
	}
	
	/**
	 * 
	* @Function: 查看自己的任务
	* @Title: selectByAttributeAnd 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月7日 下午9:27:06
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		LearnPlan learnPlan = inBean.getLearnPlan();
		learnPlan.setSysUserCuid(sysUser.getSysUserCuid());
		PageBean<LearnPlan> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(learnPlan);
		pageBean.setOrderByString("ORDER BY LEARN_PLAN_START_TIME DESC");
		return learnPlanService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Function: 更新用户学习计划
	* @Title: doUpdata 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月12日 下午8:45:04
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doUpdata")
	@ResponseBody
	public Object doUpdata(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		LearnPlan learnPlan = inBean.getLearnPlan();
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		learnPlanService.doUpdateByPrimaryKeySelective(learnPlan);
		return PageBeanUtils.formatForNormalTrue("", "更新计划成功");
	}
	
	/**
	 * 
	* @Function: 通过任务cuid查询详情
	* @Title: selectByPrimaryKey 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月12日 下午10:16:45
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		LearnPlan learnPlan = inBean.getLearnPlan();
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		learnPlan = learnPlanService.selectByPrimaryKey(learnPlan);
		return PageBeanUtils.formatForNormalTrue("", learnPlan);
	}
	
	@RequestMapping(value="selectLearnPlanPush",method=RequestMethod.GET)
	@ResponseBody
	public Object selectLearnPlanPush(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		LearnPlan learnPlan = inBean.getLearnPlan();
		learnPlan.setSysUserCuid(sysUser.getSysUserCuid());
		PageBean<LearnPlan> pageBean = new PageBean<>(1, 1);
		pageBean.setInVo(learnPlan);
		pageBean.setStartTime(TimeUtils.getMySqlFormatTime());
		pageBean.setOrderByString("ORDER BY LEARN_PLAN_START_TIME ASC");
		return learnPlanService.selectByAttributeAnd(pageBean);
	}
}
