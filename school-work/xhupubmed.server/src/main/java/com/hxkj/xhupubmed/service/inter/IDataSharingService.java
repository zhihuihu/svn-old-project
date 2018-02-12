package com.hxkj.xhupubmed.service.inter;

import javax.servlet.http.HttpServletRequest;

import com.hxkj.xhupubmed.entity.DataSharing;
import com.hxkj.xhupubmed.service.IBaseService;

/** 
 * ClassName:IDataSharingService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午3:15:36 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IDataSharingService extends IBaseService<DataSharing> {
	
	public Object doInsertFiles(HttpServletRequest request,DataSharing dataSharing) throws Exception; 

	public Object adminDoInsert(HttpServletRequest request,DataSharing dataSharing) throws Exception; 
}
