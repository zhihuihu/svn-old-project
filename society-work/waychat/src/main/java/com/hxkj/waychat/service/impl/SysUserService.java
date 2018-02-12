package com.hxkj.waychat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.waychat.entity.SysUser;
import com.hxkj.waychat.service.BaseService;
import com.hxkj.waychat.service.inter.ISysUserService;

@Service
@Transactional
public class SysUserService extends BaseService<SysUser> implements ISysUserService {

}
