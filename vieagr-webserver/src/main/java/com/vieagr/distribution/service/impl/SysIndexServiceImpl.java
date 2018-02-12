package com.vieagr.distribution.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vieagr.distribution.entity.SysIndex;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISysIndexService;

@Service
@Transactional
public class SysIndexServiceImpl extends BaseService<SysIndex> implements ISysIndexService {
}
