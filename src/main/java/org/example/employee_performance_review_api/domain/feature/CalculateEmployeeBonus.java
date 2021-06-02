package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.employee.Employee;

import java.math.BigDecimal;

public interface CalculateEmployeeBonus {
    BigDecimal handle(Employee employee);
}
