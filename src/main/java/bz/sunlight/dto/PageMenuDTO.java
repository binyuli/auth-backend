package bz.sunlight.dto;

import java.util.ArrayList;
import java.util.List;

public class PageMenuDTO {
  private String id;
  private String icon;
  private String title;
  private String url;
  private List<PageMenuDTO> items;

  /**
   * 添加节点集合.
   *
   * @param pageDTO.
   */
  public void add(PageMenuDTO pageMenuDTO) {
    if (items == null) {
      items = new ArrayList<>();
    }
    items.add(pageMenuDTO);
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
