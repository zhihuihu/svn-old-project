package com.vieagr.distribution.service.inter;

import java.util.List;
import java.util.Map;

import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.param.SerOrderParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.response.IndexResponse;
import com.vieagr.distribution.response.SerOrderResponse;
import com.vieagr.distribution.service.base.IBaseService;

/**
 * 订单业务类
 * @author master
 *
 */
public interface ISerOrderService extends IBaseService<SerOrder>{

	/**
	 * 分页查询订单列表，Query对象接收
	 * @param orderQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectOrderList(SerOrderQuery serOrderQuery) throws Exception;
	
	/**
	 * 分页查询订单列表，Entity对象接收
	 * @param orderQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectOrderList(SerOrder serOrder) throws Exception;
	
	/**
	 *	将订单与商品中间表对象一些参数封装进Map，用于excel导出或者打印的拼接
	 * @return
	 */
	Map<String, Object> joinOrderAndProductTogether(List<String> poductInfos, List<String> customerStoreNames, List<BetOrderProduct> betOrderProducts);
	
	/**
	 * 得到订单列表中所有的商家店名
	 * @param serOrders
	 * @return
	 */
	List<String> joinCustomerStoreNamesTogether(List<SerOrder> serOrders);
	
	/**
	 * 得到订单表中所有的商品名，且去重
	 * @param serOrders
	 * @return
	 */
	List<String>joinPorductNamesTogether(List<BetOrderProduct> betOrderProducts);
	
	/**
	 * 查询订单列表，
	 * 并关联上客户信息
	 * @param serOrderQuery
	 * @return
	 */
	List<SerOrder> selectOrdersAndCustomersBySendTime(SerOrderQuery serOrderQuery);
	
	/**
	 * 增加一条订单且同时增加关联表信息
	 * @param serOrder
	 * @return
	 * @throws Exception 
	 */
	Integer saveOrderAndBetOrderProduct(SerOrderParam serOrderParam) throws Exception;
	
	/**
	 * 根据订单号查询出订单详情并且查询出该订单对应的所有商品信息
	 * @param orderId
	 * @return
	 * @throws Exception 
	 */
	SerOrderResponse selectOrderByOrderNumber(String orderNumber) throws Exception;

	/**
	 * 根据customerId查询出最新的一条订单信息
	 * @param serOrderQuery
	 * @return
	 */
	SerOrder selectOneNewOrderByCustomerId(SerOrderQuery serOrderQuery);
	
	/**
	 * 根据订单号修改订单信息
	 * @param serOrder
	 * @return
	 */
	Integer updateByOrderNumberSelective(SerOrder serOrder);
	
	/**
	 * 修改了订单中商品的价格后更新订单价格
	 * @param orderNumber
	 * @return
	 * @throws Exception 
	 */
	Integer updateOrderTotalAmount(String orderNumber) throws Exception;
	
	/**
	 * 多条订单打印列表信息
	 * @param serOrderParam
	 * @return
	 * @throws Exception 
	 */
	List<SerOrderResponse> readOrderDetailsListForStamp(SerOrderParam serOrderParam) throws Exception;
	
	/**
	 * 单挑订单打印列表信息
	 * @param serOrderParam
	 * @return
	 */
	SerOrderResponse readOrderDetailsForStamp(SerOrderParam serOrderParam) throws Exception;
	
	/**
	 * 获取首页相关数据数目
	 * @param toDay
	 * @return
	 */
	IndexResponse classiFicationGetCount(String toDay);
	
	/**
	 * 查询今日待配送订单
	 * @param serOrderQuery
	 * @return
	 */
	ReturnUtils selectToDayOrderInfo(SerOrderQuery serOrderQuery);
	
	/**
	 * 走势图数据准备
	 * @return
	 */
	Object readChartData();
	
	/**
	 * 一条订单中统一修改里面的商品价格
	 * @param serOrderParam
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils unifiedUpdateProductSalePriceForOneOrder(SerOrderParam serOrderParam) throws Exception;
	
	/**
	 * 添加一条模板订单
	 * @param serOrderParam
	 * @return
	 * @throws Exception
	 */
	Integer saveTempOrderAndBetOrderProduct(SerOrderParam serOrderParam) throws Exception;
	
	/**
	 * 查询该门店的记忆订单
	 * @param sysCustomerId
	 * @return
	 * @throws Exception
	 */
	SerOrder selectMemoryOrderForCustomer(String sysCustomerId) throws Exception;

	/**
	 * 修改模板订单中的数量
	 * @param serOrderParam
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils updateSerTempOrder(SerOrderParam serOrderParam) throws Exception;
	
	/**
	 * 根据月份信息查询相应顾客对应的订单列表
	 * @param monthDate
	 * @param customerId
	 * @param orderType
	 * @return
	 * @throws Exception 
	 */
	SerOrderResponse downLoadCustomerOrdersByMonthDate(String monthDate, String customerId, Integer orderType) throws Exception;
	
	/**
	 * 根据具体时间查询相应顾客的订单列表
	 * @param startDate
	 * @param endDate
	 * @param cutomerId
	 * @param orderType
	 * @return
	 * @throws Exception 
	 */
	SerOrderResponse downLoadCustomerOrdersByDetailsDate(String startDate, String endDate, String customerId, Integer orderType) throws Exception;
}
