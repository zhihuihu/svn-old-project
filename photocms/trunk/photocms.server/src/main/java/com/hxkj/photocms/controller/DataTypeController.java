package com.hxkj.photocms.controller;

import java.util.List;

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
import com.hxkj.photocms.service.impl.DataTypeService;

/** 
 * Project Name:photocms.server 
 * ClassName:DataTypeController
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午10:48:03 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="dataType")
public class DataTypeController {

	@Resource
	private DataTypeService dataTypeService;
	
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		DataType dataType = inBean.getDataType();
		dataType.setDataTypeCreateTime(TimeUtils.getMySqlFormatTime());
		dataType.setDataTypeTotalNumber(0);
		dataTypeService.doInsert(dataType);
		return PageBeanUtils.formatForNormalTrue("", dataType);
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value="getAll")
	@ResponseBody
	public Object getAll(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		List<DataType> dataTypes = dataTypeService.getAll();
		return PageBeanUtils.formatForNormalTrue("",dataTypes);
	}
	
	@RequestMapping(value="findByDataType")
	@ResponseBody
	public Object findByDataType(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		DataType dataType = inBean.getDataType();
		return dataTypeService.findByDataType(dataType);
	}
	
	
	@RequestMapping(value="findSpecialTypeByDataType")
	@ResponseBody
	public Object findSpecialTypeByDataType(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		DataType dataType = inBean.getDataType();
		return dataTypeService.findByDataType(dataType);
	}
	
}
