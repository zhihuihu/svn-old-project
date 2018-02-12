package com.vieagr.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vieagr.distribution.base.config.Constant;
import com.vieagr.distribution.base.config.EnumConfig;
import com.vieagr.distribution.base.util.Base64FileUtils;
import com.vieagr.distribution.base.util.PropertiesUtils;
import com.vieagr.distribution.base.util.ReturnUtils;
import com.vieagr.distribution.base.util.Utils;
import com.vieagr.distribution.entity.SysSender;
import com.vieagr.distribution.service.inter.ISysSenderService;

/**
 * 送货人控制层
 * @author master
 *
 */
@RestController
@RequestMapping(value = "sysSender")
public class SysSenderController {

	@Autowired
	private ISysSenderService sysSenderService;
	
	/**
	 * 送货人--增加一个
	 * @Title: sysSenderAdd 
	 * @Description:     
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 下午1:20:17
	 */
	@RequestMapping(value="sysSenderAdd",method=RequestMethod.POST)
	public Object sysSenderAdd(String jsonStr) throws Exception{
		SysSender sysSender = Utils.jsonStrToObject(jsonStr, SysSender.class);
		return sysSenderService.sysSenderAdd(sysSender);
	}
	
	/**
	 * 送货人--列表查询
	 * @Title: selectSysSenderList 
	 * @Description:     
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 下午1:36:44
	 */
	@RequestMapping(value="selectSysSenderList",method=RequestMethod.POST)
	public Object selectSysSenderList(String jsonStr) throws Exception{
		SysSender sysSender = Utils.jsonStrToObject(jsonStr, SysSender.class);
		return sysSenderService.selectSysSenderList(sysSender);
	}
	
	/**
	 * 送货人--通过主键查询
	 * @Title: selectByPrimaryKey 
	 * @Description:     
	 * @param sysSenderId
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 下午1:37:37
	 */
	@RequestMapping(value="selectByPrimaryKey",method=RequestMethod.POST)
	public Object selectByPrimaryKey(String sysSenderId) throws Exception{
		SysSender sysSender = sysSenderService.selectByPrimaryKey(sysSenderId);
		if(null == sysSender){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.FIND_ERROR);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, sysSender);
	}
	
	/**
	 * 送货人--修改启用禁用状态
	 * @Title: updateSysSenderState 
	 * @Description:     
	 * @param sysSenderId
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 下午1:49:42
	 */
	@RequestMapping(value="updateSysSenderState",method=RequestMethod.POST)
	public Object updateSysSenderState(String jsonStr) throws Exception{
		SysSender sysSender = Utils.jsonStrToObject(jsonStr, SysSender.class);
		SysSender sysSenderCheck = sysSenderService.selectByPrimaryKey(sysSender.getSysSenderId());
		String msg = "";
		if(sysSenderCheck.getSysSenderState().equals(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex())){
			sysSender.setSysSenderState(EnumConfig.SYSTEM_UNIFIED_STATE_END_USING.getIndex());
			msg = Constant.SYS_SENDER_FORBIDDEN_SUCCESS;
		}else{
			sysSender.setSysSenderState(EnumConfig.SYSTEM_UNIFIED_STATE_START_USING.getIndex());
			msg = Constant.SYS_SENDER_START_SUCCESS;
		}
		int flg = sysSenderService.updateByPrimaryKeySelective(sysSender);
		if(flg <= 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.RESPONSE_MESSAGE_ERROR);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, msg);
	}
	
	/**
	 * 送货人--修改信息
	 * @Title: updateSysSender 
	 * @Description:     
	 * @param jsonStr
	 * @return
	 * @throws Exception   
	 * @return Object    
	 * @author huzhihui_c@qq.com
	 * @date 2016年10月29日 下午1:55:54
	 */
	@RequestMapping(value="updateSysSender",method=RequestMethod.POST)
	public Object updateSysSender(String jsonStr) throws Exception{
		SysSender sysSender = Utils.jsonStrToObject(jsonStr, SysSender.class);
		if(!Utils.isMobile(sysSender.getSysSenderMobileNumber())){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.SYS_SENDER_MOBILE_ERROR);
		}
		sysSender.setSysSenderImgUrl(Base64FileUtils.base64ToImageFile(sysSender.getSysSenderImgUrl(), PropertiesUtils.getProperties(Constant.SERVER_FILE_IMAGE_PHYSICAL_URL_PRE), Utils.getImageName()));
		int flg = sysSenderService.updateByPrimaryKeySelective(sysSender);
		if(flg <= 0){
			return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_ERROR, Constant.UPDATE_ERROR);
		}
		return ReturnUtils.forNoraml(Constant.RESPONSE_CODE_SUCCESS, Constant.UPDATE_SUCCESS);
	}
}
