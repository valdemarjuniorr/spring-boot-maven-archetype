package ${package}.config.openfeign;

import ${package}.util.DateUtils;
import org.springframework.cloud.openfeign.FeignFormatterRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;

/**
 * Class responsible to register OpenFeign date formatter. Spring Boot by default will accept these
 * Date and Time format pattern according to our locale settings.
 */
@Configuration(proxyBeanMethods = false)
public class OpenFeignFormatRegister {

  @Bean
  public FeignFormatterRegistrar feignFormatterRegistrar() {
    return registry -> {
      var registrar = new DateTimeFormatterRegistrar();
      registrar.setUseIsoFormat(Boolean.FALSE);
      registrar.setDateFormatter(DateUtils.DATE_FORMATTER);
      registrar.setTimeFormatter(DateUtils.TIME_FORMATTER);
      registrar.setDateTimeFormatter(DateUtils.DATE_TIME_FORMATTER);

      registrar.registerFormatters(registry);
    };
  }
}
