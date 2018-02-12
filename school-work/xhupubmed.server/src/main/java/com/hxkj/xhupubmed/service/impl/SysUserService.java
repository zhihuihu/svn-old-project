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
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.dao.ISysUserDao;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.service.inter.ISysUserService;

/** 
 * ClassName:SysUserService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月9日 上午11:28:33 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class SysUserService implements ISysUserService {

	@Resource
	private ISysUserDao ISysUserDao;
	
	@Override
	public int doDeleteByPrimaryKey(SysUser b) throws Exception {
		return ISysUserDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<SysUser> bs) throws Exception {
		int flg = 0 ;
		for(int i=0;i<bs.size();i++){
			flg = ISysUserDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(SysUser b) throws Exception {
		CuidUtils.setCuid(b, "系统用户表");
		return ISysUserDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<SysUser> bs) throws Exception {
		int flg = 0 ;
		CuidUtils.setCuidList(bs, "系统用户表", new SysUser());
		for(int i=0;i<bs.size();i++){
			flg = ISysUserDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(SysUser b) throws Exception {
		CuidUtils.setCuid(b, "系统用户表");
		return ISysUserDao.doInsertSelective(b);
	}

	@Override
	public SysUser selectByPrimaryKey(SysUser b) throws Exception {
		return ISysUserDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(SysUser b) throws Exception {
		return ISysUserDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(SysUser b) throws Exception {
		return ISysUserDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<SysUser> bs) throws Exception {
		int flg = 0 ;
		for(int i=0;i<bs.size();i++){
			flg = ISysUserDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("修改数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<SysUser> pageBean) throws Exception {
		List<SysUser> lists = ISysUserDao.selectByAttributeAnd(pageBean);
		int lineCount = ISysUserDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<SysUser> pageBean) throws Exception {
		return ISysUserDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<SysUser> pageBean) throws Exception {
		List<SysUser> lists = ISysUserDao.selectByAttributeOr(pageBean);
		int lineCount = ISysUserDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<SysUser> pageBean) throws Exception {
		return ISysUserDao.selectByAttributeCountOr(pageBean);
	}

	@Override
	public int doRegister(SysUser sysUser) throws Exception {
		SysUser sysUser2 = new SysUser();
		sysUser2.setSysUserEmail(sysUser.getSysUserEmail());
		if(ISysUserDao.selectSysUserByAttribute(sysUser2) != null){
			throw new Exception("邮箱地址已经被注册");
		}else{
			sysUser2 = new SysUser();
			sysUser2.setSysUserLoginName(sysUser.getSysUserLoginName());
			if(ISysUserDao.selectSysUserByAttribute(sysUser2) != null){
				throw new Exception("登录名已经被注册");
			}
		}
		CuidUtils.setCuid(sysUser, "系统用户表");
		sysUser.setSysUserType(2);
		sysUser.setSysUserState(1);
		sysUser.setSysUserCreateTime(TimeUtils.getMySqlFormatTime());
		return ISysUserDao.doInsert(sysUser);
	}

	@Override
	public SysUser doLogin(SysUser sysUser) throws Exception {
		return ISysUserDao.selectSysUserByAttribute(sysUser);
	}

	@Override
	public SysUser selectByAttribute(SysUser sysUser) throws Exception {
		return ISysUserDao.selectSysUserByAttribute(sysUser);
	}

	@Override
	public Object updateUserImage(HttpServletRequest request,String sysUserCuid) throws Exception {
		String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.IMAGE_URL), PropertiesUtils.getPropertiesValue(Constant.SERVER_IMAGE_URL), "", true);
		SysUser sysUser = new SysUser();
		sysUser.setSysUserCuid(sysUserCuid);
		sysUser = ISysUserDao.selectByPrimaryKey(sysUser);
		sysUser.setSysUserUrl(imageUrl);
		ISysUserDao.doUpdateByPrimaryKeySelective(sysUser);
		return PageBeanUtils.formatForNormalTrue("", sysUser);
	}

}
