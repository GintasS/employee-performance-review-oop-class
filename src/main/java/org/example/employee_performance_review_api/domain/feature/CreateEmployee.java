package org.example.employee_performance_review_api.domain.feature;

import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.NewEmployeeInput;

public interface CreateEmployee {
    Employee handle(NewEmployeeInput newEmployeeInput);
}
