package org.example.employee_performance_review_api.domain.model.employee;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class UpdateEmployeeInput {

    private UUID id;
    private String firstName;
    private String lastName;

    // TODO finish all the values
}
