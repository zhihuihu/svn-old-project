package com.hxkj.xhupubmed.controller.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.KeyUtils;
import com.hxkj.xhupubmed.core.utils.MailUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.ParameterUtils;
import com.hxkj.xhupubmed.core.utils.RedisUtils;
import com.hxkj.xhupubmed.entity.Chat;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.SysUserService;
import com.wordnik.swagger.annotations.ApiOperation;

/** 
 * ClassName:UserController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月12日 下午7:08:16 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/sysUser")
public class ClientSysUserController {
	
	@Resource
	private SysUserService sysUserService;
	
	
	@RequestMapping(value="normal/doLogin",method=RequestMethod.POST)
	@ApiOperation(value = "用户登录", httpMethod = "POST", response =Chat.class, notes = "add chat")
	@ResponseBody
	public Object doLogin(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = sysUserService.doLogin(inBean.getSysUser());
		if(sysUser != null){
			//sysUser.setSysUserPassword("");
			RedisUtils.save(KeyUtils.getToken(sysUser.getSysUserCuid()), sysUser, KeyUtils.TOKEN_TIME);
			return PageBeanUtils.formatForNormalTrue(KeyUtils.getToken(sysUser.getSysUserCuid()), sysUser);
		}else{
			return PageBeanUtils.formatForNormalFalse("", "用户名或密码错误");
		}
	}
	
	
	@RequestMapping(value="normal/doRegister",method=RequestMethod.POST)
	@ApiOperation(value = "用户注册", httpMethod = "POST", response =Chat.class, notes = "user register")
	@ResponseBody
	public Object doRegister(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = inBean.getSysUser();
		sysUserService.doRegister(sysUser);
		return PageBeanUtils.formatForNormalTrue("", sysUser);
	}

	
	@RequestMapping(value="normal/selectRepeatLoginName",method=RequestMethod.POST)
	@ApiOperation(value = "查询用户登录名重复", httpMethod = "POST", response =Chat.class, notes = "user register")
	@ResponseBody
	public Object selectRepeatLoginName(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = inBean.getSysUser();
		sysUser = sysUserService.selectByAttribute(sysUser);
		if(null != sysUser){
			throw new RuntimeException("登录名已经被注册");
		}
		return PageBeanUtils.formatForNormalTrue("", "可以注册");
	}
	
	@RequestMapping(value="normal/selectRepeatEmail",method=RequestMethod.POST)
	@ApiOperation(value = "查询用户邮箱重复", httpMethod = "POST", response =Chat.class, notes = "user register")
	@ResponseBody
	public Object selectRepeatEmail(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = inBean.getSysUser();
		sysUser = sysUserService.selectByAttribute(sysUser);
		if(null != sysUser){
			throw new RuntimeException("邮箱已经被注册");
		}
		return PageBeanUtils.formatForNormalTrue("", "可以注册");
	}
	
	@RequestMapping(value="normal/selectByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = inBean.getSysUser();
		sysUser = sysUserService.selectByPrimaryKey(sysUser);
		if(null != sysUser){
			throw new RuntimeException("查询失败");
		}
		return PageBeanUtils.formatForNormalTrue("", sysUser);
	}
	
	/**
	 * 
	* @Function: 用户查询其他用户或者好友的信息
	* @Title: selectUserInfoByPrimaryKey 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月13日 下午9:06:18
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectUserInfoByPrimaryKey",method=RequestMethod.POST)
	@ResponseBody
	public Object selectUserInfoByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = inBean.getSysUser();
		sysUser = sysUserService.selectByPrimaryKey(sysUser);
		return PageBeanUtils.formatForNormalTrue("", sysUser);
	}
	
	/**
	 * 
	* @Function: 更新用户的报考学校
	* @Title: updateSysUserFor 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月3日 下午1:41:43
	* @Since JDK 1.8
	 */
	@RequestMapping(value="updateSysUserFor",method=RequestMethod.POST)
	@ResponseBody
	public Object updateSysUserFor(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = inBean.getSysUser();
		int flg = sysUserService.doUpdateByPrimaryKeySelective(sysUser);
		if(flg == 0){
			return PageBeanUtils.formatForNormalFalse("", "考研学校更新失败!");
		}
		return PageBeanUtils.formatForNormalTrue("", sysUser);
	}
	
	
	/**
	 * 
	* @Function: 用户忘记密码用邮箱找回
	* @Title: forgetPassword 
	* @param @param request
	* @param @param response
	* @param @param dataInBean 必须有邮件这个属性
	* @param @param token
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月8日 下午9:57:19
	* @Since JDK 1.8
	 */
	@RequestMapping(value="forgetPasswordGetVerCode",method=RequestMethod.POST)
	@ResponseBody
	public Object forgetPasswordGetVerCode(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = inBean.getSysUser();
		sysUser= sysUserService.selectByAttribute(sysUser);//邮箱是必须的
		String verCode = KeyUtils.getVerCode();
		SysUser sysUserVerCode = new SysUser();
		sysUserVerCode.setSysUserEmail(sysUser.getSysUserEmail());
		sysUserVerCode.setSysUserVerCode(verCode);
		RedisUtils.save(KeyUtils.getToken("EMAIL" + sysUser.getSysUserCuid()), sysUserVerCode, KeyUtils.VER_CODE_TIME);
		MailUtils.sendVerCodeMail(sysUser.getSysUserEmail(), verCode);
		return PageBeanUtils.formatForNormalTrue(KeyUtils.getToken("EMAIL" + sysUser.getSysUserCuid()), "获取验证码成功");
	}
	
	/**
	 * 
	* @Function: 用户找回密码
	* @Title: forgetPasswordUpdataPassword 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @param token :作为认证使用
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月8日 下午10:42:14
	* @Since JDK 1.8
	 */
	@RequestMapping(value="forgetPasswordUpdataPassword",method=RequestMethod.POST)
	@ResponseBody
	public Object forgetPasswordUpdataPassword(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = inBean.getSysUser();//客户端输入的数据
		SysUser sysUserVerCode = RedisUtils.get(token, SysUser.class);
		if(!sysUser.getSysUserEmail().equals(sysUserVerCode.getSysUserEmail())){
			return PageBeanUtils.formatForNormalFalse("", "找回密码的邮箱两次输入不一样");
		}
		if(!sysUser.getSysUserVerCode().equals(sysUserVerCode.getSysUserVerCode())){
			return PageBeanUtils.formatForNormalFalse("", "验证码输入错误");
		}
		SysUser sysUserIn = new SysUser();
		sysUserIn.setSysUserEmail(sysUser.getSysUserEmail());
		sysUserIn = sysUserService.selectByAttribute(sysUserIn);
		sysUserIn.setSysUserPassword(sysUser.getSysUserPassword());
		int flg = sysUserService.doUpdateByPrimaryKeySelective(sysUserIn);
		if(flg == 0){
			return PageBeanUtils.formatForNormalFalse("", "密码更新失败!");
		}
		return PageBeanUtils.formatForNormalTrue("", "密码更新成功");
	}
	
	/**
	 * 
	* @Function: 用户更新头像
	* @Title: updateUserImage  
	* @param request
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月16日 下午8:35:01
	* @Since JDK 1.8
	 */
	@RequestMapping(value="updateUserImage")
	@ResponseBody
	public Object updateUserImage(HttpServletRequest request,String token) throws Exception{
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		return sysUserService.updateUserImage(request, sysUser.getSysUserCuid());
	}
	
	/**
	 * 
	* @Function: 刷新用户APP缓存
	* @Title: fleshUserData  
	* @param request
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月16日 下午8:59:56
	* @Since JDK 1.8
	 */
	@RequestMapping(value="fleshUserData")
	@ResponseBody
	public Object fleshUserData(HttpServletRequest request,String token) throws Exception{
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		sysUser = sysUserService.selectByPrimaryKey(sysUser);
		return PageBeanUtils.formatForNormalTrue("", sysUser);
	}
}
