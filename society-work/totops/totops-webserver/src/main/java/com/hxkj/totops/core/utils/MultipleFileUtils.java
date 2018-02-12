package com.hxkj.totops.core.utils;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class MultipleFileUtils {

	/**
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
	public static String uploadOneMultipleFile(HttpServletRequest request,String fileProUrl,boolean isFile,boolean isNewName) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iter=multipartRequest.getFileNames();
		if(!iter.hasNext()){
			System.out.println("-----没有获取到request中的文件信息，返回null");
			return null;
		}
		MultipartFile inputFile = multipartRequest.getFile(iter.next());
		String realName = inputFile.getOriginalFilename();
		if(isNewName == true){//是否生成新的文件名
			String ext = realName.substring(realName.lastIndexOf("."));
			realName = TimeUtils.getImageNamePrefix() + ext;
		}
		File file = makeDirsAndCreateFileName(fileProUrl,realName);
		inputFile.transferTo(file);
		//String realUrl = fileProUrl + "/" + realName;
		if(isFile == true){
			return "file/" + realName;
		}
		return "image/" + realName;
	}

	
	/**
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
	public static List<String> uploadManyMultipleFile(HttpServletRequest request,String fileProUrl,boolean isNewName) throws Exception{
		List<String> realUrls = new ArrayList<>();
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iter=multipartRequest.getFileNames();
		while(iter.hasNext()){
			MultipartFile inputFile = multipartRequest.getFile(iter.next());
			String realName = inputFile.getOriginalFilename();
			if(isNewName == true){//是否生成新的文件名
				String ext = realName.substring(realName.lastIndexOf("."));
				realName = TimeUtils.getImageNamePrefix() + ext;
			}
			File file = makeDirsAndCreateFileName(fileProUrl,realName);
			inputFile.transferTo(file);
			String realUrl = fileProUrl + "/" + realName;
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
	 * @Title: getFileRealName 
	 * @Description:    获取单个文件上传时候的原名称 
	 * @param request
	 * @return
	 * @throws Exception   
	 * @return String    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月26日 下午4:15:36
	 */
	public static String getOneFileRealName(HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iter=multipartRequest.getFileNames();
		if(!iter.hasNext()){
			System.out.println("-----没有获取到request中的文件信息，返回null");
			return null;
		}
		MultipartFile inputFile = multipartRequest.getFile(iter.next());
		String realName = inputFile.getOriginalFilename();
		return realName;
	}
	
	/**
	 * @Title: getFileSize 
	 * @Description:     获取单个上传文件的大小
	 * @return
	 * @throws Exception   
	 * @return int    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月26日 下午4:18:06
	 */
	public static Long getOneFileSize(HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iter=multipartRequest.getFileNames();
		if(!iter.hasNext()){
			System.out.println("-----没有获取到request中的文件信息，返回null");
			return 0l;
		}
		MultipartFile inputFile = multipartRequest.getFile(iter.next());
		return inputFile.getSize();
	}
	
	/**
	 * @Title: getOneFileExtName 
	 * @Description:    获取单个文件的扩展名 
	 * @param request
	 * @return
	 * @throws Exception   
	 * @return String    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月26日 下午4:22:46
	 */
	public static String getOneFileExtName(HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iter=multipartRequest.getFileNames();
		if(!iter.hasNext()){
			System.out.println("-----没有获取到request中的文件信息，返回null");
			return null;
		}
		MultipartFile inputFile = multipartRequest.getFile(iter.next());
		String realName = inputFile.getOriginalFilename();
		String ext = realName.substring(realName.lastIndexOf("."));
		return ext;
	}
	
	/**
	 * @Title: getOneFileThunbUrl 
	 * @Description:     获取单个文件的缩略图
	 * @param request
	 * @return
	 * @throws Exception   
	 * @return String    
	 * @author huzhihui_c@qq.com
	 * @date 2016年9月26日 下午4:28:47
	 */
	public static String getOneFileThunbUrl(HttpServletRequest request,String fileProUrl) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iter=multipartRequest.getFileNames();
		if(!iter.hasNext()){
			System.out.println("-----没有获取到request中的文件信息，返回null");
			return null;
		}
		MultipartFile inputFile = multipartRequest.getFile(iter.next());
		String realName = inputFile.getOriginalFilename();
		//获取扩展名
		String suffix = realName.substring(realName.lastIndexOf("."));
		System.out.println(inputFile.getInputStream());
		BufferedImage bufferedImage = ImageIO.read(inputFile.getInputStream());
		int originalWidth = bufferedImage.getWidth();
        int originalHeight = bufferedImage.getHeight();
        int width = 200;
        double scale = (double)originalWidth / (double)width;    // 缩放的比例
        int height =  (int)(originalHeight / scale);
        
        //真实cuid路径名称
        String fileUrl = TimeUtils.getImageNamePrefix() + suffix;
        String newPath = fileProUrl +"/"+ fileUrl;
        // 处理 png 背景变黑的问题
       if(suffix != null && (suffix.trim().toLowerCase().endsWith("png") || suffix.trim().toLowerCase().endsWith("gif"))){
           BufferedImage to= new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB); 
           Graphics2D g2d = to.createGraphics(); 
           to = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT); 
           g2d.dispose(); 
           
           g2d = to.createGraphics(); 
           Image from = bufferedImage.getScaledInstance(width, height, Image.SCALE_AREA_AVERAGING); 
           g2d.drawImage(from, 0, 0, null);
           g2d.dispose(); 
           
           ImageIO.write(to, suffix.substring(1), new File(newPath));
       }else{
           
           BufferedImage newImage = new BufferedImage(width, height, bufferedImage.getType());
           Graphics g = newImage.getGraphics();
           g.drawImage(bufferedImage, 0, 0, width, height, null);
           g.dispose();
           ImageIO.write(newImage, suffix.substring(1), new File(newPath));
       }
       return "image/" + fileUrl;
	}
}
