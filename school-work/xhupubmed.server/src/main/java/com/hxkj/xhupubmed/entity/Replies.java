package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:Replies
 * Function:   回帖
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午1:40:24 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Replies implements Serializable {

	private static final long serialVersionUID = -840139469033180474L;

	//回帖CUID
	private String repliesCuid;

	//帖子CUID
    private String postCuid;

    //教室CUID
    private String classroomCuid;

    //系统用户CUID
    private String sysUserCuid;

    //回帖标题
    private String repliesTitle;

    //回帖内容
    private String repliesContent;

    //回帖状态
    private int repliesState;

    //回帖时间
    private String repliesTime;

    //回帖地点
    private String repliesAddress;

    //回帖创建时间
    private String repliesCreateTime;

    //回帖更新时间
    private String repliesUpdateTime;
    
    //实体属性
    //系统用户实体
    private SysUser sysUser;
    
    //帖子实体属性
    private Post post;
    
    //预约教室属性
    private Classroom classroom;
	public String getRepliesCuid() {
		return repliesCuid;
	}

	public void setRepliesCuid(String repliesCuid) {
		this.repliesCuid = repliesCuid;
	}

	public String getPostCuid() {
		return postCuid;
	}

	public void setPostCuid(String postCuid) {
		this.postCuid = postCuid;
	}

	public String getClassroomCuid() {
		return classroomCuid;
	}

	public void setClassroomCuid(String classroomCuid) {
		this.classroomCuid = classroomCuid;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getRepliesTitle() {
		return repliesTitle;
	}

	public void setRepliesTitle(String repliesTitle) {
		this.repliesTitle = repliesTitle;
	}

	public String getRepliesContent() {
		return repliesContent;
	}

	public void setRepliesContent(String repliesContent) {
		this.repliesContent = repliesContent;
	}

	public int getRepliesState() {
		return repliesState;
	}

	public void setRepliesState(int repliesState) {
		this.repliesState = repliesState;
	}

	public String getRepliesTime() {
		return repliesTime;
	}

	public void setRepliesTime(String repliesTime) {
		this.repliesTime = repliesTime;
	}

	public String getRepliesAddress() {
		return repliesAddress;
	}

	public void setRepliesAddress(String repliesAddress) {
		this.repliesAddress = repliesAddress;
	}

	public String getRepliesCreateTime() {
		return repliesCreateTime;
	}

	public void setRepliesCreateTime(String repliesCreateTime) {
		this.repliesCreateTime = repliesCreateTime;
	}

	public String getRepliesUpdateTime() {
		return repliesUpdateTime;
	}

	public void setRepliesUpdateTime(String repliesUpdateTime) {
		this.repliesUpdateTime = repliesUpdateTime;
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

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
    
    
}
