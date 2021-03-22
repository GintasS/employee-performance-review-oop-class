package org.example.employee_performance_review_api.domain.feature.impl;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.application.web.model.response.EmployeeResponse;
import org.example.employee_performance_review_api.domain.feature.CreateEmployee;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeModelBuilder;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.domain.model.employee.NewEmployeeInput;

@AllArgsConstructor
public class CreateEmployeeImpl implements CreateEmployee {

    private final EmployeeRepository employeeRepository;
    private final EmployeeModelBuilder employeeModelBuilder;

    @Override
    public Employee handle(NewEmployeeInput newEmployeeInput) {
        final var employee =
                employeeModelBuilder.build(
                        newEmployeeInput.getFirstName(),
                        newEmployeeInput.getLastName());

        employeeRepository.save(employee);
        return employee;
    }
}
