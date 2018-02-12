package com.dy.weike.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.weike.dao.IBookDao;
import com.dy.weike.entity.Book;
import com.dy.weike.service.inter.IBookService;

@Service
@Transactional
public class BookService implements IBookService {
	
	@Resource
	private IBookDao iBookDao;

	@Override
	public int deleteByPrimaryKey(Book b) {
		return iBookDao.deleteByPrimaryKey(b);
	}

	@Override
	public int insert(Book b) {
		return iBookDao.insert(b);
	}

	@Override
	public int insertSelective(Book b) {
		return iBookDao.insertSelective(b);
	}

	@Override
	public Book selectByPrimaryKey(Book b) {
		return iBookDao.selectByPrimaryKey(b);
	}

	@Override
	public int updateByPrimaryKeySelective(Book b) {
		return iBookDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(Book b) {
		return iBookDao.updateByPrimaryKey(b);
	}
	
	@Override
	public Object selectByKeyword(Book b){
		return iBookDao.selectByKeyword(b);		
	}

}
