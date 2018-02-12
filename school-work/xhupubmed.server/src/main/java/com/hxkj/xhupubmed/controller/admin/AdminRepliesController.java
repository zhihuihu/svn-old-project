package com.hxkj.xhupubmed.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.Replies;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.RepliesService;

/** 
 * ClassName:AdminRepliesController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月5日 下午3:40:42 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="admin/replies")
public class AdminRepliesController {

	@Resource
	private RepliesService repliesService;
	
	/**
	 * 
	* @Function: 通过属性的分页查询
	* @Title: selectByAttribute  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 下午3:48:18
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttribute")
	@ResponseBody
	public Object selectByAttribute(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		PageBean<Replies> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(inBean.getReplies());
		pageBean.setSearchName(inBean.getSearchName());
		pageBean.setStartTime(inBean.getStartTime());
		pageBean.setEndTime(inBean.getEndTime());
		pageBean.setOrderByString("ORDER BY REPLIES_UPDATE_TIME DESC");
		return repliesService.selectByAttributeAnd(pageBean);
	}
	
	
	/**
	 * 
	* @Function: 更新方法
	* @Title: doUpdateByPrimaryKeySelective  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 下午3:50:57
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doUpdateByPrimaryKeySelective")
	@ResponseBody
	public Object doUpdateByPrimaryKeySelective(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		Replies replies = inBean.getReplies();
		int flg = repliesService.doUpdateByPrimaryKeySelective(replies);
		if(flg > 0){
			return PageBeanUtils.formatForNormalTrue("", "更新成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "更新失败,数据不存在");
	}
	
	@RequestMapping(value="doDelete")
	@ResponseBody
	public Object doDelete(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		Replies replies = inBean.getReplies();
		int flg = repliesService.doDeleteByPrimaryKey(replies);
		if(flg > 0){
			return PageBeanUtils.formatForNormalTrue("", "更新成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "更新失败,数据不存在");
	}
	
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		Replies replies = inBean.getReplies();
		return PageBeanUtils.formatForNormalTrue("", repliesService.selectByPrimaryKey(replies));
	}
	
	
}
