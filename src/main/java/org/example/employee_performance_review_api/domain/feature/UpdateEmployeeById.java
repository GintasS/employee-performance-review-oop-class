package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.UpdateEmployeeInput;

public interface UpdateEmployeeById {
  Employee handle(UpdateEmployeeInput updateEmployeeInput);
}
