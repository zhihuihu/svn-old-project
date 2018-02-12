package com.vieagr.distribution.service.inter;

import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.entity.SerDelivery;
import com.vieagr.distribution.query.SerDeliveryQuery;
import com.vieagr.distribution.service.base.IBaseService;

/**
 * 送货单业务
 * @author master
 *
 */
public interface ISerDeliveryService extends IBaseService<SerDelivery>{
	
	/**
	 * 分页查询送货单，Query对象接收
	 * @param deliveryQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectDeliveryList(SerDeliveryQuery deliveryQuery) throws Exception;
	
	/**
	 * 分页查询送货单，Entity对象接收
	 * @param deliveryQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectDeliveryList(SerDelivery serDelivery) throws Exception;
	
}
