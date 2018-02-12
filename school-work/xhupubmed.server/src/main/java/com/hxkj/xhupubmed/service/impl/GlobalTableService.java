package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.dao.IGlobalTableDao;
import com.hxkj.xhupubmed.entity.GlobalTable;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IGlobalTableService;

/** 
 * ClassName:GlobalTableService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午3:48:50 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class GlobalTableService implements IGlobalTableService {

	@Resource
	private IGlobalTableDao iGlobalTableDao;
	
	@Override
	public int doDeleteByPrimaryKey(GlobalTable b) throws Exception {
		return 0;
	}

	@Override
	public int doDeleteListByPrimaryKey(List<GlobalTable> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsert(GlobalTable b) throws Exception {
		return iGlobalTableDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<GlobalTable> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsertSelective(GlobalTable b) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GlobalTable selectByPrimaryKey(GlobalTable b) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int doUpdateByPrimaryKeySelective(GlobalTable b) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdateByPrimaryKey(GlobalTable b) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doUpdateListByPrimaryKey(List<GlobalTable> bs) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<GlobalTable> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<GlobalTable> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<GlobalTable> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<GlobalTable> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int doInsertTrans()throws Exception{
		for(int i=0;i<4;i++){
			GlobalTable globalTable = new GlobalTable();
			globalTable.setGlobalTableTableName("GlobalTable");
			globalTable.setGlobalTableNotes(""+i);
			globalTable.setGlobalTableCreateTime(TimeUtils.getMySqlFormatTime());
			iGlobalTableDao.doInsert(globalTable);
			if(i==3){
				throw new RuntimeException();
			}
		}
		
		return 0;
	}

}
