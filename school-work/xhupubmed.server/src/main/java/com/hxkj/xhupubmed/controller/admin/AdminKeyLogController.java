package com.hxkj.xhupubmed.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.ParameterUtils;
import com.hxkj.xhupubmed.entity.KeyLog;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.KeyLogService;

/** 
 * ClassName:AdminKeyLogController
 * Function:   可以查询多种条件的,用户的信息反馈也在这里进行反馈,state为10
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月8日 下午12:40:13 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="admin/keyLog")
public class AdminKeyLogController {

	@Resource
	private KeyLogService keyLogService;
	
	@RequestMapping(value="selectByAttributeAnd",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		PageBean<KeyLog> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(inBean.getKeyLog());
		pageBean.setSearchName(inBean.getSearchName());
		pageBean.setStartTime(inBean.getStartTime());
		pageBean.setEndTime(inBean.getEndTime());
		pageBean.setOrderByString("ORDER BY KEY_LOG_CREATE_TIME DESC");
		return keyLogService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="doDelete",method=RequestMethod.GET)
	@ResponseBody
	public Object doDelete(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		KeyLog keyLog = inBean.getKeyLog();
		int flg = keyLogService.doDeleteByPrimaryKey(keyLog);
		if(flg > 0 ){
			return PageBeanUtils.formatForNormalTrue("", "删除成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "数据不存在,删除失败");
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		KeyLog keyLog = inBean.getKeyLog();
		keyLog = keyLogService.selectByPrimaryKey(keyLog);
		if(keyLog != null ){
			return PageBeanUtils.formatForNormalTrue("", keyLog);
		}
		return PageBeanUtils.formatForNormalFalse("", "数据不存在");
	}
}
