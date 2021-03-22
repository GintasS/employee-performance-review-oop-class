package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.DeleteEmployeeById;
import org.example.employee_performance_review_api.domain.feature.FindEmployeeById;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;

import java.util.UUID;

@AllArgsConstructor
public class DeleteEmployeeByIdImpl implements DeleteEmployeeById {

    private final EmployeeRepository employeeRepository;
    private final FindEmployeeById findEmployeeById;

    @Override
    public void handle(UUID id) {
        final var employee = findEmployeeById.handle(id);
        employeeRepository.delete(employee);
    }
}
