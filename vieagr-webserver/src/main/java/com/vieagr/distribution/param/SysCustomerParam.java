package com.vieagr.distribution.param;

import java.util.ArrayList;
import java.util.List;

import com.vieagr.distribution.entity.SysCustomerGroupProduct;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.param.base.BaseParam;

/**
 * 客户请求对象
 * @author master
 *
 */
public class SysCustomerParam extends BaseParam{

	private static final long serialVersionUID = -8266591069855660350L;
	
	/**
	 * 顾客主键列表
	 */
	private List<String> customerIds;
	
	/**
	 * 顾客分组名称
	 */
	private String customerGroupName;
	
	/**
	 * 顾客分组排序位
	 */
	private Integer customerGroupSort;

	/**
	 * 顾客分组id
	 */
	private String customerGroupId;
	
	/**
	 * 商品信息列表
	 */
	private List<SysProduct> sysProducts;
	
	/**
	 * 同步顾客分组的id
	 */
	private String sysCustomerGroupId;
	
	/**
	 * 同步顾客分组的名称
	 */
	private String sysCustomerGroupName;
	
	/**
	 * 同步顾客分组的排序位
	 */
	private Integer sysCustomerGroupSort;
	
	/**
	 * 同步顾客分组的状态
	 */
	private Integer sysCustomerGroupState;
		
    /**
     * 是否有禁用或者启用的操作
     *  1、没有，2启用、3禁用
     */
    private Integer isForbiddenOrOpen;
	
    /**
     * 模板商品修改时入参列表
     */
    private List<SysCustomerGroupProduct> sysCustomerGroupProducts = new ArrayList<SysCustomerGroupProduct>();
    
	public List<SysCustomerGroupProduct> getSysCustomerGroupProducts() {
		return sysCustomerGroupProducts;
	}

	public void setSysCustomerGroupProducts(List<SysCustomerGroupProduct> sysCustomerGroupProducts) {
		this.sysCustomerGroupProducts = sysCustomerGroupProducts;
	}

	public Integer getIsForbiddenOrOpen() {
		return isForbiddenOrOpen;
	}

	public void setIsForbiddenOrOpen(Integer isForbiddenOrOpen) {
		this.isForbiddenOrOpen = isForbiddenOrOpen;
	}

	public String getSysCustomerGroupId() {
		return sysCustomerGroupId;
	}

	public void setSysCustomerGroupId(String sysCustomerGroupId) {
		this.sysCustomerGroupId = sysCustomerGroupId;
	}

	public String getSysCustomerGroupName() {
		return sysCustomerGroupName;
	}

	public void setSysCustomerGroupName(String sysCustomerGroupName) {
		this.sysCustomerGroupName = sysCustomerGroupName;
	}

	public Integer getSysCustomerGroupSort() {
		return sysCustomerGroupSort;
	}

	public void setSysCustomerGroupSort(Integer sysCustomerGroupSort) {
		this.sysCustomerGroupSort = sysCustomerGroupSort;
	}

	public Integer getSysCustomerGroupState() {
		return sysCustomerGroupState;
	}

	public void setSysCustomerGroupState(Integer sysCustomerGroupState) {
		this.sysCustomerGroupState = sysCustomerGroupState;
	}

	public String getCustomerGroupId() {
		return customerGroupId;
	}

	public void setCustomerGroupId(String customerGroupId) {
		this.customerGroupId = customerGroupId;
	}

	public List<SysProduct> getSysProducts() {
		return sysProducts;
	}

	public void setSysProducts(List<SysProduct> sysProducts) {
		this.sysProducts = sysProducts;
	}

	public List<String> getCustomerIds() {
		return customerIds;
	}

	public void setCustomerIds(List<String> customerIds) {
		this.customerIds = customerIds;
	}

	public String getCustomerGroupName() {
		return customerGroupName;
	}

	public void setCustomerGroupName(String customerGroupName) {
		this.customerGroupName = customerGroupName;
	}

	public Integer getCustomerGroupSort() {
		return customerGroupSort;
	}

	public void setCustomerGroupSort(Integer customerGroupSort) {
		this.customerGroupSort = customerGroupSort;
	}

	@Override
	public String toString() {
		return "SysCustomerParam [customerIds=" + customerIds + ", customerGroupName=" + customerGroupName
				+ ", customerGroupSort=" + customerGroupSort + ", customerGroupId=" + customerGroupId + ", sysProducts="
				+ sysProducts + "]";
	}
	
}
