package org.example.employee_performance_review_api.domain.exception;

public class EmployeeNotFoundException extends BusinessException {

  public EmployeeNotFoundException() {
    super(100, "Employee not found");
  }
}
