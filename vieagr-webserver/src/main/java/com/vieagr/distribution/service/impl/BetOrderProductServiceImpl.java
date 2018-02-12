package com.vieagr.distribution.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.dao.BetOrderProductDao;
import com.vieagr.distribution.dao.SerOrderDao;
import com.vieagr.distribution.dao.SysProductDao;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.param.SerOrderParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.IBetOrderProductService;
import com.vieagr.distribution.service.inter.ISerOrderService;

@Service
@Transactional
public class BetOrderProductServiceImpl extends BaseService<BetOrderProduct> implements IBetOrderProductService{

	@Autowired
	private BetOrderProductDao betOrderProductDao;

	@Autowired
	private SysProductDao sysProductDao;
	
	@Autowired
	private ISerOrderService serOrderService;
	
	@Autowired
	private SerOrderDao serOrderDao;
	
	@Override
	public List<BetOrderProduct> selectBetOrderProductListByQuery(SerOrderQuery serOrderQuery) throws Exception {
		return betOrderProductDao.selectBetOrderProductsAndCustomerInfo(serOrderQuery);
	}

	@Override
	public Integer saveBetOrderProductList(List<SysProduct> sysProducts, String serOrderId, SerOrder serOrder) throws Exception {
		Integer saveCode = 0;
		for (SysProduct sysProduct : sysProducts) {
			SysProduct product = sysProductDao.selectByPrimaryKey(sysProduct.getSysProductId());
			BetOrderProduct betOrderProduct = new BetOrderProduct();
			betOrderProduct.setBetOrderProductId(Utils.createPrimaryKey());
			betOrderProduct.setBetOrderProductOrderId(serOrderId);
			betOrderProduct.setBetOrderProductOrderNumber(serOrder.getSerOrderNumber());
			betOrderProduct.setBetOrderProductProductId(product.getSysProductId());
			betOrderProduct.setBetOrderProductProductName(product.getSysProductName());
			betOrderProduct.setBetOrderProductProductTypeId(product.getSysProductProductTypeId());
			betOrderProduct.setBetOrderProductProductCount(sysProduct.getSysProductCount());
			betOrderProduct.setBetOrderProductProductUnitName(product.getSysProductUnitName());
			betOrderProduct.setBetOrderProductCreateTime(Utils.getNowTime());
			betOrderProduct.setBetOrderProductProductSalePrice(sysProduct.getSysProductSalePrice());
			betOrderProduct.setBetOrderProductProductFormerPrice(product.getSysProductPrice());
			if(!serOrder.getSerOrderType().equals(EnumConfig.SER_ORDER_TYPE_MODEL.getIndex())){
				betOrderProduct.setBetOrderProductProductBidPrice(
						serOrder.getSerOrderType().equals(1) ? product.getSysProductOrdinaryBidPrice() : 
							product.getSysProductStaffBidPrice());
			}
			betOrderProduct.setBetOrderProductUnivalentRemark(sysProduct.getBetOrderProductUnivalentRemark());
			betOrderProduct.setBetOrderProductDelFlag(EnumConfig.SYSTEM_IS_NOT_DELETE.getIndex());
			BigDecimal productTotalPrice = sysProduct.getSysProductSalePrice().multiply(
					new BigDecimal(sysProduct.getSysProductCount()));
			betOrderProduct.setBetOrderProductProductTotal(productTotalPrice);
			saveCode += betOrderProductDao.insert(betOrderProduct);
		}
		return saveCode;
	}

	@Override
	public BetOrderProduct selectBetOrderProductsByBetOrderProductIdAndOrderNumber(SerOrderQuery serOrderQuery) throws Exception {
		return betOrderProductDao.selectBetOrderProductsByBetOrderProductIdAndOrderNumber(serOrderQuery);
	}

	@Override
	public Integer updateByOrderNumberAndBetOrderProductIdSelective(BetOrderProduct betOrderProduct) {
		betOrderProduct.setBetOrderProductProductTotal(betOrderProduct.getBetOrderProductProductSalePrice().
				multiply(new BigDecimal(betOrderProduct.getBetOrderProductProductCount())));
		return betOrderProductDao.updateByOrderNumberAndBetOrderProductIdSelective(betOrderProduct);
	}

	@Override
	public List<BetOrderProduct> selectProductsForUnifyUpdateOrder(SerOrderQuery serOrderQuery) throws Exception {
		List<String> orderNumbers = serOrderQuery.getOrderNumbers();
		String orderNumberArrays = "";
		for (String orderNumber : orderNumbers) {
			if(orderNumberArrays.length() == 0){
				orderNumberArrays = orderNumber;
			}else{
				orderNumberArrays = orderNumberArrays + "," + orderNumber;
			}
		}
		serOrderQuery.setOrderNumberArrays("(" + orderNumberArrays + ")");
		return betOrderProductDao.selectProductsForUnifyUpdateOrder(serOrderQuery);
	}

	@Override
	public Integer updateProductSalePrice(SerOrderParam serOrderParam) throws Exception {
		Integer updateCode = 0;
		List<String> orderNumbers = serOrderParam.getOrderNumbers();
		SerOrderQuery serOrderQuery = new SerOrderQuery();
		serOrderQuery.setSysProductId(serOrderParam.getSysProductId());
		for (String orderNumber : orderNumbers) {
			serOrderParam.setOrderNumber(orderNumber);
			Integer updateOneCode = betOrderProductDao.updateProductSalePrice(serOrderParam);
			serOrderQuery.setOrderNumber(orderNumber);
			BetOrderProduct betOrderProduct = betOrderProductDao.selectBetOrderProductByProductIdAndOrderNumber(serOrderQuery);
			if(betOrderProduct != null){
				betOrderProduct.setBetOrderProductProductTotal(betOrderProduct.getBetOrderProductProductSalePrice().multiply(
						new BigDecimal(betOrderProduct.getBetOrderProductProductCount())));
				betOrderProductDao.updateByPrimaryKeySelective(betOrderProduct);
				updateCode = updateCode + updateOneCode;
				serOrderService.updateOrderTotalAmount(orderNumber);
			}
		}
		return updateCode;
	}

	@Override
	public Integer insertProductForOrderDetails(SerOrderParam serOrderParam) throws Exception {
		SerOrder serOrder = serOrderDao.selectByOrderNumber(serOrderParam.getOrderNumber());
		SysProduct sysProduct = sysProductDao.selectByPrimaryKey(serOrderParam.getSysProductId());
		BetOrderProduct betOrderProduct = new BetOrderProduct();
		betOrderProduct.setBetOrderProductId(Utils.createPrimaryKey());
		betOrderProduct.setBetOrderProductOrderId(serOrder.getSerOrderId());
		betOrderProduct.setBetOrderProductOrderNumber(serOrder.getSerOrderNumber());
		betOrderProduct.setBetOrderProductProductId(sysProduct.getSysProductId());
		betOrderProduct.setBetOrderProductProductName(sysProduct.getSysProductName());
		betOrderProduct.setBetOrderProductProductTypeId(sysProduct.getSysProductProductTypeId());
		betOrderProduct.setBetOrderProductProductCount(serOrderParam.getBetOrderProductProductCount());
		betOrderProduct.setBetOrderProductProductUnitName(sysProduct.getSysProductUnitName());
		betOrderProduct.setBetOrderProductCreateTime(Utils.getNowTime());
		betOrderProduct.setBetOrderProductProductFormerPrice(sysProduct.getSysProductPrice());
		betOrderProduct.setBetOrderProductProductSalePrice(serOrderParam.getUpdatePrice());
		betOrderProduct.setBetOrderProductProductBidPrice(serOrder.getSerOrderType().equals(1) 
				? sysProduct.getSysProductOrdinaryBidPrice() : 
					sysProduct.getSysProductStaffBidPrice());
		betOrderProduct.setBetOrderProductProductTotal(serOrderParam.getUpdatePrice().multiply(
				new BigDecimal(serOrderParam.getBetOrderProductProductCount())));
		betOrderProduct.setBetOrderProductDelFlag(EnumConfig.SYSTEM_IS_NOT_DELETE.getIndex());
		int insertCode = betOrderProductDao.insert(betOrderProduct);
		if(insertCode >=0){
			serOrderService.updateOrderTotalAmount(serOrderParam.getOrderNumber());
		}
		return insertCode;
	}

	@Override
	public ReturnUtils deleteProductForOrderDetails(SerOrderParam serOrderParam) {
		betOrderProductDao.deleteProductForOrderDetails(serOrderParam);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.SYS_PRODUCT_ADD_SUCCESS);
	}

	@Override
	public ReturnUtils updateProductPriceForProductsAndOrders(SerOrderParam serOrderParam) throws Exception {
		List<SysProduct> products = serOrderParam.getProducts();
		List<String> orderNumbers = serOrderParam.getOrderNumbers();
		SerOrderQuery serOrderQuery = new SerOrderQuery();
		for (int i = 0; i < orderNumbers.size(); i++) {
			for (int j = 0; j < products.size(); j++) {
				String orderNumber = orderNumbers.get(i);
				BetOrderProduct betOrderProduct = new BetOrderProduct();
				betOrderProduct.setBetOrderProductProductSalePrice(products.get(j).getSysProductSalePrice());
				betOrderProduct.setBetOrderProductProductId(products.get(j).getSysProductId());
				betOrderProduct.setBetOrderProductOrderNumber(orderNumber);
				serOrderQuery.setBetOrderProductId(products.get(j).getSysProductId());
				serOrderQuery.setOrderNumber(orderNumbers.get(i));
				BetOrderProduct betOrderProductForSelect = betOrderProductDao.selectBetOrderProductsByBetOrderProductProductIdAndOrderNumber(serOrderQuery);
				if(betOrderProductForSelect != null){
					betOrderProduct.setBetOrderProductProductTotal(betOrderProduct.getBetOrderProductProductSalePrice().
							multiply(new BigDecimal(betOrderProductForSelect.getBetOrderProductProductCount())));
					betOrderProductDao.updateByOrderNumberAndBetOrderProductProductIdSelective(betOrderProduct);
				}
			}
			serOrderService.updateOrderTotalAmount(orderNumbers.get(i));
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}

}
