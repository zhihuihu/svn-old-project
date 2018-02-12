package com.hxkj.wechat.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.wechat.core.utils.SHA1Utils;
import com.hxkj.wechat.entity.SysUser;

@Controller
@RequestMapping(value="common")
public class CommonController {

	private String TOKEN = "hxkjtoken";
	
	@RequestMapping(value="token")
	@ResponseBody
	public Object token(HttpServletRequest request, HttpServletResponse response){
		// 微信加密签名
        String signature = request.getParameter("signature");
        // 随机字符串
        String echostr = request.getParameter("echostr");
        // 时间戳
        String timestamp = request.getParameter("timestamp");
        // 随机数
        String nonce = request.getParameter("nonce");

        String[] str = { TOKEN, timestamp, nonce };
        Arrays.sort(str); // 字典序排序
        String bigStr = str[0] + str[1] + str[2];
        // SHA1加密
        String digest =  SHA1Utils.encode(bigStr);
        // 确认请求来至微信
        if (digest.equals(signature)) {
        	return echostr;
        }else{
        	return "error";
        }
	}
	
	@RequestMapping(value="testAop")
	@ResponseBody
	public Object testAop(){
		return "testAop";
	}
	
	@RequestMapping(value="testJson")
	@ResponseBody
	public Object testJson(HttpServletRequest request,@RequestBody SysUser sysUser){
		System.out.println(request.getParameterNames());
		return "测试";
	}
}
