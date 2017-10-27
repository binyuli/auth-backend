package bz.sunlight.dto;

import java.util.List;

public class UserSearchDTO {

  private String name;
  private Integer status;
  private List<String> roleId;
  private String sortField;
  private Boolean isDesc;
  private String enterpriseId;

  private Integer pageSize;
  private Integer pageIndex;
  private Integer offset;

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public List<String> getRoleId() {
    return roleId;
  }

  public void setRoleId(List<String> roleId) {
    this.roleId = roleId;
  }

  public String getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(String enterpriseId) {
    this.enterpriseId = enterpriseId;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageIndex() {
    return pageIndex;
  }

  public void setPageIndex(Integer pageIndex) {
    this.pageIndex = pageIndex;
  }

  public String getSortField() {
    return sortField;
  }

  public void setSortField(String sortField) {
    this.sortField = sortField;
  }

  public Boolean getIsDesc() {
    return isDesc;
  }

  public void setIsDesc(Boolean desc) {
    isDesc = desc;
  }
}
