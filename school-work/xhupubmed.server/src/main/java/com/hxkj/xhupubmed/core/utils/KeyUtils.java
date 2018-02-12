package com.hxkj.xhupubmed.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * ClassName:KeyUtils
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月13日 下午7:29:00 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class KeyUtils {

	/**
	 * token 用户信息过期时间
	 */
	public static long TOKEN_TIME = 1800000;
	
	/**
	 * 图灵机器人访问 key
	 */
	public static final String TL_KEY = "99b9746f8c381a1940395e5bba7a099c";
	
	/**
	 * 图灵机器人访问地址 url
	 */
	public static final String TL_URL = "http://www.tuling123.com/openapi/api";
	
	/**
	 * 文本类
	 */
	public static final String TL_CODE_100000 = "100000";
	/**
	 * 连接类
	 */
	public static final String TL_CODE_200000 = "200000";
	/**
	 * 新闻类
	 */
	public static final String TL_CODE_302000 = "302000";
	/**
	 * 菜谱类
	 */
	public static final String TL_CODE_308000 = "308000";
	
	/**
	 * 用户验证码过期时间
	 */
	public static final long VER_CODE_TIME = 120000;
	
	public static String getToken(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString().substring(8, 24);
            result = fg(result);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
	
	private static String fg(String sorcesStr){
		StringBuffer result = new StringBuffer("");
		result.append(sorcesStr.substring(0, 4));
		result.append("-");
		result.append(sorcesStr.substring(5, 8));
		result.append("-");
		result.append(sorcesStr.substring(9, 12));
		result.append("-");
		result.append(sorcesStr.substring(13, 16));
		return result.toString();
	}
	
	/**
	 * 
	* @Function: 得到随机验证码
	* @Title: getVerCode 
	* @param @return     
	* @return String    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月8日 下午10:04:45
	* @Since JDK 1.8
	 */
	public static String getVerCode(){
		return String.valueOf(Math.random()*9000 +1000).substring(0, 4);
	}
}
