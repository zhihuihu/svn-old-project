package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.dao.ITagDao;
import com.cqq.leisure.dao.IUserTagDao;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.Tag;
import com.cqq.leisure.entity.UserTag;
import com.cqq.leisure.service.inter.IUserTagService;
@Service
@Transactional
public class UserTagService implements IUserTagService {
	@Resource
	private IUserTagDao iUserTagDao;
	@Resource
	private ITagDao iTagDao;

	@Override
	public int doDeleteByPrimaryKey(UserTag b) throws Exception {
		return iUserTagDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<UserTag> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserTagDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(UserTag b) throws Exception {
		return iUserTagDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<UserTag> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserTagDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(UserTag b) throws Exception {
		return iUserTagDao.doInsertSelective(b);
	}

	@Override
	public UserTag selectByPrimaryKey(UserTag b) throws Exception {
		return iUserTagDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(UserTag b) throws Exception {
		return iUserTagDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(UserTag b) throws Exception {
		return iUserTagDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<UserTag> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserTagDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<UserTag> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<UserTag> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<UserTag> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<UserTag> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserTag> selectByAttributeList(UserTag userTag) throws Exception {
		List<UserTag> list = iUserTagDao.selectByAttributeList(userTag);
		if(list != null && list.size() != 0){
			for(int i=0;i<list.size();i++){
				Tag tag = new Tag();
				tag.setTagId(list.get(i).getTagId());
				tag = iTagDao.selectByPrimaryKey(tag);
				list.get(i).setTag(tag);
			}
		}
		
		return iUserTagDao.selectByAttributeList(userTag);
	}

}
