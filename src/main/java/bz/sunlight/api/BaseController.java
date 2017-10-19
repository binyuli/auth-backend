package bz.sunlight.api;

public class BaseController {
  protected ResultInfo buildResultInfo(String message,Object payload){
    return  new ResultInfo(message,payload);
  }
  protected class ResultInfo{
    private String message = null;
    private Object payload = null;

    public ResultInfo(String message,Object payload) {
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
