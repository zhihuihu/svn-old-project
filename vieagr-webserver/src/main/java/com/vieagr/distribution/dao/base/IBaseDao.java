package com.vieagr.distribution.dao.base;

import java.util.List;

/**
 * 基础DAO层
 * @ClassName: IBaseDao 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年10月15日 下午3:55:59
 */
public interface IBaseDao<B> {

	int deleteByPrimaryKey(String cuid) throws Exception;

    int insert(B b) throws Exception;

    int insertSelective(B b) throws Exception;

    B selectByPrimaryKey(String cuid) throws Exception;

    int updateByPrimaryKeySelective(B b) throws Exception;

    int updateByPrimaryKey(B b) throws Exception;
    
    //自己增加接口需要去实现Mapper.xml层
    
    public List<B> selectByAttributeAnd(B b) throws Exception;
    
    public List<B> selectByAttributeOr(B b) throws Exception;
}
