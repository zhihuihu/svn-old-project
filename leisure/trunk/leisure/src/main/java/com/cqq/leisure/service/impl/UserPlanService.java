package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.dao.IUserPlanDao;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.UserPlan;
import com.cqq.leisure.service.inter.IUserPlanService;

/** 
 * ClassName:UserPlanService
 * Function:   
 * Date:     2016年3月20日 下午9:21:56 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class UserPlanService implements IUserPlanService {

	@Resource
	private IUserPlanDao iUserPlanDao;
	
	@Override
	public int doDeleteByPrimaryKey(UserPlan b) throws Exception {
		return iUserPlanDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<UserPlan> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserPlanDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(UserPlan b) throws Exception {
		return iUserPlanDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<UserPlan> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserPlanDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，增加数据失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(UserPlan b) throws Exception {
		return iUserPlanDao.doInsertSelective(b);
	}

	@Override
	public UserPlan selectByPrimaryKey(UserPlan b) throws Exception {
		return iUserPlanDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(UserPlan b) throws Exception {
		return iUserPlanDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(UserPlan b) throws Exception {
		return iUserPlanDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<UserPlan> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserPlanDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，修改数据失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<UserPlan> pageBean) throws Exception {
		int lineCount = iUserPlanDao.selectByAttributeCountAnd(pageBean);
		List<UserPlan> list = iUserPlanDao.selectByAttributeAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<UserPlan> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<UserPlan> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<UserPlan> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
