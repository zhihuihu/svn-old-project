package com.hxtec.hxtecblog.dubboprovider.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxtec.hxtecblog.api.service.IUserService;

/*@Service("userService")*/
@com.alibaba.dubbo.config.annotation.Service(version="1.0.0")
/*@Transactional*/
public class UserService implements IUserService{

	@Override
	public String sayWelcome(String userName) {
		return "welcome "+userName+" to hxtecblog";
	}

}
