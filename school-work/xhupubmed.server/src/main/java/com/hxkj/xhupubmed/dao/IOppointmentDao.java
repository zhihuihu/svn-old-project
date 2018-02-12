package com.hxkj.xhupubmed.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hxkj.xhupubmed.entity.Oppointment;

/** 
 * ClassName:IOppointmentDao
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午5:08:29 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Repository
public interface IOppointmentDao extends IBaseDao<Oppointment> {

	/**
	 * 
	* @Title: selectByAttribute 
	* @Description: TODO    通过属性进行查询
	* @param oppointment
	* @return
	* @throws Exception   
	* @return List<Oppointment>    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午4:25:26
	 */
	public List<Oppointment> selectByAttribute(Oppointment oppointment) throws Exception;
}
