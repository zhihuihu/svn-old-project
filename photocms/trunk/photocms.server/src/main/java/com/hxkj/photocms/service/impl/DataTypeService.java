package com.hxkj.photocms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.photocms.core.utils.CuidUtils;
import com.hxkj.photocms.core.utils.PageBeanUtils;
import com.hxkj.photocms.dao.IDataTypeDao;
import com.hxkj.photocms.entity.DataType;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.service.inter.IDataTypeService;

/** 
 * Project Name:photocms.server 
 * ClassName:DataTypeService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午10:41:27 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class DataTypeService implements IDataTypeService {

	@Resource
	private IDataTypeDao iDataTypeDao;
	
	@Override
	public boolean doInsert(DataType b) throws Exception {
		CuidUtils.setCuid(b, "数据类型表插入");
		return iDataTypeDao.doInsert(b);
	}

	@Override
	public boolean doInsertList(List<DataType> b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(DataType b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(DataType b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<DataType> getAll() throws Exception {
		return iDataTypeDao.getAll();
	}

	@Override
	public DataType getById(DataType b) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DataType> getAllByPage(PageBean<DataType> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllByPageCount(PageBean<DataType> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> findByDataType(DataType dataType) throws Exception {
		DataType dataTypeOut = iDataTypeDao.findByDataType(dataType);
		Map<String, Object> map = PageBeanUtils.formatForNormalTrue("",dataTypeOut);
		return map;
	}

	@Override
	public int getAllByPageCountOr(PageBean<DataType> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
