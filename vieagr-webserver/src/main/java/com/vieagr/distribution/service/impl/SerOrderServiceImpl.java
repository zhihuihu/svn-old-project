package com.vieagr.distribution.service.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.dao.BetOrderProductDao;
import com.vieagr.distribution.dao.SerOrderDao;
import com.vieagr.distribution.dao.SysCustomerDao;
import com.vieagr.distribution.dao.SysProductDao;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysCustomer;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.param.SerOrderParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.response.IndexResponse;
import com.vieagr.distribution.response.SerOrderResponse;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.IBetOrderProductService;
import com.vieagr.distribution.service.inter.ISerOrderService;

@Service
@Transactional
public class SerOrderServiceImpl extends BaseService<SerOrder> implements ISerOrderService{

	@Autowired
	private SerOrderDao serOrderDao;
	
	@Autowired
	private IBetOrderProductService betOrderProductService;
	
	@Autowired
	private BetOrderProductDao betOrderProductDao;
	
	@Autowired
	private SysCustomerDao sysCustomerDao;
	
	@Autowired
	private SysProductDao sysProductDao;
	
	@Override
	public ReturnUtils selectOrderList(SerOrderQuery serOrderQuery) throws Exception{
		PageHelper.startPage(serOrderQuery.getCurrentPage(), serOrderQuery.getPageSize());
		List<SerOrder> list = serOrderDao.selectOrdersAndCustomerInfos(serOrderQuery);
		PageInfo<SerOrder> page = new PageInfo<SerOrder>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils selectOrderList(SerOrder serOrder) throws Exception {
		PageHelper.startPage(serOrder.getCurrentPage(), serOrder.getPageSize());
		SerOrderQuery serOrderQuery = Utils.exchangeObject(serOrder, SerOrderQuery.class);
		serOrderQuery.setOrderPlaceTime(serOrder.getSerOrderSendTime());
		List<SerOrder> list = serOrderDao.selectOrdersAndCustomerInfos(serOrderQuery);
		PageInfo<SerOrder> page = new PageInfo<SerOrder>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}
	
	@Override
	public Map<String, Object> joinOrderAndProductTogether(List<String> poductInfos, List<String> customerStoreNames, 
			List<BetOrderProduct> betOrderProducts) {
		Map<String, Object> productInfoMaps = new HashMap<String, Object>();
		productInfoMaps.put("poductInfos", poductInfos);
		for (int i = 0; i < poductInfos.size(); i++) {
			Map<String, String> productInfoMap = new HashMap<String, String>();
			String productInfo = poductInfos.get(i);
			productInfoMap.put("2", productInfo.split(",")[0]);
			productInfoMap.put("3", productInfo.split(",")[1]);
			productInfoMaps.put(productInfo, productInfoMap);
		}
		for (int i = 0; i < betOrderProducts.size(); i++) {
			BetOrderProduct betOrderProduct = betOrderProducts.get(i);
			String mapKey = betOrderProduct.getBetOrderProductProductName() + "," + betOrderProduct.getBetOrderProductProductUnitName();
			@SuppressWarnings("unchecked")
			Map<String, String> productInfoMap = (Map<String, String>) productInfoMaps.get(mapKey);
			if(productInfoMap != null){
				String index =  customerStoreNames.indexOf(betOrderProduct.getSysCustomerStoreName()) + 4 + "";
				String lastCount = productInfoMap.get(index);
				String newCount = betOrderProduct.getBetOrderProductProductCount();
				productInfoMap.put(index,lastCount == null ? newCount.toString() : ((new BigDecimal(lastCount)).add(new BigDecimal(newCount))) + ""
						);
				if(!StringUtils.isEmpty(betOrderProduct.getBetOrderProductUnivalentRemark())){
					productInfoMap.put("@" + index, betOrderProduct.getBetOrderProductUnivalentRemark());
				}
			}
		}
		return productInfoMaps;
	}

	@Override
	public List<String> joinCustomerStoreNamesTogether(List<SerOrder> serOrders) {
		List<String> customerStoreNames = new ArrayList<String>();
		for (SerOrder serOrder : serOrders) {
			if(!customerStoreNames.contains(serOrder.getSysCustomerStoreName())){
				customerStoreNames.add(serOrder.getSysCustomerStoreName());
			}
		}
		return customerStoreNames;
	}

	@Override
	public List<SerOrder> selectOrdersAndCustomersBySendTime(SerOrderQuery serOrderQuery) {
		return serOrderDao.selectOrdersAndCustomersBySendTime(serOrderQuery);
	}

	@Override
	public List<String> joinPorductNamesTogether(List<BetOrderProduct> betOrderProducts) {
		List<String> productNames = new ArrayList<String>();
		for (BetOrderProduct betOrderProduct : betOrderProducts) {
			String productInfo = betOrderProduct.getBetOrderProductProductName() + ","
					+ betOrderProduct.getBetOrderProductProductUnitName();
			if(!productNames.contains(productInfo)){
				productNames.add(productInfo);
			}
		}
		return productNames;
	}

	@Override
	public Integer saveOrderAndBetOrderProduct(SerOrderParam serOrderParam) throws Exception {
		SerOrder serOrder = Utils.exchangeObject(serOrderParam, SerOrder.class);
		serOrder.setSerOrderId(UUID.randomUUID().toString());
		serOrder.setSerOrderNumber(Utils.getOrderNo(serOrder.getSerOrderType()));
		serOrder.setSerOrderCreaterId(serOrderParam.getSerOrderCreaterId());
		serOrder.setSerOrderCreateTime(Utils.getNowTime());
		List<SysProduct> products = serOrderParam.getProducts();
		serOrder.setSerOrderProductCount(products.size());
		BigDecimal orderTotalPrice = new BigDecimal(0);
		for (SysProduct sysProduct : products) {
			orderTotalPrice = orderTotalPrice.add(sysProduct.getSysProductSalePrice().multiply(
					new BigDecimal(sysProduct.getSysProductCount())));
		}
		serOrder.setSerOrderAmount(orderTotalPrice);
		serOrder.setSerOrderState(EnumConfig.SER_ORDER_STATE_TO_BE_DISTRIBUTION.getIndex());
		serOrder.setSerOrderDelFlag(EnumConfig.SYSTEM_IS_NOT_DELETE.getIndex());
		int saveCode = serOrderDao.insert(serOrder);
		if(saveCode > 0){
			Integer saveBetCode = betOrderProductService.saveBetOrderProductList(
					products, serOrder.getSerOrderId(), serOrder);
			if(saveBetCode == products.size()){
				/**
				 * 设置记忆订单标志
				 */
//				this.updateMemoryOrder(serOrder);
				return saveBetCode;
			}else{
				throw new RuntimeException("订单商品中间表保存异常");
			}
		}else{
			throw new RuntimeException("订单保存失败");
		}
	}

	@Override
	public SerOrderResponse selectOrderByOrderNumber(String orderNumber) throws Exception {
		SerOrderResponse serOrderResponse = new SerOrderResponse();
		SerOrder serOrder = serOrderDao.selectByOrderNumber(orderNumber);
		SerOrderQuery serOrderQuery = new SerOrderQuery();
		serOrder.setSysCustomerName(sysCustomerDao.selectByPrimaryKey(serOrder.getSerOrderCustomerId()).getSysCustomerName());
		serOrderResponse.setSerOrder(serOrder);
		serOrderQuery.setOrderNumber(orderNumber);
		List<BetOrderProduct> list = betOrderProductService.selectBetOrderProductListByQuery(serOrderQuery);
		serOrderResponse.setProducts(list);
		BigDecimal totalPrice = new BigDecimal("0");
		for (BetOrderProduct betOrderProduct : list) {
			totalPrice = totalPrice.add(betOrderProduct.getBetOrderProductProductTotal());
		}
		serOrderResponse.setOrderTotalPrice(totalPrice);
		serOrderResponse.setSendTime(serOrder.getSerOrderSendTime());
		return serOrderResponse;
	}

	@Override
	public SerOrder selectOneNewOrderByCustomerId(SerOrderQuery serOrderQuery) {
		return serOrderDao.selectOneNewOrderByCustomerId(serOrderQuery);
	}

	@Override
	public Integer updateByOrderNumberSelective(SerOrder serOrder) {
		return serOrderDao.updateByOrderNumberSelective(serOrder);
	}

	@Override
	public Integer updateOrderTotalAmount(String orderNumber) throws Exception {
		SerOrder serOrder = this.selectOrderByOrderNumber(orderNumber).getSerOrder();
		SerOrderQuery serOrderQuery = new SerOrderQuery();
		serOrderQuery.setOrderNumber(orderNumber);
		List<BetOrderProduct> betOrderProducts = betOrderProductService.selectBetOrderProductListByQuery(serOrderQuery);
		BigDecimal orderTotal = new BigDecimal("0");
		for (BetOrderProduct betOrderProduct : betOrderProducts) {
			orderTotal = orderTotal.add(betOrderProduct.getBetOrderProductProductSalePrice().multiply(
					new BigDecimal(betOrderProduct.getBetOrderProductProductCount())));
		}
		serOrder.setSerOrderAmount(orderTotal);
		return this.updateByPrimaryKeySelective(serOrder);
	}

	@Override
	public List<SerOrderResponse> readOrderDetailsListForStamp(SerOrderParam serOrderParam) throws Exception {
		List<String> orderNumbers = serOrderParam.getOrderNumbers();
		List<SerOrderResponse> serOrderResponses = new ArrayList<SerOrderResponse>();
		for (String orderNumber : orderNumbers) {
			SerOrderResponse serOrderResponse = new SerOrderResponse();
			SerOrderQuery serOrderQuery = new SerOrderQuery();
			SerOrder serOrder = serOrderDao.selectByOrderNumber(orderNumber);
			serOrder.setSysCustomerName(sysCustomerDao.selectByPrimaryKey(serOrder.getSerOrderCustomerId()).getSysCustomerName());
			serOrderResponse.setSerOrder(serOrder);
			serOrderQuery.setOrderNumber(orderNumber);
			List<BetOrderProduct> list = betOrderProductService.selectBetOrderProductListByQuery(serOrderQuery);
			serOrderResponse.setProducts(list);
			BigDecimal totalPrice = new BigDecimal("0");
			for (BetOrderProduct betOrderProduct : list) {
				totalPrice = totalPrice.add(betOrderProduct.getBetOrderProductProductTotal());
			}
			serOrderResponse.setOrderTotalPrice(totalPrice);
			serOrderResponses.add(serOrderResponse);
		}
		return serOrderResponses;
	}

	@Override
	public SerOrderResponse readOrderDetailsForStamp(SerOrderParam serOrderParam) throws Exception {
		SerOrderResponse serOrderResponse = this.selectOrderByOrderNumber(serOrderParam.getOrderNumber());
		serOrderResponse.setCustomerName(sysCustomerDao.selectByPrimaryKey(
		serOrderResponse.getSerOrder().getSerOrderCustomerId()).getSysCustomerRealName());
		return serOrderResponse;
	}

	@Override
	public IndexResponse classiFicationGetCount(String toDay) {
		IndexResponse indexResponse = new IndexResponse();
		indexResponse.setOrderCount(serOrderDao.selectOrderCount());
		indexResponse.setToDayOrderCount(serOrderDao.selectToDayOrderCount(toDay));
		indexResponse.setProductCount(sysProductDao.selectProductCount());
		indexResponse.setCustomerCount(sysCustomerDao.selectCustomerCount());
		return indexResponse;
	}

	@Override
	public ReturnUtils selectToDayOrderInfo(SerOrderQuery serOrderQuery) {
		PageHelper.startPage(serOrderQuery.getCurrentPage(), serOrderQuery.getPageSize());
		List<SerOrder> list = serOrderDao.selectToDayOrderInfo(serOrderQuery);
		PageInfo<SerOrder> page = new PageInfo<SerOrder>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public Object readChartData() {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		Map<String, Object> titleMap = new HashMap<String, Object>();
		titleMap.put("text", Constant.CHART_OF_TITLE);
		dataMap.put("title", titleMap);
		
		List<String> xAxisList = new ArrayList<String>();
		for (int i = -6; i <= Constant.CHART_WEEK_OF_COUNT; i++) {
			xAxisList.add(Utils.addAnyDay(Utils.getNowDate(), "yyyy-MM-dd", i));
		}
		Map<String, Object> xAxisMap = new HashMap<String, Object>();
		xAxisMap.put("categories", xAxisList);
		dataMap.put("xAxis", xAxisMap);
		
		Map<String, Object> yAxisMap = new HashMap<String, Object>();
		Map<String, Object> yAxisTitleMap = new HashMap<String, Object>();
		yAxisTitleMap.put("text", Constant.CHART_OF_Y_TITLE);
		yAxisMap.put("title", yAxisTitleMap);
		dataMap.put("yAxis", yAxisMap);
		
		Map<String, Object> plotOptionsMap = new HashMap<String, Object>();
		Map<String, Object> lineMap = new HashMap<String, Object>();
		Map<String, Object> dataLabelsMap = new HashMap<String, Object>();
		lineMap.put("dataLabels", dataLabelsMap);
		plotOptionsMap.put("line", lineMap);
		dataMap.put("plotOptions", plotOptionsMap);
		
		List<Map<String, Object>> seriesList = new ArrayList<Map<String, Object>>();
		Map<String, Object> seriesMap = new HashMap<String, Object>();
		seriesMap.put("name",Constant.CHART_OF_LINE_NAME);
		List<BigDecimal> amountsList = getOrderAmountOfDay(xAxisList);
		seriesMap.put("data", amountsList);
		seriesList.add(seriesMap);
		dataMap.put("series", seriesList);
		
		return dataMap;
	}
	
	/**
	 * 获取该日订单总金额
	 * @return
	 */
	private List<BigDecimal> getOrderAmountOfDay(List<String> orderSendTimes){
		List<BigDecimal> amountsList = new ArrayList<BigDecimal>();
		for (String orderSendTime : orderSendTimes){
			BigDecimal tempTotal = serOrderDao.selectOrderAmountOfDay(orderSendTime);
			if(tempTotal != null){
				amountsList.add(tempTotal);
			}else{
				amountsList.add(new BigDecimal("0"));
			}
		}
		return amountsList;
	}

	@Override
	public ReturnUtils unifiedUpdateProductSalePriceForOneOrder(SerOrderParam serOrderParam) throws Exception {
		List<BetOrderProduct> betOrderProducts = serOrderParam.getBetOrderProducts();
		for (BetOrderProduct betOrderProduct : betOrderProducts) {
			betOrderProductService.updateByOrderNumberAndBetOrderProductIdSelective(betOrderProduct);
		}
		this.updateOrderTotalAmount(betOrderProducts.get(0).getBetOrderProductOrderNumber());
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}

	@Override
	public Integer saveTempOrderAndBetOrderProduct(SerOrderParam serOrderParam) throws Exception {
		SerOrder serOrder = Utils.exchangeObject(serOrderParam, SerOrder.class);
		serOrder.setSerOrderId(UUID.randomUUID().toString());
		serOrder.setSerOrderNumber(Utils.getOrderNo(serOrder.getSerOrderType()));
		serOrder.setSerOrderCreaterId(serOrderParam.getSerOrderCreaterId());
		serOrder.setSerOrderCreateTime(Utils.getNowTime());
		List<SysProduct> products = serOrderParam.getProducts();
		serOrder.setSerOrderProductCount(products.size());
		serOrder.setSerOrderState(EnumConfig.SER_ORDER_STATE_TO_BE_DISTRIBUTION.getIndex());
		serOrder.setSerOrderDelFlag(EnumConfig.SYSTEM_IS_NOT_DELETE.getIndex());
		serOrder.setSerOrderChangeTimes(1);
		serOrder.setSerOrderType(EnumConfig.SER_ORDER_TYPE_MODEL.getIndex());
		int saveCode = serOrderDao.insert(serOrder);
		if(saveCode > 0){
			Integer saveBetCode = betOrderProductService.saveBetOrderProductList(
					products, serOrder.getSerOrderId(), serOrder);
			if(saveBetCode == products.size()){
				return saveBetCode;
			}else{
				throw new RuntimeException("订单商品中间表保存异常");
			}
		}else{
			throw new RuntimeException("订单保存失败");
		}
	}
	
//	/**
//	 * 设置每个门店的记忆订单标准
//	 * 暂时以订单修改次数为1为记忆订单的标志
//	 * @throws Exception 
//	 */
//	private void updateMemoryOrder(SerOrder serOrder) throws Exception{
//		SerOrder memoryOrder = serOrderDao.selectMemoryOrderForCustomer(serOrder.getSerOrderCustomerId());
//		if(memoryOrder != null){
//			if(serOrder.getSerOrderProductCount() >= memoryOrder.getSerOrderProductCount()){
//				memoryOrder.setSerOrderChangeTimes(null);
//				serOrder.setSerOrderChangeTimes(1);
//				serOrderDao.updateByPrimaryKey(memoryOrder);
//				serOrderDao.updateByPrimaryKeySelective(serOrder);
//			}
//		}else{
//			serOrder.setSerOrderChangeTimes(1);
//			serOrderDao.updateByPrimaryKeySelective(serOrder);
//		}
//	}

	@Override
	public SerOrder selectMemoryOrderForCustomer(String sysCustomerId) throws Exception {
		return serOrderDao.selectMemoryOrderForCustomer(sysCustomerId);
	}
	
	@Override
	public ReturnUtils updateSerTempOrder(SerOrderParam serOrderParam) throws Exception {
		List<BetOrderProduct> betOrderProducts = serOrderParam.getBetOrderProducts();
		for (BetOrderProduct betOrderProduct : betOrderProducts) {
			betOrderProductService.updateByPrimaryKeySelective(betOrderProduct);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}

	@Override
	public SerOrderResponse downLoadCustomerOrdersByMonthDate(String monthDate, String customerId, Integer orderType) throws Exception {
		SerOrderResponse serOrderResponse = new SerOrderResponse();
		SerOrder serOrder = new SerOrder();
		serOrder.setMonthDate(monthDate);
		serOrder.setSerOrderCustomerId(customerId);
		serOrder.setSerOrderType(orderType);
		
		List<SerOrder> list = serOrderDao.selectOrdersForCustomerExcel(serOrder);
		Map<String, Object> betOrderProductsMap = this.getBetOrderProductsMapBySerOrderList(list);
		SysCustomer sysCustomer = sysCustomerDao.selectByPrimaryKey(customerId);
		InputStream inputStream = Utils.downLoadCustomerOrdersExcel(list, betOrderProductsMap, 
				(Integer)betOrderProductsMap.get("maxRowNumber"), orderType, 
				sysCustomer.getSysCustomerName());
		
		serOrderResponse.setCustomerName(sysCustomer.getSysCustomerName());
		serOrderResponse.setExcelInputStream(inputStream);
		return serOrderResponse;
	}

	@Override
	public SerOrderResponse downLoadCustomerOrdersByDetailsDate(String startDate, String endDate, String customerId,
			Integer orderType) throws Exception {
		SerOrderResponse serOrderResponse = new SerOrderResponse();
		SerOrder serOrder = new SerOrder();
		serOrder.setStartTime(startDate);
		serOrder.setEndTime(endDate);
		serOrder.setSerOrderCustomerId(customerId);
		serOrder.setSerOrderType(orderType);
		
		List<SerOrder> list = serOrderDao.selectOrdersForCustomerExcel(serOrder);
		Map<String, Object> betOrderProductsMap = this.getBetOrderProductsMapBySerOrderList(list);
		SysCustomer sysCustomer = sysCustomerDao.selectByPrimaryKey(customerId);
		InputStream inputStream = Utils.downLoadCustomerOrdersExcel(list, betOrderProductsMap, 
				(Integer)betOrderProductsMap.get("maxRowNumber"), orderType, 
				sysCustomer.getSysCustomerName());
		
		serOrderResponse.setCustomerName(sysCustomer.getSysCustomerName());
		serOrderResponse.setExcelInputStream(inputStream);
		return serOrderResponse;
	}
	
	/*
	 * 根据订单列表返回一个订单商品中间表集合的Map
	 */
	@SuppressWarnings("unchecked")
	private Map<String, Object> getBetOrderProductsMapBySerOrderList(List<SerOrder> serOrders){
		Map<String, Object> betOrderProductsMap = new HashMap<String, Object>();
		Integer maxRowNumber = 0;
		/**
		 * 针对同一天不止一条的订单进行
		 * 去重，叠加，处理
		 */
		for (SerOrder serOrder : serOrders) {
			List<BetOrderProduct> betOrderProducts = betOrderProductDao.selectBetOrderProductBySerOrderId(serOrder.getSerOrderId());
			if(null != betOrderProductsMap.get(serOrder.getSerOrderSendTime())){
					List<BetOrderProduct> mergeBetOrderProductsList = this.mergeBetOrderProductsList((List<BetOrderProduct>)
							betOrderProductsMap.get(serOrder.getSerOrderSendTime()), betOrderProducts);
					betOrderProductsMap.put(serOrder.getSerOrderSendTime(), mergeBetOrderProductsList);
					maxRowNumber = mergeBetOrderProductsList.size() > maxRowNumber ? mergeBetOrderProductsList.size() : maxRowNumber;
			}else{
				maxRowNumber = betOrderProducts.size() > maxRowNumber ? betOrderProducts.size() : maxRowNumber;
				betOrderProductsMap.put(serOrder.getSerOrderSendTime(), betOrderProducts);
			}
		}
		betOrderProductsMap.put("maxRowNumber", maxRowNumber);
		return betOrderProductsMap;
	}
	
	/**
	 * 合并同一天的订单详情数据
	 * @param betOrderProductsOne
	 * @param betOrderProductsTwo
	 * @return
	 */
	private List<BetOrderProduct> mergeBetOrderProductsList(List<BetOrderProduct> betOrderProductsOne, 
			List<BetOrderProduct> betOrderProductsTwo){
		/**
		 * 创建一个list作为判断短订单详情的订单的参照物列表，
		 * 判断哪些短订单详情里面的商品是长订单里面所没有的
		 */
		List<String> compareList = new ArrayList<String>();
		if(betOrderProductsOne.size() >= betOrderProductsTwo.size()){
			for (int i = 0; i < betOrderProductsOne.size(); i++) {
				BetOrderProduct betOrderProductData = betOrderProductsOne.get(i);
				compareList.add(i, betOrderProductData.getBetOrderProductProductId());
				for (int j = 0; j < betOrderProductsTwo.size(); j++) {
					if(betOrderProductsTwo.get(j).getBetOrderProductProductId().equals(betOrderProductData.getBetOrderProductProductId())){
						betOrderProductData.setBetOrderProductProductCount((new BigDecimal(betOrderProductData.getBetOrderProductProductCount())
								.add(new BigDecimal(betOrderProductsTwo.get(j).getBetOrderProductProductCount()))).toString());
						betOrderProductData.setBetOrderProductProductTotal(betOrderProductData.getBetOrderProductProductTotal().add(
								betOrderProductsTwo.get(j).getBetOrderProductProductTotal()));
						continue;
					}
				}
			}
			/**
			 * 添加长订单详情里面没有的短订单详情信息
			 */
			for (BetOrderProduct betOrderProduct : betOrderProductsTwo) {
				if(!compareList.contains(betOrderProduct.getBetOrderProductProductId())){
					betOrderProductsOne.add(betOrderProduct);
				}
			}
			return betOrderProductsOne;
		}else{
			for (int i = 0; i < betOrderProductsTwo.size(); i++) {
				BetOrderProduct betOrderProductData = betOrderProductsTwo.get(i);
				compareList.add(i, betOrderProductData.getBetOrderProductProductId());
				for (int j = 0; j < betOrderProductsOne.size(); j++) {
					if(betOrderProductsOne.get(j).getBetOrderProductProductId().equals(betOrderProductData.getBetOrderProductProductId())){
						betOrderProductData.setBetOrderProductProductCount((new BigDecimal(betOrderProductData.getBetOrderProductProductCount())
								.add(new BigDecimal(betOrderProductsOne.get(j).getBetOrderProductProductCount()))).toString());
						betOrderProductData.setBetOrderProductProductTotal(betOrderProductData.getBetOrderProductProductTotal().add(
								betOrderProductsOne.get(j).getBetOrderProductProductTotal()));
						continue;
					}
				}
			}
			/**
			 * 添加长订单详情里面没有的短订单详情信息
			 */
			for (BetOrderProduct betOrderProduct : betOrderProductsOne) {
				if(!compareList.contains(betOrderProduct.getBetOrderProductProductId())){
					betOrderProductsTwo.add(betOrderProduct);
				}
			}
		}
		return betOrderProductsTwo;
	}
}
