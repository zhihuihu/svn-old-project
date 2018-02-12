package com.dy.weike.controllerClient;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.weike.core.utils.PageBeanUtils;
import com.dy.weike.core.utils.TimeUtils;
import com.dy.weike.entity.Ask;
import com.dy.weike.entity.User;
import com.dy.weike.service.inter.IAskService;
import com.dy.weike.service.inter.IUserService;


@Controller
@RequestMapping(value = "client/ask")
public class AskClientController {
	
	@Resource
	private IAskService iAskService;
	
	@Resource
	private IUserService iUserService;
	
	@RequestMapping(value = "showAsk")
	@ResponseBody
	public Object showAsk(int classId){
		Ask ask = new Ask();
		ask.setClassId(classId);
		List<Ask> askExist = (List<Ask>) iAskService.selectByAttribute(ask);
		for(int i = 0; i < askExist.size();i++){
			User userExist = new User();
			int userId = askExist.get(i).getAnserId();
			userExist.setUserId(userId);
			User curUser = iUserService.selectByPrimaryKey(userExist);
			askExist.get(i).setAnserInfo(curUser);			
		}
		if(askExist != null){
			return PageBeanUtils.formatForNormalTrue("", askExist);			
		}		
		return PageBeanUtils.formatForNormalFalse("", "暂时没有用户评论！");		
	}
	
	@RequestMapping(value = "showAskByAskerId")
	@ResponseBody
	public Object showAskByAskerId(int askerId){
		Ask ask = new Ask();
		ask.setAskerId(askerId);
		Object askExist = iAskService.selectByAttributeByAskerId(ask);
		if(askExist != null){
			return PageBeanUtils.formatForNormalTrue("", askExist);
		}
		return PageBeanUtils.formatForNormalFalse("", "暂时没有用户评论此用户！");		
	}
	
	@RequestMapping(value = "insertReply")
	@ResponseBody
	public Object insertReply(int classId,int askerId,int anserId,String replyContent,int curAskState){        
        Ask ask = new Ask();
	    ask.setClassId(classId);
	    ask.setAskerId(askerId);
	    ask.setAnserId(anserId);
		System.out.println("---startaskerId");
		System.out.println(askerId); 
		System.out.println("---endaskerId");	
        if(askerId == -1){	 
    		List<Ask> askExist = (List<Ask>) iAskService.selectByAttribute(ask);
    		int existNum = askExist.size() + 1;
    		System.out.println("---start");
    		System.out.println(askExist.size());
    		System.out.println("---end");			
    		ask.setAskState(existNum);	         	
        }else{
        	ask.setAskState(curAskState);
        }
	    ask.setAskText(replyContent);		
	    ask.setAskTime(TimeUtils.getMySqlFormatTime());
	    iAskService.insertSelective(ask); 
		return PageBeanUtils.formatForNormalTrue("", "回复成功！");		
	}
}
