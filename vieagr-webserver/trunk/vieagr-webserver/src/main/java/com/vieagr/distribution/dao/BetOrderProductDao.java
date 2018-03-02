package com.vieagr.distribution.dao;

import java.util.List;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.param.SerOrderParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.query.SysProductQuery;

public interface BetOrderProductDao extends IBaseDao<BetOrderProduct>{
	
	public List<BetOrderProduct> selectBetOrderProductsAndCustomerInfo(SerOrderQuery serOrderQuery) throws Exception;
	
	public BetOrderProduct selectBetOrderProductsByBetOrderProductIdAndOrderNumber(SerOrderQuery serOrderQuery) throws Exception;
	
	public BetOrderProduct selectBetOrderProductsByBetOrderProductProductIdAndOrderNumber(SerOrderQuery serOrderQuery) throws Exception;
	
	public Integer updateByOrderNumberAndBetOrderProductIdSelective(BetOrderProduct betOrderProduct);
	
	public Integer updateByOrderNumberAndBetOrderProductProductIdSelective(BetOrderProduct betOrderProduct);
	
	public List<BetOrderProduct> selectProductsForUnifyUpdateOrder(SerOrderQuery serOrderQuery) throws Exception;
	
	public Integer updateProductSalePrice(SerOrderParam serOrderParam);
	
	public BetOrderProduct selectBetOrderProductByProductIdAndOrderNumber(SerOrderQuery serOrderQuery) throws Exception;
	
	public Integer deleteProductForOrderDetails(SerOrderParam serOrderParam);
	
	public List<BetOrderProduct> selectBetOrderProductBySerOrderId(String serOrderId);
	
	/**
	 * 根据订单主键查询订单详情列表
	 * @param serOrderId
	 * @return
	 */
	public List<BetOrderProduct> selectBetOrderProductByOrderId(String serOrderId);
	
	/**
	 * 根据送货车辆及订单类型和送货时间
	 * 查询订单详情列表
	 * @param serOrderQuery
	 * @return
	 */
	public List<BetOrderProduct> selectBetOrderProductByVehiclesId(SerOrderQuery serOrderQuery);
	
	/**
	 * 根据订单id和商品id查询订单商品详情中的对应商品信息
	 * @param sysProductQuery
	 * @return
	 */
	public BetOrderProduct selectBetOrderProductBySerOrderIdAndProductId(SysProductQuery sysProductQuery);
	
}