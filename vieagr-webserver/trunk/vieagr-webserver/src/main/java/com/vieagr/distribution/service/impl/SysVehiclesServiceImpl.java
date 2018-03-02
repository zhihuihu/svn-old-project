package com.vieagr.distribution.service.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.Base64FileUtils;
import com.vieagr.distribution.base.util.PropertiesUtils;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.dao.BetOrderProductDao;
import com.vieagr.distribution.dao.SysVehiclesDao;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SysVehicles;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.query.SysVehiclesQuery;
import com.vieagr.distribution.response.SysVehiclesResponse;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISysVehiclesService;

@Service
@Transactional
public class SysVehiclesServiceImpl extends BaseService<SysVehicles>implements ISysVehiclesService{

	@Autowired
	private SysVehiclesDao sysVehiclesDao;
	
	@Autowired
	private BetOrderProductDao betOrderProductDao;
	
	@Override
	public ReturnUtils selectVehiclesList(SysVehiclesQuery sysVehiclesQuery) throws Exception {
		PageHelper.startPage(sysVehiclesQuery.getCurrentPage(), sysVehiclesQuery.getPageSize());
		List<SysVehicles> list = sysVehiclesDao.selectByAttributeAnd(Utils.exchangeObject(sysVehiclesQuery, SysVehicles.class));
		PageInfo<SysVehicles> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public ReturnUtils selectVehiclesList(SysVehicles sysVehicles) throws Exception {
		PageHelper.startPage(sysVehicles.getCurrentPage(), sysVehicles.getPageSize());
		List<SysVehicles> list = sysVehiclesDao.selectByAttributeAnd(Utils.exchangeObject(sysVehicles, SysVehicles.class));
		PageInfo<SysVehicles> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public Object sysVehiclesAdd(SysVehicles sysVehicles) throws Exception {
		if(null == sysVehicles || sysVehicles.getSysVehiclesPlateNumber() == null || sysVehicles.getSysVehiclesRegisterMobile() == null){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.ADD_VEHICLES_ERROR);
		}
		sysVehicles.setSysVehiclesPlateNumber(sysVehicles.getSysVehiclesPlateNumber().toUpperCase());
		SysVehicles sysVehiclesCheck = new SysVehicles();
		sysVehiclesCheck.setSysVehiclesPlateNumber(sysVehicles.getSysVehiclesPlateNumber());
		PageHelper.startPage(1, 10);
		List<SysVehicles> list = sysVehiclesDao.selectByAttributeAnd(sysVehiclesCheck);
		if(null != list && 0 != list.size()){//判断车牌号是否重复
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.ADD_VEHICLES_NUMBER_USED);
		}
		if(!Utils.isMobile(sysVehicles.getSysVehiclesRegisterMobile())){//判断手机号码是否正确
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.ADD_VEHICLES_FOR_PHONE_NUMBER_ERROR);
		}
		sysVehicles.setSysVehiclesId(UUID.randomUUID().toString());
		sysVehicles.setSysVehiclesCreateTime(Utils.getNowTime());
		sysVehicles.setSysVehiclesImgUrl(Base64FileUtils.base64ToImageFile(sysVehicles.getSysVehiclesImgUrl(), PropertiesUtils.getProperties(
				Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		int flg = sysVehiclesDao.insertSelective(sysVehicles);
		if(flg <= 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.ADD_VEHICLES_ERROR);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.ADD_VEHICLES_SUCCESS);
	}

	@Override
	public Object selectSysVehiclesList(SysVehicles sysVehicles) throws Exception {
		PageHelper.startPage(sysVehicles.getCurrentPage(), sysVehicles.getPageSize());
		sysVehicles.setSysVehiclesPlateNumber(sysVehicles.getSearchName());
		sysVehicles.setSysVehiclesRegisterName(sysVehicles.getSearchName());
		sysVehicles.setSysVehiclesRegisterMobile(sysVehicles.getSearchName());
		List<SysVehicles> list = sysVehiclesDao.selectSysVehiclesList(sysVehicles);
		PageInfo<SysVehicles> page = new PageInfo<>(list);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, list, 
				page.getPageNum(), page.getPageSize(), page.getPages(), (int)page.getTotal());
	}

	@Override
	public SysVehiclesResponse downLoadVehiclesBidAmountTotalExcel(String vehiclesId, Integer orderType,
			String chooseTime, Integer bidType) throws Exception {
		SysVehiclesResponse sysVehiclesResponse = new SysVehiclesResponse();
		
		/**
		 * 获取车辆信息
		 */
		SysVehicles sysVehicles = sysVehiclesDao.selectByPrimaryKey(vehiclesId);
		
		SerOrderQuery serOrderQuery = new SerOrderQuery();
		serOrderQuery.setSysVehiclesId(vehiclesId);
		serOrderQuery.setSerOrderType(orderType);
		/**
		 * 获取订单详情
		 */
		Map<String,Object> paramMap = new HashMap<>();
		if(bidType.equals(1)){
			serOrderQuery.setOrderSendTime(chooseTime);
			List<BetOrderProduct> betOrderProducts = betOrderProductDao.selectBetOrderProductByVehiclesId(serOrderQuery);
			paramMap.put(serOrderQuery.getOrderSendTime(),betOrderProducts);
		}else{
			List<String> list = Utils.getAllTheDateOftheMonthStr(new SimpleDateFormat
					("yyyy-MM").parse(chooseTime + "-01"), "yyyy-MM-dd");
			Integer maxLength = 0;
			for (String detailChooseTime : list) {
				serOrderQuery.setOrderSendTime(detailChooseTime);
				List<BetOrderProduct> betOrderProducts = betOrderProductDao.selectBetOrderProductByVehiclesId(serOrderQuery);
				if(betOrderProducts.size() > maxLength){
					maxLength = betOrderProducts.size();
				}
				paramMap.put(detailChooseTime,betOrderProducts);
			}
			paramMap.put("maxLength", maxLength);
			serOrderQuery.setOrderSendTime(chooseTime);
		}
		
		sysVehiclesResponse.setBidExcelInPutStream(Utils.downLoadVehiclesBidAmountTotalExcel(
				paramMap, sysVehicles, serOrderQuery,bidType));
		sysVehiclesResponse.setVehiclesPlateNumber(sysVehicles.getSysVehiclesPlateNumber());
		
		return sysVehiclesResponse;
	}

}
