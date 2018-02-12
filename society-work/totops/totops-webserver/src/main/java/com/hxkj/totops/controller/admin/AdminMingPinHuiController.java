package com.hxkj.totops.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.totops.core.utils.JackSonUtils;
import com.hxkj.totops.core.utils.PageReturnUtils;
import com.hxkj.totops.core.utils.TimeUtils;
import com.hxkj.totops.entity.MingPinHui;
import com.hxkj.totops.entity.query.ParameterBean;
import com.hxkj.totops.service.inter.IMingPinHuiService;

/**
 * @ClassName: AdminMingPinHuiController 
 * @Description: 管理端--名品汇控制器
 * @author huzhihui_c@qq.com
 * @date 2016年8月31日 上午11:43:54
 */
@Controller
@RequestMapping(value="admin/mingPinHui")
public class AdminMingPinHuiController {

	private static final Logger logger = LoggerFactory.getLogger(AdminMingPinHuiController.class);
	
	@Autowired
	private IMingPinHuiService iMingPinHuiService;
	
	/**
	 * @Title: insertOneMingPinHui 
	 * @Description:     名品汇--增加一个名品汇子内容
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午11:47:31
	 */
	@RequestMapping(value="insertOneMingPinHui")
	@ResponseBody
	public Map<String,Object> insertOneMingPinHui(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----名品汇--增加一个名品汇子内容");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iMingPinHuiService.insertOneMingPinHui(request, parameterBean);
	}
	
	/**
	 * @Title: updateOneMingPinHui 
	 * @Description:     名品汇--更新一个名品汇子内容
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午11:50:57
	 */
	@RequestMapping(value="updateOneMingPinHui")
	@ResponseBody
	public Map<String,Object> updateOneMingPinHui(HttpServletRequest request,String parameterBeanString) throws Exception{
		logger.info("-----名品汇--更新一个名品汇子内容");
		ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}
		return iMingPinHuiService.updateOneMingPinHui(request, parameterBean);
	}
	
	/**
	 * 更新富文本内容
	 * @Title: updateOneMingPinHuiContent 
	 * @Description:     
	 * @param request
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月10日 下午4:42:16
	 */
	@RequestMapping(value="updateOneMingPinHuiContent")
	@ResponseBody
	public Map<String,Object> updateOneMingPinHuiContent(HttpServletRequest request,@RequestBody ParameterBean parameterBean) throws Exception{
		logger.info("-----名品汇--更新一个名品汇子内容Content");
		/*ParameterBean parameterBean = new ParameterBean();
		if(null == parameterBeanString || parameterBeanString.trim().equals("")){
			parameterBean = JackSonUtils.toObject(request.getParameter("parameterBeanString"), ParameterBean.class);
		}else{
			parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		}*/
		MingPinHui mingPinHui = parameterBean.getMingPinHui();
		mingPinHui.setMingPinHuiUpdateTime(TimeUtils.getNowTime());
		iMingPinHuiService.updateByPrimaryKeySelective(mingPinHui);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "修改名品汇内容成功");
		//return iMingPinHuiService.updateOneMingPinHui(request, parameterBean);
	}
	
	/**
	 * @Title: deleteByPrimaryKey 
	 * @Description:     名品汇--删除一个名品汇子内容
	 * @param parameterBeanString
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月31日 上午11:53:30
	 */
	@RequestMapping(value="deleteByPrimaryKey")
	@ResponseBody
	public Map<String,Object> deleteByPrimaryKey(@RequestBody String parameterBeanString) throws Exception{
		logger.info("-----名品汇--删除一个名品汇子内容");
		ParameterBean parameterBean = new ParameterBean();
		parameterBean = JackSonUtils.toObject(parameterBeanString, ParameterBean.class);
		if(null == parameterBean || null == parameterBean.getMingPinHui()){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "传入参数错误，删除失败");
		}
		if(iMingPinHuiService.deleteByPrimaryKey(parameterBean.getMingPinHui().getMingPinHuiCuid()) > 0 ){
			return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, "删除成功");
		}
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_111111, PageReturnUtils.MSG_STATE_FALSE, "该信息不存在，删除失败");
	}
}
