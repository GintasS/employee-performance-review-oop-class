package org.example.employee_performance_review_api.domain.exception;

public class InvalidPasswordException extends BusinessException {
  public InvalidPasswordException() {
    super(4, "invalid password");
  }
}
