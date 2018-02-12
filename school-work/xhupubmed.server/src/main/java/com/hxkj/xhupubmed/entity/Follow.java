package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:Follow
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:37:26 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Follow implements Serializable {

	private static final long serialVersionUID = 1027416612520882880L;

	//用户关注CUID
	private String followCuid;

	//系统用户CUID
    private String sysUserCuid;

    //用户关注名称
    private String followName;

    //用户关注图标
    private String followUrl;
    
    //用户关注帖子CUID
    private String followPostCuid;
    
    //用户关注开始时间
    private String followStartTime;

    //用户关注状态
    private int followState;

    //用户关注创建时间
    private String followCreateTime;

    //用户关注更新时间
    private String followUpdateTime;
    
    /**
     * 实体属性
     */
    private Post post;
    private SysUser sysUser;
	public String getFollowCuid() {
		return followCuid;
	}

	public void setFollowCuid(String followCuid) {
		this.followCuid = followCuid;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getFollowName() {
		return followName;
	}

	public void setFollowName(String followName) {
		this.followName = followName;
	}

	public String getFollowUrl() {
		return followUrl;
	}

	public void setFollowUrl(String followUrl) {
		this.followUrl = followUrl;
	}

	public String getFollowStartTime() {
		return followStartTime;
	}

	public void setFollowStartTime(String followStartTime) {
		this.followStartTime = followStartTime;
	}

	public int getFollowState() {
		return followState;
	}

	public void setFollowState(int followState) {
		this.followState = followState;
	}

	public String getFollowCreateTime() {
		return followCreateTime;
	}

	public void setFollowCreateTime(String followCreateTime) {
		this.followCreateTime = followCreateTime;
	}

	public String getFollowUpdateTime() {
		return followUpdateTime;
	}

	public void setFollowUpdateTime(String followUpdateTime) {
		this.followUpdateTime = followUpdateTime;
	}

	public String getFollowPostCuid() {
		return followPostCuid;
	}

	public void setFollowPostCuid(String followPostCuid) {
		this.followPostCuid = followPostCuid;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
    
    
}
