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
import com.hxkj.xhupubmed.entity.IntelligentMessage;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.IntelligentMessageService;
/**
 * 
* @ClassName: ClientIntelligentMessageController 
* @Description: TODO 用户和机器人聊天的控制类
* @author huzhihui_c@qq.com
* @date 2016年4月14日 下午2:10:42 
*
 */
@Controller
@RequestMapping(value="client/intelligentMessage")
public class ClientIntelligentMessageController {

	@Resource
	private IntelligentMessageService intelligentMessageService;
	
	/**
	 * 
	* @Title: doInsert 
	* @Description: TODO    用户聊天信息增加,自己发送的消息,为 1,机器人回复为2
	* @param request
	* @param response
	* @param dataInBean  智能消息的content必要
	* @param token
	* @return
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午2:12:41
	 */
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		IntelligentMessage intelligentMessage = inBean.getIntelligentMessage();
		intelligentMessage.setSysUserCuid(sysUser.getSysUserCuid());//必要
		intelligentMessage.setIntelligentMessageDirection(1);//必要
		intelligentMessage.setIntelligentMessageState(4);//自己发的自动改为4 为已经读取的消息
		intelligentMessage.setIntelligentMessageCreateTime(TimeUtils.getMySqlFormatTime());//必要
		intelligentMessageService.doInsert(intelligentMessage);
		return PageBeanUtils.formatForNormalTrue("", intelligentMessage);
	}
	
	
	/**
	 * 
	* @Title: selectIntelligentMessageByUserCuid 
	* @Description: TODO    查询用户的消息
	* @param request
	* @param response
	* @param dataInBean 分页信息必有
	* @param token 必传
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:38:33
	 */
	@RequestMapping(value="selectIntelligentMessageByUserCuid")
	@ResponseBody
	public Object selectIntelligentMessageByUserCuid(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		IntelligentMessage intelligentMessage = inBean.getIntelligentMessage();
		intelligentMessage.setSysUserCuid(sysUser.getSysUserCuid());
		PageBean<IntelligentMessage> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(intelligentMessage);
		pageBean.setOrderByString("ORDER BY INTELLIGENT_MESSAGE_CREATE_TIME DESC");
		return intelligentMessageService.selectByAttributeAnd(pageBean);
	}
	
	
	/**
	 * 
	* @Title: selectIntelligentMessageByUserCuid 
	* @Description: TODO    查询用户的消息 用该方法
	* @param request
	* @param response
	* @param dataInBean 分页信息必有    需要传入查询的state
	* @param token 必传
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:38:33
	 */
	@RequestMapping(value="selectListByInitTask")
	@ResponseBody
	public Object selectListByInitTask(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		IntelligentMessage intelligentMessage = inBean.getIntelligentMessage();//需要传入查询的state
		intelligentMessage.setSysUserCuid(sysUser.getSysUserCuid());
		List<IntelligentMessage> intelligentMessages = intelligentMessageService.selectListByInitTask(intelligentMessage);
		return PageBeanUtils.formatForNormalTrue("", intelligentMessages);
	}
}
