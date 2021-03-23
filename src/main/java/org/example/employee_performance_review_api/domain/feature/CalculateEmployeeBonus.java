package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.employee.Employee;

import java.util.UUID;

public interface CalculateEmployeeBonus {
    double handle(Employee employee);
}
