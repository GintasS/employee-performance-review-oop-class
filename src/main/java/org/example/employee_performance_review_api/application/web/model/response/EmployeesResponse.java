package org.example.employee_performance_review_api.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName("employees")
@RegisterForReflection
public class EmployeesResponse {
  List<EmployeeResponse> employees;

  public EmployeesResponse(List<EmployeeResponse> employees) {
    this.employees = employees;
  }
}
