package com.deng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deng.config.DataTeast;
import com.deng.mapper.UserInfoMapper;
import com.deng.model.UserInfo;
import com.deng.service.Test1Service;

@Component
public class Test1ServiceImpl implements Test1Service {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @DataTeast(data="1")
    public List<UserInfo> selectUserInfo() {
    	return userInfoMapper.selectAll();
    	//return null;
    }
}