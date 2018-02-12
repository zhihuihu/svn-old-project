package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:FollowPost
 * Function:   用户关注帖子多对多表
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:39:48 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class FollowPost implements Serializable {

	private static final long serialVersionUID = 1334736337282806610L;

	//帖子CUID
	private String postCuid;

	//用户关注CUID
    private String followCuid;
    
    //用户关注总人数
    private int followPostNumber;

	public String getPostCuid() {
		return postCuid;
	}

	public void setPostCuid(String postCuid) {
		this.postCuid = postCuid;
	}

	public String getFollowCuid() {
		return followCuid;
	}

	public void setFollowCuid(String followCuid) {
		this.followCuid = followCuid;
	}

	public int getFollowPostNumber() {
		return followPostNumber;
	}

	public void setFollowPostNumber(int followPostNumber) {
		this.followPostNumber = followPostNumber;
	}
    
    
    
}
