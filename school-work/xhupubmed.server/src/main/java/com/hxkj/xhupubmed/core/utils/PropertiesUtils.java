package com.hxkj.xhupubmed.core.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtils {

	/**
	 * 系统默认的配置文件
	 */
	private static final String configFIleName = "config.properties";
	/**
	 * 读取properties文件的对象
	 */
	private static Properties prop = new Properties();
	
	static{
		reflushProperties(configFIleName);
	}
	/**
	 * 
	* @Title: reflushProperties 
	* @Description: TODO    刷新配置文件的值
	* @param configFileName   配置文件的文件名称,没有修改就传入 ""
	* @return void    
	* @author huzhihui_c@qq.com
	* @date 2016年4月28日 下午3:42:44
	 */
	public static void reflushProperties(String configFileName){
		String path = "";
		if(configFileName != null && configFileName.trim() != ""){
			path = PropertiesUtils.class.getClassLoader().getResource(configFileName).getPath();
		}else{
			path = PropertiesUtils.class.getClassLoader().getResource("config.properties").getPath();
		}
		try{
			FileInputStream in = new FileInputStream(path);
			prop.load(in);
		}catch(Exception e){
			System.out.println(e.toString());
		}
	}
	
	/**
	 * 通过配置的名称得到值
	* @Title: getPropertiesValue 
	* @Description: TODO    
	* @param propertiesName
	* @return   
	* @return String    
	* @author huzhihui_c@qq.com
	* @date 2016年4月28日 下午3:39:14
	 */
	public static String getPropertiesValue(String propertiesName){
		return prop.getProperty(propertiesName);
	}
}
