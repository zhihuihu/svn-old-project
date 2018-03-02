package com.vieagr.distribution.service.impl;

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
import com.vieagr.distribution.base.util.PropertiesUtils;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.dao.BetCustomerGroupDao;
import com.vieagr.distribution.dao.BetVehiclesCustomerDao;
import com.vieagr.distribution.dao.SerOrderDao;
import com.vieagr.distribution.dao.SysCustomerDao;
import com.vieagr.distribution.dao.SysCustomerGroupDao;
import com.vieagr.distribution.dao.SysCustomerGroupProductDao;
import com.vieagr.distribution.dao.SysProductDao;
import com.vieagr.distribution.dao.SysVehiclesDao;
import com.vieagr.distribution.entity.BetCustomerGroup;
import com.vieagr.distribution.entity.BetVehiclesCustomer;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysCustomer;
import com.vieagr.distribution.entity.SysCustomerGroup;
import com.vieagr.distribution.entity.SysCustomerGroupProduct;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.entity.SysVehicles;
import com.vieagr.distribution.param.SysCustomerParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.query.SysCustomerGroupProductQuery;
import com.vieagr.distribution.query.SysCustomerQuery;
import com.vieagr.distribution.query.SysCustomerSaveQuery;
import com.vieagr.distribution.response.SysCustomerDetailResponse;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISysCustomerService;

@Service
@Transactional
public class SysCustomerServiceImpl extends BaseService<SysCustomer>implements ISysCustomerService{

	@Autowired
	private SysCustomerDao sysCustomerDao;
	
	@Autowired
	private BetVehiclesCustomerDao betVehiclesCustomerDao;
	
	@Autowired
	private SysVehiclesDao sysVehiclesDao;
	
	@Autowired
	private SysCustomerGroupDao sysCustomerGroupDao;
	
	@Autowired
	private BetCustomerGroupDao betCustomerGroupDao;
	
	@Autowired
	private SysCustomerGroupProductDao sysCustomerGroupProductDao;
	
	@Autowired
	private SysProductDao sysProductDao;
	
	@Autowired
	private SerOrderDao serOrderDao;
	
	@Override
	public ReturnUtils selectCustomerList(SysCustomerQuery customerQuery) throws Exception {
		PageHelper.startPage(customerQuery.getCurrentPage(), customerQuery.getPageSize());
		List<SysCustomer> list = sysCustomerDao.selectByAttributeAnd(Utils.exchangeObject(customerQuery, SysCustomer.class));
		PageInfo<SysCustomer> page = new PageInfo<SysCustomer>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils selectCustomerList(SysCustomer sysCustomer) throws Exception {
		PageHelper.startPage(sysCustomer.getCurrentPage(), sysCustomer.getPageSize());
		List<SysCustomer> list = sysCustomerDao.selectByAttributeAnd(sysCustomer);
		PageInfo<SysCustomer> page = new PageInfo<SysCustomer>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils sysCustomerAdd(SysCustomerSaveQuery sysCustomerSaveQuery) throws Exception {
		if(sysCustomerSaveQuery.getBetVehiclesCustomer() == null){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_ADD_CAR);
		}
		if(null == sysCustomerSaveQuery || sysCustomerSaveQuery.getSysCustomer() == null || sysCustomerSaveQuery.getBetVehiclesCustomer() == null){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.DATA_ERROR);
		}
		SysCustomer sysCustomer = sysCustomerSaveQuery.getSysCustomer();
		BetVehiclesCustomer betVehiclesCustomer = sysCustomerSaveQuery.getBetVehiclesCustomer();
		if(betVehiclesCustomer.getBetVehiclesCustomerVehiclesId() == null || betVehiclesCustomer.getBetVehiclesCustomerVehiclesId().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_VEHICLES_ERROR);
		}
		if(sysVehiclesDao.selectByPrimaryKey(betVehiclesCustomer.getBetVehiclesCustomerVehiclesId()) == null){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_VEHICLES_ERROR);
		}
		if(sysCustomer.getSysCustomerName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_ADD_NAME_ERROR);
		}
		if(!Utils.isMobile(sysCustomer.getSysCustomerMobileNumber())){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_ADD_MOBILE_ERROR);
		}
		if(sysCustomer.getSysCustomerStoreAddress().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_ADD_ADDRESS_ERROR);
		}
		if(sysCustomer.getSysCustomerStoreName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_ADD_STORY_NAME_ERROR);
		}
		sysCustomer.setSysCustomerImgUrl(Base64FileUtils.base64ToImageFile(sysCustomer.getSysCustomerImgUrl(), PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		sysCustomer.setSysCustomerId(UUID.randomUUID().toString());
		sysCustomer.setSysCustomerCreateTime(Utils.getNowTime());
		betVehiclesCustomer.setBetVehiclesCustomerId(UUID.randomUUID().toString());
		betVehiclesCustomer.setBetVehiclesCustomerCustomerId(sysCustomer.getSysCustomerId());
		betVehiclesCustomer.setBetVehiclesCustomerCreateTime(Utils.getNowTime());
		sysCustomerDao.insertSelective(sysCustomer);
		betVehiclesCustomerDao.insertSelective(betVehiclesCustomer);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.SYS_CUSTOMER_ADD_SUCCESS);
	}

	@Override
	public ReturnUtils selectCustomerDetailList(SysCustomer sysCustomer) throws Exception {
		PageHelper.startPage(sysCustomer.getCurrentPage(), sysCustomer.getPageSize());
		sysCustomer.setSysCustomerName(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerRealName(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerMobileNumber(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerQqNumber(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerStoreName(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerStoreAddress(sysCustomer.getSearchName());
		List<SysCustomer> list = sysCustomerDao.selectCustomerListByLike(sysCustomer);
		PageInfo<SysCustomer> page = new PageInfo<SysCustomer>(list);
		List<SysCustomerDetailResponse> customerDetailResponses = new ArrayList<>();
		if(null != list && list.size() != 0){
			for(int i=0;i<list.size();i++){
				SysCustomerDetailResponse customerDetailResponse = new SysCustomerDetailResponse();
				customerDetailResponse.setSysCustomer(list.get(i));
				BetVehiclesCustomer betVehiclesCustomerSelect = new BetVehiclesCustomer();//查询中间表信息
				betVehiclesCustomerSelect.setBetVehiclesCustomerCustomerId(list.get(i).getSysCustomerId());
				List<BetVehiclesCustomer> betVehiclesCustomers = betVehiclesCustomerDao.selectByAttributeAnd(betVehiclesCustomerSelect);
				if(null != betVehiclesCustomers && betVehiclesCustomers.size() != 0){
					customerDetailResponse.setBetVehiclesCustomer(betVehiclesCustomers.get(0));
					SysVehicles sysVehicles = sysVehiclesDao.selectByPrimaryKey(betVehiclesCustomers.get(0).getBetVehiclesCustomerVehiclesId());
					customerDetailResponse.setSysVehicles(sysVehicles);
				}
				customerDetailResponses.add(customerDetailResponse);
			}
		}
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, customerDetailResponses, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils selectCustomerDetailByPrimaryKey(SysCustomer sysCustomer) throws Exception {
		sysCustomer = sysCustomerDao.selectByPrimaryKey(sysCustomer.getSysCustomerId());
		BetVehiclesCustomer betVehiclesCustomerSelect = new BetVehiclesCustomer();
		betVehiclesCustomerSelect.setBetVehiclesCustomerCustomerId(sysCustomer.getSysCustomerId());
		List<BetVehiclesCustomer> betVehiclesCustomers = betVehiclesCustomerDao.selectByAttributeAnd(betVehiclesCustomerSelect);
		SysCustomerDetailResponse customerDetailResponse = new SysCustomerDetailResponse();
		customerDetailResponse.setSysCustomer(sysCustomer);
		if(null != betVehiclesCustomers && betVehiclesCustomers.size() != 0){
			customerDetailResponse.setBetVehiclesCustomer(betVehiclesCustomers.get(0));
			SysVehicles sysVehicles = sysVehiclesDao.selectByPrimaryKey(betVehiclesCustomers.get(0).getBetVehiclesCustomerVehiclesId());
			customerDetailResponse.setSysVehicles(sysVehicles);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, customerDetailResponse);
	}

	@Override
	public ReturnUtils updateSysCustomer(SysCustomerSaveQuery sysCustomerSaveQuery) throws Exception {
		if(null == sysCustomerSaveQuery || sysCustomerSaveQuery.getSysCustomer() == null || sysCustomerSaveQuery.getBetVehiclesCustomer() == null){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.DATA_ERROR);
		}
		SysCustomer sysCustomer = sysCustomerSaveQuery.getSysCustomer();
		BetVehiclesCustomer betVehiclesCustomer = sysCustomerSaveQuery.getBetVehiclesCustomer();
		if(sysCustomer.getSysCustomerName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_ADD_NAME_ERROR);
		}
		if(!Utils.isMobile(sysCustomer.getSysCustomerMobileNumber())){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_ADD_MOBILE_ERROR);
		}
		if(sysCustomer.getSysCustomerStoreAddress().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_ADD_ADDRESS_ERROR);
		}
		if(sysCustomer.getSysCustomerStoreName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_CUSTOMER_ADD_STORY_NAME_ERROR);
		}
		sysCustomer.setSysCustomerImgUrl(Base64FileUtils.base64ToImageFile(sysCustomer.getSysCustomerImgUrl(), PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		sysCustomerDao.updateByPrimaryKeySelective(sysCustomer);
		betVehiclesCustomerDao.updateByPrimaryKeySelective(betVehiclesCustomer);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.UPDATE_SUCCESS);
	}

	@Override
	public ReturnUtils selectCustomerOrderByOrderTotal(SysCustomer sysCustomer) throws Exception {
		PageHelper.startPage(sysCustomer.getCurrentPage(), sysCustomer.getPageSize());
		sysCustomer.setSysCustomerName(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerRealName(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerMobileNumber(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerQqNumber(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerStoreName(sysCustomer.getSearchName());
		sysCustomer.setSysCustomerStoreAddress(sysCustomer.getSearchName());
		List<SysCustomer> list = sysCustomerDao.selectCustomerOrderByOrderTotal(sysCustomer);
		PageInfo<SysCustomer> page = new PageInfo<SysCustomer>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils insertCustomerGroup(SysCustomerParam sysCustomerParam) throws Exception {
		SysCustomerGroup sysCustomerGroup = new SysCustomerGroup();
		
		/**
		 * 查询设置
		 */
		sysCustomerGroup.setSysCustomerGroupName(sysCustomerParam.getCustomerGroupName());
		if(null != sysCustomerGroupDao.selectSysCustomerGroupByCondition(sysCustomerGroup)){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR,
					"该分组名字已被占用");
		}
		
		sysCustomerGroup.setSysCustomerGroupId(Utils.createPrimaryKey());
		sysCustomerGroup.setSysCustomerGroupCreateTime(Utils.getNowTime());
		sysCustomerGroup.setSysCustomerGroupName(sysCustomerParam.getCustomerGroupName());
		sysCustomerGroup.setSysCustomerGroupSort(sysCustomerParam.getCustomerGroupSort());
		Integer insertCode = sysCustomerGroupDao.insertSelective(sysCustomerGroup);
		
		if(insertCode > 0){
			List<String> customerIds = sysCustomerParam.getCustomerIds();
			/**
			 * 判断是否有顾客已加入分组
			 */
			for (String customerId : customerIds) {
				SysCustomerGroup customerGroup = this.decideCustomerIsJoinGroup(customerId);
				if(null != customerGroup){
					return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "顾客" + 
							customerGroup.getCustomerName() + "已经加入了分组" + 
							customerGroup.getSysCustomerGroupName() + "中，不能重复添加");
				}
			}
			
			/**
			 * 添加关联信息表
			 */
			BetCustomerGroup betCustomerGroup = new BetCustomerGroup();
			for (String customerId : customerIds) {
				betCustomerGroup.setBetCustomerGroupId(Utils.createPrimaryKey());
				betCustomerGroup.setBetCustomerGroupCustomerId(customerId);
				betCustomerGroup.setBetCustomerGroupCustomerGroupId(sysCustomerGroup.getSysCustomerGroupId());
				betCustomerGroup.setBetCustomerGroupCreateTime(Utils.getNowTime());
				betCustomerGroupDao.insertSelective(betCustomerGroup);
			}
			this.insertSysCustomerGroupProductAfterInsertCustomerGroup(sysCustomerGroup);
		}
		return  insertCode > 0 ? ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, 
				Constant.RESPONSE_MESSAGE_SUCCESS) : ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR,
						Constant.RESPONSE_MESSAGE_ERROR);
	}

	@Override
	public ReturnUtils insertCustomerGroupProduct(SysCustomerParam sysCustomerParam) 
			throws Exception {
		List<SysProduct> sysProducts = sysCustomerParam.getSysProducts();
		SysCustomerGroupProduct sysCustomerGroupProduct = new SysCustomerGroupProduct();
		for (SysProduct sysProduct : sysProducts) {
			sysCustomerGroupProduct.setSysCustomerGroupProductId(Utils.createPrimaryKey());
			sysCustomerGroupProduct.setSysCustomerGroupProductGroupId(sysCustomerParam.getCustomerGroupId());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductId(sysProduct.getSysProductId());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductStaffPrice(sysProduct.getSysProductStaffSelfPrice());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductOrdinaryPrice(sysProduct.getSysProductOrdinarySalePrice());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductName(sysProduct.getSysProductName());
			sysCustomerGroupProduct.setSysCustomerGroupProductCreateTime(Utils.getNowTime());
			sysCustomerGroupProductDao.insertSelective(sysCustomerGroupProduct);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, 
				Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 判断是否有顾客加入了分组
	 * @param customerId
	 * @return
	 */
	private SysCustomerGroup decideCustomerIsJoinGroup(String customerId){
		return sysCustomerGroupDao.selectSysCustomerGroupByCustomerId(customerId);
	}

	@Override
	public ReturnUtils insertCustomerIdToCustomerGroup(SysCustomerParam sysCustomerParam) throws Exception {
		List<String> customerIds = sysCustomerParam.getCustomerIds();
		/**
		 * 判断是否有顾客已加入分组
		 */
		for (String customerId : customerIds) {
			SysCustomerGroup sysCustomerGroup = this.decideCustomerIsJoinGroup(customerId);
			if(null != sysCustomerGroup){
				return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "顾客" + 
						sysCustomerGroup.getCustomerName() + "已经加入了分组" + 
						sysCustomerGroup.getSysCustomerGroupName() + "中，不能重复添加");
			}
		}
		
		/**
		 * 添加关联信息表
		 */
		BetCustomerGroup betCustomerGroup = new BetCustomerGroup();
		for (String customerId : customerIds) {
			betCustomerGroup.setBetCustomerGroupId(Utils.createPrimaryKey());
			betCustomerGroup.setBetCustomerGroupCustomerId(customerId);
			betCustomerGroup.setBetCustomerGroupCustomerGroupId(sysCustomerParam.getCustomerGroupId());
			betCustomerGroup.setBetCustomerGroupCreateTime(Utils.getNowTime());
			betCustomerGroupDao.insertSelective(betCustomerGroup);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}

	@Override
	public ReturnUtils updateCustomerGroupById(SysCustomerParam sysCustomerParam) throws Exception {
		SysCustomerGroup sysCustomerGroup = Utils.exchangeObject(sysCustomerParam, SysCustomerGroup.class);
		/**
		 * 查询设置
		 */
		SysCustomerGroup selectSysCustomerGroup = sysCustomerGroupDao.selectSysCustomerGroupByCondition(sysCustomerGroup);
		if(null != selectSysCustomerGroup && !selectSysCustomerGroup.
				getSysCustomerGroupId().equals(sysCustomerGroup.getSysCustomerGroupId())){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR,
					"该分组名字已被占用");
		}
		
		Integer updateCode = sysCustomerGroupDao.updateByPrimaryKeySelective(sysCustomerGroup);
//		/**
//		 * 启用或禁用操作
//		 */
//		if(sysCustomerParam.getIsForbiddenOrOpen().equals(2)){
//			this.forbiddenOrOpenBetCustomerGroup(false, sysCustomerGroup);
//		}if(sysCustomerParam.getIsForbiddenOrOpen().equals(3)){
//			this.forbiddenOrOpenBetCustomerGroup(true, sysCustomerGroup);
//		}
		if(updateCode > 0){
			List<String> customerIds = sysCustomerParam.getCustomerIds();
			if(StringUtils.isEmpty(sysCustomerParam.getSysCustomerGroupId())){
				throw new RuntimeException("顾客分组id不能为空");
			}

			BetCustomerGroup betCustomerGroup = new BetCustomerGroup();
			/**
			 * 先将关联表信息删除
			 */
			betCustomerGroup.setBetCustomerGroupCustomerGroupId(sysCustomerParam.getSysCustomerGroupId());
			betCustomerGroupDao.deleteBetCustomerGroupByCustomerGroupId(betCustomerGroup);
			/**
			 * 再重新添加中间表
			 */
			for (String customerId : customerIds) {
				betCustomerGroup.setBetCustomerGroupId(Utils.createPrimaryKey());
				betCustomerGroup.setBetCustomerGroupCustomerId(customerId);
				betCustomerGroup.setBetCustomerGroupCustomerGroupId(sysCustomerParam.getSysCustomerGroupId());
				betCustomerGroup.setBetCustomerGroupCreateTime(Utils.getNowTime());
				betCustomerGroupDao.insertSelective(betCustomerGroup);
			}
		}
		return updateCode > 0 ? ReturnUtils.forNoraml(
				Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS)
				: ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}

	@Override
	public ReturnUtils updateCustomerIdByCustomerGroupId(SysCustomerParam sysCustomerParam) throws Exception {
		List<String> customerIds = sysCustomerParam.getCustomerIds();
		if(StringUtils.isEmpty(sysCustomerParam.getCustomerGroupId())){
			throw new RuntimeException("顾客分组id不能为空");
		}

		BetCustomerGroup betCustomerGroup = new BetCustomerGroup();
		/**
		 * 先将关联表信息删除
		 */
		betCustomerGroup.setBetCustomerGroupCustomerGroupId(sysCustomerParam.getCustomerGroupId());
		betCustomerGroupDao.deleteBetCustomerGroupByCustomerGroupId(betCustomerGroup);
		/**
		 * 再重新添加中间表
		 */
		for (String customerId : customerIds) {
			betCustomerGroup.setBetCustomerGroupId(Utils.createPrimaryKey());
			betCustomerGroup.setBetCustomerGroupCustomerId(customerId);
			betCustomerGroup.setBetCustomerGroupCustomerGroupId(sysCustomerParam.getCustomerGroupId());
			betCustomerGroup.setBetCustomerGroupCreateTime(Utils.getNowTime());
			betCustomerGroupDao.insertSelective(betCustomerGroup);
		}
		
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 进行启用或者禁用顾客与顾客分组关联信息的操作
	 * @param isForbidden
	 * @param sysCustomerGroup
	 */
	private void forbiddenOrOpenBetCustomerGroup(Boolean isForbidden,SysCustomerGroup sysCustomerGroup){
		BetCustomerGroup betCustomerGroup = new BetCustomerGroup();
		betCustomerGroup.setBetCustomerGroupDelFlag(isForbidden ? 2 : 1);
		betCustomerGroup.setBetCustomerGroupCustomerGroupId(sysCustomerGroup.getSysCustomerGroupId());
		betCustomerGroupDao.updqteBetCustomerGroupByCustomerGroupId(betCustomerGroup);
	}

	@Override
	public ReturnUtils selectCustomerForInsertCustomerGroup(SysCustomerQuery sysCustomerQuery) throws Exception {
		PageHelper.startPage(sysCustomerQuery.getCurrentPage(), sysCustomerQuery.getPageSize());
		List<SysCustomer> list = sysCustomerDao.selectByAttributeAnd(Utils.exchangeObject(sysCustomerQuery, SysCustomer.class));
		PageInfo<SysCustomer> page = new PageInfo<SysCustomer>(list);
			for (SysCustomer sysCustomer : list) {
				/**
				 * 分组id不为空表示修改顾客分组时的查询顾客
				 */
				SysCustomerGroup sysCustomerGroup = this.decideCustomerIsJoinGroup(sysCustomer.getSysCustomerId());
				if(null == sysCustomerGroup){
					sysCustomer.setIsChangedType(1);
				}else{
					sysCustomer.setSysCustomerGroupName(sysCustomerGroup.getSysCustomerGroupName());
					if(sysCustomerGroup.getSysCustomerGroupId().equals(sysCustomerQuery.getCustomerGroupId())){
						sysCustomer.setIsChangedType(2);
					}else{
						sysCustomer.setIsChangedType(3);
					}
				}
			}
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}
	
	/**
	 * 添加顾客分组后
	 * 将所有有效的商品加入顾客分组模板中
	 * @param sysCustomerGroup
	 */
	private void insertSysCustomerGroupProductAfterInsertCustomerGroup(SysCustomerGroup sysCustomerGroup){
		List<SysProduct> sysProducts = sysProductDao.selectAllEffectiveSysProduct();
		SysCustomerGroupProduct sysCustomerGroupProduct = new SysCustomerGroupProduct();
		for (SysProduct sysProduct : sysProducts) {
			sysCustomerGroupProduct.setSysCustomerGroupProductId(Utils.createPrimaryKey());
			sysCustomerGroupProduct.setSysCustomerGroupProductGroupId(sysCustomerGroup.getSysCustomerGroupId());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductId(sysProduct.getSysProductId());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductName(sysProduct.getSysProductName());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductStaffPrice(sysProduct.getSysProductPrice());
			sysCustomerGroupProduct.setSysCustomerGroupProductProductOrdinaryPrice(sysProduct.getSysProductPrice());
			sysCustomerGroupProduct.setSysCustomerGroupProductStaffBidPrice(sysProduct.getSysProductStaffBidPrice());
			sysCustomerGroupProduct.setSysCustomerGroupProductOrdinaryBidPrice(sysProduct.getSysProductOrdinaryBidPrice());
			sysCustomerGroupProduct.setSysCustomerGroupProductCreateTime(Utils.getNowTime());
			
			sysCustomerGroupProductDao.insertSelective(sysCustomerGroupProduct);
		}
	}

	@Override
	public ReturnUtils selectSysCustomerGroupList(SysCustomerGroup sysCustomerGroup) throws Exception {
		PageHelper.startPage(sysCustomerGroup.getCurrentPage(), sysCustomerGroup.getPageSize());
		List<SysCustomerGroup> list = sysCustomerGroupDao.selectSysCustomerGroupListByCondition(sysCustomerGroup);
		PageInfo<SysCustomerGroup> page = new PageInfo<SysCustomerGroup>(list);
		for (SysCustomerGroup customerGroup : list) {
			customerGroup.setCustomerCount(sysCustomerDao.
					selectCustomerCountByCustomerGroupId(customerGroup.getSysCustomerGroupId()));
		}
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}
	
	@Override
	public ReturnUtils selectCustomerGroupProductByCustomerGroupId(
			SysCustomerGroupProductQuery sysCustomerGroupProductQuery) throws Exception{
		SerOrderQuery serOrderQuery = new SerOrderQuery();
		serOrderQuery.setCustomerId(sysCustomerGroupProductQuery.getSysCustomerId());
		SerOrder serOrder = serOrderDao.selectOneNewOrderByCustomerId(serOrderQuery);
		sysCustomerGroupProductQuery.setOrderNumber(serOrder.getSerOrderNumber());
		if(StringUtils.isEmpty(sysCustomerGroupProductQuery.getSysProductTypeId())){
			sysCustomerGroupProductQuery.setSysProductTypeId(null);
		}
		PageHelper.startPage(sysCustomerGroupProductQuery.getCurrentPage(), sysCustomerGroupProductQuery.getPageSize());
		List<SysCustomerGroupProduct> list = sysCustomerGroupProductDao.
				selectCustomerGroupProductByCustomerGroupId(sysCustomerGroupProductQuery);
		PageInfo<SysCustomerGroupProduct> page = new PageInfo<SysCustomerGroupProduct>(list);
		
		/**
		 * 手动封装模板商品信息
		 */
		for (SysCustomerGroupProduct sysCustomerGroupProduct : list) {
			if(StringUtils.isEmpty(sysCustomerGroupProduct.getSysCustomerGroupProductId())){
				sysCustomerGroupProductQuery.setSysProductId(sysCustomerGroupProduct.getSysCustomerGroupProductProductId());
				SysCustomerGroupProduct customerGroupProduct = sysCustomerGroupProductDao.
						selectSysCustomerGroupProductByCustomerGroupIdAndProductId(sysCustomerGroupProductQuery);
				sysCustomerGroupProduct.setSysCustomerGroupProductId(customerGroupProduct.getSysCustomerGroupProductId());
				sysCustomerGroupProduct.setSysCustomerGroupProductGroupId(customerGroupProduct.getSysCustomerGroupProductGroupId());
				sysCustomerGroupProduct.setSysCustomerGroupProductProductStaffPrice(
						customerGroupProduct.getSysCustomerGroupProductProductStaffPrice());
				sysCustomerGroupProduct.setSysCustomerGroupProductProductOrdinaryPrice(
						customerGroupProduct.getSysCustomerGroupProductProductOrdinaryPrice());
			}
		}
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils flushSysCcustomerGroupProductStaffPriceAndOrdinaryPrice(SysCustomerParam sysCustomerParam)
			throws Exception {
		List<SysCustomerGroupProduct> list = sysCustomerParam.getSysCustomerGroupProducts();
		for (SysCustomerGroupProduct sysCustomerGroupProduct : list) {
			sysCustomerGroupProductDao.updateByPrimaryKeySelective(sysCustomerGroupProduct);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
}
