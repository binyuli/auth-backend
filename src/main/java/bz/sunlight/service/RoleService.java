package bz.sunlight.service;

import bz.sunlight.dto.CommonDTO;
import bz.sunlight.dto.RoleDTO;
import bz.sunlight.dto.SaveRoleDTO;

import java.util.List;

public interface RoleService {
  List<RoleDTO> getRoles(Integer status, String enterpriseId);

  void abandon(String id);

  void editRoleInfo(String id, String name);

  void save(SaveRoleDTO roleDTO, CommonDTO commonDTO);

  void edit(String id, SaveRoleDTO roleDTO);

  RoleDTO getRole(String id);

}
