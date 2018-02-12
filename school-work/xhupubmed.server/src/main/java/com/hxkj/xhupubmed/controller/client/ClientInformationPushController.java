package com.hxkj.xhupubmed.controller.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.ParameterUtils;
import com.hxkj.xhupubmed.entity.InformationPush;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.InformationPushService;

/**
 * 
* @ClassName: ClientInformationPushController 
* @Description: TODO 信息推送控制层
* @author huzhihui_c@qq.com
* @date 2016年4月14日 下午3:53:54 
*
 */
@Controller
@RequestMapping(value="client/informationPush")
public class ClientInformationPushController {

	@Resource
	private InformationPushService informationPushService;
	
	
	/**
	 * 
	* @Title: selectByAttributeAnd 
	* @Description: TODO    考研新闻列表查询  state 为 1
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:58:10
	 */
	@RequestMapping(value="normal/selectPubmedNews")
	@ResponseBody
	public Object selectPubmedNews(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		InformationPush informationPush = new InformationPush();
		informationPush.setInformationPushState(1);//新闻类
		PageBean<InformationPush> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setOrderByString("ORDER BY INFORMATION_PUSH_CREATE_TIME DESC");
		pageBean.setInVo(informationPush);
		return informationPushService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Title: selectByAttributeAnd 
	* @Description: TODO    考研常见事项列表查询  state 为 2
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:58:10
	 */
	@RequestMapping(value="normal/selectPubmedNormalThings")
	@ResponseBody
	public Object selectPubmedNormalThings(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		InformationPush informationPush = new InformationPush();
		informationPush.setInformationPushState(2);//常见事项类
		PageBean<InformationPush> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setOrderByString("ORDER BY INFORMATION_PUSH_CREATE_TIME DESC");
		pageBean.setInVo(informationPush);
		return informationPushService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Title: selectByAttributeAnd 
	* @Description: TODO    考研推送列表查询  state 为 3
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:58:10
	 */
	@RequestMapping(value="normal/selectPubmedPush")
	@ResponseBody
	public Object selectPubmedPush(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		InformationPush informationPush = new InformationPush();
		informationPush.setInformationPushState(3);//推送类
		PageBean<InformationPush> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setOrderByString("ORDER BY INFORMATION_PUSH_CREATE_TIME DESC");
		pageBean.setInVo(informationPush);
		return informationPushService.selectByAttributeAnd(pageBean);
	}
	
	
	/**
	 * 
	* @Title: selectInformationPushAll 
	* @Description: TODO    考研推送列表查询  state 为 3
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:58:10
	 */
	@RequestMapping(value="normal/selectInformationPushAll")
	@ResponseBody
	public Object selectInformationPushAll(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		InformationPush informationPush = new InformationPush();
		informationPush.setInformationPushState(0);//查看所有
		PageBean<InformationPush> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setOrderByString("ORDER BY INFORMATION_PUSH_CREATE_TIME DESC");
		pageBean.setInVo(informationPush);
		pageBean.setSearchName(inBean.getSearchName());
		return informationPushService.selectByAttributeAnd(pageBean);
	}
	
	
	/**
	 * 
	* @Title: selectByPrimaryKey 
	* @Description: TODO    通过主键查询信息
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* @return Object    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午4:13:07
	 */
	@RequestMapping(value="normal/selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		InformationPush informationPush = inBean.getInformationPush();
		informationPush = informationPushService.selectByPrimaryKey(informationPush);
		return PageBeanUtils.formatForNormalTrue("", informationPush);
	}
	
	
}
