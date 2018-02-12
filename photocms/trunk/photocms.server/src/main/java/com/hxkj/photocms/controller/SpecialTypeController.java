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
import com.hxkj.photocms.entity.DataType;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.SpecialType;
import com.hxkj.photocms.service.impl.SpecialTypeService;

/** 
 * Project Name:photocms.server 
 * ClassName:SpecialTypeController
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午11:08:33 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="specialType")
public class SpecialTypeController {

	@Resource 
	private SpecialTypeService specialTypeService;
	
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialType specialType = inBean.getSpecialType();
		specialType.setSpecialTypeTotalNumber(0);
		specialType.setSpecialTypeShow("1");
		specialType.setSpecialTypeCreateTime(TimeUtils.getMySqlFormatTime());
		specialTypeService.doInsert(specialType);
		return PageBeanUtils.formatForNormalTrue("", specialType);
	}
	
	@RequestMapping(value="getSpecialTypeByDataTypeCuid")
	@ResponseBody
	public Object getSpecialTypeByDataTypeCuid(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		DataType dataType = inBean.getDataType();
		SpecialType specialType = new SpecialType();
		specialType.setDataTypeCuid(dataType.getDataTypeCuid());
		int currentPage = inBean.getCurrentPage() == 0 ? 0 : inBean.getCurrentPage();
		int lineSize = inBean.getLineSize() == 0 ? 16 : inBean.getLineSize();
		PageBean<SpecialType> pageBean = new PageBean<>(currentPage, lineSize);
		pageBean.setInVo(specialType);
		return specialTypeService.getSpecialTypeByDataTypeCuid(pageBean);
	}
	
	@RequestMapping(value="doUpdate")
	@ResponseBody
	public Object doUpdate(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialType specialType = inBean.getSpecialType();
		specialTypeService.doUpdate(specialType);
		return PageBeanUtils.formatForNormalTrue("", specialType);
	}
	
	@RequestMapping(value="doDelete")
	@ResponseBody
	public Object doDelete(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialType specialType = inBean.getSpecialType();
		specialTypeService.doDelete(specialType);
		return PageBeanUtils.formatForNormalTrue("", "删除成功！");
	}
	
	@RequestMapping(value="getSpecialTypeByAttributeAnd")
	@ResponseBody
	public Object getSpecialTypeByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialType specialType = inBean.getSpecialType();
		int currentPage = inBean.getCurrentPage() == 0 ? 0 : inBean.getCurrentPage();
		int lineSize = inBean.getLineSize() == 0 ? 16 : inBean.getLineSize();
		PageBean<SpecialType> pageBean = new PageBean<>(currentPage, lineSize);
		pageBean.setInVo(specialType);
		return specialTypeService.getSpecialTypeByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="getSpecialTypeByAttributeOr")
	@ResponseBody
	public Object getSpecialTypeByAttributeOr(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialType specialType = inBean.getSpecialType();
		int currentPage = inBean.getCurrentPage() == 0 ? 0 : inBean.getCurrentPage();
		int lineSize = inBean.getLineSize() == 0 ? 16 : inBean.getLineSize();
		PageBean<SpecialType> pageBean = new PageBean<>(currentPage, lineSize);
		pageBean.setInVo(specialType);
		return specialTypeService.getSpecialTypeByAttributeOr(pageBean);
	}
}
