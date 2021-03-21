package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.exception.EmployeeNotFoundException;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.NewEmployeeInput;

import java.util.UUID;

public interface DeleteEmployeeById {
    void handle(UUID id);
}
