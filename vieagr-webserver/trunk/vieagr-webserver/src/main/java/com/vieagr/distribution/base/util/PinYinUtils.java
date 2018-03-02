package com.vieagr.distribution.base.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

public class PinYinUtils {

    /**
     * @Title: getPinYinCodeString 
     * @Description:     得到拼音编码
     * @param str
     * @return   
     * @return String    
     * @author huzhihui_c@qq.com
     * @date 2016年11月2日 下午2:43:45
     */
    public static String getPinYinCodeString(String str){
    	if(str == null || str.trim().equals("")){
    		return "";
    	}
    	String pinyin = "";
    	String[][] pinyins = new String[str.length()][];
    	char[] strChar = str.toCharArray();
    	for(int i=0;i<strChar.length;i++){
    		if(!isChineseChar(String.valueOf(strChar[i]))){
    			String[] aa = {String.valueOf(strChar[i])};
    			pinyins[i] = aa;
    		}else{
    			pinyins[i] = PinyinHelper.convertToPinyinArray(strChar[i],PinyinFormat.WITHOUT_TONE);
    		}
    	}
    	int listCount = getStrNumberAfter(pinyins,-1);
    	List<String> pinyinList = new ArrayList<String>();
    	for(int i=0;i<listCount;i++){
    		pinyinList.add("");
    	}
    	for(int i=0;i<pinyins.length;i++){
    		for(int j=0;j<pinyins[i].length;j++){
    			pinyins[i][j] = pinyins[i][j].substring(0, 1);
				int part = pinyinList.size()/pinyins[i].length;
				for(int n=0;n<part;n++){
					pinyinList.set(j*part + n, pinyinList.get(j*part + n) + pinyins[i][j]);
				}
    		}
    	}
    	for(int i=0;i<pinyinList.size();i++){
    		if(i==0){
    			pinyin = pinyinList.get(i);
    		}else{
    			pinyin = pinyin + "," + pinyinList.get(i);
    		}
    	}
    	return pinyin.toUpperCase();
    }
    
    /**
     * @Title: getPinYinString 
     * @Description:     获取到拼音的全拼，重庆：chongqing,zhongqing,
     * @param str
     * @return   
     * @return String    
     * @author huzhihui_c@qq.com
     * @date 2016年11月2日 上午9:45:59
     */
    public static String getPinYinString(String str){
    	if(str == null || str.trim().equals("")){
    		return "";
    	}
    	String pinyin = "";
    	String[][] pinyins = new String[str.length()][];
    	char[] strChar = str.toCharArray();
    	for(int i=0;i<strChar.length;i++){
    		if(!isChineseChar(String.valueOf(strChar[i]))){
    			String[] aa = {String.valueOf(strChar[i])};
    			pinyins[i] = aa;
    		}else{
    			pinyins[i] = PinyinHelper.convertToPinyinArray(strChar[i],PinyinFormat.WITHOUT_TONE);
    		}
    	}
    	int listCount = getStrNumberAfter(pinyins,-1);
    	List<String> pinyinList = new ArrayList<String>();
    	for(int i=0;i<listCount;i++){
    		pinyinList.add("");
    	}
    	for(int i=0;i<pinyins.length;i++){
    		for(int j=0;j<pinyins[i].length;j++){
				int part = pinyinList.size()/pinyins[i].length;
				for(int n=0;n<part;n++){
					pinyinList.set(j*part + n, pinyinList.get(j*part + n) + pinyins[i][j]);
				}
    		}
    	}
    	for(int i=0;i<pinyinList.size();i++){
    		if(i==0){
    			pinyin = pinyinList.get(i);
    		}else{
    			pinyin = pinyin + "," + pinyinList.get(i);
    		}
    	}
    	return pinyin.toUpperCase();
    }
    
    /**
     * @Title: getStrNumber 
     * @Description:     获取第几行后面需要填充的数据
     * @param str
     * @param line
     * @return   
     * @return int    
     * @author huzhihui_c@qq.com
     * @date 2016年11月2日 上午10:28:05
     */
    private static int getStrNumberAfter(String[][] str,int line){
    	if(line >= str.length -1){
    		return 0;
    	}
    	int number = 1;
    	for(int i=0;i<str.length;i++){
    		if(i > line){
    			number = number*str[i].length;
    		}
    	}
    	return number;
    }
    
    /**
     * @Title: isChineseChar 
     * @Description:     判断是否是中文
     * @param str
     * @return   
     * @return boolean    
     * @author huzhihui_c@qq.com
     * @date 2016年11月2日 下午2:18:38
     */
    public static boolean isChineseChar(String str){
        boolean temp = false;
        Pattern p=Pattern.compile("[\u4e00-\u9fa5]"); 
        Matcher m=p.matcher(str); 
        if(m.find()){ 
            temp =  true;
        }
        return temp;
    }
}
