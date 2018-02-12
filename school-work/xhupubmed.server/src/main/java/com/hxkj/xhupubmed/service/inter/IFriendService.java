package com.hxkj.xhupubmed.service.inter;

import com.hxkj.xhupubmed.entity.Friend;
import com.hxkj.xhupubmed.service.IBaseService;

/** 
 * ClassName:IFriendService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午3:53:25 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IFriendService extends IBaseService<Friend> {

	/**
	 * 
	* @Function: 通过friend表的属性进行查询 返回一个
	* @Title: selectByAttribute 
	* @param @param friend
	* @param @return
	* @param @throws Exception     
	* @return Friend    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月13日 下午9:38:46
	* @Since JDK 1.8
	 */
	public Friend selectByAttribute(Friend friend) throws Exception;
}
