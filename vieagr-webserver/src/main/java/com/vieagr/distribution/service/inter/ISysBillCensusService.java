package com.vieagr.distribution.service.inter;

import com.vieagr.distribution.service.base.IBaseService;

/**
 * 账单统计业务层
 * @author Administrator
 *
 */
public interface ISysBillCensusService extends IBaseService<Object>{

	/**
	 * 	订单完成后，
	 * 日账单统计入账
	 * @param serOrderId
	 * @return
	 */
	Integer dailyOrderInfoCensusAfterFinishOrder(String serOrderId) throws Exception;
	
	/**
	 * 订单完成后，
	 * 月账单统计入账
	 * @param serOrderId
	 * @return
	 */
	Integer mensalOrderInfoCensusAfterFinishOrder(String serOrderId) throws Exception;
	
}
