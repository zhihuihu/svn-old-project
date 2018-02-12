package com.hxkj.xhupubmed.core.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

/**
 * ClassName:FileUtils Function:
 * 
 * @author huzhihui_c@qq.com Date: 2016年4月18日 下午6:57:32
 * @version 1.0
 * @since JDK 1.8
 */
public class FileUtils {

	/**
	 * 
	 * @Function: 把文件转为base64编码
	 * @Title: encodeBase64File
	 * @param path
	 * @return
	 * @throws Exception
	 *             String
	 * @author huzhihui_c@qq.com
	 * @date 2016年4月18日 下午8:05:29
	 * @Since JDK 1.8
	 */
	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return Base64.encodeBase64String(buffer);
	}
	
	/**
	 * 
	* @Function: 传入文件 转为base64编码
	* @Title: encodeBase64File  
	* @param file
	* @return
	* @throws Exception   
	* String    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月18日 下午8:13:11
	* @Since JDK 1.8
	 */
	public static String encodeBase64File(File file) throws Exception {
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return Base64.encodeBase64String(buffer);
	}

	/**
	 * 
	* @Function: base64编码转文件
	* @Title: decoderBase64File  
	* @param base64Code
	* @param targetPath 文件路径 最后不要加"/"
	* @param fileName 文件名称
	* @throws Exception   
	* void    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月18日 下午8:36:50
	* @Since JDK 1.8
	 */
	public static void decoderBase64File(String base64Code, String targetPath,String fileName) throws Exception {
		createFilePath(targetPath,fileName);
		byte[] buffer = Base64.decodeBase64(base64Code);
		FileOutputStream out = new FileOutputStream(targetPath+"/"+fileName);
		out.write(buffer);
		out.close();
	}

	
	/**
	 * 
	* @Function: 把图片转为base64 编码
	* @Title: encodeImgageToBase64  
	* @param imageUrl
	* @return
	* @throws Exception   
	* String    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月18日 下午8:37:23
	* @Since JDK 1.8
	 */
	public static String encodeImgageToBase64(URL imageUrl) throws Exception {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		ByteArrayOutputStream outputStream = null;
		BufferedImage bufferedImage = ImageIO.read(imageUrl);
		outputStream = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "jpg", outputStream);
		return Base64.encodeBase64String(outputStream.toByteArray());
	}

	/**
	 * 将本地图片进行Base64位编码
	 * 
	 * @param imgUrl
	 *            图片的url路径，如http://.....xx.jpg
	 * @return
	 */
	public static String encodeImgageToBase64(File imageFile) throws Exception {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		ByteArrayOutputStream outputStream = null;
		BufferedImage bufferedImage = ImageIO.read(imageFile);
		outputStream = new ByteArrayOutputStream();
		ImageIO.write(bufferedImage, "jpg", outputStream);
		// 对字节数组Base64编码
		return Base64.encodeBase64String(outputStream.toByteArray());
	}

	/**
	 * 将Base64位编码的图片进行解码，并保存到指定目录
	 * 
	 * @param base64
	 *            base64编码的图片信息
	 * @return
	 */
	public static void decodeBase64ToImage(String base64, String path, String imgName) throws Exception {
		FileOutputStream write = new FileOutputStream(new File(path + imgName));
		byte[] decoderBytes = Base64.decodeBase64(base64);
		write.write(decoderBytes);
		write.close();
	}
	
	/**
	 * 
	* @Function: 创建文件或者路径
	* @Title: createFilePath  
	* @param filePath   
	* void    
	* @author huzhihui_c@qq.com   
	* @date 2016年4月18日 下午8:30:18
	* @Since JDK 1.8
	 */
	private static void createFilePath(String filePath,String fileName){
		File file = new File(filePath);
		if(!file.exists()){
			file.mkdirs();
		}
	}
}
