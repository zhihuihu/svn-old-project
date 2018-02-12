package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.dao.IProgramPlanDao;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.ProgramPlan;
import com.cqq.leisure.service.inter.IProgramPlanService;

/** 
 * ClassName:ProgramPlanService
 * Function:   
 * Date:     2016年3月20日 下午9:00:01 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class ProgramPlanService implements IProgramPlanService {

	@Resource
	private IProgramPlanDao iProgramPlanDao;
	
	@Override
	public int doDeleteByPrimaryKey(ProgramPlan b) throws Exception {
		return iProgramPlanDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<ProgramPlan> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iProgramPlanDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(ProgramPlan b) throws Exception {
		return iProgramPlanDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<ProgramPlan> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iProgramPlanDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，增加数据失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(ProgramPlan b) throws Exception {
		return iProgramPlanDao.doInsertSelective(b);
	}

	@Override
	public ProgramPlan selectByPrimaryKey(ProgramPlan b) throws Exception {
		return iProgramPlanDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(ProgramPlan b) throws Exception {
		return iProgramPlanDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(ProgramPlan b) throws Exception {
		return iProgramPlanDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<ProgramPlan> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iProgramPlanDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，修改数据失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<ProgramPlan> pageBean) throws Exception {
		int lineCount = iProgramPlanDao.selectByAttributeCountAnd(pageBean);
		List<ProgramPlan> list = iProgramPlanDao.selectByAttributeAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return  PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<ProgramPlan> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<ProgramPlan> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<ProgramPlan> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
