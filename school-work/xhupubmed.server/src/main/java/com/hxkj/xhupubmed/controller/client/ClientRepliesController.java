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
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.Replies;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.RepliesService;

/** 
 * ClassName:ClientRepliesController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月5日 下午9:31:35 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/replies")
public class ClientRepliesController {

	@Resource
	private RepliesService repliesService;
	
	/**
	 * 
	* @Function:  增加一条帖子回复信息
	* @Title: doInsert 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月5日 下午9:36:07
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		Replies replies = inBean.getReplies();
		replies.setRepliesState(1);
		replies.setSysUserCuid(sysUser.getSysUserCuid());
		replies.setRepliesTitle("");
		replies.setRepliesTime(TimeUtils.getMySqlFormatTime());
		replies.setRepliesCreateTime(TimeUtils.getMySqlFormatTime());
		replies.setRepliesUpdateTime(TimeUtils.getMySqlFormatTime());
		repliesService.doInsert(replies);
		return PageBeanUtils.formatForNormalTrue("", replies);
	}
	
	/**
	 * 
	* @Function: 获取帖子的回复信息
	* @Title: selectByAttributeAnd 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月5日 下午9:39:16
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Replies replies = inBean.getReplies();//得到帖子CUID
		PageBean<Replies> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(replies);
		pageBean.setOrderByString("ORDER BY REPLIES_UPDATE_TIME DESC");
		return repliesService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Function: 用户查询自己的回复帖子列表
	* @Title: selectByAttributeAndForUser  
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 下午1:12:54
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttributeAndForUser",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAndForUser(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Replies replies = inBean.getReplies();//得到帖子CUID
		replies.setSysUserCuid(sysUser.getSysUserCuid());
		PageBean<Replies> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(replies);
		pageBean.setOrderByString("ORDER BY REPLIES_UPDATE_TIME DESC");
		return repliesService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Function: 删除帖子,用户自己删除
	* @Title: doDeleteByPrimaryKey  
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 下午1:14:38
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Replies replies = inBean.getReplies();//得到帖子CUID
		int flg = repliesService.doDeleteByPrimaryKey(replies);
		if(flg > 0){
			return PageBeanUtils.formatForNormalTrue("", "删除成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "删除失败,帖子不存在");
	}
	
	@RequestMapping(value="doInsertImages")
	@ResponseBody
	public Object doInsertImages(HttpServletRequest request,String repliesCuid) throws Exception{
		return repliesService.doInsertImages(request, repliesCuid);
	}
}
