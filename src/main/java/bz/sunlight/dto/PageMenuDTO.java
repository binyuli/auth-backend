package bz.sunlight.dto;

import java.util.ArrayList;
import java.util.List;

public class PageMenuDTO {
  private String id;
  private String icon;
  private String title;
  private String url;
  private Integer level;
  private List<PageMenuDTO> items = new ArrayList<>();

  public void add(PageMenuDTO pageMenuDTO) {
    items.add(pageMenuDTO);
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getIcon() {
    return icon;
  }

  public void setIcon(String icon) {
    this.icon = icon;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<PageMenuDTO> getItems() {
    return items;
  }

  public void setItems(List<PageMenuDTO> items) {
    this.items = items;
  }
}
