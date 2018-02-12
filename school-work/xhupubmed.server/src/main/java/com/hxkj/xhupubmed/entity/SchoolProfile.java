package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:SchoolProfile
 * Function:   考研学校简介
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午2:36:44 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class SchoolProfile implements Serializable {

	private static final long serialVersionUID = -453602266861964225L;

	//考研学校CUID
	private String schoolProfileCuid;

	//考研学校名称
    private String schoolProfileName;

    //考研学校IS_TOP
    private int schoolProfileIsTop;

    //考研学校标签
    private String schoolProfileTag;

    //考研学校代码
    private String schoolProfileCode;

    //考研学校创建时间
    private String schoolProfileScCreateTime;

    //考研学校基本资料
    private String schoolProfileBaseProfile;

    //考研学校详细介绍
    private String schoolProfileMainProfile;

    //考研学校最好专业
    private String schoolProfileBestMajor;

    //考研学校最好导师
    private String schoolProfileBestTeacher;

    //考研学校状态
    private int schoolProfileState;

    //考研学校系统创建时间
    private String schoolProfileCreateTime;

    //考研学校系统更新时间
    private String schoolProfileUpdateTime;

	public String getSchoolProfileCuid() {
		return schoolProfileCuid;
	}

	public void setSchoolProfileCuid(String schoolProfileCuid) {
		this.schoolProfileCuid = schoolProfileCuid;
	}

	public String getSchoolProfileName() {
		return schoolProfileName;
	}

	public void setSchoolProfileName(String schoolProfileName) {
		this.schoolProfileName = schoolProfileName;
	}

	public int getSchoolProfileIsTop() {
		return schoolProfileIsTop;
	}

	public void setSchoolProfileIsTop(int schoolProfileIsTop) {
		this.schoolProfileIsTop = schoolProfileIsTop;
	}

	public String getSchoolProfileTag() {
		return schoolProfileTag;
	}

	public void setSchoolProfileTag(String schoolProfileTag) {
		this.schoolProfileTag = schoolProfileTag;
	}

	public String getSchoolProfileCode() {
		return schoolProfileCode;
	}

	public void setSchoolProfileCode(String schoolProfileCode) {
		this.schoolProfileCode = schoolProfileCode;
	}

	public String getSchoolProfileScCreateTime() {
		return schoolProfileScCreateTime;
	}

	public void setSchoolProfileScCreateTime(String schoolProfileScCreateTime) {
		this.schoolProfileScCreateTime = schoolProfileScCreateTime;
	}

	public String getSchoolProfileBaseProfile() {
		return schoolProfileBaseProfile;
	}

	public void setSchoolProfileBaseProfile(String schoolProfileBaseProfile) {
		this.schoolProfileBaseProfile = schoolProfileBaseProfile;
	}

	public String getSchoolProfileMainProfile() {
		return schoolProfileMainProfile;
	}

	public void setSchoolProfileMainProfile(String schoolProfileMainProfile) {
		this.schoolProfileMainProfile = schoolProfileMainProfile;
	}

	public String getSchoolProfileBestMajor() {
		return schoolProfileBestMajor;
	}

	public void setSchoolProfileBestMajor(String schoolProfileBestMajor) {
		this.schoolProfileBestMajor = schoolProfileBestMajor;
	}

	public String getSchoolProfileBestTeacher() {
		return schoolProfileBestTeacher;
	}

	public void setSchoolProfileBestTeacher(String schoolProfileBestTeacher) {
		this.schoolProfileBestTeacher = schoolProfileBestTeacher;
	}

	public int getSchoolProfileState() {
		return schoolProfileState;
	}

	public void setSchoolProfileState(int schoolProfileState) {
		this.schoolProfileState = schoolProfileState;
	}

	public String getSchoolProfileCreateTime() {
		return schoolProfileCreateTime;
	}

	public void setSchoolProfileCreateTime(String schoolProfileCreateTime) {
		this.schoolProfileCreateTime = schoolProfileCreateTime;
	}

	public String getSchoolProfileUpdateTime() {
		return schoolProfileUpdateTime;
	}

	public void setSchoolProfileUpdateTime(String schoolProfileUpdateTime) {
		this.schoolProfileUpdateTime = schoolProfileUpdateTime;
	}
    
    
}
