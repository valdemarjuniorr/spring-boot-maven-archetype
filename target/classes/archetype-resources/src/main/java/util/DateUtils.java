package ${package}.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtils {

	public final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	public final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
	public final DateTimeFormatter DATE_TIME_FORMATTER =
		DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

	private static final String DD_MM_YYYY = "dd/MM/yyyy";

	/** Convert string to LocalDate. String format expected 2021-03-31 */
	public LocalDate asLocalDate(String date) {
		return LocalDate.parse(date);
	}

	/** Method responsible to convert localDate to brazilian format {@link DateUtils#DD_MM_YYYY} */
	public String asString(LocalDate date) {
		return date.format(DateTimeFormatter.ofPattern(DD_MM_YYYY));
	}

	/** Method responsible to convert localDate to brazilian format {@link DateUtils#DD_MM_YYYY} */
	public String asString(LocalDateTime dateTime) {
		return asString(dateTime.toLocalDate());
	}

	/** Method responsible to return hour, minute and second from LocalDateTime Object as String */
	public String asTime(LocalDateTime dateTime) {
		return dateTime.format(TIME_FORMATTER);
	}

	/** Convert string to LocalDateTime. String format expected 2021-03-08T12:13:14 */
	public LocalDateTime asLocalDateTime(String localDateTime) {
		return LocalDateTime.parse(localDateTime);
	}
}
