package org.example.employee_performance_review_api.domain.model.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

import java.util.List;

@Data
@AllArgsConstructor
public class NewEmployeeInput {

    private String firstName;
    private String lastName;
    private Team team;
    private PerformanceRating rating;
    private EmployeeType type;
    private int yearlySalary;
    private int employmentTime;
    private List<Integer> yearlyBonuses;
}
