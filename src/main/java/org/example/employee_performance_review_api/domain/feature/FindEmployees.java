package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.NewEmployeeInput;

import java.util.List;

public interface FindEmployees {
    List<Employee> handle();
}
