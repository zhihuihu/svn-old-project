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
import com.hxkj.xhupubmed.entity.Follow;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.FollowService;

/** 
 * ClassName:ClientFollowController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月3日 下午1:21:55 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/follow")
public class ClientFollowController {

	@Resource
	private FollowService followService;
	
	
	/**
	 * 
	* @Function: 新增一个收藏
	* @Title: doInsert  
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月3日 下午1:26:00
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Follow follow = inBean.getFollow();
		Follow followIsExit = new Follow();
		followIsExit.setSysUserCuid(sysUser.getSysUserCuid());
		followIsExit.setFollowPostCuid(follow.getFollowPostCuid());
		followIsExit = followService.selectByAttribute(followIsExit);
		if(followIsExit!=null){
			return PageBeanUtils.formatForNormalFalse("", "已经收藏了该帖子");
		}
		follow.setSysUserCuid(sysUser.getSysUserCuid());
		follow.setFollowStartTime(TimeUtils.getMySqlFormatTime());
		follow.setFollowState(1);
		follow.setFollowCreateTime(TimeUtils.getMySqlFormatTime());
		followService.doInsert(follow);
		return PageBeanUtils.formatForNormalTrue("", "收藏成功");
	}
	
	/**
	 * 
	* @Function: 用户收藏分页查询
	* @Title: selectByAttributeAnd  
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月3日 下午1:52:02
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
		Follow follow = new Follow();
		follow.setSysUserCuid(sysUser.getSysUserCuid());
		PageBean<Follow> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(follow);
		pageBean.setOrderByString("ORDER BY FOLLOW_CREATE_TIME DESC");
		return followService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Follow follow = inBean.getFollow();
		int flg = followService.doDeleteByPrimaryKey(follow);
		if(flg == 0){
			return PageBeanUtils.formatForNormalFalse("", "该数据不存在,删除失败");
		}
		return PageBeanUtils.formatForNormalTrue("", "删除成功!");
	}
}
