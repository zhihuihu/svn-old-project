package com.dy.weike.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dy.weike.entity.Ask;

/**
 * 问答db层
 * @author d-y
 *
 */
@Repository
public interface IAskDao extends IBaseDao<Ask> {
	/**
	 * 通过提出人查找
	 * @param b
	 * @return
	 */
	List<Ask> selectByAttributeByAskerId(Ask b);
}
