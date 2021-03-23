package org.example.employee_performance_review_api.application.web.model.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.constants.ValidationMessages;
import org.example.employee_performance_review_api.domain.model.employee.Employee;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@JsonRootName("employee")
@RegisterForReflection
public class EmployeeResponse {

    private UUID id;
    private String firstName;
    private String lastName;
    private Team team;
    private PerformanceRating rating;
    private EmployeeType type;
    private int yearlySalary;
    private int employmentTime;
    private List<Integer> yearlyBonuses;

    public EmployeeResponse(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.team = employee.getTeam();
        this.rating = employee.getRating();
        this.type = employee.getType();
        this.yearlySalary = employee.getYearlySalary();
        this.employmentTime = employee.getEmploymentTime();
        this.yearlyBonuses = employee.getYearlyBonuses();
    }
}
