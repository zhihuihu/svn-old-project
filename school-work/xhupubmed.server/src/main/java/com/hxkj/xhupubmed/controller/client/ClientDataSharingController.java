package com.hxkj.xhupubmed.controller.client;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.ParameterUtils;
import com.hxkj.xhupubmed.core.utils.RedisUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.DataSharing;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.DataSharingService;

/** 
 * ClassName:ClientDataSharingController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月2日 下午2:17:15 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/dataSharing")
public class ClientDataSharingController {

	@Resource
	private DataSharingService dataSharingService;
	
	/**
	 * 
	* @Function: 增加一条分享数据,不含文件
	* @Title: doInsert  
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月2日 下午2:26:00
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		DataSharing dataSharing = inBean.getDataSharing();
		dataSharing.setDataSharingSysUserCuid(sysUser.getSysUserCuid());
		dataSharing.setDataSharingState(1);
		dataSharing.setDataSharingCreateTime(TimeUtils.getMySqlFormatTime());
		dataSharingService.doInsertSelective(dataSharing);
		return PageBeanUtils.formatForNormalTrue("", dataSharing);
	}
	
	
	/**
	 * 
	* @Function: 新增数据分享,含有文件,只是进行数据的更新
	* @Title: doInsertFiles  
	* @param request
	* @param response
	* @param dataSharingCuid
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月2日 下午2:26:28
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsertFiles")
	@ResponseBody
	public Object doInsertFiles(HttpServletRequest request,HttpServletResponse response,String dataSharingCuid,String token) throws Exception{
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		DataSharing dataSharing = new DataSharing();
		dataSharing.setDataSharingCuid(dataSharingCuid);
		return dataSharingService.doInsertFiles(request, dataSharing);
	}
	
	@RequestMapping(value="selectByAttributeAnd")
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		/*SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}*/
		DataSharing dataSharing = inBean.getDataSharing();
		PageBean<DataSharing> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(dataSharing);
		pageBean.setSearchName(inBean.getSearchName());
		pageBean.setOrderByString("ORDER BY DATA_SHARING_CREATE_TIME DESC");
		return dataSharingService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		/*SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}*/
		DataSharing dataSharing = inBean.getDataSharing();
		dataSharing = dataSharingService.selectByPrimaryKey(dataSharing);
		if(dataSharing == null){
			return PageBeanUtils.formatForNormalFalse("", "没有该数据");
		}
		return PageBeanUtils.formatForNormalTrue("", dataSharing);
	}
}
