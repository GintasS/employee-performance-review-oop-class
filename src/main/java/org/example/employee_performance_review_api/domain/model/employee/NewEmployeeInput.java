package org.example.employee_performance_review_api.domain.model.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.employee_performance_review_api.domain.model.employee.enums.EmployeeType;
import org.example.employee_performance_review_api.domain.model.employee.enums.Team;

@Data
@AllArgsConstructor
public class NewEmployeeInput {
    private String firstName;
    private String lastName;

    // TODO finish all the values
}
