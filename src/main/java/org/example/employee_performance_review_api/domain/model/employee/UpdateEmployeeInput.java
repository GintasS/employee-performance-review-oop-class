package org.example.employee_performance_review_api.domain.model.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdateEmployeeInput {

    private UUID id;
    private String firstName;
    private String lastName;
    private Team team;
    private PerformanceRating rating;
    private EmployeeType type;
    private int yearlySalary;
    private int employmentTime;
    private List<Integer> yearlyBonuses;

    // TODO finish all the values
}
