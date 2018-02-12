package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.dao.IUserDao;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.entity.User;
import com.cqq.leisure.service.inter.IUserService;

@Service
@Transactional
public class UserService implements IUserService {

	@Resource
	private IUserDao iUserDao;
	
	@Override
	public int doDeleteByPrimaryKey(User b) throws Exception {
		return iUserDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<User> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iUserDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("传入数据出错，删除失败");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(User b) throws Exception {
		return iUserDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<User> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iUserDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("传入数据出错，增加数据失败");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(User b) throws Exception {
		return iUserDao.doInsertSelective(b);
	}

	@Override
	public User selectByPrimaryKey(User b) throws Exception {
		return iUserDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(User b) throws Exception {
		return iUserDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(User b) throws Exception {
		return iUserDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<User> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iUserDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("传入数据出错，更新数据失败");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<User> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<User> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<User> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<User> pageBean)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByAttribute(User user) throws Exception {
		return iUserDao.selectByAttribute(user);
	}

	@Override
	public List<User> selectAll(PageBean<User> pageBean) throws Exception {
		return iUserDao.selectAll(pageBean);
	}
	

}
