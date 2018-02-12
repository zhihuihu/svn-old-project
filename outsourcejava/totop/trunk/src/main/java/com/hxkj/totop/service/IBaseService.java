package com.hxkj.totop.service;

import com.hxkj.totop.entity.pojo.PageBean;

import java.util.List;
import java.util.Map;

/**
 * Created by huzhihui on 2016/4/25.
 */
public interface IBaseService<B> {
    int doInsert(B b) throws Exception;
    int doInsertSelective(B b) throws Exception;
    int doDeleteByPrimaryKey(B b) throws Exception;
    int doUpdateByPrimaryKeySelective(B b) throws Exception;
    int doUpdateByPrimaryKey(B b) throws Exception;
    B selectByPrimaryKey(B b) throws Exception;
    List<B> selectByAttribute(B b) throws Exception;
    Map<String,Object> selectByAttributeAnd(PageBean<B> pageBean) throws Exception;
    int selectByAttributeAndCount(PageBean<B> pageBean) throws Exception;
}
