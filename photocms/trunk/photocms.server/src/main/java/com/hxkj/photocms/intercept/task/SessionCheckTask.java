package com.hxkj.photocms.intercept.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hxkj.photocms.core.utils.TimeUtils;
import com.hxkj.photocms.intercept.session.UserSessionUtils;

/** 
 * Project Name:photocms.server 
 * ClassName:SessionCheck
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月19日 下午7:40:56 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Component
public class SessionCheckTask {
	
	/**
	 * 
	* @Title: checkUserSession 
	* @Description: TODO 定时任务，检查sessionId
	* @param      
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月19日 下午8:13:00
	* @Since JDK 1.8
	 */
	@Scheduled(fixedRate = 900000)
	public void checkUserSession(){
		new Thread(new Runnable() {  
            @Override  
            public void run() {  
            	System.out.println("---------开始执行session检查 ："+TimeUtils.getMySqlFormatTime());
            	UserSessionUtils.checkUserSession();
            }  
        }).start();
	}
}
