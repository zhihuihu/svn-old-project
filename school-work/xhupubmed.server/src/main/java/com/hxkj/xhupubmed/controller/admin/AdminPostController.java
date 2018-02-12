package com.hxkj.xhupubmed.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.entity.Follow;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.FollowService;
import com.hxkj.xhupubmed.service.impl.PostService;

/** 
 * ClassName:AdminPostController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月5日 下午3:27:48 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="admin/post")
public class AdminPostController {

	@Resource
	private PostService postService;
	@Resource
	private FollowService followService;
	/**
	 * 
	* @Function: 通过属性分页查询
	* @Title: selectByAttribute  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 下午3:35:57
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByAttribute")
	@ResponseBody
	public Object selectByAttribute(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		PageBean<Post> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(inBean.getPost());
		pageBean.setSearchName(inBean.getSearchName());
		pageBean.setStartTime(inBean.getStartTime());
		pageBean.setEndTime(inBean.getEndTime());
		pageBean.setOrderByString("ORDER BY POST_UPDATE_TIME DESC");
		return postService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Function: 更新数据
	* @Title: doUpdateByPrimaryKeySelective  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 下午3:37:56
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doUpdateByPrimaryKeySelective")
	@ResponseBody
	public Object doUpdateByPrimaryKeySelective(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		Post post = inBean.getPost();
		int flg = postService.doUpdateByPrimaryKeySelective(post);
		if(flg > 0){
			return PageBeanUtils.formatForNormalTrue("", "更新数据成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "更新数据失败,数据不存在");
	}
	
	
	/**
	 * 
	* @Function: 通过主键查询帖子信息
	* @Title: selectByPrimaryKey  
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 下午3:39:53
	* @Since JDK 1.8
	 */
	@RequestMapping(value="selectByPrimaryKey")
	@ResponseBody
	public Object selectByPrimaryKey(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		Post post = inBean.getPost();
		post = postService.selectByPrimaryKey(post);
		return PageBeanUtils.formatForNormalTrue("", post);
	}
	
	@RequestMapping(value="doDelete")
	@ResponseBody
	public Object doDelete(String dataInBean) throws Exception{
		DataInBean inBean = JSON.parseObject(dataInBean, DataInBean.class);
		Post post = inBean.getPost();
		post.setPostState(4);
		int flg = postService.doUpdateByPrimaryKeySelective(post);
		if(flg > 0){
			Follow follow = new Follow();
			follow.setFollowPostCuid(post.getPostCuid());
			flg = followService.doDeleteByAttribute(follow);
			if(flg >0){
				return PageBeanUtils.formatForNormalTrue("", "更新数据成功");
			}
		}
		return PageBeanUtils.formatForNormalFalse("", "更新数据失败,数据不存在");
	}
	
}
