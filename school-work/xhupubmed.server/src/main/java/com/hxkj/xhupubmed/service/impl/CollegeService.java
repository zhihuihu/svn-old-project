package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.ICollegeDao;
import com.hxkj.xhupubmed.entity.College;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.ICollegeService;

/** 
 * ClassName:CollegeService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午9:06:32 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class CollegeService implements ICollegeService {

	@Resource
	private ICollegeDao iCollegeDao;
	
	@Override
	public int doDeleteByPrimaryKey(College b) throws Exception {
		return iCollegeDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<College> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iCollegeDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据！");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(College b) throws Exception {
		CuidUtils.setCuid(b, "学院表增加！");
		return iCollegeDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<College> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "学院表增加！", new College());
		for(int i=0;i<bs.size();i++){
			flg = iCollegeDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据！");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(College b) throws Exception {
		return iCollegeDao.doInsertSelective(b);
	}

	@Override
	public College selectByPrimaryKey(College b) throws Exception {
		return iCollegeDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(College b) throws Exception {
		return iCollegeDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(College b) throws Exception {
		return iCollegeDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<College> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iCollegeDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("修改数据出错，请检查输入数据！");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<College> pageBean) throws Exception {
		List<College> lists = iCollegeDao.selectByAttributeAnd(pageBean);
		int lineCount = iCollegeDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<College> pageBean) throws Exception {
		return iCollegeDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<College> pageBean) throws Exception {
		List<College> lists = iCollegeDao.selectByAttributeOr(pageBean);
		int lineCount = iCollegeDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<College> pageBean) throws Exception {
		return iCollegeDao.selectByAttributeCountOr(pageBean);
	}

}
