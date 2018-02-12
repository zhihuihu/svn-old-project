package com.cqq.leisure.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.Merchant;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.inter.IMerchantService;

@Controller
@RequestMapping(value="admin/merchant")
public class MerchantAdminCtrl {
	
	@Resource
	private IMerchantService iMerchantService;
	
	/***
	 * 获取merchant的列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list")
	@ResponseBody
	public Object getMerchantList() throws Exception{
		Merchant merchant = new Merchant();
		PageBean<Merchant> pageBean = new PageBean<Merchant>(0, 100);
		pageBean.setInVo(merchant);
		return iMerchantService.selectAll(pageBean);
	}
	
	/***
	 * 管理员更新商家数据
	 * @param merchantId
	 * @param Log
	 * @param Lat
	 * @param StartTime
	 * @param EndTime
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="update",method=RequestMethod.POST)
	@ResponseBody
	public Object updateMerchant(int merchantId,String merchantLog,String merchantLat,String Intro) throws Exception{
		Merchant merchant = new Merchant();
		merchant.setMerchantId(merchantId);
		Merchant merchantExit = iMerchantService.selectByPrimaryKey(merchant);
		if( merchantExit == null ){
			PageBeanUtils.formatForNormalFalse("", "不存在该商家");
		}
		if(merchantLog=="" && merchantLat==""&& Intro==""){
			return PageBeanUtils.formatForNormalFalse("", "数据不能都为空");
		}
		merchantExit.setMerchantLinkman(merchantLog);
		merchantExit.setMerchantPhone(merchantLat);
		merchantExit.setMerchantIntro(Intro);
		iMerchantService.doUpdateByPrimaryKey(merchantExit);
		return PageBeanUtils.formatForNormalTrue("", merchantExit);
		
	}
	
	
	/***
	 * 添加一个商家
	 * @param merchantName
	 * @param merchantAddress
	 * @param merchantLog
	 * @param merchantLat
	 * @param merchangLinkName
	 * @param merchantTele
	 * @param merchantIntro
	 * @param merchantStartTime
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="add")
	@ResponseBody
	public Object addMerchant(int tagId,String tagName,String merchantName,String merchantAddress,String merchantLog,String merchantLat,String merchantLinkName,String merchantTele,String merchantIntro) throws Exception{
		Merchant merchant = new Merchant();
		merchant.setMerchantAddress(merchantAddress);
		merchant.setMerchantIntro(merchantIntro);
		merchant.setMerchantName(merchantName);
		merchant.setMerchantPhone(merchantTele);
		merchant.setMerchantLat(merchantLat);
		merchant.setMerchantLog(merchantLog);
		merchant.setMerchantLinkman(merchantLinkName);
		merchant.setTagId(tagId);
		merchant.setMerchantTag(tagName);
		merchant.setMerchantCreateTime(TimeUtils.getMySqlFormatTime());
		iMerchantService.doInsert(merchant);
		return PageBeanUtils.formatForNormalTrue("", merchant);
	}

}
