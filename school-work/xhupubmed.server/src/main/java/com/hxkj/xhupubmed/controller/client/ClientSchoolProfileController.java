package com.hxkj.xhupubmed.controller.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SchoolProfile;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.SchoolProfileService;

/** 
 * ClassName:ClientSchoolProfileController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月4日 下午9:19:06 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/schoolProfile")
public class ClientSchoolProfileController {

	@Resource
	private SchoolProfileService schoolProfileService;
	
	/**
	 * 
	* @Function: 普通的单个条件查询
	* @Title: selectByAttributeAnd  
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月4日 下午9:20:36
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		PageBean<SchoolProfile> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(inBean.getSchoolProfile());
		pageBean.setSearchName(inBean.getSearchName());
		pageBean.setOrderByString("ORDER BY SCHOOL_PROFILE_CREATE_TIME DESC");
		return schoolProfileService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Function: 通过主键进行查询
	* @Title: selectByPrimaryKey  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月4日 下午9:22:12
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SchoolProfile schoolProfile = inBean.getSchoolProfile();
		schoolProfile = schoolProfileService.selectByPrimaryKey(schoolProfile);
		return PageBeanUtils.formatForNormalTrue("", schoolProfile);
	}
}
