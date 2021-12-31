package com.demo.util;

import java.util.List;

public class PageBean<T> {
    private List<T> list;//A collection of lists based on criteria
    private int totalRecord;//Number of queries based on criteria

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    private int pageNum;
    private int pageSize;
    private int totalPage; 
    private int startIndex;
    private int start;
    private int end;

    private String servlet;
    private String searchColumn;
    private String keyword;

    public PageBean(int pageNum, int totalRecord) {
        this.pageNum = (pageNum = Math.max(pageNum, 1));
        this.pageSize = 10;
        this.totalRecord = totalRecord;
  
        if (totalRecord % pageSize == 0) {
         
            this.totalPage = totalRecord / pageSize;
        } else {
         
            this.totalPage = totalRecord / pageSize + 1;
        }
        
        this.startIndex = (pageNum - 1) * pageSize;
      
        this.start = 1;
        this.end = 5;
        
        if (totalPage <= 5) {
            this.end = this.totalPage;
        } else {
            this.start = pageNum - 2;
            this.end = pageNum + 2;
            if (start < 0) {
                this.start = 1;
                this.end = 5;
            }
            if (end > this.totalPage) {
                this.end = totalPage;
                this.start = end - 5;
            }
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getServlet() {
        return servlet;
    }

    public void setServlet(String servlet) {
        this.servlet = servlet;
    }

    public String getSearchColumn() {
        return searchColumn;
    }

    public void setSearchColumn(String searchColumn) {
        this.searchColumn = searchColumn;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}