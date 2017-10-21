package bz.sunlight.handler;

import bz.sunlight.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(value = BusinessException.class)
  public ResponseEntity<ErrorInfo> jsonErrorHandler(BusinessException e) throws Exception {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorInfo(e.getCode(), e.getMessage()));
  }

  protected class ErrorInfo {
    private String code;
    private String message;

    public ErrorInfo(String code, String message) {
      this.code = code;
      this.message = message;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }
  }
}
