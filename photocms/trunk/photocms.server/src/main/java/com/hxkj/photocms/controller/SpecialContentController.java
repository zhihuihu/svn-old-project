package com.hxkj.photocms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.photocms.core.utils.FileUtils;
import com.hxkj.photocms.core.utils.PageBeanUtils;
import com.hxkj.photocms.core.utils.ParameterUtils;
import com.hxkj.photocms.core.utils.TimeUtils;
import com.hxkj.photocms.entity.DataInBean;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.Special;
import com.hxkj.photocms.entity.SpecialContent;
import com.hxkj.photocms.entity.SpecialType;
import com.hxkj.photocms.service.impl.SpecialContentService;

/** 
 * Project Name:photocms.server 
 * ClassName:SpecialContentController
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 下午12:04:34 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="specialContent")
public class SpecialContentController {

	@Resource
	private SpecialContentService specialContentService;
	
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialContent specialContent = inBean.getSpecialContent();
		specialContent.setSpecialContentAuthor("胡志辉");
		specialContent.setSpecialContentCreateTime(TimeUtils.getMySqlFormatTime());
		specialContentService.doInsert(specialContent);
		return specialContent;
	}
	
	@RequestMapping(value="doUpdate")
	@ResponseBody
	public Object doUpdate(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialContent specialContent = inBean.getSpecialContent();
		specialContentService.doUpdate(specialContent);
		return PageBeanUtils.formatForNormalTrue("", specialContent);
	}
	
	
	@RequestMapping(value="doUpdateSpecialMainUrl")
	@ResponseBody
	public Object doUpdateSpecialMainUrl(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialContent specialContent = inBean.getSpecialContent();
		specialContentService.doUpdate(specialContent);
		return PageBeanUtils.formatForNormalTrue("", specialContent);
	}
	
	@RequestMapping(value="doDelete")
	@ResponseBody
	public Object doDelete(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialContent specialContent = inBean.getSpecialContent();
		specialContentService.doUpdate(specialContent);
		return PageBeanUtils.formatForNormalTrue("", specialContent);
	}
	
	@RequestMapping(value="doDeleteList")
	@ResponseBody
	public Object doDeleteList(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		List<SpecialContent> specialContents = inBean.getSpecialContents();
		specialContentService.doUpdataList(specialContents);
		return PageBeanUtils.formatForNormalTrue("", "删除成功");
	}
	
	@RequestMapping(value="getSpecialContentBySpecial")
	@ResponseBody
	public Object getSpecialContentBySpecial(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		Special special = inBean.getSpecial();
		SpecialContent specialContent = new SpecialContent();
		specialContent.setSpecialCuid(special.getSpecialCuid());
		int currentPage = inBean.getCurrentPage() == 0 ? 0 : inBean.getCurrentPage();
		int lineSize = inBean.getLineSize() == 0 ? 16 : inBean.getLineSize();
		PageBean<SpecialContent> pageBean = new PageBean<>(currentPage, lineSize);
		pageBean.setInVo(specialContent);
		return specialContentService.getSpecialContentBySpecial(pageBean);
	}
	
	@RequestMapping(value="doInsertPhotos")
	@ResponseBody
	public Object doInsertPhotos(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		dataInBean = dataInBean.replaceAll("\\\\", "\"");
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		SpecialContent specialContent = inBean.getSpecialContent();
		SpecialType specialType = inBean.getSpecialType();
		Special special = inBean.getSpecial();
		String filePath = FileUtils.uploadImages(request, specialType, special);
		if(specialContent == null){
			specialContent = new SpecialContent();
		}
		specialContent.setSpecialContentShow("1");
		specialContent.setSpecialCuid(special.getSpecialCuid());
		specialContent.setSpecialContentMainUrl(filePath);
		specialContent.setSpecialContentCreateTime(TimeUtils.getMySqlFormatTime());
		specialContentService.doInsert(specialContent);
		return PageBeanUtils.formatForNormalTrue("", "文件上传成功！");
	}
	
	@RequestMapping(value="getSpecialContentByAttributeAnd")
	@ResponseBody
	public Object getSpecialContentByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialContent specialContent = inBean.getSpecialContent();
		int currentPage = inBean.getCurrentPage() == 0 ? 0 : inBean.getCurrentPage();
		int lineSize = inBean.getLineSize() == 0 ? 16 : inBean.getLineSize();
		PageBean<SpecialContent> pageBean = new PageBean<>(currentPage, lineSize);
		pageBean.setInVo(specialContent);
		return specialContentService.getSpecialContentByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="getSpecialContentByAttributeOr")
	@ResponseBody
	public Object getSpecialContentByAttributeOr(HttpServletRequest request,HttpServletResponse response,String dataInBean,@RequestBody DataInBean dataInBeanJson) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean, dataInBeanJson);
		SpecialContent specialContent = inBean.getSpecialContent();
		int currentPage = inBean.getCurrentPage() == 0 ? 0 : inBean.getCurrentPage();
		int lineSize = inBean.getLineSize() == 0 ? 16 : inBean.getLineSize();
		PageBean<SpecialContent> pageBean = new PageBean<>(currentPage, lineSize);
		pageBean.setInVo(specialContent);
		return specialContentService.getSpecialContentByAttributeOr(pageBean);
	}
	
	@RequestMapping(value="getAll")
	@ResponseBody
	public Object getAll(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		List<SpecialContent> specialContents = specialContentService.getAll();
		return PageBeanUtils.formatForPageTrue(specialContents, 1, 1000000, 1);
	}
}
