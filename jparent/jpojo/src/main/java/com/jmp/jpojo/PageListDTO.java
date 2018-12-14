package com.jmp.jpojo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:业务层/Web层,分页查询返回数据封装;
 * @date: 2018-05-02 15:04
 */
public class PageListDTO<E> implements Serializable {

    private static final long serialVersionUID = -1723424053279985840L;
    /**
     * 当前页是否是第一页;
     */
    private Boolean firstPage;
    /**
     * 当前页是否是最后一页;
     */
    private Boolean lastPage;
    /**
     * 当前页码;
     */
    private Integer currentPage;
    /**
     * 每页显示数据条数;
     */
    private Integer pageSize;
    /**
     * 总页数;
     */
    private Integer totalPage;
    /**
     * 数据总数;
     */
    private Long totalRecord;
    /**
     * 当前返回数据条数;
     */
    private Integer listSize;
    /**
     * 返回数据;
     */
    private List<E> list = new ArrayList<>(0);

    public PageListDTO() {}

    public PageListDTO(Boolean firstPage, Boolean lastPage, Integer currentPage, Integer pageSize, Integer totalPage, Long totalRecord, Integer listSize, List<E> list) {
        this.firstPage = firstPage;
        this.lastPage = lastPage;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalRecord = totalRecord;
        this.listSize = listSize;
        this.list = list;
    }

    public Boolean getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Boolean firstPage) {
        this.firstPage = firstPage;
    }

    public Boolean getLastPage() {
        return lastPage;
    }

    public void setLastPage(Boolean lastPage) {
        this.lastPage = lastPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getListSize() {
        return listSize;
    }

    public void setListSize(Integer listSize) {
        this.listSize = listSize;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageListDTO{" +
                "firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalRecord=" + totalRecord +
                ", listSize=" + listSize +
                ", list=" + list +
                '}';
    }

}
