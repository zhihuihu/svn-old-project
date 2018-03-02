package com.vieagr.distribution.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vieagr.distribution.entity.SysFile;
import com.vieagr.distribution.service.base.BaseService;
import com.vieagr.distribution.service.inter.ISysFileService;

@Service
@Transactional
public class SysFileServiceImpl extends BaseService<SysFile>implements ISysFileService{

}
