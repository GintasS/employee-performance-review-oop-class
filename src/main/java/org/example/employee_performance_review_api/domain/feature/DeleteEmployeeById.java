package org.example.employee_performance_review_api.domain.feature;

import java.util.UUID;

public interface DeleteEmployeeById {
  void handle(UUID id);
}
