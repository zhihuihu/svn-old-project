package com.hxkj.photocms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.photocms.core.utils.CuidUtils;
import com.hxkj.photocms.dao.ISysUserDao;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.SysUser;
import com.hxkj.photocms.service.inter.ISysUserService;

/** 
 * Project Name:photocms.server 
 * ClassName:SysUserService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午10:15:46 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class SysUserService implements ISysUserService {

	@Resource
	private ISysUserDao iSysUserDao;
	
	@Override
	public boolean doInsert(SysUser b) throws Exception {
		CuidUtils.setCuid(b, "用户插入");
		return iSysUserDao.doInsert(b);
	}

	@Override
	public boolean doInsertList(List<SysUser> b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(SysUser b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(SysUser b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SysUser> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysUser getById(SysUser b) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysUser> getAllByPage(PageBean<SysUser> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllByPageCount(PageBean<SysUser> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysUser login(SysUser b) throws Exception {
		return iSysUserDao.login(b);
	}

	@Override
	public int getAllByPageCountOr(PageBean<SysUser> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
