package ${package}.config;

import ${package}.util.DateUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Class responsible to convert LocalDate and LocalDateTime as String into Objects in restTemplate
 * requests.
 */
@ControllerAdvice
public class LocalDateTimeRequestConfig {

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.registerCustomEditor(
        LocalDate.class,
        new PropertyEditorSupport() {
          @Override
          public void setAsText(String localDateAsString) throws IllegalArgumentException {
            setValue(DateUtils.asLocalDate(localDateAsString));
          }
        });
    binder.registerCustomEditor(
        LocalDateTime.class,
        new PropertyEditorSupport() {
          @Override
          public void setAsText(String localDateTimeAsString) throws IllegalArgumentException {
            setValue(DateUtils.asLocalDateTime(localDateTimeAsString));
          }
        });
  }
}
