package org.example.employee_performance_review_api.infrastructure.configuration;

import org.example.employee_performance_review_api.domain.feature.*;
import org.example.employee_performance_review_api.domain.feature.impl.*;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeModelBuilder;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.domain.model.employee.UpdateEmployeeInput;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Dependent
public class EmployeesConfiguration {

  @Produces
  @Singleton
  public CreateEmployee createEmployee(
          EmployeeRepository employeeRepository, EmployeeModelBuilder employeeModelBuilder) {
    return new CreateEmployeeImpl(employeeRepository, employeeModelBuilder);
  }

  @Produces
  @Singleton
  public FindEmployees findEmployees(EmployeeRepository employeeRepository) {
    return new FindEmployeesImpl(employeeRepository);
  }

  @Produces
  @Singleton
  public DeleteEmployeeById deleteEmployeeById(EmployeeRepository employeeRepository, FindEmployeeById findEmployeeById) {
    return new DeleteEmployeeByIdImpl(employeeRepository, findEmployeeById);
  }

  @Produces
  @Singleton
  public UpdateEmployeeById updateEmployeeById(EmployeeRepository employeeRepository, FindEmployeeById findEmployeeById, ModelValidator modelValidator) {
    return new UpdateEmployeeByIdImpl(employeeRepository, findEmployeeById, modelValidator);
  }

  @Produces
  @Singleton
  public FindEmployeeById findEmployeeById(EmployeeRepository employeeRepository) {
    return new FindEmployeeByIdImpl(employeeRepository);
  }

  @Produces
  @Singleton
  public EmployeeModelBuilder employeeModelBuilder(ModelValidator modelValidator) {
    return new EmployeeModelBuilder(modelValidator);
  }


}
