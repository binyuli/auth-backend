package bz.sunlight.service;

import bz.sunlight.dto.PageDTO;

import java.util.List;

public interface PageService {
  public List<String> getOperationsByPage(String pageId);

  public List<PageDTO> getMenuByByExample(String userId, String enterpriseId);
}
