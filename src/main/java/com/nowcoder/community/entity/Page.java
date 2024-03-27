package com.nowcoder.community.entity;
/**
 * 封装分页相关的信息.
 */
public class Page {
    // 当前页码，默认为1，显示在页面
    private int current = 1;
    // 总共有多少页，默认10，显示在页面
    private int limit = 10;
    // 数据总数(用于计算总页数)，服务端查出来的
    private int rows;
    // 查询路径(用于复用分页链接)，每一页的链接
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取当前页的起始行
     */
    public int getOffset() {
        // current * limit - limit
        return (current - 1) * limit;
    }

    /**
     * 获取总页数，显示页码
     */
    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     * 获取起始页码：比如当前是第3页，页码栏可以显示1,2,3,4,5，起始页码就是1
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码：比如当前是第3页，页码栏可以显示1,2,3,4,5，结束页码就是5
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal(); // 最后一页
        return to > total ? total : to;
    }

}
