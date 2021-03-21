package org.example.employee_performance_review_api.domain.model.employee;

import lombok.AllArgsConstructor;
import org.example.employee_performance_review_api.domain.model.user.User;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

import javax.inject.Named;
import java.util.Random;
import java.util.UUID;

@Named
@AllArgsConstructor
public class EmployeeModelBuilder {
    private final ModelValidator modelValidator;

    public Employee build(String firstName, String lastName) {

        return modelValidator.validate(new Employee(UUID.randomUUID(), firstName, lastName));
        // UUID id
        // TODO: Fix this place to validate the user input.
    }

    public Employee build(UUID id, String firstName, String lastName) {

        return modelValidator.validate(new Employee(id, firstName, lastName));
        // UUID id
        // TODO: Fix this place to validate the user input.
    }


}
