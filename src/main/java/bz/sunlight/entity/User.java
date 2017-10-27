package bz.sunlight.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column user.Id
   *
   * @mbggenerated
   */
  private String id;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column user.Name
   *
   * @mbggenerated
   */
  private String name;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column user.Username
   *
   * @mbggenerated
   */
  private String username;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column user.Create_Time
   *
   * @mbggenerated
   */
  private Date createTime;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column user.Creator
   *
   * @mbggenerated
   */
  private String creator;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column user.Modify_Time
   *
   * @mbggenerated
   */
  private Date modifyTime;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column user.Enterprise_Id
   *
   * @mbggenerated
   */
  private String enterpriseId;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column user.Status
   *
   * @mbggenerated
   */
  private Integer status;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column user.Row_Version
   *
   * @mbggenerated
   */
  private Date rowVersion;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table user
   *
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column user.Id
   *
   * @return the value of user.Id
   *
   * @mbggenerated
   */
  public String getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column user.Id
   *
   * @param id the value for user.Id
   *
   * @mbggenerated
   */
  public void setId(String id) {
    this.id = id == null ? null : id.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column user.Name
   *
   * @return the value of user.Name
   *
   * @mbggenerated
   */
  public String getName() {
    return name;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column user.Name
   *
   * @param name the value for user.Name
   *
   * @mbggenerated
   */
  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column user.Username
   *
   * @return the value of user.Username
   *
   * @mbggenerated
   */
  public String getUsername() {
    return username;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column user.Username
   *
   * @param username the value for user.Username
   *
   * @mbggenerated
   */
  public void setUsername(String username) {
    this.username = username == null ? null : username.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column user.Create_Time
   *
   * @return the value of user.Create_Time
   *
   * @mbggenerated
   */
  public Date getCreateTime() {
    return createTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column user.Create_Time
   *
   * @param createTime the value for user.Create_Time
   *
   * @mbggenerated
   */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column user.Creator
   *
   * @return the value of user.Creator
   *
   * @mbggenerated
   */
  public String getCreator() {
    return creator;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column user.Creator
   *
   * @param creator the value for user.Creator
   *
   * @mbggenerated
   */
  public void setCreator(String creator) {
    this.creator = creator == null ? null : creator.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column user.Modify_Time
   *
   * @return the value of user.Modify_Time
   *
   * @mbggenerated
   */
  public Date getModifyTime() {
    return modifyTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column user.Modify_Time
   *
   * @param modifyTime the value for user.Modify_Time
   *
   * @mbggenerated
   */
  public void setModifyTime(Date modifyTime) {
    this.modifyTime = modifyTime;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column user.Enterprise_Id
   *
   * @return the value of user.Enterprise_Id
   *
   * @mbggenerated
   */
  public String getEnterpriseId() {
    return enterpriseId;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column user.Enterprise_Id
   *
   * @param enterpriseId the value for user.Enterprise_Id
   *
   * @mbggenerated
   */
  public void setEnterpriseId(String enterpriseId) {
    this.enterpriseId = enterpriseId == null ? null : enterpriseId.trim();
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column user.Status
   *
   * @return the value of user.Status
   *
   * @mbggenerated
   */
  public Integer getStatus() {
    return status;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column user.Status
   *
   * @param status the value for user.Status
   *
   * @mbggenerated
   */
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column user.Row_Version
   *
   * @return the value of user.Row_Version
   *
   * @mbggenerated
   */
  public Date getRowVersion() {
    return rowVersion;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column user.Row_Version
   *
   * @param rowVersion the value for user.Row_Version
   *
   * @mbggenerated
   */
  public void setRowVersion(Date rowVersion) {
    this.rowVersion = rowVersion;
  }
}