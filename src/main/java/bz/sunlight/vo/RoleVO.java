package bz.sunlight.vo;

import bz.sunlight.constant.BaseConstant;
import bz.sunlight.dto.PageRoleDTO;

import java.util.ArrayList;
import java.util.List;

public class RoleVO {
  private String id;
  private String name;
  private List<String> options;
  private int status;
  private List<PageRoleDTO> permissions;

  public List<PageRoleDTO> getPermissions() {
    return permissions;
  }

  public void setPermissions(List<PageRoleDTO> permissions) {
    this.permissions = permissions;
  }

  public void setStatus(int status) {
    this.status = status;
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

  /**
   * 根据角色状态返回此条数据 是否可编辑 是否可作废.
   *
   * @return list
   */
  public List<String> getOptions() {
    if (this.status == BaseConstant.BASEDATA_STATUS_VALID) {
      options = new ArrayList<String>();
      options.add(BaseConstant.ROLE_OPTION_EDITABLE);
      options.add(BaseConstant.ROLE_OPTION_ABANDONABLE);
      return options;
    } else {
      return null;
    }
  }

  public void setOptions(List<String> options) {
    this.options = options;
  }
}
