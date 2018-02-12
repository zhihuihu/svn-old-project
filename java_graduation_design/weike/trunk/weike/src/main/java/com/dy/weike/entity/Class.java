package com.dy.weike.entity;

import java.io.Serializable;

/**
 * 课程类
 * @author d-y
 *
 */
public class Class implements Serializable {
	/**
	 * 创建课程类序列化ID
	 */
	private static final long serialVersionUID = 7620485893265741170L;
	/**
	 * 课程ID
	 */
    private int classId;
    /**
     * 课程名称
     */
    private String className;
    /**
     * 课程关键字
     */
    private String classKeyword;
    /**
     * 课程标签
     */
    private String classTag;
    /**
     * 课程开始时间
     */
    private String classStart;
    /**
     * 课程结束时间
     */
    private String classEnd;
    /**
     * 课程描述
     */
    private String classDescription;
    /**
     * 课程总课时数
     */
    private int classCount;
    /**
     * 课程星级
     */
    private int classStar;
    /**
     * 课程学习人数
     */
    private int classPerson;
    /**
     * 课程活跃度
     */
    private Integer classLiveness;
    /**
     * 课程状态
     */
    private Integer classState;
    /**
     * 课程导师---后期添加
     */
    private Integer UserId;
    
    /**
     * 课程图片
     */
    private String classImageUrl;
    
    /**
     * 课程竖图
     */
    private String classImageVerUrl;
    
    
    
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassKeyword() {
		return classKeyword;
	}
	public void setClassKeyword(String classKeyword) {
		this.classKeyword = classKeyword;
	}
	public String getClassTag() {
		return classTag;
	}
	public void setClassTag(String classTag) {
		this.classTag = classTag;
	}
	public String getClassStart() {
		return classStart;
	}
	public void setClassStart(String classStart) {
		this.classStart = classStart;
	}
	public String getClassEnd() {
		return classEnd;
	}
	public void setClassEnd(String classEnd) {
		this.classEnd = classEnd;
	}
	public String getClassDescription() {
		return classDescription;
	}
	public void setClassDescription(String classDescription) {
		this.classDescription = classDescription;
	}
	public int getClassCount() {
		return classCount;
	}
	public void setClassCount(int classCount) {
		this.classCount = classCount;
	}
	public int getClassStar() {
		return classStar;
	}
	public void setClassStar(int classStar) {
		this.classStar = classStar;
	}
	public int getClassPerson() {
		return classPerson;
	}
	public void setClassPerson(int classPerson) {
		this.classPerson = classPerson;
	}
	public Integer getClassLiveness() {
		return classLiveness;
	}
	public void setClassLiveness(Integer classLiveness) {
		this.classLiveness = classLiveness;
	}
	public Integer getClassState() {
		return classState;
	}
	public void setClassState(Integer classState) {
		this.classState = classState;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getClassImageUrl() {
		return classImageUrl;
	}
	public void setClassImageUrl(String classImageUrl) {
		this.classImageUrl = classImageUrl;
	}
	public String getClassImageVerUrl() {
		return classImageVerUrl;
	}
	public void setClassImageVerUrl(String classImageVerUrl) {
		this.classImageVerUrl = classImageVerUrl;
	}  
}
