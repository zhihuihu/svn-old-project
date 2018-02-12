package com.hxkj.xhupubmed.intercept.task;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;

import com.hxkj.xhupubmed.core.utils.SpringContextUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.dao.IIntelligentMessageDao;
import com.hxkj.xhupubmed.dao.ILearnPlanDao;
import com.hxkj.xhupubmed.entity.LearnPlan;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.impl.IntelligentMessageService;
import com.hxkj.xhupubmed.service.impl.LearnPlanService;

/** 
 * ClassName:UserPlanTask
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年6月1日 上午9:35:32 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class UserPlanTask {

	private static ILearnPlanDao iLearnPlanDao;
	private static IIntelligentMessageDao iIntelligentMessageDao;
	static{
		iLearnPlanDao = (ILearnPlanDao) SpringContextUtils.getBean("ILearnPlanDao");
		iIntelligentMessageDao = (IIntelligentMessageDao) SpringContextUtils.getBean("IIntelligentMessageDao");
	}
	
	@Scheduled(fixedRate = 60000)
	public void checkUserSession(){
		new Thread(new Runnable() {  
            @Override  
            public void run() {  
            	System.out.println("---------开始执行用户个人任务检查 ："+TimeUtils.getMySqlFormatTime());
            }  
        }).start();
	}
	
	private void checkTask() throws Exception{
		PageBean<LearnPlan> pageBean = new PageBean<>(1, 10000);
		pageBean.setInVo(new LearnPlan());
		pageBean.setStartTime(TimeUtils.getMySqlFormatTime());
		List<LearnPlan> learnPlans = iLearnPlanDao.selectByAttributeAnd(pageBean);
		if(learnPlans != null && learnPlans.size()!=0){
			
		}
	}
}
