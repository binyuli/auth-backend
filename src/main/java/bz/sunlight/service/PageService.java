package bz.sunlight.service;

import bz.sunlight.dto.PageDTO;
import bz.sunlight.entity.Page;

import java.util.List;

public interface PageService {
  List<String> getOperationsByPage(String userId, String pageId);

  List<PageDTO> getMenuByByExample(String userId, String enterpriseId);

  /**
   * 获取角色详情API调用.
   *
   * @param roleId 角色Id
   * @return List PageDTO
   */
  List<PageDTO> getPagesByRoleId(String roleId);

  List<PageDTO> getPageDetailsByPageId(String pageId, String enterpriseId);

  List<PageDTO> getPagesByMaxLevel(Integer maxLevel, String enterpriseId);

  Page getPageByCode(String code);
}
