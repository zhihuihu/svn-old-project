package com.cqq.leisure.entity;

import java.io.Serializable;

/** 
 * ClassName:HolidayPlan
 * Function:   
 * Date:     2016年3月20日 下午7:48:02 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class HolidayPlan implements Serializable {

	private static final long serialVersionUID = 846762268994699022L;

	//假日方案ID
	private int holidayPlanId;

	//标签_ID
    private int tagId;

    //假日方案名称
    private String holidayPlanName;

    //假日方案图标
    private String holidayPlanIconUrl;

    //假日方案开始时间
    private String holidayPlanStartTime;

    //假日方案结束时间
    private String holidayPlanEndTime;

    //假日方案描述
    private String holidayPlanDesc;

    //假日方案内容图片
    private String holidayPlanImgUrl;

    //假日方案状态
    private int holidayPlanState;

    //假日方案设定时间
    private String holidayPlanCreateTime;

    //假日方案更新时间
    private String holidayPlanUpdateTime;

    //假日方案标签
    private String holidayPlayTag;

    //假日方案热度排序
    private int holidayPlaySort;

	public int getHolidayPlanId() {
		return holidayPlanId;
	}

	public void setHolidayPlanId(int holidayPlanId) {
		this.holidayPlanId = holidayPlanId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getHolidayPlanName() {
		return holidayPlanName;
	}

	public void setHolidayPlanName(String holidayPlanName) {
		this.holidayPlanName = holidayPlanName;
	}

	public String getHolidayPlanIconUrl() {
		return holidayPlanIconUrl;
	}

	public void setHolidayPlanIconUrl(String holidayPlanIconUrl) {
		this.holidayPlanIconUrl = holidayPlanIconUrl;
	}

	public String getHolidayPlanStartTime() {
		return holidayPlanStartTime;
	}

	public void setHolidayPlanStartTime(String holidayPlanStartTime) {
		this.holidayPlanStartTime = holidayPlanStartTime;
	}

	public String getHolidayPlanEndTime() {
		return holidayPlanEndTime;
	}

	public void setHolidayPlanEndTime(String holidayPlanEndTime) {
		this.holidayPlanEndTime = holidayPlanEndTime;
	}

	public String getHolidayPlanDesc() {
		return holidayPlanDesc;
	}

	public void setHolidayPlanDesc(String holidayPlanDesc) {
		this.holidayPlanDesc = holidayPlanDesc;
	}

	public String getHolidayPlanImgUrl() {
		return holidayPlanImgUrl;
	}

	public void setHolidayPlanImgUrl(String holidayPlanImgUrl) {
		this.holidayPlanImgUrl = holidayPlanImgUrl;
	}

	public int getHolidayPlanState() {
		return holidayPlanState;
	}

	public void setHolidayPlanState(int holidayPlanState) {
		this.holidayPlanState = holidayPlanState;
	}

	public String getHolidayPlanCreateTime() {
		return holidayPlanCreateTime;
	}

	public void setHolidayPlanCreateTime(String holidayPlanCreateTime) {
		this.holidayPlanCreateTime = holidayPlanCreateTime;
	}

	public String getHolidayPlanUpdateTime() {
		return holidayPlanUpdateTime;
	}

	public void setHolidayPlanUpdateTime(String holidayPlanUpdateTime) {
		this.holidayPlanUpdateTime = holidayPlanUpdateTime;
	}

	public String getHolidayPlayTag() {
		return holidayPlayTag;
	}

	public void setHolidayPlayTag(String holidayPlayTag) {
		this.holidayPlayTag = holidayPlayTag;
	}

	public int getHolidayPlaySort() {
		return holidayPlaySort;
	}

	public void setHolidayPlaySort(int holidayPlaySort) {
		this.holidayPlaySort = holidayPlaySort;
	}
    
    
}
