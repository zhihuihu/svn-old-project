package com.hxkj.xhupubmed.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.Chat;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.service.impl.PostService;
import com.wordnik.swagger.annotations.ApiOperation;

/** 
 * ClassName:PostController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午9:52:54 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="post")
public class PostController {

	@Resource
	private PostService postService;
	
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ApiOperation(value = "添加信息", httpMethod = "GET", response =Chat.class, notes = "add chat")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Post post = new Post();
		post.setPostTitle("第一次发帖");
		post.setPostType(1);
		post.setPostFollowPeopleNumber(1);
		post.setPostFollowPeopleNumber(1);
		post.setPostState(1);
		post.setPostCreateTime(TimeUtils.getMySqlFormatTime());
		postService.doInsert(post);
		return post;
	}
	
	@RequestMapping(value="doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ApiOperation(value = "通过主键删除", httpMethod = "GET", response =PageBeanUtils.class, notes = "delete chat")
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Post post = new Post();
		post.setPostCuid("");
		postService.doDeleteByPrimaryKey(post);
		return post;
	}
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询AND查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select and chat")
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<Post> pageBean = new PageBean<>(1, 3);
		pageBean.setInVo(new Post());
		return postService.selectByAttributeAnd(pageBean);
	}
	@RequestMapping(value="selectByAttributeOr",method=RequestMethod.GET)
	@ApiOperation(value = "通过属性查询OR查询", httpMethod = "GET", response =PageBeanUtils.class, notes = "select or chat")
	@ResponseBody
	public Object selectByAttributeOr(HttpServletRequest request,HttpServletResponse response) throws Exception{
		PageBean<Post> pageBean = new PageBean<>(1, 3);
		pageBean.setInVo(new Post());
		return postService.selectByAttributeOr(pageBean);
	}
	
}
