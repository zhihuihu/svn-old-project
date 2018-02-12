package com.hxkj.photocms.core.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;

public class ImageUtils {

	public static String encodeImgageToBase64(URL imageUrl) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	    ByteArrayOutputStream outputStream = null;
	    try {
	      BufferedImage bufferedImage = ImageIO.read(imageUrl);
	      outputStream = new ByteArrayOutputStream();
	      ImageIO.write(bufferedImage, "jpg", outputStream);
	    } catch (MalformedURLException e1) {
	      e1.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return Base64.encodeBase64String(outputStream.toByteArray());
	  }
	
	/**
	   * 将本地图片进行Base64位编码
	   * 
	   * @param imgUrl
	   *			图片的url路径，如http://.....xx.jpg
	   * @return
	   */
	  public static String encodeImgageToBase64(File imageFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
	    ByteArrayOutputStream outputStream = null;
	    try {
	      BufferedImage bufferedImage = ImageIO.read(imageFile);
	      outputStream = new ByteArrayOutputStream();
	      ImageIO.write(bufferedImage, "jpg", outputStream);
	    } catch (MalformedURLException e1) {
	      e1.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    // 对字节数组Base64编码
	    return Base64.encodeBase64String(outputStream.toByteArray());
	  }
	  
	  /**
	   * 将Base64位编码的图片进行解码，并保存到指定目录
	   * 
	   * @param base64
	   *			base64编码的图片信息
	   * @return
	   */
	  public static void decodeBase64ToImage(String base64, String path,
	      String imgName) {
	    try {
	      FileOutputStream write = new FileOutputStream(new File(path
	          + imgName));
	      byte[] decoderBytes = Base64.decodeBase64(base64);
	      write.write(decoderBytes);
	      write.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
}
