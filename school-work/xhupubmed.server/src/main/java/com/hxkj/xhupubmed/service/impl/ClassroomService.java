package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IClassroomDao;
import com.hxkj.xhupubmed.dao.IOppointmentDao;
import com.hxkj.xhupubmed.entity.Classroom;
import com.hxkj.xhupubmed.entity.Oppointment;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IClassroomService;

/** 
 * ClassName:ClassroomService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午5:36:24 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class ClassroomService implements IClassroomService {

	@Resource
	private IClassroomDao iClassroomDao;
	@Resource
	private IOppointmentDao iOppointmentDao;
	
	@Override
	public int doDeleteByPrimaryKey(Classroom b) throws Exception {
		return iClassroomDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Classroom> bs) throws Exception {
		int flg = 0;
		for(int i =0;i<bs.size();i++){
			flg = iClassroomDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请确定传入数据正确！");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(Classroom b) throws Exception {
		CuidUtils.setCuid(b, "教室表插入！");
		return iClassroomDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Classroom> bs) throws Exception {
		CuidUtils.setCuidList(bs, "教室表插入！", new Classroom());
		int flg = 0;
		for(int i =0;i<bs.size();i++){
			flg = iClassroomDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请确定传入数据正确！");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(Classroom b) throws Exception {
		CuidUtils.setCuid(b, "教室表插入！");
		return iClassroomDao.doInsertSelective(b);
	}

	@Override
	public Classroom selectByPrimaryKey(Classroom b) throws Exception {
		Classroom classroom = iClassroomDao.selectByPrimaryKey(b);
		if(classroom != null){
			Oppointment oppointment = new Oppointment();
			oppointment.setClassroomCuid(b.getClassroomCuid());
			List<Oppointment> oppointments = iOppointmentDao.selectByAttribute(oppointment);
			classroom.setOppointments(oppointments);
		}
		return classroom;
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Classroom b) throws Exception {
		return iClassroomDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Classroom b) throws Exception {
		return iClassroomDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Classroom> bs) throws Exception {
		int flg = 0;
		for(int i =0;i<bs.size();i++){
			flg = iClassroomDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("修改数据出错，请确定传入数据正确！");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Classroom> pageBean) throws Exception {
		List<Classroom> lists = iClassroomDao.selectByAttributeAnd(pageBean);
		int lineCount = iClassroomDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Classroom> pageBean) throws Exception {
		return iClassroomDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Classroom> pageBean) throws Exception {
		List<Classroom> lists = iClassroomDao.selectByAttributeOr(pageBean);
		int lineCount = iClassroomDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Classroom> pageBean) throws Exception {
		return iClassroomDao.selectByAttributeCountOr(pageBean);
	}

}
