package com.vieagr.distribution.dao;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SysDaliyBillCensus;
import com.vieagr.distribution.query.SysBillCensusQuery;

public interface SysDaliyBillCensusDao extends IBaseDao<SysDaliyBillCensus> {
    int deleteByPrimaryKey(String sysDaliyBillCensusId);

    int insert(SysDaliyBillCensus record);

    int insertSelective(SysDaliyBillCensus record);

    SysDaliyBillCensus selectByPrimaryKey(String sysDaliyBillCensusId);

    int updateByPrimaryKeySelective(SysDaliyBillCensus record);

    int updateByPrimaryKey(SysDaliyBillCensus record);
    
    /**
     * 添加查询日统计账单
     * @param sysBillCensusQuery
     * @return
     */
    SysDaliyBillCensus selectSysDaliyBillCensusByCondition(SysBillCensusQuery sysBillCensusQuery);
}