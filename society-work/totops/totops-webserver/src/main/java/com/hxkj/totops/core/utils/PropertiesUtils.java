package com.hxkj.totops.core.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: PropertiesUtils 
 * @Description: 配置文件读取工具类
 * @author huzhihui_c@qq.com
 * @date 2016年7月14日 下午6:00:34
 */
public class PropertiesUtils {

	private static Logger logger = LoggerFactory.getLogger(PropertiesUtils.class);
	/**
	 * 系统默认的配置文件
	 */
	private static final String CONFIG_FILE_PATH = "config.properties";
	/**
	 * 读取properties文件的对象
	 */
	private static Properties prop = new Properties();
	
	static{
		reflushProperties(CONFIG_FILE_PATH);
	}
	
	/**
	 * @Title: reflushProperties 
	 * @Description:     刷新配置文件配置
	 * @param configFileName   
	 * @return void    
	 * @author huzhihui_c@qq.com
	 * @date 2016年7月14日 下午6:00:01
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
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @Title: getPropertiesValue 
	 * @Description:     通过属性名称获取值
	 * @param propertiesName
	 * @return   
	 * @return String    
	 * @author huzhihui_c@qq.com
	 * @date 2016年7月14日 下午5:59:42
	 */
	public static String getPropertiesValue(String propertiesName){
		//logger.info("propertiesName:"+prop.getProperty(propertiesName));
		return prop.getProperty(propertiesName);
	}
	
	/**
	 * @Title: setPropertiesValue 
	 * @Description:     更新或者新增属性
	 * @param propertiesName
	 * @param propertiesValue
	 * @return   
	 * @return boolean    
	 * @author huzhihui_c@qq.com
	 * @date 2016年7月21日 下午4:02:15
	 */
	public static boolean setPropertiesValue(String propertiesName,String propertiesValue){
		boolean result = false;
		String path = PropertiesUtils.class.getClassLoader().getResource(CONFIG_FILE_PATH).getPath();
		try {
			FileOutputStream out = new FileOutputStream(path);
			prop.setProperty(propertiesName, propertiesValue);
			prop.store(out, "update CUID_PRE");
			out.close();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("FSSLR-WEBSERVER-ERROR:config.properties写入失败");
		}
		return result;
	}
}
