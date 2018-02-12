package com.hxkj.photocms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.photocms.core.utils.CuidUtils;
import com.hxkj.photocms.dao.IUserTypeDao;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.UserType;
import com.hxkj.photocms.service.inter.IUserTypeService;

/** 
 * Project Name:photocms.server 
 * ClassName:UserTypeService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午9:16:01 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class UserTypeService implements IUserTypeService {

	@Resource
	private IUserTypeDao iUserTypeDao;
	@Override
	public boolean doInsert(UserType b) throws Exception {
		CuidUtils.setCuid(b, "用户类型表插入");
		return iUserTypeDao.doInsert(b);
	}

	@Override
	public boolean doInsertList(List<UserType> b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(UserType b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(UserType b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<UserType> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserType getById(UserType b) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserType> getAllByPage(PageBean<UserType> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllByPageCount(PageBean<UserType> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllByPageCountOr(PageBean<UserType> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
