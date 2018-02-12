package com.vieagr.distribution.service.inter;

import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.entity.SysSender;
import com.vieagr.distribution.query.SysSenderQuery;
import com.vieagr.distribution.service.base.IBaseService;

/**
 * 送货人业务
 * @author master
 *
 */
public interface ISysSenderService extends IBaseService<SysSender>{

	/**
	 * 分页查询送货人，Query对象接收
	 * @param senderQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectSenderList(SysSenderQuery senderQuery) throws Exception;
	
	/**
	 * 分页查询送货人，Entity对象接收
	 * @param senderQuery
	 * @return
	 * @throws Exception 
	 */
	ReturnUtils selectSenderList(SysSender sysSender) throws Exception;
	
	/**
	 * sysSenderAdd
	 * @Title: sysSenderAdd 
	 * @Description:     
	 * @param sysSender
	 * @return
	 * @throws Exception   
	 * @return ReturnUtils    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 下午1:21:11
	 */
	ReturnUtils sysSenderAdd(SysSender sysSender) throws Exception;
	
	/**
	 * 送货人--列表查询
	 * @Title: selectSysSenderList 
	 * @Description:     
	 * @param sysSender
	 * @return
	 * @throws Exception   
	 * @return ReturnUtils    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 下午1:42:10
	 */
	ReturnUtils selectSysSenderList(SysSender sysSender) throws Exception;
}
