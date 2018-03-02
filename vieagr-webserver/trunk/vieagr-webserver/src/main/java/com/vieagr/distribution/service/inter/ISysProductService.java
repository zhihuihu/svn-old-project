package com.vieagr.distribution.service.inter;

import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.param.SysProductParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.query.SysProductQuery;
import com.vieagr.distribution.service.base.IBaseService;

/**
 * 商品业务
 * @author master
 *
 */
public interface ISysProductService extends IBaseService<SysProduct>{
	
	/**
	 * 分页查询商品，Query对象接收
	 * @param sysProductQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectProductList(SysProductQuery sysProductQuery) throws Exception;
	
	/**
	 * 分页查询商品，Entity对象接收
	 * @param sysProductQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectProductList(SysProduct sysProduct) throws Exception;
	
	/**
	 * @Title: sysProductAdd 
	 * @Description:     商品--添加
	 * @param sysProduct
	 * @return
	 * @throws Exception   
	 * @return ReturnUtils    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月1日 下午3:30:34
	 */
	ReturnUtils sysProductAdd(SysProduct sysProduct) throws Exception;
	
	/**
	 * @Title: selectSysProductDetailList 
	 * @Description:     商品--列表查询
	 * @param sysProduct
	 * @return
	 * @throws Exception   
	 * @return ReturnUtils    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月1日 下午4:15:54
	 */
	ReturnUtils selectSysProductDetailList(SysProduct sysProduct) throws Exception;
	
	/**
	 * @Title: updateSysProduct 
	 * @Description:     商品--更新
	 * @param sysProduct
	 * @return
	 * @throws Exception   
	 * @return ReturnUtils    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月2日 下午3:33:42
	 */
	ReturnUtils updateSysProduct(SysProduct sysProduct) throws Exception;
	
	/**
	 * 根据订单信息有序查询商品
	 * @param sysProduct
	 * @return
	 * @throws Exception
	 */
	ReturnUtils selectProductConsultOrder(SysProduct sysProduct, SerOrderQuery serOrderQuery) throws Exception;
	
	/**
	 * 统一一次性修改多个商品价格
	 * @param sysProductParam
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils updateProductsPriceByList(SysProductParam sysProductParam) throws Exception;

	/**
	 * 订单详情增加商品时的商品列表，
	 * 排除订单中已有的商品
	 * @param orderNumber
	 * @return
	 */
	ReturnUtils productsListForOrderDetails(SysProductQuery sysProductQuery);
}
