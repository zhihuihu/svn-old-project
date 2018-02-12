package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IInformationPushDao;
import com.hxkj.xhupubmed.entity.InformationPush;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IInformationPushService;

/** 
 * ClassName:InformationPushService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午4:53:35 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class InformationPushService implements IInformationPushService {

	@Resource
	private IInformationPushDao iInformationPushDao;
	
	
	@Override
	public int doDeleteByPrimaryKey(InformationPush b) throws Exception {
		return iInformationPushDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<InformationPush> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iInformationPushDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(InformationPush b) throws Exception {
		CuidUtils.setCuid(b, "信息推送表插入数据");
		return iInformationPushDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<InformationPush> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "信息推送表插入数据", new InformationPush());
		for(int i=0;i<bs.size();i++){
			flg = iInformationPushDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(InformationPush b) throws Exception {
		CuidUtils.setCuid(b, "信息推送表插入数据");
		return iInformationPushDao.doInsertSelective(b);
	}

	@Override
	public InformationPush selectByPrimaryKey(InformationPush b) throws Exception {
		return iInformationPushDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(InformationPush b) throws Exception {
		return iInformationPushDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(InformationPush b) throws Exception {
		return iInformationPushDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<InformationPush> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iInformationPushDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("更新数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<InformationPush> pageBean) throws Exception {
		List<InformationPush> lists = iInformationPushDao.selectByAttributeAnd(pageBean);
		int lineCount = iInformationPushDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<InformationPush> pageBean) throws Exception {
		return iInformationPushDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<InformationPush> pageBean) throws Exception {
		List<InformationPush> lists = iInformationPushDao.selectByAttributeOr(pageBean);
		int lineCount = iInformationPushDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<InformationPush> pageBean) throws Exception {
		return iInformationPushDao.selectByAttributeCountOr(pageBean);
	}

}
