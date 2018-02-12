package com.hxkj.xhupubmed.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.entity.Classroom;
import com.hxkj.xhupubmed.entity.DataSharing;
import com.hxkj.xhupubmed.entity.InformationPush;
import com.hxkj.xhupubmed.entity.IntelligentMessage;
import com.hxkj.xhupubmed.entity.LearnPlan;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.entity.Replies;
import com.hxkj.xhupubmed.entity.SchoolInformation;
import com.hxkj.xhupubmed.entity.SchoolProfile;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.service.impl.ClassroomService;
import com.hxkj.xhupubmed.service.impl.DataSharingService;
import com.hxkj.xhupubmed.service.impl.InformationPushService;
import com.hxkj.xhupubmed.service.impl.IntelligentMessageService;
import com.hxkj.xhupubmed.service.impl.LearnPlanService;
import com.hxkj.xhupubmed.service.impl.PostService;
import com.hxkj.xhupubmed.service.impl.RepliesService;
import com.hxkj.xhupubmed.service.impl.SchoolInformationService;
import com.hxkj.xhupubmed.service.impl.SchoolProfileService;
import com.hxkj.xhupubmed.service.impl.SysUserService;

/** 
 * ClassName:PublicDataController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月21日 下午3:49:47 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="admin/publicData")
public class AdminPublicDataController {

	@Resource
	private PostService postService;
	@Resource
	private RepliesService repliesService;
	@Resource
	private SysUserService sysUserService;
	@Resource
	private DataSharingService dataSharingService;
	@Resource
	private IntelligentMessageService intelligentMessageService;
	@Resource
	private InformationPushService informationPushService;
	@Resource
	private SchoolInformationService schoolInformationService;
	@Resource
	private SchoolProfileService schoolProfileService;
	@Resource
	private LearnPlanService learnPlanService;
	@Resource
	private ClassroomService classroomService;
	
	@RequestMapping(value="selectBaseInfo")
	@ResponseBody
	public Object selectBaseInfo() throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		PageBean<Replies> pageBean = new PageBean<>(1, 1);
		pageBean.setInVo(new Replies());
		map.put("show1", repliesService.selectByAttributeCountAnd(pageBean));
		Replies replies = new Replies();
		replies.setRepliesCreateTime(TimeUtils.getMySqlFormatTime().substring(0, 10));
		pageBean.setInVo(replies);
		map.put("show2", repliesService.selectByAttributeCountAnd(pageBean));
		
		PageBean<Post> pageBean2 = new PageBean<>(1, 1);
		pageBean2.setInVo(new Post());
		map.put("show3", postService.selectByAttributeCountAnd(pageBean2));
		Post post = new Post();
		post.setPostCreateTime(TimeUtils.getMySqlFormatTime().substring(0, 10));
		pageBean2.setInVo(post);
		map.put("show4", postService.selectByAttributeCountAnd(pageBean2));
		
		PageBean<SysUser> pageBean3 = new PageBean<>(1, 10);
		pageBean3.setInVo(new SysUser());
		map.put("show5", sysUserService.selectByAttributeCountAnd(pageBean3));
		
		PageBean<DataSharing> pageBean4 = new PageBean<>(1, 10);
		pageBean4.setInVo(new DataSharing());
		map.put("show6", dataSharingService.selectByAttributeCountAnd(pageBean4));
		
		PageBean<IntelligentMessage> pageBean5 = new PageBean<>(1, 10);
		pageBean5.setInVo(new IntelligentMessage());
		map.put("show7", intelligentMessageService.selectByAttributeCountAnd(pageBean5));
		
		PageBean<InformationPush> pageBean6 = new PageBean<>(1, 10);
		pageBean6.setInVo(new InformationPush());
		map.put("show8", informationPushService.selectByAttributeCountAnd(pageBean6));
		
		PageBean<SchoolProfile> pageBean7 = new PageBean<>(1, 10);
		pageBean7.setInVo(new SchoolProfile());
		map.put("show9", schoolProfileService.selectByAttributeCountAnd(pageBean7));
		
		PageBean<SchoolInformation> pageBean8 = new PageBean<>(1, 10);
		pageBean8.setInVo(new SchoolInformation());
		map.put("show10", schoolInformationService.selectByAttributeCountAnd(pageBean8));
		
		PageBean<LearnPlan> pageBean9 = new PageBean<>(1, 10);
		pageBean9.setInVo(new LearnPlan());
		map.put("show11", learnPlanService.selectByAttributeCountAnd(pageBean9));
		
		PageBean<Classroom> pageBean10 = new PageBean<>(1, 10);
		pageBean10.setInVo(new Classroom());
		map.put("show12", classroomService.selectByAttributeCountAnd(pageBean10));
		return map;
	}
}
