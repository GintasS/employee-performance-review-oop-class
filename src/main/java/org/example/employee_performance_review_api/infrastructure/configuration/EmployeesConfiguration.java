package org.example.employee_performance_review_api.infrastructure.configuration;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import org.example.employee_performance_review_api.domain.feature.CalculateEmployeeBonus;
import org.example.employee_performance_review_api.domain.feature.CreateEmployee;
import org.example.employee_performance_review_api.domain.feature.DeleteEmployeeById;
import org.example.employee_performance_review_api.domain.feature.FindEmployeeById;
import org.example.employee_performance_review_api.domain.feature.FindEmployees;
import org.example.employee_performance_review_api.domain.feature.UpdateEmployeeById;
import org.example.employee_performance_review_api.domain.feature.impl.CalculateEmployeeBonusImpl;
import org.example.employee_performance_review_api.domain.feature.impl.CreateEmployeeImpl;
import org.example.employee_performance_review_api.domain.feature.impl.DeleteEmployeeByIdImpl;
import org.example.employee_performance_review_api.domain.feature.impl.FindEmployeeByIdImpl;
import org.example.employee_performance_review_api.domain.feature.impl.FindEmployeesImpl;
import org.example.employee_performance_review_api.domain.feature.impl.UpdateEmployeeByIdImpl;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeModelBuilder;
import org.example.employee_performance_review_api.domain.model.employee.EmployeeRepository;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;
import org.example.employee_performance_review_api.infrastructure.repository.hibernate.entity.EntityUtils;

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
  public FindEmployees findEmployees(
      EmployeeRepository employeeRepository, EntityUtils entityUtils) {
    return new FindEmployeesImpl(employeeRepository, entityUtils);
  }

  @Produces
  @Singleton
  public DeleteEmployeeById deleteEmployeeById(
      EmployeeRepository employeeRepository, FindEmployeeById findEmployeeById) {
    return new DeleteEmployeeByIdImpl(employeeRepository, findEmployeeById);
  }

  @Produces
  @Singleton
  public UpdateEmployeeById updateEmployeeById(
      EmployeeRepository employeeRepository,
      FindEmployeeById findEmployeeById,
      ModelValidator modelValidator) {
    return new UpdateEmployeeByIdImpl(employeeRepository, findEmployeeById, modelValidator);
  }

  @Produces
  @Singleton
  public CalculateEmployeeBonus calculateEmployeeBonus() {
    return new CalculateEmployeeBonusImpl();
  }

  @Produces
  @Singleton
  public FindEmployeeById findEmployeeById(
      EmployeeRepository employeeRepository, EntityUtils entityUtils) {
    return new FindEmployeeByIdImpl(employeeRepository, entityUtils);
  }

  @Produces
  @Singleton
  public EmployeeModelBuilder employeeModelBuilder(ModelValidator modelValidator) {
    return new EmployeeModelBuilder(modelValidator);
  }
}
