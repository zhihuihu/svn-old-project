package com.hxkj.waychat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.waychat.entity.ChatHistory;
import com.hxkj.waychat.service.BaseService;
import com.hxkj.waychat.service.inter.IChatHistoryService;

@Service
@Transactional
public class ChatHistoryService extends BaseService<ChatHistory> implements IChatHistoryService {

}
