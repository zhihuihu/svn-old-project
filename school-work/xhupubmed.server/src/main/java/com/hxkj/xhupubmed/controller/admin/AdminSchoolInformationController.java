package com.hxkj.xhupubmed.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SchoolInformation;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.SchoolInformationService;

/** 
 * ClassName:AdminSchoolInformationController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月4日 下午10:10:13 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="admin/schoolInformation")
public class AdminSchoolInformationController {

	@Resource
	private SchoolInformationService schoolInformationService;
	
	
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SchoolInformation schoolInformation = inBean.getSchoolInformation();
		schoolInformation.setSchoolInformationType(1);//通用类型设置
		schoolInformation.setSchoolInformationState(1);
		schoolInformation.setSchoolInformationCreateTime(TimeUtils.getMySqlFormatTime());
		schoolInformation.setSchoolInformationUpdateTime(TimeUtils.getMySqlFormatTime());
		schoolInformationService.doInsert(schoolInformation);
		return PageBeanUtils.formatForNormalTrue("", "增加信息成功");
	}
	
	/**
	 * 
	* @Function: 通过属性分页查询
	* @Title: selectByAttributeAnd  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月4日 下午10:20:20
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttributeAnd")
	@ResponseBody
	public Object selectByAttributeAnd(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SchoolInformation schoolInformation = inBean.getSchoolInformation();
		PageBean<SchoolInformation> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(schoolInformation);
		pageBean.setStartTime(inBean.getStartTime());
		pageBean.setEndTime(inBean.getEndTime());
		pageBean.setSearchName(inBean.getSearchName());
		pageBean.setOrderByString("ORDER BY SCHOOL_INFORMATION_CREATE_TIME DESC");
		return schoolInformationService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Function: 通过主键查询详情
	* @Title: selectByPrimaryKey  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 上午9:29:12
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SchoolInformation schoolInformation = inBean.getSchoolInformation();
		schoolInformation = schoolInformationService.selectByPrimaryKey(schoolInformation);
		return PageBeanUtils.formatForNormalTrue("", schoolInformation);
	}
	
	/**
	 * 
	* @Function: 更新方法
	* @Title: doUpdate  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月21日 下午7:48:20
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doUpdate")
	@ResponseBody
	public Object doUpdate(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SchoolInformation schoolInformation = inBean.getSchoolInformation();
		schoolInformation.setSchoolInformationUpdateTime(TimeUtils.getMySqlFormatTime());
		schoolInformationService.doUpdateByPrimaryKeySelective(schoolInformation);
		return PageBeanUtils.formatForNormalTrue("", "更新成功");
	}
}
