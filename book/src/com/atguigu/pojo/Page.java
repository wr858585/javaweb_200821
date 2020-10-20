package com.atguigu.pojo;

import java.util.List;

/**
 * @author oono
 * @date 2020 10 20
 */
public class Page<T> {

    //常量：默认的页面展示items数量
    public static final Integer PAGE_SIZE = 4;
    //当前页数
    private Integer pageNo;
    //页面展示的items数
    private Integer pageSize = PAGE_SIZE;
    //总记录数
    private Integer pageCount;
    //总页码
    private Integer pageTotal;
    //当前页的数据items
    private List<T> items;

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", pageTotal=" + pageTotal +
                ", items=" + items +
                '}';
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageCount, Integer pageTotal, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.pageTotal = pageTotal;
        this.items = items;
    }

    public Page() {
    }
}
