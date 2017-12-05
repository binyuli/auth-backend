package bz.sunlight.api;

import bz.sunlight.dto.CommonDTO;
import bz.sunlight.entity.User;
import bz.sunlight.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class BaseContext {
  @Autowired
  private  UserService userService;

  protected ResultInfo buildResultInfo(String message, Object payload) {
    return new ResultInfo(message, payload);
  }

  /**
   * 无参构建通用对象.
   *
   * @return CommonDTO
   */
  public CommonDTO createCommonDTO(String userId) {
    User user = userService.getUserById(userId);
    Date now = new Date();
    CommonDTO commonDTO = new CommonDTO();
    commonDTO.setCreateTime(now);
    commonDTO.setCreator(user.getUsername());
    commonDTO.setEnterpriseId(user.getEnterpriseId());
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
