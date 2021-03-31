package ${package}.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class JsonUtilsTest {

  private static final String JSON = "{\"id\":\"id\",\"description\":\"description\"}";
  private ToJsonObject jsonObject = new ToJsonObject("id", "description");

  @Test
  void whenObjectIsOkToConvertToJson() {
    var json = JsonUtils.toJson(this.jsonObject);
    assertThat(json).isEqualTo(JSON);
  }

  @Test
  void whenParamIsNullExceptionToJson() {
    assertThatThrownBy(() -> JsonUtils.toJson(null))
        .hasMessage("parameter must not be null")
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void whenParamJsonIsNullExceptionToObject() {
    assertThatThrownBy(() -> JsonUtils.toObject(null, ToJsonObject.class))
        .hasMessage("parameter must not be null or empty")
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void whenParamClazzIsNullExceptionToObject() {
    assertThatThrownBy(() -> JsonUtils.toObject(JSON, null))
        .hasMessage("parameter clazz must not be null")
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  void whenJsonIsOkToConvertToObject() {
    var object = JsonUtils.toObject(JSON, ToJsonObject.class);
    assertThat(object).usingRecursiveComparison().isEqualTo(this.jsonObject);
  }

  @Getter
  @NoArgsConstructor
  @AllArgsConstructor
  private static class ToJsonObject {
    private String id;
    private String description;
  }
}
