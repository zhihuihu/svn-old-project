package com.dy.weike.entity;

import java.io.Serializable;

/**
 * 作业类
 * @author d-y
 *
 */
public class Exam implements Serializable {
	/**
	 * 创建作业类的序列化ID
	 */
	private static final long serialVersionUID = 8870599555947640201L;
	/**
	 * 作业ID
	 */
	private int examId;
	/**
	 * 课程ID
	 */
    private int classId;
    /**
     * 作业题目
     */
    private String examName;
    /**
     * 作业答案url
     */
    private String examAns;
    /**
     * 作业经验值
     */
    private int examValue;
    /**
     * 作业状态
     */
    private int examState;
    /**
     * 作业创建时间
     */
    private String examCreatetime;
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExamAns() {
		return examAns;
	}
	public void setExamAns(String examAns) {
		this.examAns = examAns;
	}
	public int getExamValue() {
		return examValue;
	}
	public void setExamValue(int examValue) {
		this.examValue = examValue;
	}
	public int getExamState() {
		return examState;
	}
	public void setExamState(int examState) {
		this.examState = examState;
	}
	public String getExamCreatetime() {
		return examCreatetime;
	}
	public void setExamCreatetime(String examCreatetime) {
		this.examCreatetime = examCreatetime;
	}
    
    
    
	

}
