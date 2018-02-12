package com.hxkj.xhupubmed.controller.client;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SchoolInformation;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.SchoolInformationService;

/** 
 * ClassName:ClientSchoolInformationController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月5日 上午9:49:37 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/schoolInformation")
public class ClientSchoolInformationController {

	@Resource
	private SchoolInformationService schoolInformationService;
	
	
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
		pageBean.setSearchName2(inBean.getSearchName2());
		pageBean.setSearchName3(inBean.getSearchName3());
		pageBean.setOrderByString("ORDER BY SCHOOL_INFORMATION_CREATE_TIME DESC");
		return schoolInformationService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SchoolInformation schoolInformation = inBean.getSchoolInformation();
		schoolInformation = schoolInformationService.selectByPrimaryKey(schoolInformation);
		return PageBeanUtils.formatForNormalTrue("", schoolInformation);
	}
	
	
}
