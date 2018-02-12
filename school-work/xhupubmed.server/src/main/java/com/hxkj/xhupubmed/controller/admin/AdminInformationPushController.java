package com.hxkj.xhupubmed.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.InformationPush;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.InformationPushService;

/** 
 * ClassName:AdminInformationPushController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午5:55:04 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="admin/informationPush")
public class AdminInformationPushController {

	@Resource
	private InformationPushService informationPushService;
	
	
	/**
	 * 
	* @Function: 增加一个推送信息
	* @Title: doInsert  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月17日 下午5:59:38
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		InformationPush informationPush = inBean.getInformationPush();
		informationPush.setInformationPushCreateTime(TimeUtils.getMySqlFormatTime());
		informationPushService.doInsert(informationPush);
		return PageBeanUtils.formatForNormalTrue("", "增加数据成功");
	}
	
	/**
	 * 
	* @Function: 分页搜索查询
	* @Title: selectByAttributeAnd  
	* @param request
	* @param response
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月17日 下午6:07:56
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		InformationPush informationPush = inBean.getInformationPush();
		PageBean<InformationPush> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(informationPush);
		pageBean.setOrderByString("ORDER BY INFORMATION_PUSH_CREATE_TIME DESC");
		pageBean.setStartTime(inBean.getStartTime());
		pageBean.setEndTime(inBean.getEndTime());
		pageBean.setSearchName(inBean.getSearchName());
		return informationPushService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="doDelete",method=RequestMethod.GET)
	@ResponseBody
	public Object doDelete(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		InformationPush informationPush = inBean.getInformationPush();
		int flg = informationPushService.doDeleteByPrimaryKey(informationPush);
		if(flg > 0){
			return PageBeanUtils.formatForNormalTrue("", "删除成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "删除失败,数据不存在");
	}
	
	@RequestMapping(value="selectByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		InformationPush informationPush = inBean.getInformationPush();
		informationPush = informationPushService.selectByPrimaryKey(informationPush);
		if(informationPush != null){
			return PageBeanUtils.formatForNormalTrue("", informationPush);
		}
		return PageBeanUtils.formatForNormalFalse("", "数据不存在");
	}
}
