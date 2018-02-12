package com.hxkj.xhupubmed.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.ParameterUtils;
import com.hxkj.xhupubmed.entity.DataSharing;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.DataSharingService;

/** 
 * ClassName:AdminDataSharingController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月10日 上午9:47:56 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="admin/dataSharing")
public class AdminDataSharingController {

	@Resource
	private DataSharingService dataSharingService;
	
	
	@RequestMapping(value="doInsert")
	@ResponseBody
	public Object doInsert(HttpServletRequest request,String dataSharing) throws Exception{
		DataSharing dataSharingB = JSON.parseObject(dataSharing,DataSharing.class);
		return dataSharingService.adminDoInsert(request, dataSharingB);
	}
	
	@RequestMapping(value="selectByAttributeAnd")
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		DataSharing dataSharing = inBean.getDataSharing();
		PageBean<DataSharing> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(dataSharing);
		pageBean.setSearchName(inBean.getSearchName());
		pageBean.setStartTime(inBean.getStartTime());
		pageBean.setEndTime(inBean.getEndTime());
		pageBean.setOrderByString("ORDER BY DATA_SHARING_CREATE_TIME DESC");
		return dataSharingService.selectByAttributeAnd(pageBean);
	}
	
	@RequestMapping(value="doUpdate")
	@ResponseBody
	public Object doUpdate(HttpServletRequest request,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		DataSharing dataSharing = inBean.getDataSharing();
		int flg = dataSharingService.doUpdateByPrimaryKeySelective(dataSharing);
		if(flg > 0){
			return PageBeanUtils.formatForNormalTrue("", "更新成功!");
		}
		return PageBeanUtils.formatForNormalFalse("", "更新失败!");
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		DataSharing dataSharing = inBean.getDataSharing();
		dataSharing = dataSharingService.selectByPrimaryKey(dataSharing);
		if(dataSharing == null){
			return PageBeanUtils.formatForNormalFalse("", "数据不存在,请检查数据");
		}
		return PageBeanUtils.formatForNormalTrue("", dataSharing);
	}
	
}
