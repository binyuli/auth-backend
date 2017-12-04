package bz.sunlight.api;

import bz.sunlight.dto.CommonDTO;
import bz.sunlight.entity.User;
import bz.sunlight.service.UserService;
import bz.sunlight.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class BaseContext {
  @Autowired
  private  UserService userService;

  protected ResultInfo buildResultInfo(String message, Object payload) {
    return new ResultInfo(message, payload);
  }

  /**
   * 获取当前登录用户.
   *
   * @return loginUser
   */
  public LoginUser getLoginUser(HttpServletRequest request) {
    String userId = request.getHeader("X-USER-ID");
    if (userId == null) {
      return null;
    }
    User user = this.userService.getUserById(userId);
    if (user == null) {
      return null;
    }
    //TODO 当前默认admin用户，待认证授权完成后调整为从系统框架获得当前用户
    LoginUser loginUser = new LoginUser();
    loginUser.setId(user.getId());
    loginUser.setUsername(user.getUsername());
    loginUser.setEnterpriseId(user.getEnterpriseId());
    loginUser.setName(user.getName());
    loginUser.setOpenId(user.getOpenId());
    return loginUser;
  }

  /**
   * 无参构建通用对象.
   *
   * @return CommonDTO
   */
  public CommonDTO createCommonDTO(HttpServletRequest request) {
    LoginUser loginUser = getLoginUser(request);
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
