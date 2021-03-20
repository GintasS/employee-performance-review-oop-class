package org.example.employee_performance_review_api.domain.exception;

public class EmailAlreadyExistsException extends BusinessException {

  public EmailAlreadyExistsException() {
    super(3, "email already exists");
  }
}
