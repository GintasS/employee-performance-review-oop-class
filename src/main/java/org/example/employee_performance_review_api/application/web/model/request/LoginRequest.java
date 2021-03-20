package org.example.employee_performance_review_api.application.web.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.constants.ValidationMessages;
import org.example.employee_performance_review_api.domain.model.user.LoginUserInput;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonRootName("user")
@RegisterForReflection
public class LoginRequest {

  @NotBlank(message = ValidationMessages.EMAIL_MUST_BE_NOT_BLANK)
  private String email;

  @NotBlank(message = ValidationMessages.PASSWORD_MUST_BE_NOT_BLANK)
  private String password;

  public LoginUserInput toLoginUserInput() {
    return new LoginUserInput(this.email, this.password);
  }
}
