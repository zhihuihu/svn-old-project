package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IImagesDao;
import com.hxkj.xhupubmed.entity.Images;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IImagesService;

/** 
 * ClassName:ImagesService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午4:27:59 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class ImagesService implements IImagesService {

	@Resource
	private IImagesDao iImagesDao;
	
	@Override
	public int doDeleteByPrimaryKey(Images b) throws Exception {
		return iImagesDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Images> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iImagesDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(Images b) throws Exception {
		CuidUtils.setCuid(b, "图片表插入");
		return iImagesDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Images> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "图片表插入", new Images());
		for(int i=0;i<bs.size();i++){
			flg = iImagesDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(Images b) throws Exception {
		CuidUtils.setCuid(b, "图片表插入");
		return iImagesDao.doInsertSelective(b);
	}

	@Override
	public Images selectByPrimaryKey(Images b) throws Exception {
		return iImagesDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Images b) throws Exception {
		return iImagesDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Images b) throws Exception {
		return iImagesDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Images> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iImagesDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("修改数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Images> pageBean) throws Exception {
		List<Images> lists = iImagesDao.selectByAttributeAnd(pageBean);
		int lineCount = iImagesDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Images> pageBean) throws Exception {
		return iImagesDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Images> pageBean) throws Exception {
		List<Images> lists = iImagesDao.selectByAttributeOr(pageBean);
		int lineCount = iImagesDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Images> pageBean) throws Exception {
		return iImagesDao.selectByAttributeCountOr(pageBean);
	}

}
