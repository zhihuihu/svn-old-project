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
import com.cqq.leisure.entity.UserCollectCommit;
import com.cqq.leisure.service.inter.IUserCollectCommitService;

@Controller
@RequestMapping(value="client/commit")
public class ClientUserCollectCommit {
	@Resource
	private IUserCollectCommitService iUserCollectCommitService;
	/**
	 * 获取当前商家的所有评论信息
	 * @param MerchantId 商家Id
	 * @param currentPage 当前页
	 * @param lineSize 条数
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list", method = RequestMethod.GET)
	@ResponseBody
	public Object getCommitList(int MerchantId,int currentPage,int lineSize) throws Exception{
		UserCollectCommit userCollectCommit = new UserCollectCommit();
		userCollectCommit.setMerchantId(MerchantId);
		PageBean<UserCollectCommit> pageBean = new PageBean<UserCollectCommit>(currentPage, lineSize);
		pageBean.setInVo(userCollectCommit);
		return iUserCollectCommitService.selectByAttributeAnd(pageBean);
		
	}
	/***
	 * 对当前商家进行评论  修改state为2的空白评论
	 * @param merchantId当前商家Id
	 * @param token用户的Token
	 * @param commitType评论类型（1好评2一般3差评）
	 * @param commitContent评论内容
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="add", method = RequestMethod.GET)
	@ResponseBody
	public Object addUserCollectCommit(int merchantId,String token,int commitType,String commitContent)throws Exception{
		User tokenUser = RedisUtils.get(token, User.class);
		if(tokenUser == null){
			return PageBeanUtils.formatForNormalFalse("", "用户登录到期请重新登录");
		}
		UserCollectCommit userCollectCommit = new UserCollectCommit();
		userCollectCommit.setUserId(tokenUser.getUserId());
		userCollectCommit.setMerchantId(merchantId);
		userCollectCommit.setUserCollectCommitState(2);
		UserCollectCommit isExist = iUserCollectCommitService.selectByPrimaryKey(userCollectCommit);
		if(isExist == null){
			return PageBeanUtils.formatForNormalFalse("", "您没有未提交的评论");
		}else{
			isExist.setUserCollectCommitType(commitType);
			isExist.setUserCollectCommitContent(commitContent);
			isExist.setUserCollectCommitState(1);//状态位最好不为0
			isExist.setUserCollectCommitUpdateTime(TimeUtils.getMySqlFormatTime());
			iUserCollectCommitService.doUpdateByPrimaryKey(isExist);
			return PageBeanUtils.formatForNormalTrue("",isExist );
		}
		
	}
	
	
	/***
	 * 点击参加 添加一条空白评论 当存在state为2 的评论时不添加
	 * @param merchantId
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="addblank",method=RequestMethod.GET)
	@ResponseBody
	public Object addBlankCommit(int merchantId,String token)throws Exception{
		User tokenUser = RedisUtils.get(token, User.class);
		if(tokenUser == null){
			return PageBeanUtils.formatForNormalFalse("", "用户登录到期请重新登录");
		}
		UserCollectCommit userCollectCommit = new UserCollectCommit();
		userCollectCommit.setUserId(tokenUser.getUserId());
		userCollectCommit.setMerchantId(merchantId);
		//状态为2是空白评论
		userCollectCommit.setUserCollectCommitState(2);
		UserCollectCommit isExist = iUserCollectCommitService.selectByPrimaryKey(userCollectCommit);
		if(isExist == null){
			userCollectCommit.setUserCollectCommitCreateTime(TimeUtils.getMySqlFormatTime());
			iUserCollectCommitService.doInsert(userCollectCommit);
			return PageBeanUtils.formatForNormalTrue("", "插入一条新空白评论");
		}
		else{
			return PageBeanUtils.formatForNormalFalse("", "已经存在，插入失败");
		}
	}
	
}

