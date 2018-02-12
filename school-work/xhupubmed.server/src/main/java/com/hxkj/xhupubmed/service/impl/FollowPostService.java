package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IFollowPostDao;
import com.hxkj.xhupubmed.entity.FollowPost;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IFollowPostService;

/** 
 * ClassName:FollowPostService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午3:12:34 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class FollowPostService implements IFollowPostService {

	@Resource
	private IFollowPostDao iFollowPostDao;
	
	@Override
	public int doDeleteByPrimaryKey(FollowPost b) throws Exception {
		return iFollowPostDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<FollowPost> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iFollowPostDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg==0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(FollowPost b) throws Exception {
		CuidUtils.setCuid(b, "用户关注列表");
		return iFollowPostDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<FollowPost> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "用户关注列表", new FollowPost());
		for(int i=0;i<bs.size();i++){
			flg = iFollowPostDao.doInsert(bs.get(i));
			if(flg==0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(FollowPost b) throws Exception {
		CuidUtils.setCuid(b, "用户关注列表");
		return iFollowPostDao.doInsertSelective(b);
	}

	@Override
	public FollowPost selectByPrimaryKey(FollowPost b) throws Exception {
		return iFollowPostDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(FollowPost b) throws Exception {
		return iFollowPostDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(FollowPost b) throws Exception {
		return iFollowPostDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<FollowPost> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iFollowPostDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg==0){
				throw new RuntimeException("更新数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<FollowPost> pageBean) throws Exception {
		List<FollowPost> lists = iFollowPostDao.selectByAttributeAnd(pageBean);
		int lineCount = iFollowPostDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<FollowPost> pageBean) throws Exception {
		return iFollowPostDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<FollowPost> pageBean) throws Exception {
		List<FollowPost> lists = iFollowPostDao.selectByAttributeOr(pageBean);
		int lineCount = iFollowPostDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<FollowPost> pageBean) throws Exception {
		return iFollowPostDao.selectByAttributeCountOr(pageBean);
	}

}
