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
import com.hxkj.xhupubmed.entity.Friend;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.FriendService;

/** 
 * ClassName:ClientFriendController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月13日 下午9:22:48 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/friend")
public class ClientFriendController {

	@Resource
	private FriendService friendService;
	
	/**
	 * 
	* @Function: 添加好友方法
	* @Title: doInsert 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月13日 下午9:29:24
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
		Friend selectFriend = new Friend();
		selectFriend.setSysUserCuid(sysUser.getSysUserCuid());
		selectFriend.setFriendRealCuid(inBean.getFriend().getFriendRealCuid());
		selectFriend = friendService.selectByAttribute(selectFriend);
		if(selectFriend != null){
			return PageBeanUtils.formatForNormalFalse("", "已经添加该好友不能重复添加");
		}
		Friend friend = inBean.getFriend();
		friend.setSysUserCuid(sysUser.getSysUserCuid());
		friend.setFriendAddTime(TimeUtils.getMySqlFormatTime());
		friend.setFriendState(1);
		friend.setFriendCreateTime(TimeUtils.getMySqlFormatTime());
		friendService.doInsert(friend);
		return PageBeanUtils.formatForNormalTrue("", "添加好友成功");
	}
	
	/**
	 * 
	* @Function: 删除好友 通过主键删除
	* @Title: doDeleteByPrimaryKey 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月13日 下午9:30:32
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Friend friend = inBean.getFriend();
		int flg = friendService.doDeleteByPrimaryKey(friend);
		if(flg == 0){
			return PageBeanUtils.formatForNormalFalse("", "删除失败,不是你的好友");
		}
		return PageBeanUtils.formatForNormalTrue("", "删除好友成功");
	}
	
	/**
	 * 
	* @Function: 通过主键查询friend表信息
	* @Title: selectByPrimaryKey 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月13日 下午9:33:01
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Friend friend = inBean.getFriend();
		friendService.selectByPrimaryKey(friend);
		return PageBeanUtils.formatForNormalTrue("", "删除好友成功");
	}
	
	/**
	 * 
	* @Function: 通过friend 的cuid进行数据查找
	* @Title: selectByfriendCuid  
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月13日 下午9:45:43
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByfriendCuid",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByfriendCuid(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Friend friend = inBean.getFriend();
		friend.setSysUserCuid(sysUser.getSysUserCuid());
		friend = friendService.selectByAttribute(friend);
		if(friend == null){
			return PageBeanUtils.formatForNormalTrue("", "没有添加该好友");
		}
		return PageBeanUtils.formatForNormalFalse("", friend);
	}
	
	/**
	 * 
	* @Title: selectFriendsByUserCuid 
	* @Description: TODO    通过用户的cuid查询用户的好友
	* @param request
	* @param response
	* @param dataInBean 必传分页的大小,当前页数
	* @param token 必传的参数,可以通过token得到用户的cuid
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午2:04:40
	 */
	@RequestMapping(value="selectFriendsByUserCuid",method=RequestMethod.GET)
	@ResponseBody
	public Object selectFriendsByUserCuid(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Friend friend = new Friend();
		friend.setSysUserCuid(sysUser.getSysUserCuid());
		PageBean<Friend> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(friend);
		return friendService.selectByAttributeAnd(pageBean);
	}
}
