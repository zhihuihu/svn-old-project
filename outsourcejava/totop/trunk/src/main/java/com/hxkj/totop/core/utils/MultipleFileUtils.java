package com.hxkj.totop.core.utils;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by huzhihui on 2016/4/25.
 */
public class MultipleFileUtils {
    /**
     *
     * @Title: uploadOneMultipleFile
     * @Description: TODO    单文件上传
     * @param request
     * @param fileProUrl	文件保存路径
     * @param fileProName	文件保存名称前部
     * @param newName	是否生成新的文件名
     * @throws Exception
     * @return String    文件路径URL
     * @author huzhihui_c@qq.com
     * @date 2016年4月19日 下午1:37:27
     */
    public static String uploadOneMultipleFile(HttpServletRequest request, String fileProUrl, String fileProName, boolean newName) throws Exception{
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iter=multipartRequest.getFileNames();
        MultipartFile inputFile = multipartRequest.getFile(iter.next());
        String realName = inputFile.getOriginalFilename();
        if(newName == true){//是否生成新的文件名
            String ext = realName.substring(realName.lastIndexOf("."));
            realName = fileProName + getNewFileName() + ext;
        }else{
            realName = fileProName + realName;
        }
        File file = makeDirsAndCreateFileName(fileProUrl,realName);
        inputFile.transferTo(file);
        String realUrl = Constant.IMAGE_SERVER_URL + fileProName + realName;
        return realUrl;
    }

    /**
     * 通过 input的name来得到图片的上传后的路径
     * @param request
     * @param fileProUrl    服务器访问路径
     * @param fileProName   新文件名前缀
     * @param newName   是否生成新名称
     * @param inputNameMap 一个map,包装了前台传来的file对象的name
     * @return
     * @throws Exception
     */
    public static Map<String,String> uploadMultipleFileByInputName(HttpServletRequest request, String fileProUrl, String fileProName, boolean newName,Map<String,String> inputNameMap) throws Exception{
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iter=multipartRequest.getFileNames();
        while (iter.hasNext()){
            MultipartFile inputFile = multipartRequest.getFile(iter.next());
            for(Map.Entry<String,String> entry : inputNameMap.entrySet()){
                if(entry.getKey().equals(inputFile.getName())){
                    String realName = inputFile.getOriginalFilename();
                    if(newName == true){//是否生成新的文件名
                        String ext = realName.substring(realName.lastIndexOf("."));
                        realName = fileProName + getNewFileName() + ext;
                    }else{
                        realName = fileProName + realName;
                    }
                    File file = makeDirsAndCreateFileName(fileProUrl,realName);
                    inputFile.transferTo(file);
                    String realUrl = Constant.IMAGE_SERVER_URL + fileProName + realName;
                    entry.setValue(realUrl);
                }
            }
        }
        return inputNameMap;
    }


    /**
     *
     * @Title: uploadManyMultipleFile
     * @Description: TODO    上传多文件
     * @param request
     * @param fileProUrl	文件保存路径文件夹
     * @param fileProName	文件名前部
     * @param newName	是否保存新名称
     * @throws Exception
     * @return List<String>    上传文件的路径List
     * @author huzhihui_c@qq.com
     * @date 2016年4月19日 下午1:43:48
     */
    public static List<String> uploadManyMultipleFile(HttpServletRequest request, String fileProUrl, String fileProName, boolean newName) throws Exception{
        List<String> realUrls = new ArrayList<>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iter=multipartRequest.getFileNames();
        while(iter.hasNext()){
            MultipartFile inputFile = multipartRequest.getFile(iter.next());
            String realName = inputFile.getOriginalFilename();
            if(newName == true){//是否生成新的文件名
                String ext = realName.substring(realName.lastIndexOf("."));
                realName = fileProName + getNewFileName() + ext;
            }else{
                realName = fileProName + realName;
            }
            File file = makeDirsAndCreateFileName(fileProUrl,realName);
            inputFile.transferTo(file);
            String realUrl = fileProUrl + fileProName + realName;
            realUrls.add(realUrl);
        }
        return realUrls;
    }

    /**
     *
     * @Title: makeDirsAndCreateFileName
     * @Description: TODO    创建为空的文件,并没有占据空间
     * @param path 在系统存储路径
     * @param fileName 文件名称
     * @return File    为空的文件
     * @author huzhihui_c@qq.com
     * @date 2016年4月19日 下午1:00:55
     */
    private static File makeDirsAndCreateFileName(String path,String fileName){
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        file = new File(path,fileName);
        return file;
    }

    /**
     *
     * @Title: getNewFileName
     * @Description: TODO    取得新文件新名称
     * @throws Exception
     * @return String    新文件名称
     * @author huzhihui_c@qq.com
     * @date 2016年4月19日 下午1:28:14
     */
    private static String getNewFileName() throws Exception{
        TimeUnit.MILLISECONDS.sleep(1);
        String newFileName = String.valueOf(System.currentTimeMillis());
        Random random = new Random();
        newFileName +=(random.nextInt(900)+100);
        return newFileName;
    }
}
