package com.cqq.leisure.controller.client;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.entity.UserTag;
import com.cqq.leisure.service.inter.IUserTagService;
@Controller
@RequestMapping(value="client/usertag")
public class ClientUserTag {
	
	@Resource
	private IUserTagService iUserTagService ;
	
	/***
	 * 添加用户的活动标签
	 * @param userId
	 * @param TagId  
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public Object addUserTag(int userId,int tagId) throws Exception{
		UserTag userTag = new UserTag();
		userTag.setTagId(tagId);
		userTag.setUserId(userId);
		UserTag isExist = iUserTagService.selectByPrimaryKey(userTag);
		if(isExist == null){
			userTag.setUserTagPressNumber(1);
			iUserTagService.doInsert(userTag);
			return PageBeanUtils.formatForNormalTrue("", userTag);
		}else{
			int hasNumber = isExist.getUserTagPressNumber();
			int number = hasNumber+1;
			isExist.setUserTagPressNumber(number);
			iUserTagService.doUpdateByPrimaryKey(isExist);
			return PageBeanUtils.formatForNormalTrue("", isExist);
		}
	}
	
	
	/**
	 * 通过用户Id找到属于user的Tag
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="get",method = RequestMethod.GET)
	@ResponseBody
	public Object getMyTag(int userId)throws Exception{
		List<UserTag> list = new ArrayList<UserTag>();
		UserTag userTag = new UserTag();
		userTag.setUserId(userId);
		List<UserTag> isExist = iUserTagService.selectByAttributeList(userTag);
		for(int i=0;i<isExist.size();i++){
			int number = isExist.get(i).getUserTagPressNumber();
			if(number>=10){
				list.add(isExist.get(i));
			}
		}
		
		return PageBeanUtils.formatForNormalTrue("", list);
	}
}
