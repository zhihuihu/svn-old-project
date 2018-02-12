package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.dao.IForbiddenDao;
import com.cqq.leisure.entity.Forbidden;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.inter.IForbiddenService;

@Service
@Transactional
public class ForbiddenService implements IForbiddenService {

	@Resource
	private IForbiddenDao  iForbiddenDao;
	@Override
	public int doDeleteByPrimaryKey(Forbidden b) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Forbidden> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsert(Forbidden b) throws Exception {
		// TODO Auto-generated method stub
		return iForbiddenDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Forbidden> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsertSelective(Forbidden b) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Forbidden selectByPrimaryKey(Forbidden b) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Forbidden b) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdateByPrimaryKey(Forbidden b) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Forbidden> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Forbidden> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		int lineCount = iForbiddenDao.selectByAttributeCountAnd(pageBean);
		List<Forbidden> list = iForbiddenDao.selectByAttributeAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Forbidden> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Forbidden> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Forbidden> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
