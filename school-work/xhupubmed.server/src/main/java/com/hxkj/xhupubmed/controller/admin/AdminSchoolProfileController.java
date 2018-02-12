package com.hxkj.xhupubmed.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SchoolProfile;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.SchoolProfileService;

/** 
 * ClassName:AdminSchoolProfileController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月4日 下午8:12:44 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="admin/schoolProfile")
public class AdminSchoolProfileController {

	@Resource
	private SchoolProfileService schoolProfileService;
	
	/**
	 * 
	* @Function: 新增一个学校的数据
	* @Title: doInsert  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月4日 下午8:18:09
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SchoolProfile schoolProfile = inBean.getSchoolProfile();
		schoolProfile.setSchoolProfileState(1);
		schoolProfile.setSchoolProfileCreateTime(TimeUtils.getMySqlFormatTime());
		schoolProfileService.doInsert(schoolProfile);
		return PageBeanUtils.formatForNormalTrue("", "增加成功");
	}
	
	
	/**
	 * 
	* @Function: 删除一个学校数据,通过主键删除
	* @Title: doDelete  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月4日 下午8:18:26
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doDelete")
	@ResponseBody
	public Object doDelete(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SchoolProfile schoolProfile = inBean.getSchoolProfile();
		int flg = schoolProfileService.doDeleteByPrimaryKey(schoolProfile);
		if(flg > 0){
			return PageBeanUtils.formatForNormalTrue("", "删除成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "删除失败,数据不存在");
	}
	
	/**
	 * 
	* @Function: 分页查询,admin
	* @Title: selectByAttributeAnd  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月4日 下午8:43:31
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttributeAnd")
	@ResponseBody
	public Object selectByAttributeAnd(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		PageBean<SchoolProfile> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(inBean.getSchoolProfile());
		pageBean.setSearchName(inBean.getSearchName());
		pageBean.setStartTime(inBean.getStartTime());
		pageBean.setEndTime(inBean.getEndTime());
		pageBean.setOrderByString("ORDER BY SCHOOL_PROFILE_CREATE_TIME DESC");
		return schoolProfileService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Function: 通过主键查询
	* @Title: selectByPrimaryKey  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月4日 下午8:45:55
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
	
	
	@RequestMapping(value="doUpdate")
	@ResponseBody
	public Object doUpdate(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SchoolProfile schoolProfile = inBean.getSchoolProfile();
		schoolProfile.setSchoolProfileUpdateTime(TimeUtils.getMySqlFormatTime());
		schoolProfileService.doUpdateByPrimaryKeySelective(schoolProfile);
		return PageBeanUtils.formatForNormalTrue("", "更新成功");
	}
}
