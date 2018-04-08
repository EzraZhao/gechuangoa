package com.ezra.gechuang.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Ezra on 2017/9/3.
 */
public class PageBean implements Serializable {


    private List recordList;
    private int currentPage;
    private int pageCount;
    private int pageSize;
    private int recordCount;
    private int beginPageIndex;
    private int endPageIndex;

    public PageBean() {
    }

    public PageBean(List recordList, int currentPage, int pageSize, int recordCount) {
        this.recordList = recordList;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.recordCount = recordCount;

//        if (recordCount % pageSize == 0) {
//            pageCount = recordCount / pageSize;
//        } else {
//            pageCount = recordCount / pageSize + 1;
//        }
        pageCount = (recordCount + pageSize - 1) / pageSize;

        if (pageCount <= 10) {
            beginPageIndex = 1;
            endPageIndex = pageCount;
        } else {
            beginPageIndex = currentPage - 4;
            endPageIndex = currentPage + 5;

            if (beginPageIndex < 1) {
                beginPageIndex = 1;
                endPageIndex = 10;
            }

            if (endPageIndex > pageCount) {
                beginPageIndex = pageCount - 10;
                endPageIndex = pageCount;
            }
        }


    }

    public List getRecordList() {
        return recordList;
    }

    public void setRecordList(List recordList) {
        this.recordList = recordList;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getBeginPageIndex() {
        return beginPageIndex;
    }

    public void setBeginPageIndex(int beginPageIndex) {
        this.beginPageIndex = beginPageIndex;
    }

    public int getEndPageIndex() {
        return endPageIndex;
    }

    public void setEndPageIndex(int endPageIndex) {
        this.endPageIndex = endPageIndex;
    }
}
