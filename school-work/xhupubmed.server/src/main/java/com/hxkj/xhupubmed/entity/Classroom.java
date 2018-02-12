package com.hxkj.xhupubmed.entity;

import java.io.Serializable;
import java.util.List;

/** 
 * ClassName:Classroom
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:31:45 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Classroom implements Serializable {

	private static final long serialVersionUID = 8251689977120420067L;

	//教室CUID
	private String classroomCuid;

	//系统用户CUID'
    private String sysUserCuid;

    //教室名称
    private String classroomName;

    //教学楼号数
    private String classroomNumber;

    //教室编号
    private String classroomRoomNumber;

    //教室简介
    private String classroomIntroduction;

    //教室二维码
    private String classroomQrCode;

    //约定人总数
    private int classroomStudentNumber;

    //教室状态
    private int classroomState;

    //教室创建时间   当作了教室的开始的时间用
    private String classroomCreateTime;

    //教室更新时间    则是当作数据库创建时间
    private String classroomUpdateTime;

    //教室约定实体类
    private List<Oppointment> oppointments;
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

	public String getClassroomName() {
		return classroomName;
	}

	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}

	public String getClassroomNumber() {
		return classroomNumber;
	}

	public void setClassroomNumber(String classroomNumber) {
		this.classroomNumber = classroomNumber;
	}

	public String getClassroomRoomNumber() {
		return classroomRoomNumber;
	}

	public void setClassroomRoomNumber(String classroomRoomNumber) {
		this.classroomRoomNumber = classroomRoomNumber;
	}

	public String getClassroomIntroduction() {
		return classroomIntroduction;
	}

	public void setClassroomIntroduction(String classroomIntroduction) {
		this.classroomIntroduction = classroomIntroduction;
	}

	public String getClassroomQrCode() {
		return classroomQrCode;
	}

	public void setClassroomQrCode(String classroomQrCode) {
		this.classroomQrCode = classroomQrCode;
	}

	public int getClassroomStudentNumber() {
		return classroomStudentNumber;
	}

	public void setClassroomStudentNumber(int classroomStudentNumber) {
		this.classroomStudentNumber = classroomStudentNumber;
	}

	public int getClassroomState() {
		return classroomState;
	}

	public void setClassroomState(int classroomState) {
		this.classroomState = classroomState;
	}

	public String getClassroomCreateTime() {
		return classroomCreateTime;
	}

	public void setClassroomCreateTime(String classroomCreateTime) {
		this.classroomCreateTime = classroomCreateTime;
	}

	public String getClassroomUpdateTime() {
		return classroomUpdateTime;
	}

	public void setClassroomUpdateTime(String classroomUpdateTime) {
		this.classroomUpdateTime = classroomUpdateTime;
	}

	public List<Oppointment> getOppointments() {
		return oppointments;
	}

	public void setOppointments(List<Oppointment> oppointments) {
		this.oppointments = oppointments;
	}
    
    
}
