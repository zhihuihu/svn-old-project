package com.cqq.leisure.service.inter;

import java.util.Map;

import com.cqq.leisure.entity.HolidayPlan;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.service.IBaseService;

/** 
 * ClassName:IHolidayPlanService
 * Function:   
 * Date:     2016年3月20日 下午8:03:40 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface IHolidayPlanService extends IBaseService<HolidayPlan> {

	public Map<String,Object> getRecommendHolidayPlan(User user) throws Exception;
}
