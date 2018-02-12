package com.hxkj.totops.entity;

public class SysFile {
    /**
     * 系统文件id
     * 表字段 : sys_file.sys_file_cuid
     */
    private String sysFileCuid;

    /**
     * 文件原名称
     * 表字段 : sys_file.sys_file_name
     */
    private String sysFileName;

    /**
     * 缩略图
     * 表字段 : sys_file.sys_file_thumb_url
     */
    private String sysFileThumbUrl;

    /**
     * 文件保存url
     * 表字段 : sys_file.sys_file_url
     */
    private String sysFileUrl;

    /**
     * 文件类型（1：文件、2：图片、3视频）
     * 表字段 : sys_file.sys_file_type
     */
    private Integer sysFileType;

    /**
     * 文件状态（（1：正常显示、40：删除隐藏））
     * 表字段 : sys_file.sys_file_state
     */
    private Integer sysFileState;

    /**
     * 系统文件上传时间
     * 表字段 : sys_file.sys_file_create_time
     */
    private String sysFileCreateTime;

    /**
     * 系统文件更新时间
     * 表字段 : sys_file.sys_file_update_time
     */
    private String sysFileUpdateTime;

    public String getSysFileCuid() {
        return sysFileCuid;
    }

    public void setSysFileCuid(String sysFileCuid) {
        this.sysFileCuid = sysFileCuid == null ? null : sysFileCuid.trim();
    }

    public String getSysFileName() {
        return sysFileName;
    }

    public void setSysFileName(String sysFileName) {
        this.sysFileName = sysFileName == null ? null : sysFileName.trim();
    }

    public String getSysFileThumbUrl() {
        return sysFileThumbUrl;
    }

    public void setSysFileThumbUrl(String sysFileThumbUrl) {
        this.sysFileThumbUrl = sysFileThumbUrl == null ? null : sysFileThumbUrl.trim();
    }

    public String getSysFileUrl() {
        return sysFileUrl;
    }

    public void setSysFileUrl(String sysFileUrl) {
        this.sysFileUrl = sysFileUrl == null ? null : sysFileUrl.trim();
    }

    public Integer getSysFileType() {
        return sysFileType;
    }

    public void setSysFileType(Integer sysFileType) {
        this.sysFileType = sysFileType;
    }

    public Integer getSysFileState() {
        return sysFileState;
    }

    public void setSysFileState(Integer sysFileState) {
        this.sysFileState = sysFileState;
    }

    public String getSysFileCreateTime() {
        return sysFileCreateTime;
    }

    public void setSysFileCreateTime(String sysFileCreateTime) {
        this.sysFileCreateTime = sysFileCreateTime == null ? null : sysFileCreateTime.trim();
    }

    public String getSysFileUpdateTime() {
        return sysFileUpdateTime;
    }

    public void setSysFileUpdateTime(String sysFileUpdateTime) {
        this.sysFileUpdateTime = sysFileUpdateTime == null ? null : sysFileUpdateTime.trim();
    }
}