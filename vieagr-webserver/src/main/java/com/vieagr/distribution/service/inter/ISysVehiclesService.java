package com.vieagr.distribution.service.inter;

import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.entity.SysVehicles;
import com.vieagr.distribution.query.SysVehiclesQuery;
import com.vieagr.distribution.response.SysVehiclesResponse;
import com.vieagr.distribution.service.base.IBaseService;

/**
 * 送货车辆业务
 * @author master
 *
 */
public interface ISysVehiclesService extends IBaseService<SysVehicles>{
	
	/**
	 * 分页查询送货车辆，Query对象接收
	 * @param sysVehiclesQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectVehiclesList(SysVehiclesQuery sysVehiclesQuery) throws Exception;
	
	/**
	 * 分页查询送货车辆，Entity对象接收
	 * @param sysVehiclesQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectVehiclesList(SysVehicles sysVehicles) throws Exception;
	
	/**
	 * 车辆--添加
	 * @Title: sysVehiclesAdd 
	 * @Description:     
	 * @param sysVehicles
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 上午9:48:49
	 */
	Object sysVehiclesAdd(SysVehicles sysVehicles) throws Exception;
	
	/**
	 * 车辆--列表查询
	 * @Title: selectSysVehiclesList 
	 * @Description:     
	 * @param sysVehicles
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 上午11:37:41
	 */
	 Object selectSysVehiclesList(SysVehicles sysVehicles) throws Exception;
	 
	 /**
	  * 商品进价单导出
	  * @param vehiclesId
	  * @param orderType
	  * @param chooseTime
	  * @return
	 * @throws Exception 
	  */
	 SysVehiclesResponse downLoadVehiclesBidAmountTotalExcel(String vehiclesId, Integer orderType,
			 String chooseTime, Integer bidType) throws Exception;
}
