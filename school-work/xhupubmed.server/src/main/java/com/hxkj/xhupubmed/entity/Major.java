package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:Major
 * Function:   专业
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:56:36 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Major implements Serializable {

	private static final long serialVersionUID = 131568064824909767L;

	//专业CUID
	private String majorCuid;

	//学院CUID
    private String collegeCuid;

    //专业名称
    private String majorName;

    //专业CODE
    private String majorCode;

    //专业拥有学生总数
    private int majorStudentNumber;

    //专业状态
    private int majorState;

    //专业创建时间
    private String majorCreateTime;

    //专业更新时间
    private String majorUpdateTime;

	public String getMajorCuid() {
		return majorCuid;
	}

	public void setMajorCuid(String majorCuid) {
		this.majorCuid = majorCuid;
	}

	public String getCollegeCuid() {
		return collegeCuid;
	}

	public void setCollegeCuid(String collegeCuid) {
		this.collegeCuid = collegeCuid;
	}

	public String getMajorName() {
		return majorName;
	}

	public void setMajorName(String majorName) {
		this.majorName = majorName;
	}

	public String getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(String majorCode) {
		this.majorCode = majorCode;
	}

	public int getMajorStudentNumber() {
		return majorStudentNumber;
	}

	public void setMajorStudentNumber(int majorStudentNumber) {
		this.majorStudentNumber = majorStudentNumber;
	}

	public int getMajorState() {
		return majorState;
	}

	public void setMajorState(int majorState) {
		this.majorState = majorState;
	}

	public String getMajorCreateTime() {
		return majorCreateTime;
	}

	public void setMajorCreateTime(String majorCreateTime) {
		this.majorCreateTime = majorCreateTime;
	}

	public String getMajorUpdateTime() {
		return majorUpdateTime;
	}

	public void setMajorUpdateTime(String majorUpdateTime) {
		this.majorUpdateTime = majorUpdateTime;
	}
    
    
}
