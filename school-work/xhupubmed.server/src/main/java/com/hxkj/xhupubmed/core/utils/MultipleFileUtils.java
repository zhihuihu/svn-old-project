package com.hxkj.xhupubmed.core.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class MultipleFileUtils {

	/**
	 * 
	* @Title: uploadOneMultipleFile 
	* @Description: TODO    单文件上传
	* @param request	
	* @param fileProUrl	文件保存路径
	* @param fileProServerUrl	文件服务器访问路径前缀
	* @param fileProName	文件保存名称前部
	* @param newName	是否生成新的文件名
	* @throws Exception   
	* @return String    文件路径URL
	* @author huzhihui_c@qq.com
	* @date 2016年4月19日 下午1:37:27
	 */
	public static String uploadOneMultipleFile(HttpServletRequest request,String fileProUrl,String fileProServerUrl,String fileProName,boolean newName) throws Exception{
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
		String realUrl = fileProServerUrl + "/" + fileProName + realName;
		return realUrl;
	}

	
	/**
	 * 
	* @Title: uploadManyMultipleFile 
	* @Description: TODO    上传多文件
	* @param request
	* @param fileProUrl	文件保存路径文件夹
	* @param fileProServerUrl	文件服务器访问路径前缀
	* @param fileProName	文件名前部
	* @param newName	是否保存新名称
	* @throws Exception   
	* @return List<String>    上传文件的路径List
	* @author huzhihui_c@qq.com
	* @date 2016年4月19日 下午1:43:48
	 */
	public static List<String> uploadManyMultipleFile(HttpServletRequest request,String fileProUrl,String fileProServerUrl,String fileProName,boolean newName) throws Exception{
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
			String realUrl = fileProServerUrl + "/" + fileProName + realName;
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
	public static void main(String[] args) throws Exception {
		System.out.println("fsdfsf.exe".substring("fsdfsf.exe".indexOf(".")));
		for(int i=0;i<10;i++){
			System.out.println(getNewFileName());
		}
		
	}
}
