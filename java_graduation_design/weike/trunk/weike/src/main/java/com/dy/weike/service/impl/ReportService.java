package com.dy.weike.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IReportDao;
import com.dy.weike.entity.Report;
import com.dy.weike.service.inter.IReportService;

@Service
@Transactional
public class ReportService implements IReportService {

	@Resource
	private IReportDao iReportDao;
	
	@Override
	public int deleteByPrimaryKey(Report b) {
		return iReportDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(Report b) {
		return iReportDao.insert(b);
	}

	@Override
	public int insertSelective(Report b) {
		return iReportDao.insertSelective(b);
	}

	@Override
	public Report selectByPrimaryKey(Report b) {
		return iReportDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(Report b) {
		return iReportDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(Report b) {
		return iReportDao.updateByPrimaryKey(b);
	}

}
