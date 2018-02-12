package com.hxkj.waychat.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.waychat.entity.RoomPeople;
import com.hxkj.waychat.service.BaseService;
import com.hxkj.waychat.service.inter.IRoomPeopleService;

@Service
@Transactional
public class RoomPeopleService extends BaseService<RoomPeople> implements IRoomPeopleService {

}
