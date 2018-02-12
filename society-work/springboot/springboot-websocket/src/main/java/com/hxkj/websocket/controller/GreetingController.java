package com.hxkj.websocket.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {

	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;  
	
	@RequestMapping("getSession") 
	@ResponseBody
	public String getSession(HttpSession session){
		System.out.println(session.getId());
		return "index";
	}
	
	@RequestMapping("index") 
	public String index(HttpSession session){
		System.out.println(session.getId());
		return "index";
	}
	
    @RequestMapping("/helloSocket")    
    public String helloSocket(){        
        return "hello/index";    
    }  
    
    @RequestMapping("/oneToOne")    
    public String oneToOne(){        
        return "oneToOne";    
    }  
    
    @MessageMapping(value="/change-notice")    
    //@SendToUser(value="/topic/notice")
    //@SendTo(value="/topic/notice")
    public void greeting(SimpMessageHeaderAccessor headerAccessor,String value){
    	System.out.println(headerAccessor.getSessionAttributes());
    	Map<String,Object> map = headerAccessor.getSessionAttributes();
    	System.out.println("HTTP_SESSION_ID:"+map.get("HTTP_SESSION_ID"));
    	System.out.println("session:"+headerAccessor.getSessionId()+"		value:"+value);
        this.simpMessagingTemplate.convertAndSend("/topic/notice", value);    
    	//return value;
    }
    
    @MessageMapping(value="/change-notice-greetingToOne")    
    //@SendToUser(value="/topic/greetingToOne")
    public void greetingToOne(SimpMessageHeaderAccessor headerAccessor,String value){
    	String reId = value.substring(0, value.indexOf(";"));
    	System.out.println(headerAccessor.getSessionAttributes());
    	Map<String,Object> map = headerAccessor.getSessionAttributes();
    	System.out.println("HTTP_SESSION_ID:"+map.get("HTTP_SESSION_ID"));
    	System.out.println("session:"+headerAccessor.getSessionId()+"		value:"+value);
    	this.simpMessagingTemplate.convertAndSendToUser(reId, "/greetingToOne/", value);
    	//return value;
    }
    
}
