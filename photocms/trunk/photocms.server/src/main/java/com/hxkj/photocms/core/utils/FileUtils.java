package com.hxkj.photocms.core.utils;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hxkj.photocms.entity.Special;
import com.hxkj.photocms.entity.SpecialType;

/** 
 * Project Name:photocms.server 
 * ClassName:FileUtils
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月18日 下午4:48:49 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class FileUtils {

	public static String uploadImages(HttpServletRequest request,SpecialType specialType,Special special){
		String specialTypePath = specialType.getSpecialTypeCuid().substring(0, 13)+specialType.getSpecialTypeCuid().substring(21);
		String specialPath = special.getSpecialCuid().substring(0, 7)+special.getSpecialCuid().substring(16);
		String pathPre = request.getSession().getServletContext().getRealPath("");
		String realPath = pathPre+"imgs/"+specialTypePath+"/"+specialPath;
		String imgUrl = "imgs/"+specialTypePath+"/"+specialPath+"/";
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile inputFile = null;
		Iterator<String> iter=multipartRequest.getFileNames();
		inputFile=multipartRequest.getFile(iter.next());
		if (!(inputFile.getOriginalFilename() == null || "".equals(inputFile.getOriginalFilename()))) {
			imgUrl += getFile(inputFile, realPath);
			return imgUrl;
		}else{
			System.out.println("文件上传框出错，无法正确获取文件-----------------------------------");
			return imgUrl;
		}
	}
	
	private static String getFile(MultipartFile imgFile, String path) {
		
		String fileName = "";
		String imgUrl = "";
		fileName = TimeUtils.getImageNamePrefix();
		String realName = imgFile.getOriginalFilename();
		String ext = realName.substring(realName.lastIndexOf("."));
		fileName = fileName + ext;
		File file = makeDirsAndCreateFileName(path, fileName);
		try {
			imgFile.transferTo(file); // 保存上传的文件
			System.out.println("上传成功！");
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//传出图片名称
		imgUrl = fileName;
		return imgUrl;
	}
	
	private static File makeDirsAndCreateFileName(String path,String fileName){
		
		//url = "file:///"+path+"/"+fileName; //取得绝对路径
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
			System.out.println(path);
		}
		file = new File(path,fileName);
		return file;
	}
}
