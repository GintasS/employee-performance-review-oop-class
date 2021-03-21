package org.example.employee_performance_review_api.application.web.model.request;

import com.fasterxml.jackson.annotation.JsonRootName;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;
import org.example.employee_performance_review_api.domain.model.employee.NewEmployeeInput;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;


@Getter
@Setter
@JsonRootName("employee")
@RegisterForReflection
public class NewEmployeeRequest {
    private String firstName; //Employee's first name
    private String lastName; //Employee's last name
    public Team team; //What team the employee belongs to - Senior Management receives double bonus.
    public EmployeeType type; //Interns get no bonuses.
    public int yearlySalary; //What the employee's current yearly salary is - 5 year bonuses cannot exceed current yearly salary x6
    public int employmentTime; //How long (in years) the employee has worked in the company - time defines the percentage of yearly salary for the bonus

    // TODO make all private


    public NewEmployeeInput toNewEmployeeInput() {
        return new NewEmployeeInput(this.firstName, this.lastName);
    }
}
