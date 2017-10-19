package bz.sunlight.entity;

import java.io.Serializable;

public class Page implements Serializable {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column page.Id
   *
   * @mbggenerated
   */
  private String id;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column page.Name
   *
   * @mbggenerated
   */
  private String name;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column page.Url
   *
   * @mbggenerated
   */
  private String url;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column page.Icon
   *
   * @mbggenerated
   */
  private String icon;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column page.Weight
   *
   * @mbggenerated
   */
  private Integer weight;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column page.parent_Id
   *
   * @mbggenerated
   */
  private String parentId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column page.Enterprise_Id
   *
   * @mbggenerated
   */
  private String enterpriseId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table page
   *
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column page.Id
   *
   * @return the value of page.Id
   * @mbggenerated
   */
  public String getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column page.Id
   *
   * @param id the value for page.Id
   * @mbggenerated
   */
  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column page.Name
   *
   * @return the value of page.Name
   * @mbggenerated
   */
  public String getName() {
    return name;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column page.Name
   *
   * @param name the value for page.Name
   * @mbggenerated
   */
  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column page.Url
   *
   * @return the value of page.Url
   * @mbggenerated
   */
  public String getUrl() {
    return url;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column page.Url
   *
   * @param url the value for page.Url
   * @mbggenerated
   */
  public void setUrl(String url) {
    this.url = url == null ? null : url.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column page.Icon
   *
   * @return the value of page.Icon
   * @mbggenerated
   */
  public String getIcon() {
    return icon;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column page.Icon
   *
   * @param icon the value for page.Icon
   * @mbggenerated
   */
  public void setIcon(String icon) {
    this.icon = icon == null ? null : icon.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column page.Weight
   *
   * @return the value of page.Weight
   * @mbggenerated
   */
  public Integer getWeight() {
    return weight;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column page.Weight
   *
   * @param weight the value for page.Weight
   * @mbggenerated
   */
  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column page.parent_Id
   *
   * @return the value of page.parent_Id
   * @mbggenerated
   */
  public String getParentId() {
    return parentId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column page.parent_Id
   *
   * @param parentId the value for page.parent_Id
   * @mbggenerated
   */
  public void setParentId(String parentId) {
    this.parentId = parentId == null ? null : parentId.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column page.Enterprise_Id
   *
   * @return the value of page.Enterprise_Id
   * @mbggenerated
   */
  public String getEnterpriseId() {
    return enterpriseId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column page.Enterprise_Id
   *
   * @param enterpriseId the value for page.Enterprise_Id
   * @mbggenerated
   */
  public void setEnterpriseId(String enterpriseId) {
    this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
  }
}