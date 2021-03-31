package ${package}.config.openfeign;

import ${package}.exception.http.BadRequest;
import ${package}.exception.http.InternalServerError;
import ${package}.exception.http.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OpenFeignErrorDecoder implements ErrorDecoder {

	@Override
	public Exception decode(String msg, Response response) {
		var httpStatus = HttpStatus.resolve(response.status());
		var reason = response.reason();
		switch (httpStatus) {
			case BAD_REQUEST:
				throw new BadRequest();
			case NOT_FOUND:
				throw new NotFoundException();
			default:
				log.error("Error {} due \"{}\". Body: {}", httpStatus, reason, response.body());
				throw new InternalServerError();
		}
	}
}
