package com.hxkj.xhupubmed.service.inter;

import javax.servlet.http.HttpServletRequest;

import com.hxkj.xhupubmed.entity.Replies;
import com.hxkj.xhupubmed.service.IBaseService;

/** 
 * ClassName:IRepliesService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月9日 上午11:26:47 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IRepliesService extends IBaseService<Replies> {

	public Object doInsertImages(HttpServletRequest request, String repliesCuid) throws Exception;
}
