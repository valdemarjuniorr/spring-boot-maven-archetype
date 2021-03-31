package ${package}.config;

import ${package}.exception.AbstractUserResponseException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
class ErrorResponse {

  private String title;
  private String detail;

  public ErrorResponse(AbstractUserResponseException e) {
    this.title = e.getTitle();
    this.detail = e.getDetail();
  }
}
