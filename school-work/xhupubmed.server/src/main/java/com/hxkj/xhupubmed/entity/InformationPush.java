package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:InformationPush
 * Function:   信息推送
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:48:07 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class InformationPush implements Serializable {

	private static final long serialVersionUID = 6604741366159362020L;

	//信息推送CUID
	private String informationPushCuid;

	//信息推送标题
    private String informationPushTitle;

    //信息推送内容
    private String informationPushContent;

    //信息推送创建人
    private String informationPushPeople;

    //信息推送URL
    private String informationPushUrl;

    //信息推送状态
    private int informationPushState;

    //信息推送创建时间
    private String informationPushCreateTime;

    //信息推送更新时间
    private String informationPushUpdateTime;

	public String getInformationPushCuid() {
		return informationPushCuid;
	}

	public void setInformationPushCuid(String informationPushCuid) {
		this.informationPushCuid = informationPushCuid;
	}

	public String getInformationPushTitle() {
		return informationPushTitle;
	}

	public void setInformationPushTitle(String informationPushTitle) {
		this.informationPushTitle = informationPushTitle;
	}

	public String getInformationPushContent() {
		return informationPushContent;
	}

	public void setInformationPushContent(String informationPushContent) {
		this.informationPushContent = informationPushContent;
	}

	public String getInformationPushPeople() {
		return informationPushPeople;
	}

	public void setInformationPushPeople(String informationPushPeople) {
		this.informationPushPeople = informationPushPeople;
	}

	public String getInformationPushUrl() {
		return informationPushUrl;
	}

	public void setInformationPushUrl(String informationPushUrl) {
		this.informationPushUrl = informationPushUrl;
	}

	public int getInformationPushState() {
		return informationPushState;
	}

	public void setInformationPushState(int informationPushState) {
		this.informationPushState = informationPushState;
	}

	public String getInformationPushCreateTime() {
		return informationPushCreateTime;
	}

	public void setInformationPushCreateTime(String informationPushCreateTime) {
		this.informationPushCreateTime = informationPushCreateTime;
	}

	public String getInformationPushUpdateTime() {
		return informationPushUpdateTime;
	}

	public void setInformationPushUpdateTime(String informationPushUpdateTime) {
		this.informationPushUpdateTime = informationPushUpdateTime;
	}
    
    
}
