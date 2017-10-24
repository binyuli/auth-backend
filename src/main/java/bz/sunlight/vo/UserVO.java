package bz.sunlight.vo;

import bz.sunlight.constant.BaseConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserVO {

  private String id;
  private String name;
  private String username;
  private int status;
  private List<String> options;
  private List<Map<String, String>> roles;

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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public void setOptions(List<String> options) {
    this.options = options;
  }

  /**
   * 根据用户状态返回此条数据 是否可编辑 是否可冻结或解冻.
   *
   * @return list
   */
  public List<String> getOptions() {
    if (this.status == BaseConstant.BASEDATA_STATUS_VALID) {
      options = new ArrayList<String>();
      options.add(BaseConstant.USER_OPTION_EDITABLE);
      options.add(BaseConstant.USER_OPTION_DISABLEORENABLE);
      return options;
    } else {
      return null;
    }
  }

  public List<Map<String, String>> getRoles() {
    return roles;
  }

  public void setRoles(List<Map<String, String>> roles) {
    this.roles = roles;
  }
}
