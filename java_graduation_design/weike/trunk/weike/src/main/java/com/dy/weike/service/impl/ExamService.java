package com.dy.weike.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IExamDao;
import com.dy.weike.entity.Exam;
import com.dy.weike.service.inter.IExamService;

@Service
@Transactional
public class ExamService implements IExamService {

	@Resource
	private IExamDao iExamDao;
	@Override
	public int deleteByPrimaryKey(Exam b) {
		return iExamDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(Exam b) {
		return iExamDao.insert(b);
	}

	@Override
	public int insertSelective(Exam b) {
		return iExamDao.insertSelective(b);
	}

	@Override
	public Exam selectByPrimaryKey(Exam b) {
		return iExamDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(Exam b) {
		return iExamDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(Exam b) {
		return iExamDao.updateByPrimaryKey(b);
	}

	@Override
	public Object selectByAttribute(Exam b) {
		List<Exam> exam = iExamDao.selectByAttribute(b);
		List<Exam> list = new ArrayList<Exam>();
		System.out.println(exam);
		if( exam!= null && exam.size() != 0){
			for(int i=0;i<exam.size();i++){
				list.add(exam.get(i));
			}
			return list;
		}
		return null;
	}

}
