package com.hxkj.photocms.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.photocms.core.utils.TimeUtils;
import com.hxkj.photocms.entity.DataInBean;
import com.hxkj.photocms.entity.DataType;
import com.hxkj.photocms.entity.Special;
import com.hxkj.photocms.entity.SpecialContent;
import com.hxkj.photocms.entity.SpecialType;
import com.hxkj.photocms.entity.SysUser;
import com.hxkj.photocms.entity.UserType;
import com.hxkj.photocms.service.impl.UserTypeService;

/** 
 * Project Name:photocms.server 
 * ClassName:UserTypeController
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午9:20:39 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="userType")
public class UserTypeController {
	
	@Resource
	private UserTypeService userTypeService;
	
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert() throws Exception{
		UserType userType = new UserType();
		userType.setUserTypeName("照片");
		userType.setUserTypeCode("PHOTO");
		userType.setUserTypeCreateTime(TimeUtils.getMySqlFormatTime());
		userTypeService.doInsert(userType);
		return userType;
	}

	@RequestMapping(value="getDataInBean")
	@ResponseBody
	public Object getDataInBean() throws Exception{
		DataInBean dataInBean = new DataInBean();
		dataInBean.setDataType(new DataType());
		dataInBean.setSessionId("");
		dataInBean.setSpecial(new Special());
		dataInBean.setSpecialContent(new SpecialContent());
		dataInBean.setSpecialType(new SpecialType());
		dataInBean.setSysUser(new SysUser());
		return dataInBean;
	}
}
