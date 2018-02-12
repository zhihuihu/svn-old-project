package com.hxkj.wechat.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	
	public void sayHello(){
		System.out.println("hello testService");
	}
	
	public void sayWorld(String words){
		System.out.println("hello:"+words);
	}
}
