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
import com.hxkj.xhupubmed.dao.IDataSharingDao;
import com.hxkj.xhupubmed.dao.ISysUserDao;
import com.hxkj.xhupubmed.entity.DataSharing;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.service.inter.IDataSharingService;

/** 
 * ClassName:DataSharingService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月17日 下午3:16:06 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class DataSharingService implements IDataSharingService {

	@Resource
	private IDataSharingDao iDataSharingDao;
	@Resource
	private ISysUserDao iSysUserDao;
	@Override
	public int doDeleteByPrimaryKey(DataSharing b) throws Exception {
		return iDataSharingDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<DataSharing> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsert(DataSharing b) throws Exception {
		CuidUtils.setCuid(b, "");
		return iDataSharingDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<DataSharing> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsertSelective(DataSharing b) throws Exception {
		CuidUtils.setCuid(b, "");
		return iDataSharingDao.doInsertSelective(b);
	}

	@Override
	public DataSharing selectByPrimaryKey(DataSharing b) throws Exception {
		DataSharing dataSharing = iDataSharingDao.selectByPrimaryKey(b);
		if(dataSharing != null){
			SysUser sysUser = new SysUser();
			sysUser.setSysUserCuid(dataSharing.getDataSharingSysUserCuid());
			dataSharing.setSysUser(iSysUserDao.selectByPrimaryKey(sysUser));
		}
		return iDataSharingDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(DataSharing b) throws Exception {
		return iDataSharingDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(DataSharing b) throws Exception {
		return iDataSharingDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<DataSharing> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<DataSharing> pageBean) throws Exception {
		int lineCount = iDataSharingDao.selectByAttributeCountAnd(pageBean);
		List<DataSharing> list = iDataSharingDao.selectByAttributeAnd(pageBean);
		for(int i=0;i<list.size();i++){
			SysUser sysUser = new SysUser();
			sysUser.setSysUserCuid(list.get(i).getDataSharingSysUserCuid());
			sysUser = iSysUserDao.selectByPrimaryKey(sysUser);
			list.get(i).setSysUser(sysUser);
		}
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(list, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<DataSharing> pageBean) throws Exception {
		return iDataSharingDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<DataSharing> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<DataSharing> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object doInsertFiles(HttpServletRequest request, DataSharing dataSharing) throws Exception {
		String fileUrl = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.FILE_URL), PropertiesUtils.getPropertiesValue(Constant.SERVER_FILE_URL), "", true);
		dataSharing = iDataSharingDao.selectByPrimaryKey(dataSharing);
		if(dataSharing.getDataSharingFileUrl1()=="" || dataSharing.getDataSharingFileUrl1() == null){
			dataSharing.setDataSharingFileUrl1(fileUrl);
		}else if(dataSharing.getDataSharingFileUrl2()=="" || dataSharing.getDataSharingFileUrl2() == null){
			dataSharing.setDataSharingFileUrl2(fileUrl);
		}else if(dataSharing.getDataSharingFileUrl3()=="" || dataSharing.getDataSharingFileUrl3() == null){
			dataSharing.setDataSharingFileUrl3(fileUrl);
		}else{
			dataSharing.setDataSharingFileUrl4(fileUrl);
		}
		iDataSharingDao.doUpdateByPrimaryKeySelective(dataSharing);
		return PageBeanUtils.formatForNormalTrue("", "文件上传成功");
	}

	@Override
	public Object adminDoInsert(HttpServletRequest request, DataSharing dataSharing) throws Exception {
		CuidUtils.setCuid(dataSharing, "");
		dataSharing.setDataSharingSysUserCuid("SYSUSER201605050274");
		dataSharing.setDataSharingState(1);
		dataSharing.setDataSharingCreateTime(TimeUtils.getMySqlFormatTime());
		dataSharing.setDataSharingUpdateTime(TimeUtils.getMySqlFormatTime());
		List<String> fileUrl = MultipleFileUtils.uploadManyMultipleFile(request, PropertiesUtils.getPropertiesValue(Constant.FILE_URL), PropertiesUtils.getPropertiesValue(Constant.SERVER_FILE_URL), "", true);
		for(int i=0;i<fileUrl.size();i++){
			if(dataSharing.getDataSharingFileUrl1()=="" || dataSharing.getDataSharingFileUrl1() == null){
				dataSharing.setDataSharingFileUrl1(fileUrl.get(i));
			}else if(dataSharing.getDataSharingFileUrl2()=="" || dataSharing.getDataSharingFileUrl2() == null){
				dataSharing.setDataSharingFileUrl2(fileUrl.get(i));
			}else if(dataSharing.getDataSharingFileUrl3()=="" || dataSharing.getDataSharingFileUrl3() == null){
				dataSharing.setDataSharingFileUrl3(fileUrl.get(i));
			}else{
				dataSharing.setDataSharingFileUrl4(fileUrl.get(i));
			}
		}
		iDataSharingDao.doInsert(dataSharing);
		return PageBeanUtils.formatForNormalTrue("", "新增信息成功");
	}

}
