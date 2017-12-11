package bz.sunlight.service;

import bz.sunlight.dto.RoleDTO;
import bz.sunlight.dto.SaveRoleDTO;
import bz.sunlight.vo.LoginUser;

import java.util.List;

public interface RoleService {
  List<RoleDTO> getRoles(Integer status, String enterpriseId);

  void abandon(String id, LoginUser loginUser);

  void editRoleInfo(String id, String name, LoginUser loginUser);

  void save(SaveRoleDTO roleDTO, LoginUser loginUser);

  void edit(String id, SaveRoleDTO roleDTO, LoginUser loginUser);

  RoleDTO getRole(String id);

}
