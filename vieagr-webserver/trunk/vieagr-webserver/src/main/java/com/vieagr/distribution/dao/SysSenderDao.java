package com.vieagr.distribution.dao;

import java.util.List;

import com.vieagr.distribution.dao.base.IBaseDao;
import com.vieagr.distribution.entity.SysSender;

public interface SysSenderDao extends IBaseDao<SysSender> {

	/**
	 * 送货人--列表查询
	 * @Title: selectSysSenderList 
	 * @Description:     
	 * @param sysSender
	 * @return
	 * @throws Exception   
	 * @return List<SysSender>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 下午1:45:20
	 */
	List<SysSender> selectSysSenderList(SysSender sysSender) throws Exception;
}