package com.deng.service;

import com.deng.model.UserDetail;

import java.util.List;

public interface Test2Service {
	//@DataTeast(data="2")
    List<UserDetail> selectUserDetail();
}
