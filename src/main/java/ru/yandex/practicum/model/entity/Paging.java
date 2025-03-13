package ru.yandex.practicum.model.entity;

public class Paging {

    private String search;

    private int pageSize;

    private int pageNumber;

    private boolean hasNext;

    private boolean hasPrevious;

    public Paging() {
        this.search = "";
        this.pageSize = 10;
        this.pageNumber = 1;
        this.hasNext = true;
        this.hasPrevious = false;
    }

    public Paging(String search, int pageSize, int pageNumber, boolean hasNext, boolean hasPrevious) {
        this.search = search;
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.hasNext = hasNext;
        this.hasPrevious = hasPrevious;
    }

    public int pageSize() {
        return this.pageSize;
    }

    public int pageNumber() {
        return this.pageNumber;
    }

    public boolean hasNext() {
        return this.hasNext;
    }

    public boolean hasPrevious() {
        return this.hasPrevious;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public boolean isHasPrevious() {
        return hasPrevious;
    }

    public void setHasPrevious(boolean hasPrevious) {
        this.hasPrevious = hasPrevious;
    }

}
