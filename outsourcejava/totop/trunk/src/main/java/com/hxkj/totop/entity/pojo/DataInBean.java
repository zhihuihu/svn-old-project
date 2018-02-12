package com.hxkj.totop.entity.pojo;

import com.hxkj.totop.entity.IndexPage;
import com.hxkj.totop.entity.Mingpinhui;
import com.hxkj.totop.entity.PingLife;
import com.hxkj.totop.entity.SysUser;

/**
 * Created by huzhihui on 2016/4/25.
 */
public class DataInBean {
    private String token;

    private int currentPage;

    private int pageSize;

    private String startTime;

    private String endTime;

    private String searchName;

    private SysUser sysUser;

    private IndexPage indexPage;

    //实体属性
    /**
     * 名品汇实体
     */
    private Mingpinhui mingpinhui;

    /**
     * 品生活实体
     */
    private PingLife pingLife;
    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public IndexPage getIndexPage() {
        return indexPage;
    }

    public void setIndexPage(IndexPage indexPage) {
        this.indexPage = indexPage;
    }

    public Mingpinhui getMingpinhui() {
        return mingpinhui;
    }

    public void setMingpinhui(Mingpinhui mingpinhui) {
        this.mingpinhui = mingpinhui;
    }

    public PingLife getPingLife() {
        return pingLife;
    }

    public void setPingLife(PingLife pingLife) {
        this.pingLife = pingLife;
    }
}
