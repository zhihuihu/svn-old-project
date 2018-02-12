package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.ILearnPlanDao;
import com.hxkj.xhupubmed.entity.LearnPlan;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.ILearnPlanService;

/** 
 * ClassName:LearnPlanService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午7:38:00 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class LearnPlanService implements ILearnPlanService {

	@Resource
	private ILearnPlanDao ILearnPlanDao;
	
	@Override
	public int doDeleteByPrimaryKey(LearnPlan b) throws Exception {
		return ILearnPlanDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<LearnPlan> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = ILearnPlanDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(LearnPlan b) throws Exception {
		CuidUtils.setCuid(b, "学习计划表插入");
		return ILearnPlanDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<LearnPlan> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "学习计划表插入", new LearnPlan());
		for(int i=0;i<bs.size();i++){
			flg = ILearnPlanDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(LearnPlan b) throws Exception {
		CuidUtils.setCuid(b, "学习计划表插入");
		return ILearnPlanDao.doInsertSelective(b);
	}

	@Override
	public LearnPlan selectByPrimaryKey(LearnPlan b) throws Exception {
		return ILearnPlanDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(LearnPlan b) throws Exception {
		return ILearnPlanDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(LearnPlan b) throws Exception {
		return ILearnPlanDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<LearnPlan> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = ILearnPlanDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("更新数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<LearnPlan> pageBean) throws Exception {
		List<LearnPlan> lists = ILearnPlanDao.selectByAttributeAnd(pageBean);
		int lineCount = ILearnPlanDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<LearnPlan> pageBean) throws Exception {
		return ILearnPlanDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<LearnPlan> pageBean) throws Exception {
		List<LearnPlan> lists = ILearnPlanDao.selectByAttributeOr(pageBean);
		int lineCount = ILearnPlanDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<LearnPlan> pageBean) throws Exception {
		return ILearnPlanDao.selectByAttributeCountOr(pageBean);
	}

}
