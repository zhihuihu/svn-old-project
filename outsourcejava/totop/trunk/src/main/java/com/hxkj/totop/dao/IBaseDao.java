package com.hxkj.totop.dao;

import com.hxkj.totop.entity.pojo.PageBean;

import java.util.List;

/**
 * Created by huzhihui on 2016/4/25.
 */
public interface IBaseDao<B> {
    int doInsert(B b) throws Exception;
    int doInsertSelective(B b) throws Exception;
    int doDeleteByPrimaryKey(B b) throws Exception;
    int doUpdateByPrimaryKeySelective(B b) throws Exception;
    int doUpdateByPrimaryKey(B b) throws Exception;
    B selectByPrimaryKey(B b) throws Exception;
    List<B> selectByAttribute(B b) throws Exception;
    List<B> selectByAttributeAnd(PageBean<B> pageBean) throws Exception;
    int selectByAttributeAndCount(PageBean<B> pageBean) throws Exception;
}
