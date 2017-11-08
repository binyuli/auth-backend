package bz.sunlight.vo;

import bz.sunlight.constant.BaseConstant;

import java.util.List;

public class ResultWithPagination<T> {

  private List<T> content;
  private Integer pageIndex       = BaseConstant.DEFAULT_PAGE_INDEX;
  private Integer pageSize        = BaseConstant.DEFAULT_PAGE_SIZE;
  private Integer totalElements;
  private Integer totalPages;
  private String sort             = BaseConstant.DEFAULT_SORT_TYPE;

  public List<T> getContent() {
    return content;
  }

  public void setContent(List<T> content) {
    this.content = content;
  }

  public Integer getPageIndex() {
    return pageIndex;
  }

  public void setPageIndex(Integer pageIndex) {
    this.pageIndex = pageIndex;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }
}
