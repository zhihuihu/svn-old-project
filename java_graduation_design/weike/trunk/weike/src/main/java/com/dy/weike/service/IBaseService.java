package com.dy.weike.service;

public interface IBaseService<B> {

	/**
	 * 通过主键删除
	 * @param b
	 * @return
	 */
	int deleteByPrimaryKey(B b);
	
	/**
	 * 插入一条数据 
	 * @param b
	 * @return
	 */
	int insert(B b);
	
	/**
	 * 插入一条数据  为空的不进行插入
	 * @param b
	 * @return
	 */
	int insertSelective(B b);
	
	/**
	 * 通过逐渐查找该数据
	 * @param b
	 * @return
	 */
	B selectByPrimaryKey(B b);
	
	/**
	 * 通过主键更新数据，为空的不进行更新
	 * @param b
	 * @return
	 */
	int updateByPrimaryKeySelective(B b);
	
	/**
	 * 通过主键进行更新，为空的也更新为null
	 * @param b
	 * @return
	 */
	int updateByPrimaryKey(B b);
}
