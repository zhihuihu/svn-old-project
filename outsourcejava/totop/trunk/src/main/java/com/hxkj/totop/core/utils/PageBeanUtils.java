package com.hxkj.totop.core.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huzhihui on 2016/4/25.
 */
public class PageBeanUtils {
    private static final String MSGCODE = "msgCode";

    private static final String MSG = "msg";

    private static final String STATE ="state";

    private static final String CURRENTPAGE ="currentPage";

    private static final String LINESIZE ="lineSize";

    private static final String PAGECOUNT ="pageCount";

    private static final String SESSIONID = "token";

    private static final boolean STATETRUE = true;

    private static final boolean STATEFALSE = false;

    private static final int CODE_200 = 200;

    private static final int code_500 = 500;

    /**
     *
     * formatForPageTrue:
     * TODO: 正常返回数据
     * @param list
     * @param currentPage
     * @param lineSize
     * @param pageCount
     * @return:
     * @author huzhihui
     * date: 2016年1月20日 上午11:03:54
     * @since JDK 1.8
     */
    public static Map<String,Object> formatForPageTrue(Object list,int currentPage,int lineSize,int pageCount){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put(MSGCODE, CODE_200);
        returnMap.put(STATE, STATETRUE);
        returnMap.put(MSG, list);
        returnMap.put(CURRENTPAGE, currentPage);
        returnMap.put(LINESIZE, lineSize);
        returnMap.put(PAGECOUNT, pageCount);
        return returnMap;
    }

    /**
     *
     * formatForPageFalse:
     * TODO:   返回错误的数据，获取数据失败
     * @param list
     * @param currentPage
     * @param lineSize
     * @param pageCount
     * @return:
     * @author huzhihui
     * date: 2016年1月20日 上午11:04:47
     * @since JDK 1.8
     */
    public static Map<String,Object> formatForPageFalse(Object list,int currentPage,int lineSize,int pageCount){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put(MSGCODE, CODE_200);
        returnMap.put(STATE, STATEFALSE);
        returnMap.put(MSG, list);
        returnMap.put(CURRENTPAGE, currentPage);
        returnMap.put(LINESIZE, lineSize);
        returnMap.put(PAGECOUNT, pageCount);
        return returnMap;
    }


    public static Map<String,Object> formatForNormalTrue(String sessionId,Object obj){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put(SESSIONID, sessionId);
        returnMap.put(MSGCODE, CODE_200);
        returnMap.put(STATE, STATETRUE);
        returnMap.put(MSG, obj);
        return returnMap;
    }

    public static Map<String,Object> formatForNormalFalse(String sessionId,Object obj){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put(SESSIONID, sessionId);
        returnMap.put(MSGCODE, CODE_200);
        returnMap.put(STATE, STATEFALSE);
        returnMap.put(MSG, obj);
        return returnMap;
    }

    public static Map<String,Object> formatForError(String sessionId,Object obj){
        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put(SESSIONID, sessionId);
        returnMap.put(MSGCODE, code_500);
        returnMap.put(STATE, STATEFALSE);
        returnMap.put(MSG, obj);
        return returnMap;
    }


    public static int getPageCount(int lineCount,int lineSize){
        if(lineCount==0){
            return 0;
        }
        return lineCount % lineSize == 0 ? lineCount / lineSize : lineCount / lineSize + 1;
    }
}
