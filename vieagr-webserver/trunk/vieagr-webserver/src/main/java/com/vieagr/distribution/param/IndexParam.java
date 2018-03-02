package com.vieagr.distribution.param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vieagr.distribution.param.base.BaseParam;

/**
 * 首页请求对象
 * @author master
 *
 */
public class IndexParam extends BaseParam{

	private static final long serialVersionUID = -3796891146672672877L;
	
	/**
	 *	普通订单的客户门店信息
	 */
	List<String> ordinaryOrderCustomerStoreNames = new ArrayList<String>();
	
	/**
	 * 普通订单的商品信息
	 */
	Map<String, Object> ordinaryOrderProductInfoMaps = new HashMap<String, Object>();
	
	/**
	 * 员工餐订单客户门店信息
	 */
	List<String> staffOrderCustomerStoreNames = new ArrayList<String>();
	
	/**
	 * 员工餐订单商品信息
	 */
	Map<String, Object> staffOrderProductInfoMaps = new HashMap<String, Object>();

	public List<String> getOrdinaryOrderCustomerStoreNames() {
		return ordinaryOrderCustomerStoreNames;
	}

	public void setOrdinaryOrderCustomerStoreNames(List<String> ordinaryOrderCustomerStoreNames) {
		this.ordinaryOrderCustomerStoreNames = ordinaryOrderCustomerStoreNames;
	}
	public List<String> getStaffOrderCustomerStoreNames() {
		return staffOrderCustomerStoreNames;
	}

	public void setStaffOrderCustomerStoreNames(List<String> staffOrderCustomerStoreNames) {
		this.staffOrderCustomerStoreNames = staffOrderCustomerStoreNames;
	}

	public Map<String, Object> getOrdinaryOrderProductInfoMaps() {
		return ordinaryOrderProductInfoMaps;
	}

	public void setOrdinaryOrderProductInfoMaps(Map<String, Object> ordinaryOrderProductInfoMaps) {
		this.ordinaryOrderProductInfoMaps = ordinaryOrderProductInfoMaps;
	}

	public Map<String, Object> getStaffOrderProductInfoMaps() {
		return staffOrderProductInfoMaps;
	}

	public void setStaffOrderProductInfoMaps(Map<String, Object> staffOrderProductInfoMaps) {
		this.staffOrderProductInfoMaps = staffOrderProductInfoMaps;
	}
	
}	
