package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.UpdateEmployeeInput;
import org.example.employee_performance_review_api.domain.model.user.UpdateUserInput;
import org.example.employee_performance_review_api.domain.model.user.User;

import java.util.UUID;

public interface UpdateEmployeeById {
  Employee handle(UpdateEmployeeInput updateEmployeeInput);
}
