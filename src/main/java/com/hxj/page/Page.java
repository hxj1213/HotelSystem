package com.hxj.page;

import java.util.List;

/**
 * @ author 黑潇君
 * 东软睿道西安TTC
 */
public class Page<T> {

    private int pageNow;//当前页
    private int pageRows;//每页显示多少条数据
    private int totalPages;//总页数
    private int totalRows;//总共多少条记录
    private List<T> datas;//每页的数据

    public Page() {
    }

    public Page(int pageNow, int pageRows) {
        this.pageNow = pageNow;
        this.pageRows = pageRows;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageRows() {
        return pageRows;
    }

    public void setPageRows(int pageRows) {
        this.pageRows = pageRows;
    }

    public int getTotalPages() {
        totalPages = totalRows%pageRows==0?totalRows/pageRows:totalRows/pageRows+1;
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNow=" + pageNow +
                ", pageRows=" + pageRows +
                ", totalPages=" + getTotalPages() +
                ", totalRows=" + totalRows +
                ", datas=" + datas +
                '}';
    }
}
