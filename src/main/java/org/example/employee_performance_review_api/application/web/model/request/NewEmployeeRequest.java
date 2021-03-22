package org.example.employee_performance_review_api.application.web.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.employee.NewEmployeeInput;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

import java.util.List;

@Getter
@Setter
@JsonRootName("employee")
@RegisterForReflection
public class NewEmployeeRequest {

    private String firstName;
    private String lastName;
    private Team team;
    private PerformanceRating rating;
    private EmployeeType type;
    private int yearlySalary;
    private int employmentTime;
    private List<Integer> yearlyBonuses;

    public NewEmployeeInput toNewEmployeeInput() {
        return new NewEmployeeInput(this.firstName, this.lastName, this.team, this.rating, this.type, this.yearlySalary, this.employmentTime, this.yearlyBonuses);
    }
}
