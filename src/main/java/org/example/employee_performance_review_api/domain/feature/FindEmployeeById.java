package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.employee.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FindEmployeeById {
    Employee handle(UUID id);
}
