package bz.sunlight.service;

import bz.sunlight.dto.CommonDTO;
import bz.sunlight.dto.RoleDTO;
import bz.sunlight.dto.SaveRoleDTO;

import java.util.List;

public interface RoleService {
  public List<RoleDTO> getRoles();

  public void abandon(String id);

  public void editRoleInfo(String id, String name);

  public void save(SaveRoleDTO roleDTO, CommonDTO commonDTO);

  public void edit(String id, SaveRoleDTO roleDTO);

  public RoleDTO getRole(String id);

}
