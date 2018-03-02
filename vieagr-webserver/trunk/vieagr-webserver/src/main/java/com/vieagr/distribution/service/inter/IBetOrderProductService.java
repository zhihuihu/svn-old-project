package com.vieagr.distribution.service.inter;

import java.util.List;

import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.param.SerOrderParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.service.base.IBaseService;

/**
 * 订单和商品中间表对象业务
 * @author master
 *
 */
public interface IBetOrderProductService extends IBaseService<BetOrderProduct>{
	
	/**
	 * 根据订单号查询所有对应的中间表关联信息
	 * @return
	 * @throws Exception 
	 */
	public List<BetOrderProduct> selectBetOrderProductListByQuery(SerOrderQuery serOrderQuery) throws Exception;
	
	/**
	 * 批量增加订单关联商品表信息
	 * @param sysProducts
	 * @param serOrderId
	 * @return
	 * @throws Exception 
	 */
	public Integer saveBetOrderProductList(List<SysProduct> sysProducts, String serOrderId, SerOrder serOrder) throws Exception;
	
	/**
	 * 根据订单商品关联id和订单号查询出一条对应的订单商品关联信息
	 * @param serOrderQuery
	 * @return
	 * @throws Exception 
	 */
	BetOrderProduct selectBetOrderProductsByBetOrderProductIdAndOrderNumber(SerOrderQuery serOrderQuery) throws Exception;
	
	/**
	 * 根据订单号和商品订单关联id修改一条商品订单关联信息
	 * @param betOrderProduct
	 * @return
	 */
	Integer updateByOrderNumberAndBetOrderProductIdSelective(BetOrderProduct betOrderProduct);
	
	/**
	 *	统一修改多条订单中的商品价格时查询商品列表
	 */
	List<BetOrderProduct> selectProductsForUnifyUpdateOrder(SerOrderQuery serOrderQuery) throws Exception;
	
	/**
	 * 统一修改订单中商品卖价
	 * @param serOrderParam
	 * @return
	 * @throws Exception 
	 */
	Integer updateProductSalePrice(SerOrderParam serOrderParam) throws Exception;
	
	/**
	 * 订单详情中增加商品
	 * @param serOrderParam
	 * @return
	 * @throws Exception 
	 */
	Integer insertProductForOrderDetails(SerOrderParam serOrderParam) throws Exception;
	
	/**
	 * 订单详情中删除商品
	 * @param serOrderParam
	 * @return
	 */
	ReturnUtils deleteProductForOrderDetails(SerOrderParam serOrderParam);
	
	/**
	 * 多条订单多个商品统一修改多个商品价格
	 * @throws Exception 
	 */
	ReturnUtils updateProductPriceForProductsAndOrders(SerOrderParam serOrderParam) throws Exception;
	
}
