package bz.sunlight.service;

import bz.sunlight.dto.PageDTO;

import java.util.List;

public interface PageService {
  public List<String> getOperationsByPage(String pageId);

  public List<PageDTO> getMenuByByExample(String userId, String enterpriseId);

  /**
   * 获取角色详情API调用
   *
   * @param roleId.
   * @return List PageDTO
   */
  public List<PageDTO> getPagesByRoleId(String roleId);
}
