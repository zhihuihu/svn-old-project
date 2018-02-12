package com.vieagr.distribution.dao;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.BetCustomerGroup;

public interface BetCustomerGroupDao extends IBaseDao<BetCustomerGroup> {
    int deleteByPrimaryKey(String betCustomerGroupId);

    int insert(BetCustomerGroup record);

    int insertSelective(BetCustomerGroup record);

    BetCustomerGroup selectByPrimaryKey(String betCustomerGroupId);

    int updateByPrimaryKeySelective(BetCustomerGroup record);

    int updateByPrimaryKey(BetCustomerGroup record);
    
    /**
     * 根据顾客分组id修改顾客和顾客分组关联信息
     * @param betCustomerGroup
     * @return
     */
    Integer updqteBetCustomerGroupByCustomerGroupId(BetCustomerGroup betCustomerGroup);
    
    /**
     * 根据顾客分组id删除顾客与顾客分组关联信息
     * @param betCustomerGroup
     * @return
     */
    Integer deleteBetCustomerGroupByCustomerGroupId(BetCustomerGroup betCustomerGroup);
}