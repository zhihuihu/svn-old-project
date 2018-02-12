package com.cqq.leisure.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.dao.IMerchantDao;
import com.cqq.leisure.entity.Merchant;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.inter.IMerchantService;
@Service
@Transactional
public class MerchantService implements IMerchantService {
	@Resource
	private IMerchantDao  iMerchantDao;
	@Override
	public int doDeleteByPrimaryKey(Merchant b) throws Exception {
		return iMerchantDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Merchant> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iMerchantDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(Merchant b) throws Exception {
		return iMerchantDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Merchant> bs) throws Exception {
		int flag =0;
		for(int i = 0; i< bs.size();i++){
			flag = iMerchantDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("数据传入错误，插入失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(Merchant b) throws Exception {
		return iMerchantDao.doInsertSelective(b);
	}

	@Override
	public Merchant selectByPrimaryKey(Merchant b) throws Exception {
		return iMerchantDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Merchant b) throws Exception {
		return iMerchantDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Merchant b) throws Exception {
		return iMerchantDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Merchant> bs) throws Exception {
		int flag = 0;
		for(int i = 0;i<bs.size();i++){
			flag = iMerchantDao.doUpdateByPrimaryKey(bs.get(i));
			if(flag == 0){
				throw new RuntimeException("输入数据错误，请重新输入");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Merchant> pageBean)throws Exception {
		int lineCount = iMerchantDao.selectByAttributeCountAnd(pageBean);
		List<Merchant> list = iMerchantDao.selectByAttributeAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Merchant> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Merchant> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Merchant> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Merchant> selectNearByMerchant(String longitude,
			String latitude, float distance) throws Exception {
		PageBean<Merchant> pageBean = new PageBean<Merchant>(1, 10000);
		pageBean.setInVo(new Merchant());
		List<Merchant> list = new ArrayList<Merchant>();
		list = iMerchantDao.selectByAttributeAnd(pageBean);
		int i;
		List<Merchant> getNearbyList = new ArrayList<Merchant>();
		for( i=0;i<list.size();i++ ){
			
			String attrlongitude = list.get(i).getMerchantLog();
			String attrLatitude = list.get(i).getMerchantLat(); 
			double lat1 = Double.parseDouble(latitude);
			double lat2 = Double.parseDouble(attrLatitude);
			double lng1 = Double.parseDouble(longitude);
			double lng2 = Double.parseDouble(attrlongitude);
			if(lat2 != 0.0&&lng2 !=0.0){
				double radLat1 = lat1*Math.PI/180.0;
				double radLat2 = lat2*Math.PI/180.0;
				double difference = radLat1 - radLat2;
			    double mdifference = lng1*Math.PI/180.0 - lng2*Math.PI/180.0;
			    double attrDistance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
		                + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(mdifference / 2), 2)));
			    attrDistance = attrDistance * EARTH_RADIUS;
			    attrDistance = Math.round(attrDistance * 10000) / 10000;
			    if(attrDistance <= distance){
			    	getNearbyList.add(list.get(i));
			    }
			}
			
		}
		return getNearbyList;
	}
	private static double EARTH_RADIUS = 6378.137;
	@Override
	public List<Merchant> selectAll(PageBean<Merchant> pageBean)
			throws Exception {
		return iMerchantDao.selectAll(pageBean);
		
	}

	@Override
	public List<Merchant> selectByKeyWord(String keyWord) throws Exception {
		Merchant merchant = new Merchant();
		merchant.setMerchantAddress(keyWord);
		merchant.setMerchantName(keyWord);
		merchant.setMerchantIntro(keyWord);
		PageBean<Merchant> pagebean = new PageBean<Merchant>(0,100);
		pagebean.setInVo(merchant);
		return iMerchantDao.selectByKeyWord(pagebean);
	}

}
