package com.cqq.leisure.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.Images;
import com.cqq.leisure.service.impl.ImagesService;

/** 
 * ClassName:ImagesController
 * Function:   
 * Date:     2016年3月20日 下午8:40:42 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="images")
public class ImagesController {

	@Resource
	private ImagesService imagesService;
	
	@RequestMapping(value="insert")
	@ResponseBody
	private Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Images images = new Images();
		images.setImagesUrl("www.baidu.com");
		images.setImagesState(1);
		images.setImagesCreateTime(TimeUtils.getMySqlFormatTime());
		imagesService.doInsert(images);
		return images;
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey")
	@ResponseBody
	private Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Images images = new Images();
		images.setImagesId(5);
		imagesService.doDeleteByPrimaryKey(images);
		return images;
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	private Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Images images = new Images();
		images.setImagesId(6);
		imagesService.selectByPrimaryKey(images);
		return images;
	}
	
	@RequestMapping(value="doUpdateByPrimaryKey")
	@ResponseBody
	private Object doUpdateByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Images images = new Images();
		images.setImagesId(3);
		images.setImagesUrl("www.baidu.com");
		images.setImagesState(1);
		images.setImagesCreateTime(TimeUtils.getMySqlFormatTime());
		imagesService.doUpdateByPrimaryKey(images);
		return images;
	}
}
