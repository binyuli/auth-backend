package bz.sunlight.api;

import bz.sunlight.dto.CommonDTO;
import bz.sunlight.vo.LoginUser;

import java.util.Date;

public class BaseContext {
  protected ResultInfo buildResultInfo(String message, Object payload) {
    return new ResultInfo(message, payload);
  }

  /**
   * 获取当前登录用户.
   *
   * @return loginUser
   */
  public static LoginUser getLoginUser() {
    //TODO 当前默认admin用户，待认证授权完成后调整为从系统框架获得当前用户
    LoginUser loginUser = new LoginUser();
    loginUser.setId("4d3b30d7-0e08-4ed9-bc98-315a3cd20399");
    loginUser.setUsername("admin");
    loginUser.setEnterpriseId("786b67b6-b424-11e7-b9e5-005056af50a8");
    return loginUser;
  }

  /**
   * 无参构建通用对象.
   *
   * @return CommonDTO
   */
  public CommonDTO createCommonDTO() {
    LoginUser loginUser = getLoginUser();
    Date now = new Date();
    CommonDTO commonDTO = new CommonDTO();
    commonDTO.setCreateTime(now);
    commonDTO.setCreator(loginUser.getUsername());
    commonDTO.setEnterpriseId(loginUser.getEnterpriseId());
    commonDTO.setModifyTime(now);
    return commonDTO;
  }

  protected class ResultInfo {
    private String message = null;
    private Object payload = null;

    public ResultInfo(String message, Object payload) {
      this.message = message;
      this.payload = payload;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }

    public Object getPayload() {
      return payload;
    }

    public void setPayload(Object payload) {
      this.payload = payload;
    }
  }

}
