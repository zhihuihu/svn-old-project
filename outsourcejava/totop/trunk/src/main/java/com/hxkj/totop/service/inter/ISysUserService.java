package com.hxkj.totop.service.inter;

import com.hxkj.totop.entity.SysUser;
import com.hxkj.totop.service.IBaseService;

/**
 * Created by huzhihui on 2016/4/25.
 */
public interface ISysUserService extends IBaseService<SysUser> {
    /**
     * 管理员登录方法
     * @param sysUser
     * @return
     * @throws Exception
     */
    public SysUser doLogin(SysUser sysUser) throws Exception;
}
