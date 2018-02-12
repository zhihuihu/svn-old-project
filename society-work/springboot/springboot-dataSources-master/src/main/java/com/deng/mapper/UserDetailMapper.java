package com.deng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.deng.model.UserDetail;

@Mapper
public interface UserDetailMapper  {
	List<UserDetail> selectAll();
}