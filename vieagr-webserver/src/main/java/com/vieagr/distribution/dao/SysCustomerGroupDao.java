package com.vieagr.distribution.dao;

import java.util.List;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SysCustomerGroup;

public interface SysCustomerGroupDao extends IBaseDao<SysCustomerGroup> {
	
    int deleteByPrimaryKey(String sysCustomerGroupId);

    int insert(SysCustomerGroup record);

    int insertSelective(SysCustomerGroup record);

    SysCustomerGroup selectByPrimaryKey(String sysCustomerGroupId);

    int updateByPrimaryKeySelective(SysCustomerGroup record);

    int updateByPrimaryKey(SysCustomerGroup record);
    
    /**
     * 根据顾客id查询顾客分组信息
     * @param customerId
     * @return
     */
    SysCustomerGroup selectSysCustomerGroupByCustomerId(String customerId);
    
    /**
     * 查询所有的有效的顾客分组
     * @return
     */
    List<SysCustomerGroup> selectEffectiveSysCustomerGroup();
    
    /**
     * 根据条件查询出一条顾客分组
     * @param sysCustomerGroup
     * @return
     */
    SysCustomerGroup selectSysCustomerGroupByCondition(SysCustomerGroup sysCustomerGroup);
    
    /**
     * 根据条件查询顾客分组列表
     * @param sysCustomerGroup
     * @return
     */
    List<SysCustomerGroup>selectSysCustomerGroupListByCondition(SysCustomerGroup sysCustomerGroup);
    
}