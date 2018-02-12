package com.cqq.leisure.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.Tag;
import com.cqq.leisure.service.inter.ITagService;

@Controller
@RequestMapping(value="admin/tag")
public class TagAdminCtrl {
	
	@Resource
	private ITagService iTagService;
	
	/***
	 * 获取taglist
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list")
	@ResponseBody
	public Object gettagList() throws Exception{
		Tag tag = new Tag();
		PageBean<Tag> pageBean = new PageBean<Tag>(0, 1000);
		pageBean.setInVo(tag);
		return iTagService.selectAll(pageBean);
		//return PageBeanUtils.formatForNormalTrue("", iTagService.selectAll(pageBean));
	}
	
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public Object addtag(String tagName,String tagImage) throws Exception{
		Tag tag = new Tag();
		tag.setTagImg(tagImage);
		tag.setTagName(tagName);
		iTagService.doInsert(tag);
		return PageBeanUtils.formatForNormalTrue("", tag);
	}
	

}
