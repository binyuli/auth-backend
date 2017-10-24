package bz.sunlight.dao;

import bz.sunlight.BaseMapper;
import bz.sunlight.entity.Page;
import bz.sunlight.entity.PageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PageMapper extends BaseMapper<Page, PageExample, String> {
  public List<Page> getMenuByByExample(@Param("userId") String userId, @Param("enterpriseId") String enterpriseId);
}