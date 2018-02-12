package com.hxkj.waychat.service;

import java.util.List;
import java.util.Map;

import com.hxkj.waychat.entity.query.PageBean;

public interface IBaseService<B> {

	public int deleteByPrimaryKey(String cuid) throws Exception;
	
	public int insert(B b) throws Exception;
	
	public int insertSelective(B b) throws Exception;
	
	public B selectByPrimaryKey(String cuid) throws Exception;
	
	public int updateByPrimaryKeySelective(B b) throws Exception;
	
	public int updateByPrimaryKey(B b) throws Exception;
	
	public List<B> selectByAttribute(B b) throws Exception;
	
	public Map<String,Object> selectByPageAnd(PageBean<B> pageBean) throws Exception;
	
	public int selectByPageAndCount(PageBean<B> pageBean) throws Exception;
}
