package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:Oppointment
 * Function:   约定表
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午1:28:05 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Oppointment implements Serializable {

	private static final long serialVersionUID = 4705102588229730473L;

	//约定表CUID
	private String oppointmentCuid;

	//教室CUID
    private String classroomCuid;

    //系统用户CUID
    private String sysUserCuid;

    //约定表名称    用户评论用了
    private String oppointmentName;

    //约定表用户登录名
    private String oppointmentUserName;

    //约定用户头像
    private String oppointmentUserUrl;

    //约定表状态
    private int oppointmentState;

    //约定表结束时间
    private String oppointmentEndTime;

    //约定表创建时间
    private String oppointmentCreateTime;

    //约定表更新时间
    private String oppointmentUpdateTime;

	public String getOppointmentCuid() {
		return oppointmentCuid;
	}

	public void setOppointmentCuid(String oppointmentCuid) {
		this.oppointmentCuid = oppointmentCuid;
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

	public String getOppointmentName() {
		return oppointmentName;
	}

	public void setOppointmentName(String oppointmentName) {
		this.oppointmentName = oppointmentName;
	}

	public String getOppointmentUserName() {
		return oppointmentUserName;
	}

	public void setOppointmentUserName(String oppointmentUserName) {
		this.oppointmentUserName = oppointmentUserName;
	}

	public String getOppointmentUserUrl() {
		return oppointmentUserUrl;
	}

	public void setOppointmentUserUrl(String oppointmentUserUrl) {
		this.oppointmentUserUrl = oppointmentUserUrl;
	}

	public int getOppointmentState() {
		return oppointmentState;
	}

	public void setOppointmentState(int oppointmentState) {
		this.oppointmentState = oppointmentState;
	}

	public String getOppointmentEndTime() {
		return oppointmentEndTime;
	}

	public void setOppointmentEndTime(String oppointmentEndTime) {
		this.oppointmentEndTime = oppointmentEndTime;
	}

	public String getOppointmentCreateTime() {
		return oppointmentCreateTime;
	}

	public void setOppointmentCreateTime(String oppointmentCreateTime) {
		this.oppointmentCreateTime = oppointmentCreateTime;
	}

	public String getOppointmentUpdateTime() {
		return oppointmentUpdateTime;
	}

	public void setOppointmentUpdateTime(String oppointmentUpdateTime) {
		this.oppointmentUpdateTime = oppointmentUpdateTime;
	}
    
    
}
