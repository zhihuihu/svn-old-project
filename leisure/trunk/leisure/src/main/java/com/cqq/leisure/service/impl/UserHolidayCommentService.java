package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.dao.IUserActiveCommentDao;
import com.cqq.leisure.dao.IUserHolidayCommentDao;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.UserActiveComment;
import com.cqq.leisure.entity.UserHolidayComment;
import com.cqq.leisure.service.inter.IUserHolidayCommentService;
@Service
@Transactional
public class UserHolidayCommentService implements IUserHolidayCommentService {
	
	@Resource
	private IUserHolidayCommentDao iUserHolidayCommentDao;

	@Override
	public int doDeleteByPrimaryKey(UserHolidayComment b) throws Exception {
		return iUserHolidayCommentDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<UserHolidayComment> bs)throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserHolidayCommentDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(UserHolidayComment b) throws Exception {
		return iUserHolidayCommentDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<UserHolidayComment> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserHolidayCommentDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(UserHolidayComment b) throws Exception {
		return iUserHolidayCommentDao.doInsertSelective(b);
	}

	@Override
	public UserHolidayComment selectByPrimaryKey(UserHolidayComment b)throws Exception {
		return iUserHolidayCommentDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(UserHolidayComment b)throws Exception {
		return iUserHolidayCommentDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(UserHolidayComment b) throws Exception {
		return iUserHolidayCommentDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<UserHolidayComment> bs)throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserHolidayCommentDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(
			PageBean<UserHolidayComment> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<UserHolidayComment> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(
			PageBean<UserHolidayComment> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<UserHolidayComment> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
