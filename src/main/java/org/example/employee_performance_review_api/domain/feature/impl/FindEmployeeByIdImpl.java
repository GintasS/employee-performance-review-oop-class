package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.exception.EmployeeNotFoundException;
import org.example.employee_performance_review_api.domain.feature.FindEmployeeById;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import java.util.UUID;

@AllArgsConstructor
public class FindEmployeeByIdImpl implements FindEmployeeById {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee handle(UUID id) {
        return employeeRepository.findEmployeeById(id).orElseThrow(EmployeeNotFoundException::new);
    }
}
