package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.ISchoolProfileDao;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SchoolProfile;
import com.hxkj.xhupubmed.service.inter.ISchoolProfileService;

/** 
 * ClassName:SchoolProfileService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午3:37:08 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class SchoolProfileService implements ISchoolProfileService {

	@Resource
	private ISchoolProfileDao iSchoolProfileDao;
	
	@Override
	public int doDeleteByPrimaryKey(SchoolProfile b) throws Exception {
		return iSchoolProfileDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<SchoolProfile> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsert(SchoolProfile b) throws Exception {
		CuidUtils.setCuid(b, "");
		return iSchoolProfileDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<SchoolProfile> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsertSelective(SchoolProfile b) throws Exception {
		CuidUtils.setCuid(b, "");
		return iSchoolProfileDao.doInsertSelective(b);
	}

	@Override
	public SchoolProfile selectByPrimaryKey(SchoolProfile b) throws Exception {
		return iSchoolProfileDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(SchoolProfile b) throws Exception {
		return iSchoolProfileDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(SchoolProfile b) throws Exception {
		return iSchoolProfileDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<SchoolProfile> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<SchoolProfile> pageBean) throws Exception {
		int lineCount = iSchoolProfileDao.selectByAttributeCountAnd(pageBean);
		List<SchoolProfile> list = iSchoolProfileDao.selectByAttributeAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<SchoolProfile> pageBean) throws Exception {
		return iSchoolProfileDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<SchoolProfile> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<SchoolProfile> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
