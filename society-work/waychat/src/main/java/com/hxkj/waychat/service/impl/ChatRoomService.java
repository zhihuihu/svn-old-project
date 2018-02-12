package com.hxkj.waychat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.waychat.entity.ChatRoom;
import com.hxkj.waychat.service.BaseService;
import com.hxkj.waychat.service.inter.IChatRoomService;

@Service
@Transactional
public class ChatRoomService extends BaseService<ChatRoom> implements IChatRoomService {

}
