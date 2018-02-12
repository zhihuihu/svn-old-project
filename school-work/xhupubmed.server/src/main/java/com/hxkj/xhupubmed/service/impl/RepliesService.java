package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.Constant;
import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.MultipleFileUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.PropertiesUtils;
import com.hxkj.xhupubmed.dao.IPostDao;
import com.hxkj.xhupubmed.dao.IRepliesDao;
import com.hxkj.xhupubmed.dao.ISysUserDao;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.entity.Replies;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.service.inter.IRepliesService;

/** 
 * ClassName:RepliesService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月9日 上午11:27:43 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class RepliesService implements IRepliesService {

	@Resource
	private IRepliesDao iRepliesDao;
	@Resource
	private ISysUserDao iSysUserDao;
	@Resource
	private IPostDao iPostDao;
	
	@Override
	public int doDeleteByPrimaryKey(Replies b) throws Exception {
		return iRepliesDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Replies> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iRepliesDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(Replies b) throws Exception {
		CuidUtils.setCuid(b, "帖子回复表");
		Post post = new Post();
		post.setPostCuid(b.getPostCuid());
		post = iPostDao.selectByPrimaryKey(post);
		post.setPostRepliesNumber(post.getPostRepliesNumber()+1);
		iPostDao.doUpdateByPrimaryKeySelective(post);
		return iRepliesDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Replies> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "帖子回复表", new Replies());
		for(int i=0;i<bs.size();i++){
			flg = iRepliesDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(Replies b) throws Exception {
		CuidUtils.setCuid(b, "帖子回复表");
		Post post = new Post();
		post.setPostCuid(b.getPostCuid());
		post = iPostDao.selectByPrimaryKey(post);
		post.setPostRepliesNumber(post.getPostRepliesNumber()+1);
		iPostDao.doUpdateByPrimaryKeySelective(post);
		return iRepliesDao.doInsertSelective(b);
	}

	@Override
	public Replies selectByPrimaryKey(Replies b) throws Exception {
		b = iRepliesDao.selectByPrimaryKey(b);
		SysUser sysUser = new SysUser();
		sysUser.setSysUserCuid(b.getSysUserCuid());
		sysUser = iSysUserDao.selectByPrimaryKey(sysUser);
		b.setSysUser(sysUser);
		Post post = new Post();
		post.setPostCuid(b.getPostCuid());
		post = iPostDao.selectByPrimaryKey(post);
		b.setPost(post);
		return iRepliesDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Replies b) throws Exception {
		return iRepliesDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Replies b) throws Exception {
		return iRepliesDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Replies> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iRepliesDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("修改数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Replies> pageBean) throws Exception {
		List<Replies> lists = iRepliesDao.selectByAttributeAnd(pageBean);
		for(int i=0;i<lists.size();i++){
			//用户实体设置
			SysUser sysUser = new SysUser();
			sysUser.setSysUserCuid(lists.get(i).getSysUserCuid());
			SysUser sysUser1 = iSysUserDao.selectByPrimaryKey(sysUser);
			lists.get(i).setSysUser(sysUser1);
			Post post = new Post();
			post.setPostCuid(lists.get(i).getPostCuid());
			post = iPostDao.selectByPrimaryKey(post);
			lists.get(i).setPost(post);
		}
		int lineCount = iRepliesDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Replies> pageBean) throws Exception {
		return iRepliesDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Replies> pageBean) throws Exception {
		List<Replies> lists = iRepliesDao.selectByAttributeOr(pageBean);
		int lineCount = iRepliesDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Replies> pageBean) throws Exception {
		return iRepliesDao.selectByAttributeCountOr(pageBean);
	}

	@Override
	public Object doInsertImages(HttpServletRequest request, String repliesCuid) throws Exception {
		String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.IMAGE_URL), PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), "", true);
		Replies replies = new Replies();
		replies.setRepliesCuid(repliesCuid);
		replies.setRepliesTitle(imageUrl);
		iRepliesDao.doUpdateImage(replies);
		return PageBeanUtils.formatForNormalTrue("", "图片增加成功");
	}

}
