package com.deng.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.deng.model.UserInfo;

@Mapper
public interface UserInfoMapper {
    List<UserInfo> selectAll();
}