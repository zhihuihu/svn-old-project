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
import com.hxkj.xhupubmed.entity.Follow;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;
import com.hxkj.xhupubmed.service.impl.FollowService;
import com.hxkj.xhupubmed.service.impl.PostService;

@Controller
@RequestMapping(value="client/post")
public class ClientPostController {

	@Resource
	private PostService postService;
	@Resource
	private FollowService followService;
	/**
	 * 
	* @Function: 用户增加一个帖子
	* @Title: doInsert 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月5日 下午8:03:23
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doInsert",method=RequestMethod.GET)
	@ResponseBody
	public Object doInsert(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		Post post = inBean.getPost();
		post.setSysUserCuid(sysUser.getSysUserCuid());
		post.setPostUrl("");
		post.setPostType(2);
		post.setPostCreateTime(TimeUtils.getMySqlFormatTime());
		post.setPostUpdateTime(TimeUtils.getMySqlFormatTime());
		post.setPostState(1);
		postService.doInsert(post);
		return PageBeanUtils.formatForNormalTrue("", post);
	}
	
	/**
	 * 
	* @Function: 用户搜索帖子方法  通用
	* @Title: selectAllByPage 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月5日 下午8:38:30
	* @Since JDK 1.8
	 */
	@RequestMapping(value="normal/selectAllByPage",method=RequestMethod.GET)
	@ResponseBody
	public Object selectAllByPage(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Post post = inBean.getPost();
		PageBean<Post> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(post);
		pageBean.setOrderByString("ORDER BY POST_UPDATE_TIME DESC");
		return postService.selectByAttributeAnd(pageBean);
	}
	
	/**
	 * 
	* @Function: 通过主键查询帖子信息
	* @Title: selectByPrimaryKey 
	* @param @param request
	* @param @param response
	* @param @param dataInBean
	* @param @return
	* @param @throws Exception     
	* @return Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月5日 下午9:26:42
	* @Since JDK 1.8
	 */
	@RequestMapping(value="normal/selectByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Post post = inBean.getPost();
		return postService.selectByPrimaryKey(post);
	}
	
	
	/**
	 * 
	* @Function: 用户查询自己的帖子 分页查询
	* @Title: selectByAttributeAnd  
	* @param request
	* @param response
	* @param dataInBean
	* @param token
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 下午1:06:34
	* @Since JDK 1.8
	 */
	@RequestMapping(value="normal/selectByAttributeAnd",method=RequestMethod.GET)
	@ResponseBody
	public Object selectByAttributeAnd(HttpServletRequest request,HttpServletResponse response,String dataInBean,String token) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		SysUser sysUser = RedisUtils.get(token, SysUser.class);
		if(sysUser == null){
			return PageBeanUtils.formatForNormalFalse("", "登录过期,请重新登录");
		}
		Post post = inBean.getPost();
		post.setSysUserCuid(sysUser.getSysUserCuid());
		PageBean<Post> pageBean = new PageBean<>(inBean.getCurrentPage(), inBean.getLineSize());
		pageBean.setInVo(post);
		pageBean.setOrderByString("ORDER BY POST_UPDATE_TIME DESC");
		return postService.selectByAttributeAnd(pageBean);
	}
	
	
	/**
	 * 
	* @Function: 用户删除帖子
	* @Title: doDeleteByPrimaryKey  
	* @param request
	* @param response
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年5月5日 下午1:10:26
	* @Since JDK 1.8
	 */
	@RequestMapping(value="normal/doDeleteByPrimaryKey",method=RequestMethod.GET)
	@ResponseBody
	public Object doDeleteByPrimaryKey(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Post post = inBean.getPost();
		int flg = postService.doDeleteByPrimaryKey(post);
		if(flg == 1){
			return PageBeanUtils.formatForNormalTrue("", "删除成功");
		}
		return PageBeanUtils.formatForNormalFalse("", "帖子不存在,删除失败");
	}
	
	@RequestMapping(value="doInsertImages")
	@ResponseBody
	public Object doInsertImages(HttpServletRequest request,String postCuid) throws Exception{
		return postService.doInsertImages(request, postCuid);
	}
	
	/**
	 * 
	* @Function: app做删除方法使用
	* @Title: doUpdate  
	* @param request
	* @param response
	* @param dataInBean
	* @return
	* @throws Exception   
	* Object    
	* @author huzhihui_c@qq.com   
	* @date 2016年6月2日 下午3:05:34
	* @Since JDK 1.8
	 */
	@RequestMapping(value="doUpdate")
	@ResponseBody
	public Object doUpdate(HttpServletRequest request,HttpServletResponse response,String dataInBean) throws Exception{
		DataInBean inBean = ParameterUtils.getDataInBeanFromPage(dataInBean);
		Post post = inBean.getPost();
		int flg = postService.doUpdateByPrimaryKeySelective(post);
		if(flg > 0){
			Follow follow = new Follow();
			follow.setFollowPostCuid(post.getPostCuid());
			flg = followService.doDeleteByAttribute(follow);
			if(flg >0){
				return PageBeanUtils.formatForNormalTrue("", "更新成功");
			}
		}
		return PageBeanUtils.formatForNormalFalse("", "帖子不存在,更新失败");
	}
}
