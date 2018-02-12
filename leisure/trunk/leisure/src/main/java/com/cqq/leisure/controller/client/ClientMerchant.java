package com.cqq.leisure.controller.client;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.entity.Merchant;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.inter.IMerchantService;

@Controller
@RequestMapping(value="client/merchant")
public class ClientMerchant {
	@Resource
	private IMerchantService iMerchantService;
	
	//热门排序商家列表
	@RequestMapping(value="list",method=RequestMethod.GET)
	@ResponseBody
	public Object listMerchant(int currentPage,int lineSize)throws Exception{
		Merchant merchant = new Merchant();
		PageBean<Merchant> pageBean = new PageBean<Merchant>(currentPage, lineSize);
		pageBean.setInVo(merchant);
		return iMerchantService.selectByAttributeAnd(pageBean);
	}
	
	//商家详情
	@RequestMapping(value="detail",method=RequestMethod.GET)
	@ResponseBody
	public Object detailMerchant(int id)throws Exception{
		Merchant merchant = new Merchant();
		merchant.setMerchantId(id);
		merchant = iMerchantService.selectByPrimaryKey(merchant);
		return merchant;
	}
	
	/**
	 * 根据用户当前位置经纬度和所需距离获取餐厅
	 * @param longitude
	 * @param latitude
	 * @param distance
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="getnearbymerchant",method=RequestMethod.GET)
	@ResponseBody
	public Object getNearbyMerchant(String longitude,String latitude,float distance)throws Exception{
		List<Merchant> list = new ArrayList<>();
		//List<Merchant> list2 = new ArrayList<>();
		list = iMerchantService.selectNearByMerchant(longitude, latitude, distance);
		if(list == null){
			return PageBeanUtils.formatForNormalFalse("", "您的附近不存在活动或商店");
		}
		return PageBeanUtils.formatForNormalTrue("", list);
	}
	
	/**
	 * 在推送假日方案规划处根据所提供的location查找热度较好的Merchant
	 * @param location
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="programmerchant",method=RequestMethod.GET)
	@ResponseBody
	public Object getLocationMerchant(String location)throws Exception{
		Merchant merchant = new Merchant();
		merchant.setMerchantGpsAddress(location);
		PageBean<Merchant> pageBean = new PageBean<Merchant>(0, 4);
		pageBean.setInVo(merchant);
		return iMerchantService.selectByAttributeAnd(pageBean);
	}
	
	
	/***
	 * 点击我要参与增加商家的sort，做商家的热度排序
	 * @param merchantId
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="addsort",method=RequestMethod.POST)
	@ResponseBody
	public Object addSort( int merchantId) throws Exception{
		Merchant merchant = new Merchant();
		merchant.setMerchantId(merchantId);
		Merchant merchantExict = iMerchantService.selectByPrimaryKey(merchant);
		if( merchantExict == null){
			return PageBeanUtils.formatForNormalFalse("", "不存在该商家");
		}
		int sort = merchantExict.getMerchantSort()+1;
		System.out.println(sort);
		merchantExict.setMerchantSort(sort);
		iMerchantService.doUpdateByPrimaryKey(merchantExict);
		return PageBeanUtils.formatForNormalTrue("", merchantExict);
	}
	
	/**
	 * 通过关键字搜素商家
	 * @param keyword
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="searchkeyword")
	@ResponseBody
	public Object merchantSearchWord( String keyword) throws Exception{
		List<Merchant> list = new ArrayList<Merchant>();
		list = iMerchantService.selectByKeyWord(keyword);
		return PageBeanUtils.formatForNormalTrue("", list) ;
	}
	
	/***
	 * 由管理员指定四个商家展示在首页   当state = 1
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="mainmerchant")
	@ResponseBody
	public Object getMainMerchant()throws Exception{
		Merchant merchant = new Merchant();
		merchant.setMerchantState(1);
		PageBean<Merchant> pageBean = new PageBean<Merchant>(0, 4);
		pageBean.setInVo(merchant);
		return 	iMerchantService.selectByAttributeAnd(pageBean);
	}
	
}
