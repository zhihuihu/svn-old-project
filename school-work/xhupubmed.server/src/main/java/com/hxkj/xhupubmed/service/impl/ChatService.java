package com.hxkj.xhupubmed.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.dao.IChatDao;
import com.hxkj.xhupubmed.entity.Chat;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IChatService;

/** 
 * ClassName:ChatService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 下午2:47:30 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class ChatService implements IChatService {

	@Resource
	private IChatDao iChatDao;
	
	@Override
	public int doDeleteByPrimaryKey(Chat b) throws Exception {
		return iChatDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<Chat> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iChatDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new Exception("删除出错请查看数据是否正确");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(Chat b) throws Exception {
		CuidUtils.setCuid(b, "chat表开始插入");
		return iChatDao.doInsert(b);
	}

	@Override
	public int doInsertList(List<Chat> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			CuidUtils.setCuid(bs.get(i), "chat表开始插入");
			flg = iChatDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new Exception("增加数据错误，请查看数据格式是否正确");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(Chat b) throws Exception {
		CuidUtils.setCuid(b, "chat表开始插入");
		return iChatDao.doInsertSelective(b);
	}

	@Override
	public Chat selectByPrimaryKey(Chat b) throws Exception {
		return iChatDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(Chat b) throws Exception {
		return iChatDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(Chat b) throws Exception {
		return iChatDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<Chat> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iChatDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new Exception("查看数据是否填写完整");
			}
		}
		return 0;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<Chat> pageBean) throws Exception {
		List<Chat> lists = iChatDao.selectByAttributeAnd(pageBean);
		int lineCount = iChatDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<Chat> pageBean) throws Exception {
		return iChatDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<Chat> pageBean) throws Exception {
		List<Chat> lists = iChatDao.selectByAttributeOr(pageBean);
		int lineCount = iChatDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<Chat> pageBean) throws Exception {
		return iChatDao.selectByAttributeCountOr(pageBean);
	}

}
