package com.sky.elasticsearch.entity.model.es;

/**
 * @author hhuang
 * @date 2020-07-29 18:40
 */
public class PageEs {

    private Long total;

    private Integer totalPage;

    private Integer pageSize;

    private String result;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        if (null != total) {
            this.totalPage = (int) (total - 1) / this.pageSize + 1;
        }
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
