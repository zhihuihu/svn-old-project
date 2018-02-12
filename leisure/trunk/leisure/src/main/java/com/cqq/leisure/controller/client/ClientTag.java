package com.cqq.leisure.controller.client;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.RedisUtils;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.Tag;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.service.inter.ITagService;

@Controller
@RequestMapping(value="client/tag")
public class ClientTag {
	@Resource
	private ITagService itagService;
	/**
	 * 获取首页四个展示标签
	 * @param token
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Object listTag(String token,int currentPage,int lineSize)throws Exception{
		User userToken = RedisUtils.get(token, User.class);
		if(userToken == null){
			return PageBeanUtils.formatForNormalFalse("", "请重新登陆");
		}
		Tag tag = new Tag();
		PageBean<Tag> pageBean = new PageBean<Tag>(currentPage, lineSize);
		pageBean.setInVo(tag);
		return itagService.selectByAttributeAnd(pageBean);
	}
}
