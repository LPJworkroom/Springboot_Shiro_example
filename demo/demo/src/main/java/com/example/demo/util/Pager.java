package com.example.demo.util;

public class Pager {
    private int pageNumber;
    private int pageSize;

    public int getOffset(){
        return (pageNumber-1)*pageSize;
    }

    public int getLimit(){
        return pageSize;
    }

    public Pager() {
    }

    public Pager(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
