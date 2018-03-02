package com.vieagr.distribution.response;

import com.vieagr.distribution.entity.BetVehiclesCustomer;
import com.vieagr.distribution.entity.SysCustomer;
import com.vieagr.distribution.entity.SysVehicles;

/**
 * @ClassName: SysCustomerDetailResponse 
 * @Description: 客户详情返回bean
 * @author huzhihui_c@qq.com
 * @date 2016年10月31日 下午2:48:59
 */
public class SysCustomerDetailResponse {

	/**
	 * 客户bean
	 */
	private SysCustomer sysCustomer;
	
	/**
	 * 客户车辆关系bean
	 */
	private BetVehiclesCustomer betVehiclesCustomer;
	
	/**
	 * 车辆信息bean
	 */
	private SysVehicles sysVehicles;

	public SysCustomer getSysCustomer() {
		return sysCustomer;
	}

	public void setSysCustomer(SysCustomer sysCustomer) {
		this.sysCustomer = sysCustomer;
	}

	public BetVehiclesCustomer getBetVehiclesCustomer() {
		return betVehiclesCustomer;
	}

	public void setBetVehiclesCustomer(BetVehiclesCustomer betVehiclesCustomer) {
		this.betVehiclesCustomer = betVehiclesCustomer;
	}

	public SysVehicles getSysVehicles() {
		return sysVehicles;
	}

	public void setSysVehicles(SysVehicles sysVehicles) {
		this.sysVehicles = sysVehicles;
	}
	
}
