package com.vieagr.distribution.service.inter;

import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.entity.SysProductType;
import com.vieagr.distribution.service.base.IBaseService;

/**
 * 商品类型业务
 * @author master
 *
 */
public interface ISysProductTypeService extends IBaseService<SysProductType>{
	
	/**
	 * 分页查询商品列表
	 * @param sysProductType
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectProductTypeList(SysProductType sysProductType) throws Exception;
}
