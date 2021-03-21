package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.*;
import org.example.employee_performance_review_api.domain.model.article.Article;
import org.example.employee_performance_review_api.domain.model.article.ArticleRepository;
import org.example.employee_performance_review_api.domain.model.article.UpdateArticleInput;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.domain.model.employee.UpdateEmployeeInput;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

import java.time.LocalDateTime;
import java.util.UUID;

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
