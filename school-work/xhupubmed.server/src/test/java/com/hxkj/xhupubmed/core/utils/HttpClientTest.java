package com.hxkj.xhupubmed.core.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/** 
 * Project Name:xhupubmed.server 
 * ClassName:HttpClientTest
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 上午9:46:01 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class HttpClientTest {

	public static void main(String[] args) throws Exception {
		
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("key", "99b9746f8c381a1940395e5bba7a099c"));
		params.add(new BasicNameValuePair("info", "最新考研新闻"));
		params.add(new BasicNameValuePair("userid", "123456789fd"));
		String res = HttpServletUtil.doPost(params, "http://www.tuling123.com/openapi/api");
		
		System.out.println(DataChangeUtils.getTuLingDataString(res));
		System.out.println(HttpServletUtil.doPost(params, "http://m.toutiao.com/search/?keyword=%E8%80%83%E7%A0%94&from=search_page_input"));
	}
}
