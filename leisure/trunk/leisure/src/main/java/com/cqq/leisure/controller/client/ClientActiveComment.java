package com.cqq.leisure.controller.client;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.RedisUtils;
import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.entity.UserActiveComment;
import com.cqq.leisure.service.inter.IUserActiveCommentService;

/**
 * 关于活动评论控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value="client/active/comment")
public class ClientActiveComment {
	@Resource
	private IUserActiveCommentService iuserActiveCommentService;
	
	/**
	 * 获取该活动的所有评论
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Object getComment(int ActiveId,int lineSize,int currentPage) throws Exception{
		UserActiveComment userActiveComment = new UserActiveComment();
		userActiveComment.setUserActiveCommentActiveId(ActiveId);
		PageBean<UserActiveComment> pageBean = new PageBean<UserActiveComment>(currentPage,lineSize);
		pageBean.setInVo(userActiveComment);
		return iuserActiveCommentService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 修改空白评论
	 * @param commentTyepe 评论类型 1好 2一般 3差
	 * @param commentContent 评论类型
	 * @param token 用户的token
	 * @param activeId 活动Id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public Object addComment(String token,int activeId,int commentTyepe,String commentContent) throws Exception{
		User userToken = RedisUtils.get(token,User.class);
		if(userToken == null){
			return PageBeanUtils.formatForNormalFalse("", "用户登录到期,请重新登录");
		}
		UserActiveComment userActiveComment = new UserActiveComment();
		userActiveComment.setUserActiveCommentActiveId(activeId);
		userActiveComment.setUserActiveCommentUserId(userToken.getUserId());
		UserActiveComment exist = iuserActiveCommentService.selectByPrimaryKey(userActiveComment);
		System.out.println(exist);
		if(exist == null){
			return PageBeanUtils.formatForNormalFalse("", "您未参加该活动，参加才允许评论");
		}
		
		exist.setUserActiveCommentType(commentTyepe);
		exist.setUserActiveCommentContent(commentContent);
		exist.setUserActiveCommentUpdateTime(TimeUtils.getMySqlFormatTime());
		iuserActiveCommentService.doUpdateByPrimaryKey(exist);
		return PageBeanUtils.formatForNormalTrue("", exist);
	}
	
	/**点击“我要参与”增加一条新的空白评论
	 * 活动评论一个用户只能存在一条评论
	 * @param activeId
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="addblank",method=RequestMethod.POST)
	@ResponseBody
	public Object addBlank(int activeId,String token) throws Exception{
		User tokenUser = RedisUtils.get(token, User.class);
		if(tokenUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期请重新登录");
		}
		UserActiveComment userActiveComment = new UserActiveComment();
		userActiveComment.setUserActiveCommentActiveId(activeId);
		userActiveComment.setUserActiveCommentUserId(tokenUser.getUserId());
		userActiveComment.setUserActiveCommentContent("该用户未进行评论");
		userActiveComment.setUserActiveCommentCreateTime(TimeUtils.getMySqlFormatTime());
		iuserActiveCommentService.doInsert(userActiveComment);
		return PageBeanUtils.formatForNormalTrue("", userActiveComment);
	}
}
