package com.hxkj.xhupubmed.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxkj.xhupubmed.core.utils.CuidUtils;
import com.hxkj.xhupubmed.core.utils.DataChangeUtils;
import com.hxkj.xhupubmed.core.utils.HttpServletUtil;
import com.hxkj.xhupubmed.core.utils.KeyUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.core.utils.TimeUtils;
import com.hxkj.xhupubmed.dao.IIntelligentMessageDao;
import com.hxkj.xhupubmed.dao.ILearnPlanDao;
import com.hxkj.xhupubmed.entity.IntelligentMessage;
import com.hxkj.xhupubmed.entity.LearnPlan;
import com.hxkj.xhupubmed.entity.PageBean;
import com.hxkj.xhupubmed.service.inter.IIntelligentMessageService;

/** 
 * ClassName:IntelligentMessageService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月8日 下午5:56:11 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Service
@Transactional
public class IntelligentMessageService implements IIntelligentMessageService {

	@Resource
	private IIntelligentMessageDao iIntelligentMessageDao;
	@Resource
	private ILearnPlanDao iLearnPlanDao;
	
	@Override
	public int doDeleteByPrimaryKey(IntelligentMessage b) throws Exception {
		return iIntelligentMessageDao.doDeleteByPrimaryKey(b);
	}

	@Override
	public int doDeleteListByPrimaryKey(List<IntelligentMessage> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iIntelligentMessageDao.doDeleteByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("删除数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsert(IntelligentMessage b) throws Exception {
		CuidUtils.setCuid(b, "只能消息表插入数据");
		iIntelligentMessageDao.doInsert(b);
		Thread.sleep(1000);
		messageToTL(b);//进行智能消息回复
		return 1;
	}

	@Override
	public int doInsertList(List<IntelligentMessage> bs) throws Exception {
		int flg = 0;
		CuidUtils.setCuidList(bs, "智能消息插入表", new IntelligentMessage());
		for(int i=0;i<bs.size();i++){
			flg = iIntelligentMessageDao.doInsert(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("增加数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public int doInsertSelective(IntelligentMessage b) throws Exception {
		CuidUtils.setCuid(b, "只能消息表插入数据");
		return iIntelligentMessageDao.doInsertSelective(b);
	}

	@Override
	public IntelligentMessage selectByPrimaryKey(IntelligentMessage b) throws Exception {
		return iIntelligentMessageDao.selectByPrimaryKey(b);
	}

	@Override
	public int doUpdateByPrimaryKeySelective(IntelligentMessage b) throws Exception {
		return iIntelligentMessageDao.doUpdateByPrimaryKeySelective(b);
	}

	@Override
	public int doUpdateByPrimaryKey(IntelligentMessage b) throws Exception {
		return iIntelligentMessageDao.doUpdateByPrimaryKey(b);
	}

	@Override
	public int doUpdateListByPrimaryKey(List<IntelligentMessage> bs) throws Exception {
		int flg = 0;
		for(int i=0;i<bs.size();i++){
			flg = iIntelligentMessageDao.doUpdateByPrimaryKey(bs.get(i));
			if(flg == 0){
				throw new RuntimeException("更新数据出错，请检查输入数据");
			}
		}
		return flg;
	}

	@Override
	public Map<String, Object> selectByAttributeAnd(PageBean<IntelligentMessage> pageBean) throws Exception {
		checkLearnPlanTask(pageBean.getInVo());
		List<IntelligentMessage> lists = iIntelligentMessageDao.selectByAttributeAnd(pageBean);
		if(lists != null){
			for(int i =0;i<lists.size();i++){//执行信息的状态的更新
				IntelligentMessage intelligentMessage = lists.get(i);
				intelligentMessage.setIntelligentMessageState(4);
				iIntelligentMessageDao.doUpdateByPrimaryKeySelective(intelligentMessage);
			}
		}
		int lineCount = iIntelligentMessageDao.selectByAttributeCountAnd(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountAnd(PageBean<IntelligentMessage> pageBean) throws Exception {
		return iIntelligentMessageDao.selectByAttributeCountAnd(pageBean);
	}

	@Override
	public Map<String, Object> selectByAttributeOr(PageBean<IntelligentMessage> pageBean) throws Exception {
		List<IntelligentMessage> lists = iIntelligentMessageDao.selectByAttributeOr(pageBean);
		int lineCount = iIntelligentMessageDao.selectByAttributeCountOr(pageBean);
		int pageCount = PageBeanUtils.getPageCount(lineCount, pageBean.getLineSize());
		return PageBeanUtils.formatForPageTrue(lists, pageBean.getCurrentPage(), pageBean.getLineSize(), pageCount);
	}

	@Override
	public int selectByAttributeCountOr(PageBean<IntelligentMessage> pageBean) throws Exception {
		return iIntelligentMessageDao.selectByAttributeCountOr(pageBean);
	}
	
	/**
	 * 
	* @Title: messageToTL 
	* @Description: TODO    做为与图灵机器人聊天的接口
	* @param intelligentMessage
	* @return int    
	* @author huzhihui_c@qq.com
	 * @throws Exception 
	* @date 2016年4月14日 下午2:44:29
	 */
	private int messageToTL(IntelligentMessage intelligentMessage) throws Exception{
		IntelligentMessage intelligentMessageToTL = new IntelligentMessage();
		//开始智能通信
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", KeyUtils.TL_KEY));
		params.add(new BasicNameValuePair("info", intelligentMessage.getIntelligentMessageContent()));
		params.add(new BasicNameValuePair("userid", intelligentMessage.getSysUserCuid()));
		String intelligentMessageContent = DataChangeUtils.getTuLingDataString( HttpServletUtil.doPost(params, "http://www.tuling123.com/openapi/api"));
		//end
		CuidUtils.setCuid(intelligentMessageToTL, "只能消息表插入数据");
		intelligentMessageToTL.setSysUserCuid(intelligentMessage.getSysUserCuid());
		intelligentMessageToTL.setIntelligentMessageTitle("图灵机器人");
		intelligentMessageToTL.setIntelligentMessageContent(intelligentMessageContent);
		intelligentMessageToTL.setIntelligentMessageDirection(2);
		intelligentMessageToTL.setIntelligentMessageState(1);//设置为未读消息
		intelligentMessageToTL.setIntelligentMessageCreateTime(TimeUtils.getMySqlFormatTime());
		iIntelligentMessageDao.doInsert(intelligentMessageToTL);
		return 1;
	}

	@Override
	public List<IntelligentMessage> selectListByInitTask(IntelligentMessage intelligentMessage)  throws Exception{
		return iIntelligentMessageDao.selectListByInitTask(intelligentMessage);
	}
	
	private void checkLearnPlanTask(IntelligentMessage intelligentMessage) throws Exception{
		PageBean<LearnPlan> pageBean = new PageBean<>(1, 1);
		pageBean.setStartTime(TimeUtils.getMySqlFormatTime());
		LearnPlan learnPlan = new LearnPlan();
		learnPlan.setSysUserCuid(intelligentMessage.getSysUserCuid());
		pageBean.setInVo(learnPlan);
		pageBean.setSearchName(TimeUtils.getMySqlDay());
		pageBean.setOrderByString("ORDER BY LEARN_PLAN_START_TIME DESC");
		List<LearnPlan> learnPlans = iLearnPlanDao.selectByAttributeAnd(pageBean);
		PageBean<IntelligentMessage> pageBean2 = new PageBean<>(1, 100);
		pageBean2.setInVo(intelligentMessage);
		pageBean2.setOrderByString("ORDER BY INTELLIGENT_MESSAGE_CREATE_TIME DESC");
		List<IntelligentMessage> intelligentMessages = iIntelligentMessageDao.selectByAttributeAnd(pageBean2);
		if(learnPlans !=null && learnPlans.size()!=0 && intelligentMessages!=null && intelligentMessages.size()!=0){
			int flg = 0;int insertFlg = -1;
			for(int i=0;i<learnPlans.size();i++){
				for(int j=0;j<intelligentMessages.size();j++){
					if(learnPlans.get(i).getLearnPlanStartTime().equals(intelligentMessages.get(j).getIntelligentMessageUpdateTime())){
						flg = 0;insertFlg = -1;
						break;
					}else{
						flg = 1;insertFlg = i;
					}
				}
			}
			if(flg == 1 && insertFlg != -1){
				IntelligentMessage intelligentMessage2 = new IntelligentMessage();
				CuidUtils.setCuid(intelligentMessage2, "智能消息表插入数据");
				intelligentMessage2.setSysUserCuid(intelligentMessage.getSysUserCuid());
				intelligentMessage2.setIntelligentMessageName("任务提醒");
				intelligentMessage2.setIntelligentMessageState(4);
				intelligentMessage2.setIntelligentMessageTitle("任务提醒");
				intelligentMessage2.setIntelligentMessageCreateTime(TimeUtils.getMySqlFormatTime());
				intelligentMessage2.setIntelligentMessageDirection(2);
				intelligentMessage2.setIntelligentMessageUpdateTime(learnPlans.get(insertFlg).getLearnPlanStartTime());
				intelligentMessage2.setIntelligentMessageContent("你有新任务哦，请在个人任务中查看！");
				iIntelligentMessageDao.doInsert(intelligentMessage2);
			}
		}
	}

}
