package org.example.employee_performance_review_api.domain.model.employee;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.employee_performance_review_api.domain.model.constants.ValidationMessages;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.PerformanceRating;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {

    // This is a unique identifier for every employee.
    @NotNull
    private UUID id;

    @NotBlank(message = ValidationMessages.EMPLOYEE_FIRST_NAME_MUST_BE_NOT_BLANK)
    private String firstName;

    @NotBlank(message = ValidationMessages.EMPLOYEE_LAST_NAME_MUST_BE_NOT_BLANK)
    private String lastName;

    // What team the employee belongs to - Senior Management receives double bonus.
    private Team team;

    // What the employee's performance review is.
    // Exceptional performance increases the bonus by 50%.
    private PerformanceRating rating;

    // Interns get no bonuses.
    private EmployeeType type;

    // What the employee's current yearly salary is.
    // 5 year bonuses cannot exceed current yearly salary 6 times.
    private BigDecimal yearlySalary;

    // How long (in years) the employee has worked in the company.
    // Time defines the percentage of yearly salary for the bonus.
    private int employmentTime;

    // The list of previous bonuses that are relevant to the bonus calculation.
    private List<BigDecimal> yearlyBonuses;
}
