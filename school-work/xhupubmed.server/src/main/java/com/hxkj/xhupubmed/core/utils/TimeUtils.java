package com.hxkj.xhupubmed.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * Project Name:photocms.server 
 * ClassName:TimeUtils
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午3:16:29 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class TimeUtils {

	/**
	 * 
	 * getCurrentTimeMillis:
	 * TODO: 返回当前毫秒很长long
	 * @return:当前毫秒
	 * @author huzhihui 
	 * date: 2015年12月15日 下午9:36:44
	 * @since JDK 1.8
	 */
	public static long getCurrentTimeMillis(){
		return System.currentTimeMillis();
	}
	
	
	/**
	 * 
	 * getCurrentSecond:
	 * TODO: 得到当前秒数，一分钟以内的
	 * @return: 当前秒数
	 * @author huzhihui 
	 * date: 2015年12月15日 下午9:42:48
	 * @since JDK 1.8
	 */
	public static int getCurrentSecond(){
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int second = calendar.get(Calendar.SECOND);
		return second;
	}
	
	
	public static String getSimpleFormatTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-S");
		Date date = new Date();
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 
	 * getLocalFormatTime:
	 * TODO: 执行返回时间的到毫秒级别
	 * @return:到毫秒级别的时间
	 * @author huzhihui 
	 * date: 2015年12月19日 下午12:23:35
	 * @since JDK 1.8
	 */
	public static String getLocalFormatTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S");
		Date date = new Date();
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 
	 * getMySqlFormatTime:
	 * TODO:得到MySQL的datetime时间
	 * @return: 得到2015-02-03 12:02:23
	 * @author huzhihui 
	 * date: 2015年12月19日 下午12:22:28
	 * @since JDK 1.8
	 */
	public static String getMySqlFormatTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 
	 * getCuidHeadTime:
	 * TODO:
	 * @return:
	 * @author huzhihui 
	 * date: 2016年1月20日 下午12:33:05
	 * @since JDK 1.8
	 */
	public static String getCuidHeadTime(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 
	* @Function: 获取当前日期， yyyy-MM-dd
	* @Title: getMySqlDay  
	* @return   
	* String    
	* @author huzhihui_c@qq.com   
	* @date 2016年6月1日 上午10:31:31
	* @Since JDK 1.8
	 */
	public static String getMySqlDay(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String time = sdf.format(date);
		return time;
	}
	
	/**
	 * 
	* @Title: getImageNamePrefix 
	* @Description: 返回图片名称
	* @param @return     
	* @return String    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月18日 下午7:01:01
	* @Since JDK 1.8
	 */
	public static String getImageNamePrefix()
	{
		String namePrefix = String.valueOf(System.currentTimeMillis());
		namePrefix += (int)((Math.random()*899+100));
		System.out.println(namePrefix);
		return namePrefix;
	}
	
	public static final int daysBetween(Date early, Date late) {
		java.util.Calendar calst = java.util.Calendar.getInstance();
		java.util.Calendar caled = java.util.Calendar.getInstance();
		calst.setTime(early);
		caled.setTime(late);
		// 设置时间为0时
		calst.set(java.util.Calendar.HOUR_OF_DAY, 0);
		calst.set(java.util.Calendar.MINUTE, 0);
		calst.set(java.util.Calendar.SECOND, 0);
		caled.set(java.util.Calendar.HOUR_OF_DAY, 0);
		caled.set(java.util.Calendar.MINUTE, 0);
		caled.set(java.util.Calendar.SECOND, 0);
		// 得到两个日期相差的天数
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst.getTime().getTime() / 1000)) / 3600 / 24;
		return days;
	}
}
