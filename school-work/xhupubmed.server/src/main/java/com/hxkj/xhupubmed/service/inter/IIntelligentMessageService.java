package com.hxkj.xhupubmed.service.inter;

import java.util.List;

import com.hxkj.xhupubmed.entity.IntelligentMessage;
import com.hxkj.xhupubmed.service.IBaseService;

/** 
 * ClassName:IIntelligentMessageService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午5:55:51 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IIntelligentMessageService extends IBaseService<IntelligentMessage> {

	/**
	 * 
	* @Title: selectListByInitTask 
	* @Description: TODO    用户查询是否有回复的消息
	* @param intelligentMessage
	* @return   
	* @return List<IntelligentMessage>    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午4:36:21
	 */
	public List<IntelligentMessage> selectListByInitTask(IntelligentMessage intelligentMessage)  throws Exception;
}
