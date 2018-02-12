package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IFollowDao;
import com.hxkj.xhupubmed.dao.IPostDao;
import com.hxkj.xhupubmed.entity.Follow;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.service.inter.IFollowService;

/** 
 * ClassName:FollowService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午9:47:48 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class FollowService implements IFollowService {

	@Resource
	private IFollowDao iFollowDao;
	@Resource
	private IPostDao iPostDao;
	
	@Override
	public int doDeleteByPrimaryKey(Follow b) throws Exception {
		return iFollowDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Follow> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iFollowDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(Follow b) throws Exception {
		CuidUtils.setCuid(b, "用户关注表插入数据");
		Post post = new Post();
		post.setPostCuid(b.getFollowPostCuid());
		post = iPostDao.selectByPrimaryKey(post);
		post.setPostFollowPeopleNumber(post.getPostFollowPeopleNumber()+1);
		iPostDao.doUpdateByPrimaryKeySelective(post);
		return iFollowDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Follow> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "用户关注表插入数据", new Follow());
		for(int i=0;i<bs.size();i++){
			flg = iFollowDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("插入数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(Follow b) throws Exception {
		CuidUtils.setCuid(b, "用户关注表插入数据");
		Post post = new Post();
		post.setPostCuid(b.getFollowPostCuid());
		post = iPostDao.selectByPrimaryKey(post);
		post.setPostRepliesNumber(post.getPostRepliesNumber()+1);
		iPostDao.doUpdateByPrimaryKeySelective(post);
		return iFollowDao.doInsertSelective(b);
	}

	@Override
	public Follow selectByPrimaryKey(Follow b) throws Exception {
		return iFollowDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Follow b) throws Exception {
		return iFollowDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Follow b) throws Exception {
		return iFollowDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Follow> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iFollowDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("更新数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Follow> pageBean) throws Exception {
		List<Follow> lists = iFollowDao.selectByAttributeAnd(pageBean);
		if(lists != null && lists.size() !=0){
			for(int i=0;i<lists.size();i++){
				Post post = new Post();
				post.setPostCuid(lists.get(i).getFollowPostCuid());
				post = iPostDao.selectByPrimaryKey(post);
				lists.get(i).setPost(post);
			}
		}
		int lineCount = iFollowDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Follow> pageBean) throws Exception {
		return iFollowDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Follow> pageBean) throws Exception {
		List<Follow> lists = iFollowDao.selectByAttributeOr(pageBean);
		int lineCount = iFollowDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Follow> pageBean) throws Exception {
		return iFollowDao.selectByAttributeCountOr(pageBean);
	}

	@Override
	public Follow selectByAttribute(Follow follow) throws Exception {
		return iFollowDao.selectByAttribute(follow);
	}

	@Override
	public int doDeleteByAttribute(Follow follow) throws Exception {
		return iFollowDao.doDeleteByAttribute(follow);
	}

}
