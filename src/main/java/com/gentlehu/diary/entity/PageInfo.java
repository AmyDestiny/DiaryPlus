package com.gentlehu.diary.entity;

public class PageInfo {
    protected int pageNum = 1;
    /**
     * 默认每页显示10条记录
     */
    protected int pageSize = 10;

    /**
     * 依据哪个column排序
     */
    protected String orderby = "createtime";

    /**
     * 是否是倒序
     */
    protected boolean isDesc = true;

    private int start = 0;



    public PageInfo() {
        super();
    }

    public PageInfo(int pageNum) {
        super();
        this.pageNum = pageNum;
        this.start = (pageNum - 1) * pageSize;
    }

    public PageInfo(int pageNum, int pageSize) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.start = (pageNum - 1) * pageSize;

    }

    /**
     * 创建一个页面信息
     * @param pageNum 需要显示的页面号
     * @param pageSize 每一页的大小,默认为10
     * @param orderby 依据哪列排序 ，默认是 createtime
     * @param isDesc 是否是倒序，默认为true
     */
    public PageInfo(int pageNum, int pageSize, String orderby, boolean isDesc) {
        super();
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.start = (pageNum - 1) * pageSize;
        this.orderby = orderby;
        this.isDesc = isDesc;
    }

    public int getPageNum() {
        return pageNum;
    }
    /**
     * @param pageNum 需要显示的页面号
     */
    public void setPageNum(int pageNum) {
        this.start = (pageNum - 1) * pageSize;
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize 每一页的大小,默认为10
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderby() {
        return orderby;
    }
    /**
     * @param orderby 依据哪列排序 ，默认是 createtime
     */
    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public boolean getIsDesc() {
        return isDesc;
    }

    /**
     * @param isDesc 是否是倒序，默认为true
     */
    public void setIsDesc(boolean isDesc) {
        this.isDesc = isDesc;
    }

    public int getStart() {
        return start;
    }
    /**
     * 设置起始位置 默认为 (pageNum - 1) * pageSize
     * @param start
     */

    public void setStart(int start) {
        this.start = start;
    }


}