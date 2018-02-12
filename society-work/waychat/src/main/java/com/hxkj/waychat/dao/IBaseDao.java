package com.hxkj.waychat.dao;

import java.util.List;

import com.hxkj.waychat.entity.query.PageBean;

public interface IBaseDao<B> {

	public int deleteByPrimaryKey(String cuid) throws Exception;
	
	public int insert(B b) throws Exception;
	
	public int insertSelective(B b) throws Exception;
	
	public B selectByPrimaryKey(String cuid) throws Exception;
	
	public int updateByPrimaryKeySelective(B b) throws Exception;
	
	public int updateByPrimaryKey(B b) throws Exception;
	
	public List<B> selectByAttribute(B b) throws Exception;
	
	public List<B> selectByPageAnd(PageBean<B> pageBean) throws Exception;
	
	public int selectByPageAndCount(PageBean<B> pageBean) throws Exception;
}
