package org.example.employee_performance_review_api.domain.feature;

import java.util.List;
import org.example.employee_performance_review_api.domain.model.employee.Employee;

public interface FindEmployees {
  List<Employee> handle();
}
