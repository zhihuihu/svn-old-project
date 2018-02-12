package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:SchoolInformation
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午2:33:58 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class SchoolInformation implements Serializable {

	private static final long serialVersionUID = -4335002033823021157L;

	//学校最新资料CUID
	private String schoolInformationCuid;

	//考研学校CUID
    private String schoolProfileCuid;

    //学校最新资料标题
    private String schoolInformationTitle;

    //学校最新资料标签
    private String schoolInformationTag;

    //学校最新资料类型
    private int schoolInformationType;

    //学校最新资料主要内容
    private String schoolInformationMainContent;

    //学校最新资料提示
    private String schoolInformationNotes;

    //学校最新资料IS_TOP
    private int schoolInformationIsTop;

    //学校最新资料状态
    private int schoolInformationState;

    //学校最新资料创建时间
    private String schoolInformationCreateTime;

    //学校最新资料更新时间
    private String schoolInformationUpdateTime;

    //实体属性
    private SchoolProfile schoolProfile;
	public String getSchoolInformationCuid() {
		return schoolInformationCuid;
	}

	public void setSchoolInformationCuid(String schoolInformationCuid) {
		this.schoolInformationCuid = schoolInformationCuid;
	}

	public String getSchoolProfileCuid() {
		return schoolProfileCuid;
	}

	public void setSchoolProfileCuid(String schoolProfileCuid) {
		this.schoolProfileCuid = schoolProfileCuid;
	}

	public String getSchoolInformationTitle() {
		return schoolInformationTitle;
	}

	public void setSchoolInformationTitle(String schoolInformationTitle) {
		this.schoolInformationTitle = schoolInformationTitle;
	}

	public String getSchoolInformationTag() {
		return schoolInformationTag;
	}

	public void setSchoolInformationTag(String schoolInformationTag) {
		this.schoolInformationTag = schoolInformationTag;
	}

	public int getSchoolInformationType() {
		return schoolInformationType;
	}

	public void setSchoolInformationType(int schoolInformationType) {
		this.schoolInformationType = schoolInformationType;
	}

	public String getSchoolInformationMainContent() {
		return schoolInformationMainContent;
	}

	public void setSchoolInformationMainContent(String schoolInformationMainContent) {
		this.schoolInformationMainContent = schoolInformationMainContent;
	}

	public String getSchoolInformationNotes() {
		return schoolInformationNotes;
	}

	public void setSchoolInformationNotes(String schoolInformationNotes) {
		this.schoolInformationNotes = schoolInformationNotes;
	}

	public int getSchoolInformationIsTop() {
		return schoolInformationIsTop;
	}

	public void setSchoolInformationIsTop(int schoolInformationIsTop) {
		this.schoolInformationIsTop = schoolInformationIsTop;
	}

	public int getSchoolInformationState() {
		return schoolInformationState;
	}

	public void setSchoolInformationState(int schoolInformationState) {
		this.schoolInformationState = schoolInformationState;
	}

	public String getSchoolInformationCreateTime() {
		return schoolInformationCreateTime;
	}

	public void setSchoolInformationCreateTime(String schoolInformationCreateTime) {
		this.schoolInformationCreateTime = schoolInformationCreateTime;
	}

	public String getSchoolInformationUpdateTime() {
		return schoolInformationUpdateTime;
	}

	public void setSchoolInformationUpdateTime(String schoolInformationUpdateTime) {
		this.schoolInformationUpdateTime = schoolInformationUpdateTime;
	}

	public SchoolProfile getSchoolProfile() {
		return schoolProfile;
	}

	public void setSchoolProfile(SchoolProfile schoolProfile) {
		this.schoolProfile = schoolProfile;
	}
    
    
}
