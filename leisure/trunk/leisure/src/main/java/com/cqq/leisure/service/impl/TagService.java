package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.dao.ITagDao;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.Tag;
import com.cqq.leisure.service.inter.ITagService;
@Service
@Transactional
public class TagService implements ITagService {
	@Resource
	private ITagDao iTagDao;
	@Override
	public int doDeleteByPrimaryKey(Tag b) throws Exception {
		return iTagDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Tag> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iTagDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(Tag b) throws Exception {
		return iTagDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Tag> bs) throws Exception {
		
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iTagDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(Tag b) throws Exception {
		return iTagDao.doInsertSelective(b);
	}

	@Override
	public Tag selectByPrimaryKey(Tag b) throws Exception {
		return iTagDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Tag b) throws Exception {
		return iTagDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Tag b) throws Exception {
		return iTagDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Tag> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iTagDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Tag> pageBean)throws Exception {
		int lineCount = iTagDao.selectByAttributeCountAnd(pageBean);
		List<Tag> list = iTagDao.selectByAttributeAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
		
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Tag> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Tag> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Tag> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Tag> selectAll(PageBean<Tag> pageBean) throws Exception {
		return iTagDao.selectAll(pageBean);
	}

}
