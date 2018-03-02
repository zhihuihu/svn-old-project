package com.vieagr.distribution.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.vieagr.distribution.dao.base.IBaseDao;

/**
 * 基本service接口实现
 * @ClassName: BaseService 
 * @Description: 
 * @author huzhihui_c@qq.com
 * @date 2016年10月15日 下午3:57:52
 */
@Transactional
public abstract class BaseService<B> implements IBaseService<B> {

	@Autowired
	private IBaseDao<B> ibaseDao;

	@Override
	public int deleteByPrimaryKey(String cuid) throws Exception {
		if(StringUtils.isEmpty(cuid)){
			throw new RuntimeException("删除操作时主键为空");
		}
		return ibaseDao.deleteByPrimaryKey(cuid);
	}

	@Override
	public int insert(B b) throws Exception {
		return ibaseDao.insert(b);
	}

	@Override
	public int insertSelective(B b) throws Exception {
		return ibaseDao.insertSelective(b);
	}

	@Override
	public B selectByPrimaryKey(String cuid) throws Exception {
		return ibaseDao.selectByPrimaryKey(cuid);
	}

	@Override
	public int updateByPrimaryKeySelective(B b) throws Exception {
		return ibaseDao.updateByPrimaryKeySelective(b);
	}

	@Override
	public int updateByPrimaryKey(B b) throws Exception {
		return ibaseDao.updateByPrimaryKey(b);
	}

	@Override
	public List<B> selectByAttributeAnd(B b) throws Exception {
		return ibaseDao.selectByAttributeAnd(b);
	}

	@Override
	public List<B> selectByAttributeOr(B b) throws Exception {
		return ibaseDao.selectByAttributeOr(b);
	}
	
}
