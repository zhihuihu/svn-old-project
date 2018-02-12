package com.hxkj.photocms.intercept.session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.hxkj.photocms.core.utils.TimeUtils;
import com.hxkj.photocms.entity.SysUser;
import com.hxkj.photocms.entity.UserSession;

/** 
 * Project Name:photocms.server 
 * ClassName:UserSessionUtils
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月14日 下午1:56:54 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class UserSessionUtils {

	private static Map<String,UserSession> sessionMap = new HashMap<>();
	
	private static long OUTTIME = 1800000;
	
	/**
	 * 
	* @Title: addUserSession 
	* @Description: 设置用户的session以便下次访问
	* @param @param sysUser
	* @param @return     
	* @return UserSession    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月17日 下午8:50:01
	* @Since JDK 1.8
	 */
	public static UserSession addUserSession(SysUser sysUser){
		sysUser.setSysUserPassword("");
		String sessionId = MD5(sysUser.getSysUserCuid());
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		userSession.setSysUser(sysUser);
		userSession.setUpdateTime(TimeUtils.getMySqlFormatTime());
		sessionMap.put(sessionId, userSession);
		return userSession;
	}
	
	/**
	 * 
	* @Title: getUserSession 
	* @Description: 查找用户的存在的session
	* @param @param sessionId
	* @param @return     
	* @return UserSession    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月17日 下午8:50:32
	* @Since JDK 1.8
	 */
	public static UserSession getUserSession(String sessionId){
		UserSession userSession = sessionMap.get(sessionId);
		return userSession;
	}
	
	public static boolean destoryUserSession(String sessionId){
		sessionMap.remove(sessionId);
		return true;
	}
	
	public static void checkUserSession(){
		for(Map.Entry<String, UserSession> userSession : sessionMap.entrySet()){
			if(System.currentTimeMillis()-userSession.getValue().getUpdateTimeSecond()>=OUTTIME){
				sessionMap.remove(userSession.getKey());
			}
		}
	}
	
	
	/**
	 * 
	* @Title: updateUserSession 
	* @Description: TODO 用户的session信息更新
	* @param @param sessionId
	* @param @param userSession     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月19日 下午8:18:14
	* @Since JDK 1.8
	 */
	public static void updateUserSession(String sessionId,UserSession userSession){
		sessionMap.replace(sessionId, userSession);
	}
	
	
	
	
	
	
	private static String MD5(String sourceStr) {
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
}
