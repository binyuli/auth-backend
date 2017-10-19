package bz.sunlight.service;

import bz.sunlight.dto.CommonDTO;

import java.util.Date;

public abstract class AbstractBaseService {
  /**
   * 带参构建通用对象.
   * @param creator.
   * @param enterpriseId.
   * @return CommonDTO
   */
  //TODO 此处当前登录用户后期调整系统框架获得
  public CommonDTO createCommonDTO(String creator, String enterpriseId) {
    CommonDTO commonDTO = new CommonDTO();
    commonDTO.setCreateTime(new Date());
    commonDTO.setCreator(creator);
    commonDTO.setEnterpriseId(enterpriseId);
    commonDTO.setModifyTime(new Date());
    return commonDTO;
  }

  /**
   * 无参构建通用对象.
   * @return CommonDTO
   */
  public CommonDTO createCommonDTO() {
    CommonDTO commonDTO = new CommonDTO();
    commonDTO.setCreateTime(new Date());
    commonDTO.setCreator("123");
    commonDTO.setEnterpriseId("786b67b6-b424-11e7-b9e5-005056af50a8");
    commonDTO.setModifyTime(new Date());
    return commonDTO;
  }
}
