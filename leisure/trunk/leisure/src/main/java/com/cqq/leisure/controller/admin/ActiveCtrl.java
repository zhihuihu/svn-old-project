package com.cqq.leisure.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.Active;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.inter.IActiveService;

@Controller
@RequestMapping(value="admin/active")
public class ActiveCtrl {

	@Resource
	private IActiveService iActiveService;
	
	@RequestMapping(value="list")
	@ResponseBody
	public Object getActiveList() throws Exception{
		Active active = new Active();
		PageBean<Active> pageBean = new PageBean<Active>(0, 1000);
		pageBean.setInVo(active);
		return iActiveService.selectAll(pageBean);
	}
	
	/***
	 * 后台修改活动
	 * @param activeId
	 * @param activeStartTime
	 * @param activeAddress
	 * @param activeMainContent
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="update")
	@ResponseBody
	public Object updateActive(int activeId,String activeStartTime,String activeAddress,String activeMainContent,String activeName) throws Exception{
		Active active = new Active();
		active.setActiveId(activeId);
		Active activeExcit = iActiveService.selectByPrimaryKey(active);
		if( activeExcit == null){
			return PageBeanUtils.formatForNormalFalse("", "不存在该活动");
		}
		activeExcit.setActiveAddress(activeAddress);
		activeExcit.setActiveMainContent(activeMainContent);
		activeExcit.setActiveStartTime(activeStartTime);
		activeExcit.setActiveName(activeName);
		iActiveService.doUpdateByPrimaryKey(activeExcit);
		return PageBeanUtils.formatForNormalTrue("", "修改成功");
	}
	
	//管理员添加活动
	@RequestMapping(value="add")
	@ResponseBody
	public Object addActive(String activeIconUrl,String activeName,String activeAddress,String activeStartTime,String activeEndTime,String activeMainContent,String activeLog,String activeLat) throws Exception{
		Active active = new Active();
		active.setActiveAddress(activeAddress);
		active.setActiveEndTime(activeEndTime);
		active.setActiveMainContent(activeMainContent);
		active.setActiveCreateTime(TimeUtils.getMySqlFormatTime());
		active.setActiveName(activeName);
		active.setActiveStartTime(activeStartTime);
		active.setActiveCreateName("管理员");
		active.setActiveTag("hot");
		active.setTagId(1);
		active.setActiveLat(activeLat);
		active.setActiveLog(activeLog);
		active.setActiveIconUrl(activeIconUrl);
		iActiveService.doInsert(active);
		return PageBeanUtils.formatForNormalTrue("", active);
		
	}
}
