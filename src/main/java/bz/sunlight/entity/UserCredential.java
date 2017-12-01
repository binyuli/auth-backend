package bz.sunlight.entity;

import java.sql.Timestamp;

public class UserCredential {
  private String userId;
  private String username;
  private String password;
  private String enterpriseId;
  private String enterpriseCode;
  private Integer status;
  private Timestamp rowVersion;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEnterpriseCode() {
    return enterpriseCode;
  }

  public void setEnterpriseCode(String enterpriseCode) {
    this.enterpriseCode = enterpriseCode;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Timestamp getRowVersion() {
    return rowVersion;
  }

  public void setRowVersion(Timestamp rowVersion) {
    this.rowVersion = rowVersion;
  }

  public String getEnterpriseId() {
    return enterpriseId;
  }

  public void setEnterpriseId(String enterpriseId) {
    this.enterpriseId = enterpriseId;
  }
}
