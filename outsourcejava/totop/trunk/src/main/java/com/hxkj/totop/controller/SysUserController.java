package com.hxkj.totop.controller;

import com.hxkj.totop.core.utils.PageBeanUtils;
import com.hxkj.totop.core.utils.TimeUtils;
import com.hxkj.totop.entity.SysUser;
import com.hxkj.totop.entity.pojo.DataInBean;
import com.hxkj.totop.service.inter.ISysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by huzhihui on 2016/4/6.
 */
@Controller
@RequestMapping(value = "sysUser")
public class SysUserController {

    @Resource
    private ISysUserService iSysUserService;

    @RequestMapping(value="doInsert")
    @ResponseBody
    public Object doInsert(HttpServletRequest request,String token,DataInBean dataInBean) throws Exception{
        SysUser sysUser = new SysUser();
        sysUser.setSysUserLoginName("admin");
        sysUser.setSysUserPassword("123456");
        sysUser.setSysUserCreateTime(TimeUtils.getMySqlFormatTime());
        iSysUserService.doInsert(sysUser);
        return sysUser;
    }

    /**
     * 管理员登录接口
     * @param request
     * @param token
     * @param datainBean
     * @return
     * @throws Exception
     */
    @RequestMapping(value="doLogin")
    @ResponseBody
    public Object doLogin(HttpServletRequest request,String token,@RequestBody DataInBean datainBean) throws Exception{
        SysUser sysUser = datainBean.getSysUser();
        sysUser = iSysUserService.doLogin(sysUser);
        if(sysUser == null){
            return PageBeanUtils.formatForNormalFalse("","用户名或者密码错误");
        }
        return PageBeanUtils.formatForNormalTrue("",sysUser);
    }


    @RequestMapping(value="doUpdate")
    @ResponseBody
    public Object doUpdate(HttpServletRequest request,String token,DataInBean dataInBean) throws Exception{
        SysUser sysUser = new SysUser();
        sysUser.setSysUserCuid("SYS_USER201604252");
        sysUser.setSysUserAddress("cds");
        sysUser.setSysUserUpdateTime(TimeUtils.getMySqlFormatTime());
        iSysUserService.doUpdateByPrimaryKeySelective(sysUser);
        return sysUser;
    }
}
