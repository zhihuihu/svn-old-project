package com.hxkj.xhupubmed.service.inter;

import com.hxkj.xhupubmed.entity.Follow;
import com.hxkj.xhupubmed.service.IBaseService;

/** 
 * ClassName:IFollowService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午9:47:25 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IFollowService extends IBaseService<Follow> {

	public Follow selectByAttribute(Follow follow) throws Exception;
	
	//只实现postCuid
	public int doDeleteByAttribute(Follow follow) throws Exception;
}
