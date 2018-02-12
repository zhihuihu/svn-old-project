package com.vieagr.distribution.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SysProductType;
import com.vieagr.distribution.service.inter.ISysProductTypeService;

/**
 * 商品类型控制层
 * @author master
 *
 */
@RequestMapping(value = "productType")
@RestController
public class SysProductTypeController {
	
	@Autowired
	private ISysProductTypeService sysProductTypeService;
	
	/**
	 * 商品单位列表查询
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "selectProductTypeList", method = RequestMethod.POST)
	public Object selectProductTypeList(String jsonStr) throws Exception{
		SysProductType sysProductType = Utils.jsonStrToObject(jsonStr, SysProductType.class);
		sysProductType.setSysProductTypeName(sysProductType.getSearchName());
		return sysProductTypeService.selectProductTypeList(sysProductType);
	}
	
	/**
	 * 增加一条商品类型
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "saveProductType", method = RequestMethod.POST)
	public Object saveProductType(String jsonStr) throws Exception{
		SysProductType sysProductType = Utils.jsonStrToObject(jsonStr, SysProductType.class);
		sysProductType.setSysProductTypeId(UUID.randomUUID().toString());
		sysProductType.setSysProductTypeCreateTime(Utils.getNowTime());
		if(sysProductType.getSysProductTypeName() == null || sysProductType.getSysProductTypeName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "商品类型名称为空，增加失败");
		}
		List<SysProductType> list = sysProductTypeService.selectByAttributeAnd(sysProductType);
		if(list != null && list.size() != 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "商品类型名称已被添加，增加失败");
		}
		sysProductTypeService.insertSelective(sysProductType);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 修改一条商品类型
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "updateProductType", method = RequestMethod.POST)
	public Object updateProductType(String jsonStr) throws Exception{
		SysProductType sysProductType = Utils.jsonStrToObject(jsonStr, SysProductType.class);
		if(sysProductType.getSysProductTypeName() == null || sysProductType.getSysProductTypeName().trim().equals("")){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "商品类型名称为空，增加失败");
		}
		/*List<SysProductType> list = sysProductTypeService.selectByAttributeAnd(sysProductType);
		if(list != null && list.size() != 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, "商品类型名称已被添加，增加失败");
		}*/
		sysProductTypeService.updateByPrimaryKeySelective(sysProductType);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * @Title: selectByPrimaryKey 
	 * @Description:     通过主键查询
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月22日 上午10:40:10
	 */
	@RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST)
	public Object selectByPrimaryKey(String jsonStr) throws Exception{
		SysProductType sysProductType = Utils.jsonStrToObject(jsonStr, SysProductType.class);
		sysProductType = sysProductTypeService.selectByPrimaryKey(sysProductType.getSysProductTypeId());
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, sysProductType);
	}
	
	/**
	 * @Title: updateSysProductTypeState 
	 * @Description:     启用禁用状态更新
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月22日 上午10:42:57
	 */
	@RequestMapping(value = "updateSysProductTypeState", method = RequestMethod.POST)
	public Object updateSysProductTypeState(String jsonStr) throws Exception{
		SysProductType sysProductType = Utils.jsonStrToObject(jsonStr, SysProductType.class);
		SysProductType sysProductTypeCheck = sysProductTypeService.selectByPrimaryKey(sysProductType.getSysProductTypeId());
		String msg = "";
		if(sysProductTypeCheck.getSysProductTypeState().equals(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex())){
			sysProductType.setSysProductTypeState(EnumConfig.SYSTEM_UNIFIED_STATE_END_USING.getIndex());
			msg = "禁用成功";
		}else{
			sysProductType.setSysProductTypeState(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex());
			msg = "启用成功";
		}
		int flg = sysProductTypeService.updateByPrimaryKeySelective(sysProductType);
		if(flg <= 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, msg);
	}
	 
	/**
	 * @Title: selectProductTypeListForChoose 
	 * @Description:     选择的列表填充
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年11月22日 下午2:28:39
	 */
	@RequestMapping(value = "selectProductTypeListForChoose", method = RequestMethod.POST)
	public Object selectProductTypeListForChoose() throws Exception{
		SysProductType sysProductType = new SysProductType();
		sysProductType.setPageSize(100);
		sysProductType.setSysProductTypeState(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex());
		return sysProductTypeService.selectProductTypeList(sysProductType);
	}
}
