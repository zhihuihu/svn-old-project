package com.hxkj.photocms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.photocms.dao.IGlobalIdDao;
import com.hxkj.photocms.entity.GlobalId;
import com.hxkj.photocms.entity.PageBean;
import com.hxkj.photocms.service.inter.IGlobalIdService;

/** 
 * Project Name:photocms.server 
 * ClassName:GlobalIdService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午5:17:15 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class GlobalIdService implements IGlobalIdService {

	@Resource
	private IGlobalIdDao iGlobalIdDao;
	
	@Override
	public boolean doInsert(GlobalId b) throws Exception {
		return iGlobalIdDao.doInsert(b);
	}

	@Override
	public boolean doInsertList(List<GlobalId> b) throws Exception {
		boolean flg = true;
		for(int i=0;i<b.size();i++){
			flg = iGlobalIdDao.doInsert(b.get(i));
			if(flg == false){
				break;
			}
		}
		return flg;
	}

	@Override
	public boolean doUpdate(GlobalId b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(GlobalId b) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<GlobalId> getAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GlobalId getById(GlobalId b) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GlobalId> getAllByPage(PageBean<GlobalId> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllByPageCount(PageBean<GlobalId> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAllByPageCountOr(PageBean<GlobalId> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
