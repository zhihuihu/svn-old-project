package com.hxkj.xhupubmed.core.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.hxkj.xhupubmed.entity.pojo.TulingMessage;

/**
 * 
* @ClassName: DataChangeUtils 
* @Description: TODO  值的转换工具类
* @author huzhihui_c@qq.com
* @date 2016年4月14日 下午2:32:50 
*
 */
public class DataChangeUtils {

	/**
	 * 
	* @Title: getTuLingDataString 
	* @Description: TODO    转换图灵消息的工具类
	* @param inString
	* @return String    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:06:18
	 */
	public static String getTuLingDataString(String inString){
		StringBuffer outString = new StringBuffer();
		TulingMessage tulingMessage = JSON.parseObject(inString, TulingMessage.class);
		if(tulingMessage.getCode().equals(KeyUtils.TL_CODE_100000)){
			outString.append(tulingMessage.getText());
		}else if(tulingMessage.getCode().equals(KeyUtils.TL_CODE_200000)){
			outString.append(getCode200000(tulingMessage));
		}else if(tulingMessage.getCode().equals(KeyUtils.TL_CODE_302000)){
			outString.append(getCode302000(tulingMessage));
		}else if(tulingMessage.getCode().equals(KeyUtils.TL_CODE_308000)){
			outString.append(getCode308000(tulingMessage));
		}else{
			outString.append("我不知道怎么回复了");
		}
		return outString.toString();
	}
	
	/**
	 * 
	* @Title: getCode200000 
	* @Description: TODO    Code_200000 连接类返回类容
	* @param tulingMessage
	* @return   
	* @return String    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:18:24
	 */
	private static String getCode200000(TulingMessage tulingMessage){
		StringBuffer outString = new StringBuffer();
		outString.append(tulingMessage.getText());
		outString.append("<a class='robit_url' href='javascript:void(0);' href_url='"+tulingMessage.getUrl()+"'>点击连接查看更多哦!</a>");
		return outString.toString();
	}
	
	/**
	 * 
	* @Title: getCode302000 
	* @Description: TODO    新闻类
	* @param tulingMessage
	* @return   
	* @return String    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:30:58
	 */
	private static String getCode302000(TulingMessage tulingMessage){
		StringBuffer outString = new StringBuffer();
		outString.append(tulingMessage.getText());
		List<TulingMessage.NewList> newList = tulingMessage.getList();
		for(int i=0;i<newList.size();i++){
			String in = "";
			in += "标题:" + newList.get(i).getArticle() + "<br>";
			in += "来源:" + newList.get(i).getSource() + "<br>";
			in += "详细连接:<a class='robit_url' href='javascript:void(0);' href_url='"+newList.get(i).getDetailurl()+"'>点击查看更多哦</a><br>";
			outString.append(in);
		}
		return outString.toString();
	}
	
	/**
	 * 
	* @Title: getCode308000 
	* @Description: TODO    菜谱类信息格式化
	* @param tulingMessage
	* @return   
	* @return String    
	* @author huzhihui_c@qq.com
	* @date 2016年4月14日 下午3:30:01
	 */
	private static String getCode308000(TulingMessage tulingMessage){
		StringBuffer outString = new StringBuffer();
		outString.append(tulingMessage.getText());
		List<TulingMessage.NewList> newList = tulingMessage.getList();
		for(int i=0;i<newList.size();i++){
			String in = "";
			in += "菜名:" + newList.get(i).getName() + "<br>";
			in += "菜谱信息:" + newList.get(i).getInfo() + "<br>";
			in += "详细连接:<a class='robit_url' href='javascript:void(0);' href_url='"+newList.get(i).getDetailurl()+"'>点击查看更多哦</a><br>";
			outString.append(in);
		}
		return outString.toString();
	}
}
