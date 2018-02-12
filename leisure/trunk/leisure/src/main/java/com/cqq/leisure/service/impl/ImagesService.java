package com.cqq.leisure.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cqq.leisure.dao.IImagesDao;
import com.cqq.leisure.entity.Images;
import com.cqq.leisure.entity.PageBean;
import com.cqq.leisure.service.inter.IImagesService;

/** 
 * ClassName:ImagesService
 * Function:   
 * Date:     2016年3月20日 下午8:37:28 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class ImagesService implements IImagesService {

	@Resource
	private IImagesDao iImagesDao;
	
	@Override
	public int doDeleteByPrimaryKey(Images b) throws Exception {
		return iImagesDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Images> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iImagesDao.doDeleteByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，删除失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsert(Images b) throws Exception {
		return iImagesDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Images> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iImagesDao.doInsert(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，增加数据失败");
			}
		}
		return flag;
	}

	@Override
	public int doInsertSelective(Images b) throws Exception {
		return iImagesDao.doInsertSelective(b);
	}

	@Override
	public Images selectByPrimaryKey(Images b) throws Exception {
		return iImagesDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Images b) throws Exception {
		return iImagesDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Images b) throws Exception {
		return iImagesDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Images> bs) throws Exception {
		int flag = 0;
		for( int i=0;i<bs.size();i++){
			flag = iImagesDao.doUpdateByPrimaryKey(bs.get(i));
			if( flag == 0){
				throw new RuntimeException("传入数据错误，增加数据失败");
			}
		}
		return flag;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Images> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Images> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Images> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Images> pageBean) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
