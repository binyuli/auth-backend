package bz.sunlight.dao;

import bz.sunlight.BaseMapper;
import bz.sunlight.entity.Page;
import bz.sunlight.entity.PageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PageMapper extends BaseMapper<Page, PageExample, String> {
  List<Page> getMenuByByExample(@Param("userId") String userId);

  List<Page> getPageByRole(@Param("roleId") String roleId);
}