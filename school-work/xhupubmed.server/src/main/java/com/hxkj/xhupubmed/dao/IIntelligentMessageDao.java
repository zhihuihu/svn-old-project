package com.hxkj.xhupubmed.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hxkj.xhupubmed.entity.IntelligentMessage;

/** 
 * ClassName:IIntelligentMessageDao
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午5:06:34 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface IIntelligentMessageDao extends IBaseDao<IntelligentMessage> {

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
	public List<IntelligentMessage> selectListByInitTask(IntelligentMessage intelligentMessage) throws Exception;
}
