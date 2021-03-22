package org.example.employee_performance_review_api.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

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
