package bz.sunlight.dto;

import java.util.List;

public class PageRoleDTO {
  private String id;
  private String name;
  private List<PageRoleDTO> items;
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

  public List<PageRoleDTO> getItems() {
    return items;
  }

  public void setItems(List<PageRoleDTO> items) {
    this.items = items;
  }

  public List<OperationDTO> getOperations() {
    return operations;
  }

  public void setOperations(List<OperationDTO> operations) {
    this.operations = operations;
  }
}
