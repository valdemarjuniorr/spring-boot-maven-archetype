package ${package}.config;

import ${package}.exception.AbstractUserResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/** Class responsible to intercept all exception which extends from AbstractUserResponseException */
@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(AbstractUserResponseException.class)
  public ResponseEntity<ErrorResponse> handleException(AbstractUserResponseException e) {
    return ResponseEntity.status(e.getStatus()).body(new ErrorResponse(e));
  }
}
