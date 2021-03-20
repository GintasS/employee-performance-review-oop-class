package org.example.employee_performance_review_api.domain.model.user;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

import javax.inject.Named;
import java.util.UUID;

@Named
@AllArgsConstructor
public class UserModelBuilder {
  private final ModelValidator modelValidator;

  public User build(String username, String email, String password) {
    return modelValidator.validate(
        new User(UUID.randomUUID(), username, email, password, null, null));
  }

  public User build(
      UUID id, String username, String bio, String image, String password, String email) {
    return modelValidator.validate(new User(id, username, email, password, bio, image));
  }
}
