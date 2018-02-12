package com.vieagr.distribution.dao;

import java.util.List;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.query.SysProductQuery;

public interface SysProductDao extends IBaseDao<SysProduct> {

	/**
	 * @Title: selectSysProductDetailList 
	 * @Description:     列表like查询
	 * @param sysProduct
	 * @return
	 * @throws Exception   
	 * @return List<SysProduct>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月1日 下午4:24:06
	 */
	List<SysProduct> selectSysProductDetailList(SysProduct sysProduct) throws Exception;
	
	/**
	 * 根据订单号有序查询商品信息
	 * @param sysProduct
	 * @return
	 * @throws Exception
	 */
	List<SysProduct> selectProductConsultOrder(SysProduct sysProduct) throws Exception;
	
	/**
	 * 获取商品总数
	 * @return
	 */
	Integer selectProductCount();
	
	/**
	 * 订单列表增加商品时的商品列表，
	 * 排除订单中已有的商品
	 * @param orderNumber
	 * @return
	 */
	List<SysProduct> productsListForOrderDetails(SysProductQuery sysProductQuery);
	
	/**
	 * 根据商品名查询商品
	 * @param sysProduct
	 * @return
	 */
	List<SysProduct> selectSysProductByProductName(SysProduct sysProduct);
	
	/**
	 * 查询所有的有效的商品信息
	 * @return
	 */
	List<SysProduct> selectAllEffectiveSysProduct();
}