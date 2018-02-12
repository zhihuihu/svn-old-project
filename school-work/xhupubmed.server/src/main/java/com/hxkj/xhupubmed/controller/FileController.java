package com.hxkj.xhupubmed.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.xhupubmed.core.utils.Constant;
import com.hxkj.xhupubmed.core.utils.FileUtils;
import com.hxkj.xhupubmed.core.utils.PageBeanUtils;
import com.hxkj.xhupubmed.entity.pojo.FileBean;

/** 
 * ClassName:FileController
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年4月18日 下午8:40:04 
 * @version  1.0 
 * @since    JDK 1.8      
 */
@Controller
@RequestMapping(value="fileUpload")
public class FileController {

	@RequestMapping(value="uploadFile",method=RequestMethod.POST)
	@ResponseBody
	private Object uploadFile(String fileBase64String,String fileName) throws Exception{
		FileUtils.decoderBase64File(fileBase64String, Constant.FILE_URL, fileName);
		return PageBeanUtils.formatForNormalTrue("", "上传成功");
	}
	
	@RequestMapping(value="uploadFileObject",method=RequestMethod.POST)
	@ResponseBody
	private Object uploadFileObject(@RequestBody FileBean fileBean) throws Exception{
		FileUtils.decoderBase64File(fileBean.getFileBase64String(), Constant.FILE_URL, fileBean.getFileName());
		return PageBeanUtils.formatForNormalTrue("", "上传成功");
	}
}
