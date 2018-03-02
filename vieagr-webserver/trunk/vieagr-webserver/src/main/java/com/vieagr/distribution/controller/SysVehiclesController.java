package com.vieagr.distribution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.Base64FileUtils;
import com.vieagr.distribution.base.util.PropertiesUtils;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SysVehicles;
import com.vieagr.distribution.service.inter.ISysVehiclesService;

/**
 * 送货车辆控制层
 * @author master
 *
 */
@Controller
@RestController
@RequestMapping(value = "sysVehicles")
public class SysVehiclesController {

	@Autowired
	private ISysVehiclesService sysVehiclesService;
	
	/**
	 * 车辆--新增
	 * @Title: sysVehiclesAdd 
	 * @Description:     
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 上午10:13:01
	 */
	@RequestMapping(value="sysVehiclesAdd",method=RequestMethod.POST)
	public Object sysVehiclesAdd(String jsonStr) throws Exception{
		SysVehicles sysVehicles = Utils.jsonStrToObject(jsonStr, SysVehicles.class);
		return sysVehiclesService.sysVehiclesAdd(sysVehicles);
	}
	
	/**
	 * 车辆--列表查询
	 * @Title: selectSysVehiclesList 
	 * @Description:     
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 上午11:37:03
	 */
	@RequestMapping(value="selectSysVehiclesList",method=RequestMethod.POST)
	public Object selectSysVehiclesList(String jsonStr) throws Exception{
		SysVehicles sysVehicles = Utils.jsonStrToObject(jsonStr, SysVehicles.class);
		return sysVehiclesService.selectSysVehiclesList(sysVehicles);
	}
	
	/**
	 * 车辆--改变启用禁用状态
	 * @Title: updateSysVehiclesState 
	 * @Description:     
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 上午11:52:01
	 */
	@RequestMapping(value="updateSysVehiclesState",method=RequestMethod.POST)
	public Object updateSysVehiclesState(String jsonStr) throws Exception{
		SysVehicles sysVehicles = Utils.jsonStrToObject(jsonStr, SysVehicles.class);
		SysVehicles sysVehiclesCheck = sysVehiclesService.selectByPrimaryKey(sysVehicles.getSysVehiclesId());
		String msg = "";
		if(sysVehiclesCheck.getSysVehiclesState().equals(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex())){
			sysVehicles.setSysVehiclesState(EnumConfig.SYSTEM_UNIFIED_STATE_END_USING.getIndex());
			msg = Constant.FORBIDDEN_VEHICLES_SUCCESS;
		}else{
			sysVehicles.setSysVehiclesState(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex());
			msg = Constant.START_VEHICLES_SUCCESS;
		}
		int flg = sysVehiclesService.updateByPrimaryKeySelective(sysVehicles);
		if(flg <= 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, msg);
	}
	
	/**
	 * 车辆--修改所有信息
	 * @Title: updateSysVehicles 
	 * @Description:     
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 上午11:59:16
	 */
	@RequestMapping(value="updateSysVehicles",method=RequestMethod.POST)
	public Object updateSysVehicles(String jsonStr) throws Exception{
		SysVehicles sysVehicles = Utils.jsonStrToObject(jsonStr, SysVehicles.class);
		if(!Utils.isMobile(sysVehicles.getSysVehiclesRegisterMobile())){//判断手机号码是否正确
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.ADD_VEHICLES_FOR_PHONE_NUMBER_ERROR);
		}
		sysVehicles.setSysVehiclesImgUrl(Base64FileUtils.base64ToImageFile(sysVehicles.getSysVehiclesImgUrl(), 
				PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		int flg = sysVehiclesService.updateByPrimaryKeySelective(sysVehicles);
		if(flg <= 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.RESPONSE_MESSAGE_SUCCESS);
	}
	
	/**
	 * 车辆--通过主键查询
	 * @Title: selectByPrimaryKey 
	 * @Description:     
	 * @param sysVehiclesId
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 下午12:53:12
	 */
	@RequestMapping(value="selectByPrimaryKey",method=RequestMethod.POST)
	public Object selectByPrimaryKey(String sysVehiclesId) throws Exception{
		SysVehicles sysVehicles = sysVehiclesService.selectByPrimaryKey(sysVehiclesId);
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, sysVehicles);
	}
	
	/**
	 * @Title: selectListToOption 
	 * @Description:     查询车辆列表为option填充
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月31日 下午3:31:17
	 */
	@RequestMapping(value="selectListToOption",method=RequestMethod.GET)
	public Object selectListToOption() throws Exception{
		List<SysVehicles> list = sysVehiclesService.selectByAttributeAnd(new SysVehicles());
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, list);
	}
}
