package com.mcii.tools;

/**
 * Created by Sean on 2017/8/10.
 */

import java.util.List;

/**
 * 分页
 */
public class PageRecord {
    private int currentPage = 0;
    private int pageSize = 0;
    private int totalPage = 0;
    private List<Object> objects = null;

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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }
}
