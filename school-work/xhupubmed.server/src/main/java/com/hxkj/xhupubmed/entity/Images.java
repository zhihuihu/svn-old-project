package com.hxkj.xhupubmed.entity;

import java.io.Serializable;

/** 
 * ClassName:Images
 * Function:   图片集
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午12:46:03 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class Images implements Serializable {

	private static final long serialVersionUID = -2229514906840356560L;

	//图片集CUID
	private String imagesCuid;

	//回帖CUID
    private String repliesCuid;

    //图片集名称
    private String imagesName;

    //图片集URL
    private String imagesUrl;

    //图片集缩略图
    private String imagesThumbUrl;

    //图片集后续说明
    private String imagesExplian;

    //图片集状态
    private int imagesState;

    //图片集创建时间
    private String imagesCreateTime;

    //图片集更新时间
    private String imagesUpdateTime;

	public String getImagesCuid() {
		return imagesCuid;
	}

	public void setImagesCuid(String imagesCuid) {
		this.imagesCuid = imagesCuid;
	}

	public String getRepliesCuid() {
		return repliesCuid;
	}

	public void setRepliesCuid(String repliesCuid) {
		this.repliesCuid = repliesCuid;
	}

	public String getImagesName() {
		return imagesName;
	}

	public void setImagesName(String imagesName) {
		this.imagesName = imagesName;
	}

	public String getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String imagesUrl) {
		this.imagesUrl = imagesUrl;
	}

	public String getImagesThumbUrl() {
		return imagesThumbUrl;
	}

	public void setImagesThumbUrl(String imagesThumbUrl) {
		this.imagesThumbUrl = imagesThumbUrl;
	}

	public String getImagesExplian() {
		return imagesExplian;
	}

	public void setImagesExplian(String imagesExplian) {
		this.imagesExplian = imagesExplian;
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

	public String getImagesUpdateTime() {
		return imagesUpdateTime;
	}

	public void setImagesUpdateTime(String imagesUpdateTime) {
		this.imagesUpdateTime = imagesUpdateTime;
	}
    
    
    
}
