package com.cqq.leisure.core.utils;

import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/** 
 * Project Name:xhupubmed.server 
 * ClassName:HttpServletUtil
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月7日 上午9:37:46 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class HttpServletUtil {

	private static CloseableHttpClient httpclient;
	private static RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
	
	/**
	 * 
	* @Title: doPost 
	* @param @param params
	* @param @param url
	* @param @return
	* @param @throws Exception     
	* @return String    
	* @author huzhihui_c@qq.com   
	* @date 2016年3月7日 上午9:43:44
	* @Since JDK 1.8
	 */
	public static String doPost(List<NameValuePair> params, String url) throws Exception {
        String result = null;
        httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
        //设置请求和传输超时时间
        httpPost.setConfig(requestConfig);
        CloseableHttpResponse httpResp = httpclient.execute(httpPost);
        try {
            int statusCode = httpResp.getStatusLine().getStatusCode();
            // 判断是够请求成功
            if (statusCode == HttpStatus.SC_OK) {
                System.out.println("状态码:" + statusCode);
                System.out.println("请求成功!");
                // 获取返回的数据
                result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
            } else {
                System.out.println("状态码:"
                        + httpResp.getStatusLine().getStatusCode());
                System.out.println("HttpPost方式请求失败!");
            }
        } finally {
            httpResp.close();
            httpclient.close();
        }
        return result;
    }
 
    /**
     * Get:访问数据库并返回数据字符串
     * 
     * @param url
     * @return String 数据字符串
     * @throws Exception
     */
     public static String doGet(String url) throws Exception{
        String result = null;
        httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //设置请求和传输超时时间
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse httpResp = httpclient.execute(httpGet);
        try {
            int statusCode = httpResp.getStatusLine().getStatusCode();
            // 判断是够请求成功
            if (statusCode == HttpStatus.SC_OK) {
                System.out.println("状态码:" + statusCode);
                System.out.println("请求成功!");
                // 获取返回的数据
                result = EntityUtils.toString(httpResp.getEntity(), "UTF-8");
            } else {
                System.out.println("状态码:"
                        + httpResp.getStatusLine().getStatusCode());
                System.out.println("HttpGet方式请求失败!");
            }
        } finally {
            httpResp.close();
            httpclient.close();
        }
        return result;
     }
	
	
}
