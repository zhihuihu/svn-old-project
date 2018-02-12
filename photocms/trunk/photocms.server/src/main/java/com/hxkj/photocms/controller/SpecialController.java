package com.hxkj.photocms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.photocms.core.utils.PageBeanUtils;
import com.hxkj.photocms.core.utils.ParameterUtils;
import com.hxkj.photocms.core.utils.TimeUtils;
import com.hxkj.photocms.entity.DataInBean;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.Special;
import com.hxkj.photocms.entity.SpecialType;
import com.hxkj.photocms.service.impl.SpecialService;

/** 
 * Project Name:photocms.server 
 * ClassName:SpecialController
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午11:38:17 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="special")
public class SpecialController {

	@Resource
	private SpecialService specialService;
	
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		Special special = inBean.getSpecial();
		special.setSpecialTotalNumber(0);
		special.setSpecialShow("1");
		special.setSpecialCreateTime(TimeUtils.getMySqlFormatTime());
		special.setSpecialUpdataTime(TimeUtils.getMySqlFormatTime());
		specialService.doInsert(special);
		return PageBeanUtils.formatForNormalTrue("", special);
	}
	
	@RequestMapping(value="doUpdate")
	@ResponseBody
	public Object doUpdate(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		Special special = inBean.getSpecial();
		specialService.doUpdate(special);
		return PageBeanUtils.formatForNormalTrue("", special);
	}
	
	@RequestMapping(value="doDelete")
	@ResponseBody
	public Object doDelete(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		Special special = inBean.getSpecial();
		specialService.doDelete(special);
		return PageBeanUtils.formatForNormalTrue("", special);
	}
	
	@RequestMapping(value="getSpecialBySpecialType")
	@ResponseBody
	public Object getSpecialBySpecialType(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialType specialType = inBean.getSpecialType();
		Special special = new Special();
		special.setSpecialTypeCuid(specialType.getSpecialTypeCuid());
		int currentPage = inBean.getCurrentPage() == 0 ? 0 : inBean.getCurrentPage();
		int lineSize = inBean.getLineSize() == 0 ? 16 : inBean.getLineSize();
		PageBean<Special> pageBean = new PageBean<>(currentPage, lineSize);
		pageBean.setInVo(special);
		return specialService.getSpecialBySpecialType(pageBean);
	}
	
	@RequestMapping(value="getSpecialByAttributeAnd")
	@ResponseBody
	public Object getSpecialByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		Special special = inBean.getSpecial();
		int currentPage = inBean.getCurrentPage() == 0 ? 0 : inBean.getCurrentPage();
		int lineSize = inBean.getLineSize() == 0 ? 16 : inBean.getLineSize();
		PageBean<Special> pageBean = new PageBean<>(currentPage, lineSize);
		pageBean.setInVo(special);
		return specialService.getSpecialByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="getSpecialByAttributeOr")
	@ResponseBody
	public Object getSpecialByAttributeOr(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		Special special = inBean.getSpecial();
		int currentPage = inBean.getCurrentPage() == 0 ? 0 : inBean.getCurrentPage();
		int lineSize = inBean.getLineSize() == 0 ? 16 : inBean.getLineSize();
		PageBean<Special> pageBean = new PageBean<>(currentPage, lineSize);
		pageBean.setInVo(special);
		return specialService.getSpecialByAttributeOr(pageBean);
	}
}
