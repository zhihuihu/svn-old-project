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
import com.hxkj.xhupubmed.dao.ISysUserDao;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.Post;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.service.inter.IPostService;

/** 
 * ClassName:PostService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午9:48:27 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class PostService implements IPostService {

	
	@Resource
	private IPostDao IPostDao;
	@Resource
	private ISysUserDao iSysUserDao;
	
	@Override
	public int doDeleteByPrimaryKey(Post b) throws Exception {
		return IPostDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Post> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = IPostDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(Post b) throws Exception {
		CuidUtils.setCuid(b, "帖子表插入");
		return IPostDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Post> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "帖子表插入", new Post());
		for(int i=0;i<bs.size();i++){
			flg = IPostDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(Post b) throws Exception {
		CuidUtils.setCuid(b, "帖子表插入");
		return IPostDao.doInsertSelective(b);
	}

	@Override
	public Post selectByPrimaryKey(Post b) throws Exception {
		b = IPostDao.selectByPrimaryKey(b);
		SysUser sysUser = new SysUser();
		sysUser.setSysUserCuid(b.getSysUserCuid());
		sysUser = iSysUserDao.selectByPrimaryKey(sysUser);
		b.setSysUser(sysUser);
		return b;
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Post b) throws Exception {
		return IPostDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Post b) throws Exception {
		return IPostDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Post> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = IPostDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("修改数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Post> pageBean) throws Exception {
		List<Post> lists = IPostDao.selectByAttributeAnd(pageBean);
		if(lists != null && lists.size()!=0){
			for(int i=0;i<lists.size();i++){
				SysUser sysUser = new SysUser();
				sysUser.setSysUserCuid(lists.get(i).getSysUserCuid());
				sysUser = iSysUserDao.selectByPrimaryKey(sysUser); 
				lists.get(i).setSysUser(sysUser);
			}
		}
		int lineCount = IPostDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Post> pageBean) throws Exception {
		return IPostDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Post> pageBean) throws Exception {
		List<Post> lists = IPostDao.selectByAttributeOr(pageBean);
		int lineCount = IPostDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Post> pageBean) throws Exception {
		return IPostDao.selectByAttributeCountOr(pageBean);
	}

	@Override
	public Object doInsertImages(HttpServletRequest request, String postCuid) throws Exception {
		String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.IMAGE_URL), PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), "", true);
		Post post = new Post();
		post.setPostCuid(postCuid);
		post.setPostUrl(imageUrl);
		IPostDao.doUpdateImage(post);
		return PageBeanUtils.formatForNormalTrue("", "图片增加成功");
	}

}
