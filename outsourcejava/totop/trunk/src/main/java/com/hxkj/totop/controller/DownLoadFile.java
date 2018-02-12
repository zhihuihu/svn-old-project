package com.hxkj.totop.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;

/**
 * Created by huzhihui on 2016/4/28.
 */
@Controller
@RequestMapping(value = "downLoadFile")
public class DownLoadFile {


    @RequestMapping("download")
    public ResponseEntity<byte[]> download() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "dict.java");
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File("C:\\Users\\huzhihui\\IdeaProjects\\totop\\src\\main\\java\\com\\hxkj\\totop\\core\\utils\\Constant.java")),
                headers, HttpStatus.CREATED);
    }
}
