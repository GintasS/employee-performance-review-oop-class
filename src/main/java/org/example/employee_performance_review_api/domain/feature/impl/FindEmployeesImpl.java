package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.FindEmployees;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.EntityUtils;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class FindEmployeesImpl implements FindEmployees {

    private final EmployeeRepository employeeRepository;
    private final EntityUtils entityUtils;

    @Override
    public List<Employee> handle() {

        return employeeRepository.findAllEmployees()
                .stream()
                .map(entityUtils::employee)
                .collect(Collectors.toList());
    }
}
