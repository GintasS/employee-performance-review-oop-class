package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.feature.CreateEmployee;
import org.example.employee_performance_review_api.domain.feature.FindEmployees;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeModelBuilder;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.domain.model.employee.NewEmployeeInput;

import javax.ws.rs.core.Response;
import java.util.List;

@AllArgsConstructor
public class FindEmployeesImpl implements FindEmployees {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> handle() {
        final var employees = employeeRepository.findAllEmployees();

        return employees;
    }
}
