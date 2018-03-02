package com.vieagr.distribution.dao;

import java.util.List;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SysVehicles;

public interface SysVehiclesDao extends IBaseDao<SysVehicles> {

	/**
	 * 车辆--列表查询
	 * @Title: selectSysVehiclesList 
	 * @Description:     
	 * @param sysVehicles
	 * @return
	 * @throws Exception   
	 * @return List<SysVehicles>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 上午11:39:37
	 */
	List<SysVehicles> selectSysVehiclesList(SysVehicles sysVehicles) throws Exception;
}