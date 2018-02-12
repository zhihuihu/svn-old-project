package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IKeyLogDao;
import com.hxkj.xhupubmed.entity.KeyLog;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IKeyLogService;

/** 
 * ClassName:KeyLogService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午7:11:37 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class KeyLogService implements IKeyLogService {

	@Resource
	private IKeyLogDao iKeyLogDao;
	
	@Override
	public int doDeleteByPrimaryKey(KeyLog b) throws Exception {
		return iKeyLogDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<KeyLog> bs) throws Exception {
		int flg = 0;
		for(int i = 0;i<bs.size();i++){
			flg = iKeyLogDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(KeyLog b) throws Exception {
		CuidUtils.setCuid(b, "关键日志记录表插入");
		return iKeyLogDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<KeyLog> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "关键日志记录表插入", new KeyLog());
		for(int i = 0;i<bs.size();i++){
			flg = iKeyLogDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(KeyLog b) throws Exception {
		CuidUtils.setCuid(b, "关键日志记录表插入");
		return iKeyLogDao.doInsertSelective(b);
	}

	@Override
	public KeyLog selectByPrimaryKey(KeyLog b) throws Exception {
		return iKeyLogDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(KeyLog b) throws Exception {
		return iKeyLogDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(KeyLog b) throws Exception {
		return iKeyLogDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<KeyLog> bs) throws Exception {
		int flg = 0;
		for(int i = 0;i<bs.size();i++){
			flg = iKeyLogDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("更新数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<KeyLog> pageBean) throws Exception {
		List<KeyLog> lists = iKeyLogDao.selectByAttributeAnd(pageBean);
		int lineCount = iKeyLogDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<KeyLog> pageBean) throws Exception {
		return iKeyLogDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<KeyLog> pageBean) throws Exception {
		List<KeyLog> lists = iKeyLogDao.selectByAttributeOr(pageBean);
		int lineCount = iKeyLogDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<KeyLog> pageBean) throws Exception {
		return iKeyLogDao.selectByAttributeCountOr(pageBean);
	}

}
