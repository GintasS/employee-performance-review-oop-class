package org.example.employee_performance_review_api.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

import java.util.ArrayList;
import java.util.List;

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
