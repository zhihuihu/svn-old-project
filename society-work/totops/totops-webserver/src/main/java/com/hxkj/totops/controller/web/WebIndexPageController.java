package com.hxkj.totops.controller.web;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxkj.totops.core.config.EnumConfig;
import com.hxkj.totops.core.utils.PageReturnUtils;
import com.hxkj.totops.entity.IndexPage;
import com.hxkj.totops.service.inter.IIndexPageService;

/**
 * @ClassName: WebIndexPageController 
 * @Description: 主页的查询控制器
 * @author huzhihui_c@qq.com
 * @date 2016年8月30日 下午1:19:52
 */
@Controller
@RequestMapping(value="web/indexPage")
public class WebIndexPageController {

	private static final Logger logger = LoggerFactory.getLogger(WebIndexPageController.class);
	
	@Autowired
	private IIndexPageService iIndexPageService;
	
	/**
	 * @Title: selectMainImageList 
	 * @Description:     获取主页的4张图片的接口
	 * @return
	 * @throws Exception   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午12:48:56
	 */
	@RequestMapping(value="selectMainImageList")
	@ResponseBody
	public Map<String,Object> selectMainImageList() throws Exception{
		logger.info("-----获取主页的4张图片");
		IndexPage indexPage = new IndexPage();
		indexPage.setIndexPageType(EnumConfig.INDEX_PAGE_TYPE_MAIN.getIndex());
		List<IndexPage> indexPages = iIndexPageService.selectByAttribute(indexPage);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, indexPages);
	}
	
	/**
	 * @Title: selectMidInfo 
	 * @Description:     获取中间的简介
	 * @return   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午1:10:59
	 */
	@RequestMapping(value="selectMidInfo")
	@ResponseBody
	public Map<String,Object> selectMidInfo() throws Exception{
		logger.info("-----获取主页中间的介绍信息");
		IndexPage indexPage = new IndexPage();
		indexPage.setIndexPageType(EnumConfig.INDEX_PAGE_TYPE_MID.getIndex());
		List<IndexPage> indexPages = iIndexPageService.selectByAttribute(indexPage);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, indexPages);
	}
	
	/**
	 * @Title: selectBottomList 
	 * @Description:     获取底部的图片的列表
	 * @return   
	 * @return Map<String,Object>    
	 * @author huzhihui_c@qq.com
	 * @date 2016年8月30日 下午1:10:59
	 */
	@RequestMapping(value="selectBottomList")
	@ResponseBody
	public Map<String,Object> selectBottomList() throws Exception{
		logger.info("-----获取主页底部的图片的列表");
		IndexPage indexPage = new IndexPage();
		indexPage.setIndexPageType(EnumConfig.INDEX_PAGE_TYPE_BOTTOM.getIndex());
		List<IndexPage> indexPages = iIndexPageService.selectByAttribute(indexPage);
		return PageReturnUtils.formatNormal("", PageReturnUtils.MSG_CODE_000000, PageReturnUtils.MSG_STATE_TRUE, indexPages);
	}
}
