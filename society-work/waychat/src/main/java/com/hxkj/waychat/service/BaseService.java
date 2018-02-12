package com.hxkj.waychat.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.waychat.core.utils.PageReturnUtils;
import com.hxkj.waychat.dao.IBaseDao;
import com.hxkj.waychat.entity.query.PageBean;

@Transactional
public abstract class BaseService<B> implements IBaseService<B> {

	@Autowired
	private IBaseDao<B> ibaseDao;
	
	@Override
	public int deleteByPrimaryKey(String cuid) throws Exception {
		return ibaseDao.deleteByPrimaryKey(cuid);
	}

	@Override
	public int insert(B b) throws Exception {
		return ibaseDao.insert(b);
	}

	@Override
	public int insertSelective(B b) throws Exception {
		return ibaseDao.insertSelective(b);
	}

	@Override
	public B selectByPrimaryKey(String cuid) throws Exception {
		return ibaseDao.selectByPrimaryKey(cuid);
	}

	@Override
	public int updateByPrimaryKeySelective(B b) throws Exception {
		return ibaseDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(B b) throws Exception {
		return ibaseDao.updateByPrimaryKey(b);
	}

	@Override
	public List<B> selectByAttribute(B b) throws Exception {
		return ibaseDao.selectByAttribute(b);
	}

	@Override
	public Map<String,Object> selectByPageAnd(PageBean<B> pageBean) throws Exception {
		List<B> list = ibaseDao.selectByPageAnd(pageBean);
		int totalLine = ibaseDao.selectByPageAndCount(pageBean);
		return PageReturnUtils.formatPage("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, list, pageBean.getCurrentPage(), pageBean.getPageSize(), totalLine);
	}

	@Override
	public int selectByPageAndCount(PageBean<B> pageBean) throws Exception {
		return ibaseDao.selectByPageAndCount(pageBean);
	}

}
