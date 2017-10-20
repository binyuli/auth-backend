package bz.sunlight.service;

import bz.sunlight.dto.RoleDTO;

import java.util.List;

public interface RoleService {
  public List<RoleDTO> getRoles();

  public void abandon(String id);

  public void editRoleInfo(String id, String name);
}
