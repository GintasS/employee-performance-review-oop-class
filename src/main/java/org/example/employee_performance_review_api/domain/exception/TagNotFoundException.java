package org.example.employee_performance_review_api.domain.exception;

public class TagNotFoundException extends BusinessException {

  public TagNotFoundException() {
    super(7, "tag not found");
  }
}
