package org.example.employee_performance_review_api.infrastructure.configuration;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.validation.Validator;
import org.example.employee_performance_review_api.domain.validator.ModelValidator;

public class ModelValidatorConfiguration {
  @Produces
  @Singleton
  public ModelValidator modelValidator(Validator validator) {
    return new ModelValidator(validator);
  }
}
