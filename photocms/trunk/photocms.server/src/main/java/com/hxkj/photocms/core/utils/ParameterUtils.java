package com.hxkj.photocms.core.utils;

import com.alibaba.fastjson.JSON;
import com.hxkj.photocms.entity.DataInBean;

/** 
 * Project Name:photocms.server 
 * ClassName:ParameterUtils
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月20日 下午6:58:00 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class ParameterUtils {

	public static DataInBean getDataInBeanFromPage(String dataInBean,DataInBean dataInBeanJson){
		if(dataInBean!=null){
			dataInBeanJson = JSON.parseObject(dataInBean, DataInBean.class);
		}
		return dataInBeanJson;
	}
}
