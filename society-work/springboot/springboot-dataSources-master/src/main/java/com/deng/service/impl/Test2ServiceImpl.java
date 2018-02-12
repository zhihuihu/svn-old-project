package com.deng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.deng.config.DataTeast;
import com.deng.mapper.UserDetailMapper;
import com.deng.model.UserDetail;
import com.deng.service.Test2Service;

@Component
public class Test2ServiceImpl implements Test2Service {

    @Autowired
    private UserDetailMapper userDetailMapper;

    @DataTeast(data="2")
    public List<UserDetail> selectUserDetail() {
       return userDetailMapper.selectAll();
    }
}
