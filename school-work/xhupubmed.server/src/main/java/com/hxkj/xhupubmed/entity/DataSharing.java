package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:DataSharing
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午2:30:32 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class DataSharing implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = -5428306385010938092L;

	//资料共享CUID
	private String dataSharingCuid;

	//资料共享人
    private String dataSharingSysUserCuid;

    //资料共享标题
    private String dataSharingTitle;

    //资料共享类型
    private int dataSharingType;

    //资料共享标签
    private String dataSharingTag;

    //资料共享状态
    private int dataSharingState;

    //资料共享发表时间
    private String dataSharingShCreateTime;

    //资料共享主要内容
    private String dataSharingMainContent;

    //资料共享URL	作为了第一个链接,让用户自己输入
    private String dataSharingUrl;

    //资料共享文件URL1
    private String dataSharingFileUrl1;

    //资料共享文件URL2'
    private String dataSharingFileUrl2;

    //资料共享文件URL3
    private String dataSharingFileUrl3;

    //资料共享文件URL4
    private String dataSharingFileUrl4;

    //资料共享创建时间
    private String dataSharingCreateTime;

    //资料共享更新时间
    private String dataSharingUpdateTime;

    //用户实体类属性
    private SysUser sysUser;
	public String getDataSharingCuid() {
		return dataSharingCuid;
	}

	public void setDataSharingCuid(String dataSharingCuid) {
		this.dataSharingCuid = dataSharingCuid;
	}

	public String getDataSharingSysUserCuid() {
		return dataSharingSysUserCuid;
	}

	public void setDataSharingSysUserCuid(String dataSharingSysUserCuid) {
		this.dataSharingSysUserCuid = dataSharingSysUserCuid;
	}

	public String getDataSharingTitle() {
		return dataSharingTitle;
	}

	public void setDataSharingTitle(String dataSharingTitle) {
		this.dataSharingTitle = dataSharingTitle;
	}

	public int getDataSharingType() {
		return dataSharingType;
	}

	public void setDataSharingType(int dataSharingType) {
		this.dataSharingType = dataSharingType;
	}

	public String getDataSharingTag() {
		return dataSharingTag;
	}

	public void setDataSharingTag(String dataSharingTag) {
		this.dataSharingTag = dataSharingTag;
	}

	public int getDataSharingState() {
		return dataSharingState;
	}

	public void setDataSharingState(int dataSharingState) {
		this.dataSharingState = dataSharingState;
	}

	public String getDataSharingShCreateTime() {
		return dataSharingShCreateTime;
	}

	public void setDataSharingShCreateTime(String dataSharingShCreateTime) {
		this.dataSharingShCreateTime = dataSharingShCreateTime;
	}

	public String getDataSharingMainContent() {
		return dataSharingMainContent;
	}

	public void setDataSharingMainContent(String dataSharingMainContent) {
		this.dataSharingMainContent = dataSharingMainContent;
	}

	public String getDataSharingUrl() {
		return dataSharingUrl;
	}

	public void setDataSharingUrl(String dataSharingUrl) {
		this.dataSharingUrl = dataSharingUrl;
	}

	public String getDataSharingFileUrl1() {
		return dataSharingFileUrl1;
	}

	public void setDataSharingFileUrl1(String dataSharingFileUrl1) {
		this.dataSharingFileUrl1 = dataSharingFileUrl1;
	}

	public String getDataSharingFileUrl2() {
		return dataSharingFileUrl2;
	}

	public void setDataSharingFileUrl2(String dataSharingFileUrl2) {
		this.dataSharingFileUrl2 = dataSharingFileUrl2;
	}

	public String getDataSharingFileUrl3() {
		return dataSharingFileUrl3;
	}

	public void setDataSharingFileUrl3(String dataSharingFileUrl3) {
		this.dataSharingFileUrl3 = dataSharingFileUrl3;
	}

	public String getDataSharingFileUrl4() {
		return dataSharingFileUrl4;
	}

	public void setDataSharingFileUrl4(String dataSharingFileUrl4) {
		this.dataSharingFileUrl4 = dataSharingFileUrl4;
	}

	public String getDataSharingCreateTime() {
		return dataSharingCreateTime;
	}

	public void setDataSharingCreateTime(String dataSharingCreateTime) {
		this.dataSharingCreateTime = dataSharingCreateTime;
	}

	public String getDataSharingUpdateTime() {
		return dataSharingUpdateTime;
	}

	public void setDataSharingUpdateTime(String dataSharingUpdateTime) {
		this.dataSharingUpdateTime = dataSharingUpdateTime;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
    
    
}
