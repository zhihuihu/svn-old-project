package com.cqq.leisure.controller.client;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.RedisUtils;
import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.dao.IUserDao;
import com.cqq.leisure.entity.Active;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.service.impl.ActiveService;
import com.cqq.leisure.service.inter.IUserService;

@Controller
@RequestMapping(value="client/active")
public class ClientActive {
	@Resource
	private ActiveService activeService;
	@Resource
	private IUserService iUserService;

	/**
	 * 个人用户端发起我的活动，该活动可推荐给同区域用户
	 * @param token
	 * @param ActiveString
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public Object addActive(String token,String ActiveString) throws Exception{
		Active active = JSON.parseObject(ActiveString, Active.class);
		User userToken = RedisUtils.get(token, User.class);
		
		Active newActive = new Active();
		if(userToken == null){
			return PageBeanUtils.formatForNormalFalse("", "用户登录到期请重新登录");
		}
		Random random=new Random();// 定义随机类
		int result=random.nextInt(10);
		newActive.setActiveName(active.getActiveName());
		newActive.setActiveCreateTime(TimeUtils.getMySqlFormatTime());
		newActive.setActiveStartTime(active.getActiveStartTime());
		newActive.setActiveEndTime(active.getActiveEndTime());
		newActive.setActiveMainContent(active.getActiveMainContent());
		newActive.setUserId(userToken.getUserId());
		newActive.setActiveAddress(active.getActiveAddress());
		newActive.setActiveLat(active.getActiveLat());
		newActive.setActiveTag("hot");
		newActive.setActiveIconUrl("http://192.168.137.1:8080/leisureImage/"+result+".jpg");
		newActive.setActiveType(active.getActiveType());
		newActive.setTagId(active.getTagId());
		newActive.setActiveLog(active.getActiveLog());
		
		activeService.doInsert(newActive);
		return PageBeanUtils.formatForNormalTrue("", newActive);
	}
	
	/**
	 * 获取我发起的活动列表
	 * @param token
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Object listActive(String token,int currentPage,int lineSize) throws Exception{
		User userToken = RedisUtils.get(token, User.class);
		if(userToken == null){
			return PageBeanUtils.formatForNormalFalse("", "请登录");
		}
		Active active =new Active(); 
		active.setUserId(userToken.getUserId());
		PageBean<Active> pageBean = new PageBean<Active>(currentPage, lineSize);
		pageBean.setInVo(active);
		return activeService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 删除我发起的社区活动
	 * @param token
	 * @param ActiveId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="delete",method=RequestMethod.POST)
	@ResponseBody
	public Object deleteActive(String token,int ActiveId)throws Exception{
		User userToken = RedisUtils.get(token, User.class);
		if(userToken == null){
			return PageBeanUtils.formatForNormalFalse("", "请登录");
		}
		Active active = new Active();
		active.setActiveId(ActiveId);
		activeService.doDeleteByPrimaryKey(active);
		return PageBeanUtils.formatForNormalTrue("", "删除成功");
	}
	
	/**
	 * 查找主页上的Active列表 选择activeCreateName为管理员的活动。
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="index/list",method=RequestMethod.GET)
	@ResponseBody
	public Object getIndexActiveList(int currentPage,int lineSize) throws Exception{
		Active active =new Active(); 
		active.setActiveCreateName("管理员");
		PageBean<Active> pageBean = new PageBean<Active>(currentPage, lineSize);
		pageBean.setInVo(active);
		return activeService.selectByAttributeAnd(pageBean);
	}

	/***
	 * 按照分类来查找 在发现页
	 * @param activeType
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="find/type/list",method=RequestMethod.GET)
	@ResponseBody
	public Object getActiveByType(String activeType,int currentPage,int lineSize) throws Exception{
		Active active = new Active();
		active.setActiveType(activeType);
		PageBean<Active> pageBean = new PageBean<Active>(currentPage, lineSize);
		pageBean.setInVo(active);
		return activeService.selectByAttributeAnd(pageBean);
	}

	/***
	 * 获取主页活动详情
	 * @param ActiveId 需要获取的活动ID
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="index/detail",method=RequestMethod.GET)
	@ResponseBody
	public Object getIndexActiveDetail(int ActiveId) throws Exception{
		Active  active = new Active();
		active.setActiveId(ActiveId);
		Active activeExcit = activeService.selectByPrimaryKey(active);
		int ActiveUserId = activeExcit.getUserId();
		User ActiveUser = new User();
		ActiveUser.setUserId(ActiveUserId);
		User ActiveUserExict = iUserService.selectByPrimaryKey(ActiveUser);
		activeExcit.setUser(ActiveUserExict);
		return PageBeanUtils.formatForNormalTrue("", activeExcit);
	}
	
	/**
	 *查找前十的活动 activeTag替代为排序方式  hot normal
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value ="find/top",method=RequestMethod.GET)
	@ResponseBody
	public Object getTopTen(int currentPage,int lineSize) throws Exception{
		Active active = new Active();
		active.setActiveTag("hot");
		PageBean<Active> pageBean = new PageBean<Active>(currentPage, lineSize);
		pageBean.setInVo(active);
		return activeService.selectByAttributeAnd(pageBean);
	}
	
	
	/***
	 * 通过标签TagID查找Active
	 * @param tagId 标签ID
	 * @param currentPage
	 * @param lineSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="listbytag",method=RequestMethod.GET)
	@ResponseBody
	public Object getActiveByTagId(int tagId,int currentPage,int lineSize) throws Exception{
		Active active = new Active();
		active.setTagId(tagId);
		PageBean<Active> pageBean = new PageBean<Active>(currentPage, lineSize);
		pageBean.setInVo(active);
		return activeService.selectByAttributeAnd(pageBean);
		
	}
	
	/**
	 * 通过参加活动增加sort字段，为热门排序准备
	 * @param activeId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="addsort",method=RequestMethod.POST)
	@ResponseBody
	public Object addSort(int activeId)throws Exception{
		Active active = new Active();
		active.setActiveId(activeId);
		Active excitActive = activeService.selectByPrimaryKey(active);
		int sort = excitActive.getActiveSort()+1;
		excitActive.setActiveSort(sort);
		activeService.doUpdateByPrimaryKey(excitActive);
		return PageBeanUtils.formatForNormalTrue("", excitActive);
	}
	
	
	/***
	 * 通过常驻位置进行活动的推送 
	 * @param token
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="recomend",method=RequestMethod.GET)
	@ResponseBody
	public Object recomendActive(String token) throws Exception{
		List<Active> list = new ArrayList<Active>();
		list = activeService.selectNearByActive(token);
		System.out.println(list);
		return PageBeanUtils.formatForNormalTrue("", list);
	}
	
	/***
	 * 通过关键字搜索活动
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="searchbykeyword",method=RequestMethod.GET)
	@ResponseBody
	public Object searchByKeyWord(String keyword) throws Exception{
		List<Active> list = new ArrayList<Active>();
		list = activeService.selectByKeyWord(keyword);
		return PageBeanUtils.formatForNormalTrue("", list);
	}
}
