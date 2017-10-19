package bz.sunlight.service;

import java.util.Date;

import bz.sunlight.dto.CommonDTO;

public abstract class AbstractBaseService {
  //TODO 此处当前登录用户后期调整系统框架获得
  public CommonDTO createCommonDTO(String creator, String enterpriseId) {
    CommonDTO commonDTO = new CommonDTO();
    commonDTO.setCreateTime(new Date());
    commonDTO.setCreator(creator);
    commonDTO.setEnterpriseId(enterpriseId);
    commonDTO.setModifyTime(new Date());
    return commonDTO;
  }
  public CommonDTO createCommonDTO() {
    CommonDTO commonDTO = new CommonDTO();
    commonDTO.setCreateTime(new Date());
    commonDTO.setCreator("123");
    commonDTO.setEnterpriseId("786b67b6-b424-11e7-b9e5-005056af50a8");
    commonDTO.setModifyTime(new Date());
    return commonDTO;
  }
}
