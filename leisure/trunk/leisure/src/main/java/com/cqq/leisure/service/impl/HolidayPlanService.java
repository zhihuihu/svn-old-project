package com.cqq.leisure.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.core.utils.TimeUtils;
import com.cqq.leisure.dao.IHolidayPlanDao;
import com.cqq.leisure.dao.IUserPlanDao;
import com.cqq.leisure.entity.HolidayPlan;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.entity.UserPlan;
import com.cqq.leisure.service.inter.IHolidayPlanService;

/** 
 * ClassName:HolidayPlanService
 * Function:   
 * Date:     2016年3月20日 下午8:04:32 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class HolidayPlanService implements IHolidayPlanService {

	@Resource
	private IHolidayPlanDao iHolidayPlanDao;
	@Resource
	private IUserPlanDao iUserPlanDao;
	@Override
	public int doDeleteByPrimaryKey(HolidayPlan b) throws Exception {
		return iHolidayPlanDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<HolidayPlan> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iHolidayPlanDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(HolidayPlan b) throws Exception {
		return iHolidayPlanDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<HolidayPlan> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iHolidayPlanDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，增加数据失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(HolidayPlan b) throws Exception {
		return iHolidayPlanDao.doInsertSelective(b);
	}

	@Override
	public HolidayPlan selectByPrimaryKey(HolidayPlan b) throws Exception {
		return iHolidayPlanDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(HolidayPlan b) throws Exception {
		return iHolidayPlanDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(HolidayPlan b) throws Exception {
		return iHolidayPlanDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<HolidayPlan> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iHolidayPlanDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，修改数据失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<HolidayPlan> pageBean) throws Exception {
		int lineCount = iHolidayPlanDao.selectByAttributeCountAnd(pageBean);
		List<HolidayPlan> list = iHolidayPlanDao.selectByAttributeAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<HolidayPlan> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<HolidayPlan> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<HolidayPlan> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> getRecommendHolidayPlan(User user)
			throws Exception {
		List<HolidayPlan> holidayPlans = new ArrayList<HolidayPlan>();
		PageBean<UserPlan> userPlanbean = new PageBean<UserPlan>(0, 10000);
		userPlanbean.setStartTime(TimeUtils.getMySqlFormatTime());
		UserPlan userPlan = new UserPlan();
		userPlan.setUserId(user.getUserId());
		userPlanbean.setInVo(userPlan);
		//选出该用户所有的日历规划
		List<UserPlan> userPlans = iUserPlanDao.selectByAttributeAnd(userPlanbean);
		//遍历所有的日历规划
		for(int i=0;i<userPlans.size();i++){
			PageBean<HolidayPlan> pageBean = new PageBean<HolidayPlan>(1, 10000);
			pageBean.setSearchName(userPlans.get(i).getUserPlanName());
			pageBean.setStartTime(TimeUtils.getMySqlFormatTime());
			pageBean.setInVo(new HolidayPlan());
			List<HolidayPlan> list = iHolidayPlanDao.selectByAttributeAnd(pageBean);
			if(list != null && list.size()!=0){
				holidayPlans.addAll(list);
			}
		}
		return PageBeanUtils.formatForPageTrue(holidayPlans, 1, 10000, 1);
	}

}
