package org.example.employee_performance_review_api.domain.feature.impl;

import java.util.UUID;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.exception.EmployeeNotFoundException;
import org.example.employee_performance_review_api.domain.feature.FindEmployeeById;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.EntityUtils;

@AllArgsConstructor
public class FindEmployeeByIdImpl implements FindEmployeeById {

  private final EmployeeRepository employeeRepository;
  private final EntityUtils entityUtils;

  @Override
  public Employee handle(UUID id) {
    return employeeRepository
        .findEmployeeById(id)
        .map(entityUtils::employee)
        .orElseThrow(EmployeeNotFoundException::new);
  }
}
