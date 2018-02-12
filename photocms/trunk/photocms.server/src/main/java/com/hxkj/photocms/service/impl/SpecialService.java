package com.hxkj.photocms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.photocms.core.utils.CuidUtils;
import com.hxkj.photocms.core.utils.PageBeanUtils;
import com.hxkj.photocms.dao.ISpecialDao;
import com.hxkj.photocms.dao.ISpecialTypeDao;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.Special;
import com.hxkj.photocms.entity.SpecialType;
import com.hxkj.photocms.service.inter.ISpecialService;

/** 
 * Project Name:photocms.server 
 * ClassName:SpecialService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午11:36:43 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class SpecialService implements ISpecialService {

	@Resource
	private ISpecialDao iSpecialDao;
	@Resource
	private ISpecialTypeDao iSpecialTypeDao;
	@Override
	public boolean doInsert(Special b) throws Exception {
		CuidUtils.setCuid(b, "专辑添加");
		SpecialType specialType = new SpecialType();
		specialType.setSpecialTypeCuid(b.getSpecialTypeCuid());
		specialType.setSpecialTypeTotalNumber(1);
		iSpecialTypeDao.doUpdateToTalNumber(specialType);
		return iSpecialDao.doInsert(b);
	}

	@Override
	public boolean doInsertList(List<Special> b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Special b) throws Exception {
		return iSpecialDao.doUpdate(b);
	}

	@Override
	public boolean doDelete(Special b) throws Exception {
		b.setSpecialShow("2");
		iSpecialDao.doUpdate(b);
		return false;
	}

	@Override
	public List<Special> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Special getById(Special b) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Special> getAllByPage(PageBean<Special> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllByPageCount(PageBean<Special> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> getSpecialBySpecialType(PageBean<Special> pageBean) throws Exception {
		List<Special> specials = iSpecialDao.getSpecialBySpecialType(pageBean);
		int pageCount = iSpecialDao.getAllByPageCount(pageBean);
		pageCount = PageBeanUtils.getPageCount(pageCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(specials, pageBean.getRealCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int getAllByPageCountOr(PageBean<Special> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> getSpecialByAttributeAnd(PageBean<Special> pageBean) throws Exception {
		List<Special> specials = iSpecialDao.getSpecialByAttributeAnd(pageBean);
		int pageCount = iSpecialDao.getAllByPageCount(pageBean);
		pageCount = PageBeanUtils.getPageCount(pageCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(specials, pageBean.getRealCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public Map<String, Object> getSpecialByAttributeOr(PageBean<Special> pageBean) throws Exception {
		List<Special> specials = iSpecialDao.getSpecialByAttributeOr(pageBean);
		int pageCount = iSpecialDao.getAllByPageCountOr(pageBean);
		pageCount = PageBeanUtils.getPageCount(pageCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(specials, pageBean.getRealCurrentPage(), pageBean.getLineSize(), pageCount);
	}

}
