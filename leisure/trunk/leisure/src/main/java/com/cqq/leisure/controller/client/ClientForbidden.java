package com.cqq.leisure.controller.client;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.entity.Forbidden;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.inter.IForbiddenService;

@Controller
@RequestMapping(value="client/forbidden")
public class ClientForbidden {
	
	@Resource
	private IForbiddenService iForbiddenService;
	
	/**
	 * 增加一条禁忌消息
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	@ResponseBody
	public Object addForbidden (String cityName,String title,String mainContent) throws Exception{
		Forbidden forbidden = new Forbidden();
		forbidden.setForbiddenCityName(cityName);
		forbidden.setForbiddenTitle(title);
		forbidden.setForbiddenMainContent(mainContent);
		iForbiddenService.doInsert(forbidden);
		return PageBeanUtils.formatForNormalTrue("", forbidden);
	}
	
	/**
	 * 通过当前地址获取禁忌信息
	 * @param cityName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="getMainContent",method=RequestMethod.GET)
	@ResponseBody
	public Object getMainContent(String cityName) throws Exception{
		Forbidden forbidden = new Forbidden();
		forbidden.setForbiddenCityName(cityName);
		PageBean<Forbidden> pagebean = new PageBean<Forbidden>(0, 1);
		pagebean.setInVo(forbidden);
		return iForbiddenService.selectByAttributeAnd(pagebean);
	}
}
