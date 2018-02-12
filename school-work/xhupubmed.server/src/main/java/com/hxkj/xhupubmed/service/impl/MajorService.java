package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IMajorDao;
import com.hxkj.xhupubmed.entity.Major;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IMajorService;

/** 
 * ClassName:MajorService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午8:17:56 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class MajorService implements IMajorService {

	@Resource
	private IMajorDao iMajorDao;
	
	@Override
	public int doDeleteByPrimaryKey(Major b) throws Exception {
		return iMajorDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Major> bs) throws Exception {
		int flg = 0;
		for(int i =0;i<bs.size();i++){
			flg = iMajorDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(Major b) throws Exception {
		CuidUtils.setCuid(b, "专业表插入");
		return iMajorDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Major> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "专业表插入", new Major());
		for(int i =0;i<bs.size();i++){
			flg = iMajorDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(Major b) throws Exception {
		CuidUtils.setCuid(b, "专业表插入");
		return iMajorDao.doInsertSelective(b);
	}

	@Override
	public Major selectByPrimaryKey(Major b) throws Exception {
		return iMajorDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Major b) throws Exception {
		return iMajorDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Major b) throws Exception {
		return iMajorDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Major> bs) throws Exception {
		int flg = 0;
		for(int i =0;i<bs.size();i++){
			flg = iMajorDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("更新数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Major> pageBean) throws Exception {
		List<Major> lists = iMajorDao.selectByAttributeAnd(pageBean);
		int lineCount = iMajorDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Major> pageBean) throws Exception {
		return iMajorDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Major> pageBean) throws Exception {
		List<Major> lists = iMajorDao.selectByAttributeOr(pageBean);
		int lineCount = iMajorDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Major> pageBean) throws Exception {
		return iMajorDao.selectByAttributeCountOr(pageBean);
	}

}
