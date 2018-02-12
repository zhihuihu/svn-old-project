package com.cqq.leisure.dao;

import java.util.List;

import com.cqq.leisure.entity.UserTag;

public interface IUserTagDao extends IBaseDao<UserTag> {

	public List<UserTag> selectByAttributeList(UserTag usertag)throws Exception;
}
