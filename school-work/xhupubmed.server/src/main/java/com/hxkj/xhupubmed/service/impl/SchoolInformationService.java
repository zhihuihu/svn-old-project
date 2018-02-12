package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.ISchoolInformationDao;
import com.hxkj.xhupubmed.dao.ISchoolProfileDao;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SchoolInformation;
import com.hxkj.xhupubmed.entity.SchoolProfile;
import com.hxkj.xhupubmed.service.inter.ISchoolInformationService;

/** 
 * ClassName:SchoolInformationService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午3:26:00 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class SchoolInformationService implements ISchoolInformationService {

	@Resource
	private ISchoolInformationDao iSchoolInformationDao;
	@Resource
	private ISchoolProfileDao iSchoolProfileDao;
	
	@Override
	public int doDeleteByPrimaryKey(SchoolInformation b) throws Exception {
		return iSchoolInformationDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<SchoolInformation> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsert(SchoolInformation b) throws Exception {
		CuidUtils.setCuid(b, "");
		return iSchoolInformationDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<SchoolInformation> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsertSelective(SchoolInformation b) throws Exception {
		CuidUtils.setCuid(b, "");
		return iSchoolInformationDao.doInsertSelective(b);
	}

	@Override
	public SchoolInformation selectByPrimaryKey(SchoolInformation b) throws Exception {
		b= iSchoolInformationDao.selectByPrimaryKey(b);
		SchoolProfile schoolProfile = new SchoolProfile();
		schoolProfile.setSchoolProfileCuid(b.getSchoolProfileCuid());
		schoolProfile = iSchoolProfileDao.selectByPrimaryKey(schoolProfile);
		b.setSchoolProfile(schoolProfile);
		return b;
	}

	@Override
	public int doUpdateByPrimaryKeySelective(SchoolInformation b) throws Exception {
		return iSchoolInformationDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(SchoolInformation b) throws Exception {
		return iSchoolInformationDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<SchoolInformation> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<SchoolInformation> pageBean) throws Exception {
		int lineCount = iSchoolInformationDao.selectByAttributeCountAnd(pageBean);
		List<SchoolInformation> list = iSchoolInformationDao.selectByAttributeAnd(pageBean);
		for(int i=0;i<list.size();i++){
			SchoolProfile schoolProfile = new SchoolProfile();
			schoolProfile.setSchoolProfileCuid(list.get(i).getSchoolProfileCuid());
			schoolProfile = iSchoolProfileDao.selectByPrimaryKey(schoolProfile);
			list.get(i).setSchoolProfile(schoolProfile);
		}
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<SchoolInformation> pageBean) throws Exception {
		return iSchoolInformationDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<SchoolInformation> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<SchoolInformation> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
