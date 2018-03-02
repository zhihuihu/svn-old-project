package com.vieagr.distribution.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.Base64FileUtils;
import com.vieagr.distribution.base.util.PinYinUtils;
import com.vieagr.distribution.base.util.PropertiesUtils;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.dao.BetOrderProductDao;
import com.vieagr.distribution.dao.SerOrderDao;
import com.vieagr.distribution.dao.SysCustomerGroupDao;
import com.vieagr.distribution.dao.SysCustomerGroupProductDao;
import com.vieagr.distribution.dao.SysProductDao;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysCustomerGroup;
import com.vieagr.distribution.entity.SysCustomerGroupProduct;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.param.SysProductParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.query.SysCustomerGroupProductQuery;
import com.vieagr.distribution.query.SysProductQuery;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISysProductService;

@Service
@Transactional
public class SysProductServiceImpl extends BaseService<SysProduct>implements ISysProductService{

	@Autowired
	private SysProductDao sysProductDao;
	
	@Autowired
	private SysCustomerGroupDao sysCustomerGroupDao;
	
	@Autowired
	private SysCustomerGroupProductDao sysCustomerGroupProductDao;
	
	@Autowired
	private SerOrderDao serOrderDao;
	
	@Autowired
	private BetOrderProductDao betOrderProductDao;
	
	
	@Override
	public ReturnUtils selectProductList(SysProductQuery sysProductQuery) throws Exception {
		PageHelper.startPage(sysProductQuery.getCurrentPage(), sysProductQuery.getPageSize());
		List<SysProduct> list = sysProductDao.selectByAttributeAnd(Utils.exchangeObject(sysProductQuery, SysProduct.class));
		PageInfo<SysProduct> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils selectProductList(SysProduct sysProduct) throws Exception {
		PageHelper.startPage(sysProduct.getCurrentPage(), sysProduct.getPageSize());
		List<SysProduct> list = sysProductDao.selectByAttributeAnd(sysProduct);
		PageInfo<SysProduct> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils sysProductAdd(SysProduct sysProduct) throws Exception {
		if(null == sysProduct){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.DATA_ERROR);
		}
		if(null == sysProduct.getSysProductName() || sysProduct.getSysProductName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_PRODUCT_NAME_ERROR);
		}
		if(null == sysProduct.getSysProductProductTypeId() || sysProduct.getSysProductProductTypeId().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "商品添加失败，请先添加商品类型");
		}
		SysProduct sysProductCheck = new SysProduct();
		sysProductCheck.setSysProductName(sysProduct.getSysProductName());
		List<SysProduct> list = sysProductDao.selectSysProductByProductName(sysProductCheck);
		if(null != list && list.size() >0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_PRODUCT_NAME_REPEAT);
		}
		sysProduct.setSysProductName(sysProduct.getSysProductName().toUpperCase());
		sysProduct.setSysProductId(UUID.randomUUID().toString());
		sysProduct.setSysProductPyCode(PinYinUtils.getPinYinCodeString(sysProduct.getSysProductName()));
		sysProduct.setSysProductPyName(PinYinUtils.getPinYinString(sysProduct.getSysProductName()));
		sysProduct.setSysProductCreateTime(Utils.getNowTime());
		sysProduct.setSysProductImgUrl(Base64FileUtils.base64ToImageFile(sysProduct.getSysProductImgUrl(), 
				PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		
		int flg = sysProductDao.insertSelective(sysProduct);
		if(flg > 0){
			/**
			 * 添加模板商品入顾客分组商品中
			 */
			this.insertSysCustomerGroupProductAfterInsertSysProduct(sysProduct);
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.SYS_PRODUCT_ADD_SUCCESS);
		}else{
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_PRODUCT_ADD_ERROR);
		}
	}

	@Override
	public ReturnUtils selectSysProductDetailList(SysProduct sysProduct) throws Exception {
		PageHelper.startPage(sysProduct.getCurrentPage(), sysProduct.getPageSize());
		if(sysProduct.getSearchName() != null){
			sysProduct.setSearchName(sysProduct.getSearchName().trim().toUpperCase());
		}
		sysProduct.setSysProductName(sysProduct.getSearchName());
		sysProduct.setSysProductPyName(sysProduct.getSearchName());
		sysProduct.setSysProductPyCode(sysProduct.getSearchName());
		if(sysProduct.getSysProductProductTypeId() == null || sysProduct.getSysProductProductTypeId().trim().equals("") || sysProduct.getSysProductProductTypeId().trim().equals("null")){
			sysProduct.setSysProductProductTypeId(null);
		}
		List<SysProduct> list = sysProductDao.selectSysProductDetailList(sysProduct);
		PageInfo<SysProduct> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils updateSysProduct(SysProduct sysProduct) throws Exception {
		if(null == sysProduct){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.DATA_ERROR);
		}
		if(null == sysProduct.getSysProductName() || sysProduct.getSysProductName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_PRODUCT_NAME_ERROR);
		}
		if(null == sysProduct.getSysProductProductTypeId() || sysProduct.getSysProductProductTypeId().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "商品修改失败，请先添加商品类型");
		}
		SysProduct sysProductCheck = new SysProduct();
		sysProductCheck.setSysProductName(sysProduct.getSysProductName());
		sysProduct.setSysProductImgUrl(Base64FileUtils.base64ToImageFile(sysProduct.getSysProductImgUrl(), PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		int flg = sysProductDao.updateByPrimaryKeySelective(sysProduct);
		/**
		 * 修改商品对应的今日已下订单中商品详情的商品进价
		 */
		SerOrderQuery serOrderQuery = new SerOrderQuery();
		serOrderQuery.setOrderSendTime(Utils.getNowDate());
		List<SerOrder> list = serOrderDao.selectSerOrderBySendTime(serOrderQuery);
		
		SysProductQuery sysProductQuery = new SysProductQuery();
		for (SerOrder serOrder : list) {
			sysProductQuery.setSerOrderId(serOrder.getSerOrderId());
			sysProductQuery.setProductId(sysProduct.getSysProductId());
			BetOrderProduct betOrderProduct = betOrderProductDao.selectBetOrderProductBySerOrderIdAndProductId(sysProductQuery);
			if(betOrderProduct != null){
				betOrderProduct.setBetOrderProductProductBidPrice(serOrder.getSerOrderType().equals(2) 
						? sysProduct.getSysProductStaffBidPrice() : sysProduct.getSysProductOrdinaryBidPrice());
				betOrderProductDao.updateByPrimaryKeySelective(betOrderProduct);
			}
		}
		if(flg > 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.UPDATE_SUCCESS);
		}else{
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.UPDATE_ERROR);
		}
	}

	@Override
	public ReturnUtils selectProductConsultOrder(SysProduct sysProduct, SerOrderQuery serOrderQuery) throws Exception {
		PageHelper.startPage(sysProduct.getCurrentPage(), sysProduct.getPageSize());
		List<SysProduct> list = new ArrayList<SysProduct>();
		if(StringUtils.isEmpty(sysProduct.getSysProductOrderNumber())){
			list = sysProductDao.selectByAttributeAnd(sysProduct);
		}else{
			list= sysProductDao.selectProductConsultOrder(sysProduct);
		}
		PageInfo<SysProduct> page = new PageInfo<SysProduct>(list);
		this.filtrationProductListStaffSalePriceAndOrdinarySalePrice(list, serOrderQuery.getCustomerId());
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils updateProductsPriceByList(SysProductParam sysProductParam) throws Exception {
		List<String> sysProductIds = sysProductParam.getSysProductIds();
		List<BigDecimal> sysProductPrices = sysProductParam.getSysProductPrices();
		List<BigDecimal> sysProductStaffBidPrice = sysProductParam.getSysProductStaffBidPrice();
		List<BigDecimal> sysProductOrdinaryBidPrice = sysProductParam.getSysProductOrdinaryBidPrice();
		if(sysProductIds.size() != sysProductPrices.size() || sysProductIds.size() != sysProductStaffBidPrice.size() || 
				sysProductIds.size() != sysProductOrdinaryBidPrice.size()){
			throw new RuntimeException(Constant.UPDATE_PRODUCT_BY_LIST_FOR_SIZE_ERROR);
		}
		Integer updateCount = 0;
		for (int i = 0; i < sysProductIds.size(); i++) {
			SysProduct sysProduct = new SysProduct();
			sysProduct.setSysProductId(sysProductIds.get(i));
			sysProduct.setSysProductPrice(sysProductPrices.get(i));
			sysProduct.setSysProductStaffBidPrice(sysProductStaffBidPrice.get(i));
			sysProduct.setSysProductOrdinaryBidPrice(sysProductOrdinaryBidPrice.get(i));
			updateCount = updateCount + sysProductDao.updateByPrimaryKeySelective(sysProduct);
		}
		/**
		 * 修改当天配送的订单的对应商品的进价
		 */
		SerOrderQuery serOrderQuery = new SerOrderQuery();
		serOrderQuery.setOrderSendTime(Utils.getNowDate());
		List<SerOrder> list = serOrderDao.selectSerOrderBySendTime(serOrderQuery);
		
		SysProductQuery sysProductQuery = new SysProductQuery();

		for (int i = 0; i < sysProductIds.size(); i++) {
			for (SerOrder serOrder : list) {
				sysProductQuery.setSerOrderId(serOrder.getSerOrderId());
				sysProductQuery.setProductId(sysProductIds.get(i));
				BetOrderProduct betOrderProduct = betOrderProductDao.selectBetOrderProductBySerOrderIdAndProductId(sysProductQuery);
				if(betOrderProduct != null){
					betOrderProduct.setBetOrderProductProductBidPrice(serOrder.getSerOrderType().equals(2) 
							? sysProductStaffBidPrice.get(i) : sysProductOrdinaryBidPrice.get(i));
					betOrderProductDao.updateByPrimaryKeySelective(betOrderProduct);
				}
			}
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}

	@Override
	public ReturnUtils productsListForOrderDetails(SysProductQuery sysProductQuery) {
		SerOrder serOrder = serOrderDao.selectByOrderNumber(sysProductQuery.getOrderNumber());
		SysCustomerGroup sysCustomerGroup = sysCustomerGroupDao.selectSysCustomerGroupByCustomerId(
				serOrder.getSerOrderCustomerId());
		PageHelper.startPage(sysProductQuery.getCurrentPage(), sysProductQuery.getPageSize());
		List<SysProduct> list = sysProductDao.productsListForOrderDetails(sysProductQuery);
		PageInfo<SysProduct> page = new PageInfo<SysProduct>(list);
		if(sysCustomerGroup != null){
			SysCustomerGroupProductQuery sysCustomerGroupProductQuery = new SysCustomerGroupProductQuery();
			for (SysProduct sysProduct : list) {
				sysCustomerGroupProductQuery.setSysCustomerGroupId(sysCustomerGroup.getSysCustomerGroupId());
				sysCustomerGroupProductQuery.setSysProductId(sysProduct.getSysProductId());
				SysCustomerGroupProduct sysCustomerGroupProduct = sysCustomerGroupProductDao.
						selectSysCustomerGroupProductByCustomerGroupIdAndProductId(sysCustomerGroupProductQuery);
				if(sysCustomerGroupProduct != null){
					sysProduct.setSysProductPrice(serOrder.getSerOrderType().equals(1) ? 
							sysCustomerGroupProduct.getSysCustomerGroupProductProductOrdinaryPrice() : 
								sysCustomerGroupProduct.getSysCustomerGroupProductProductStaffPrice());
					sysProduct.setSysProductStaffSelfPrice(sysCustomerGroupProduct.getSysCustomerGroupProductProductStaffPrice());
					sysProduct.setSysProductOrdinarySalePrice(sysCustomerGroupProduct.getSysCustomerGroupProductProductOrdinaryPrice());
				}else{
					sysProduct.setSysProductStaffSelfPrice(sysProduct.getSysProductPrice());
					sysProduct.setSysProductOrdinarySalePrice(sysProduct.getSysProductPrice());
				}
			}
		}else{
			for (SysProduct sysProduct : list) {
				sysProduct.setSysProductStaffSelfPrice(sysProduct.getSysProductPrice());
				sysProduct.setSysProductOrdinarySalePrice(sysProduct.getSysProductPrice());
			}
		}
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	/**
	 * 添加商品过后添加分组模板商品
	 * @param sysProduct
	 */
	private void insertSysCustomerGroupProductAfterInsertSysProduct(SysProduct sysProduct){
		List<SysCustomerGroup> list = sysCustomerGroupDao.selectEffectiveSysCustomerGroup();
		SysCustomerGroupProduct sysCustomerGroupProduct = new SysCustomerGroupProduct();
		for (SysCustomerGroup sysCustomerGroup : list) {
			sysCustomerGroupProduct.setSysCustomerGroupProductId(Utils.createPrimaryKey());
			sysCustomerGroupProduct.setSysCustomerGroupProductGroupId(sysCustomerGroup.getSysCustomerGroupId());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductId(sysProduct.getSysProductId());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductName(sysProduct.getSysProductName());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductStaffPrice(sysProduct.getSysProductPrice());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductOrdinaryPrice(sysProduct.getSysProductPrice());
			sysCustomerGroupProduct.setSysCustomerGroupProductStaffBidPrice(sysProduct.getSysProductStaffBidPrice());
			sysCustomerGroupProduct.setSysCustomerGroupProductOrdinaryBidPrice(sysProduct.getSysProductOrdinaryBidPrice());
			sysCustomerGroupProductDao.insertSelective(sysCustomerGroupProduct);
		}
	}
	
	/**
	 * 过滤商品列表的员工餐卖价和普通卖价
	 * @return
	 */
	private List<SysProduct> filtrationProductListStaffSalePriceAndOrdinarySalePrice(List<SysProduct> list,
			String customerId){
		SysCustomerGroup sysCustomerGroup = sysCustomerGroupDao.selectSysCustomerGroupByCustomerId(customerId);
		/**
		 * 分组在且生效
		 * 进行两个卖价的过滤
		 */
		if(null != sysCustomerGroup && sysCustomerGroup.getSysCustomerGroupState().equals(1)){
			SysCustomerGroupProductQuery sysCustomerGroupProductQuery = new SysCustomerGroupProductQuery();
			for (SysProduct sysProduct : list) {
				sysCustomerGroupProductQuery.setSysCustomerGroupId(sysCustomerGroup.getSysCustomerGroupId());
				sysCustomerGroupProductQuery.setSysProductId(sysProduct.getSysProductId());
				SysCustomerGroupProduct sysCustomerGroupProduct = sysCustomerGroupProductDao.
						selectSysCustomerGroupProductByCustomerGroupIdAndProductId(sysCustomerGroupProductQuery);
				/**
				 * 模板商品存在且有效
				 */
				if(null != sysCustomerGroupProduct ){
					sysProduct.setSysProductStaffSelfPrice(sysCustomerGroupProduct.getSysCustomerGroupProductProductStaffPrice());
					sysProduct.setSysProductOrdinarySalePrice(sysCustomerGroupProduct.getSysCustomerGroupProductProductOrdinaryPrice());
				}
			}
		}
		/**
		 * 针对没有分组的，
		 * 商品设置为原价
		 */
		for (SysProduct sysProduct : list) {
			if(null == sysProduct.getSysProductStaffSelfPrice()){
				sysProduct.setSysProductStaffSelfPrice(sysProduct.getSysProductPrice());
			}
			if(null == sysProduct.getSysProductOrdinarySalePrice()){
				sysProduct.setSysProductOrdinarySalePrice(sysProduct.getSysProductPrice());
			}
		}
		return list;
	}
	
}
