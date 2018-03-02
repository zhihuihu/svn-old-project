package com.vieagr.distribution.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.util.MultipleFileUtils;
import com.vieagr.distribution.base.util.PropertiesUtils;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SysIndex;
import com.vieagr.distribution.service.inter.ISysIndexService;

/**
 * 主页控制层
 * @author huzhihui
 *
 */
@RestController
@RequestMapping(value="sysIndex")
public class SysIndexController {

	@Autowired
	private ISysIndexService iSysIndexService;
	
	/**
	 * 通过类型查询主页图片
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="selectImagesByType")
	public Object selectImagesByType(String jsonStr) throws Exception{
		SysIndex sysIndex = Utils.jsonStrToObject(jsonStr, SysIndex.class);
		sysIndex.setOrderByString("order by sys_index_number,sys_index_create_time asc");
		PageHelper.startPage(sysIndex.getCurrentPage(), sysIndex.getPageSize());
		List<SysIndex> sysIndexs = iSysIndexService.selectByAttributeAnd(sysIndex);
		PageInfo<SysIndex> pageInfo = new PageInfo<>(sysIndexs);
		return ReturnUtils.forNoramlPage(Constant.RESPONSE_CODE_SUCCESS, sysIndexs, 
				pageInfo.getPageNum(), pageInfo.getPageSize(), pageInfo.getPages(), (int)pageInfo.getTotal());
	}
	
	/**
	 * 更新主页图片
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="createOrUpdateIndexImage")
	public Object createOrUpdateIndexImage(HttpServletRequest request) throws Exception{
		boolean createFlg = false;
		String jsonStr = request.getParameter("jsonStr");
		SysIndex sysIndex = Utils.jsonStrToObject(jsonStr, SysIndex.class);
		if(null == sysIndex) {
			sysIndex = new SysIndex();
		}
		if(StringUtils.isEmpty(sysIndex.getSysIndexId())) {
			createFlg = true;
			sysIndex.setSysIndexId(Utils.createPrimaryKey());
		}
		String imageUrl = MultipleFileUtils.uploadOneMultipleFile(request, PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), "image", true);
		sysIndex.setSysIndexImageUrl(imageUrl);
		sysIndex.setSysIndexUpdateTime(Utils.getNowTime());
		if(createFlg) {
			SysIndex sysIndexSearch = new SysIndex();
			sysIndexSearch.setSysIndexType(sysIndex.getSysIndexType());
			List<SysIndex> sysIndexs = iSysIndexService.selectByAttributeAnd(sysIndexSearch);
			if(CollectionUtils.isEmpty(sysIndexs)) {
				sysIndex.setSysIndexNumber(1);
			}else {
				sysIndex.setSysIndexNumber(sysIndexs.get(sysIndexs.size()-1).getSysIndexNumber() + 1);
			}
			sysIndex.setSysIndexCreateTime(Utils.getNowTime());
			sysIndex.setSysIndexUpdateTime(Utils.getNowTime());
			iSysIndexService.insertSelective(sysIndex);
		}
		iSysIndexService.updateByPrimaryKeySelective(sysIndex);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 通过主键查询信息
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="selectByPrimaryKey")
	public Object selectByPrimaryKey(String jsonStr) throws Exception{
		SysIndex sysIndex = Utils.jsonStrToObject(jsonStr, SysIndex.class);
		sysIndex = iSysIndexService.selectByPrimaryKey(sysIndex.getSysIndexId());
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, sysIndex);
	}
	
	/**
	 * 删除
	 * @param jsonStr
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="deleteByPrimaryKey")
	public Object deleteByPrimaryKey(String jsonStr) throws Exception{
		SysIndex sysIndex = Utils.jsonStrToObject(jsonStr, SysIndex.class);
		iSysIndexService.deleteByPrimaryKey(sysIndex.getSysIndexId());
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
}
