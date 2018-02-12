package com.hxkj.totops.core.utils;

import java.util.HashMap;
import java.util.Map;

import com.hxkj.totops.core.config.Constant;

/**
 * @ClassName: PageReturnUtils 
 * @Description: 返回页面数据工具类
 * @author huzhihui_c@qq.com
 * @date 2016年7月18日 下午1:35:25
 */
public class PageReturnUtils {

	/**
	 * success的请求code
	 */
	public static final String MSG_CODE_000000 = "000000";
	
	/**
	 * error的请求code
	 */
	public static final String MSG_CODE_111111 = "111111";
	
	/**
	 * success的状态
	 */
	public static final boolean MSG_STATE_TRUE = true;
	
	/**
	 * error的状态
	 */
	public static final boolean MSG_STATE_FALSE = false;
	
	private static final String TOKEN = "token";
	
	private static final String MSG_CODE = "msgCode";
	
	private static final String MSG_STATE = "msgState";
	
	private static final String MSG = "msg";
	
	private static final String CURRENT_PAGE = "currentPage";
	
	private static final String PAGE_SIZE = "pageSize";
	
	private static final String TOTAL_PAGE = "totalPage";
	
	private static final String TOTAL_LINE = "totalLine";
	
	private static final String IMAGE_URL_PRE = "imageUrlPre";
	
	/**
	 * @Title: formatNormal 
	 * @Description:     普通ajax请求数据返回
	 * @param token	登录认证token
	 * @param msgCode	消息编码
	 * @param msgState	程序运行是否正确或者是否返回数据正确
	 * @param msg	返回消息
	 * @return   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年7月18日 下午2:14:53
	 */
	public static Map<String,Object> formatNormal(String token,String msgCode,boolean msgState,Object msg){
		Map<String,Object> map = new HashMap<>();
		map.put(IMAGE_URL_PRE, PropertiesUtils.getPropertiesValue(Constant.HTTP_FILE_URL));
		map.put(TOKEN, token);
		map.put(MSG_CODE, msgCode);
		map.put(MSG_STATE, msgState);
		map.put(MSG, msg);
		return map;
	}
	
	/**
	 * @Title: formatPage 
	 * @Description:     分页ajax请求数据返回
	 * @param token		登录认证token
	 * @param msgCode	消息编码
	 * @param msgState	程序运行是否正确或者是否返回数据正确
	 * @param msg	返回消息
	 * @param currentPage	当前页
	 * @param pageSize	分页大小
	 * @param totalPage	总共页数
	 * @param totalLine	总行数
	 * @return   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年7月18日 下午2:15:19
	 */
	public static Map<String,Object> formatPage(String token,String msgCode,boolean msgState,Object msg,int currentPage,int pageSize,int totalLine){
		Map<String,Object> map = new HashMap<>();
		map.put(IMAGE_URL_PRE, PropertiesUtils.getPropertiesValue(Constant.HTTP_FILE_URL));
		map.put(TOKEN, token);
		map.put(MSG_CODE, msgCode);
		map.put(MSG_STATE, msgState);
		map.put(MSG, msg);
		map.put(CURRENT_PAGE, currentPage);
		map.put(PAGE_SIZE, pageSize);
		map.put(TOTAL_PAGE, (totalLine + pageSize) % pageSize == 0 ? (totalLine / pageSize) : ((totalLine + pageSize) / pageSize));
		map.put(TOTAL_LINE, totalLine);
		return map;
	}
}
