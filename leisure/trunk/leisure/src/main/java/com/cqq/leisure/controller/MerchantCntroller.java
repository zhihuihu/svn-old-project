package com.cqq.leisure.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
/**
 * 商家控制器
 * @author CQQ
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.entity.Merchant;
import com.cqq.leisure.service.impl.MerchantService;
@Controller
@RequestMapping("merchant")
public class MerchantCntroller {
	@Resource
	private MerchantService merchantService;
	@RequestMapping("insert")
	@ResponseBody
	private Object doInsert(HttpServletRequest request,HttpServletResponse response) throws Exception{
		Merchant merchant = new Merchant();
		merchant.setMerchantLinkman("陈巧巧");
		merchant.setMerchantPhone("13438334359");
		merchant.setMerchantAddress("西化大学牛市口");
		merchant.setMerchantTag("成都");
		merchant.setMerchantCreateTime(TimeUtils.getMySqlFormatTime());
		merchantService.doInsert(merchant);
		return merchant;	
	}
}

