package org.example.employee_performance_review_api.application.web.resource.utils;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.application.web.model.response.EmployeeBonusResponse;
import org.example.employee_performance_review_api.application.web.model.response.EmployeeResponse;
import org.example.employee_performance_review_api.application.web.model.response.EmployeesResponse;
import org.example.employee_performance_review_api.domain.model.employee.Employee;

@ApplicationScoped
@AllArgsConstructor
public class ResourceUtils {

  public EmployeesResponse employeesResponse(List<Employee> employees) {
    final var resultsResponse =
        employees.stream().map(this::employeeResponse).collect(Collectors.toList());

    return new EmployeesResponse(resultsResponse);
  }

  public EmployeeResponse employeeResponse(Employee employee) {
    return new EmployeeResponse(employee);
  }

  public EmployeeBonusResponse employeeBonusResponse(BigDecimal bonus) {
    return new EmployeeBonusResponse(bonus);
  }
}
