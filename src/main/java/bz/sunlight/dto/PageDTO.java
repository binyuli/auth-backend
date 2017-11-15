package bz.sunlight.dto;

import java.util.ArrayList;
import java.util.List;

public class PageDTO {
  private String id;
  private String name;
  private String title; // menu 菜单名称为 title
  private String pinyin;
  private String initial;
  private String url;
  private String icon;
  private Integer weight;
  private Integer level;
  private String parentId;
  private String enterpriseId;
  private List<PageDTO> items;
  private List<OperationDTO> operations;
  private Integer maxLevel; //获取 page 列表 用于控制显示层级

  /**
   * 添加节点集合.
   *
   * @param pageDTO.
   */
  public void add(PageDTO pageDTO) {
    if (items == null) {
      items = new ArrayList<>();
    }
    items.add(pageDTO);
  }

  public Integer getMaxLevel() {
    return maxLevel;
  }

  public void setMaxLevel(Integer maxLevel) {
    this.maxLevel = maxLevel;
  }

  public String getTitle() {
    return name;
  }

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

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(String enterpriseId) {
    this.enterpriseId = enterpriseId;
  }

  public List<PageDTO> getItems() {
    return items;
  }

  public void setItems(List<PageDTO> items) {
    this.items = items;
  }

  public List<OperationDTO> getOperations() {
    return operations;
  }

  public void setOperations(List<OperationDTO> operations) {
    this.operations = operations;
  }

  public String getPinyin() {
    return pinyin;
  }

  public void setPinyin(String pinyin) {
    this.pinyin = pinyin;
  }

  public String getInitial() {
    return initial;
  }

  public void setInitial(String initial) {
    this.initial = initial;
  }
}
