package org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity;

import java.util.UUID;
import javax.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeModelBuilder;

@ApplicationScoped
@AllArgsConstructor
public class EntityUtils {
  private final EmployeeModelBuilder employeeBuilder;

  public Employee employee(EmployeeEntity employeeEntity) {
    final var id = UUID.fromString(employeeEntity.getId());
    final var firstName = employeeEntity.getFirstName();
    final var lastName = employeeEntity.getLastName();
    final var team = employeeEntity.getTeam();
    final var rating = employeeEntity.getRating();
    final var type = employeeEntity.getType();
    final var yearlySalary = employeeEntity.getYearlySalary();
    final var employmentTime = employeeEntity.getEmploymentTime();
    final var yearlyBonuses = employeeEntity.getYearlyBonuses();

    return employeeBuilder.build(
        id, firstName, lastName, team, rating, type, yearlySalary, employmentTime, yearlyBonuses);
  }
}
