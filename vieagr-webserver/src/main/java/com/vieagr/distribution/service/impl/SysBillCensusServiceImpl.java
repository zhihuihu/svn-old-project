package com.vieagr.distribution.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.dao.BetOrderProductDao;
import com.vieagr.distribution.dao.SerOrderDao;
import com.vieagr.distribution.dao.SysDaliyBillCensusDao;
import com.vieagr.distribution.dao.SysMensalBillCensusDao;
import com.vieagr.distribution.entity.BetOrderProduct;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysDaliyBillCensus;
import com.vieagr.distribution.query.SysBillCensusQuery;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISysBillCensusService;

@Service
@Transactional
public class SysBillCensusServiceImpl extends BaseService<Object> implements ISysBillCensusService{

	@Autowired
	private SysDaliyBillCensusDao sysDaliyBillCensusDao;
	
	@Autowired
	private SysMensalBillCensusDao sysMensalBillCensusDao;
	
	@Autowired
	private SerOrderDao serOrderDao;
	
	@Autowired
	private BetOrderProductDao betOrderProductDao;
	
	@Override
	public Integer dailyOrderInfoCensusAfterFinishOrder(String serOrderId) throws Exception{
		SerOrder serOrder = this.selectOrderByOrderId(serOrderId);
		if(null != serOrder){
			List<BetOrderProduct> list = betOrderProductDao.selectBetOrderProductByOrderId(serOrderId);
			/**
			 * 先获取并修改总统计账单
			 */
			SysDaliyBillCensus sysDaliyTotalBillCensus = this.selectTotalSysDaliyBillCensus(serOrder);
			sysDaliyTotalBillCensus.setSysDaliyBillCensusSaleAmount(serOrder.getSerOrderAmount());
			sysDaliyTotalBillCensus.setSysDaliyBillCensusBidAmount(this.calculateBidAmount(list));
			sysDaliyTotalBillCensus.setSysDaliyBillCensusProfitAmount(sysDaliyTotalBillCensus.getSysDaliyBillCensusSaleAmount().
					subtract(sysDaliyTotalBillCensus.getSysDaliyBillCensusBidAmount()));
			sysDaliyTotalBillCensus.setSysDaliyBillCensusOrderCount(sysDaliyTotalBillCensus.getSysDaliyBillCensusOrderCount() + 1);
			sysDaliyBillCensusDao.updateByPrimaryKeySelective(sysDaliyTotalBillCensus);
			/**
			 * 再获取对应此条订单顾客的日统计账单
			 */
			SysDaliyBillCensus sysDaliyBillCustomerCensus = this.selectCustomerSysDaliyBillCensus(serOrder);
			sysDaliyBillCustomerCensus.setSysDaliyBillCensusSaleAmount(serOrder.getSerOrderAmount());
			sysDaliyBillCustomerCensus.setSysDaliyBillCensusBidAmount(this.calculateBidAmount(list));
			sysDaliyBillCustomerCensus.setSysDaliyBillCensusProfitAmount(sysDaliyBillCustomerCensus.getSysDaliyBillCensusSaleAmount().
					subtract(sysDaliyBillCustomerCensus.getSysDaliyBillCensusBidAmount()));
			sysDaliyBillCustomerCensus.setSysDaliyBillCensusOrderCount(sysDaliyBillCustomerCensus.getSysDaliyBillCensusOrderCount() + 1);
			sysDaliyBillCensusDao.updateByPrimaryKeySelective(sysDaliyBillCustomerCensus);
		}
		return null;
	}

	@Override
	public Integer mensalOrderInfoCensusAfterFinishOrder(String serOrderId) throws Exception{
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 根据订单主键查询出对应的订单记录
	 * @return
	 * @throws Exception 
	 */
	private SerOrder selectOrderByOrderId(String serOrderId) throws Exception{
		return serOrderDao.selectByPrimaryKey(serOrderId);
	}

	/**
	 * 查询日总统计账单
	 * @param createTime
	 * @return
	 */
	private SysDaliyBillCensus selectTotalSysDaliyBillCensus(SerOrder serOrder){
		SysBillCensusQuery sysBillCensusQuery = new SysBillCensusQuery();
		sysBillCensusQuery.setBillCensusOrderType(serOrder.getSerOrderType());
		sysBillCensusQuery.setBillCensusDate(serOrder.getSerOrderSendTime());
		sysBillCensusQuery.setBillCensusServiceType(EnumConfig.getIndex("总统计", Constant.BILL_CENSUS));
		SysDaliyBillCensus sysDaliyBillCensus = sysDaliyBillCensusDao.selectSysDaliyBillCensusByCondition(sysBillCensusQuery);
		/**
		 * 需要新建统计账单
		 */
		if(null == sysDaliyBillCensus){
			sysDaliyBillCensus = this.createTotalSysDaliyBillCensus(serOrder);
		}
		return sysDaliyBillCensus;
	}
	
	/**
	 * 创建总统计账单
	 * @param serOrder
	 * @return
	 */
	private SysDaliyBillCensus createTotalSysDaliyBillCensus(SerOrder serOrder){
		SysDaliyBillCensus sysDaliyBillCensus = new SysDaliyBillCensus();
		sysDaliyBillCensus.setSysDaliyBillCensusId(Utils.createPrimaryKey());
		sysDaliyBillCensus.setSysDaliyBillCensusCreateTime(Utils.getNowTime());
		sysDaliyBillCensus.setSysDaliyBillCensusDate(serOrder.getSerOrderSendTime());
		sysDaliyBillCensus.setSysDaliyBillCensusOrderType(serOrder.getSerOrderType());
		sysDaliyBillCensus.setSysDaliyBillCensusServiceType(EnumConfig.getIndex("总统计", Constant.BILL_CENSUS));
		sysDaliyBillCensusDao.insertSelective(sysDaliyBillCensus);
		return sysDaliyBillCensusDao.selectByPrimaryKey(sysDaliyBillCensus.getSysDaliyBillCensusId());
	}
	
	/**
	 * 查询日顾客商家统计账单
	 * @param createTime
	 * @return
	 */
	private SysDaliyBillCensus selectCustomerSysDaliyBillCensus(SerOrder serOrder){
		SysBillCensusQuery sysBillCensusQuery = new SysBillCensusQuery();
		sysBillCensusQuery.setBillCensusOrderType(serOrder.getSerOrderType());
		sysBillCensusQuery.setBillCensusDate(serOrder.getSerOrderSendTime());
		sysBillCensusQuery.setBillCensusServiceType(EnumConfig.getIndex("客户统计", Constant.BILL_CENSUS));
		sysBillCensusQuery.setBillCensusCustomerId(serOrder.getSerOrderCustomerId());
		SysDaliyBillCensus sysDaliyBillCensus = sysDaliyBillCensusDao.selectSysDaliyBillCensusByCondition(sysBillCensusQuery);
		/**
		 * 需要新建统计账单
		 */
		if(null == sysDaliyBillCensus){
			sysDaliyBillCensus = this.createCustomerSysDaliyBillCensus(serOrder);
		}
		return sysDaliyBillCensus;
	}
	
	/**
	 * 创建顾客商家统计账单
	 * @param serOrder
	 * @return
	 */
	private SysDaliyBillCensus createCustomerSysDaliyBillCensus(SerOrder serOrder){
		SysDaliyBillCensus sysDaliyBillCensus = new SysDaliyBillCensus();
		sysDaliyBillCensus.setSysDaliyBillCensusId(Utils.createPrimaryKey());
		sysDaliyBillCensus.setSysDaliyBillCensusCreateTime(Utils.getNowTime());
		sysDaliyBillCensus.setSysDaliyBillCensusDate(serOrder.getSerOrderSendTime());
		sysDaliyBillCensus.setSysDaliyBillCensusOrderType(serOrder.getSerOrderType());
		sysDaliyBillCensus.setSysDaliyBillCensusServiceType(EnumConfig.getIndex("客户统计", Constant.BILL_CENSUS));
		sysDaliyBillCensus.setSysDaliyBillCensusCustomerId(serOrder.getSerOrderCustomerId());
		sysDaliyBillCensusDao.insertSelective(sysDaliyBillCensus);
		return sysDaliyBillCensusDao.selectByPrimaryKey(sysDaliyBillCensus.getSysDaliyBillCensusId());
	}
	
	/**
	 * 根据订单详情列表计算出成本价
	 * @param list
	 * @return
	 */
	private BigDecimal calculateBidAmount(List<BetOrderProduct> list){
		BigDecimal bidAmount = new BigDecimal("0");
		for (BetOrderProduct betOrderProduct : list) {
			bidAmount = bidAmount.add(betOrderProduct.getBetOrderProductProductBidPrice());
		}
		return bidAmount;
	}
	
}
