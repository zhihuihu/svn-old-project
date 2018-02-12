package com.vieagr.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.Base64FileUtils;
import com.vieagr.distribution.base.util.PropertiesUtils;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SysUser;
import com.vieagr.distribution.service.inter.ISysUserService;

/**
 * 登录用户控制层
 * @author master
 *
 */
@RestController
@RequestMapping(value = "sysUser")
public class SysUserController {

	@Autowired
	private ISysUserService sysUserService;
	
	/**
	 * 增加一个系统用户
	 * @param jsonStr
	 * @return
	 * @throws Exception 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@RequestMapping(value="addOneSysUser",method=RequestMethod.POST)
	public Object addOneSysUser(String jsonStr) throws Exception{
		SysUser sysUser = Utils.jsonStrToObject(jsonStr, SysUser.class);
		return sysUserService.addOneSysUser(sysUser);
	}
	
	/**
	 * 系统用户列表查询
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="selectSysUserList",method=RequestMethod.POST)
	public Object selectSysUserList(String jsonStr) throws Exception{
		SysUser sysUser = Utils.jsonStrToObject(jsonStr, SysUser.class);
		return sysUserService.selectSysUserList(sysUser);
	}
	
	/**
	 * 系统用户--启用--禁用
	 * @Title: updateSysUserState 
	 * @Description:     
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月28日 下午2:49:53
	 */
	@RequestMapping(value="updateSysUserState",method=RequestMethod.POST)
	public Object updateSysUserState(String jsonStr) throws Exception{
		SysUser sysUser = Utils.jsonStrToObject(jsonStr, SysUser.class);
		SysUser sysUserCheck = sysUserService.selectByPrimaryKey(sysUser.getSysUserId());
		String msg = "";
		if(sysUserCheck.getSysUserState().equals(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex())){//如果是启用则禁用
			sysUser.setSysUserState(EnumConfig.SYSTEM_UNIFIED_STATE_END_USING.getIndex());
			msg = Constant.FORBIDDEN_USER_SUCCESS;
		}else{
			sysUser.setSysUserState(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex());
			msg = Constant.START_USER_SUCCESS;
		}
		sysUserService.updateByPrimaryKeySelective(sysUser);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, msg);
	}
	
	
	@RequestMapping(value="selectByPrimaryKey",method=RequestMethod.POST)
	public Object selectByPrimaryKey(String sysUserId) throws Exception{
		SysUser sysUser = sysUserService.selectByPrimaryKey(sysUserId);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, sysUser);
	}
	
	/**
	 * 更新用户信息
	 * @Title: updateSysUser 
	 * @Description:     
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月28日 下午4:56:38
	 */
	@RequestMapping(value="updateSysUser",method=RequestMethod.POST)
	public Object updateSysUser(String jsonStr) throws Exception{
		SysUser sysUser = Utils.jsonStrToObject(jsonStr, SysUser.class);
		/*if(sysUser.getSysUserName().trim().equals("")){
			return ReturnUtils.forNoraml("111111", "用户名格式错误，请重新填写");
		}*/
		if(!Utils.isMobile(sysUser.getSysUserMobileNumber())){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "手机号码格式错误，请重新填写");
		}
		if(null == sysUser.getSysUserPassword() || sysUser.getSysUserPassword().trim().length() < 6){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "密码格式错误，请重新填写");
		}
		sysUser.setSysUserImgUrl(Base64FileUtils.base64ToImageFile(sysUser.getSysUserImgUrl(), PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		int flg = sysUserService.updateByPrimaryKeySelective(sysUser);
		if(flg > 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, "用户信息修改成功");
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "用户信息修改失败，请重试");
	}
}
