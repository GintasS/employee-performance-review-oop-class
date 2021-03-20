package org.example.employee_performance_review_api.domain.exception;

public class UsernameAlreadyExistsException extends BusinessException {

  public UsernameAlreadyExistsException() {
    super(2, "username already exists");
  }
}
