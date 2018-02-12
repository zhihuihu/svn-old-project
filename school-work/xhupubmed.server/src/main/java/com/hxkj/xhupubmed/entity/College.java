package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:College
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:35:33 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class College implements Serializable {

	private static final long serialVersionUID = -5390751334875997610L;

	//学院CUID
	private String collegeCuid;

	//学院名称
    private String collegeName;

    //学院CODE
    private String collegeCode;

    //学院专业数量
    private int collegeMajorNumber;

    //学院状态
    private int collegeState;

    //学院创建时间
    private String collegeCreateTime;

    //学院更新时间
    private String collegeUpdateTime;

	public String getCollegeCuid() {
		return collegeCuid;
	}

	public void setCollegeCuid(String collegeCuid) {
		this.collegeCuid = collegeCuid;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getCollegeCode() {
		return collegeCode;
	}

	public void setCollegeCode(String collegeCode) {
		this.collegeCode = collegeCode;
	}

	public int getCollegeMajorNumber() {
		return collegeMajorNumber;
	}

	public void setCollegeMajorNumber(int collegeMajorNumber) {
		this.collegeMajorNumber = collegeMajorNumber;
	}

	public int getCollegeState() {
		return collegeState;
	}

	public void setCollegeState(int collegeState) {
		this.collegeState = collegeState;
	}

	public String getCollegeCreateTime() {
		return collegeCreateTime;
	}

	public void setCollegeCreateTime(String collegeCreateTime) {
		this.collegeCreateTime = collegeCreateTime;
	}

	public String getCollegeUpdateTime() {
		return collegeUpdateTime;
	}

	public void setCollegeUpdateTime(String collegeUpdateTime) {
		this.collegeUpdateTime = collegeUpdateTime;
	}
    
    
}
