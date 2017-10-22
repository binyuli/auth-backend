package bz.sunlight.dto;

import java.util.List;

/**
 * 新增/修改.
 */
public class SaveRoleDTO {
  private String name;
  private List<String> operations;
  private List<String> pages;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<String> getOperations() {
    return operations;
  }

  public void setOperations(List<String> operations) {
    this.operations = operations;
  }

  public List<String> getPages() {
    return pages;
  }

  public void setPages(List<String> pages) {
    this.pages = pages;
  }
}
