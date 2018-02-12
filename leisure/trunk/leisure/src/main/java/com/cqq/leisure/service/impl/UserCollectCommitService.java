package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.dao.IUserCollectCommitDao;
import com.cqq.leisure.dao.IUserDao;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.entity.UserCollectCommit;
import com.cqq.leisure.service.inter.IUserCollectCommitService;
@Service
@Transactional
public class UserCollectCommitService implements IUserCollectCommitService {
	@Resource
	private IUserCollectCommitDao iUserCollectCommitDao;
	
	@Resource
	private IUserDao iUserDao;

	@Override
	public int doDeleteByPrimaryKey(UserCollectCommit b) throws Exception {
		return iUserCollectCommitDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<UserCollectCommit> bs)throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserCollectCommitDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(UserCollectCommit b) throws Exception {
		return iUserCollectCommitDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<UserCollectCommit> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserCollectCommitDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(UserCollectCommit b) throws Exception {
		return iUserCollectCommitDao.doInsertSelective(b);
	}

	@Override
	public UserCollectCommit selectByPrimaryKey(UserCollectCommit b)throws Exception {
		return iUserCollectCommitDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(UserCollectCommit b)throws Exception {
		return iUserCollectCommitDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(UserCollectCommit b) throws Exception {
		return iUserCollectCommitDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<UserCollectCommit> bs)throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserCollectCommitDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(
			PageBean<UserCollectCommit> pageBean) throws Exception {
		int lineCount = iUserCollectCommitDao.selectByAttributeCountAnd(pageBean);
		List<UserCollectCommit> list = iUserCollectCommitDao.selectByAttributeAnd(pageBean);
		//将用户信息存储到这个评论当中去
		for(int i=0;i<list.size();i++){
			User user = new User();
			user.setUserId(list.get(i).getUserId());
			user = iUserDao.selectByPrimaryKey(user);
			list.get(i).setUser(user);
		}
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<UserCollectCommit> pageBean)
			throws Exception {
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(
			PageBean<UserCollectCommit> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<UserCollectCommit> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
