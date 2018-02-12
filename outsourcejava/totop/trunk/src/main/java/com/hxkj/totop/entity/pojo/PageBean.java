package com.hxkj.totop.entity.pojo;

import java.util.List;

/**
 * Created by huzhihui on 2016/4/25.
 */
public class PageBean<B> {
    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 一页的大小
     */
    private int pageSize;

    /**
     * 查询实体
     */
    private B b;

    /**
     * mysql查询开始编号
     */
    private int startLine;

    /**
     * 用户排序数组
     */
    private List<String> orderList ;

    /**
     * mybatis 排序查询字段
     */
    private String orderByString;

    /**
     * 区间查询属性
     */
    private String betweenType;

    /**
     * 区间查询属性前一个
     */
    private String betweenBefore;

    /**
     * 区间查询属性前一个
     */
    private String betweenAfter;

	/*private String betweenString;*/

    public PageBean(int currentPage, int pageSize){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.startLine = ((currentPage < 1 ? 1 : currentPage) - 1) * pageSize;
    }

    public PageBean(int currentPage, int pageSize,B b){
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.startLine = ((currentPage < 1 ? 1 : currentPage) - 1) * pageSize;
        this.b = b;
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

    public B getB() {
        return b;
    }

    /**
     * 设置实体类属性
     * @param b
     */
    public void setB(B b) {
        this.b = b;
    }

    public int getStartLine() {
        return startLine;
    }

    public void setStartLine(int startLine) {
        this.startLine = startLine;
    }

    public List<String> getOrderList() {
        return orderList;
    }

    /**
     * 设置排序查询字段 默认降序
     * @param orderList
     */
    public void setOrderList(List<String> orderList) {
        if(orderList == null){
            return;
        }
        this.orderList = orderList;
        setOrderByString();
        this.orderByString = "ORDER BY " + this.orderByString;
        this.orderByString += " DESC";
    }

    /**
     * 设置排序字段查询降序
     * @param orderList
     */
    public void setOrderListDesc(List<String> orderList) {
        if(orderList == null){
            return;
        }
        this.orderList = orderList;
        setOrderByString();
        this.orderByString = "ORDER BY " + this.orderByString;
        this.orderByString += " DESC";
    }

    /**
     * 设置排序字段查询升序
     * @param orderList
     */
    public void setOrderListASC(List<String> orderList) {
        if(orderList == null){
            return;
        }
        this.orderList = orderList;
        setOrderByString();
        this.orderByString = "ORDER BY " + this.orderByString;
        this.orderByString += " ASC";
    }

    public String getOrderByString() {
        return orderByString;
    }

    public void setOrderByString(String orderByString) {
        this.orderByString = orderByString;
    }

    /**
     * 把排序单词转化为数据库能识别的类型
     */
    private void setOrderByString() {
        StringBuffer sb = new StringBuffer("");
        if(null == this.orderList){
            return;
        }
        for(int i=0;i<this.orderList.size();i++){
            if(i == 0){
                sb.append(changeUpAndDown(this.orderList.get(i)));
            }else{
                sb.append(changeUpAndDown("," + this.orderList.get(i)));
            }

        }
        this.orderByString = sb.toString();
    }

    /**
     *
     * @param inWord
     * @return
     */
    private String changeUpAndDown(String inWord){
        StringBuffer sb = new StringBuffer("");
        for(int i=0;i<inWord.length();i++){
            char c = inWord.charAt(i);
            if(Character.isUpperCase(c)){
                sb.append("_" + Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String getBetweenType() {
        return betweenType;
    }

    /**
     * 区间查询的属性
     * @param betweenType
     */
    public void setBetweenType(String betweenType) {
        if(null == betweenType || "".equals(betweenType)){
            return;
        }
        this.betweenType = changeUpAndDown(betweenType);
    }

    public String getBetweenBefore() {
        return betweenBefore;
    }

    /**
     * 区间查询的>条件
     * @param betweenBefore
     */
    public void setBetweenBefore(String betweenBefore) {
        if(null == betweenBefore || "".equals(betweenBefore)){
            return;
        }
        this.betweenBefore = this.betweenType +"> '"+ betweenBefore +"'";
    }

    public String getBetweenAfter() {
        return betweenAfter;
    }

    /**
     * 区间查询的<条件
     * @param betweenAfter
     */
    public void setBetweenAfter(String betweenAfter) {
        if(null == betweenAfter || "".equals(betweenAfter)){
            return;
        }
        this.betweenAfter = this.betweenType +"<= '"+  betweenAfter + "'";
    }
}
