package bz.sunlight.service;

import bz.sunlight.dto.PageMenuDTO;

import java.util.List;

public interface PageService {
  public List<String> getOperationsByPage(String pageId);

  public List<PageMenuDTO> getMenuByByExample(String userId, String enterpriseId);
}
