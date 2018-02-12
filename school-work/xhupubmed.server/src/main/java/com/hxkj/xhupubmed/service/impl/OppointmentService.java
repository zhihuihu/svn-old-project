package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IOppointmentDao;
import com.hxkj.xhupubmed.entity.Oppointment;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IOppointmentService;

/** 
 * ClassName:OppointmentService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午8:59:59 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class OppointmentService implements IOppointmentService {

	@Resource
	private IOppointmentDao iOppointmentDao;
	
	@Override
	public int doDeleteByPrimaryKey(Oppointment b) throws Exception {
		return iOppointmentDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Oppointment> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iOppointmentDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(Oppointment b) throws Exception {
		CuidUtils.setCuid(b, "用户约定表插入");
		return iOppointmentDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Oppointment> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "用户约定表插入", new Oppointment());
		for(int i=0;i<bs.size();i++){
			flg = iOppointmentDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(Oppointment b) throws Exception {
		CuidUtils.setCuid(b, "用户约定表插入");
		return iOppointmentDao.doInsertSelective(b);
	}

	@Override
	public Oppointment selectByPrimaryKey(Oppointment b) throws Exception {
		return iOppointmentDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Oppointment b) throws Exception {
		return iOppointmentDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Oppointment b) throws Exception {
		return iOppointmentDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Oppointment> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iOppointmentDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("更新数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Oppointment> pageBean) throws Exception {
		List<Oppointment> lists = iOppointmentDao.selectByAttributeAnd(pageBean);
		int lineCount = iOppointmentDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Oppointment> pageBean) throws Exception {
		return iOppointmentDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Oppointment> pageBean) throws Exception {
		List<Oppointment> lists = iOppointmentDao.selectByAttributeOr(pageBean);
		int lineCount = iOppointmentDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Oppointment> pageBean) throws Exception {
		return iOppointmentDao.selectByAttributeCountOr(pageBean);
	}

	@Override
	public List<Oppointment> selectByAttribute(Oppointment oppointment) throws Exception {
		return iOppointmentDao.selectByAttribute(oppointment);
	}

}
