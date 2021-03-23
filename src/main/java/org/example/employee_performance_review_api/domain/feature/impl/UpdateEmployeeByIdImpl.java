package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindEmployeeById;
import org.example.employee_performance_review_api.domain.feature.UpdateEmployeeById;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.domain.model.employee.UpdateEmployeeInput;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@AllArgsConstructor
public class UpdateEmployeeByIdImpl implements UpdateEmployeeById {

  private final EmployeeRepository employeeRepository;
  private final FindEmployeeById findEmployeeById;
  private final ModelValidator modelValidator;

  @Override
  public Employee handle(UpdateEmployeeInput updateEmployeeInput) {
    final var employee = findEmployeeById.handle(updateEmployeeInput.getId());

    if (atLeastOneFieldIsNotBlank(updateEmployeeInput)) {
      if (isNotBlank(updateEmployeeInput.getFirstName())) {
        employee.setFirstName(updateEmployeeInput.getFirstName());
      }
      if (isNotBlank(updateEmployeeInput.getLastName())) {
        employee.setLastName(updateEmployeeInput.getLastName());
      }

      if (isNotBlank(updateEmployeeInput.getTeam().toString())) {
        employee.setTeam(updateEmployeeInput.getTeam());
      }

      if (isNotBlank(updateEmployeeInput.getRating().toString())) {
        employee.setRating(updateEmployeeInput.getRating());
      }
      if (isNotBlank(updateEmployeeInput.getType().toString())) {
        employee.setType(updateEmployeeInput.getType());
      }

      if (updateEmployeeInput.getYearlyBonuses().size() > 0) {
        employee.setYearlyBonuses(updateEmployeeInput.getYearlyBonuses());
      }

      // TODO Think about integers, should we validate them here.

      employeeRepository.update(modelValidator.validate(employee));
    }

    return employee;
  }

  private boolean atLeastOneFieldIsNotBlank(UpdateEmployeeInput updateEmployeeInput) {
    return  isNotBlank(updateEmployeeInput.getFirstName()) ||
            isNotBlank(updateEmployeeInput.getLastName()) ||
            isNotBlank(updateEmployeeInput.getTeam().toString()) ||
            isNotBlank(updateEmployeeInput.getRating().toString()) ||
            isNotBlank(updateEmployeeInput.getType().toString()) ||
            updateEmployeeInput.getYearlyBonuses().size() > 0;
  }
}
