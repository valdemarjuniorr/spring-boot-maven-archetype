package ${package}.exception;

import org.springframework.http.HttpStatus;

/**
 * Abstraction which exceptions should extends to make them return the json structure, for example {
 * "title": "summary about the error", "detail": "more detailed description about the error",
 * "status": "200" }
 */
public abstract class AbstractUserResponseException extends RuntimeException {

  /** the summary about the error */
  public abstract String getTitle();

  /** More detailed description about the error */
  public abstract String getDetail();

  /** Http status error */
  public abstract HttpStatus getStatus();
}
