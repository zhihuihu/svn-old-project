package com.hxkj.waychat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.waychat.entity.Friend;
import com.hxkj.waychat.service.BaseService;
import com.hxkj.waychat.service.inter.IFriendService;

@Service
@Transactional
public class FriendService extends BaseService<Friend> implements IFriendService {

}
