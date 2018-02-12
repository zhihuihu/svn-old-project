package com.cqq.leisure.entity;

import java.io.Serializable;

/** 
 * ClassName:ProgramPlan
 * Function:   方案规划表
 * Date:     2016年3月20日 下午8:48:20 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class ProgramPlan implements Serializable {

	private static final long serialVersionUID = -749030993999611533L;

	//方案规划表ID
	private int programPlanId;

	//假日方案ID
    private int holidayPlanId;

    //方案规划表名称
    private String programPlanName;

    //方案规划表图标
    private String programPlanIconUrl;

    //方案规划表类型
    private String programPlanType;

    //方案规划表开始时间
    private String programPlanStartTime;

    //方案规划表结束时间
    private String programPlanEndTime;

    //方案规划表地点
    private String programPlanAddress;

    //方案规划表具体内容
    private String programPlanMainContent;

    //方案规划表排序
    private int programPlanSort;
    
    //方案规划表状态
    private int programPlanState;

   //方案规划表创建时间
    private String programPlanCreateTime;

    //方案规划表更新时间
    private String programPlanUpdateTime;

	public int getProgramPlanId() {
		return programPlanId;
	}

	public void setProgramPlanId(int programPlanId) {
		this.programPlanId = programPlanId;
	}

	public int getHolidayPlanId() {
		return holidayPlanId;
	}

	public void setHolidayPlanId(int holidayPlanId) {
		this.holidayPlanId = holidayPlanId;
	}

	public String getProgramPlanName() {
		return programPlanName;
	}

	public void setProgramPlanName(String programPlanName) {
		this.programPlanName = programPlanName;
	}

	public String getProgramPlanIconUrl() {
		return programPlanIconUrl;
	}

	public void setProgramPlanIconUrl(String programPlanIconUrl) {
		this.programPlanIconUrl = programPlanIconUrl;
	}

	public String getProgramPlanType() {
		return programPlanType;
	}

	public void setProgramPlanType(String programPlanType) {
		this.programPlanType = programPlanType;
	}

	public String getProgramPlanStartTime() {
		return programPlanStartTime;
	}

	public void setProgramPlanStartTime(String programPlanStartTime) {
		this.programPlanStartTime = programPlanStartTime;
	}

	public String getProgramPlanEndTime() {
		return programPlanEndTime;
	}

	public void setProgramPlanEndTime(String programPlanEndTime) {
		this.programPlanEndTime = programPlanEndTime;
	}

	public String getProgramPlanAddress() {
		return programPlanAddress;
	}

	public void setProgramPlanAddress(String programPlanAddress) {
		this.programPlanAddress = programPlanAddress;
	}

	public String getProgramPlanMainContent() {
		return programPlanMainContent;
	}

	public void setProgramPlanMainContent(String programPlanMainContent) {
		this.programPlanMainContent = programPlanMainContent;
	}

	public int getProgramPlanSort() {
		return programPlanSort;
	}

	public void setProgramPlanSort(int programPlanSort) {
		this.programPlanSort = programPlanSort;
	}

	public int getProgramPlanState() {
		return programPlanState;
	}

	public void setProgramPlanState(int programPlanState) {
		this.programPlanState = programPlanState;
	}

	public String getProgramPlanCreateTime() {
		return programPlanCreateTime;
	}

	public void setProgramPlanCreateTime(String programPlanCreateTime) {
		this.programPlanCreateTime = programPlanCreateTime;
	}

	public String getProgramPlanUpdateTime() {
		return programPlanUpdateTime;
	}

	public void setProgramPlanUpdateTime(String programPlanUpdateTime) {
		this.programPlanUpdateTime = programPlanUpdateTime;
	}
	
	
}
