package com.hxkj.xhupubmed.entity.pojo;

import com.hxkj.xhupubmed.entity.Classroom;
import com.hxkj.xhupubmed.entity.DataSharing;
import com.hxkj.xhupubmed.entity.Follow;
import com.hxkj.xhupubmed.entity.Friend;
import com.hxkj.xhupubmed.entity.InformationPush;
import com.hxkj.xhupubmed.entity.IntelligentMessage;
import com.hxkj.xhupubmed.entity.KeyLog;
import com.hxkj.xhupubmed.entity.LearnPlan;
import com.hxkj.xhupubmed.entity.Oppointment;
import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.entity.Replies;
import com.hxkj.xhupubmed.entity.SchoolInformation;
import com.hxkj.xhupubmed.entity.SchoolProfile;
import com.hxkj.xhupubmed.entity.SysUser;

/** 
 * ClassName:DataInBean
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月12日 下午7:45:47 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class DataInBean {

	/**
	 * 为用户保存的token
	 */
	private String token;
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 一页大小
	 */
	private int lineSize;
	
	private String startTime;
	
	private String endTime;
	
	private String searchName;
	
	private String searchName2;
	
	private String searchName3;
	
	//实体
	/**
	 * 用户实体类
	 */
	private SysUser sysUser;
	
	/**
	 * 帖子类
	 */
	private Post post;
	
	/**
	 * 回复帖子消息
	 */
	private Replies replies;
	
	/**
	 * 学习计划实体
	 */
	private LearnPlan learnPlan;
	
	/**
	 * 考研教室实体
	 */
	private Classroom classroom;
	
	/**
	 * 好友实体
	 */
	private Friend friend;
	
	/**
	 * 智能聊天信息
	 */
	private IntelligentMessage intelligentMessage;
	
	/**
	 * 信息推送实体类
	 */
	private InformationPush informationPush;
	
	/**
	 * 教室预约,多对多的表
	 */
	private Oppointment oppointment;
	
	/**
	 * 资料共享
	 */
	private DataSharing dataSharing;
	
	/**
	 * 用户帖子收藏
	 */
	private Follow follow;
	
	/**
	 * 学校简介
	 */
	private SchoolProfile schoolProfile;
	
	/**
	 * 学校详细资料
	 */
	private SchoolInformation schoolInformation;
	
	private KeyLog keyLog;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLineSize() {
		return lineSize;
	}
	public void setLineSize(int lineSize) {
		this.lineSize = lineSize;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public Replies getReplies() {
		return replies;
	}
	public void setReplies(Replies replies) {
		this.replies = replies;
	}
	public LearnPlan getLearnPlan() {
		return learnPlan;
	}
	public void setLearnPlan(LearnPlan learnPlan) {
		this.learnPlan = learnPlan;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	public Friend getFriend() {
		return friend;
	}
	public void setFriend(Friend friend) {
		this.friend = friend;
	}
	public IntelligentMessage getIntelligentMessage() {
		return intelligentMessage;
	}
	public void setIntelligentMessage(IntelligentMessage intelligentMessage) {
		this.intelligentMessage = intelligentMessage;
	}
	public InformationPush getInformationPush() {
		return informationPush;
	}
	public void setInformationPush(InformationPush informationPush) {
		this.informationPush = informationPush;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	public Oppointment getOppointment() {
		return oppointment;
	}
	public void setOppointment(Oppointment oppointment) {
		this.oppointment = oppointment;
	}
	public DataSharing getDataSharing() {
		return dataSharing;
	}
	public void setDataSharing(DataSharing dataSharing) {
		this.dataSharing = dataSharing;
	}
	public Follow getFollow() {
		return follow;
	}
	public void setFollow(Follow follow) {
		this.follow = follow;
	}
	public SchoolProfile getSchoolProfile() {
		return schoolProfile;
	}
	public void setSchoolProfile(SchoolProfile schoolProfile) {
		this.schoolProfile = schoolProfile;
	}
	public SchoolInformation getSchoolInformation() {
		return schoolInformation;
	}
	public void setSchoolInformation(SchoolInformation schoolInformation) {
		this.schoolInformation = schoolInformation;
	}
	public String getSearchName2() {
		return searchName2;
	}
	public void setSearchName2(String searchName2) {
		this.searchName2 = searchName2;
	}
	public String getSearchName3() {
		return searchName3;
	}
	public void setSearchName3(String searchName3) {
		this.searchName3 = searchName3;
	}
	public KeyLog getKeyLog() {
		return keyLog;
	}
	public void setKeyLog(KeyLog keyLog) {
		this.keyLog = keyLog;
	}
	
	
}
