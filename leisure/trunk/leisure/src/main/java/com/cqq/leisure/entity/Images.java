package com.cqq.leisure.entity;

import java.io.Serializable;

/** 
 * ClassName:Images
 * Function:   
 * Date:     2016年3月20日 下午8:18:26 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Images implements Serializable {

	private static final long serialVersionUID = 3313126267081821994L;

	//图片ID
	private int imagesId;

	//假日方案ID
    private int holidayPlanId;

    //方案规划表ID
    private int programPlanId;

    //活动表ID
    private Integer activeId;

    //图片描述
    private String imagesDesc;

    //图片URL
    private String imagesUrl;

    //图片后续内容
    private String imagesSufContent;

    //图片状态
    private int imagesState;

    //图片创建时间
    private String imagesCreateTime;

	public int getImagesId() {
		return imagesId;
	}

	public void setImagesId(int imagesId) {
		this.imagesId = imagesId;
	}

	public int getHolidayPlanId() {
		return holidayPlanId;
	}

	public void setHolidayPlanId(int holidayPlanId) {
		this.holidayPlanId = holidayPlanId;
	}

	public int getProgramPlanId() {
		return programPlanId;
	}

	public void setProgramPlanId(int programPlanId) {
		this.programPlanId = programPlanId;
	}

	public Integer getActiveId() {
		return activeId;
	}

	public void setActiveId(Integer activeId) {
		this.activeId = activeId;
	}

	public String getImagesDesc() {
		return imagesDesc;
	}

	public void setImagesDesc(String imagesDesc) {
		this.imagesDesc = imagesDesc;
	}

	public String getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String imagesUrl) {
		this.imagesUrl = imagesUrl;
	}

	public String getImagesSufContent() {
		return imagesSufContent;
	}

	public void setImagesSufContent(String imagesSufContent) {
		this.imagesSufContent = imagesSufContent;
	}

	public int getImagesState() {
		return imagesState;
	}

	public void setImagesState(int imagesState) {
		this.imagesState = imagesState;
	}

	public String getImagesCreateTime() {
		return imagesCreateTime;
	}

	public void setImagesCreateTime(String imagesCreateTime) {
		this.imagesCreateTime = imagesCreateTime;
	}
    
    
    
	
}
