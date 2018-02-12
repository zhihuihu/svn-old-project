package com.hxkj.totop.entity;

import java.io.Serializable;

/**
 * 系统管理员
 * Created by huzhihui on 2016/4/7.
 */
public class SysUser implements Serializable {


    private static final long serialVersionUID = 5888900813344357975L;
    //系统用户CUID
    private String sysUserCuid;

    //系统用户登录名
    private String sysUserLoginName;

    //系统用户真实姓名
    private String sysUserRelName;

    //系统用户登录密码
    private String sysUserPassword;

    //系统用户电话
    private String sysUserTele;

    //系统用户地址
    private String sysUserAddress;

    //系统用户状态
    private int sysUserState;

    //系统用户创建时间
    private String sysUserCreateTime;

    //系统用户更新时间
    private String sysUserUpdateTime;

    public String getSysUserCuid() {
        return sysUserCuid;
    }

    public void setSysUserCuid(String sysUserCuid) {
        this.sysUserCuid = sysUserCuid;
    }

    public String getSysUserLoginName() {
        return sysUserLoginName;
    }

    public void setSysUserLoginName(String sysUserLoginName) {
        this.sysUserLoginName = sysUserLoginName;
    }

    public String getSysUserRelName() {
        return sysUserRelName;
    }

    public void setSysUserRelName(String sysUserRelName) {
        this.sysUserRelName = sysUserRelName;
    }

    public String getSysUserPassword() {
        return sysUserPassword;
    }

    public void setSysUserPassword(String sysUserPassword) {
        this.sysUserPassword = sysUserPassword;
    }

    public String getSysUserTele() {
        return sysUserTele;
    }

    public void setSysUserTele(String sysUserTele) {
        this.sysUserTele = sysUserTele;
    }

    public String getSysUserAddress() {
        return sysUserAddress;
    }

    public void setSysUserAddress(String sysUserAddress) {
        this.sysUserAddress = sysUserAddress;
    }

    public int getSysUserState() {
        return sysUserState;
    }

    public void setSysUserState(int sysUserState) {
        this.sysUserState = sysUserState;
    }

    public String getSysUserCreateTime() {
        return sysUserCreateTime;
    }

    public void setSysUserCreateTime(String sysUserCreateTime) {
        this.sysUserCreateTime = sysUserCreateTime;
    }

    public String getSysUserUpdateTime() {
        return sysUserUpdateTime;
    }

    public void setSysUserUpdateTime(String sysUserUpdateTime) {
        this.sysUserUpdateTime = sysUserUpdateTime;
    }

}
