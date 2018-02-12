package com.vieagr.distribution.base.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

/**
 * base64文件操作
 * 
 * @author huzhihui
 *
 */
public class Base64FileUtils {

	public static String imageFileToBase64(File file) throws Exception {
		byte[] data = null;
		InputStream in = new FileInputStream(file);
		data = new byte[in.available()];
		in.read(data);
		in.close();
		return Base64.encodeBase64String(data);
	}

	/**
	 * 
	 * @param base64String
	 * @param fileUrlPre	文件物理路径前缀D:/vieagrfiles
	 * @param imageUrl	图片路径 image/201609181474209880226291
	 * @return	images/3123131.jpg
	 * @throws Exception
	 */
	public static String base64ToImageFile(String base64String, String fileUrlPre, String imageUrl) throws Exception {
		if(base64String == null || base64String.length() <100){
			return null;
		}
		int endIndex = base64String.indexOf("base64,");
		base64String = base64String.substring(endIndex + 7);
		byte[] bytes = Base64.decodeBase64(base64String);
		for (int i = 0; i < bytes.length; ++i) {
			if (bytes[i] < 0) {// 调整异常数据
				bytes[i] += 256;
			}
		}
		OutputStream out = new FileOutputStream(fileUrlPre + '/' + imageUrl);
		out.write(bytes);
		out.flush();
		out.close();
		return imageUrl;
	}
}
