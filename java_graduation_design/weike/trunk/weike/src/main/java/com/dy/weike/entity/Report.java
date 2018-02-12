package com.dy.weike.entity;

import java.io.Serializable;

/**
 * 举报类
 * @author d-y
 *
 */
public class Report implements Serializable {
	/**
	 * 创建举报类的序列化ID
	 */
	private static final long serialVersionUID = 7054936914952064899L;
	/**
	 * 举报表id
	 */
	private int reportId;

	/**
	 * 问答id
	 */
    private int askId;

    /**
     * 举报人id
     */
    private int reporterId;

    /**
     * 举报时间
     */
    private String reportTime;

    /**
     * 举报原因
     */
    private String reportReason;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getAskId() {
		return askId;
	}

	public void setAskId(int askId) {
		this.askId = askId;
	}

	public int getReporterId() {
		return reporterId;
	}

	public void setReporterId(int reporterId) {
		this.reporterId = reporterId;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public String getReportReason() {
		return reportReason;
	}

	public void setReportReason(String reportReason) {
		this.reportReason = reportReason;
	}
    
    
}
