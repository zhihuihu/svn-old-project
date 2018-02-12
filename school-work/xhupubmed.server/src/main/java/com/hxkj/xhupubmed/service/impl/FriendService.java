package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IFriendDao;
import com.hxkj.xhupubmed.entity.Friend;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IFriendService;

/** 
 * ClassName:FriendService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午3:53:53 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class FriendService implements IFriendService {

	@Resource
	private IFriendDao iFriendDao;
	
	@Override
	public int doDeleteByPrimaryKey(Friend b) throws Exception {
		return iFriendDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Friend> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iFriendDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(Friend b) throws Exception {
		CuidUtils.setCuid(b, "好友表插入数据");
		return iFriendDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Friend> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "好友表插入数据", new Friend());
		for(int i=0;i<bs.size();i++){
			flg = iFriendDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(Friend b) throws Exception {
		return iFriendDao.doInsertSelective(b);
	}

	@Override
	public Friend selectByPrimaryKey(Friend b) throws Exception {
		return iFriendDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Friend b) throws Exception {
		return iFriendDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Friend b) throws Exception {
		return iFriendDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Friend> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iFriendDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("更新数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Friend> pageBean) throws Exception {
		List<Friend> lists = iFriendDao.selectByAttributeAnd(pageBean);
		int lineCount = iFriendDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Friend> pageBean) throws Exception {
		return iFriendDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Friend> pageBean) throws Exception {
		List<Friend> lists = iFriendDao.selectByAttributeOr(pageBean);
		int lineCount = iFriendDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Friend> pageBean) throws Exception {
		return iFriendDao.selectByAttributeCountOr(pageBean);
	}

	@Override
	public Friend selectByAttribute(Friend friend) throws Exception {
		return iFriendDao.selectByAttribute(friend);
	}

}
