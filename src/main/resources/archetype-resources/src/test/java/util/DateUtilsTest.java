package ${package}.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

public class DateUtilsTest {

	@Test
	public void asLocalDate() {
		var date = DateUtils.asLocalDate("2020-12-18");
		assertThat(date.getDayOfMonth()).isEqualTo(18);
		assertThat(date.getMonth()).isEqualTo(Month.DECEMBER);
		assertThat(date.getYear()).isEqualTo(2020);
	}

	@Test
	public void asString() {
		var dateAsString = LocalDate.of(2020, Month.DECEMBER, 18);
		assertThat(DateUtils.asString(dateAsString)).isEqualTo("18/12/2020");
	}

	@Test
	public void asTime() {
		var dateTime = LocalDateTime.now().withHour(14).withMinute(01).withSecond(15);
		assertThat(DateUtils.asTime(dateTime)).isEqualTo("14:01:15");
	}

	@Test
	public void asStringLocalDateTime() {
		var localDateTime = getLocalDateTime();
		var asString = DateUtils.asString(localDateTime);

		assertThat(asString).isEqualTo("08/03/2021");
	}

	@Test
	public void asLocalDateTime() {
		var localDateTime = getLocalDateTime();
		assertThat(localDateTime.getYear()).isEqualTo(2021);
		assertThat(localDateTime.getMonth()).isEqualTo(Month.MARCH);
		assertThat(localDateTime.getDayOfMonth()).isEqualTo(8);
		assertThat(localDateTime.getHour()).isEqualTo(12);
		assertThat(localDateTime.getMinute()).isEqualTo(13);
		assertThat(localDateTime.getSecond()).isEqualTo(14);
	}

	private LocalDateTime getLocalDateTime() {
		return DateUtils.asLocalDateTime("2021-03-08T12:13:14");
	}
}
