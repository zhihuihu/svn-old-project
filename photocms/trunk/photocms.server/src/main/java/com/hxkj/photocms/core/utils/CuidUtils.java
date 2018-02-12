package com.hxkj.photocms.core.utils;

import java.util.List;

import com.hxkj.photocms.entity.DataType;
import com.hxkj.photocms.entity.GlobalId;
import com.hxkj.photocms.entity.Special;
import com.hxkj.photocms.entity.SpecialContent;
import com.hxkj.photocms.entity.SpecialType;
import com.hxkj.photocms.entity.SysUser;
import com.hxkj.photocms.entity.UserType;
import com.hxkj.photocms.service.impl.GlobalIdService;

/** 
 * Project Name:photocms.server 
 * ClassName:CuidUtils
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月2日 下午9:40:56 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public class CuidUtils {

	private static GlobalIdService globalIdService;
	
	static{
		globalIdService = (GlobalIdService) SpringContextUtils.getBean("globalIdService");
	}
	
	/**
	 * 
	* @Title: setCuid 
	* @Description: DATATYPE 数据类型设置CUID
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月3日 上午10:46:16
	* @Since JDK 1.8
	 */
	public static void setCuid(DataType b,String notes) throws Exception{
		GlobalId globalId = new GlobalId();
		globalId.setGlobalTableName("DATATYPE");
		globalId.setGlobalNotes(notes);
		globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
		globalIdService.doInsert(globalId);
		b.setDataTypeCuid("DATATYPE_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
	}
	
	public static void setCuidList(List<DataType> bs,String notes,DataType classType) throws Exception{
		for(int i=0;i<bs.size();i++){
			GlobalId globalId = new GlobalId();
			globalId.setGlobalTableName("DATATYPE");
			globalId.setGlobalNotes(notes);
			globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
			globalIdService.doInsert(globalId);
			bs.get(i).setDataTypeCuid("DATATYPE_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
		}
	}
	
	
	/**
	 * 
	* @Title: setCuid 
	* @Description: SPECIAL  专辑的CUID设置方法
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月3日 上午9:26:04
	* @Since JDK 1.8
	 */
	public static void setCuid(Special b,String notes) throws Exception{
		GlobalId globalId = new GlobalId();
		globalId.setGlobalTableName("SPECIAL");
		globalId.setGlobalNotes(notes);
		globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
		globalIdService.doInsert(globalId);
		b.setSpecialCuid("SPECIAL_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
	}
	
	public static void setCuidList(List<Special> bs,String notes,Special classType) throws Exception{
		for(int i=0;i<bs.size();i++){
			GlobalId globalId = new GlobalId();
			globalId.setGlobalTableName("SPECIAL");
			globalId.setGlobalNotes(notes);
			globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
			globalIdService.doInsert(globalId);
			bs.get(i).setSpecialCuid("SPECIAL_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
		}
	}
	
	/**
	 * 
	* @Title: setCuid 
	* @Description: SPECIAL_CONTENT 专辑内容设置CUID
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月3日 上午9:27:51
	* @Since JDK 1.8
	 */
	public static void setCuid(SpecialContent b,String notes) throws Exception{
		GlobalId globalId = new GlobalId();
		globalId.setGlobalTableName("SPECIAL_CONTENT");
		globalId.setGlobalNotes(notes);
		globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
		globalIdService.doInsert(globalId);
		b.setSpecialContentCuid("SPECIAL_CONTENT_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
	}
	
	public static void setCuidList(List<SpecialContent> bs,String notes,SpecialContent classType) throws Exception{
		for(int i=0;i<bs.size();i++){
			GlobalId globalId = new GlobalId();
			globalId.setGlobalTableName("SPECIAL_CONTENT");
			globalId.setGlobalNotes(notes);
			globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
			globalIdService.doInsert(globalId);
			bs.get(i).setSpecialContentCuid("SPECIAL_CONTENT_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
		}
	}
	
	/**
	 * 
	* @Title: setCuid 
	* @Description: SPECIAL_TYPE   专辑类型设置CUID
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月3日 上午9:29:12
	* @Since JDK 1.8
	 */
	public static void setCuid(SpecialType b,String notes) throws Exception{
		GlobalId globalId = new GlobalId();
		globalId.setGlobalTableName("SPECIAL_TYPE");
		globalId.setGlobalNotes(notes);
		globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
		globalIdService.doInsert(globalId);
		b.setSpecialTypeCuid("SPECIAL_TYPE_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
	}
	
	public static void setCuidList(List<SpecialType> bs,String notes,SpecialType classType) throws Exception{
		for(int i=0;i<bs.size();i++){
			GlobalId globalId = new GlobalId();
			globalId.setGlobalTableName("SPECIAL_TYPE");
			globalId.setGlobalNotes(notes);
			globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
			globalIdService.doInsert(globalId);
			bs.get(i).setSpecialTypeCuid("SPECIAL_TYPE_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
		}
	}
	
	/**
	 * 
	* @Title: setCuid 
	* @Description: SYS_USER    设置系统用户表CUID
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月3日 上午9:30:37
	* @Since JDK 1.8
	 */
	public static void setCuid(SysUser b,String notes) throws Exception{
		GlobalId globalId = new GlobalId();
		globalId.setGlobalTableName("SYS_USER");
		globalId.setGlobalNotes(notes);
		globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
		globalIdService.doInsert(globalId);
		b.setSysUserCuid("SYS_USER_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
	}
	
	public static void setCuidList(List<SysUser> bs,String notes,SysUser classType) throws Exception{
		for(int i=0;i<bs.size();i++){
			GlobalId globalId = new GlobalId();
			globalId.setGlobalTableName("SYS_USER");
			globalId.setGlobalNotes(notes);
			globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
			globalIdService.doInsert(globalId);
			bs.get(i).setSysUserCuid("SYS_USER_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
		}
	}
	
	
	/**
	 * 
	* @Title: setCuid 
	* @Description: 设置UserType的CUID
	* @param @param b
	* @param @param notes
	* @param @throws Exception     
	* @return void    
	* @author huzhihui_c@qq.com   
	* @date 2016年2月2日 下午9:55:56
	* @Since JDK 1.8
	 */
	public static void setCuid(UserType b,String notes) throws Exception{
		GlobalId globalId = new GlobalId();
		globalId.setGlobalTableName("USER_TYPE");
		globalId.setGlobalNotes(notes);
		globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
		globalIdService.doInsert(globalId);
		b.setUserTypeCuid("USER_TYPE_"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
	}
	
	public static void setCuidList(List<UserType> bs,String notes,UserType classType) throws Exception{
		for(int i=0;i<bs.size();i++){
			GlobalId globalId = new GlobalId();
			globalId.setGlobalTableName("USER_TYPE");
			globalId.setGlobalNotes(notes);
			globalId.setGlobalCreateTime(TimeUtils.getMySqlFormatTime());
			globalIdService.doInsert(globalId);
			bs.get(i).setUserTypeCuid("USER_TYPE"+TimeUtils.getCuidHeadTime()+"00"+globalId.getGlobalCuid());
		}
	}
}
