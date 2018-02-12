package com.hxkj.xhupubmed.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.crypto.Data;

import org.junit.Test;

/**
 * ClassName:TimeTest Function:
 * 
 * @author huzhihui_c@qq.com Date: 2016年5月21日 下午4:42:39
 * @version 1.0
 * @since JDK 1.8
 */
public class TimeTest {

	@Test
	public void testSub() {
		System.out.println(TimeUtils.getMySqlFormatTime().substring(0, 10));
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
	
	@Test
	public void testGetDay(){
		Date earlydate = new Date();   
        Date latedate = new Date();   
        DateFormat df = DateFormat.getDateInstance();   
        try {   
            earlydate = df.parse("2016-05-24");   
            latedate = df.parse("2016-05-24");   
        } catch (ParseException e) {   
              e.printStackTrace();   
          }   
         int days = daysBetween(earlydate,latedate);   
         TimeUtils.getMySqlFormatTime().substring(0, 10);
         System.out.println(days);   
	}
}
