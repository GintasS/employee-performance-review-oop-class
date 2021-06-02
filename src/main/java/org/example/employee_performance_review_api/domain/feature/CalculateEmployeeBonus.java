package org.example.employee_performance_review_api.domain.feature;

import java.math.BigDecimal;
import org.example.employee_performance_review_api.domain.model.employee.Employee;

public interface CalculateEmployeeBonus {
  BigDecimal handle(Employee employee);
}
