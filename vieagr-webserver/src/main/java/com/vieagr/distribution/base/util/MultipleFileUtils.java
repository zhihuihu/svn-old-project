package com.vieagr.distribution.base.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 上传文件工具类
 * @author huzhihui
 *
 */
public class MultipleFileUtils {
	/**
     * 单文件上传
     * @param request   HttpServletRequest
     * @param fileProUrl    文件保存路径
     * @param fileType   文件类型
     * @param isNewName 是否设置新名称
     * @return  文件名称
     * @throws Exception    异常
     */
    public static String uploadOneMultipleFile(HttpServletRequest request, String fileProUrl,
                                               String fileType,
                                               boolean isNewName) throws Exception {
        fileProUrl = fileProUrl + "/" + fileType;
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iter = multipartRequest.getFileNames();
        while (iter.hasNext()) {
            List<MultipartFile> inputFiles = multipartRequest.getFiles(iter.next());
            for (MultipartFile inputFile : inputFiles) {
                String realName = inputFile.getOriginalFilename();
                if (isNewName == true) {//是否生成新的文件名
                    String ext = realName.substring(realName.lastIndexOf("."));
                    realName = Utils.createPrimaryKey() + ext;
                }
                File file = makeDirsAndCreateFileName(fileProUrl, realName);
                inputFile.transferTo(file);
                String realUrl = fileType + "/" + realName;
                return realUrl;
            }
        }
        return null;
    }

    /**
     * 上传多文件
     * @param request   HttpServletRequest
     * @param fileProUrl    文件保存路径文件夹
     * @param fileType  文件类型
     * @param isNewName 是否设置新名称
     * @return  返回名称列表
     * @throws Exception    异常
     */
    public static List<String> uploadManyMultipleFile(HttpServletRequest request, String fileProUrl,
                                                      String fileType,
                                                      boolean isNewName) throws Exception {
        fileProUrl = fileProUrl + "/" + fileType;
        List<String> realUrls = new ArrayList<>();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Iterator<String> iter = multipartRequest.getFileNames();
        while (iter.hasNext()) {
            List<MultipartFile> inputFiles = multipartRequest.getFiles(iter.next());
            for (MultipartFile inputFile : inputFiles) {
                String realName = inputFile.getOriginalFilename();
                if (isNewName == true) {//是否生成新的文件名
                    String ext = realName.substring(realName.lastIndexOf("."));
                    realName = Utils.createPrimaryKey() + ext;
                }
                File file = makeDirsAndCreateFileName(fileProUrl, realName);
                inputFile.transferTo(file);
                String realUrl = fileType + "/" + realName;
                realUrls.add(realUrl);
            }
        }
        return realUrls;
    }

    /**
     * 创建为空的文件,并没有占据空间
     * @param path  在系统存储路径
     * @param fileName  文件名称
     * @return  File    为空的文件
     */
    private static File makeDirsAndCreateFileName(String path, String fileName) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(path, fileName);
        return file;
    }
}
