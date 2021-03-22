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
import java.util.UUID;

@Getter
@Setter
@JsonRootName("employee")
@RegisterForReflection
public class EmployeeResponse {
    UUID id; //REST endpoint
    String firstName; //Employee's first name
    String lastName; //Employee's last name
    Team team; //What team the employee belongs to - Senior Management receives double bonus.
    PerformanceRating rating;//What the employee's performance review was - Exceptional performance increases the bonus by 50%
    EmployeeType type; //Interns get no bonuses.
    int yearlySalary; //What the employee's current yearly salary is - 5 year bonuses cannot exceed current yearly salary x6
    int employmentTime; //How long (in years) the employee has worked in the company - time defines the percentage of yearly salary for the bonus
    List<Integer> yearlyBonuses = new ArrayList<Integer>(); //The list of previous bonuses that are relevant to the bonus calculation.

    public EmployeeResponse(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();


        // TODO: map all the remaining values.
    }
}
