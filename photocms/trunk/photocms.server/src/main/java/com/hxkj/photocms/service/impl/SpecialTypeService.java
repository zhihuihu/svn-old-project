package com.hxkj.photocms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.photocms.core.utils.CuidUtils;
import com.hxkj.photocms.core.utils.PageBeanUtils;
import com.hxkj.photocms.dao.IDataTypeDao;
import com.hxkj.photocms.dao.ISpecialTypeDao;
import com.hxkj.photocms.entity.DataType;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.SpecialType;
import com.hxkj.photocms.service.inter.ISpecialTypeService;

/** 
 * Project Name:photocms.server 
 * ClassName:SpecialTypeService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午11:05:17 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class SpecialTypeService implements ISpecialTypeService {

	@Resource
	private ISpecialTypeDao iSpecialTypeDao;
	@Resource
	private IDataTypeDao iDataTypeDao;
	@Override
	public boolean doInsert(SpecialType b) throws Exception {
		CuidUtils.setCuid(b, "专辑类型大标签");
		DataType dataType = iDataTypeDao.getById(b.getDataTypeCuid());
		dataType.setDataTypeTotalNumber(dataType.getDataTypeTotalNumber()+1);
		iDataTypeDao.doUpdate(dataType);
		return iSpecialTypeDao.doInsert(b);
	}

	@Override
	public boolean doInsertList(List<SpecialType> b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(SpecialType b) throws Exception {
		return iSpecialTypeDao.doUpdate(b);
	}

	@Override
	public boolean doDelete(SpecialType b) throws Exception {
		b.setSpecialTypeShow("2");
		return iSpecialTypeDao.doUpdate(b);
	}

	@Override
	public List<SpecialType> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpecialType getById(SpecialType b) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpecialType> getAllByPage(PageBean<SpecialType> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllByPageCount(PageBean<SpecialType> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> getSpecialTypeByDataTypeCuid(PageBean<SpecialType> pageBean) throws Exception {
		List<SpecialType> specialTypes = iSpecialTypeDao.getSpecialTypeByDataTypeCuid(pageBean);
		int pageCount = iSpecialTypeDao.getAllByPageCount(pageBean);
		pageCount = PageBeanUtils.getPageCount(pageCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(specialTypes, pageBean.getRealCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int getAllByPageCountOr(PageBean<SpecialType> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> getSpecialTypeByAttributeAnd(PageBean<SpecialType> pageBean) throws Exception {
		List<SpecialType> specialTypes = iSpecialTypeDao.getSpecialTypeByAttributeAnd(pageBean);
		int pageCount = iSpecialTypeDao.getAllByPageCount(pageBean);
		pageCount = PageBeanUtils.getPageCount(pageCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(specialTypes, pageBean.getRealCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public Map<String, Object> getSpecialTypeByAttributeOr(PageBean<SpecialType> pageBean) throws Exception {
		List<SpecialType> specialTypes = iSpecialTypeDao.getSpecialTypeByAttributeOr(pageBean);
		int pageCount = iSpecialTypeDao.getAllByPageCountOr(pageBean);
		pageCount = PageBeanUtils.getPageCount(pageCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(specialTypes, pageBean.getRealCurrentPage(), pageBean.getLineSize(), pageCount);
	}

}
