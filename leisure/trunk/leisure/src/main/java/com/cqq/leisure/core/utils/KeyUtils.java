package com.cqq.leisure.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/** 
 * ClassName:KeyUtils，生成token
 * Function:   
 * Date:     2016年3月13日 下午7:29:00 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class KeyUtils {

	public static long TOKEN_TIME = 1800000;
	
	
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
}
