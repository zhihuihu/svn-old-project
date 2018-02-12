package com.hxkj.xhupubmed.core.utils;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.entity.pojo.DataInBean;

/** 
 * Project Name:photocms.server 
 * ClassName:ParameterUtils
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月20日 下午6:58:00 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class ParameterUtils {

	/*private static String ROBOT_100000 = "100000";
	private static String ROBOT_200000 = "200000";
	private static String ROBOT_302000 = "302000";
	private static String ROBOT_308000 = "308000";*/
	/**
	 * 
	* @Function:  字符串转为对象
	* @Title: getDataInBeanFromPage 
	* @param @param dataInBean
	* @param @return     
	* @return DataInBean    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月12日 下午8:59:31
	* @Since JDK 1.8
	 */
	public static DataInBean getDataInBeanFromPage(String dataInBean){
		return JSON.parseObject(dataInBean, DataInBean.class);
	}
	
}
