package com.hxkj.totops.entity;

public class SysUser {
    /**
     * 系统用户CUID
     * 表字段 : sys_user.sys_user_cuid
     */
    private String sysUserCuid;

    /**
     * 系统用户头像
     * 表字段 : sys_user.sys_user_image
     */
    private String sysUserImage;

    /**
     * 系统用户登录名
     * 表字段 : sys_user.sys_user_login_name
     */
    private String sysUserLoginName;

    /**
     * 系统用户登录密码
     * 表字段 : sys_user.sys_user_password
     */
    private String sysUserPassword;

    /**
     * 系统用户昵称
     * 表字段 : sys_user.sys_user_like_name
     */
    private String sysUserLikeName;

    /**
     * 系统用户真实姓名
     * 表字段 : sys_user.sys_user_rel_name
     */
    private String sysUserRelName;

    /**
     * 系统用户类型（1：管理员）
     * 表字段 : sys_user.sys_user_type
     */
    private Integer sysUserType;

    /**
     * 系统用户状态（1：正常显示、40：删除隐藏）
     * 表字段 : sys_user.sys_user_state
     */
    private Integer sysUserState;

    /**
     * 系统用户创建时间
     * 表字段 : sys_user.sys_user_create_time
     */
    private String sysUserCreateTime;

    /**
     * 系统用户更新时间
     * 表字段 : sys_user.sys_user_update_time
     */
    private String sysUserUpdateTime;

    public String getSysUserCuid() {
        return sysUserCuid;
    }

    public void setSysUserCuid(String sysUserCuid) {
        this.sysUserCuid = sysUserCuid == null ? null : sysUserCuid.trim();
    }

    public String getSysUserImage() {
        return sysUserImage;
    }

    public void setSysUserImage(String sysUserImage) {
        this.sysUserImage = sysUserImage == null ? null : sysUserImage.trim();
    }

    public String getSysUserLoginName() {
        return sysUserLoginName;
    }

    public void setSysUserLoginName(String sysUserLoginName) {
        this.sysUserLoginName = sysUserLoginName == null ? null : sysUserLoginName.trim();
    }

    public String getSysUserPassword() {
        return sysUserPassword;
    }

    public void setSysUserPassword(String sysUserPassword) {
        this.sysUserPassword = sysUserPassword == null ? null : sysUserPassword.trim();
    }

    public String getSysUserLikeName() {
        return sysUserLikeName;
    }

    public void setSysUserLikeName(String sysUserLikeName) {
        this.sysUserLikeName = sysUserLikeName == null ? null : sysUserLikeName.trim();
    }

    public String getSysUserRelName() {
        return sysUserRelName;
    }

    public void setSysUserRelName(String sysUserRelName) {
        this.sysUserRelName = sysUserRelName == null ? null : sysUserRelName.trim();
    }

    public Integer getSysUserType() {
        return sysUserType;
    }

    public void setSysUserType(Integer sysUserType) {
        this.sysUserType = sysUserType;
    }

    public Integer getSysUserState() {
        return sysUserState;
    }

    public void setSysUserState(Integer sysUserState) {
        this.sysUserState = sysUserState;
    }

    public String getSysUserCreateTime() {
        return sysUserCreateTime;
    }

    public void setSysUserCreateTime(String sysUserCreateTime) {
        this.sysUserCreateTime = sysUserCreateTime == null ? null : sysUserCreateTime.trim();
    }

    public String getSysUserUpdateTime() {
        return sysUserUpdateTime;
    }

    public void setSysUserUpdateTime(String sysUserUpdateTime) {
        this.sysUserUpdateTime = sysUserUpdateTime == null ? null : sysUserUpdateTime.trim();
    }
}