package bz.sunlight.api;

import bz.sunlight.service.UserService;
import bz.sunlight.vo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseContext {
  @Autowired
  private UserService userService;

  protected ResultInfo buildResultInfo(String message, Object payload) {
    return new ResultInfo(message, payload);
  }

  /**
   * 获取当前登录用户.
   *
   * @return loginUser
   */
  public LoginUser getLoginUser(String userId) {
    LoginUser user = this.userService.getUserById(userId);
    return user;
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
