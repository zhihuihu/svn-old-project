package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:LearnPlan
 * Function:   学习计划
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:54:22 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class LearnPlan implements Serializable {

	private static final long serialVersionUID = 6916441841015866511L;

	//学习计划CUID
	private String learnPlanCuid;

	//系统用户CUID
    private String sysUserCuid;

    //学习计划名称
    private String learnPlanName;

    //学习计划图标
    private String learnPlanUrl;

    //学习计划内容
    private String learnPlanContent;

    //学习计划开始时间
    private String learnPlanStartTime;

    //学习计划完成时间
    private String learnPlanEndTime;

    //学习计划状态
    private int learnPlanState;

    //学习计划创建时间
    private String learnPlanCreateTime;

    //学习计划更新时间
    private String learnPlanUpdateTime;

	public String getLearnPlanCuid() {
		return learnPlanCuid;
	}

	public void setLearnPlanCuid(String learnPlanCuid) {
		this.learnPlanCuid = learnPlanCuid;
	}

	public String getSysUserCuid() {
		return sysUserCuid;
	}

	public void setSysUserCuid(String sysUserCuid) {
		this.sysUserCuid = sysUserCuid;
	}

	public String getLearnPlanName() {
		return learnPlanName;
	}

	public void setLearnPlanName(String learnPlanName) {
		this.learnPlanName = learnPlanName;
	}

	public String getLearnPlanUrl() {
		return learnPlanUrl;
	}

	public void setLearnPlanUrl(String learnPlanUrl) {
		this.learnPlanUrl = learnPlanUrl;
	}

	public String getLearnPlanContent() {
		return learnPlanContent;
	}

	public void setLearnPlanContent(String learnPlanContent) {
		this.learnPlanContent = learnPlanContent;
	}

	public String getLearnPlanStartTime() {
		return learnPlanStartTime;
	}

	public void setLearnPlanStartTime(String learnPlanStartTime) {
		this.learnPlanStartTime = learnPlanStartTime;
	}

	public String getLearnPlanEndTime() {
		return learnPlanEndTime;
	}

	public void setLearnPlanEndTime(String learnPlanEndTime) {
		this.learnPlanEndTime = learnPlanEndTime;
	}

	public int getLearnPlanState() {
		return learnPlanState;
	}

	public void setLearnPlanState(int learnPlanState) {
		this.learnPlanState = learnPlanState;
	}

	public String getLearnPlanCreateTime() {
		return learnPlanCreateTime;
	}

	public void setLearnPlanCreateTime(String learnPlanCreateTime) {
		this.learnPlanCreateTime = learnPlanCreateTime;
	}

	public String getLearnPlanUpdateTime() {
		return learnPlanUpdateTime;
	}

	public void setLearnPlanUpdateTime(String learnPlanUpdateTime) {
		this.learnPlanUpdateTime = learnPlanUpdateTime;
	}
    
    
    
}
