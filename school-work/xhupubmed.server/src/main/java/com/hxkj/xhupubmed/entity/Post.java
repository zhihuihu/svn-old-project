package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:Post
 * Function:   帖子
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午1:36:51 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Post implements Serializable {

	private static final long serialVersionUID = 8962840967084598298L;

	//帖子CUID
	private String postCuid;

	//系统用户CUID'
    private String sysUserCuid;

    //帖子名称
    private String postName;

    //帖子图片
    private String postUrl;

    //帖子标题
    private String postTitle;

    //帖子内容
    private String postContent;

    //帖子所属类型
    private int postType;

    //帖子回帖总数
    private int postRepliesNumber;

    //帖子关注人总数
    private int postFollowPeopleNumber;

    //帖子创建地点
    private String postCreateAddress;

    //帖子状态
    private int postState;

    //帖子创建时间
    private String postCreateTime;

    //帖子更新时间
    private String postUpdateTime;

    private SysUser sysUser;
	public String getPostCuid() {
		return postCuid;
	}

	public void setPostCuid(String postCuid) {
		this.postCuid = postCuid;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	public String getPostTitle() {
		return postTitle;
	}

	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public int getPostType() {
		return postType;
	}

	public void setPostType(int postType) {
		this.postType = postType;
	}

	public int getPostRepliesNumber() {
		return postRepliesNumber;
	}

	public void setPostRepliesNumber(int postRepliesNumber) {
		this.postRepliesNumber = postRepliesNumber;
	}

	public int getPostFollowPeopleNumber() {
		return postFollowPeopleNumber;
	}

	public void setPostFollowPeopleNumber(int postFollowPeopleNumber) {
		this.postFollowPeopleNumber = postFollowPeopleNumber;
	}

	public String getPostCreateAddress() {
		return postCreateAddress;
	}

	public void setPostCreateAddress(String postCreateAddress) {
		this.postCreateAddress = postCreateAddress;
	}

	public int getPostState() {
		return postState;
	}

	public void setPostState(int postState) {
		this.postState = postState;
	}

	public String getPostCreateTime() {
		return postCreateTime;
	}

	public void setPostCreateTime(String postCreateTime) {
		this.postCreateTime = postCreateTime;
	}

	public String getPostUpdateTime() {
		return postUpdateTime;
	}

	public void setPostUpdateTime(String postUpdateTime) {
		this.postUpdateTime = postUpdateTime;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
    
    
}
