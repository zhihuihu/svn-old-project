package com.vieagr.distribution.dao;

import java.util.List;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SysCustomerGroupProduct;
import com.vieagr.distribution.query.SysCustomerGroupProductQuery;

public interface SysCustomerGroupProductDao extends IBaseDao<SysCustomerGroupProduct> {
	
    int deleteByPrimaryKey(String sysCustomerGroupProductId);

    int insert(SysCustomerGroupProduct record);

    int insertSelective(SysCustomerGroupProduct record);

    SysCustomerGroupProduct selectByPrimaryKey(String sysCustomerGroupProductId);

    int updateByPrimaryKeySelective(SysCustomerGroupProduct record);

    int updateByPrimaryKey(SysCustomerGroupProduct record);
    
    /**
     * 根据分组id和商品id查询模板商品信息
     * @param sysCustomerGroupProductQuery
     * @return
     */
    SysCustomerGroupProduct selectSysCustomerGroupProductByCustomerGroupIdAndProductId(
    		SysCustomerGroupProductQuery sysCustomerGroupProductQuery);
    
    /**
     * 根据分组id查询对应的模板商品列表
     * @return
     */
    List<SysCustomerGroupProduct> selectCustomerGroupProductByCustomerGroupId(
    		SysCustomerGroupProductQuery sysCustomerGroupProductQuery);
    
}