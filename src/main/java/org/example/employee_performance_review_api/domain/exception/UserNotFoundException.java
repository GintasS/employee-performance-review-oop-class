package org.example.employee_performance_review_api.domain.exception;

public class UserNotFoundException extends BusinessException {

  public UserNotFoundException() {
    super(1, "user not found");
  }
}
