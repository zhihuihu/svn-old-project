package com.vieagr.distribution.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SerOrder;
import com.vieagr.distribution.entity.SysProduct;
import com.vieagr.distribution.param.SerOrderParam;
import com.vieagr.distribution.param.SysProductParam;
import com.vieagr.distribution.query.SerOrderQuery;
import com.vieagr.distribution.query.SysProductQuery;
import com.vieagr.distribution.service.inter.IBetOrderProductService;
import com.vieagr.distribution.service.inter.ISerOrderService;
import com.vieagr.distribution.service.inter.ISysProductService;

/**
 * 商品控制层
 * @author master
 *
 */
@RestController
@RequestMapping(value = "sysProduct")
public class SysProductController {

	private static final Logger logger = LoggerFactory.getLogger(SysProductController.class);
	
	@Autowired
	private ISysProductService sysProductService;
	
	@Autowired
	private ISerOrderService serOrderService;
	
	@Autowired
	private IBetOrderProductService betOrderProductService;
	
	/**
	 * 查询商品列表
	 * @param jsonStr
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "selectSysProductList", method = RequestMethod.POST)
	public Object selectSysProductList(String jsonStr, HttpServletRequest request, HttpServletResponse response) throws Exception{
		SysProduct sysProduct = Utils.jsonStrToObject(jsonStr, SysProduct.class);
		return sysProductService.selectProductList(sysProduct);
	}
	
	/**
	 * @Title: sysProductAdd 
	 * @Description:     商品--添加
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月1日 下午3:29:01
	 */
	@RequestMapping(value = "sysProductAdd", method = RequestMethod.POST)
	public Object sysProductAdd(String jsonStr) throws Exception{
		SysProduct sysProduct = Utils.jsonStrToObject(jsonStr, SysProduct.class);
		return sysProductService.sysProductAdd(sysProduct);
	}

	/**
	 * @Title: selectSysProductDetailList 
	 * @Description:     商品--列表查询
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月1日 下午4:15:17
	 */
	@RequestMapping(value = "selectSysProductDetailList", method = RequestMethod.POST)
	public Object selectSysProductDetailList(String jsonStr) throws Exception{
		logger.info("-----商品--列表查询");
		SysProduct sysProduct = Utils.jsonStrToObject(jsonStr, SysProduct.class);
		return sysProductService.selectSysProductDetailList(sysProduct);
	}
	
	/**
	 * @Title: selectByPrimaryKey 
	 * @Description:     商品通过主键查询
	 * @param sysProductId
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月1日 下午4:31:15
	 */
	@RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST)
	public Object selectByPrimaryKey(String sysProductId) throws Exception{
		logger.info("-----商品--通过主键查询");
		SysProduct sysProduct = sysProductService.selectByPrimaryKey(sysProductId);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, sysProduct);
	}
	
	/**
	 * @Title: updateSysProductState 
	 * @Description:     商品--启用禁用状态更新
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月2日 下午3:28:05
	 */
	@RequestMapping(value = "updateSysProductState", method = RequestMethod.POST)
	public Object updateSysProductState(String sysProductId) throws Exception{
		SysProduct sysProduct = new SysProduct();
		SysProduct sysProductCheck = sysProductService.selectByPrimaryKey(sysProductId);
		sysProduct.setSysProductId(sysProductId);
		String msg = "";
		if(sysProductCheck.getSysProductState().equals(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex())){
			sysProduct.setSysProductState(EnumConfig.SYSTEM_UNIFIED_STATE_END_USING.getIndex());
			msg = Constant.SYS_PRODUCT_STATE_END;
		}else{
			sysProduct.setSysProductState(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex());
			msg = Constant.SYS_PRODUCT_STATE_START;
		}
		sysProductService.updateByPrimaryKeySelective(sysProduct);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, msg);
	}
	
	/**
	 * @Title: updateSysProduct 
	 * @Description:     商品--更新
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月2日 下午3:32:39
	 */
	@RequestMapping(value = "updateSysProduct", method = RequestMethod.POST)
	public Object updateSysProduct(String jsonStr) throws Exception{
		logger.info("-----商品--更新");
		SysProduct sysProduct = Utils.jsonStrToObject(jsonStr, SysProduct.class);
		return sysProductService.updateSysProduct(sysProduct);
	}
	
	/**
	 * 根据订单号有序查询出商品列表信息
	 * @param jsonStr
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "selectProductConsultOrder", method = RequestMethod.POST)
	public Object selectProductConsultOrder(String jsonStr) throws Exception{
		SerOrderQuery serOrderQuery = Utils.jsonStrToObject(jsonStr, SerOrderQuery.class);
		SerOrder serOrder = serOrderService.selectOneNewOrderByCustomerId(serOrderQuery);
		SysProduct sysProduct = new SysProduct();
		sysProduct.setCurrentPage(serOrderQuery.getCurrentPage());
		sysProduct.setPageSize(serOrderQuery.getPageSize());
		if(serOrder != null){
			sysProduct.setSysProductOrderNumber(serOrder.getSerOrderNumber());
		}
		if(!StringUtils.isEmpty(serOrderQuery.getSearchName())){
			sysProduct.setSearchName(serOrderQuery.getSearchName());
		}
		return sysProductService.selectProductConsultOrder(sysProduct, serOrderQuery);
	}
	
	/**
	 * 商品列表统一修改多个商品价格
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateProductsPriceByList", method = RequestMethod.POST)
	public Object updateProductsPriceByList(String jsonStr) throws Exception{
		SysProductParam sysProductParam = Utils.jsonStrToObject(jsonStr, SysProductParam.class);
		return sysProductService.updateProductsPriceByList(sysProductParam);
	}
	
	/**
	 * 订单详情中增加商品时的商品列表
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "productsListForOrderDetails", method = RequestMethod.POST)
	public Object productsListForOrderDetails(String jsonStr) throws Exception{
		return sysProductService.productsListForOrderDetails(Utils.jsonStrToObject(jsonStr, SysProductQuery.class));
	}
	
	/**
	 * 商品列表中删除商品
	 * @param jsonStr
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "deleteProductForOrderDetails", method = RequestMethod.POST)
	public Object deleteProductForOrderDetails(String jsonStr) throws Exception{
		SerOrderParam serOrderParam = Utils.jsonStrToObject(jsonStr, SerOrderParam.class);
		return betOrderProductService.deleteProductForOrderDetails(serOrderParam);
	}
	
}
