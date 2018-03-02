package com.vieagr.distribution.query;

import com.vieagr.distribution.entity.BetVehiclesCustomer;
import com.vieagr.distribution.entity.SysCustomer;
import com.vieagr.distribution.query.base.BaseQuery;

/**
 * @ClassName: SysCustomerSaveQuery 
 * @Description: 顾客保存实体
 * @author huzhihui_c@qq.com
 * @date 2016年10月31日 上午11:17:41
 */
public class SysCustomerSaveQuery extends BaseQuery{

	private static final long serialVersionUID = 1L;

	/**
	 * 顾客实体
	 */
	private SysCustomer sysCustomer;
	
	/**
	 * 顾客和送货车辆关系表
	 */
	private BetVehiclesCustomer betVehiclesCustomer;

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
	
}
