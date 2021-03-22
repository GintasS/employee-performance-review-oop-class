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
      // TODO finish this

      employeeRepository.update(modelValidator.validate(employee));
    }

    return employee;
  }

  private boolean atLeastOneFieldIsNotBlank(UpdateEmployeeInput updateEmployeeInput) {
    return isNotBlank(updateEmployeeInput.getFirstName()) ||
            isNotBlank(updateEmployeeInput.getLastName());
  }
}
