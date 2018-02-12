package com.vieagr.distribution.dao;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SysMensalBillCensus;

public interface SysMensalBillCensusDao extends IBaseDao<SysMensalBillCensus> {
    int deleteByPrimaryKey(String sysMensalBillCensusId);

    int insert(SysMensalBillCensus record);

    int insertSelective(SysMensalBillCensus record);

    SysMensalBillCensus selectByPrimaryKey(String sysMensalBillCensusId);

    int updateByPrimaryKeySelective(SysMensalBillCensus record);

    int updateByPrimaryKey(SysMensalBillCensus record);
}