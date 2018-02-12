package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.core.utils.PageBeanUtils;
import com.cqq.leisure.dao.IUserActiveCommentDao;
import com.cqq.leisure.dao.IUserDao;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.entity.UserActiveComment;
import com.cqq.leisure.service.inter.IUserActiveCommentService;
@Service
@Transactional
public class UserActiveCommentService implements IUserActiveCommentService {
	@Resource
	private IUserActiveCommentDao iUserActiveCommentDao;
	
	@Resource
	private IUserDao iUserDao;

	@Override
	public int doDeleteByPrimaryKey(UserActiveComment b) throws Exception {
		return iUserActiveCommentDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<UserActiveComment> bs)throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserActiveCommentDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(UserActiveComment b) throws Exception {
		return iUserActiveCommentDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<UserActiveComment> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserActiveCommentDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(UserActiveComment b) throws Exception {
		return iUserActiveCommentDao.doInsertSelective(b);
	}

	@Override
	public UserActiveComment selectByPrimaryKey(UserActiveComment b)throws Exception {
		return iUserActiveCommentDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(UserActiveComment b)throws Exception {
		return iUserActiveCommentDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(UserActiveComment b) throws Exception {
		return iUserActiveCommentDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<UserActiveComment> bs)throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iUserActiveCommentDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(
			PageBean<UserActiveComment> pageBean) throws Exception {
		int lineCount = iUserActiveCommentDao.selectByAttributeCountAnd(pageBean);
		List<UserActiveComment> list = iUserActiveCommentDao.selectByAttributeAnd(pageBean);
		for(int i=0;i<list.size();i++){
			User user = new User();
			user.setUserId(list.get(i).getUserActiveCommentUserId());
			user = iUserDao.selectByPrimaryKey(user);
			list.get(i).setUser(user);
		}
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<UserActiveComment> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(
			PageBean<UserActiveComment> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<UserActiveComment> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
