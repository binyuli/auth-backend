package bz.sunlight.vo;

import bz.sunlight.dto.OperationDTO;

import java.util.List;

public class PageDetailsVO {
  private String id;
  private String name;
  private List<PageDetailsVO> items;
  private List<OperationDTO> operations;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<PageDetailsVO> getItems() {
    return items;
  }

  public void setItems(List<PageDetailsVO> items) {
    this.items = items;
  }

  public List<OperationDTO> getOperations() {
    return operations;
  }

  public void setOperations(List<OperationDTO> operations) {
    this.operations = operations;
  }
}
