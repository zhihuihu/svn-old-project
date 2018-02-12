package com.cqq.leisure.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.entity.Tag;
import com.cqq.leisure.service.impl.TagService;

@Controller
@RequestMapping("tag")
public class TagController {
	@Resource
	private TagService tagService;
	@RequestMapping("insert")
	@ResponseBody
	private Object doInsert(HttpServletRequest request,HttpServletResponse response)throws Exception{
		Tag tag = new Tag();
		tag.setTagName("毕业季");
		tagService.doInsert(tag);
		return tag;
	}

}
