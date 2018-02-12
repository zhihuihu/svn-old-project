package com.hxkj.photocms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.photocms.core.utils.CuidUtils;
import com.hxkj.photocms.core.utils.PageBeanUtils;
import com.hxkj.photocms.dao.ISpecialContentDao;
import com.hxkj.photocms.dao.ISpecialDao;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.entity.Special;
import com.hxkj.photocms.entity.SpecialContent;
import com.hxkj.photocms.service.inter.ISpecialContentService;

/** 
 * Project Name:photocms.server 
 * ClassName:SpecialContentService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 下午12:02:40 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class SpecialContentService implements ISpecialContentService {

	@Resource
	private ISpecialContentDao iSpecialContentDao;
	@Resource
	private ISpecialDao iSpecialDao;
	@Override
	public boolean doInsert(SpecialContent b) throws Exception {
		CuidUtils.setCuid(b, "专辑列表的内容添加");
		Special special = iSpecialDao.getById(b.getSpecialCuid());
		if(special.getSpecialMainImgUrl() == null || special.getSpecialMainImgUrl().equals("")){
			special.setSpecialMainImgUrl(b.getSpecialContentMainUrl());
		}
		special.setSpecialTotalNumber(1);
		iSpecialDao.doUpdateTotalNumber(special);
		return iSpecialContentDao.doInsert(b);
	}

	@Override
	public boolean doInsertList(List<SpecialContent> b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(SpecialContent b) throws Exception {
		return iSpecialContentDao.doUpdate(b);
	}

	@Override
	public boolean doDelete(SpecialContent b) throws Exception {
		b.setSpecialContentShow("2");
		Special special = new Special();
		special.setSpecialCuid(b.getSpecialCuid());
		special.setSpecialTotalNumber(-1);
		iSpecialDao.doUpdateTotalNumber(special);
		return iSpecialContentDao.doUpdate(b);
	}

	@Override
	public List<SpecialContent> getAll() throws Exception {
		return iSpecialContentDao.getAll();
	}

	@Override
	public SpecialContent getById(SpecialContent b) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SpecialContent> getAllByPage(PageBean<SpecialContent> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllByPageCount(PageBean<SpecialContent> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> getSpecialContentBySpecial(PageBean<SpecialContent> pageBean) throws Exception {
		List<SpecialContent> specialContents = iSpecialContentDao.getSpecialContentBySpecial(pageBean);
		int pageCount = iSpecialContentDao.getAllByPageCount(pageBean);
		pageCount = PageBeanUtils.getPageCount(pageCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(specialContents, pageBean.getRealCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public boolean doUpdateSpecialMainUrl(SpecialContent specialContent) throws Exception {
		Special special = new Special();
		special.setSpecialCuid(specialContent.getSpecialCuid());
		special.setSpecialMainImgUrl(specialContent.getSpecialContentMainUrl());
		return iSpecialDao.doUpdate(special);
	}

	@Override
	public boolean doUpdataList(List<SpecialContent> specialContents) throws Exception {
		boolean flg = false;
		for(int i=0; i<specialContents.size();i++){
			specialContents.get(i).setSpecialContentShow("2");
			Special special = new Special();
			special.setSpecialCuid(specialContents.get(i).getSpecialCuid());
			special.setSpecialTotalNumber(-1);
			iSpecialDao.doUpdateTotalNumber(special);
			flg = iSpecialContentDao.doUpdate(specialContents.get(i));
			if(flg == false){
				break;
			}
		}
		return flg;
	}

	@Override
	public int getAllByPageCountOr(PageBean<SpecialContent> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> getSpecialContentByAttributeAnd(PageBean<SpecialContent> pageBean) throws Exception {
		List<SpecialContent> specialContents = iSpecialContentDao.getSpecialContentByAttributeAnd(pageBean);
		int pageCount = iSpecialContentDao.getAllByPageCount(pageBean);
		pageCount = PageBeanUtils.getPageCount(pageCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(specialContents, pageBean.getRealCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public Map<String, Object> getSpecialContentByAttributeOr(PageBean<SpecialContent> pageBean) throws Exception {
		List<SpecialContent> specialContents = iSpecialContentDao.getSpecialContentByAttributeOr(pageBean);
		int pageCount = iSpecialContentDao.getAllByPageCountOr(pageBean);
		pageCount = PageBeanUtils.getPageCount(pageCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(specialContents, pageBean.getRealCurrentPage(), pageBean.getLineSize(), pageCount);
	}

}
