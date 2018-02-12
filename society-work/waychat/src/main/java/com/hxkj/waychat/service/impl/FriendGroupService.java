package com.hxkj.waychat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.waychat.entity.FriendGroup;
import com.hxkj.waychat.service.BaseService;
import com.hxkj.waychat.service.inter.IFriendGroupService;

@Service
@Transactional
public class FriendGroupService extends BaseService<FriendGroup> implements IFriendGroupService {

}
