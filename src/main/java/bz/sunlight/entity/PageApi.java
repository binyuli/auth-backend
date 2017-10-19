package bz.sunlight.entity;

import java.io.Serializable;

public class PageApi implements Serializable {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column page_api.Api_Id
   *
   * @mbggenerated
   */
  private String apiId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column page_api.Page_Id
   *
   * @mbggenerated
   */
  private String pageId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table page_api
   *
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column page_api.Api_Id
   *
   * @return the value of page_api.Api_Id
   * @mbggenerated
   */
  public String getApiId() {
    return apiId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column page_api.Api_Id
   *
   * @param apiId the value for page_api.Api_Id
   * @mbggenerated
   */
  public void setApiId(String apiId) {
    this.apiId = apiId == null ? null : apiId.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column page_api.Page_Id
   *
   * @return the value of page_api.Page_Id
   * @mbggenerated
   */
  public String getPageId() {
    return pageId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column page_api.Page_Id
   *
   * @param pageId the value for page_api.Page_Id
   * @mbggenerated
   */
  public void setPageId(String pageId) {
    this.pageId = pageId == null ? null : pageId.trim();
  }
}