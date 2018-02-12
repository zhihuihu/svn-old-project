package com.hxkj.waychat.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * JackSon的转换工具类
 * @ClassName: JackSonUtils 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年8月12日 下午2:39:41
 */
public class JackSonUtils {

	@SuppressWarnings("unused")
	private static Logger logger = LoggerFactory.getLogger(JackSonUtils.class);
	
	/**
	 * 对象转为json
	 * @Title: toString 
	 * @Description:     
	 * @param object
	 * @return   
	 * @return String    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月12日 下午3:01:45
	 */
	public static String toString(Object object){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * json转为对象
	 * @Title: toObject 
	 * @Description:     
	 * @param jsonString
	 * @param classType
	 * @return   
	 * @return T    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月12日 下午3:01:59
	 */
	public static <T> T toObject(String jsonString,Class<T> classType){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonString, classType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
