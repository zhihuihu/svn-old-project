package com.hxkj.xhupubmed.controller.client;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hxkj.xhupubmed.core.utils.Constant;
import com.hxkj.xhupubmed.core.utils.PropertiesUtils;

/** 
 * ClassName:FileDownloadController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年5月3日 上午10:10:19 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="client/download")
public class FileDownloadController {
	
	@RequestMapping("downloadFile")
    public ResponseEntity<byte[]> downloadFile(String downloadUrl) throws IOException {
    	String realFileUrl = PropertiesUtils.getPropertiesValue(Constant.FILE_URL) + downloadUrl.substring(47);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", downloadUrl.substring(36));
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(realFileUrl)),
                headers, HttpStatus.CREATED);
    }
    
    @RequestMapping("downloadImage")
    public ResponseEntity<byte[]> downloadImage(String downloadUrl) throws IOException {
    	String realFileUrl = PropertiesUtils.getPropertiesValue(Constant.FILE_URL) + downloadUrl.substring(48);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", downloadUrl.substring(37));
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(realFileUrl)),
                headers, HttpStatus.CREATED);
    }
    
    public static void main(String[] args) {
    	String downloadUrl = "http://192.168.31.219:8080/xhupubmedfiles/files/1462239035450421.txt";
    	System.out.println(downloadUrl.substring(48));
	}
}
