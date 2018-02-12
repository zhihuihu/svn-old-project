package com.hxkj.xhupubmed.service.inter;

import java.util.List;

import com.hxkj.xhupubmed.entity.Oppointment;
import com.hxkj.xhupubmed.service.IBaseService;

/** 
 * ClassName:IOppointmentService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午8:59:31 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IOppointmentService extends IBaseService<Oppointment> {

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
