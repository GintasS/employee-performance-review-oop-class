package org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeModelBuilder;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@AllArgsConstructor
public class EntityUtils {
  private final EmployeeModelBuilder employeeBuilder;

  public Employee employee(EmployeeEntity employeeEntity) {
    final var id = employeeEntity.getId();
    final var firstName = employeeEntity.getFirstName();
    final var lastName = employeeEntity.getLastName();
    // TODO map this
    return employeeBuilder.build(id, firstName, lastName);
  }
}
