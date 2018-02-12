package com.vieagr.distribution.dao;

import java.math.BigDecimal;
import java.util.List;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.query.SerOrderQuery;

public interface SerOrderDao extends IBaseDao<SerOrder> {
		
	/**
	 * 查询出订单列表，并关联上客户信息
	 * @param serOrder
	 * @return
	 */
	public List<SerOrder> selectOrdersAndCustomersBySendTime(SerOrderQuery serOrderQuery);
	
	/**
	 * 根据顾客id查询出最新的一条配送成功的订单
	 * @param serOrderQuery
	 * @return
	 */
	public SerOrder selectOneNewOrderByCustomerId(SerOrderQuery serOrderQuery);
	
	/**
	 * 查询订单列表并关联客户信息
	 * @param serOrder
	 * @return
	 */
	public List<SerOrder> selectOrdersAndCustomerInfos(SerOrderQuery serOrderQuery);
	
	/**
	 * 根据订单号查询一条订单详情
	 * @param serOrder
	 * @return
	 */
	public SerOrder selectByOrderNumber(String orderNumber);
	
	/**
	 * 根据订单号修改订单信息
	 * @param serOrder
	 * @return
	 */
	public Integer updateByOrderNumberSelective(SerOrder serOrder);
	
	/**
	 * 获取所有的订单数目
	 * @return
	 */
	public Integer selectOrderCount();
	
	/**
	 * 获取当天下单的订单数目
	 * @param toDay
	 * @return
	 */
	public Integer selectToDayOrderCount(String toDay);
	
	/**
	 * 获取今日待配送订单
	 * @param serOrderQuery
	 * @return
	 */
	public List<SerOrder> selectToDayOrderInfo(SerOrderQuery serOrderQuery);
	
	/**
	 * 计算出该送货日期下的订单总金额
	 * @param orderSendTime
	 * @return
	 */
	public BigDecimal selectOrderAmountOfDay(String orderSendTime);
	
	/**
	 * 查询出商店的记忆订单
	 * @param sysCustomerId
	 * @return
	 */
	public SerOrder selectMemoryOrderForCustomer(String sysCustomerId);
	
	/**
	 * 按照月份查询出对应顾客的订单列表
	 * @param serOrder
	 * @return
	 */
	public List<SerOrder> selectOrdersForCustomerExcel(SerOrder serOrder);
	
}