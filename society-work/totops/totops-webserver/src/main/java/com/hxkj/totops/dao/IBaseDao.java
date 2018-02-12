package com.hxkj.totops.dao;

import java.util.List;

import com.hxkj.totops.entity.query.PageBean;

public interface IBaseDao<B> {
	int deleteByPrimaryKey(String cuid) throws Exception;

    int insert(B b) throws Exception;

    int insertSelective(B b) throws Exception;

    B selectByPrimaryKey(String cuid) throws Exception;

    int updateByPrimaryKeySelective(B b) throws Exception;

    int updateByPrimaryKey(B b) throws Exception;
    
    public List<B> selectByAttribute(B b) throws Exception;
	
	public List<B> selectByPageAnd(PageBean<B> pageBean) throws Exception;
	
	public int selectByPageAndCount(PageBean<B> pageBean) throws Exception;
}
