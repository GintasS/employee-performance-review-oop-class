package org.example.employee_performance_review_api.domain.model.employee;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.inject.Named;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

@Named
@AllArgsConstructor
public class EmployeeModelBuilder {
  private final ModelValidator modelValidator;

  public Employee build(
      String firstName,
      String lastName,
      Team team,
      PerformanceRating rating,
      EmployeeType employeeType,
      BigDecimal yearlySalary,
      int employmentTime,
      List<BigDecimal> yearlyBonuses) {

    return modelValidator.validate(
        new Employee(
            UUID.randomUUID(),
            firstName,
            lastName,
            team,
            rating,
            employeeType,
            yearlySalary,
            employmentTime,
            yearlyBonuses));

    // TODO: Fix this place to validate the user input.
  }

  public Employee build(
      UUID id,
      String firstName,
      String lastName,
      Team team,
      PerformanceRating rating,
      EmployeeType employeeType,
      BigDecimal yearlySalary,
      int employmentTime,
      List<BigDecimal> yearlyBonuses) {

    return modelValidator.validate(
        new Employee(
            id,
            firstName,
            lastName,
            team,
            rating,
            employeeType,
            yearlySalary,
            employmentTime,
            yearlyBonuses));

    // TODO: Fix this place to validate the user input.
  }
}
