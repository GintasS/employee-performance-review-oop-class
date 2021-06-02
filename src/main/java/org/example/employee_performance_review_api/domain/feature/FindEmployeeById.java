package org.example.employee_performance_review_api.domain.feature;

import java.util.UUID;
import org.example.employee_performance_review_api.domain.model.employee.Employee;

public interface FindEmployeeById {
  Employee handle(UUID id);
}
