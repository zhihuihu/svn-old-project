package com.cqq.leisure.service.inter;

import java.util.List;

import com.cqq.leisure.entity.UserTag;
import com.cqq.leisure.service.IBaseService;

public interface IUserTagService extends IBaseService<UserTag> {

	public List<UserTag> selectByAttributeList(UserTag usertag)throws Exception;
}
