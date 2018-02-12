package com.hxkj.xhupubmed.service.inter;

import javax.servlet.http.HttpServletRequest;

import com.hxkj.xhupubmed.entity.SysUser;
import com.hxkj.xhupubmed.service.IBaseService;

/** 
 * ClassName:ISysUserService
 * Function:   
 * @author   huzhihui_c@qq.com
 * Date:     2016年3月9日 上午11:27:13 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface ISysUserService extends IBaseService<SysUser> {

	public int doRegister(SysUser sysUser) throws Exception;
	
	public SysUser doLogin(SysUser sysUser) throws Exception;
	
	public SysUser selectByAttribute(SysUser sysUser) throws Exception;
	
	public Object updateUserImage(HttpServletRequest request,String sysUserCuid) throws Exception;
}
