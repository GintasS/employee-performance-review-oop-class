package org.example.employee_performance_review_api.infrastructure.configuration;

import org.example.employee_performance_review_api.domain.validator.ModelValidator;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.validation.Validator;

public class ModelValidatorConfiguration {
    @Produces
    @Singleton
    public ModelValidator modelValidator(Validator validator) {
        return new ModelValidator(validator);
    }
}
