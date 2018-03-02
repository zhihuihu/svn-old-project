package com.vieagr.distribution.service.base;

import java.util.List;

/**
 * 基本service接口
 * @ClassName: IBaseService 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年10月15日 下午3:57:11
 */
public interface IBaseService<B> {

	int deleteByPrimaryKey(String cuid) throws Exception;

    int insert(B b) throws Exception;

    int insertSelective(B b) throws Exception;

    B selectByPrimaryKey(String cuid) throws Exception;

    int updateByPrimaryKeySelective(B b) throws Exception;

    int updateByPrimaryKey(B b) throws Exception;
    
    public List<B> selectByAttributeAnd(B b) throws Exception;
    
    public List<B> selectByAttributeOr(B b) throws Exception;
}
