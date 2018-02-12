package com.cqq.leisure.entity;

import java.io.Serializable;

public class Merchant implements Serializable {

	
	// 商家实体
	private static final long serialVersionUID = -2769722254989638952L;
	
	//商家ID
    private int merchantId;

    //标签ID
    private int tagId;

    //商家图标
    private String merchantIconUrl;

    //商家联系人名称
    private String merchantLinkman;

    //商家联系电话
    private String merchantPhone;

    //商家地址
    private String merchantAddress;

    //商家广告
    private String merchantAd;

    //商家名称
    private String merchantName;

    //商家类型
    private String merchantType;

    //商家GPS地址
    private String merchantGpsAddress;

    //商家经度
    private String merchantLog;

    //商家纬度
    private String merchantLat;

    //商家简介
    private String merchantIntro;

    //商家状态
    private int merchantState;

    //商家创建时间
     
    private String merchantCreateTime;

    //商家更新时间
    private String merchantUpdateTime;

    //商家所属标签
    private String merchantTag;

    // 商家热度排序
    private int merchantSort;

	public int getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(int merchantId) {
		this.merchantId = merchantId;
	}

	public int getTagId() {
		return tagId;
	}

	public void setTagId(int tagId) {
		this.tagId = tagId;
	}

	public String getMerchantIconUrl() {
		return merchantIconUrl;
	}

	public void setMerchantIconUrl(String merchantIconUrl) {
		this.merchantIconUrl = merchantIconUrl;
	}

	public String getMerchantLinkman() {
		return merchantLinkman;
	}

	public void setMerchantLinkman(String merchantLinkman) {
		this.merchantLinkman = merchantLinkman;
	}

	public String getMerchantPhone() {
		return merchantPhone;
	}

	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}

	public String getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	public String getMerchantAd() {
		return merchantAd;
	}

	public void setMerchantAd(String merchantAd) {
		this.merchantAd = merchantAd;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantType() {
		return merchantType;
	}

	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType;
	}

	public String getMerchantGpsAddress() {
		return merchantGpsAddress;
	}

	public void setMerchantGpsAddress(String merchantGpsAddress) {
		this.merchantGpsAddress = merchantGpsAddress;
	}

	public String getMerchantLog() {
		return merchantLog;
	}

	public void setMerchantLog(String merchantLog) {
		this.merchantLog = merchantLog;
	}

	public String getMerchantLat() {
		return merchantLat;
	}

	public void setMerchantLat(String merchantLat) {
		this.merchantLat = merchantLat;
	}

	public String getMerchantIntro() {
		return merchantIntro;
	}

	public void setMerchantIntro(String merchantIntro) {
		this.merchantIntro = merchantIntro;
	}

	public int getMerchantState() {
		return merchantState;
	}

	public void setMerchantState(int merchantState) {
		this.merchantState = merchantState;
	}

	public String getMerchantCreateTime() {
		return merchantCreateTime;
	}

	public void setMerchantCreateTime(String merchantCreateTime) {
		this.merchantCreateTime = merchantCreateTime;
	}

	public String getMerchantUpdateTime() {
		return merchantUpdateTime;
	}

	public void setMerchantUpdateTime(String merchantUpdateTime) {
		this.merchantUpdateTime = merchantUpdateTime;
	}

	public String getMerchantTag() {
		return merchantTag;
	}

	public void setMerchantTag(String merchantTag) {
		this.merchantTag = merchantTag;
	}

	public int getMerchantSort() {
		return merchantSort;
	}

	public void setMerchantSort(int merchantSort) {
		this.merchantSort = merchantSort;
	}
    
    
	
}
