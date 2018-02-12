package com.hxkj.photocms.service.inter;

import com.hxkj.photocms.entity.SysUser;

/** 
 * Project Name:photocms.server 
 * ClassName:ISysUserService
 * Function: TODO ADD FUNCTION.   
 * @author   huzhihui_c@qq.com
 * Date:     2016年2月3日 上午10:14:32 
 * @version  1.0 
 * @since    JDK 1.8      
 */
public interface ISysUserService extends IBaseService<SysUser> {

	public SysUser login(SysUser b) throws Exception;
}
