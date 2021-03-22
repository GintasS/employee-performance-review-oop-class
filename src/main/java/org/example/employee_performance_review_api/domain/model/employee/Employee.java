package org.example.employee_performance_review_api.domain.model.employee;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.employee_performance_review_api.domain.model.constants.ValidationMessages;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Employee {

    @NotNull
    private UUID id; //REST endpoint
    @NotBlank(message = ValidationMessages.USERNAME_MUST_BE_NOT_BLANK)
    private String firstName; //Employee's first name
    @NotBlank(message = ValidationMessages.EMAIL_MUST_BE_NOT_BLANK)
    private String lastName; //Employee's last name
    //private Team team; //What team the employee belongs to - Senior Management receives double bonus.
    //private PerformanceRating rating;//What the employee's performance review was - Exceptional performance increases the bonus by 50%
    //private EmployeeType type; //Interns get no bonuses.
    //private int yearlySalary; //What the employee's current yearly salary is - 5 year bonuses cannot exceed current yearly salary x6
    //private int employmentTime; //How long (in years) the employee has worked in the company - time defines the percentage of yearly salary for the bonus
    //private List<Integer> yearlyBonuses = new ArrayList<Integer>(); //The list of previous bonuses that are relevant to the bonus calculation.

    // TODO: make all the access to private ?
}
